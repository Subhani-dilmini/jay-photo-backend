package com.subhani.kavishkajaybackend.service;

import com.subhani.kavishkajaybackend.dto.*;
import com.subhani.kavishkajaybackend.entity.*;
import com.subhani.kavishkajaybackend.mapper.PackageMapper;
import com.subhani.kavishkajaybackend.mapper.SessionMapper;
import com.subhani.kavishkajaybackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private final SessionMapper mapper;
    @Autowired
    private final PackageRepo packageRepository;

    @Autowired
    private final PackageItemRepo packageItemRepository;

    @Autowired
    private  final PackagePackageItemRepo packagePackageItemRepository;

    @Autowired
    private final AdditionalItemRepo additionalItemRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SessionRepo sessionRepo;
    @Autowired
    private SessionAdditionalItemRepo sessionAdditionalItemRepo;


    public SessionService(SessionMapper mapper, PackageRepo packageRepository, PackageItemRepo packageItemRepository, PackagePackageItemRepo packagePackageItemRepository, AdditionalItemRepo additionalItemRepository) {
        this.mapper = mapper;
        this.packageRepository = packageRepository;
        this.packageItemRepository = packageItemRepository;
        this.packagePackageItemRepository = packagePackageItemRepository;
        this.additionalItemRepository = additionalItemRepository;
    }


    // ✅ Add Package
    public Session addSession(CreateSessionDTO request) {
        Session newSession = new Session();
        newSession.setAmount(request.getAmount());
        newSession.setSessionStatus(Session.SessionStatus.PENDING);
        newSession.setPaymentStatus(Session.PaymentStatus.PENDING);
        newSession.setPayment(request.getPayment());
        newSession.setDate(request.getDate());
        newSession.setTime(request.getTime());
        User user = userRepo.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        PhotographicPackage existingPackage = packageRepository.findById(request.getPhotographyPackage().getPackageId())
                .orElseThrow(() -> new RuntimeException("Package not found"));
        newSession.setUser(user);
        newSession.setaPackage(existingPackage);
        Session savedSession = sessionRepo.save(newSession);

        for (CreateSessionDTO.AdditionalItemDto additionalItem : request.getAdditionalItems()) {
            Long itemId = additionalItem.getItem().getItemId();
            String itemName = additionalItem.getItem().getName();

            int quantity = additionalItem.getQuantity();

            // Find or create the item by ID or name
            AdditionalItem item = additionalItemRepository.findById(itemId)
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            // Create PackagePackageItem relationship
            SessionAdditionalItem sessionAdditionalItem = new SessionAdditionalItem();
            sessionAdditionalItem.setSession(savedSession);
            sessionAdditionalItem.setItem(item);
            sessionAdditionalItem.setQuantity(quantity);

            sessionAdditionalItemRepo.save(sessionAdditionalItem);
        }

        return savedSession;
    }

    public CountDto getUpcomingCountByUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return mapper.toCountDto(sessionRepo.countBySessionStatusInAndUser(List.of(Session.SessionStatus.PENDING, Session.SessionStatus.CANCELED, Session.SessionStatus.CONFIRMED), user));
    }

    public List<SessionBasicDto> getUpcomingSessionsByUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return mapper.toSessionBasicDTOList(sessionRepo.findBySessionStatusInAndUser(List.of(Session.SessionStatus.PENDING, Session.SessionStatus.CANCELED, Session.SessionStatus.CONFIRMED), user));
    }

    public CountDto getPastCountByUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return mapper.toCountDto(sessionRepo.countBySessionStatusInAndUser(List.of(Session.SessionStatus.COMPLETED), user));
    }

    public List<SessionBasicDto> getPastSessionsByUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return mapper.toSessionBasicDTOList(sessionRepo.findBySessionStatusInAndUser(List.of(Session.SessionStatus.COMPLETED), user));
    }

}

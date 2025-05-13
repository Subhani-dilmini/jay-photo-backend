package com.subhani.kavishkajaybackend.repo;

import com.subhani.kavishkajaybackend.entity.PhotographicPackage;
import com.subhani.kavishkajaybackend.entity.Session;
import com.subhani.kavishkajaybackend.entity.User;
import com.subhani.kavishkajaybackend.enumeration.MeetingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface SessionRepo extends JpaRepository<Session, Long> {

    long countBySessionStatusInAndUser(List<Session.SessionStatus> sessionStatus, User user);
    List<Session> findBySessionStatusInAndUser(List<Session.SessionStatus> sessionStatus, User user);
}

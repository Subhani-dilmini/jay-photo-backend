package com.subhani.kavishkajaybackend.dto;

public class CountDto {
    private Long count;

    public CountDto() {
    }

    public CountDto(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CountDto{" +
                "count=" + count +
                '}';
    }
}

package com.sample.test.demo.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactInfo {

    private String name;
    private String phone;
    private String email;

    public static ContactInfo defaultModel() {
        return ContactInfo.builder()
                .name("John Wick")
                .email("wick@mail.com")
                .phone("+38066777888")
                .build();
    }

}

package io.userMicroservice.entity.dto;

import lombok.Data;

public record UserDTO(User user) {

    @Data
    public static class User {
        private String name;
        private String email;
        private String last_name;
        private String address;
        private String password;
    }
}

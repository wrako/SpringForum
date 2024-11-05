    package com.forum.userservice.request;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class AuthRequest {

        private String username;
        private String password;

    }
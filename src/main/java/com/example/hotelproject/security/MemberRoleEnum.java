package com.example.hotelproject.security;

public enum MemberRoleEnum {
    USER(Authority.USER),  // 회원 권한
    ADMIN(Authority.ADMIN),  // 관리자 권한
    OWNER(Authority.OWNER); // 오너 권한

    private final String authority;

    MemberRoleEnum(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {

        public static final String USER = "ROLE_USER";
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String OWNER = "ROLE_OWNER";
    }
}

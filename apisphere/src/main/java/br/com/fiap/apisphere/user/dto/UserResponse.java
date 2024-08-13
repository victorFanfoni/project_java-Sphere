package br.com.fiap.apisphere.user.dto;

import br.com.fiap.apisphere.user.User;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String name,
        String bio,
        String email,
        LocalDateTime createAt,
        LocalDateTime updateAt
) {
    public static UserResponse feromModel(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getBio(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }


}

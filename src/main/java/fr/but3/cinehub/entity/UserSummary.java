package fr.but3.cinehub.entity;

import lombok.Data;

@Data
public class UserSummary {
    private Long id;
    private String username;
    private String profilePicture;
    private String language;
}

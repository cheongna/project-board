package com.fastcampus.projectboard.dto;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.fastcampus.projectboard.domain.Article}
 */
public record ArticleDto(
        LocalDateTime createAt,
        String createdBy,
        String title,
        String content,
        String hashtag
) {
    public static ArticleDto of(LocalDateTime createAt, String createdBy, String title, String content, String hashtag) {
        return new ArticleDto(createAt, createdBy, title, content, hashtag);
    }
}
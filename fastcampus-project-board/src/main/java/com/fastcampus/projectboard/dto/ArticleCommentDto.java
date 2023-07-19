package com.fastcampus.projectboard.dto;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.fastcampus.projectboard.domain.ArticleComment}
 */
public record ArticleCommentDto(
        LocalDateTime createAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        String content,
        String hashtag
) {
    public static ArticleCommentDto of(LocalDateTime createAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy, String content, String hashtag) {
        return new ArticleCommentDto(createAt, createdBy, modifiedAt, modifiedBy, content, hashtag);
    }
}
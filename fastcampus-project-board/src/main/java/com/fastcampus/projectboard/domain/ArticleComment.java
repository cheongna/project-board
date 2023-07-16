package com.fastcampus.projectboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createAt"),
        @Index(columnList = "createBy")
})
@Entity
@NoArgsConstructor
public class ArticleComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false)
    private Article article; //제목

    @Setter
    @Column(nullable = false, length = 500)
    private String content; //본문
    private String hashtag; //해시태그

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createAt; //생성일시

    @CreatedBy
    @Column(nullable = false, length = 100)
    private String createBy; //생성자

    @LastModifiedBy
    @Column(nullable = false)
    private LocalDateTime modifiedAt; //수정일시

    @LastModifiedDate
    @Column(nullable = false, length = 100)
    private String modifiedBy; //수정자

    public ArticleComment(Article article, String content){
        this.article = article;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment that)) return false;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static ArticleComment of(Article article, String content){
        return new ArticleComment(article, content);
    }
}

package com.ikeguang.vue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author: keguang
 * @Date: 2021/1/27 16:51
 * @version: v1.0.0
 * @description:
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Table(name = "articles")
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull(message = "id不能为 null")
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contentHtml;

    @Column(nullable = false)
    private String contentMd;

    /**
     * article release date
     */
    @Column(nullable = false)
    private Date date;

}

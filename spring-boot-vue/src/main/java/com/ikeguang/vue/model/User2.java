package com.ikeguang.vue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ Author: keguang
 * @ Date: 2019/6/24 20:18
 * @ version: v1.0.0
 * @ description:
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User2 implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String passWord;


}

package com.ikeguang.datasourcejpa.model.s;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ Author: keguang
 * @ Date: 2019/12/17 15:09
 * @ version: v1.0.0
 * @ description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class SecondaryEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;
}

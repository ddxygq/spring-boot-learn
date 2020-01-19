package com.ikeguang.ajax.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: keguang
 * @Date: 2019/12/16 17:48
 * @version: v1.0.0
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SelectDate implements Serializable{

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
}

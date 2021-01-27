package com.ikeguang.vue.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: keguang
 * @Date: 2021/1/26 14:54
 * @version: v1.0.0
 * @description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {

    private int code;
    private String msg;
    private Object result;
}

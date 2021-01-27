package com.ikeguang.vue.utils;

import com.ikeguang.vue.result.Result;
import com.ikeguang.vue.result.ResultCode;

import java.util.List;

/**
 * @Author: keguang
 * @Date: 2021/1/26 14:57
 * @version: v1.0.0
 * @description:
 */
public class ResultConfigFactory {

    public static Result builtResult(List list){
        return new Result(ResultCode.SUCCESS.code, "成功", list);
    }
}

package com.progzc.ke.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 自定义错误枚举
 * @Author zhaochao
 * @Date 2021/3/17 18:15
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Getter
@AllArgsConstructor
public enum ErrorEnum {
    // 请求错误
    PATH_NOT_FOUND(404, "路径不存在，请检查路径"),
    // 系统错误
    UNKNOWN(500, "系统内部错误，请联系管理员");

    private int code;
    private String msg;
}

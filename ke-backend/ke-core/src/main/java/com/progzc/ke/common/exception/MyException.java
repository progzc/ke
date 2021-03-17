package com.progzc.ke.common.exception;

import com.progzc.ke.common.enums.ErrorEnum;
import lombok.Data;

/**
 * @Description 自定义异常类
 * @Author zhaochao
 * @Date 2021/3/17 18:07
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@Data
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 7391473533100241371L;

    private String msg;
    private int code = 500;

    public MyException() {
        super(ErrorEnum.UNKNOWN.getMsg());
        this.msg = ErrorEnum.UNKNOWN.getMsg();
    }

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MyException(ErrorEnum errorEnum) {
        super(errorEnum.getMsg());
        this.msg = errorEnum.getMsg();
        this.code = errorEnum.getCode();
    }

    public MyException(ErrorEnum errorEnum, Throwable e) {
        super(errorEnum.getMsg(), e);
        this.msg = errorEnum.getMsg();
        this.code = errorEnum.getCode();
    }

}

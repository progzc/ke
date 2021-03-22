package com.progzc.ke.common.exception;

import com.progzc.ke.common.Result;
import com.progzc.ke.common.enums.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @Description 异常处理类
 * @Author zhaochao
 * @Date 2021/3/17 18:06
 * @Email zcprog@foxmail.com
 * @Version V1.0
 */
@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {
    
    /**
     * 处理自定义异常：包含校验异常、认证异常
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public Result handleMyException(MyException e) {
        Result result = new Result();
        result.put("code", e.getCode());
        result.put("msg", e.getMsg());
        return result;
    }

    /**
     * 处理路径找不到的异常
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result hanlerNoFoundException(NoHandlerFoundException e) {
        log.error(e.getMessage(), e);
        return Result.exception(ErrorEnum.PATH_NOT_FOUND);
    }

    /**
     * 处理DAO异常
     * @param e
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return Result.exception(ErrorEnum.DUPLICATE_KEY);
    }

    /**
     * 处理Exception异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.exception();
    }
}

package sinosoft.config;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 王江超
 * @Date 2020/3/9 10:40
 * @Description:
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = AuthenticationException.class)
    public String error(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) {
        return "未登录";
    }


    @ExceptionHandler(value = AuthorizationException.class)
    public String error(HttpServletRequest request, HttpServletResponse response, AuthorizationException ex) {
        return "未授权";
    }


}

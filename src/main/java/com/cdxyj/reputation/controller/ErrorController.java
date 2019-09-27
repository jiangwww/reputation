package com.cdxyj.reputation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author jiangwei
 * @Description
 * @Date 2019/9/27
 **/
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    private static final String ERROR_PATH = "/error";
    @RequestMapping(ERROR_PATH)
    public String error() {
        return "error";
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}

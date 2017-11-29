package com.simple.demo.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.simple.common.base.BaseController;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/9/28
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = {"/", "index"})
    @ResponseBody
    public String hello() {
        return "Hello demo war !!";
    }


    @RequestMapping("/exception")
    @ResponseBody
    public int zeroException() throws SQLException {
        throw new SQLException();
    }

}

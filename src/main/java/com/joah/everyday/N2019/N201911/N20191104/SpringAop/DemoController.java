package com.joah.everyday.N2019.N201911.N20191104.SpringAop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/aop/http/alive")
    public String alive() {
        return "服务一切正常";
    }

    @AuthChecker
    @RequestMapping("/aop/http/user_info")
    public String callSomeInterface() {
        return "调用了 user_info 接口.";
    }
}
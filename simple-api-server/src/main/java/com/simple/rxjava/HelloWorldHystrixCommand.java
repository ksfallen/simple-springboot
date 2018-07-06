package com.simple.rxjava;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author: Jfeng
 * @date: 2018/2/7
 */
public class HelloWorldHystrixCommand extends HystrixCommand {
    private final String name;

    public HelloWorldHystrixCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected Object run() throws Exception {
        return "Hello " + name;
    }

    public static void main(String[] args) {
        String result = (String) new HelloWorldHystrixCommand("HLX").execute();
        System.out.println(result);  // 打印出Hello HLX
    }
}

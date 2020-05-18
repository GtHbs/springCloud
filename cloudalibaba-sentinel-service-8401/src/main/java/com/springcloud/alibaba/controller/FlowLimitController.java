package com.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流量控制检测器
 *
 * @author: 李昭
 * @Date: 2020/5/16 22:06
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "-------testA-------";
    }

    @GetMapping("/testB")
    public String testB() {
        System.out.println(Thread.currentThread().getName()+"\t");
        return "=======testB========";
    }

    @GetMapping("/testD")
    public String testD() {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//            System.out.println("测试平均响应时间");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.print("测试异常比例");
        int a = 10 / 0;
        return "=======testD=========";
    }

    @GetMapping("testE")
    public String testE() {
        System.out.print("测试异常数");
        int a = 10 / 0;
        return "=======testE========";
    }

    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey",blockHandler = "deal_hotKey")
    public String hotKey(@RequestParam(value = "p1",required = false)String p1,
                         @RequestParam(value = "p2",required = false)String p2) {
        int a = 10 / 0;
        return "-----hotkey-------";
    }

    //熔断方法
    public String deal_hotKey(String p1, String p2, BlockException blockException) {

        return "------deal_block_exception---";
    }

}

package com.springcloud.entities.resultenum;

import lombok.Getter;

/**
 * @author: 李昭
 * @Date: 2020/4/2 15:54
 */
@Getter
public enum Result {
    /**
     * 返回给前端状态信息
     */
    SUCCESS(200, "成功"),
    FAIL(444, "失败");
    private Integer code;
    private String message;

    Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

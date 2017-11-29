package com.simple.constants.eums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum UserInfoState {
    _0("0", "创建未认证"),
    _1("1", "正常状态"),
    _2("2", "用户被锁定");

    private String key;

    private String name;

    UserInfoState(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getNameByKey(String key) {
        String result = "";
        for (UserInfoState temp: UserInfoState.values()) {
            if (StringUtils.equals(name, temp.name)) {
                result = temp.getName();
                break;
            }
        }
        return result;
    }
}

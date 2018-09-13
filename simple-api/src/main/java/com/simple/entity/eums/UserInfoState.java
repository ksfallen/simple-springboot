package com.simple.entity.eums;

import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserInfoState {
    _0("0", "创建未认证"),
    _1("1", "正常状态"),
    _2("2", "用户被锁定");

    private String key;

    private String value;

    public static UserInfoState getByKey(String key) {
        Optional<UserInfoState> op = Arrays.stream(UserInfoState.values()).filter(e -> e.key.equals(key)).findFirst();
        return op.orElse(null);
    }
}

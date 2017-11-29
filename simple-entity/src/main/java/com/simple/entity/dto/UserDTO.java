package com.simple.entity.dto;

import com.simple.common.base.bean.BaseBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/24
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseBean{
    private static final long serialVersionUID = 689952543254535946L;

    private Integer age;

    private String name;
}

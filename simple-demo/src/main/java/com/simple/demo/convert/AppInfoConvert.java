package com.simple.demo.convert;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import com.simple.demo.model.AppInfo;
import com.simple.entity.dto.AppInfoDTO;

import fr.xebia.extras.selma.*;

/**
 * @author: Jianfeng.Hu
 * @date: 2017/10/30
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface AppInfoConvert {

    @Maps(withCustomFields = {@Field(value = "ownerId", withCustom = AppInfoConvert.OwnerIdMapper.class)})
    AppInfoDTO asDto(AppInfo in);

    // @Maps(withCustomFields = {@Field(value = "ownerId", withCustom = AppInfoConvert.OwnerIdMapper.class)})
    @InheritMaps(method = "asDto")
    AppInfo asModel(AppInfoDTO in);

    AppInfo duplicate(AppInfo source);


    @Service
    class OwnerIdMapper {

        public String toInt(Integer ownerId) {
            return ownerId != null ? ownerId.toString() : null;
        }

        public Integer incrementAge(String ownerId) {
            return ownerId != null ? NumberUtils.toInt(ownerId) : null;
        }
    }


}


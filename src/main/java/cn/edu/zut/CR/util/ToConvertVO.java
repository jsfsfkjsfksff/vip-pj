package cn.edu.zut.CR.util;

import cn.edu.zut.CR.VO.VIPC;
import cn.edu.zut.CR.car.entity.Car;
import org.mapstruct.Mapper;
@Mapper
public interface ToConvertVO {
        ToConvertVO INSTANCE = org.mapstruct.factory.Mappers.getMapper(ToConvertVO.class);
        VIPC convert(Car user);
}

package cn.iocoder.yudao.module.gpt.convert.application;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.gpt.controller.admin.application.vo.*;
import cn.iocoder.yudao.module.gpt.dal.dataobject.application.ApplicationDO;

/**
 * gpt应用 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ApplicationConvert {

    ApplicationConvert INSTANCE = Mappers.getMapper(ApplicationConvert.class);

    ApplicationDO convert(ApplicationCreateReqVO bean);

    ApplicationDO convert(ApplicationUpdateReqVO bean);

    ApplicationRespVO convert(ApplicationDO bean);

    List<ApplicationRespVO> convertList(List<ApplicationDO> list);

    PageResult<ApplicationRespVO> convertPage(PageResult<ApplicationDO> page);

    List<ApplicationExcelVO> convertList02(List<ApplicationDO> list);

}

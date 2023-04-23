package cn.iocoder.yudao.module.gpt.dal.mysql.application;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.gpt.dal.dataobject.application.ApplicationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.gpt.controller.admin.application.vo.*;

/**
 * gpt应用 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ApplicationMapper extends BaseMapperX<ApplicationDO> {

    default PageResult<ApplicationDO> selectPage(ApplicationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ApplicationDO>()
                .eqIfPresent(ApplicationDO::getIcon, reqVO.getIcon())
                .eqIfPresent(ApplicationDO::getDesc, reqVO.getDesc())
                .eqIfPresent(ApplicationDO::getDirection, reqVO.getDirection())
                .eqIfPresent(ApplicationDO::getText, reqVO.getText())
                .eqIfPresent(ApplicationDO::getGroupId, reqVO.getGroupId())
                .betweenIfPresent(ApplicationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ApplicationDO::getScore, reqVO.getScore())
                .eqIfPresent(ApplicationDO::getStatus, reqVO.getStatus())
                .orderByDesc(ApplicationDO::getId));
    }

    default List<ApplicationDO> selectList(ApplicationExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ApplicationDO>()
                .eqIfPresent(ApplicationDO::getIcon, reqVO.getIcon())
                .eqIfPresent(ApplicationDO::getDesc, reqVO.getDesc())
                .eqIfPresent(ApplicationDO::getDirection, reqVO.getDirection())
                .eqIfPresent(ApplicationDO::getText, reqVO.getText())
                .eqIfPresent(ApplicationDO::getGroupId, reqVO.getGroupId())
                .betweenIfPresent(ApplicationDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ApplicationDO::getScore, reqVO.getScore())
                .eqIfPresent(ApplicationDO::getStatus, reqVO.getStatus())
                .orderByDesc(ApplicationDO::getId));
    }

}

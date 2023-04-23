package cn.iocoder.yudao.module.gpt.service.application;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.gpt.controller.admin.application.vo.*;
import cn.iocoder.yudao.module.gpt.dal.dataobject.application.ApplicationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.gpt.convert.application.ApplicationConvert;
import cn.iocoder.yudao.module.gpt.dal.mysql.application.ApplicationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gpt.enums.ErrorCodeConstants.*;

/**
 * gpt应用 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ApplicationServiceImpl implements ApplicationService {

    @Resource
    private ApplicationMapper applicationMapper;

    @Override
    public Long createApplication(ApplicationCreateReqVO createReqVO) {
        // 插入
        ApplicationDO application = ApplicationConvert.INSTANCE.convert(createReqVO);
        applicationMapper.insert(application);
        // 返回
        return application.getId();
    }

    @Override
    public void updateApplication(ApplicationUpdateReqVO updateReqVO) {
        // 校验存在
        validateApplicationExists(updateReqVO.getId());
        // 更新
        ApplicationDO updateObj = ApplicationConvert.INSTANCE.convert(updateReqVO);
        applicationMapper.updateById(updateObj);
    }

    @Override
    public void deleteApplication(Long id) {
        // 校验存在
        validateApplicationExists(id);
        // 删除
        applicationMapper.deleteById(id);
    }

    private void validateApplicationExists(Long id) {
        if (applicationMapper.selectById(id) == null) {
            throw exception(APPLICATION_NOT_EXISTS);
        }
    }

    @Override
    public ApplicationDO getApplication(Long id) {
        return applicationMapper.selectById(id);
    }

    @Override
    public List<ApplicationDO> getApplicationList(Collection<Long> ids) {
        return applicationMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ApplicationDO> getApplicationPage(ApplicationPageReqVO pageReqVO) {
        return applicationMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ApplicationDO> getApplicationList(ApplicationExportReqVO exportReqVO) {
        return applicationMapper.selectList(exportReqVO);
    }

}

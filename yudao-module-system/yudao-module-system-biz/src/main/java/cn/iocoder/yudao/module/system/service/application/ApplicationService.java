package cn.iocoder.yudao.module.gpt.service.application;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.gpt.controller.admin.application.vo.*;
import cn.iocoder.yudao.module.gpt.dal.dataobject.application.ApplicationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * gpt应用 Service 接口
 *
 * @author 芋道源码
 */
public interface ApplicationService {

    /**
     * 创建gpt应用
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createApplication(@Valid ApplicationCreateReqVO createReqVO);

    /**
     * 更新gpt应用
     *
     * @param updateReqVO 更新信息
     */
    void updateApplication(@Valid ApplicationUpdateReqVO updateReqVO);

    /**
     * 删除gpt应用
     *
     * @param id 编号
     */
    void deleteApplication(Long id);

    /**
     * 获得gpt应用
     *
     * @param id 编号
     * @return gpt应用
     */
    ApplicationDO getApplication(Long id);

    /**
     * 获得gpt应用列表
     *
     * @param ids 编号
     * @return gpt应用列表
     */
    List<ApplicationDO> getApplicationList(Collection<Long> ids);

    /**
     * 获得gpt应用分页
     *
     * @param pageReqVO 分页查询
     * @return gpt应用分页
     */
    PageResult<ApplicationDO> getApplicationPage(ApplicationPageReqVO pageReqVO);

    /**
     * 获得gpt应用列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return gpt应用列表
     */
    List<ApplicationDO> getApplicationList(ApplicationExportReqVO exportReqVO);

}

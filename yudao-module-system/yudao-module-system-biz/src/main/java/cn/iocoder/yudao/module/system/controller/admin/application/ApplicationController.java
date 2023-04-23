package cn.iocoder.yudao.module.system.controller.application;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;

import cn.iocoder.yudao.module.system.controller.application.vo.*;
import cn.iocoder.yudao.module.system.convert.application.ApplicationConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.application.ApplicationDO;
import cn.iocoder.yudao.module.system.service.application.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Tag(name = "管理后台 - gpt应用")
@RestController
@RequestMapping("/gpt/application")
@Validated
public class ApplicationController {

    @Resource
    private ApplicationService applicationService;

    @PostMapping("/create")
    @Operation(summary = "创建gpt应用")
    @PreAuthorize("@ss.hasPermission('gpt:application:create')")
    public CommonResult<Long> createApplication(@Valid @RequestBody ApplicationCreateReqVO createReqVO) {
        return success(applicationService.createApplication(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新gpt应用")
    @PreAuthorize("@ss.hasPermission('gpt:application:update')")
    public CommonResult<Boolean> updateApplication(@Valid @RequestBody ApplicationUpdateReqVO updateReqVO) {
        applicationService.updateApplication(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除gpt应用")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gpt:application:delete')")
    public CommonResult<Boolean> deleteApplication(@RequestParam("id") Long id) {
        applicationService.deleteApplication(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得gpt应用")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gpt:application:query')")
    public CommonResult<ApplicationRespVO> getApplication(@RequestParam("id") Long id) {
        ApplicationDO application = applicationService.getApplication(id);
        return success(ApplicationConvert.INSTANCE.convert(application));
    }

    @GetMapping("/list")
    @Operation(summary = "获得gpt应用列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('gpt:application:query')")
    public CommonResult<List<ApplicationRespVO>> getApplicationList(@RequestParam("ids") Collection<Long> ids) {
        List<ApplicationDO> list = applicationService.getApplicationList(ids);
        return success(ApplicationConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得gpt应用分页")
    @PreAuthorize("@ss.hasPermission('gpt:application:query')")
    public CommonResult<PageResult<ApplicationRespVO>> getApplicationPage(@Valid ApplicationPageReqVO pageVO) {
        PageResult<ApplicationDO> pageResult = applicationService.getApplicationPage(pageVO);
        return success(ApplicationConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出gpt应用 Excel")
    @PreAuthorize("@ss.hasPermission('gpt:application:export')")
    @OperateLog(type = EXPORT)
    public void exportApplicationExcel(@Valid ApplicationExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ApplicationDO> list = applicationService.getApplicationList(exportReqVO);
        // 导出 Excel
        List<ApplicationExcelVO> datas = ApplicationConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "gpt应用.xls", "数据", ApplicationExcelVO.class, datas);
    }

}

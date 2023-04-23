package cn.iocoder.yudao.module.system.controller.application.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - gpt应用更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApplicationUpdateReqVO extends ApplicationBaseVO {

    @Schema(description = "应用id", required = true, example = "7549")
    @NotNull(message = "应用id不能为空")
    private Long applicationId;

}

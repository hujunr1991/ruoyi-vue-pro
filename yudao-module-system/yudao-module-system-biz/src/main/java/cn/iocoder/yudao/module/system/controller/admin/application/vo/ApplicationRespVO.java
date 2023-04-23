package cn.iocoder.yudao.module.system.controller.application.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - gpt应用 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApplicationRespVO extends ApplicationBaseVO {

    @Schema(description = "应用id", required = true, example = "7549")
    private Long applicationId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}

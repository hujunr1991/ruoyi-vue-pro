package cn.iocoder.yudao.module.system.controller.application.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - gpt应用 Excel 导出 Request VO，参数和 ApplicationPageReqVO 是一致的")
@Data
public class ApplicationExportReqVO {

    @Schema(description = "图标")
    private String icon;

    @Schema(description = "描述")
    private String desc;

    @Schema(description = "应用指令")
    private String direction;

    @Schema(description = "输入")
    private String text;

    @Schema(description = "所属分组", example = "22402")
    private String groupId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "评分")
    private String score;

    @Schema(description = "是否删除：0：有效，-1：失效", example = "2")
    private Byte status;

}

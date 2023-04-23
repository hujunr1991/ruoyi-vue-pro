package cn.iocoder.yudao.module.system.controller.application.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* gpt应用 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ApplicationBaseVO {

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

    @Schema(description = "评分")
    private String score;

    @Schema(description = "是否删除：0：有效，-1：失效", example = "2")
    private Integer status;

}

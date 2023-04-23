package cn.iocoder.yudao.module.system.controller.admin.openAi.entity.req;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OpenRequest {

    @Schema(description = "输入的文本", required = true, example = "讲一个笑话")
    private String text;

}

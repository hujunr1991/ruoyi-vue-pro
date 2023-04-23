package cn.iocoder.yudao.module.system.controller.admin.openAi.entity.completions;


import cn.iocoder.yudao.module.system.controller.admin.openAi.entity.common.Choice;
import cn.iocoder.yudao.module.system.controller.admin.openAi.entity.common.OpenAiResponse;
import cn.iocoder.yudao.module.system.controller.admin.openAi.entity.common.Usage;
import lombok.Data;
/**
 * 描述： 答案类
 *
 * @author https:www.unfbx.com
 * @date 2023-02-11
 */
@Data
public class CompletionResponse extends OpenAiResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private Choice[] choices;
    private Usage usage;
}

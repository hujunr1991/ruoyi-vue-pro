package cn.iocoder.yudao.module.system.controller.application.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * gpt应用 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ApplicationExcelVO {

    @ExcelProperty("应用id")
    private Long applicationId;

    @ExcelProperty("图标")
    private String icon;

    @ExcelProperty("描述")
    private String desc;

    @ExcelProperty("应用指令")
    private String direction;

    @ExcelProperty("输入")
    private String text;

    @ExcelProperty("所属分组")
    private String groupId;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("评分")
    private String score;

    @ExcelProperty("是否删除：0：有效，-1：失效")
    private Byte status;

}

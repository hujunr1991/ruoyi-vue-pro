package cn.iocoder.yudao.module.gpt.dal.dataobject.application;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * gpt应用 DO
 *
 * @author 芋道源码
 */
@TableName("gpt_application")
@KeySequence("gpt_application_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDO extends BaseDO {

    /**
     * 应用id
     */
    @TableId
    private Long applicationId;
    /**
     * 图标
     */
    private String icon;
    /**
     * 描述
     */
    private String desc;
    /**
     * 应用指令
     */
    private String direction;
    /**
     * 输入
     */
    private String text;
    /**
     * 所属分组
     */
    private String groupId;
    /**
     * 评分
     */
    private String score;
    /**
     * 是否删除：0：有效，-1：失效
     */
    private Byte status;

}

package com.wuxin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * desc ：字典VO
 * author ：lizj
 * date ：2020-06-18 10:51
 * </pre>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysDictVO {

    /**
     * 值
     */
    private String code;

    /**
     * 名称
     */
    private String text;
}

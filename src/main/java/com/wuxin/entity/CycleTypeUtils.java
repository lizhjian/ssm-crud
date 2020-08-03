package com.wuxin.entity;


import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * desc ：周期类
 * author ：lizj
 * date ：2020-06-18 10:56
 * </pre>
 */
public class CycleTypeUtils {

    public static List<SysDictVO> standardCycles= Arrays.asList(
            new SysDictVO(CycleTypeEnums.TODAY.getCode(), CycleTypeEnums.TODAY.getName()),
            new SysDictVO(CycleTypeEnums.THIS_WEEK.getCode(), CycleTypeEnums.THIS_WEEK.getName()),
            new SysDictVO(CycleTypeEnums.THIS_MONTH.getCode(), CycleTypeEnums.THIS_MONTH.getName()),
            new SysDictVO(CycleTypeEnums.YESTERDAY.getCode(), CycleTypeEnums.YESTERDAY.getName()),
            new SysDictVO(CycleTypeEnums.LAST_WEEK.getCode(), CycleTypeEnums.LAST_WEEK.getName()),
            new SysDictVO(CycleTypeEnums.LAST_MONTH.getCode(), CycleTypeEnums.LAST_MONTH.getName())
    );

    public static List<SysDictVO> recentlyCycles=Arrays.asList(
            new SysDictVO(CycleTypeEnums.RECENTLY_THIRTY_DAY.getCode(), CycleTypeEnums.RECENTLY_THIRTY_DAY.getName()),
            new SysDictVO(CycleTypeEnums.RECENTLY_FIFTEEN_DAY.getCode(), CycleTypeEnums.RECENTLY_FIFTEEN_DAY.getName()),
            new SysDictVO(CycleTypeEnums.RECENTLY_SEVEN_DAY.getCode(), CycleTypeEnums.RECENTLY_SEVEN_DAY.getName())
    );
}

package com.wuxin.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * desc ：时间周期
 * author ：lizj
 * date ：2020-06-18 10:22
 * </pre>
 */
public enum CycleTypeEnums {
    TODAY("today", "今日"),
    THIS_WEEK("this_week", "本周"),
    THIS_MONTH("this_month", "本月"),
    YESTERDAY("yesterday", "昨日"),
    LAST_WEEK("last_week", "上周"),
    LAST_MONTH("last_month", "上月"),

    RECENTLY_THIRTY_DAY("recently_thirty_day", "近30日"),
    RECENTLY_FIFTEEN_DAY("recently_fifteen_day", "近15日"),
    RECENTLY_SEVEN_DAY("recently_seven_day", "近7日");


    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    CycleTypeEnums(String index, String name) {
        this.code = index;
        this.name = name;
    }

    public static List<SysDict>  standardCycle = new ArrayList<SysDict>();
    public static List<SysDict>  recentlyCycle = new ArrayList<SysDict>();

    static {
        standardCycle.add(new SysDict(TODAY.getCode(), TODAY.getName()));
        standardCycle.add(new SysDict(THIS_MONTH.getCode(), THIS_MONTH.getName()));
        standardCycle.add(new SysDict(YESTERDAY.getCode(), YESTERDAY.getName()));
//        standardCycle.add(new SysDict()LAST_WEEK);
//        recentlyCycle.add(new SysDict()RECENTLY_THIRTY_DAY);
//        recentlyCycle.add(new SysDict()RECENTLY_THIRTY_DAY);
//        recentlyCycle.add(new SysDict()RECENTLY_THIRTY_DAY);

    }
}

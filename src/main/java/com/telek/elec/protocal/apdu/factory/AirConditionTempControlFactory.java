package com.telek.elec.protocal.apdu.factory;

import com.telek.elec.protocal.data.model.OAD;
import com.telek.elec.protocal.data.model.OI;
import com.telek.elec.protocal.data.model.OMD;

/**
 * 空调时段温控oad/omd工厂类
 */
public class AirConditionTempControlFactory {

    public static final OI OI = new OI(0x8122, false);

    /**
     * 参数配置
     * =array 空调时段温控参数
     * 空调时段温控参数=structure
     * {
     *   温度阈值（同4311属性5）
     *   自动控制时段::=structure
     * {
     *    起始小时 unsigned，
     *    起始分钟 unsigned，
     *    结束小时 unsigned，
     *    结束分钟 unsigned
     * }
     * }
     * 属性2
     * @return enum{关闭（0），打开（1）
     */
    public static OAD params() {
        return new OAD(OI, 2, 0, false);
    }

    /**
     * 开始空调时段温控
     * 方法127
     * @return null
     */
    public static OMD on() {
        return new OMD(OI, 127, 0, false);
    }

    /**
     * 停止空调时段温控
     * 方法128
     * @return null
     */
    public static OMD off() {
        return new OMD(OI, 128, 0, false);
    }

}

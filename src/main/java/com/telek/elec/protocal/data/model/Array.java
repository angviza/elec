package com.telek.elec.protocal.data.model;

import java.util.List;

import com.telek.elec.protocal.constant.DataType;

import lombok.Data;

/**
 * 数组
 *  * 03 —— 数组元素个数=3
 *  12 09 6D —— 元素1：类型18：long-unsigned 241.3V A相
 *  12 09 6D —— 元素2：类型18：long-unsigned 241.3V B相
 *  12 09 6D —— 元素3：类型18：long-unsigned 241.3V C相
 */
@Data
public class Array extends AbsArraysData {

    public Array() {
        this.dataType = DataType.ARRAY;
    }

    public Array(boolean isEncodeDataType) {
        this();
        this.isEncodeDataType = isEncodeDataType;
    }

    public Array(List<AbsData> data, boolean isEncodeDataType) {
        this(isEncodeDataType);
        if (data == null) {
            this.size = 0;
        } else {
            this.datas = data;
        }
    }
}
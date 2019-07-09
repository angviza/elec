package com.telek.elec.protocal.service.request.apdufactory;

import java.util.concurrent.atomic.AtomicInteger;

import com.telek.elec.protocal.apdu.CodecAPDU;
import com.telek.elec.protocal.apdu.action.request.ActionRequestNormal;
import com.telek.elec.protocal.apdu.factory.DocumentFactory;
import com.telek.elec.protocal.apdu.model.ActionRequestData;
import com.telek.elec.protocal.data.Datas;
import com.telek.elec.protocal.data.model.Array;
import com.telek.elec.protocal.data.model.Enums;
import com.telek.elec.protocal.data.model.Structure;
import com.telek.elec.protocal.data.model.number.LongUnsigned;
import com.telek.elec.protocal.data.model.number.Unsigned;

/**
 * 档案
 */
public class Document {
    public static volatile AtomicInteger index_num = new AtomicInteger(0);

    /**
     * @Description: 添加一个采集档案配置单元
     * @auther: wll
     * @date: 20:38 2019/7/8
     * @param: []
     * @return: com.telek.elec.protocal.apdu.CodecAPDU
     */
    public static CodecAPDU addDocument() {
        Structure document = new Structure();
        document.addData(new LongUnsigned(index_num.incrementAndGet()));
        Structure basicObject = new Structure();
//        basicObject.addData(new )
        basicObject.addData(new Enums((short) 0));
        basicObject.addData(new Enums((short) 1));
//        basicObject.addData(new OAD(4));
//        basicObject.addData(new OctetString());
        basicObject.addData(new Unsigned((short) 4));
        basicObject.addData(new Unsigned((short) 1));
        basicObject.addData(new Enums((short) 1));
        basicObject.addData(new LongUnsigned(220));
        basicObject.addData(new LongUnsigned(5));
        document.addData(basicObject);
        Structure extendedObject = new Structure();
//        extendedObject.addData();
//        extendedObject.addData(new OctetString());
        extendedObject.addData(new LongUnsigned(1));
        extendedObject.addData(new LongUnsigned(2));
        document.addData(extendedObject);
        Array annexObject = new Array();
        document.addData(annexObject);
        ActionRequestNormal actionRequest = new ActionRequestNormal();
        actionRequest.setActionRequestData(new ActionRequestData(DocumentFactory.addDocument(), new Datas<>(document)));
        actionRequest.setTimeStamp(0);
        return null;
    }
}

package com.xiayule.action;

import com.opensymphony.xwork2.Action;
import com.xiayule.qrcode.QRCodeMaker;
import com.xiayule.utils.InfoUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by tan on 14-6-28.
 */
public class QRCodeAction implements Action{
    private InputStream qrcodeInputStream;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InputStream getQrcodeInputStream() {
        return qrcodeInputStream;
    }

    public void setQrcodeInputStream(InputStream qrcodeInputStream) {
        this.qrcodeInputStream = qrcodeInputStream;
    }

    @Override
    public String execute() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        QRCodeMaker.writeQRCodeToImage(InfoUtil.getWebUrl() + "/display.action?id="+id,
                QRCodeMaker.TYPE_PNG,
                byteArrayOutputStream,
                200,
                200);


        qrcodeInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        return SUCCESS;
    }
}

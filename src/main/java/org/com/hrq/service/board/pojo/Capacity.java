package org.com.hrq.service.board.pojo;

import java.io.Serializable;

public class Capacity implements Serializable {
    private static final long serialVersionUID = -8160570779181439994L;

    public Capacity(String deviceNo, String deviceName, int amount) {
        this.deviceNo = deviceNo;
        this.deviceName = deviceName;
        this.amount = amount;
    }

    /**
     * 设备编码
     */
    private String deviceNo;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 产能
     */
    private int amount;
}

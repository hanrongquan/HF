package org.com.hrq.service.board.pojo;

public class DeviceStatus {
    public DeviceStatus(String deviceName, int status, boolean alarmState, float waterCementRatio, String alarmCode, int hourCapacity, int totalCapacity, int materialBatlevel) {
        this.deviceName = deviceName;
        this.status = status;
        this.alarmState = alarmState;
        this.waterCementRatio = waterCementRatio;
        this.alarmCode = alarmCode;
        this.hourCapacity = hourCapacity;
        this.totalCapacity = totalCapacity;
        this.materialBatlevel = materialBatlevel;
    }

    private String deviceName;//设备名称
    private int status;//运行状态
    private boolean alarmState;//报警状态
    private float waterCementRatio;//水灰比
    private String alarmCode;//报警代码
    private int hourCapacity;//每小时产能
    private int totalCapacity;//总产能
    private int materialBatlevel;//物料剩余值
}

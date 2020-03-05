package org.com.bzl.service.board;

import org.com.bzl.service.board.pojo.Capacity;
import org.com.bzl.service.board.pojo.DeviceHour;
import org.com.bzl.service.board.pojo.DeviceStatus;
import org.com.bzl.service.board.pojo.OnlineVideo;

import java.util.List;

public interface IBoardService {
    /**
     * 设备产能
     * @return List<Capacity>
     */
    List<Capacity> capacityList();

    /**
     * 日工作情况,默认1号至今天
     * @return String[]：red/green/gray
     */
    String[] dailyWork();

    /**
     * 月产能,默认1月份到当月
     * @return int[]
     */
    int[] monthCapacity();

    /**
     * 设备工作时长列表
     * @return List<DeviceHour>
     */
    List<DeviceHour> deviceHours();

    /**
     * 设备运行状态
     * @return  DeviceStatus
     */
    DeviceStatus deviceStatus();

    /**
     * 视频播放列表
     * @return
     */
    List<OnlineVideo> videoList();
}

package org.com.bzl.controller.board;

import org.com.bzl.service.board.pojo.Capacity;
import org.com.bzl.service.board.pojo.DeviceHour;
import org.com.bzl.service.board.pojo.DeviceStatus;
import org.com.bzl.service.board.pojo.OnlineVideo;
import org.com.bzl.service.board.IBoardService;
import org.com.bzl.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 *     大屏展示控制层
 *     @author menoly
 *     @date : 2019/2/19 下午5:08
 * </pre>
 */
@RestController
@RequestMapping( "/api/board" )
public class BoardController {
    @Autowired
    private IBoardService boardService;

    /**
     * 总产能
     * @return
     */
    @GetMapping("/totalCapacity")
    public Response capacity(){
        List<Capacity> data = boardService.capacityList();
        return Response.yes(data);
    }

    /**
     * 日工作情况,默认从1号到今天
     * @return
     */
    @GetMapping("/dailyWork")
    public Response dailyWork(){
        String[] data = boardService.dailyWork();
        return Response.yes(data);
    }

    /**
     * 月产能，默认1月份到当月
     * @return
     */
    @GetMapping("/monthCapacity")
    public Response monthCapacity(){
        int[]  data = boardService.monthCapacity();
        return Response.yes(data);
    }

    /**
     * 设备工作时长
     * @return
     */
    @GetMapping("/deviceHours")
    public Response deviceHours(){
        List<DeviceHour>  data = boardService.deviceHours();
        return Response.yes(data);
    }

    /**
     * 设备运行状态
     * @return
     */
    @GetMapping("/deviceStatus")
    public Response deviceStatus(){
        DeviceStatus data = boardService.deviceStatus();
        return Response.yes(data);
    }

    /**
     * 视频列表
     * @return
     */
    @GetMapping("/videoList")
    public Response videoList(){
        List<OnlineVideo> data = boardService.videoList();
        return Response.yes(data);
    }
}
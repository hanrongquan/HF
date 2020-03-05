package org.com.hrq.service.board;

import org.com.hrq.service.board.pojo.Capacity;
import org.com.hrq.service.board.pojo.DeviceHour;
import org.com.hrq.service.board.pojo.DeviceStatus;
import org.com.hrq.service.board.pojo.OnlineVideo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements IBoardService {

    @Override
    public List<Capacity> capacityList() {
        List<Capacity> data = new ArrayList<Capacity>();

        data.add(new Capacity("hrq-A001","送料运输机器人",88));
        data.add(new Capacity("hrq-A002","储罐式砂浆腻子搅拌机",100));

        return data;
    }

    @Override
    public String[] dailyWork() {
        String[] data = new String[]{"green","green","green","red"};
        return data;
    }

    @Override
    public int[] monthCapacity() {
        int [] data = new int[]{123,44,34,343,22};
        return data;
    }

    @Override
    public List<DeviceHour> deviceHours() {
        List<DeviceHour> data = new ArrayList<DeviceHour>();

        data.add(new DeviceHour("送料运输机器人",758));
        data.add(new DeviceHour("储罐式砂浆腻子搅拌机",325));
        return data;
    }

    @Override
    public DeviceStatus deviceStatus() {
        return new DeviceStatus("送料运输机器人",5,false,0.75f,"0xff34",32,2233,2120);
    }

    @Override
    public List<OnlineVideo> videoList() {
        List<OnlineVideo> data = new ArrayList<OnlineVideo>();
        data.add(new OnlineVideo("/video1"));
        return data;
    }
}

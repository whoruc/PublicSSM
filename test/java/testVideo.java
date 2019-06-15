import com.alibaba.fastjson.JSON;
import com.qiuligao.dao.PersonNumDao;
import com.qiuligao.dao.VideoDao;
import com.qiuligao.entity.Camera;
import com.qiuligao.entity.PersonNum;
import com.qiuligao.entity.Video;
import com.qiuligao.service.CameraService;
import com.qiuligao.service.PersonNumService;
import com.qiuligao.service.VideoService;
import com.qiuligao.util.ConfigUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class testVideo {
    LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(4);

    @Resource
    PersonNumService personService;

    @Resource
    PersonNumDao personNumDao;

    @Resource
    CameraService cameraService;

    @Resource
    VideoService videoService;

    @Test
    public void testVideoTime() {
//        int num;
//        int max = 34;
//        int min = 12;
//        Random random = new Random();
//        Long time = Long.parseLong("1560355200000");
//        Double dayTemp = time.doubleValue();
//        String day = Long.toString(Math.round(dayTemp / 1000 / 24 / 3600));
//        System.out.println(new Timestamp(time));
//        for (int i = 0; i < 50; i++) {
//            num = random.nextInt((max - min) + 1) + min;
//            personService.addHistory1(day, new Timestamp(time), num);
//            System.out.println(new Timestamp(time));
//            System.out.println(day);
//            time += 1000 * 60;
//        }
//        long time = Long.parseLong("1560422340000");
//        System.out.println(Long.toString(time / 1000 / 24 / 3600));
//        System.out.println(personService.getHistory1(Long.toString(time / 1000 / 24 / 3600)).length);

    }

    void setQueue(String name) {
        if (queue.size() == 3) {
            try {
                String delFile = queue.take();
                File file = new File(delFile);
                if (file.exists()) {
                    file.delete();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            queue.put(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

import com.alibaba.fastjson.JSON;
import com.qiuligao.dao.PersonNumDao;
import com.qiuligao.dao.VideoDao;
import com.qiuligao.entity.Camera;
import com.qiuligao.entity.PersonNum;
import com.qiuligao.entity.Video;
import com.qiuligao.service.CameraService;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class testVideo {
    LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(4);

    @Resource
    PersonNumDao personNumDao;

    @Resource
    CameraService cameraService;

    @Resource
    VideoService videoService;

    @Test
    public void testVideoTime() {
        String fileName = "1.mp4";
        String[] after = fileName.split("\\.");
        long longTime = (new Date()).getTime();
        String time = Long.toString(longTime);
        int id = Integer.parseInt(after[0]);
        Camera camera = cameraService.findCameraById(id);
        String position = camera.getPosition();
        String storeFileName = after[0] + "_" + position + "_" + time + "." + after[1];
        String filePath = ConfigUtil.getVideoFilePath(id);
        String webPath = ConfigUtil.getVideoPath(id);
        String url = filePath + storeFileName;
        System.out.println(url);
        String webUrl = webPath + storeFileName;
        videoService.uploadVideos(storeFileName, new Timestamp(longTime), 400, position, webUrl, id);
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

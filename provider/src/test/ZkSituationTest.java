import org.apache.curator.framework.CuratorFramework;
import org.junit.Before;
import org.junit.Test;

import com.lanxiang.zk.practice.service.common.ZkConnection;
import com.lanxiang.zk.practice.service.executetest.zkconfig.LanxiangConfig;

/**
 * Created by lanxiang on 2018/5/27.
 */
public class ZkSituationTest extends AbstractTest {


    private CuratorFramework curator = new ZkConnection("127.0.0.1:2181", "com.lanxiang.zk.practice").connect();

    @Before
    public void init() throws Exception {
        curator.start();

        curator.setData().forPath("/lanxiangZkPractice/lanxiangZkConfig/lanxiang.name", "lanxiang".getBytes());
        curator.setData().forPath("/lanxiangZkPractice/lanxiangZkConfig/lanxiang.age", "25".getBytes());
    }

    @Test
    public void testZkcc() throws Exception {
        Thread.sleep(1000L);
        System.out.println(LanxiangConfig.getName());
        System.out.println(LanxiangConfig.getAge());
        updateNameAndAge("liju", "24");
        Thread.sleep(1000L);
        System.out.println(LanxiangConfig.getName());
        System.out.println(LanxiangConfig.getAge());
        updateNameAndAge("bamei", "25");
        Thread.sleep(1000L);
        System.out.println(LanxiangConfig.getName());
        System.out.println(LanxiangConfig.getAge());
        while (true) {

        }
    }

    private void updateNameAndAge(String name, String age) throws Exception {
        curator.setData().forPath("/lanxiangZkPractice/lanxiangZkConfig/lanxiang.name", name.getBytes());
        curator.setData().forPath("/lanxiangZkPractice/lanxiangZkConfig/lanxiang.age", age.getBytes());
    }

}

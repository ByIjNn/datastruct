import com.binblink.springboot.HelloSpringBoot;
import com.binblink.springboot.bean.Person;
import com.binblink.springboot.component.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloSpringBoot.class)
public class RedisSpringBootTest {

    @Qualifier("myredisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private Person person;


    @Test
    public void test() {

        ValueOperations valueOperations = redisTemplate.opsForValue();

        valueOperations.set("das","dddddd");
//        valueOperations.set("sd","速度");
//        valueOperations.set("根","sdsdsdsdds");
//        valueOperations.set("person",person);
//        System.out.println(valueOperations.get("person"));
    }

    @Test
    public void test2() {

        redisUtil.set("mylove","lyq");
        System.out.println(redisUtil.get("mylove"));

    }

    @Test
    public void locktest() {

        //设置个Key
        String key = "order_id";
        //锁名称前缀
       String LOCK_PREFIX = "redis_lock";
        try {
            boolean b = redisUtil.lock(LOCK_PREFIX + key);
            if (b) {
                System.out.println("开始执行业务逻辑");
                Thread.sleep(2000);
            } else {
                System.out.println("获取锁错误{}"+b);
                return;
            }
        } catch (Exception e) {
            System.out.println("h获取异常");
            e.printStackTrace();
        } finally {
            //删除锁；
            redisUtil.releaseLock(LOCK_PREFIX + key);
        }
    }

}

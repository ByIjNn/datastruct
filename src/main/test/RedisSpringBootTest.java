import com.binblink.springboot.HelloSpringBoot;
import com.binblink.springboot.bean.Person;
import com.binblink.springboot.component.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
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
//
//        valueOperations.set("das","dddddd");
//        valueOperations.set("sd","速度");
//        valueOperations.set("根","sdsdsdsdds");
//        valueOperations.set("person",person);
        System.out.println(valueOperations.get("sd"));
        System.out.println(valueOperations.get("person"));
    }

    /**
     * 存入1000个货物
     */
    @Test
    @Order
    public void test2() {

        redisUtil.set("goods",1000);
        System.out.println(redisUtil.get("goods"));

    }

    class Task implements Runnable{
        //设置个Key
        String key = "order_id";
        //锁名称前缀
        String LOCK_PREFIX = "redis_lock";

        @Override
        public void run() {

            try {
                boolean b = redisUtil.lock(LOCK_PREFIX + key);
                if (b) {
                    System.out.println(Thread.currentThread().getName()+"开始执行业务逻辑");
                    int number  = (int) redisUtil.get("goods");

                    if(number >0){

                        redisUtil.decr("goods",1);
                    }

                } else {
                    System.out.println(Thread.currentThread().getName()+"获取锁错误{}"+b);
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


    /**
     * 获取锁 消耗货物
     */
    @Test
    public void locktest() {

//        int number  = (int) redisUtil.get("goods");
//
//        if(number >0){
//
//            redisUtil.decr("goods",1);
//        }

        Thread t1 = new Thread(new Task(),"Thread-1");
        Thread t2 = new Thread(new Task(),"Thread-2");
        Thread t3 = new Thread(new Task(),"Thread-3");
        Thread t4 = new Thread(new Task(),"Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

}

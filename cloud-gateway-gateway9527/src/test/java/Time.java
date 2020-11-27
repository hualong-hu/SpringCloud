import java.time.ZonedDateTime;

/**
 * @ProjectName: SpringCloud
 * @ClassName: Time
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-27 14:53
 * @Version v1.0
 */
public class Time {
    public static void main(String[] args) {
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println("time = " + time);
    }
}

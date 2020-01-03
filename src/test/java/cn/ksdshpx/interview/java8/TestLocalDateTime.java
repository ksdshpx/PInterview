package cn.ksdshpx.interview.java8;

import org.junit.Test;

import java.time.*;
import java.util.concurrent.TimeUnit;

/**
 * Create with IntelliJ IDEA
 * Create by peng.xing
 * Date: 2020/1/3
 * Time: 10:24
 * Description:本地时间与时间戳
 */
public class TestLocalDateTime {
    //1.LocalDate LocalTime LocalDateTime
    @Test
    public void test01() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate localDate2 = localDate.plusYears(1);
        System.out.println(localDate2);
        LocalDate localDate3 = localDate.minusDays(5);
        System.out.println(localDate3);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        System.out.println("=============");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println("=============");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    //Instant:时间戳(以Unix元年1970年00:00:00到某个时间的毫秒值)
    @Test
    public void test02() {
        Instant instant = Instant.now();//默认获取UTC时区
        System.out.println(instant);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        Instant instant2 = Instant.ofEpochSecond(60);
        System.out.println(instant2);
    }

    //Duration:计算两个时间之间的间隔
    //Period:计算两个日期之间的间隔
    @Test
    public void test03() {
        Instant start = Instant.now();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());
        System.out.println("====================");
        LocalDateTime startLocalDateTime = LocalDateTime.now();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime endLocalDateTime = LocalDateTime.now();
        System.out.println(Duration.between(startLocalDateTime, endLocalDateTime).toMillis());
        System.out.println("==================");
        LocalDate startLocalDate = LocalDate.of(2015, 1, 1);
        LocalDate endLocalDate = LocalDate.now();
        Period period = Period.between(startLocalDate, endLocalDate);
        System.out.println(period.getYears() + ":" + period.getMonths() + ":" + period.getDays());
    }
}

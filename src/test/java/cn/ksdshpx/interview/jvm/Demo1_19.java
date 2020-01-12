package cn.ksdshpx.interview.jvm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/1/12
 * Time: 22:35
 * Description:演示栈内存溢出
 */
public class Demo1_19 {
    public static void main(String[] args) throws JsonProcessingException {
        Dept d = new Dept();
        d.setName("Market");
        Emp e1 = new Emp();
        e1.setName("zhang");
        e1.setDept(d);
        Emp e2 = new Emp();
        e2.setName("li");
        e2.setDept(d);
        d.setEmps(Arrays.asList(e1, e2));
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(d));
    }
}

class Emp {
    private String name;
    @JsonIgnore
    private Dept dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}

class Dept {
    private String name;
    private List<Emp> emps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}

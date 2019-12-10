package cn.goat.mybatis.reflection;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/12/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/5---11:46
 */
public class Student extends Human implements Ibird {

    private String test;

    public Student() {
        System.out.println("无参构造函数执行。。。。。");
    }

    public Student(String test) {
        this.test = test;
    }

    /* 有参 有返回*/
    public String study(String course,Integer hour){
        return " Student  study......" +  course + hour;
    }

    public void getTitle(){
        System.out.println("Student getTitle......");
    }

    public void isTitle(){
        System.out.println("Student isTitle......");
    }
    @Override
    public ArrayList<String> getIds() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("2");
        strings.add("2");
        strings.add("2");
        return strings;
    }

    @Override
    public void eat() {
        System.out.println("Student eat......");
    }

    @Override
    public void fly() {
        System.out.println("Student...fly......");
    }
}

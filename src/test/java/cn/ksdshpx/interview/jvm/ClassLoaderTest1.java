package cn.ksdshpx.interview.jvm;

import sun.misc.Launcher;

import java.net.URL;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2020/2/12
 * Time: 20:07
 * Description:三种类加载器
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("*****启动类加载器*****");
        //获取启动类加载器能够加载的api的路径
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }

        System.out.println("*****扩展类加载器*****");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
    }
}

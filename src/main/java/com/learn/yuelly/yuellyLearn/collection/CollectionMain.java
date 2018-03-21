package com.learn.yuelly.yuellyLearn.collection;

import com.google.common.collect.Lists;
import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ll_yue on 2018/3/20.10:33
 */
public class CollectionMain {

    public static void main(String[] args) {


        Set set1 = new HashSet();

        set1.add(new Date());     //向列表中添加数据

        set1.add("apple");      //向列表中添加数据

        set1.add(new Socket());     //向列表中添加数据

        set1.add("TV");      //向列表中添加数据

        System.out.println("Set1的大小为："+set1.size());

        Set set2=new HashSet();

        set2.add("TV");      //向列表中添加数据


        System.out.println("Set2的大小为："+set2.size());

        List<Object> list = Lists.newArrayList();
        list.add("TV");
        set1.retainAll(list);
        //set1.retainAll(set2);

        System.out.println("从Set1集合移除Set2集合包含的内容");

        System.out.println("Set1的大小为："+set1.size());

    }
}

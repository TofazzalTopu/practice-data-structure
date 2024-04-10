package com.example.practice.model.eassy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class EssyShark {

    {
        System.out.println("one");
    }

    public static String output = "";

    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
            output += "1";
        } catch (Exception e) {
            output += "2";
            return;
        } finally {
            output += "3";
        }
        output += "4";
        System.out.println(output);
    }

    public static void main(String[] ares) {

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        map1.put("Number1", new Integer(100));
        map1.put("Number2", new Integer(200));
        map1.put("Number3", new Integer(300));
        List<Map> list = new ArrayList<Map>();
        list.add(map1);
        list.add(map2);

        HashMap resultMap = (HashMap) list.get(0);
        //      System.out.println("Number:" + resultMap.get("Number2"));
        foo(0);
        foo(1);
        //      System.out.println(output);

        int limit = 10;
        int i = 1;
        int sum = 0;
        for (; i <= limit; ) {
            sum += i++;
        }
        System.out.println(sum);
        String foo = "ABCDE";
        foo.substring(3);
        //      System.out.println(foo);
        //      List<String> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        String[] strArray = {"a", "b"};
        //      System.out.println("two");
        String s = new String("sssss");
        StringBuffer sb = new StringBuffer("bbbbb");
        s.concat("-aaa");
        sb.append("-aaa");
        //      System.out.println(s);
        //      System.out.println(sb);
        String[] strs = new String[5];
        strs[0] = "a";
        strs[1] = "b";

        int[] ints = new int[6];
        ints[0] = 1;
        //      int i = 0;
        int i2 = 127;
        //      var(i, i2);

        byte b = 2;
        byte b1 = 3;
        //      b = b * b1;
        Vector<String> lst = new Vector<String>();
        List<String> x = new Vector<String>();

        //      byte b = 12;
        //      byte k = b + 1;
        //      System.out.println(k);

        //      System.out.println(ares.length());
        //      System.out.println(ares[0]);
        //      System.out.println(ares);
    }

    public static void var(Integer x, int y) {
        System.out.println("Integer int");
    }

    public static void var(Object... x) {
        System.out.println("Object");
    }

    public static void var(int... x) {
        System.out.println("Int x");
    }

    public static void var(Integer... x) {
        System.out.println("Integer ");
    }

    static {
        System.out.println("three");
    }

}

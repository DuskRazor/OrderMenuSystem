package com.kali;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用来测试如何统计list中相同的元素，想在AppWindow中对客户
 * 已点菜单进行归类
 */
public class Test {
    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(1,"地三鲜",14));
        menus.add(new Menu(2,"红烧肉",24));
        menus.add(new Menu(3,"油闷大虾",64));
        menus.add(new Menu(3,"油闷大虾",64));
        menus.add(new Menu(4,"麻婆豆腐",12));
        menus.add(new Menu(5,"木须柿子",9));

        Map<Menu,Integer> map = new HashMap<>();

        //System.out.println(map.get("s"));

        for(Menu s : menus){
            int i = 1;
            if(map.get(s) != null){
                i = map.get(s) + 1;
            }
            map.put(s,i);
        }

        System.out.println(map);
    }
}

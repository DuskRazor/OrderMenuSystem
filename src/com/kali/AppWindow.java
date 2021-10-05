package com.kali;

import java.util.*;

/**
 * 难点：在对客户已点菜单进行统计时，对于数据的存储方式做了改变
 * 使用LinkedHashMap进行统计，根据输入的id用for循环控制在list集合
 * 中的索引index，将map的values做加操作
 */
public class AppWindow {

    //初始化菜单
    private final List<Menu> menus = new ArrayList<>();
    private final Map<Menu,Integer> map = new LinkedHashMap<>();
    public AppWindow(){
        initMenu();
    }

    //对于单个客户的处理逻辑
    public void process(AppWindow app,Customer customer){
        Scanner scan = new Scanner(System.in);

        app.showHelp();
        app.showMainMenu();

        System.out.print("请输入操作序号: ");
        while(true){
            String input = scan.next();
            int delId;
            if(input.contains("-")){
                delId = Integer.parseInt(input.substring(1));
                if(delId >= 1 && delId <= customer.getList().size()){
                    app.deleteOrdered(customer,delId);
                }
            }
            if("#".equals(input)){
                showMainMenu();
            }else {
                try {
                    int in = Integer.parseInt(input);
                    switch (in){
                        case 1 :
                            app.showMenus();
                            app.order(customer,scan);
                            break;
                        case 2 :
                            app.showOrdered(customer);
                            break;
                        case 3 :
                            app.checkOut(customer);
                            break;
                        case 4 :
                            return;
                        case 5 :
                            app.showHelp();
                            break;
                        default: break;
                    }
                }catch (Exception e){
                    System.out.println("请输入*结束点菜");
                    showMainMenu();
                }
            }
        }
    }

    //帮助
    public void showHelp(){
        System.out.println("帮助信息\t");
        System.out.print("摁1进入点菜\t");
        System.out.print("摁2查看已点菜单\t");
        System.out.print("摁3查看金额\t");
        System.out.print("摁4退出\t");
        System.out.print("摁*结束点菜\t");
        System.out.print("摁(-NO.)删除已点菜\t");
        System.out.println("摁#显示主菜单");
    }

    //结账
    public void checkOut(Customer c){
        List<Menu> list = c.getList();
        int count = 0;
        for(Menu m : list){
            count += m.getPrice();
        }
        System.out.println("总计" + count + "￥");
    }

    //删除已点菜单
    public void deleteOrdered(Customer c,int id){
        List<Menu> list = c.getList();
        if(id >= 1 && id <= map.size()){
            Collection<Integer> values = map.values();
            int index = 0;
            for(int i = 0;i < id;i++){
                Object[] obj = values.toArray();
                index += (Integer) obj[i];
            }
            list.remove(index - 1);
        }

        showOrdered(c);
    }

    //查看已点菜单
    public void showOrdered(Customer c){
        List<Menu> list = c.getList();
        System.out.println("—————" + c.getId() + "号桌已点菜单—————");
        map.clear();

        for(Menu m : list){
            int i = 1;
            if(map.get(m) != null){
                i = map.get(m) + 1;
            }
            map.put(m,i);
        }

        int i = 1;
        for(Map.Entry<Menu,Integer> entry : map.entrySet()){
            System.out.println((i++) + "\t" + entry.getKey().getName() + "\t" + entry.getKey().getPrice() + "\t" + entry.getValue() + "份");
        }
        System.out.println("——————————订单号:" + c.getCid() + "\n");

        System.out.println("摁(-NO.)删除  摁3查看总价\t摁#显示主菜单");
    }
    //客户点菜
    public void order(Customer c,Scanner scan){
        List<Menu> list = c.getList();
        while(true){
            String in = scan.next();
            if("*".equals(in)){
                System.out.println("点餐完毕，输入2显示订单信息");
                break;
            }else{
                int i = Integer.parseInt(in);
                if(i > 0 && i <= menus.size()){
                    Menu menu = menus.get(i - 1);
                    System.out.println("已点" + menu);
                    list.add(menu);
                }
            }
        }
    }

    public void showMenus(){
        System.out.println("——————————菜单———————————");
        for(Menu m : menus){
            System.out.println("\t" + m);
        }
        System.out.println("—————————————————————————");
        System.out.println("请点餐(输入*退出点餐)");
    }

    public void showMainMenu(){
        System.out.println("+——————————主菜单—————————+");
        System.out.println("|  1            点菜      |");
        System.out.println("|  2            查看      |");
        System.out.println("|  3            结账      |");
        System.out.println("|  4            退出      |");
        System.out.println("|  5            帮助      |");
        System.out.println("+—————————————————————————+");
    }

    public void initMenu(){
        menus.add(new Menu(1,"地三鲜",14));
        menus.add(new Menu(2,"红烧肉",24));
        menus.add(new Menu(3,"油闷大虾",64));
        menus.add(new Menu(4,"麻婆豆腐",12));
        menus.add(new Menu(5,"木须柿子",19));
    }

}

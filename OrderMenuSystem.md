# OrderMenuSystem
* 系统未做健壮性考虑，主要考虑点在逻辑实现。
* 小项目可以实现多个用户的同步处理，如果想改进的话，可以将排队的Consumer存入合适的数据结构中，让AppWindow，处理即可。
*
* 1.系统说明：
*    操作说明：
*     摁1进入点菜
*     摁2查看已点菜
*     摁3查看金额
*     摁4退出
*     摁*结束点菜
*     摁(-NO.)删除已点菜，例如 -1，用于删除已点的菜单
*     摁#显示主菜单
* 2.菜的类为Menu有三个属性，在AppWindow类的存储结构是LinkedLisk。查看菜单就是对list集合的遍历，没什么可说的，
* 在编写过程中，比较花时间的是对客户点购的菜单归类显示，比如 拍黄瓜 2 份，采用了LinkedHashSet，采用LinkedHashMap的
* 原因是因为在每次对list集合进行结构性修改后想保持它原有的添加顺序，以便后续使用LinkedHashMap在统计时也有序
* 3.系统中使用了一个map----->  private final Map<Menu,Integer> map = new LinkedHashMap<>();在每次list发生结构性
* 变化时，map.clear()，清除上次统计的数据。重新统计，然后顺序输出菜单.....
* 4.客户已点菜单归类逻辑：
*
* public void checkOut(Customer c){
*     List<Menu> list = c.getList();
*     int count = 0;
*     for(Menu m : list){
*         count += m.getPrice();
*     }
*     System.out.println("总计" + count + "￥");
* }
*
* 5.map集合只是对list集合中相同（相同菜名）的元素做了统计，但是对已点菜要进行删除具体某一个，我却花了好一会功夫，解决方案，
* 因为使用的是LinkedHashMap，所以不需要担心在clear之后每次存储的数据位置发生变化，所以有几组key-value那么根据id找到对应的组，
* 然后将value值相加（map中value代表list中相同菜的数量），得到list中的索引，利用这个索引就可以删除list中的元素了，最后更新
* map集合即可。
*
* //删除已点菜单
* public void deleteOrdered(Customer c,int id){
*    List<Menu> list = c.getList();
*     if(id >= 1 && id <= map.size()){
*         Collection<Integer> values = map.values();
*         int index = 0;
*         for(int i = 0;i < id;i++){
*             Object[] obj = values.toArray();
*             index += (Integer) obj[i];
*         }
*         list.remove(index - 1);
*     }
*
*     showOrdered(c);
* }

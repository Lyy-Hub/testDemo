package 三种集合比较;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        listtest();
        settest();
        maptest();
    }

    static String[] string = {"i", "am", "xiao", "huang"};

    public static void listtest() {
        List<String> list = new ArrayList<String>();
        for (String s : string) {
            list.add(s);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list的结果是：" + list.get(i));
        }
    }

    public static void settest() {
        Set<String> set = new HashSet<String>();
        for (String s : string) {
            set.add(s);
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("set的输出结果是：" + iterator.next());
        }
    }

    public static void maptest() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (String s : string) {
            map.put(s.length(), s);
            System.out.println("map的输出结果是：" + map.get(s.length()));
        }
    }

}

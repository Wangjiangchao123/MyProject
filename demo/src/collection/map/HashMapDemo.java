package collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author 王江超
 * @Date 2019/12/27 9:38
 * @Description:
 */
public class HashMapDemo {

    /**
     *  HashMap 5种遍历  一种遍历值
     *
     * @param args
     */
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("1","张三");
        map.put("2","李四");

        //  1、直接遍历  map的值
        for (Object val:map.values()) {
            System.out.println(val);
        }

        //遍历map的key

        Iterator iterator = map.entrySet().iterator();
 //      推荐方式  获取map的key和value   效率高
        //2、遍历  完整的map
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println((Object) entry.getKey()+"----"+(Object)entry.getValue());
        }


    }
}

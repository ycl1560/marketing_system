package com.yunhang.marketing_system;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.glassfish.jersey.internal.guava.HashMultimap;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MarketingSystemApplicationTests {

    @Test
    void contextLoads() {
    }
   @Test
    public void Test1(){
      /* String str="2019-10-09 12:15:12";
       List<String> split = Splitter.on('-').trimResults().splitToList(str);
       for (String s : split) {
           System.out.println(s);
       }
      String s2=Splitter.on(" ").trimResults().splitToList(split.get(2)).get(0);
       System.out.println(split.get(1)+"月"+s2+"日");

       //5-10是截取str出了10-09 ,注意这里有空格
       System.out.println(str.substring(5,10).replace("-","月"));*/

     /*  HashMultimap<Integer,String> hashMultimap=HashMultimap.create();
       hashMultimap.put(1, "第一");
       hashMultimap.put(1,"第二");
       Set<String> strings = hashMultimap.get(1);
       for (String string : strings) {
           System.out.println(string);
       }*/
     /*  ArrayList<String> strings1 = Lists.newArrayList(strings);
       for (int i=0;i<strings1.size();i++){
           System.out.println(strings1.get(i));
       }*/


     /*  HashMap<Integer,String > hashMap=new HashMap();
       hashMap.put(1,"第一");
       hashMap.put(1,"第二");
       System.out.println(hashMap);*/


      /* String url="https://note.youdao.com/web/#/file/recent/note/WEB050ef93073aa016542acaac119accf89/";
       //加密
       String s = Base64.getEncoder().encodeToString(url.getBytes());
       //解密
       byte[] decode = Base64.getDecoder().decode(s);
       System.out.println(s);
       System.out.println(new String(decode));*/
    }
}

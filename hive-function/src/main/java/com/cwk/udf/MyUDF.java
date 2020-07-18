package com.cwk.udf;


import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * 1.继承 UDF类，提供多个evaluate方法，evaluate不能返回void，但是可以返回null
 *
 * ①取ap属性的值app:   a(jsonstr,'ap')=app
②取json的1581472611770：   a(jsonstr,'ts')=1581472611770
③取cm公共部分中的属性，例如：
	取cm中的ln的值：  a(jsonstr,'ln')=-45.5
	取cm中的sv的值：  a(jsonstr,'sv')=V2.7.9
	取et:  a(jsonstr,'et')=[{},{},{}]

	param应该包含ts！

	数据格式：  时间戳 | {"ap":"","cm":{},"et":[{},{}]}
 */
public class MyUDF extends UDF{

    public String evaluate(String source,String param) throws JSONException {

        //参数的检查  source中，没有param，param也不是ts
        if (!source.contains(param) && !"ts".equals(param)) {

            return "";

        }

        //param合法，取参数
        String[] words = source.split("\\|");

        //构建JSON对象
        JSONObject root = new JSONObject(words[1]);

        //取出时间戳
        if ("ts".equals(param)) {

            return words[0].trim();

        }else if ("ap".equals(param)) {
            //取出ap的值

            return root.getString("ap");

        }else if ("et".equals(param)) {
            //取出整个事件数组字符串

            return root.getString("et");

        }else {
            //取的是cm中的某个属性
            return root.getJSONObject("cm").getString(param);

        }


    }

}

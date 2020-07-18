package com.cwk.udtf;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * 1. 继承 GenericUDTF
 * 		initialize
 *
 * 2. 传入的参数：　[{},{},{}]
 */

public class MyUDTF extends GenericUDTF{

    // 在函数运行之前被调用一次，作用是告诉MapTask,当前函数返回的结果类型和个数，以便MapTask在运行时，
    // 会函数的返回值进行检查
    // 当前此函数，应该在initialize声明返回值类型是 2列String类型的数据！
    // Inspector：检查员
    @Override
    public StructObjectInspector initialize(ObjectInspector[] argOIs) throws UDFArgumentException {

        //当前返回的两列的字段别名
        List<String> fieldNames=new ArrayList<String>();

        fieldNames.add("event_name");
        fieldNames.add("event_json");

        //　当前返回的两列的类型检查器
        List<ObjectInspector> fieldOIs= new ArrayList<ObjectInspector>();

        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);

    }

    //执行函数的功能，处理数据后调用forward()返回结果
    // 返回的应该是2列Ｎ行的数据，
    @Override
    public void process(Object[] args) throws HiveException {

        //检查是否传入了参数
        if (args[0]==null || args.length==0) {
            return ;
        }

        try {
            //构建JSON数组对象

            JSONArray jsonArray = new JSONArray(args[0].toString());

            //构建JSON数组对象是否失败
            if (jsonArray==null || jsonArray.length()==0) {
                return;
            }

            //取出JSON数组中，每一个{},再从每一个{}取出事件名
            for (int i=0;i<jsonArray.length();i++) {

                try {
                    //每遍历一次，需要写出去一行两列的数据，构建一个数组，存储一行两列的数据
                    String [] result=new String [2];

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //取出当中的事件名
                    result[0]=jsonObject.getString("en");

                    //讲真个jsonstr作为第二列
                    result[1]=jsonObject.toString();

                    System.out.println(Arrays.asList(result));

                    //讲result写出
                    forward(result);
                } catch (Exception e) {

                    //继续开始遍历下一个{}
                    continue;

                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    // 在调用函数完成之后,执行一些清理或关闭操作
    @Override
    public void close() throws HiveException {

    }

}

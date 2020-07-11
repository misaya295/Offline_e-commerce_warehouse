package com.cwk.dw.flume;


import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyInterCeptor implements Interceptor {


    private List<Event> results = new ArrayList<Event>();

    private String startFlag = "\"en\":\"start\"";



    @Override
    public void initialize() {




    }


    /**
     * 核心方法，拦截Event
     * @param event
     * @return
     */
    @Override
    public Event intercept(Event event) {


        byte[] body = event.getBody();


        //在header添加key
        Map<String, String> header = event.getHeaders();


        String bodyStr = new String(body, Charset.forName("UTF-8"));


        boolean flag = true;

        //符合启动日志特征
        if (bodyStr.contains(startFlag)) {
            header.put("topic", "topic_start");
            flag = ELTUtils.validStartLog(bodyStr);
        } else {
            header.put("topic", "topic_event");
            flag = ELTUtils.validEventLog(bodyStr);

        }

        if (!flag) {
            return null;
        }


        return event;
    }


    @Override
    public List<Event> intercept(List<Event> list)
    {

        //先清空result
        results.clear();

        for (Event event : list) {

            Event result = intercept(event);

            //有可能intercept(event)，event不符合要求，会拦截掉，返回null
            if (result != null) {
                results.add(result);
            }


        }
        return results;

    }

    @Override
    public void close() {

    }



    //创建一个拦截器对象
    public static class Builder implements Interceptor.Builder {
        @Override
        public Interceptor build() {


            return new MyInterCeptor();

        }

        @Override
        public void configure(Context context) {




        }
    }
}


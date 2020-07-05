import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class TestJson {

    @Test
    public void testFastJson() throws  Exception {


        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "jack");
        jsonObject.put("age", "18");
        jsonObject.put("gender", "male");

        System.out.println(jsonObject);


    }

    @Test
    public void testFastJson1() throws  Exception {


        String str = "{\"gender\":\"male\",\"name\":\"jack\",\"age\":18}";


        Person p = new JSON() {
        }.parseObject(str,Person.class);
        System.out.println(p);
    }
    @Test
    public void testFastJson3() throws  Exception {
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "jack");
        jsonObject1.put("age", "18");
        jsonObject1.put("gender", "male");


        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name", "jack");
        jsonObject2.put("age", "18");
        jsonObject2.put("gender", "male");


        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);

        System.out.println(jsonArray);


    }


}

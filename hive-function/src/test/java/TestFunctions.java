

import com.cwk.udf.MyUDF;
import com.cwk.udtf.MyUDTF;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.json.JSONException;
import org.junit.Test;



public class TestFunctions {

	@Test
	public void testUDF() throws JSONException, HiveException {

		//String str="1581472611770|{\"cm\":{\"ln\":\"-45.5\",\"sv\":\"V2.7.9\",\"os\":\"8.0.7\",\"g\":\"2E0719R3@gmail.com\",\"mid\":\"9\",\"nw\":\"3G\",\"l\":\"pt\",\"vc\":\"13\",\"hw\":\"640*1136\",\"ar\":\"MX\",\"uid\":\"9\",\"t\":\"1581440366103\",\"la\":\"24.4\",\"md\":\"HTC-5\",\"vn\":\"1.2.3\",\"ba\":\"HTC\",\"sr\":\"F\"},\"ap\":\"app\",\"et\":[{\"ett\":\"1581376543852\",\"en\":\"display\",\"kv\":{\"goodsid\":\"3\",\"action\":\"1\",\"extend1\":\"1\",\"place\":\"3\",\"category\":\"78\"}},{\"ett\":\"1581440821593\",\"en\":\"loading\",\"kv\":{\"extend2\":\"\",\"loading_time\":\"10\",\"action\":\"3\",\"extend1\":\"\",\"type\":\"2\",\"type1\":\"433\",\"loading_way\":\"1\"}},{\"ett\":\"1581436003510\",\"en\":\"ad\",\"kv\":{\"entry\":\"3\",\"show_style\":\"4\",\"action\":\"3\",\"detail\":\"325\",\"source\":\"4\",\"behavior\":\"1\",\"content\":\"2\",\"newstype\":\"1\"}}]\r\n" +
			//	"";

		String str="1581472611767|{\"cm\":{\"ln\":\"-45.5\",\"sv\":\"V2.8.5\",\"os\":\"8.1.7\",\"g\":\"F482879D@gmail.com\",\"mid\":\"5\",\"nw\":\"3G\",\"l\":\"en\",\"vc\":\"5\",\"hw\":\"640*960\",\"ar\":\"MX\",\"uid\":\"5\",\"t\":\"1581404570383\",\"la\":\"-42.3\",\"md\":\"Huawei-10\",\"vn\":\"1.2.0\",\"ba\":\"Huawei\",\"sr\":\"S\"},\"ap\":\"app\",\"et\":[{\"ett\":\"1581431305538\",\"en\":\"newsdetail\",\"kv\":{\"entry\":\"1\",\"goodsid\":\"2\",\"news_staytime\":\"6\",\"loading_time\":\"20\",\"action\":\"4\",\"showtype\":\"0\",\"category\":\"64\",\"type1\":\"\"}},{\"ett\":\"1581408922952\",\"en\":\"ad\",\"kv\":{\"entry\":\"2\",\"show_style\":\"5\",\"action\":\"3\",\"detail\":\"201\",\"source\":\"4\",\"behavior\":\"1\",\"content\":\"2\",\"newstype\":\"9\"}},{\"ett\":\"1581452325430\",\"en\":\"active_foreground\",\"kv\":{\"access\":\"\",\"push_id\":\"2\"}},{\"ett\":\"1581393585120\",\"en\":\"error\",\"kv\":{\"errorDetail\":\"at cn.lift.dfdfdf.control.CommandUtil.getInfo(CommandUtil.java:67)\\\\n at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\\\\n at java.lang.reflect.Method.invoke(Method.java:606)\\\\n\",\"errorBrief\":\"at cn.lift.dfdf.web.AbstractBaseController.validInbound(AbstractBaseController.java:72)\"}},{\"ett\":\"1581401731609\",\"en\":\"comment\",\"kv\":{\"p_comment_id\":3,\"addtime\":\"1581373484705\",\"praise_count\":528,\"other_id\":2,\"comment_id\":0,\"reply_count\":59,\"userid\":3,\"content\":\"华样焰忘坤沏擅洽般驰胞羌贬纤肄肛蛊姚炉繁逆雁迫鄂\"}},{\"ett\":\"1581462650833\",\"en\":\"favorites\",\"kv\":{\"course_id\":8,\"id\":0,\"add_time\":\"1581467735483\",\"userid\":3}},{\"ett\":\"1581376563077\",\"en\":\"praise\",\"kv\":{\"target_id\":0,\"id\":6,\"type\":3,\"add_time\":\"1581415278073\",\"userid\":2}}]}\r\n" +
				"";

		MyUDF myUDF = new MyUDF();

		MyUDTF myUDTF = new MyUDTF();

		System.out.println(myUDF.evaluate(str, "et"));

		Object [] args=new Object[2];

		args[0]=myUDF.evaluate(str, "et");

		myUDTF.process(args);
	}

}

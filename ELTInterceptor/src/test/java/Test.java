import com.cwk.dw.flume.ELTUtils;

public class Test {

    public static void main(String[] args) {

        String startStr="{\"action\":\"1\",\"ar\":\"MX\",\"ba\":\"Sumsung\",\"detail\":\"\",\"en\":\"start\",\"entry\":\"1\",\"extend1\":\"\",\"g\":\"269B4A02@gmail.com\",\"hw\":\"750*1134\",\"l\":\"es\",\"la\":\"15.3\",\"ln\":\"-90.7\",\"loading_time\":\"4\",\"md\":\"sumsung-19\",\"mid\":\"9\",\"nw\":\"4G\",\"open_ad_type\":\"1\",\"os\":\"8.0.5\",\"sr\":\"R\",\"sv\":\"V2.2.0\",\"t\":\"1581389337646\",\"uid\":\"9\",\"vc\":\"9\",\"vn\":\"1.1.4\"}\r\n" +
                "";

        String eventStr="1123472611840|{\"cm\":{\"ln\":\"-120.5\",\"sv\":\"V2.3.2\",\"os\":\"8.1.0\",\"g\":\"T0707S8I@gmail.com\",\"mid\":\"2\",\"nw\":\"3G\",\"l\":\"es\",\"vc\":\"6\",\"hw\":\"750*1134\",\"ar\":\"MX\",\"uid\":\"2\",\"t\":\"1581383400282\",\"la\":\"-2.2\",\"md\":\"sumsung-4\",\"vn\":\"1.0.4\",\"ba\":\"Sumsung\",\"sr\":\"Y\"},\"ap\":\"app\",\"et\":[{\"ett\":\"1581392790244\",\"en\":\"ad\",\"kv\":{\"entry\":\"2\",\"show_style\":\"2\",\"action\":\"3\",\"detail\":\"\",\"source\":\"2\",\"behavior\":\"1\",\"content\":\"2\",\"newstype\":\"5\"}},{\"ett\":\"1581428049597\",\"en\":\"active_foreground\",\"kv\":{\"access\":\"\",\"push_id\":\"1\"}},{\"ett\":\"1581408190108\",\"en\":\"error\",\"kv\":{\"errorDetail\":\"java.lang.NullPointerException\\\\n    at cn.lift.appIn.web.AbstractBaseController.validInbound(AbstractBaseController.java:72)\\\\n at cn.lift.dfdf.web.AbstractBaseController.validInbound\",\"errorBrief\":\"at cn.lift.appIn.control.CommandUtil.getInfo(CommandUtil.java:67)\"}},{\"ett\":\"1581405196123\",\"en\":\"comment\",\"kv\":{\"p_comment_id\":1,\"addtime\":\"1581458501484\",\"praise_count\":860,\"other_id\":2,\"comment_id\":8,\"reply_count\":59,\"userid\":3,\"content\":\"插惊丘搓厉逸溺忠徊帐萍蝉捧降旁挠\"}},{\"ett\":\"1581467162556\",\"en\":\"favorites\",\"kv\":{\"course_id\":7,\"id\":0,\"add_time\":\"1581467520402\",\"userid\":1}}]}\r\n" +
                "";

        System.out.println(ELTUtils.validStartLog(startStr));
        System.out.println(ELTUtils.validEventLog(eventStr));
    }

}

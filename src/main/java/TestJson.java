import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestJson {
    public static void main(String args[]){
//        String lastObj = "{\"ts\": {\"$timestamp\": {\"t\": 1573565064, \"i\": 1}}, \"t\": {\"$numberLong\": \"1\"}, \"h\": {\"$numberLong\": \"1795537101436045599\"}, \"v\": 2, \"op\": \"u\", \"ns\": \"mongoshake.ckpt_default\", \"o2\": {\"_id\": {\"$oid\": \"5dca76737ec163bd703972b0\"}}, \"o\": {\"_id\": {\"$oid\": \"5dca76737ec163bd703972b0\"}, \"name\": \"mgset-15533907\", \"ckpt\": {\"$timestamp\": {\"t\": 1573565063, \"i\": 1}}}}";
//
//        try {
//            JSONObject jsonObj = (JSONObject)(new JSONParser().parse(lastObj));
//
//            JSONObject tsObj = (JSONObject)(new JSONParser().parse(jsonObj.get("ts").toString()));
//            JSONObject timestampObj = (JSONObject)(new JSONParser().parse(tsObj.get("$timestamp").toString()));
//            System.out.println(timestampObj);
//            String tObj = timestampObj.get("t").toString();
//
//            System.out.println(tObj);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String c = null;
        Boolean a =  !( c == null) && c.equals("student");

        System.out.println(a);
    }


}

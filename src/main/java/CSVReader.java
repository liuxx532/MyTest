//import java.io.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class CSVReader implements Serializable{
//    private static final long serialVersionUID = 1L;
//    public static Map readCsv(String filepath, String tableName, String foreignKey) {
//        System.out.println("start to read file...");
//        File csv = new File(filepath); // CSV文件路径
////        csv.setReadable(true);//设置可读
////        csv.setWritable(true);//设置可写
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader(csv));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        String line = "";
//        String everyLine = "";
//        Map<String,String> allString = new HashMap<>();
//        try {
//            while ((line = br.readLine()) != null) // 读取到的内容给line变量
//            {
//                everyLine = line;
//                String[] strArr = everyLine.split(",");
//                allString.put(tableName + "_" + strArr[0] , foreignKey + "_" + strArr[1]);
//            }
//            System.out.println(allString);
//            System.out.println("csv表格中所有行数：" + allString.size());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return allString;
//    }
//
//    public static Map readCsv(String filepath, String tableName, String semesterId, String publisherId ) {
//        System.out.println("start to read file...");
//        File csv = new File(filepath); // CSV文件路径
////        csv.setReadable(true);//设置可读
////        csv.setWritable(true);//设置可写
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader(csv));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        String line = "";
//        String everyLine = "";
//        Map<String,String> allString = new HashMap<>();
//        try {
//            while ((line = br.readLine()) != null) // 读取到的内容给line变量
//            {
//                everyLine = line;
//                String[] strArr = everyLine.split(",");
//                allString.put(tableName + "_" + strArr[0] , publisherId + "_" + strArr[1] + "," + semesterId + "_" + strArr[2]);
//            }
//            System.out.println(allString);
//            System.out.println("csv表格中所有行数：" + allString.size());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return allString;
//    }
//
//    public  List readCsv(String filepath ) {
//        InputStream path = this.getClass().getResourceAsStream(filepath);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(path));
//
//        String line;
//        String everyLine;
//        List dataList = new ArrayList();
//        try {
//            while ((line = reader.readLine()) != null) // 读取到的内容给line变量
//            {
//                everyLine = line;
//                String[] strArr = everyLine.split(",");
//                dataList.add(strArr[1]);
//            }
//            System.out.println("csv表格中所有行数：" + dataList.size());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return dataList;
//    }
//
//
//    public static void main(String arg[]) {
//
//    }
//
//}

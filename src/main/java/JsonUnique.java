
import net.sf.json.JSONObject;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class JsonUnique {
    private File outfile = new File("/Users/lgx/Downloads/emailResult.txt");
    LdapReader ldapReader = new LdapReader();

    public static void main(String[] args) {
        JsonUnique jsonUnique = new JsonUnique();
        jsonUnique.getKeys();
    }

    public void getKeys() {
        File file = new File("/Users/lgx/Downloads/2020-07-13-12_25_16.log");

        BufferedReader br = null;
        String line = "";
        Map userMap = new HashMap();
        try {
            br = new BufferedReader(new FileReader(file));
            while (null != (line = br.readLine())) {
                JSONObject jsonObject = JSONObject.fromObject(line);
                String username = jsonObject.getString("username");
                System.out.println(username);
                if (("null").equals(username))
                    continue;
                String name = username.split("\\(")[1].split("\\)")[0];
                userMap.put(name,"");
            }
            FileWriter fileWriter = new FileWriter(outfile,true);

            userMap.keySet()
                    .stream()
                    .forEach(e->
                    {
                        try {
                            fileWriter.write(ldapReader.GetADInfo(e.toString()) + "\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });

            fileWriter.flush();
            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void connectMysql(String username){
        Connection conn = null;
        System.out.println("start connect");
        String conn_str = "jdbc:mysql://127.0.0.1:3306/finebiTest?"
                + "user=root&password=root"
                +"&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(conn_str);
            Statement stmt = conn.createStatement();
            String sql = "select email from fine_user where userName = '" + username + "'";
            ResultSet result = stmt.executeQuery(sql);

            FileWriter fileWriter = new FileWriter(outfile,true);

            if (result != null) {
                while (result.next()) {
                    {
                        try {
                            System.out.println(result.getString(1) + "\n");
                            fileWriter.write(result.getString(1) + "\n");

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        fileWriter.flush();
                        fileWriter.close();
                    }
                }
            }

            System.out.println("MariaDB/MySQL connect success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

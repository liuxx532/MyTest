import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LdapReader {

    public String GetADInfo(String username) {
        String userMail = "";
        Hashtable HashEnv = new Hashtable();
        String adminName ="dc=ldap,dc=yc345,dc=tv";//AD的用户名
        // User@domain.com
        HashEnv.put(Context.SECURITY_AUTHENTICATION, "simple"); // LDAP访问安全级别
//        HashEnv.put(Context.SECURITY_PRINCIPAL, adminName); // AD User
        HashEnv.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory"); // LDAP工厂类
        HashEnv.put(Context.PROVIDER_URL, "ldap://edc.yc345.tv:389");
        try {
            LdapContext ctx = new InitialLdapContext(HashEnv, null);
            // 域节点
            String searchBase = "uid=" + username + ",cn=users,dc=ldap,dc=yc345,dc=tv";
            // LDAP搜索过滤器类
            String searchFilter = "objectClass=person";
            // 搜索控制器
            SearchControls searchCtls = new SearchControls(); // Create the
            // search
            // controls
            // 创建搜索控制器
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE); // Specify
            // the
            // search
            // scope
            // 设置搜索范围
            // searchCtls.setSearchScope(SearchControls.OBJECT_SCOPE); //
            // Specify the search scope 设置搜索范围
            String returnedAtts[] = { "mail", "cn" };// 定制返回属性
            // String returnedAtts[] = { "url", "whenChanged", "employeeID",
            // "name", "userPrincipalName", "physicalDeliveryOfficeName",
            // "departmentNumber", "telephoneNumber", "homePhone",
            // "mobile", "department", "sAMAccountName", "whenChanged",
            // "mail" }; // 定制返回属性
            searchCtls.setReturningAttributes(returnedAtts); // 设置返回属性集

            // 根据设置的域节点、过滤器类和搜索控制器搜索LDAP得到结果
            NamingEnumeration answer = ctx.search(searchBase, searchFilter,
                    searchCtls);// Search for objects using the filter

            // 初始化搜索结果数为0
            int totalResults = 0;// Specify the attributes to return
            int rows = 0;

            while (answer.hasMoreElements()) {// 遍历结果集
                SearchResult sr = (SearchResult) answer.next();// 得到符合搜索条件的DN
                System.out.println(++rows + "************************************************");
                System.out.println(sr.getName());
                Attributes Attrs = sr.getAttributes();// 得到符合条件的属性集
                System.out.println(Attrs);
                if (Attrs != null) {
                    try {
                        for (NamingEnumeration ne = Attrs.getAll(); ne.hasMore();) {
                            Attribute Attr = (Attribute) ne.next();// 得到下一个属性
                            // 读取属性值
                            for (NamingEnumeration e = Attr.getAll(); e.hasMore(); totalResults++) {
                                userMail = userMail + e.next().toString() + "\t";
                            }
                        }
                    } catch (NamingException e) {
                        System.err.println("Throw Exception : " + e);
                    }
                }
            }
            System.out.println("************************************************");
            System.out.println("Number: " + totalResults);
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
            System.err.println("Throw Exception : " + e);
        }

        System.out.println(userMail);
        return userMail;
    }

    public static void main(String args[]) {
        LdapReader ldapReader = new LdapReader();
        ldapReader.GetADInfo("liuguanxiong");
    }
}

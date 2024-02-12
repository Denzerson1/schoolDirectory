import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        String[] hostnames = {
                "test.test.com.gov",
                "www.ibm.com",
                "www.java.sun.com",
                "www.zend.com",
                "java.sun.com",
                "www.php.net",
                "www.IBM.com",
                "www.ris.bka.gv.at",
                "www.Web addresses can't have spaces.com",
                "www..com",
                "192.168.1.0",
                "192.168.1.256",
                "256.1.1.1",
                "172.435.123.123",
                "192.192.258.192"
        };

        String regex = "^(?!.*\\s)((?!\\d+$)[a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9])" +
                "(\\.(?!\\d+$)(?!-)[a-zA-Z0-9-]+(?<!-)\\b)*\\.?(\\.(?!\\d+$)(?!-)[a-zA-Z]{2,6})$";
        Pattern pattern = Pattern.compile(regex);

        for (String hostname : hostnames) {
            Matcher matcher = pattern.matcher(hostname);
            System.out.println(hostname + " is " + (matcher.matches() ? "valid" : "invalid"));
        }
    }

}

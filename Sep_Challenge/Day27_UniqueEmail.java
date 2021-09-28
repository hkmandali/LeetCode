import java.util.HashSet;

public class Day27_UniqueEmail {
    public int numUniqueEmails(String[] emails) {
        if(null == emails || 0 == emails.length)
            return 0;
        HashSet<String> uniqueset = new HashSet<>();
        int len = emails.length;
        for(int i=0;i<len;++i)
        {

            String curr = emails[i];
            String[] split= curr.split("@");
            String local = split[0];
            String domain= split[1];
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<local.length() && local.charAt(j) != '+';++j)
            {
                if(local.charAt(j) != '.')
                    sb.append(local.charAt(j));
            }
            System.out.println("sb is  "+sb +"  domain is  "+domain);
            uniqueset.add(sb+"@"+domain);
        }

        return uniqueset.size();
    }
    public static void main(String[] args) {
        System.out.println(new Day27_UniqueEmail().numUniqueEmails(new String[]{"test.email+alex@leetcode.com",
                "test.email.leet+alex@code.com"}));
    }
}

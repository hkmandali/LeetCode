import java.util.HashSet;

public class Day28_SortArraybyParity {
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
            uniqueset.add(sb+"@"+domain);
        }

        return uniqueset.size();
    }
}

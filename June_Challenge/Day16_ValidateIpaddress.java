class Solution {
    String isValidIpv4(String[] split)
    {
        
        for(int i=0;i<4;++i)
        {
           // System.out.println("first char is "+split[i].charAt(0));
            
            int leng = split[i].length();
            if(leng > 3)
                return "Neither";
            if(leng > 1 && 0 == (split[i].charAt(0) -'0'))
                return "Neither";
            for(int j=0;j<leng;++j)
            {
                int curr = split[i].charAt(j) - '0';    
                if(!(curr >=0 && curr <=9))
                    return "Neither";
            }       
            int whole = Integer.parseInt(split[i]);
            if(!(whole >=0 && whole <= 255))
                return "Neither";
        }
        
        return "IPv4";
    }
    String isValidIpv6(String[] split)
    {
        
        for(int i=0;i<8;++i)
        {
           // System.out.println("first char is "+split[i].charAt(0));
            if(4 < split[i].length())
                return "Neither";
            for(char c: split[i].toCharArray())
            {
                if(!((c >= '0' && c<='9') || (c >='a' && c<='f') || (c>='A' && c<='F')))
                    return "Neither";
            }
            
        }
        
        return "IPv6";
    }
    public String validIPAddress(String IP) {
        if(null == IP || 0 == IP.length())
            return "Neither";
        String[] split4 = IP.split("\\.+");
        //System.out.println("length is "+split4.length);
        
        if(IP.chars().filter(c -> c == '.').count() ==3)
        {
            if(4 == split4.length)
                return isValidIpv4(split4);
        }
        else if(IP.chars().filter(c -> c == ':').count() ==7){
            String[] split6 = IP.split(":+");
            //System.out.println("length is "+split6.length);
            if(8 == split6.length)
                return isValidIpv6(split6);
        }
        return "Neither";
    }
}
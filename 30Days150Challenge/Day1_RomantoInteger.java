public class Day1_RomantoInteger {
    public int romanToInt(String s) {
        int len = s.length();
        int res=0;
        for(int i=0;i<len;++i)
        {
            char c = s.charAt(i);
            switch(c)
            {
                case 'M':
                    res += 1000;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'C':
                    if(i< (len-1))
                    {
                        if(s.charAt(i+1) == 'D')
                        {
                            res += 400;
                            i++;
                        }
                        else if(s.charAt(i+1) == 'M')
                        {
                            res += 900;
                            i++;
                        }
                        else
                            res += 100;
                    }
                    else
                        res += 100;
                    break;
                case 'X':
                    if(i< (len-1))
                    {
                        if(s.charAt(i+1) == 'L')
                        {
                            res += 40;
                            i++;
                        }
                        else if(s.charAt(i+1) == 'C')
                        {
                            res += 90;
                            i++;
                        }
                        else
                            res += 10;
                    }
                    else
                        res += 10;
                    break;
                case 'I':
                    if(i< (len-1))
                    {
                        if(s.charAt(i+1) == 'V')
                        {
                            res += 4;
                            i++;
                        }
                        else if(s.charAt(i+1) == 'X')
                        {
                            res += 9;
                            i++;
                        }
                        else
                            res += 1;

                    }
                    else
                        res += 1;
                    break;
                default:
                    break;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}

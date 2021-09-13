public class Day08 {
    public String shiftingLetters(String s, int[] shifts) {
        int shiftlen = shifts.length;
        for(int i=shiftlen-2;i>=0;--i)
        {
            shifts[i] = (shifts[i]%26 + shifts[i+1]%26)%26;
        }
        char[] arr = s.toCharArray();
        for(int i=0;i<shiftlen;++i)
        {
            int replace = ((arr[i]-'a')+ shifts[i])%26;
            arr[i] = (char)(replace+97);
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        System.out.println("new string is "+new Day08().shiftingLetters("abc",new int[]{3,5,9}));
    }
}

public class Day14 {
    public String reverseOnlyLetters(String s) {
        if(null == s || "" == s)
        {
            return s;
        }
        char[] input = s.toCharArray();
        int len = input.length;
        int start=0,end=len-1;
        while(start < end)
        {
            if(!((input[start] >= 65 && input[start] <=90) || ( input[start] >= 97 && input[start] <=122) ))
            {
                start++;
            }
            else if(!((input[end] >= 65 && input[end] <=90) || ( input[end] >= 97 && input[end] <=122) ))
            {
                end--;
            }
            else
            {
                char temp = input[start];
                input[start] = input[end];
                input[end] = temp;
                start++;
                end--;
            }
        }
        return new String(input);
    }

    public static void main(String[] args) {
        System.out.println("the reversed string is "+new Day14().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}

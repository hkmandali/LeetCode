public class Day08_AddDigits {
    public int addDigits(int num) {
        if(0 == num)
            return 0;
        if(num % 9 == 0)
            return 9;
        else
            return num%9;

    }
}

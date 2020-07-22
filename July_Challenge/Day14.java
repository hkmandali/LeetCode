class Solution {
    public double angleClock(int hour, int minutes) {
        double mindegree = minutes *6;
        double hrdegree = hour * 30 + ((double)minutes)/2;
        double diff = Math.abs(mindegree - hrdegree);
        return Math.min(diff,360.0 - diff);
    }
}
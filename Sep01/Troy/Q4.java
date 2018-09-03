/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int middle = 0;
        while(start <= end) {
            middle = (end - start) / 2 + start;
            int res = guess(middle);
            if (res == 0) {
                break;
            } else if (res == 1) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return middle;
    }
}

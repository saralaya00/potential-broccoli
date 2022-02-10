class EvenDigitSum {
    public int countEven(int num) {
        int sum = 0;
        for (int i = num; i > 0 ; i--) {
            int digitSum = 0, n = i;
            while (n != 0) {
                digitSum += n % 10;
                n = n / 10;
            }
            sum += (digitSum % 2 == 0) ? 1 : 0;
        }
        
        return sum;
    }

package org.example;

public class HotAndCold {

    public static void main(String[] args)
    {
        HotAndCold hotAndCold = new HotAndCold();
        hotAndCold.testCases();
    }

    /**
     * Returns a hint for the guess based on the hidden number.
     *
     * @param hiddenStr The hidden number.
     * @param guessStr  The guess number.
     * @return A hint for the guess based on the hidden number.
     */
    public String getHint(String hiddenStr, String guessStr)
    {
        int[] digitFrequency = new int[10];
        int hotCount = 0;
        int coldCount = 0;

        for (int index = 0; index < hiddenStr.length(); index++) {
            int hiddenDigit = hiddenStr.charAt(index) - '0';
            int guessDigit = guessStr.charAt(index) - '0';

            if (hiddenDigit == guessDigit) {
                hotCount++;
            } else {
                if (digitFrequency[hiddenDigit] < 0) {
                    coldCount++;
                }
                if (digitFrequency[guessDigit] > 0) {
                    coldCount++;
                }
                digitFrequency[hiddenDigit]++;
                digitFrequency[guessDigit]--;
            }
        }

        StringBuilder hint = new StringBuilder();
        hint.append(hotCount).append("H").append(coldCount).append("C");
        return hint.toString();
    }

    public boolean assertHint(int caseNumber, String results, String expected)
    {
        boolean correct = results.equals(expected);
        System.out.println("Expected value = " + expected + " Actual value = " + results);
        System.out.println("Case " + caseNumber + " = " + (correct ? "passed" : "fail"));
        return results.equals(expected);
    }

    public void testCases()
    {
        String case1 = getHint("1807", "7810");
        assertHint(1, case1, "1H3C");

        String case2 = getHint("1807", "2805");
        assertHint(2, case2, "2H0C");

        String case3 = getHint("1807", "9807");
        assertHint(3, case3, "3H0C");

        String case4 = getHint("1807", "1807");
        assertHint(4, case4, "4H0C");

        String case5 = getHint("1234", "5678");
        assertHint(5, case5, "0H0C");

        String case6 = getHint("0000", "1111");
        assertHint(6, case6, "0H0C");

        String case7 = getHint("1111", "1112");
        assertHint(7, case7, "3H0C");

        String case8 = getHint("1111", "1234");
        assertHint(8, case8, "1H0C");

    }

}
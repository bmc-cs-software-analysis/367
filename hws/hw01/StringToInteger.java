public class StringToInteger {

    public static int parseInt(String str) throws NumberFormatException {
        if (str == null || str.isEmpty()) {
            throw new NumberFormatException("Input string is null or empty");
        }

        int result = 0;
        boolean isNegative = false;
        int i = 0;
        int len = str.length();

        // Check if the first character is a minus sign for negative numbers
        if (str.charAt(0) == '-') {
            isNegative = true;
            i++;
        }

        // Iterate over the remaining characters
        while (i < len) {
            char c = str.charAt(i);

            // Check if the character is a digit
            if (c >= '0' && c <= '9') {
                result = result * 10 + (c - '0');
            } else {
                throw new NumberFormatException("Invalid character found: " + c);
            }

            i++;
        }

        return isNegative ? -result : result;
    }

}

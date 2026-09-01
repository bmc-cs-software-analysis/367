public class BuyTicket {

    public static boolean isMinor(int age) {
        return age < 18;
    }


    public static boolean isSenior(int age) {
        return age > 65;
    }

    /**
     * Calculates discount based on customer age and number of days until event
     * @param basePrice Base price of the ticket without any discount
     * @param daysUntilEvent Number of days remaining until the event day
     * @param customerAge Age of the customer
     * @param isMember Boolean indicating if the custsomer is a member
     * @return ticket price discounted based on number of days remaining and potential age and membership discount
     */

    public static double calculatePrice(int basePrice, int daysUntilEvent, int customerAge, boolean isMember) {
        double maxDiscount = basePrice - 100;

        double discountRate = daysUntilEvent / maxDiscount; // BUG 1: potential division by zero
        
        if (isMember) discountRate += .10;

        if (isSenior(customerAge)) {
            discountRate += (customerAge - 65) / maxDiscount; 
        } else if (isMinor(customerAge)) {
            discountRate += (18 - customerAge) / maxDiscount; 
        }

        return basePrice - (basePrice * discountRate);
    }
}

public class BuyTicket {

    
    public static double calculatePrice(int basePrice, int daysUntilEvent, int customerAge, boolean isMember) {
        double maxDiscount = basePrice - 100;

        double discountRate = daysUntilEvent / maxDiscount; 

        if (isMember) discountRate += .10;

        if (customerAge > 65) {
            discountRate += (customerAge - 65) / maxDiscount; 
        } else if (customerAge < 18) {
            discountRate += (18 - customerAge) / maxDiscount; 
        }

        return basePrice - (basePrice * discountRate);
    }
}

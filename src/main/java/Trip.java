public class Trip {
    String city;
    int price;
    int adultCount;
    int childCount;
    int adultBags;
    int childBags;
    int vat;

    public Trip(String city, int price, int adultCount, int childCount, int adultBags, int childBags, int vat) {
        this.city = city;
        this.price = price;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.adultBags = adultBags;
        this.childBags = childBags;
        this.vat = vat;
    }

    public double getAdultPrice() {
        double sumBeforeVat = price * adultCount;
        double taxRate = 1 + (double) vat / 100;
        return sumBeforeVat * taxRate;
    }

    public double getBagPrice(int bagCount) {
        double bagPrice = price * 0.3;
        double taxRate = 1 + (double) vat / 100;
        return  bagPrice * (double) bagCount * taxRate;
    }

    public double getChildPrice() {
        double sumBeforeVat = price * childCount * 0.5;
        double taxRate = 1 + (double) vat / 100;
        return sumBeforeVat * taxRate;
    }

    public double getTotal() {
        return getAdultPrice() + getBagPrice(adultBags) + getChildPrice() + getBagPrice(childBags);
    }


    public void printTotal() {
        System.out.println("Ticket prices: ");
        System.out.println("o Adult (" + price + " EUR + " + vat + " %) = " + getAdultPrice() + " EUR");
        if (adultBags > 0) {
            System.out.println("o " + adultBags + " bags ("+ price + " EUR + " + "x 30% + " + vat + " %) = " + getBagPrice(adultBags)  + " EUR");
        }
        if (childCount > 0) {
            System.out.println("o Children (" + price + " EUR x 50% +" + vat + " %) = " + getChildPrice() + " EUR");
        }
        if (childBags > 0) {
            System.out.println("o " + childBags + " bags ("+ price + " EUR + " + "x 30% + " + vat + " %) = " + getBagPrice(childBags)  + " EUR");
        }
        System.out.println("Total price = " + getTotal());
    }

}

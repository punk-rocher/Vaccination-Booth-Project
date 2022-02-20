public class Booth extends Patient {

    private String customerName;
    private int vaccineStock;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setVaccineStock(int vaccineStock) {
        this.vaccineStock = vaccineStock;
    }

    public int getVaccineStock() {
        return vaccineStock;
    }
}

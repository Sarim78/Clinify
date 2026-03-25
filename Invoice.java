import java.util.Date;

public class Invoice {

    private int paymentID;
    private String paymentMethod;
    private String paymentStatus;
    private Date transactionDate;

    public Invoice(int paymentID, String paymentMethod, String paymentStatus, Date transactionDate) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.transactionDate = transactionDate;
    }

    public void generateInvoice() {
        System.out.println("Invoice generated with ID: " + paymentID);
    }

    public void processPayment() {
        this.paymentStatus = "Paid";
        System.out.println("Payment processed successfully.");
    }

    public void cancelPayment() {
        this.paymentStatus = "Cancelled";
        System.out.println("Payment has been cancelled.");
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void sendReceipt() {
        System.out.println("Receipt sent for payment ID: " + paymentID);
    }

    public int getPaymentID() {
        return paymentID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
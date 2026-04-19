class PaymentProcessor {
  
    private String paymentType;
    private double monto;
    
    public PaymentProcessor(String paymentType, double monto){
        this.paymentType = paymentType;
        this.monto = monto;
    }
    
    public void metodoPago(String paymentType, double monto) {  
        switch (paymentType) {
          case "CREDIT_CARD":
              processCreditCardPayment(monto);
              break;
          case "PAYPAL":
              processPaypalPayment(monto);
              break;
          case "CASH":
              processCashPayment(monto);
              break;
          default:
              throw new IllegalArgumentException("Método de pago no soportado");
        }
    }
}

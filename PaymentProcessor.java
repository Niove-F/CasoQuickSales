class PaymentProcessor {
  
    private String paymentType;
    
    public PaymentProcessor(String paymentType){
        this.paymentType = paymentType;
    }
    
    public void metodoPago(double monto) {  
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

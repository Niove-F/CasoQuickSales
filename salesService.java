public class SaleService {
  
  public void processSale(String DNI, String paymentType, double amount, String email) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Monto inválido");
    }
    
    CheckCustomerDiscount discountChecker = new CheckCustomerDiscount(DNI);
    double discount = discountChecker.calcularDescuento(amount);

    double finalAmount = amount - discount;

    PaymentProcessor procesarPago = new PaymentProcessor(paymentType);
    procesarPago.metodoPago(finalAmount);

    RegisterSale register = new RegisterSale();
    register.registerSale(customerType, paymentType, finalAmount);
    System.out.println("Guardando venta en base de datos");

    String report = "Venta registrada. Cliente: " + customerType +  ", Total: " + finalAmount;
    generateSaleReport();
    System.out.println("Generando reporte: " + report);

    EmailValidator validarEmail = new EmailValidator(email);
    validarEmail.send(email, DNI, finalAmount);
      
  }
  
}

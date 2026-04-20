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

    RegisterSale register = new RegisterSale(DNI, paymentType, finalAmount);
    register.registerSale();
    System.out.println("Guardando venta en base de datos");

    String report = register.generateSaleReport();

    System.out.println("Generando reporte: " + report);

    EmailValidator validarEmail = new EmailValidator(email);
    validarEmail.send(email, DNI, finalAmount);
      
  }
  
}

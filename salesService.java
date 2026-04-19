public class SaleService {
  public void processSale(String customerType, String paymentType, double amount, String email) {
    if (amount <= 0) {
      System.out.println("Monto inválido");
      return;
    }
    double discount = 0;
    if (customerType.equals("REGULAR")) {
      discount = amount * 0.05;
    } else if (customerType.equals("VIP")) {
      discount = amount * 0.10;
    } else if (customerType.equals("EMPLOYEE")) {
      discount = amount * 0.15;
    }

    if (customerType.equals("VIP") && amount > 1000) {
      discount = amount * 0.15;
    }

    if (email == null) {
      System.out.println("Email no proporcionado");
    }

    double finalAmount = amount - discount;

    if (paymentType.equals("CREDIT_CARD")) {
           processCreditCardPayment();
           System.out.println("Procesando pago con tarjeta de crédito");
    } else if (paymentType.equals("PAYPAL")) {
           processPaypalPayment();
           System.out.println("Procesando pago con PayPal");
    } else if (paymentType.equals("CASH")) {
           processCashPayment();
           System.out.println("Procesando pago en efectivo");
    } else {
           System.out.println("Método de pago no soportado");
           return;
    }

    RegisterSale register = new RegisterSale();
    register.registerSale(customerType, paymentType, finalAmount);
    System.out.println("Guardando venta en base de datos");

    String report = "Venta registrada. Cliente: " + customerType +  ", Total: " + finalAmount;
    generateSaleReport();
    System.out.println("Generando reporte: " + report);

    if (email != null && !email.isEmpty()) {
      sendEmailNotification();
      System.out.println("Enviando correo a: " + email);
    }

    System.out.println("Proceso completado");
  }
}

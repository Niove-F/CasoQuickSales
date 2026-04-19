class PaymentProcessor {


    public void pagar(String tipoPago, double monto) {
        switch (tipoPago) {
            case "CREDIT_CARD":
                System.out.println("Procesando pago con tarjeta de credito: S/. " + monto);
                break;
            case "PAYPAL":
                System.out.println("Procesando pago con PayPal: S/. " + monto);
                break;
            case "CASH":
                System.out.println("Procesando pago en efectivo: S/. " + monto);
                break;
            case "YAPE":
                System.out.println("Procesando pago con Yape: S/. " + monto);
                break;
            default:
                System.out.println("Metodo de pago no soportado: " + tipoPago);
        }
    }
}

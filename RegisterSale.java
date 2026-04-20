class RegisterSale {

    private String DNI;
    private String paymentType;
    private double amount;

    public RegisterSale(String DNI, String paymentType, double amount) {
        this.DNI = DNI;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public void registerSale() {
        DatabaseManager db = new DatabaseManager();
        db.insertRow("sales", "'" + DNI + "', '" + paymentType + "', " + amount);
    }

    public String generateSaleReport() {
        String report = "Reporte de venta: Cliente: " + DNI + ", Método de pago: " + paymentType + ", Monto: " + amount;
        return report;
    }
}
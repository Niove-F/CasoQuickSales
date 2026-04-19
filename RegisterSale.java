class RegisterSale {

    public void registerSale(String customerType, String paymentType, double amount) {
        DatabaseManager db = new DatabaseManager();
        db.insertRow("sales", "'" + customerType + "', '" + paymentType + "', " + amount);
    }
}
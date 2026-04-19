class CheckCustomerDiscount {

    private String customerDNI;

    public CheckCustomerDiscount(String customerDNI) {
        this.customerDNI = customerDNI;
    }

 
    public float calcularDescuento(double monto) {
        String[] cliente = buscarClientePorDNI(customerDNI);
        
        int filaTipoCliente = 5;
        String tipoCliente = cliente[filaTipoCliente]; 

        switch (tipoCliente) {
            case "REGULAR" -> {
                return 0.05f;
            }
            case "VIP" -> {
                if (monto > 1000) return 0.15f;
                return 0.10f;
            }
            case "EMPLOYEE" -> {
                return 0.15f;
            }
            default -> {
                return 0.0f;
            }
        }
    }


    private String[] buscarClientePorDNI(String dni) {
        DatabaseManager db = new DatabaseManager();
        String[] filaPorDni = db.getRow("customers", "dni = '" + dni + "'");
        return filaPorDni;
    }
}

class CheckCustomerDiscount {

    private String customerDNI;

    public CheckCustomerDiscount(String customerDNI) {
        this.customerDNI = customerDNI;
    }

 
    public float calcularDescuento(double monto) {
        String tipoCliente = buscarClientePorDNI(customerDNI);

        switch (tipoCliente) {
            case "REGULAR":   return 0.05f;
            case "VIP":
                if (monto > 1000) return 0.15f;
                return 0.10f;
            case "EMPLOYEE":  return 0.15f;
            default:          return 0.0f;
        }
    }


    private String buscarClientePorDNI(String dni) {
        if (dni.equals("12345678")) return "VIP";
        if (dni.equals("87654321")) return "EMPLOYEE";
        return "REGULAR";
    }
}

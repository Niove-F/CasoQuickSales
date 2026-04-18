# CasoQuickSales
### Tarea grupal 1 – Diseño de Patrones de Software

**TO DO:**
- Clase CheckCustomerDiscount(string DNI)  → Busca en BD el dni del cliente, retorna un float deacuerdo al tipo de cliente → Se usa para discount = amount*X
- String customerDNI → se define llamando a otra clase para identificar que tipo de descuento se le aplica y devuelve el monto de descuento fijo como porcentaje
- Clase PaymentProcessor → Procesa el pago de acuerdo a su tipo
- Clase PaymentTypeIdentifier → Identifica el tipo de pago, verificando que no este vacio y llama a PaymentProcessor con los parametros acordes
- Reemplazar SaveSale() por su una clase RegisterSale que acceda a la clase encargada de manejar la BD
- Una clase que aplique regex para verificar sintaxis del correo

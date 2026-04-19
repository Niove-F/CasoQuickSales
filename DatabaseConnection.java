
import java.sql.Connection;

class DatabaseConnection{
    String host = "localhost";
    String database = "quicksales";
    String user = "admin";
    String password = "admin123";
    Connection conn;
    public void connect() {
        System.out.println("Conectando a la base de datos...");
        try {
            conn = java.sql.DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public void disconnect() {
        System.out.println("Desconectando de la base de datos...");
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar de la base de datos: " + e.getMessage());
        }
    }
    public void executeQuery(String query) {
        System.out.println("Ejecutando consulta: " + query);
        try {
            conn.createStatement().execute(query);
        } catch (Exception e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }
    
}
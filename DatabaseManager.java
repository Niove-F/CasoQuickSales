class DatabaseManager {
    
    private DatabaseConnection connection;

    public DatabaseManager() {
        this.connection = new DatabaseConnection();
    }

    public void insertRow(String table, String values) {
        connection.connect();
        String query = "INSERT INTO " + table + " VALUES (" + values + ")";
        connection.executeQuery(query);
        connection.disconnect();
    }
    public void editRow(String table, String setClause, String whereClause) {
        connection.connect();
        String query = "UPDATE " + table + " SET " + setClause + " WHERE " + whereClause;
        connection.executeQuery(query);
        connection.disconnect();
    }
    public void deleteRow(String table, String whereClause) {
        connection.connect();
        String query = "DELETE FROM " + table + " WHERE " + whereClause;
        connection.executeQuery(query);
        connection.disconnect();
    }
    public String[] getRow(String table, String whereClause) {
        connection.connect();
        String query = "SELECT * FROM " + table + " WHERE " + whereClause;
        String[] data = connection.query(query);
        connection.disconnect();
        return data;
    }

}
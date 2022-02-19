package DataAcess;

import Entities.Client;
import com.mycompany.layers_java.Config;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Progra
 */
public class ClientDAO {

    private Connection _cnn = null;

    private String msj = "";

    public ClientDAO() throws SQLException, Exception {
        String url = Config.getConnectionString();
        try {
            _cnn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new Exception("Error generico:" + ex.getMessage());
        }
    }

    /**
     * Método que lista de forma ordenada a los clientes que se soliciten
     *
     * @param condition - Condicion en formato SQL para filtrar la consulta.
     * @param order - Condicion en formato SQL para ordenar la consulta.
     * @return ResultSet con todos los registros obtenidos en la consulta.
     * @throws java.sql.SQLException
     */
    public ResultSet listAll(String condition, String order) throws SQLException, Exception {
        ResultSet rs = null;
        String query = "Select id_client,name, phone, direction from Clients";
        if (!condition.equals("")) {
            query = String.format("%s Where %s", query, condition);
        }
        if (!order.equals(order)) {
            query = String.format("%s Order By %s", query, condition);
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return rs;
    }

    public Client getOne(String condition) throws SQLException, Exception {
        Client client = new Client();
        ResultSet rs = null;
        String query = "Select id_client,name, phone, direction from Clients";
        if (!condition.equals("")) {
            query = String.format("%s Where %s", query, condition);
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);

            if (rs != null && rs.next()) {
                client.setId_client(rs.getInt(1));
                client.setName(rs.getString(2));
                client.setPhone(rs.getString(3));
                client.setDireccion(rs.getString(4));
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return client;
    }

    public List<Client> listAll(String condition) throws SQLException, Exception {
        ResultSet rs = null;
        List<Client> list = null;
        String query = "Select id_client,name, phone, direction from Clients";
        if (!condition.equals("")) {
            query = String.format("%s Where %s", query, condition);
        }
        try {
            Statement statement = _cnn.createStatement();
            rs = statement.executeQuery(query);
            while (rs != null && rs.next()) {
                list.add(new Client(rs.getInt("id_client"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("direction")
                ));
            } // FIN WHILE.
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return list;
    }

    public int insert(Client client) throws SQLException, Exception {
        int result = -1;
        try {

            ResultSet rs = null;
            String query = "INSERT INTO Clients(name, phone, direction) VALUES(?,?,?)";
            PreparedStatement ps = _cnn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getName());
            ps.setString(2, client.getPhone());
            ps.setString(3, client.getDireccion());
            ps.execute(query);
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                result = rs.getInt(1);
                msj = "Cliente almacenado con exito";
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return result;
    }

    public int update(Client client) throws SQLException, Exception {
        int result = -1;
        try {
            String query = "UPDATE Clients SET name = ?, phone = ?, direction =? WHERE id_cliente = ?";
            PreparedStatement ps = _cnn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getName());
            ps.setString(2, client.getPhone());
            ps.setString(3, client.getDireccion());
            ps.setInt(4, client.getId_client());
            result = ps.executeUpdate(query);
            msj = "Cliente actualizado con exito";
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return result;
    }

    public int delete(Client client) throws SQLException, Exception {
        int result = -1;
        try {
            String query = String.format("DELETE FROM Clients WHERE id_cliente = %d", client.getId_client());
            PreparedStatement ps = _cnn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getName());
            ps.setString(2, client.getPhone());
            ps.setString(3, client.getDireccion());
            ps.setInt(4, client.getId_client());
            result = ps.executeUpdate(query);
            msj = "Cliente eliminado con exito";
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return result;
    }

    public String getMsj() {
        return msj;
    }
}

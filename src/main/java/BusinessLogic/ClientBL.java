package BusinessLogic;

import Entities.Client;
import DataAcess.ClientDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Progra
 */
public class ClientBL {

    private String msj = "";

    public String getMsj() {
        return msj;
    }
    private ClientDAO _dAClient;

    public ClientBL() {
        this.msj = "";
    }

    public ResultSet listAll(String condition, String order) throws SQLException, Exception {
        ResultSet rs = null;
        try {
            _dAClient = new ClientDAO();
            rs = _dAClient.listAll(condition, order);
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        }
        return rs;
    }

    public List<Client> listAll(String condition) throws SQLException, Exception {
        List<Client> lista = null;
        try {
            _dAClient = new ClientDAO();
            lista = _dAClient.listAll(condition);
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        }
        return lista;
    }

    public Client getOne(String condition) throws SQLException, Exception {
        Client client = null;
        try {
            _dAClient = new ClientDAO();
            client = _dAClient.getOne(condition);
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        }
        return client;
    }

    public int insert(Client client) throws SQLException, Exception {
        int result = -1;
        try {
            _dAClient = new ClientDAO();
            result = _dAClient.insert(client);
            msj = _dAClient.getMsj();
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    public int update(Client client) throws SQLException, Exception {
        int result = -1;
        try {
            _dAClient = new ClientDAO();
            result = _dAClient.update(client);
            msj = _dAClient.getMsj();
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    public int delete(Client client) throws SQLException, Exception {
        int result = -1;
        try {
            _dAClient = new ClientDAO();
            result = _dAClient.delete(client);
            msj = _dAClient.getMsj();
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

}

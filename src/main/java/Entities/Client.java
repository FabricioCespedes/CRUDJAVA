/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Progra
 */
public class Client {
    private int id_client;
    private String name;
    private String direccion;
    private String phone;
    private boolean exist;

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public Client(int id_client, String name, String direccion, String phone) {
        this.id_client = id_client;
        this.name = name;
        this.direccion = direccion;
        this.phone = phone;
        this.exist = true;
    }

    public Client() {
       id_client = 0;
       name = "";
       direccion = "";
       phone = "";
       exist = false;
    }
}

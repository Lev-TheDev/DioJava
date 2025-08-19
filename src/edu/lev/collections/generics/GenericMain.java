package edu.lev.collections.generics;

import edu.lev.collections.generics.dao.ClientDAO;
import edu.lev.collections.generics.dao.GenericDAO;
import edu.lev.collections.generics.dao.UserDAO;
import edu.lev.collections.generics.domain.ClientDomain;
import edu.lev.collections.generics.domain.UserDomain;

public class GenericMain {
    private final static GenericDAO<Integer, UserDomain> userDAO = new UserDAO();
    private final static GenericDAO<String, ClientDomain> clientDAO = new ClientDAO();


    public static void main(String[] args) {
        System.out.println("======= USER DAO =======");
        var user = new UserDomain(1, "Levi", 30);
        System.out.println(userDAO.count());
        System.out.println(userDAO.save(3, user, new UserDomain(2, "Tom", 32), new UserDomain(3, "Cris", 34)));
        System.out.println(userDAO.findAll());
        System.out.println(userDAO.find(d -> d.getId().equals(1)));
        System.out.println(userDAO.count());
        System.out.println(userDAO.delete(user));
        System.out.println(userDAO.findAll());
        System.out.println(userDAO.count());
        System.out.println("======= CLIENT DAO =======");

        var client = new ClientDomain("Maria", 21, "A");
        System.out.println(clientDAO.count());
        System.out.println(clientDAO.save(1, client));
        System.out.println(clientDAO.findAll());
        System.out.println(clientDAO.find(d -> d.getId().equals("A")));
        System.out.println(clientDAO.count());
        System.out.println(clientDAO.delete(client));
        System.out.println(clientDAO.findAll());
        System.out.println(clientDAO.count());



    }
}

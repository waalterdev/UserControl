package org.userControl;

public class Main {
    public static void main(String[] args) {
        // Iniciando gerenciador de usuários
        UserManagement userManagement = new UserManagement();

        // Adicionando dois usuários
        userManagement.addUser(new User("John", "Martin", "12345678901"));
        userManagement.addUser(new User("John", "Doe", "12345678902"));
        
        System.out.println(userManagement.findUserByCPF("12345678903"));
    }
}
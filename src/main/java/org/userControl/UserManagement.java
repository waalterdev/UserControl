package org.userControl;

import java.util.ArrayList;

public class UserManagement {
    private ArrayList<User> users;

    public UserManagement() {
        users = new ArrayList<>();
        System.out.println("Gerenciador de usuários iniciado...");
    }

    // Funções de tratamento de usuário

    public User addUser(User newUser) {
        boolean validCPF = cpfValidation(newUser.getCpf());
        boolean userExists = userExists(newUser.getCpf());

        if (!validCPF) {
            throw new IllegalArgumentException(String.format("CPF inválido: %s", newUser.getCpf()));
        }

        if (userExists) {
            throw new IllegalArgumentException(String.format("Usuário já existe."));
        }

        users.add(newUser);
        return newUser;
    }

    // Funções de consulta

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findUserByCPF(String cpf) {
        boolean validCPF = cpfValidation(cpf);

        if (!validCPF) {
            throw new IllegalArgumentException(String.format("CPF inválido: %s", cpf));
        }

        return users.stream()
        .filter(user -> user.getCpf().equals(cpf))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(String.format("Usuário com CPF %s não encontrado.", cpf)));
    }

    public ArrayList<User> findUsersByFirstname(String firstname) {

        if (firstname == null || firstname.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        ArrayList<User> foundUsers = new ArrayList<>();

        for (User user : users) {
            if (user.getFirstname().equals(firstname)) {
                foundUsers.add(user);
            }
        }

        if (foundUsers.size() > 0) {
            return foundUsers;
        } else {
            System.out.println(String.format("Não há usuários com o nome \"%s\".", firstname));
            return null;
        }
    }

    // Funções de validação

    private boolean cpfValidation(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        return cpf.matches("\\d{11}");
    }

    private boolean userExists(String cpf) {
        return users.stream().anyMatch(user -> user.getCpf().equals(cpf));
    }
}

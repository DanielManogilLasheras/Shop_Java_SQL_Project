package model;

public class Client {
    private int clientId;
    private String name,surname, email;
    private int age;
    private String password;

    public Client() {
    }
    public Client(int clientId, String name, String surname, String email, int age) {
        this.clientId=clientId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.password = password;
    }
    public Client(String name, String surname, String email, int age, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public int getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}

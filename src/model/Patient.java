package model;

public class Patient {
    private String id;
    private String name;
    private int age;
    private String sex;
    private int priorityValue;

    public Patient(String id, String name, int age, String sex, int priorityValue) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.priorityValue = priorityValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPriorityValue() {
        return priorityValue;
    }

    public void setPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
    }

    public String printInformation() {
        String information = "" +
                "******* PACIENTE *******\n" +
                "*   Id: " + id + "\n"+
                "*   Nombre: " + name + "\n"+
                "*   Genero: " + sex + "\n"+
                "*   Edad: " + age + "\n" +
                "*   Prioridad: " + priorityValue + "\n";
        return information;
    }

}

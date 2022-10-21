package ui;
import model.IPS_Manager;

import java.util.Scanner;

public class Main {
    private Scanner sc;
    private IPS_Manager controller;

    public Main() {
        sc= new Scanner(System.in);
        controller = new IPS_Manager();
    }

    public static void main(String[] args) throws Exception {

        Main ppal= new Main();

        int option=0;

        do{
            option= ppal.showMenu();
            ppal.executeOperation(option);

        }while (option!=0);

    }

    public int showMenu() {
        int option=0;
        System.out.println(
                "Select an option to start\n" +
                        "(1) Registrar paciente \n" +
                        "(2) Ingresar a la cola\n"+
                        "(3) Sacar de la cola\n"+
                        "(4) Deshacer\n" +
                        "(5) Mostrar pacientes en la Cola\n" +
                        "(0) Exit"
        );
        option= sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void executeOperation(int operation) throws Exception {

        switch(operation) {
            case 0:
                System.out.println("Cerrando Programa");
                break;
            case 1:
                startSystemIPS();
                searchPatientInDateBase();
                break;
            case 2:
                addToQueue();
                break;
            case 3:
                removeFromQueue();
                break;
            case 4:
                undo();
                break;
            case 5:
                showPatients();
                break;

            case 6:

                break;

            default:
                System.out.println("Error, opcion invalilda");

        }
    }

    public void startSystemIPS(){
        controller.startSystem();
    }
    public void searchPatientInDateBase() throws Exception {

        System.out.println("Ingrese la CC o TI del paciente");
        String id = sc.next();
        sc.nextLine();
        if (controller.searchPatient(id)==false){
            System.out.println("***EL PACIENTE NO EXISTE***");

            System.out.println("Ingrese el nombre del paciente");
            String name = sc.nextLine();
            System.out.println("Ingrese la edad del paciente");
            int age  = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el genero del paciente (Masculino o Femenino)");
            String sex = sc.next();
            sc.nextLine();
            System.out.println("Ingrese el turno de prioridad del paciente");
            int priorityValue = sc.nextInt();
            sc.nextLine();
            controller.addPatientToSystem(id,name,age,sex,priorityValue);
        }else {
            System.out.println("El paciente ya se encuentra registrado");
        }
    }

    public void addToQueue() {

        System.out.println("Ingrese el id del paciente:");
        String id = sc.nextLine();
        if(controller.searchPatient(id) == false) {
            System.out.println("El paciente no se encuentra en el sistema");
        } else {
            System.out.println("Ingrese la unidad a la que va a ingresar el paciente \n 1.Hematologia \n 2.Proposito general");
            int option = Integer.parseInt(sc.nextLine());
            controller.addPatientToQueue(id, option);
        }
    }

    public void removeFromQueue() {

        System.out.println("Ingrese la unidad en la que se encuentra el paciente \n 1.Hematologia \n 2.Proposito general");
        int option = Integer.parseInt(sc.nextLine());
        System.out.println(controller.removeFromQueue(option));
    }

    public void showPatients() {

        System.out.println("Ingrese la unidad de la que desea ver la cola \n 1.Hematologia \n 2.Proposito general");
        int option = Integer.parseInt(sc.nextLine());
        System.out.println(controller.showPatients(option));
    }

    private void undo() {

        System.out.println("Ingrese la unidad en la que desea deshacer lo hecho \n 1.Hematologia \n 2.Proposito general");
        int option = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese que desea deshacer \n 1.Turno \n 2.Salida");
        int option2 = Integer.parseInt(sc.nextLine());

        System.out.println(controller.undo(option,option2));
    }
}



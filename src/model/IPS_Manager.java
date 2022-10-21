package model;


import model.Implementations.*;


import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class IPS_Manager {

    private ChainHashTable<String,Patient> pacientes;

    private Section hematologySection;
    private Section generalPurposeSection;
    ArrayList<Patient> paciente = new ArrayList<>();

    public IPS_Manager() {
        pacientes = new ChainHashTable<>(100);
        hematologySection = new Section();
        generalPurposeSection = new Section();
    }

    public void startSystem(){
        File file = new File("Base de datos.txt");
        //System.out.println(file.exists());
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fis)
            );
            String line;
            //reader.readLine();
            while(( line = reader.readLine()) != null){
                //System.out.println(line);
                String separator = Pattern.quote("|");
                String[] parts = line.split(separator);
                Patient p = new Patient(parts[0], parts[1],Integer.parseInt(parts[2]), parts[3], Integer.parseInt(parts[4]));
                paciente.add(p);
                pacientes.insert(parts[0],p);

            }
            fis.close();
            System.out.println("Database loaded successfully");
            //System.out.println("Tamano del arreglo: "+paciente.size());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean searchPatient(String key){
        return pacientes.search(key) !=null;
    }

    public void addPatientToSystem( String id, String name, int age, String sex, int priorityValue) throws Exception {
        Patient pt = new Patient(id,name,age,sex,priorityValue);
        pacientes.insert(id,pt);

        String text = "";
        File file = new File("Base de datos.txt");
        try {
            text += id + "|" + name + "|" + age + "|" + sex + "|" + priorityValue + "\n";
            System.out.println(text);
            BufferedWriter bwWrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"utf-8"));
            bwWrite.write(text);
            bwWrite.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void addPatientToQueue(String id, int option) {

        Patient patient = pacientes.search(id);

        if(option == 1) {
            hematologySection.enqueue(patient.getPriorityValue(),patient);
            hematologySection.setLastAdd(patient);
        } else {
            generalPurposeSection.enqueue(patient.getPriorityValue(),patient);
            generalPurposeSection.setLastAdd(patient);
        }
    }


    public String removeFromQueue(int option) {
        Patient patient;

        if(option == 1) {
            patient = hematologySection.removeFromQueue();
            hematologySection.setLastExit(patient);
        } else {
            patient = generalPurposeSection.removeFromQueue();
            hematologySection.setLastExit(patient);
        }

        return patient.printInformation();
    }

    public String showPatients(int option) {

        if(option == 1) {
            return hematologySection.showElements();
        } else {
            return generalPurposeSection.showElements();
        }
    }

    public String undo(int option, int option2) {

        if(option == 1) {
            return undoHematology(option2);
        } else {
            return undoGeneralPurpose(option2);
        }
    }

    public String undoHematology(int option2) {

        if(option2 == 1) {
            return removeFromQueue(1) + "\n Undid successfully";
        } else {
            addPatientToQueue(hematologySection.getLastExit().getId(),1);
            return "Undid successfully";
        }

    }

    public String undoGeneralPurpose(int option) {

        if(option == 1) {
            return removeFromQueue(2) + "\n Undid successfully";
        } else {
            addPatientToQueue(generalPurposeSection.getLastExit().getId(),2);
            return "Undid successfully";
        }

    }








}

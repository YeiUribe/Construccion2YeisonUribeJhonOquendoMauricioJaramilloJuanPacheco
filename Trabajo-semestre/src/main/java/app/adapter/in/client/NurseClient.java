package app.adapter.in.client;

import app.adapter.in.builder.PatientVitalsBuilder;
import app.application.usecases.NurseUseCase;
import app.domain.model.PatientVitals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class NurseClient {

    private static final String MENU = "Rol: Enfermería \n"
            + "1. Registrar Signos Vitales de Paciente\n"
            + "2. Salir";
    private static Scanner reader = new Scanner(System.in);

    @Autowired
    private NurseUseCase nurseUseCase;
    @Autowired
    private PatientVitalsBuilder patientVitalsBuilder;

    public void session() {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    private boolean menu() {
        try {
            System.out.println(MENU);
            String option = reader.nextLine();
            switch (option) {
                case "1": {
                    PatientVitals vitals = readVitalsData();
                    nurseUseCase.recordPatientVitals(vitals);
                    System.out.println("Signos vitales registrados exitosamente.");
                    return true;
                }
                case "2":
                    return false;
                default:
                    System.out.println("Opción no válida.");
                    return true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return true;
        }
    }

    private PatientVitals readVitalsData() throws Exception {
        System.out.println("Ingrese Cédula del Paciente:");
        String patientId = reader.nextLine();
        System.out.println("Ingrese Presión Arterial (ej: 120/80):");
        String pressure = reader.nextLine();
        System.out.println("Ingrese Temperatura (ej: 37.5):");
        String temp = reader.nextLine();
        System.out.println("Ingrese Pulso (ej: 80):");
        String pulse = reader.nextLine();
        System.out.println("Ingrese Nivel de Oxígeno (ej: 98.0):");
        String oxygen = reader.nextLine();

        return patientVitalsBuilder.build(patientId, pressure, temp, pulse, oxygen);
    }
}
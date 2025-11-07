package app.adapter.in.client;

import app.adapter.in.builder.ClinicalOrderBuilder;
import app.adapter.in.builder.ClinicalRecordBuilder;
import app.application.usecases.DoctorUseCase;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class DoctorClient {

    private static final String MENU = "Rol: Médico \n"
            + "1. Iniciar Historia Clínica (Consulta)\n"
            + "2. Crear Orden Clínica\n"
            + "3. Registrar Hospitalización\n"
            + "4. Salir";
    private static Scanner reader = new Scanner(System.in);

    @Autowired
    private DoctorUseCase doctorUseCase;
    @Autowired
    private ClinicalRecordBuilder clinicalRecordBuilder;
    @Autowired
    private ClinicalOrderBuilder clinicalOrderBuilder;

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
                    ClinicalRecord record = readClinicalRecordData();
                    System.out.println("Nota: Los signos vitales deben ser registrados por la enfermera.");
                    // En un flujo real, buscaríamos los vitales. Aquí asumimos que se pasan nulos.
                    doctorUseCase.createNewClinicalRecord(record, null);
                    System.out.println("Historia Clínica registrada.");
                    return true;
                }
                case "2": {
                    ClinicalOrder order = readClinicalOrderData();
                    System.out.println("Añada ítems a la orden (lógica no implementada).");
                    // Lógica para añadir Medicamentos, Procedimientos...
                    doctorUseCase.createNewClinicalOrder(order);
                    System.out.println("Orden Clínica creada.");
                    return true;
                }
                case "3": {
                    System.out.println("Función de hospitalización no implementada.");
                    return true;
                }
                case "4":
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

    private ClinicalRecord readClinicalRecordData() throws Exception {
        System.out.println("Ingrese Cédula del Paciente:");
        String patientId = reader.nextLine();
        System.out.println("Ingrese Cédula del Médico (usted):");
        String doctorId = reader.nextLine();
        System.out.println("Ingrese Motivo de la Consulta:");
        String reason = reader.nextLine();
        System.out.println("Ingrese Síntomas:");
        String symptoms = reader.nextLine();
        System.out.println("Ingrese Diagnóstico:");
        String diagnosis = reader.nextLine();

        return clinicalRecordBuilder.build(patientId, doctorId, reason, symptoms, diagnosis);
    }

    private ClinicalOrder readClinicalOrderData() throws Exception {
        System.out.println("Ingrese Cédula del Paciente:");
        String patientId = reader.nextLine();
        System.out.println("Ingrese Cédula del Médico (usted):");
        String doctorId = reader.nextLine();

        return clinicalOrderBuilder.build(patientId, doctorId);
    }
}

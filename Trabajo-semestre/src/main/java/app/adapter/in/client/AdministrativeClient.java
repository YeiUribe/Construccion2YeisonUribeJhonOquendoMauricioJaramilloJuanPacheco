package app.adapter.in.client;

import app.adapter.in.builder.PatientBuilder;
import app.application.usecases.AdministrativeUseCase;
import app.domain.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class AdministrativeClient {

    private static final String MENU = "Rol: Personal Administrativo \n"
            + "1. Registrar Paciente\n"
            + "2. Generar Factura\n"
            + "3. Salir";
    private static Scanner reader = new Scanner(System.in);

    @Autowired
    private AdministrativeUseCase administrativeUseCase;
    @Autowired
    private PatientBuilder patientBuilder;

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
                    Patient patient = readPatientData();
                    administrativeUseCase.registerNewPatient(patient);
                    System.out.println("Paciente registrado exitosamente.");
                    return true;
                }
                case "2": {
                    System.out.println("Función de facturación no implementada.");
                    // Invoice invoice = readInvoiceData();
                    // administrativeUseCase.generateInvoice(invoice);
                    return true;
                }
                case "3":
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

    private Patient readPatientData() throws Exception {
        System.out.println("--- Datos del Paciente ---");
        System.out.println("Ingrese Cédula:");
        String id = reader.nextLine();
        System.out.println("Ingrese Nombre Completo:");
        String name = reader.nextLine();
        System.out.println("Ingrese Fecha de Nacimiento (YYYY-MM-DD):");
        String birthDate = reader.nextLine();
        System.out.println("Ingrese Género:");
        String gender = reader.nextLine();
        System.out.println("Ingrese Dirección:");
        String address = reader.nextLine();
        System.out.println("Ingrese Teléfono:");
        String phone = reader.nextLine();
        System.out.println("Ingrese Email:");
        String email = reader.nextLine();
        
        System.out.println("--- Contacto de Emergencia ---");
        System.out.println("Ingrese Nombre Completo del Contacto:");
        String ecName = reader.nextLine();
        System.out.println("Ingrese Parentesco:");
        String ecRel = reader.nextLine();
        System.out.println("Ingrese Teléfono del Contacto:");
        String ecPhone = reader.nextLine();

        System.out.println("--- Seguro ---");
        System.out.println("Ingrese ID de la aseguradora:");
        String insuranceId = reader.nextLine();

        return patientBuilder.build(id, name, birthDate, gender, address, phone, email, ecName, ecRel, ecPhone, insuranceId);
    }
}
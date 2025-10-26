package app.adapter.in.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class ClinicConsoleApplication implements CommandLineRunner { // Se ejecuta después de que Spring inicie

    private static final String MENU_PRINCIPAL = "=== Clínica - Sistema de Gestión ===\n"
            + "Seleccione el rol con el que desea iniciar sesión:\n"
            + "1. Recursos Humanos\n"
            + "2. Personal Administrativo\n"
            + "3. Médico\n"
            + "4. Enfermería\n"
            + "5. Soporte de Información\n"
            + "0. Salir";

    private static Scanner reader = new Scanner(System.in);

    // Inyecta todas las clases Client específicas
    @Autowired
    private HumanResourcesClient humanResourcesClient;
    @Autowired
    private AdministrativeClient administrativeClient;
    @Autowired
    private DoctorClient doctorClient;
    @Autowired
    private NurseClient nurseClient;
    @Autowired
    private InformationSupportClient informationSupportClient;

    @Override
    public void run(String... args) throws Exception {
        boolean running = true;
        while (running) {
            System.out.println("\n" + MENU_PRINCIPAL);
            String opcion = reader.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("\n--- Iniciando sesión como Recursos Humanos ---");
                    humanResourcesClient.session();
                    break;
                case "2":
                    System.out.println("\n--- Iniciando sesión como Personal Administrativo ---");
                    administrativeClient.session();
                    break;
                case "3":
                    System.out.println("\n--- Iniciando sesión como Médico ---");
                    doctorClient.session();
                    break;
                case "4":
                    System.out.println("\n--- Iniciando sesión como Enfermería ---");
                    nurseClient.session();
                    break;
                case "5":
                    System.out.println("\n--- Iniciando sesión como Soporte de Información ---");
                    informationSupportClient.session();
                    break;
                case "0":
                    System.out.println("Saliendo de la aplicación...");
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
        reader.close();
    }
}
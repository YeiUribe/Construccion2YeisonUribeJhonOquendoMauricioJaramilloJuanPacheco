package app.adapter.in.client;

import app.adapter.in.builder.UserBuilder;
import app.application.usecases.HumanResourcesUseCase;
import app.domain.model.User;
import app.domain.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class HumanResourcesClient {

    private static final String MENU = "Rol: Recursos Humanos \n"
            + "1. Contratar Personal (Médico)\n"
            + "2. Contratar Personal (Enfermera)\n"
            + "3. Contratar Personal (Administrativo)\n"
            + "4. Actualizar Personal\n"
            + "5. Despedir Personal\n"
            + "6. Salir";
    private static Scanner reader = new Scanner(System.in);

    @Autowired
    private HumanResourcesUseCase humanResourcesUseCase;
    @Autowired
    private UserBuilder userBuilder;

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
                    User user = readStaffData();
                    humanResourcesUseCase.hireStaff(user, Role.DOCTOR);
                    System.out.println("Médico creado exitosamente.");
                    return true;
                }
                case "2": {
                    User user = readStaffData();
                    humanResourcesUseCase.hireStaff(user, Role.NURSE);
                    System.out.println("Enfermera(o) creada exitosamente.");
                    return true;
                }
                case "3": {
                    User user = readStaffData();
                    humanResourcesUseCase.hireStaff(user, Role.ADMINISTRATIVE_STAFF);
                    System.out.println("Administrativo creado exitosamente.");
                    return true;
                }
                case "4": {
                    System.out.println("Función de actualización no implementada.");
                    // User userToUpdate = readStaffData();
                    // humanResourcesUseCase.updateStaffInformation(userToUpdate);
                    return true;
                }
                case "5": {
                    System.out.println("Ingrese la cédula del empleado a despedir:");
                    String doc = reader.nextLine();
                    humanResourcesUseCase.terminateStaff(doc);
                    System.out.println("Empleado despedido.");
                    return true;
                }
                case "6":
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

    private User readStaffData() throws Exception {
        System.out.println("Ingrese Cédula:");
        String doc = reader.nextLine();
        System.out.println("Ingrese Nombre Completo:");
        String name = reader.nextLine();
        System.out.println("Ingrese Email (ej. usuario@dominio.com):");
        String email = reader.nextLine();
        System.out.println("Ingrese Teléfono (max 10 dígitos):");
        String phone = reader.nextLine();
        System.out.println("Ingrese Fecha de Nacimiento (YYYY-MM-DD):");
        String birthDate = reader.nextLine();
        System.out.println("Ingrese Dirección (max 30 car.):");
        String address = reader.nextLine();
        System.out.println("Ingrese Nombre de Usuario (max 15 car., letras y números):");
        String username = reader.nextLine();
        System.out.println("Ingrese Contraseña:");
        String password = reader.nextLine();
        
        return userBuilder.build(doc, name, email, phone, birthDate, address, username, password);
    }
}
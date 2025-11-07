package app.adapter.in.client;

import app.adapter.in.builder.DiagnosticAidBuilder;
import app.adapter.in.builder.InsuranceBuilder;
import app.adapter.in.builder.MedicationBuilder;
import app.adapter.in.builder.ProcedureBuilder;
import app.application.usecases.InformationSupportUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Scanner;

@Controller
public class InformationSupportClient {

    private static final String MENU = "Rol: Soporte de Información \n"
            + "1. Crear nuevo Medicamento en inventario\n"
            + "2. Crear nuevo Procedimiento en inventario\n"
            + "3. Crear nueva Ayuda Diagnóstica en inventario\n"
            + "4. Crear nueva Aseguradora\n"
            + "5. Salir";
    private static Scanner reader = new Scanner(System.in);

    @Autowired
    private InformationSupportUseCase informationSupportUseCase;
    @Autowired
    private MedicationBuilder medicationBuilder;
    @Autowired
    private ProcedureBuilder procedureBuilder;
    @Autowired
    private DiagnosticAidBuilder diagnosticAidBuilder;
    @Autowired
    private InsuranceBuilder insuranceBuilder;
    
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
                    System.out.println("Ingrese Nombre del Medicamento:");
                    String name = reader.nextLine();
                    System.out.println("Ingrese Costo (ej: 15000.0):");
                    String cost = reader.nextLine();
                    informationSupportUseCase.createMedication(medicationBuilder.build(name, cost));
                    System.out.println("Medicamento creado.");
                    return true;
                }
                case "2": {
                    System.out.println("Ingrese Nombre del Procedimiento:");
                    String name = reader.nextLine();
                    System.out.println("Ingrese Costo:");
                    String cost = reader.nextLine();
                    informationSupportUseCase.createProcedure(procedureBuilder.build(name, cost));
                    System.out.println("Procedimiento creado.");
                    return true;
                }
                case "3": {
                    System.out.println("Ingrese Nombre de la Ayuda Diagnóstica:");
                    String name = reader.nextLine();
                    System.out.println("Ingrese Costo:");
                    String cost = reader.nextLine();
                    informationSupportUseCase.createDiagnosticAid(diagnosticAidBuilder.build(name, cost));
                    System.out.println("Ayuda Diagnóstica creada.");
                    return true;
                }
                case "4": {
                    System.out.println("Ingrese Nombre de la Aseguradora:");
                    String name = reader.nextLine();
                    System.out.println("Ingrese Teléfono de Contacto:");
                    String phone = reader.nextLine();
                    System.out.println("¿Convenio Activo? (true/false):");
                    String active = reader.nextLine();
                    // Lógica para guardar la aseguradora (requiere un servicio)
                    // informationSupportUseCase.createInsurance(insuranceBuilder.build(name, phone, active));
                    System.out.println("Aseguradora creada.");
                    return true;
                }
                case "5":
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
}
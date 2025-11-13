# Guía Completa: Prueba de Endpoints con Thunder Client

## Tabla de Contenidos
1. [Configuración Inicial](#configuración-inicial)
2. [Endpoints Administrativos](#endpoints-administrativos)
3. [Endpoints Médicos](#endpoints-médicos)
4. [Endpoints de RRHH](#endpoints-de-rrhh)
5. [Endpoints de Soporte](#endpoints-de-soporte)
6. [Endpoints de Enfermería](#endpoints-de-enfermería)
7. [Manejo de Errores](#manejo-de-errores)

---

## Configuración Inicial

### Paso 1: Instalar Thunder Client en VS Code
1. Abre VS Code
2. Ve a Extensions (Ctrl+Shift+X)
3. Busca "Thunder Client"
4. Instala la extensión oficial por Ranga Vadhineni

### Paso 2: Crear Environment
1. Abre Thunder Client (icono en barra lateral izquierda)
2. Haz clic en **Environments** → **New Environment**
3. Crea un environment llamado "Local"
4. Agrega las siguientes variables:

```json
{
  "name": "Local",
  "variables": [
    {
      "key": "baseUrl",
      "value": "http://localhost:8080",
      "enabled": true
    },
    {
      "key": "apiPrefix",
      "value": "/api",
      "enabled": true
    }
  ]
}
```

5. Selecciona este environment en la esquina superior derecha de Thunder Client

### Paso 3: Levantar la Aplicación
En PowerShell (en la raíz del proyecto):

```powershell
# Compilar y ejecutar
.\mvnw spring-boot:run

# O compilar primero y luego ejecutar el JAR
.\mvnw clean package -DskipTests
java -jar .\target\Trabajo-semestre-0.0.1-SNAPSHOT.jar
```

Espera hasta ver: `Started TrabajoSemestreApplication in X.XXX seconds`

---

## ENDPOINTS ADMINISTRATIVOS

Base URL: `http://localhost:8080/api/admin`

### 1. Registrar Paciente
**POST** `/api/admin/patients`

#### Request Body:
```json
{
  "identificationNumber": "1234567890",
  "fullName": "Juan Carlos Pérez García",
  "birthDate": "1985-03-15",
  "gender": "M",
  "address": "Calle 10 #20-30, Apartamento 501",
  "phoneNumber": "+573001234567",
  "email": "juan.perez@example.com",
  "ecFullName": "María Elena García López",
  "ecRelationship": "Esposa",
  "ecPhoneNumber": "+573009876543",
  "insuranceId": "1"
}
```

#### Response (201 Created):
```json
{
  "success": true,
  "data": {
    "identificationNumber": "1234567890",
    "fullName": "Juan Carlos Pérez García",
    "birthDate": "1985-03-15",
    "gender": "M",
    "address": "Calle 10 #20-30, Apartamento 501",
    "phoneNumber": "+573001234567",
    "email": "juan.perez@example.com",
    "emergencyContactName": "María Elena García López",
    "emergencyContactPhone": "+573009876543",
    "emergencyContactRelationship": "Esposa",
    "insuranceCompany": "AXA Seguros",
    "insurancePolicyNumber": "1",
    "insuranceActive": true
  },
  "message": "Paciente registrado exitosamente",
  "errors": null
}
```

#### cURL para Thunder Client:
```bash
curl --request POST \
  --url http://localhost:8080/api/admin/patients \
  --header 'Content-Type: application/json' \
  --data '{
  "identificationNumber": "1234567890",
  "fullName": "Juan Carlos Pérez García",
  "birthDate": "1985-03-15",
  "gender": "M",
  "address": "Calle 10 #20-30, Apartamento 501",
  "phoneNumber": "+573001234567",
  "email": "juan.perez@example.com",
  "ecFullName": "María Elena García López",
  "ecRelationship": "Esposa",
  "ecPhoneNumber": "+573009876543",
  "insuranceId": "1"
}'
```

**En Thunder Client:**
1. Nuevo Request → Nombre: "Registrar Paciente"
2. Método: **POST**
3. URL: `{{baseUrl}}{{apiPrefix}}/admin/patients`
4. Headers:
   - Content-Type: `application/json`
5. Body (Raw): Pega el JSON del request
6. Click en **Send**

---

### 2. Generar Factura
**POST** `/api/admin/invoices`

#### Request Body:
```json
{
  "patientId": 1,
  "doctorId": 2,
  "issueDate": "2025-11-12",
  "totalAmount": 150000.00
}
```

#### Response (201 Created):
```json
{
  "success": true,
  "data": {
    "id": 101,
    "issueDate": "2025-11-12",
    "patientId": "1234567890",
    "patientName": "Juan Carlos Pérez García",
    "doctorId": "9876543210",
    "doctorName": "Dr. Roberto López",
    "totalAmount": 150000.00,
    "copayAmount": 30000.00
  },
  "message": "Factura generada exitosamente",
  "errors": null
}
```

#### cURL para Thunder Client:
```bash
curl --request POST \
  --url http://localhost:8080/api/admin/invoices \
  --header 'Content-Type: application/json' \
  --data '{
  "patientId": 1,
  "doctorId": 2,
  "issueDate": "2025-11-12",
  "totalAmount": 150000.00
}'
```

**En Thunder Client:**
1. Nuevo Request → Nombre: "Generar Factura"
2. Método: **POST**
3. URL: `{{baseUrl}}{{apiPrefix}}/admin/invoices`
4. Headers: Content-Type: `application/json`
5. Body (Raw): Pega el JSON
6. Send

---

## ENDPOINTS MÉDICOS

Base URL: `http://localhost:8080/api/doctor`

### 3. Crear Registro Clínico
**POST** `/api/doctor/clinical-records`

#### Request Body:
```json
{
  "patientId": 1,
  "doctorId": 2,
  "recordDate": "2025-11-12",
  "reasonForVisit": "Dolor de espalda",
  "symptoms": "Dolor intenso en la región lumbar, rigidez matutina",
  "diagnosis": "Lumbago agudo"
}
```

#### Response (201 Created):
```json
{
  "success": true,
  "data": {
    "id": 50,
    "patientId": "1234567890",
    "patientName": "Juan Carlos Pérez García",
    "doctorId": "9876543210",
    "doctorName": "Dr. Roberto López",
    "recordDate": "2025-11-12",
    "reasonForVisit": "Dolor de espalda",
    "symptoms": "Dolor intenso en la región lumbar, rigidez matutina",
    "diagnosis": "Lumbago agudo"
  },
  "message": "Registro clínico creado exitosamente",
  "errors": null
}
```

#### cURL para Thunder Client:
```bash
curl --request POST \
  --url http://localhost:8080/api/doctor/clinical-records \
  --header 'Content-Type: application/json' \
  --data '{
  "patientId": 1,
  "doctorId": 2,
  "recordDate": "2025-11-12",
  "reasonForVisit": "Dolor de espalda",
  "symptoms": "Dolor intenso en la región lumbar, rigidez matutina",
  "diagnosis": "Lumbago agudo"
}'
```

**En Thunder Client:**
1. Nuevo Request → Nombre: "Crear Registro Clínico"
2. Método: **POST**
3. URL: `{{baseUrl}}{{apiPrefix}}/doctor/clinical-records`
4. Headers: Content-Type: `application/json`
5. Body (Raw): Pega el JSON
6. Send

---

### 4. Crear Orden Clínica
**POST** `/api/doctor/clinical-orders`

#### Request Body:
```json
{
  "patientId": 1,
  "doctorId": 2,
  "creationDate": "2025-11-12",
  "medications": [
    {
      "itemNumber": 1,
      "name": "Ibuprofeno 400mg",
      "dosage": "400mg",
      "duration": "10 días",
      "cost": 25000.00
    },
    {
      "itemNumber": 2,
      "name": "Paracetamol 500mg",
      "dosage": "500mg",
      "duration": "5 días",
      "cost": 15000.00
    }
  ],
  "procedures": [
    {
      "itemNumber": 1,
      "name": "Resonancia Magnética Columna",
      "repetitionCount": 1,
      "frequency": "Una sola vez",
      "requiresSpecialist": true,
      "specialty": "RADIOLOGIA",
      "cost": 500000.00
    }
  ],
  "diagnosticAids": [
    {
      "itemNumber": 1,
      "name": "Laboratorio Básico",
      "quantity": 1,
      "requiresSpecialist": false,
      "specialty": null,
      "cost": 80000.00
    }
  ]
}
```

#### Response (201 Created):
```json
{
  "success": true,
  "data": {
    "id": 25,
    "patientId": "1234567890",
    "patientName": "Juan Carlos Pérez García",
    "doctorId": "9876543210",
    "doctorName": "Dr. Roberto López",
    "creationDate": "2025-11-12",
    "medications": [
      {
        "itemNumber": 1,
        "name": "Ibuprofeno 400mg",
        "dosage": "400mg",
        "duration": "10 días",
        "cost": 25000.00
      },
      {
        "itemNumber": 2,
        "name": "Paracetamol 500mg",
        "dosage": "500mg",
        "duration": "5 días",
        "cost": 15000.00
      }
    ],
    "procedures": [
      {
        "itemNumber": 1,
        "name": "Resonancia Magnética Columna",
        "repetitionCount": 1,
        "frequency": "Una sola vez",
        "requiresSpecialist": true,
        "specialty": "RADIOLOGIA",
        "cost": 500000.00
      }
    ],
    "diagnosticAids": [
      {
        "itemNumber": 1,
        "name": "Laboratorio Básico",
        "quantity": 1,
        "requiresSpecialist": false,
        "specialty": null,
        "cost": 80000.00
      }
    ]
  },
  "message": "Orden clínica creada exitosamente",
  "errors": null
}
```

#### cURL para Thunder Client:
```bash
curl --request POST \
  --url http://localhost:8080/api/doctor/clinical-orders \
  --header 'Content-Type: application/json' \
  --data '{
  "patientId": 1,
  "doctorId": 2,
  "creationDate": "2025-11-12",
  "medications": [
    {
      "itemNumber": 1,
      "name": "Ibuprofeno 400mg",
      "dosage": "400mg",
      "duration": "10 días",
      "cost": 25000.00
    }
  ],
  "procedures": [
    {
      "itemNumber": 1,
      "name": "Resonancia Magnética Columna",
      "repetitionCount": 1,
      "frequency": "Una sola vez",
      "requiresSpecialist": true,
      "specialty": "RADIOLOGIA",
      "cost": 500000.00
    }
  ],
  "diagnosticAids": [
    {
      "itemNumber": 1,
      "name": "Laboratorio Básico",
      "quantity": 1,
      "requiresSpecialist": false,
      "specialty": null,
      "cost": 80000.00
    }
  ]
}'
```

**En Thunder Client:**
1. Nuevo Request → Nombre: "Crear Orden Clínica"
2. Método: **POST**
3. URL: `{{baseUrl}}{{apiPrefix}}/doctor/clinical-orders`
4. Headers: Content-Type: `application/json`
5. Body (Raw): Pega el JSON
6. Send

---

## ENDPOINTS DE RRHH

Base URL: `http://localhost:8080/api/hr`

### 5. Contratar Personal
**POST** `/api/hr/staff`

#### Request Body:
```json
{
  "documentNumber": "98765432",
  "fullName": "Dra. Sandra Martínez López",
  "email": "sandra.martinez@hospital.com",
  "phoneNumber": "+573115559876",
  "birthDate": "1980-06-20",
  "address": "Carrera 5 #12-45, Apartamento 302",
  "username": "smartinez",
  "password": "SecurePassword123!",
  "role": "DOCTOR"
}
```

#### Response (201 Created):
```json
{
  "success": true,
  "data": {
    "documentNumber": "98765432",
    "fullName": "Dra. Sandra Martínez López",
    "email": "sandra.martinez@hospital.com",
    "phoneNumber": "+573115559876",
    "birthDate": "1980-06-20",
    "address": "Carrera 5 #12-45, Apartamento 302",
    "role": "DOCTOR",
    "username": "smartinez"
  },
  "message": "Personal contratado exitosamente",
  "errors": null
}
```

#### Valores válidos para Role:
- `DOCTOR`
- `NURSE`
- `ADMINISTRATIVE`
- `INFORMATION_SUPPORT`
- `HUMAN_RESOURCES`

#### cURL para Thunder Client:
```bash
curl --request POST \
  --url http://localhost:8080/api/hr/staff \
  --header 'Content-Type: application/json' \
  --data '{
  "documentNumber": "98765432",
  "fullName": "Dra. Sandra Martínez López",
  "email": "sandra.martinez@hospital.com",
  "phoneNumber": "+573115559876",
  "birthDate": "1980-06-20",
  "address": "Carrera 5 #12-45, Apartamento 302",
  "username": "smartinez",
  "password": "SecurePassword123!",
  "role": "DOCTOR"
}'
```

**En Thunder Client:**
1. Nuevo Request → Nombre: "Contratar Personal"
2. Método: **POST**
3. URL: `{{baseUrl}}{{apiPrefix}}/hr/staff`
4. Headers: Content-Type: `application/json`
5. Body (Raw): Pega el JSON
6. Send

---

## ENDPOINTS DE SOPORTE

Base URL: `http://localhost:8080/api/support`

### 6. Crear Medicamento
**POST** `/api/support/medications`

#### Request Body:
```json
{
  "name": "Amoxicilina 500mg",
  "cost": 45000.00
}
```

#### Response (201 Created):
```json
{
  "success": true,
  "data": {
    "itemNumber": 1,
    "name": "Amoxicilina 500mg",
    "dosage": null,
    "duration": null,
    "cost": 45000.00
  },
  "message": "Medicamento creado exitosamente",
  "errors": null
}
```

#### cURL para Thunder Client:
```bash
curl --request POST \
  --url http://localhost:8080/api/support/medications \
  --header 'Content-Type: application/json' \
  --data '{
  "name": "Amoxicilina 500mg",
  "cost": 45000.00
}'
```

**En Thunder Client:**
1. Nuevo Request → Nombre: "Crear Medicamento"
2. Método: **POST**
3. URL: `{{baseUrl}}{{apiPrefix}}/support/medications`
4. Headers: Content-Type: `application/json`
5. Body (Raw): Pega el JSON
6. Send

---

### 7. Crear Procedimiento
**POST** `/api/support/procedures`

#### Request Body:
```json
{
  "name": "Cirugía de Apendicitis",
  "cost": 2500000.00
}
```

#### Response (201 Created):
```json
{
  "success": true,
  "data": {
    "itemNumber": 1,
    "name": "Cirugía de Apendicitis",
    "repetitionCount": 0,
    "frequency": null,
    "requiresSpecialist": false,
    "specialty": null,
    "cost": 2500000.00
  },
  "message": "Procedimiento creado exitosamente",
  "errors": null
}
```

#### cURL para Thunder Client:
```bash
curl --request POST \
  --url http://localhost:8080/api/support/procedures \
  --header 'Content-Type: application/json' \
  --data '{
  "name": "Cirugía de Apendicitis",
  "cost": 2500000.00
}'
```

**En Thunder Client:**
1. Nuevo Request → Nombre: "Crear Procedimiento"
2. Método: **POST**
3. URL: `{{baseUrl}}{{apiPrefix}}/support/procedures`
4. Headers: Content-Type: `application/json`
5. Body (Raw): Pega el JSON
6. Send

---

### 8. Crear Ayuda Diagnóstica
**POST** `/api/support/diagnostic-aids`

#### Request Body:
```json
{
  "name": "Tomografía Computarizada Torax",
  "cost": 350000.00
}
```

#### Response (201 Created):
```json
{
  "success": true,
  "data": {
    "itemNumber": 1,
    "name": "Tomografía Computarizada Torax",
    "quantity": 0,
    "requiresSpecialist": false,
    "specialty": null,
    "cost": 350000.00
  },
  "message": "Ayuda diagnóstica creada exitosamente",
  "errors": null
}
```

#### cURL para Thunder Client:
```bash
curl --request POST \
  --url http://localhost:8080/api/support/diagnostic-aids \
  --header 'Content-Type: application/json' \
  --data '{
  "name": "Tomografía Computarizada Torax",
  "cost": 350000.00
}'
```

**En Thunder Client:**
1. Nuevo Request → Nombre: "Crear Ayuda Diagnóstica"
2. Método: **POST**
3. URL: `{{baseUrl}}{{apiPrefix}}/support/diagnostic-aids`
4. Headers: Content-Type: `application/json`
5. Body (Raw): Pega el JSON
6. Send

---

### 9. Crear Seguro
**POST** `/api/support/insurances`

#### Request Body:
```json
{
  "companyName": "AXA Seguros Colombia",
  "contactNumber": "+573111234567",
  "active": true
}
```

#### Response (201 Created):
```json
{
  "success": true,
  "data": {
    "id": 10,
    "companyName": "AXA Seguros Colombia",
    "contactNumber": "+573111234567",
    "active": true
  },
  "message": "Seguro creado exitosamente",
  "errors": null
}
```

#### cURL para Thunder Client:
```bash
curl --request POST \
  --url http://localhost:8080/api/support/insurances \
  --header 'Content-Type: application/json' \
  --data '{
  "companyName": "AXA Seguros Colombia",
  "contactNumber": "+573111234567",
  "active": true
}'
```

**En Thunder Client:**
1. Nuevo Request → Nombre: "Crear Seguro"
2. Método: **POST**
3. URL: `{{baseUrl}}{{apiPrefix}}/support/insurances`
4. Headers: Content-Type: `application/json`
5. Body (Raw): Pega el JSON
6. Send

---

## ENDPOINTS DE ENFERMERÍA

Base URL: `http://localhost:8080/api/nurse`

### 10. Registrar Vitales del Paciente
**POST** `/api/nurse/vitals`

#### Request Body:
```json
{
  "patientId": 1,
  "recordTimestamp": "2025-11-12T14:30:00",
  "bloodPressure": "120/80",
  "temperature": 37.2,
  "pulse": 72,
  "oxygenLevel": 98.5
}
```

#### Response (201 Created):
```json
{
  "success": true,
  "data": {
    "id": 45,
    "patientId": "1234567890",
    "recordTimestamp": "2025-11-12T14:30:00",
    "bloodPressure": "120/80",
    "temperature": 37.2,
    "pulse": 72,
    "oxygenLevel": 98.5
  },
  "message": "Vitales registrados exitosamente",
  "errors": null
}
```

#### cURL para Thunder Client:
```bash
curl --request POST \
  --url http://localhost:8080/api/nurse/vitals \
  --header 'Content-Type: application/json' \
  --data '{
  "patientId": 1,
  "recordTimestamp": "2025-11-12T14:30:00",
  "bloodPressure": "120/80",
  "temperature": 37.2,
  "pulse": 72,
  "oxygenLevel": 98.5
}'
```

**En Thunder Client:**
1. Nuevo Request → Nombre: "Registrar Vitales"
2. Método: **POST**
3. URL: `{{baseUrl}}{{apiPrefix}}/nurse/vitals`
4. Headers: Content-Type: `application/json`
5. Body (Raw): Pega el JSON
6. Send

---

## MANEJO DE ERRORES

### Error: Validación (400 Bad Request)

#### Request inválido:
```json
{
  "identificationNumber": "",
  "fullName": "",
  "birthDate": "invalid-date"
}
```

#### Response esperado (400):
```json
{
  "success": false,
  "data": null,
  "message": "Solicitud inválida",
  "errors": [
    "identificationNumber no debe estar vacío",
    "fullName no debe estar vacío",
    "birthDate debe ser una fecha válida (YYYY-MM-DD)"
  ]
}
```

---

### Error: Conflicto (409 Conflict)

#### Intento de registrar paciente con número de identificación duplicado

#### Response esperado (409):
```json
{
  "success": false,
  "data": null,
  "message": "Conflicto en la operación",
  "errors": [
    "Ya existe un paciente con el número de identificación 1234567890"
  ]
}
```

---

### Error: Servidor (500 Internal Server Error)

#### Response esperado:
```json
{
  "success": false,
  "data": null,
  "message": "Error interno del servidor",
  "errors": [
    "Descripción del error interno"
  ]
}
```

---

## Consejos para Pruebas Efectivas

### 1. Workflow Recomendado
```
1. Crear Seguro (soporte) → Guardar ID
2. Crear Paciente (admin) → Referencia a seguro
3. Contratar Médico (RRHH)
4. Crear Medicamentos (soporte)
5. Crear Procedimientos (soporte)
6. Crear Registro Clínico (doctor)
7. Crear Orden Clínica (doctor) → Referencia a medicamentos/procedimientos
8. Generar Factura (admin)
9. Registrar Vitales (nurse)
```

### 2. Usando Variables en Thunder Client
Para reutilizar IDs:
1. Después de crear un paciente, copia el `id` de la respuesta
2. En Environment → Local, agrega: `"patientId": "valor_copiado"`
3. Usa `{{patientId}}` en futuras requests

### 3. Testing con Insomnia (alternativa)
Si prefieres Insomnia en lugar de Thunder Client:
1. Instala Insomnia desde https://insomnia.rest
2. Copia los mismos cURL proporcionados
3. Import → From cURL
4. Pega el comando y listo

### 4. Validaciones de Formato
- **Fechas**: Formato ISO `YYYY-MM-DD` (ej: 2025-11-12)
- **DateTime**: Formato ISO con hora `YYYY-MM-DDTHH:mm:ss` (ej: 2025-11-12T14:30:00)
- **Moneda**: Números decimales sin separador de miles (ej: 150000.00, no 150.000,00)
- **Teléfono**: Incluye indicativo país (ej: +573001234567)
- **Email**: Formato válido (ej: user@domain.com)

### 5. Importar Colección Completa
Si quieres crear una colección reutilizable:
1. Thunder Client → Collections → New
2. Guarda cada request con nombres claros
3. Exporta como JSON para compartir con el equipo

---

## Resumen de Endpoints

| # | Método | Endpoint | Descripción |
|---|--------|----------|-------------|
| 1 | POST | `/api/admin/patients` | Registrar paciente |
| 2 | POST | `/api/admin/invoices` | Generar factura |
| 3 | POST | `/api/doctor/clinical-records` | Crear registro clínico |
| 4 | POST | `/api/doctor/clinical-orders` | Crear orden clínica |
| 5 | POST | `/api/hr/staff` | Contratar personal |
| 6 | POST | `/api/support/medications` | Crear medicamento |
| 7 | POST | `/api/support/procedures` | Crear procedimiento |
| 8 | POST | `/api/support/diagnostic-aids` | Crear ayuda diagnóstica |
| 9 | POST | `/api/support/insurances` | Crear seguro |
| 10 | POST | `/api/nurse/vitals` | Registrar vitales |

---

## Contacto y Soporte

Para reportar errores o hacer preguntas sobre los endpoints:
- Revisa los logs de la aplicación en la consola
- Verifica que la aplicación esté corriendo en `http://localhost:8080`
- Asegúrate de tener el environment "Local" seleccionado en Thunder Client

¡Listo para empezar a probar! 🚀

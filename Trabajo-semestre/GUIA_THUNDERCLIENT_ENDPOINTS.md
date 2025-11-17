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
  "patientId": "1234567890",
  "doctorId": "9876543210",
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
  "patientId": "1234567890",
  "doctorId": "9876543210",
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
  "patientId": "1234567890",
  "doctorId": "9876543210",
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
  "patientId": "1234567890",
  "doctorId": "9876543210",
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
  "patientId": "1234567890",
  "doctorId": "9876543210",
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
  "diagnosticAids": []
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
  "patientId": "1234567890",
  "doctorId": "9876543210",
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
  "diagnosticAids": []
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
  "patientId": "1234567890",
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
  "patientId": "1234567890",
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

### 1. Workflow Recomendado — Paso a Paso Completo

**Orden crítico (respeta las dependencias):**

#### Paso 1: Crear Seguro
```bash
curl -X POST http://localhost:8080/api/support/insurances \
  -H 'Content-Type: application/json' \
  -d '{
    "companyName": "AXA Seguros Colombia",
    "contactNumber": "+573111234567",
    "active": true
  }'
```
**Guarda el ID de respuesta**, ej: `"id": 1`

#### Paso 2: Crear Paciente (usa seguro del paso 1)
```bash
curl -X POST http://localhost:8080/api/admin/patients \
  -H 'Content-Type: application/json' \
  -d '{
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
**Nota:** `identificationNumber` es la clave primaria del paciente (String). Úsala exactamente en los siguientes requests.

#### Paso 3: Contratar Personal (Doctor)
```bash
curl -X POST http://localhost:8080/api/hr/staff \
  -H 'Content-Type: application/json' \
  -d '{
    "documentNumber": "9876543210",
    "fullName": "Dr. Roberto López",
    "email": "roberto.lopez@hospital.com",
    "phoneNumber": "+573105551234",
    "birthDate": "1975-07-10",
    "address": "Calle 5 #10-20",
    "username": "rlopez",
    "password": "Password1!",
    "role": "DOCTOR"
  }'
```
**Nota:** `documentNumber` es la clave primaria del usuario. Guarda exactamente este valor.

#### Paso 4: Crear Medicamentos (sin dependencias)
```bash
curl -X POST http://localhost:8080/api/support/medications \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Ibuprofeno 400mg",
    "cost": 25000.00
  }'
```
Puedes crear múltiples medicamentos; guarda los nombres exactamente.

#### Paso 5: Crear Procedimientos (sin dependencias)
```bash
curl -X POST http://localhost:8080/api/support/procedures \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Resonancia Magnética Columna",
    "cost": 500000.00
  }'
```

#### Paso 6: Crear Ayudas Diagnósticas (sin dependencias)
```bash
curl -X POST http://localhost:8080/api/support/diagnostic-aids \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Laboratorio Básico",
    "cost": 80000.00
  }'
```

#### Paso 7: Crear Registro Clínico (usa paciente del paso 2 + doctor del paso 3)
```bash
curl -X POST http://localhost:8080/api/doctor/clinical-records \
  -H 'Content-Type: application/json' \
  -d '{
    "patientId": "1234567890",
    "doctorId": "9876543210",
    "recordDate": "2025-11-12",
    "reasonForVisit": "Dolor de espalda",
    "symptoms": "Dolor intenso en la región lumbar",
    "diagnosis": "Lumbago agudo"
  }'
```
**Importante:** usa `identificationNumber` del paciente y `documentNumber` del doctor.

#### Paso 8: Crear Orden Clínica (usa paciente + doctor + medicamentos/procedimientos)
```bash
curl -X POST http://localhost:8080/api/doctor/clinical-orders \
  -H 'Content-Type: application/json' \
  -d '{
    "patientId": "1234567890",
    "doctorId": "9876543210",
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
    "diagnosticAids": []
  }'
```
**Importante:** Una orden clínica NO puede tener diagnósticAids si también contiene medicamentos o procedimientos. Elige uno u otro.

#### Paso 9: Generar Factura (usa paciente del paso 2 + doctor del paso 3)
```bash
curl -X POST http://localhost:8080/api/admin/invoices \
  -H 'Content-Type: application/json' \
  -d '{
    "patientId": "1234567890",
    "doctorId": "9876543210",
    "issueDate": "2025-11-12",
    "totalAmount": 150000.00
  }'
```
**Crítico:** usa exactamente `identificationNumber` del paciente y `documentNumber` del doctor. Si no existen en BD, recibirás error 500 con mensaje "Paciente no encontrado" o "Doctor no encontrado".

#### Paso 10: Registrar Vitales del Paciente (usa paciente del paso 2)
```bash
curl -X POST http://localhost:8080/api/nurse/vitals \
  -H 'Content-Type: application/json' \
  -d '{
    "patientId": "1234567890",
    "recordTimestamp": "2025-11-12T14:30:00",
    "bloodPressure": "120/80",
    "temperature": 37.2,
    "pulse": 72,
    "oxygenLevel": 98.5
  }'
```

---

### Notas Críticas de Identificadores

- **Pacientes:** La clave primaria es `identificationNumber` (String, ej: "1234567890")
- **Usuarios/Doctores/Staff:** La clave primaria es `documentNumber` (String, ej: "9876543210")
- **Facturas, Órdenes, Registros:** Usa EXACTAMENTE estos valores de PK al crear referencias
- Si intentas crear una factura con un paciente/doctor que no existe, recibirás error 500 con descripción clara

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

---

# PRUEBA COMPLETA CON DATOS NUEVOS

Esta sección contiene un flujo de prueba completo con datos diferentes para verificar todas las funcionalidades del sistema.

## Datos de Prueba

- **Paciente 2:** Identificación: `9876543210`, Nombre: `María José López Martínez`
- **Doctor 2:** Documento: `1112223334`, Nombre: `Dra. Ana María García López`
- **Seguro 2:** `Seguros Suramericana`

---

## Flujo Completo de Prueba

### Paso 1: Crear Segundo Seguro
```bash
curl -X POST http://localhost:8080/api/support/insurances \
  -H 'Content-Type: application/json' \
  -d '{
    "companyName": "Seguros Suramericana",
    "contactNumber": "+573215551234",
    "active": true
  }'
```

**Guarda el ID de respuesta**, ej: `"id": 2`

---

### Paso 2: Crear Segundo Paciente
```bash
curl -X POST http://localhost:8080/api/admin/patients \
  -H 'Content-Type: application/json' \
  -d '{
    "identificationNumber": "9876543210",
    "fullName": "María José López Martínez",
    "birthDate": "1990-08-22",
    "gender": "F",
    "address": "Avenida Paseo de los Libertadores #50-30, Apartamento 1202",
    "phoneNumber": "+573209876543",
    "email": "maria.lopez@example.com",
    "ecFullName": "Carlos Alberto López García",
    "ecRelationship": "Hermano",
    "ecPhoneNumber": "+573105551111",
    "insuranceId": "2"
  }'
```

**Guarda:** `identificationNumber = "9876543210"`

**Respuesta esperada (201 Created):**
```json
{
  "success": true,
  "data": {
    "identificationNumber": "9876543210",
    "fullName": "María José López Martínez",
    "birthDate": "1990-08-22",
    "gender": "F",
    "address": "Avenida Paseo de los Libertadores #50-30, Apartamento 1202",
    "phoneNumber": "+573209876543",
    "email": "maria.lopez@example.com",
    "emergencyContactName": "Carlos Alberto López García",
    "emergencyContactPhone": "+573105551111",
    "emergencyContactRelationship": "Hermano",
    "insuranceCompany": "Seguros Suramericana",
    "insurancePolicyNumber": "2",
    "insuranceActive": true
  },
  "message": "Paciente registrado exitosamente",
  "errors": null
}
```

---

### Paso 3: Contratar Segunda Doctora
```bash
curl -X POST http://localhost:8080/api/hr/staff \
  -H 'Content-Type: application/json' \
  -d '{
    "documentNumber": "1112223334",
    "fullName": "Dra. Ana María García López",
    "email": "ana.garcia@hospital.com",
    "phoneNumber": "+573125559876",
    "birthDate": "1982-11-05",
    "address": "Calle 7 #30-50, Apartamento 501",
    "username": "agarcia",
    "password": "SecurePass456!",
    "role": "DOCTOR"
  }'
```

**Guarda:** `documentNumber = "1112223334"`

**Respuesta esperada (201 Created):**
```json
{
  "success": true,
  "data": {
    "documentNumber": "1112223334",
    "fullName": "Dra. Ana María García López",
    "email": "ana.garcia@hospital.com",
    "phoneNumber": "+573125559876",
    "birthDate": "1982-11-05",
    "address": "Calle 7 #30-50, Apartamento 501",
    "role": "DOCTOR",
    "username": "agarcia"
  },
  "message": "Personal contratado exitosamente",
  "errors": null
}
```

---

### Paso 4: Crear Medicamento 2
```bash
curl -X POST http://localhost:8080/api/support/medications \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Amoxicilina 500mg",
    "cost": 35000.00
  }'
```

**Respuesta esperada:**
```json
{
  "success": true,
  "data": {
    "itemNumber": 2,
    "name": "Amoxicilina 500mg",
    "dosage": null,
    "duration": null,
    "cost": 35000.00
  },
  "message": "Medicamento creado exitosamente",
  "errors": null
}
```

---

### Paso 5: Crear Procedimiento 2
```bash
curl -X POST http://localhost:8080/api/support/procedures \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Tomografía de Tórax",
    "cost": 450000.00
  }'
```

**Respuesta esperada:**
```json
{
  "success": true,
  "data": {
    "itemNumber": 2,
    "name": "Tomografía de Tórax",
    "repetitionCount": 0,
    "frequency": null,
    "requiresSpecialist": false,
    "specialty": null,
    "cost": 450000.00
  },
  "message": "Procedimiento creado exitosamente",
  "errors": null
}
```

---

### Paso 6: Crear Ayuda Diagnóstica 2
```bash
curl -X POST http://localhost:8080/api/support/diagnostic-aids \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Radiografía de Tórax",
    "cost": 120000.00
  }'
```

**Respuesta esperada:**
```json
{
  "success": true,
  "data": {
    "itemNumber": 2,
    "name": "Radiografía de Tórax",
    "quantity": 0,
    "requiresSpecialist": false,
    "specialty": null,
    "cost": 120000.00
  },
  "message": "Ayuda diagnóstica creada exitosamente",
  "errors": null
}
```

---

### Paso 7: Crear Registro Clínico 2
```bash
curl -X POST http://localhost:8080/api/doctor/clinical-records \
  -H 'Content-Type: application/json' \
  -d '{
    "patientId": "9876543210",
    "doctorId": "1112223334",
    "recordDate": "2025-11-16",
    "reasonForVisit": "Control de presión arterial",
    "symptoms": "Presión elevada, ligero mareo ocasional",
    "diagnosis": "Hipertensión arterial en tratamiento"
  }'
```

**Respuesta esperada (201 Created):**
```json
{
  "success": true,
  "data": {
    "id": 51,
    "patientId": "9876543210",
    "patientName": "María José López Martínez",
    "doctorId": "1112223334",
    "doctorName": "Dra. Ana María García López",
    "recordDate": "2025-11-16",
    "reasonForVisit": "Control de presión arterial",
    "symptoms": "Presión elevada, ligero mareo ocasional",
    "diagnosis": "Hipertensión arterial en tratamiento"
  },
  "message": "Registro clínico creado exitosamente",
  "errors": null
}
```

---

### Paso 8: Crear Orden Clínica 2 (Con Medicamentos y Procedimientos)
```bash
curl -X POST http://localhost:8080/api/doctor/clinical-orders \
  -H 'Content-Type: application/json' \
  -d '{
    "patientId": "9876543210",
    "doctorId": "1112223334",
    "creationDate": "2025-11-16",
    "medications": [
      {
        "itemNumber": 1,
        "name": "Amoxicilina 500mg",
        "dosage": "500mg",
        "duration": "7 días",
        "cost": 35000.00
      },
      {
        "itemNumber": 2,
        "name": "Losartán 50mg",
        "dosage": "50mg",
        "duration": "30 días",
        "cost": 25000.00
      }
    ],
    "procedures": [
      {
        "itemNumber": 1,
        "name": "Tomografía de Tórax",
        "repetitionCount": 1,
        "frequency": "Una sola vez",
        "requiresSpecialist": true,
        "specialty": "RADIOLOGIA",
        "cost": 450000.00
      }
    ],
    "diagnosticAids": []
  }'
```

**Respuesta esperada (201 Created):**
```json
{
  "success": true,
  "data": {
    "id": 26,
    "patientId": "9876543210",
    "patientName": "María José López Martínez",
    "doctorId": "1112223334",
    "doctorName": "Dra. Ana María García López",
    "creationDate": "2025-11-16",
    "medications": [
      {
        "itemNumber": 1,
        "name": "Amoxicilina 500mg",
        "dosage": "500mg",
        "duration": "7 días",
        "cost": 35000.00
      },
      {
        "itemNumber": 2,
        "name": "Losartán 50mg",
        "dosage": "50mg",
        "duration": "30 días",
        "cost": 25000.00
      }
    ],
    "procedures": [
      {
        "itemNumber": 1,
        "name": "Tomografía de Tórax",
        "repetitionCount": 1,
        "frequency": "Una sola vez",
        "requiresSpecialist": true,
        "specialty": "RADIOLOGIA",
        "cost": 450000.00
      }
    ],
    "diagnosticAids": []
  },
  "message": "Orden clínica creada exitosamente",
  "errors": null
}
```

---

### Paso 9: Generar Factura 2
```bash
curl -X POST http://localhost:8080/api/admin/invoices \
  -H 'Content-Type: application/json' \
  -d '{
    "patientId": "9876543210",
    "doctorId": "1112223334",
    "issueDate": "2025-11-16",
    "totalAmount": 300000.00
  }'
```

**Respuesta esperada (201 Created):**
```json
{
  "success": true,
  "data": {
    "id": 102,
    "issueDate": "2025-11-16",
    "patientId": "9876543210",
    "patientName": "María José López Martínez",
    "doctorId": "1112223334",
    "doctorName": "Dra. Ana María García López",
    "totalAmount": 300000.00,
    "copayAmount": 60000.00
  },
  "message": "Factura generada exitosamente",
  "errors": null
}
```

---

### Paso 10: Registrar Vitales 2
```bash
curl -X POST http://localhost:8080/api/nurse/vitals \
  -H 'Content-Type: application/json' \
  -d '{
    "patientId": "9876543210",
    "recordTimestamp": "2025-11-16T10:45:00",
    "bloodPressure": "145/90",
    "temperature": 36.5,
    "pulse": 78,
    "oxygenLevel": 97.5
  }'
```

**Respuesta esperada (201 Created):**
```json
{
  "success": true,
  "data": {
    "id": 46,
    "patientId": "9876543210",
    "recordTimestamp": "2025-11-16T10:45:00",
    "bloodPressure": "145/90",
    "temperature": 36.5,
    "pulse": 78,
    "oxygenLevel": 97.5
  },
  "message": "Vitales registrados exitosamente",
  "errors": null
}
```

---

## Validación de Prueba Completa

✅ **Seguro Creado:** Seguros Suramericana (ID: 2)
✅ **Paciente Creado:** María José López Martínez (9876543210)
✅ **Doctor Creado:** Dra. Ana María García López (1112223334)
✅ **Medicamentos Creados:** Amoxicilina 500mg, Losartán 50mg
✅ **Procedimientos Creados:** Tomografía de Tórax
✅ **Ayudas Diagnósticas Creadas:** Radiografía de Tórax
✅ **Registro Clínico Creado:** Control de presión arterial
✅ **Orden Clínica Creada:** Con medicamentos y procedimientos
✅ **Factura Generada:** $300,000 COP
✅ **Vitales Registrados:** PA 145/90, FC 78, Temp 36.5°C, O₂ 97.5%

---

## Flujo Alternativo: Orden Clínica SOLO con Diagnósticos

Si prefieres crear una orden SOLO con ayudas diagnósticas (sin medicamentos ni procedimientos):

```bash
curl -X POST http://localhost:8080/api/doctor/clinical-orders \
  -H 'Content-Type: application/json' \
  -d '{
    "patientId": "9876543210",
    "doctorId": "1112223334",
    "creationDate": "2025-11-16",
    "medications": [],
    "procedures": [],
    "diagnosticAids": [
      {
        "itemNumber": 1,
        "name": "Radiografía de Tórax",
        "quantity": 1,
        "requiresSpecialist": false,
        "specialty": null,
        "cost": 120000.00
      }
    ]
  }'
```

**Nota importante:** Una orden clínica NO puede tener AMBOS medicamentos/procedimientos Y diagnósticos simultáneamente.

---

## Endpoints de RRHH: Actualizar y Eliminar Personal

### Actualizar Personal

**JSON ejemplo:**
```json
{
  "documentNumber": "1112223334",
  "fullName": "Dra. Ana María García López",
  "phoneNumber": "3216549870",
  "address": "Calle 123 #45-67, Medellín"
}
```

**Curl:**
```bash
curl -X POST http://localhost:8080/api/hr/staff/update \
  -H 'Content-Type: application/json' \
  -d '{
    "documentNumber": "1112223334",
    "fullName": "Dra. Ana María García López",
    "phoneNumber": "3216549870",
    "address": "Calle 123 #45-67, Medellín"
  }'
```

### Login (JWT)

**JSON ejemplo (admin existente):**
```json
{
  "username": "agarcia",
  "password": "SecurePass456!"
}
```

**Curl (login admin existente):**
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H 'Content-Type: application/json' \
  -d '{"username":"agarcia","password":"SecurePass456!"}'
```

La respuesta contendrá el token y `expiresIn` (ms). Usa el token en la cabecera `Authorization: Bearer <token>` para llamadas autenticadas.

---

**Prueba paso a paso (compilar + login + uso del token)**

1) Compilar y ejecutar la aplicación

```powershell
# Desde la carpeta raíz del proyecto
.\mvnw clean package -DskipTests
.\mvnw spring-boot:run
# o ejecutar el JAR generado
# java -jar .\target\Trabajo-semestre-0.0.1-SNAPSHOT.jar
```

2) Crear usuarios necesarios (admin / rrhh)

Puedes crear usuarios usando el endpoint de RRHH `/api/hr/staff`. El payload debe seguir la estructura de `UserRequest`.

Nota: El usuario administrador ya existe en el sistema. Usa las credenciales siguientes para las pruebas (no es necesario crear otro admin):

```json
{
  "documentNumber": "1112223334",
  "fullName": "Dra. Ana María García López",
  "email": "ana.garcia@hospital.com",
  "phoneNumber": "3125559876",
  "birthDate": "1982-11-05",
  "address": "Calle 7 #30-50",
  "username": "agarcia",
  "password": "SecurePass456!",
  "role": "ADMINISTRATIVE_STAFF"
}
```
Usa `username: agarcia` y `password: SecurePass456!` para hacer login como administrador.

Ejemplo: crear un usuario de `HUMAN_RESOURCES` (RRHH)

```bash
curl -X POST http://localhost:8080/api/hr/staff \
  -H 'Content-Type: application/json' \
  -d '{
    "documentNumber": "1112223334",
    "fullName": "RRHH Usuario",
    "email": "rrhh@example.com",
    "phoneNumber": "3003334444",
    "birthDate": "1990-05-05",
    "address": "Oficina RRHH",
    "username": "rrhh",
    "password": "rrhh123",
    "role": "HUMAN_RESOURCES"
  }'
```

3) Hacer login para obtener el token

```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H 'Content-Type: application/json' \
  -d '{"username":"agarcia","password":"SecurePass456!"}'
```

Respuesta esperada (ejemplo):

```json
{
  "success": true,
  "data": {
    "token": "eyJhbGciOi...",
    "expiresIn": 300000
  },
  "message": "Login exitoso",
  "errors": null
}
```

4) Usar el token en llamadas autenticadas

Ejemplo: actualizar personal (requiere `HUMAN_RESOURCES` o `ADMINISTRATIVE_STAFF`)

```bash
curl -X POST http://localhost:8080/api/hr/staff/update \
  -H 'Content-Type: application/json' \
  -H 'Authorization: Bearer <token>' \
  -d '{
    "documentNumber": "1112223334",
    "fullName": "RRHH Usuario Actualizado",
    "phoneNumber": "3150001111",
    "address": "Nueva dirección"
  }'
```

Ejemplo: eliminar personal (requiere `ADMINISTRATIVE_STAFF`)

```bash
curl -X POST http://localhost:8080/api/hr/staff/delete \
  -H 'Content-Type: application/json' \
  -H 'Authorization: Bearer <token>' \
  -d '{ "documentNumber": "1112223334" }'
```

5) Probar la autorización por roles

- Si haces login con `rrhh` (rol `HUMAN_RESOURCES`) podrás llamar a `/staff/update` pero **no** a `/staff/delete` (deberías obtener 403).
- Si haces login con `agarcia` (rol `ADMINISTRATIVE_STAFF`) podrás llamar a ambos endpoints.

6) Probar expiración del token (5 minutos)

- El token tiene `expiresIn` = 300000 ms (5 minutos). Espera 5 minutos y vuelve a intentar una llamada autenticada; la respuesta debería ser 401 con el cuerpo `{"error":"token_expired"}`.

7) Depuración y errores comunes

- `401 Unauthorized` al llamar endpoints: revisa que el header `Authorization` contenga `Bearer <token>` y que el token no haya expirado.
- `403 Forbidden`: el token es válido pero el rol del usuario no tiene permiso para ese recurso (`@PreAuthorize`). Verifica el rol en la creación del usuario y/o el claim `roles` dentro del token.
- Si tienes problemas al compilar por dependencias jjwt / security: corre `mvnw dependency:tree` y verifica que `jjwt` y `spring-boot-starter-security` estén presentes.

Si quieres, agrego también colecciones de Thunder Client con los requests listos para importar (login, crear admin, crear rrhh, update, delete). ¿Quieres que las genere ahora?

### Eliminar Personal

**JSON ejemplo:**
```json
{
  "documentNumber": "1112223334"
}
```

**Curl:**
```bash
curl -X POST http://localhost:8080/api/hr/staff/delete \
  -H 'Content-Type: application/json' \
  -d '{
    "documentNumber": "1112223334"
  }'
```

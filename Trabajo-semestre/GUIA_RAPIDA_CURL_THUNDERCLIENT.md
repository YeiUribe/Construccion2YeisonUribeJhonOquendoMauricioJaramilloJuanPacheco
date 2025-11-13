# Guía Rápida: Importar cURL en Thunder Client

## Opción 1: Importar desde cURL Individual

### Paso 1: Copiar el cURL
Toma cualquier cURL de la guía anterior, por ejemplo:

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

### Paso 2: Importar en Thunder Client
1. Abre Thunder Client (icono rayo en la barra lateral)
2. Ve a la pestaña **"My Collections"** o crea una nueva colección
3. Haz clic en el botón **"+"** para crear un nuevo request
4. Haz clic en el icono de **"Import"** (arriba del request, ícono de flecha hacia adentro)
5. Selecciona **"From cURL"**
6. Pega el cURL completo
7. Thunder Client automáticamente extraerá:
   - Método (POST, GET, etc.)
   - URL
   - Headers
   - Body (JSON)
8. Click en **"Import"**

---

## Opción 2: Importar Múltiples cURL usando PowerShell

Si quieres crear todos los requests de una vez, crea un archivo `requests.txt` con todos los cURL:

### Archivo: `importar_curls.txt`

```
=== Registrar Paciente ===
curl --request POST \
  --url http://localhost:8080/api/admin/patients \
  --header 'Content-Type: application/json' \
  --data '{"identificationNumber":"1234567890","fullName":"Juan Carlos Pérez","birthDate":"1985-03-15","gender":"M","address":"Calle 10","phoneNumber":"+573001234567","email":"juan@example.com","ecFullName":"María","ecRelationship":"Esposa","ecPhoneNumber":"+573009876543","insuranceId":"1"}'

=== Crear Seguro ===
curl --request POST \
  --url http://localhost:8080/api/support/insurances \
  --header 'Content-Type: application/json' \
  --data '{"companyName":"AXA Seguros","contactNumber":"+573111234567","active":true}'

=== Registrar Vitales ===
curl --request POST \
  --url http://localhost:8080/api/nurse/vitals \
  --header 'Content-Type: application/json' \
  --data '{"patientId":1,"recordTimestamp":"2025-11-12T14:30:00","bloodPressure":"120/80","temperature":37.2,"pulse":72,"oxygenLevel":98.5}'
```

Luego, en Thunder Client:
1. Import → From cURL → Paste multiple
2. Selecciona el contenido del archivo
3. Thunder Client importará todos automáticamente

---

## Opción 3: Crear Variables Globales

Para usar en todos los requests sin tener que cambiar URLs:

### Pasos:
1. Thunder Client → **Environments** tab
2. **New Environment** → Nombre: "APIs Locales"
3. Agrega estas variables:

```json
{
  "name": "APIs Locales",
  "variables": [
    {
      "key": "base",
      "value": "http://localhost:8080",
      "enabled": true
    },
    {
      "key": "api",
      "value": "/api",
      "enabled": true
    },
    {
      "key": "admin",
      "value": "/admin",
      "enabled": true
    },
    {
      "key": "doctor",
      "value": "/doctor",
      "enabled": true
    },
    {
      "key": "hr",
      "value": "/hr",
      "enabled": true
    },
    {
      "key": "support",
      "value": "/support",
      "enabled": true
    },
    {
      "key": "nurse",
      "value": "/nurse",
      "enabled": true
    },
    {
      "key": "token",
      "value": "",
      "enabled": true
    },
    {
      "key": "patientId",
      "value": "",
      "enabled": true
    }
  ]
}
```

Luego usa en URLs:
- `{{base}}{{api}}{{admin}}/patients`
- `{{base}}{{api}}{{doctor}}/clinical-orders`
- Etc.

---

## Opción 4: Script PowerShell para Generar Colección

Crea un script que genere requests automáticamente:

### Archivo: `generar_collection.ps1`

```powershell
# Script para generar requests en Thunder Client
$requests = @(
    @{
        name = "Registrar Paciente"
        method = "POST"
        url = "http://localhost:8080/api/admin/patients"
        body = @{
            identificationNumber = "1234567890"
            fullName = "Juan Carlos Pérez"
            birthDate = "1985-03-15"
            gender = "M"
            address = "Calle 10"
            phoneNumber = "+573001234567"
            email = "juan@example.com"
            ecFullName = "María"
            ecRelationship = "Esposa"
            ecPhoneNumber = "+573009876543"
            insuranceId = "1"
        }
    },
    @{
        name = "Crear Seguro"
        method = "POST"
        url = "http://localhost:8080/api/support/insurances"
        body = @{
            companyName = "AXA Seguros"
            contactNumber = "+573111234567"
            active = $true
        }
    },
    @{
        name = "Registrar Vitales"
        method = "POST"
        url = "http://localhost:8080/api/nurse/vitals"
        body = @{
            patientId = 1
            recordTimestamp = "2025-11-12T14:30:00"
            bloodPressure = "120/80"
            temperature = 37.2
            pulse = 72
            oxygenLevel = 98.5
        }
    }
)

# Guardar como JSON para Thunder Client
$requests | ConvertTo-Json -Depth 10 | Out-File -FilePath "requests.json" -Encoding UTF8
Write-Host "✓ Requests guardados en requests.json"
```

Ejecuta:
```powershell
.\generar_collection.ps1
```

Luego importa `requests.json` en Thunder Client.

---

## Opción 5: Copiar un cURL Completo y Simplificado

### cURL Simplificado por Endpoint

#### 1. Registrar Paciente
```bash
curl -X POST http://localhost:8080/api/admin/patients \
-H "Content-Type: application/json" \
-d '{"identificationNumber":"1234567890","fullName":"Juan Carlos Pérez","birthDate":"1985-03-15","gender":"M","address":"Calle 10","phoneNumber":"+573001234567","email":"juan@example.com","ecFullName":"María","ecRelationship":"Esposa","ecPhoneNumber":"+573009876543","insuranceId":"1"}'
```

#### 2. Crear Seguro
```bash
curl -X POST http://localhost:8080/api/support/insurances \
-H "Content-Type: application/json" \
-d '{"companyName":"AXA Seguros","contactNumber":"+573111234567","active":true}'
```

#### 3. Crear Medicamento
```bash
curl -X POST http://localhost:8080/api/support/medications \
-H "Content-Type: application/json" \
-d '{"name":"Amoxicilina 500mg","cost":45000.00}'
```

#### 4. Contratar Personal
```bash
curl -X POST http://localhost:8080/api/hr/staff \
-H "Content-Type: application/json" \
-d '{"documentNumber":"98765432","fullName":"Dra. Sandra Martínez","email":"sandra@hospital.com","phoneNumber":"+573115559876","birthDate":"1980-06-20","address":"Carrera 5","username":"smartinez","password":"SecurePassword123!","role":"DOCTOR"}'
```

#### 5. Crear Registro Clínico
```bash
curl -X POST http://localhost:8080/api/doctor/clinical-records \
-H "Content-Type: application/json" \
-d '{"patientId":1,"doctorId":2,"recordDate":"2025-11-12","reasonForVisit":"Dolor de espalda","symptoms":"Dolor intenso","diagnosis":"Lumbago"}'
```

#### 6. Registrar Vitales
```bash
curl -X POST http://localhost:8080/api/nurse/vitals \
-H "Content-Type: application/json" \
-d '{"patientId":1,"recordTimestamp":"2025-11-12T14:30:00","bloodPressure":"120/80","temperature":37.2,"pulse":72,"oxygenLevel":98.5}'
```

---

## Flujo de Prueba Completo en Thunder Client

### 1. Crear Colección "Hospital API"
- Thunder Client → Collections → New Collection
- Nombre: "Hospital API"

### 2. Crear Environment "Local"
- Thunder Client → Environments → New
- Nombre: "Local"
- Variables:
  ```json
  {
    "baseUrl": "http://localhost:8080",
    "apiPrefix": "/api"
  }
  ```

### 3. Importar Requests (en orden)
1. **Crear Seguro** → `{{baseUrl}}{{apiPrefix}}/support/insurances`
2. **Crear Medicamento** → `{{baseUrl}}{{apiPrefix}}/support/medications`
3. **Registrar Paciente** → `{{baseUrl}}{{apiPrefix}}/admin/patients`
4. **Contratar Médico** → `{{baseUrl}}{{apiPrefix}}/hr/staff`
5. **Crear Registro Clínico** → `{{baseUrl}}{{apiPrefix}}/doctor/clinical-records`
6. **Crear Orden Clínica** → `{{baseUrl}}{{apiPrefix}}/doctor/clinical-orders`
7. **Generar Factura** → `{{baseUrl}}{{apiPrefix}}/admin/invoices`
8. **Registrar Vitales** → `{{baseUrl}}{{apiPrefix}}/nurse/vitals`

### 4. Ejecutar en Orden
- Selecciona cada request → Click **Send**
- Guarda los IDs devueltos en el Environment para reutilizar

---

## Troubleshooting

### Problema: "No response" en Thunder Client

**Solución:**
1. Verifica que la app esté corriendo: `http://localhost:8080`
2. En consola debe haber un mensaje: `Started TrabajoSemestreApplication`
3. Si no está corriendo, ejecuta: `.\mvnw spring-boot:run`

### Problema: Error 400 "Bad Request"

**Solución:**
1. Verifica que el JSON sea válido (sin errores de sintaxis)
2. Comprueba que todos los campos requeridos estén presentes
3. Revisa que las fechas estén en formato `YYYY-MM-DD`
4. Los números de teléfono deben incluir indicativo: `+57...`

### Problema: Error 409 "Conflict"

**Solución:**
- Probablemente ya existe un registro con esos datos
- Usa IDs o documentos diferentes para cada prueba
- O limpia la base de datos y reinicia la aplicación

### Problema: No puedo importar el cURL

**Solución:**
1. Asegúrate de copiar el cURL completo (incluida la última comilla)
2. Thunder Client → Import → From cURL
3. Si sigue sin funcionar, crea el request manualmente:
   - Método: POST
   - URL: copia de `--url`
   - Headers: copia de `--header`
   - Body: copia de `--data`

---

## Atajos Útiles en Thunder Client

| Atajo | Descripción |
|-------|-------------|
| `Ctrl+L` | Focus en barra de URL |
| `Ctrl+K` | Buscar en Requests |
| `Ctrl+E` | Cambiar Environment |
| `Ctrl+S` | Guardar Request |
| `Enter` | Enviar Request (cuando está seleccionada) |

---

Ahora estás listo para empezar a probar todos los endpoints. ¡Buena suerte! 🚀

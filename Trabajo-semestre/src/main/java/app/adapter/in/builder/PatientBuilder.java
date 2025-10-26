package app.adapter.in.builder; 

import app.adapter.validators.PatientValidator;
import app.adapter.validators.InsuranceValidator;
import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.domain.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientBuilder {

    @Autowired
    private PatientValidator patientValidator;
    @Autowired
    private InsuranceValidator insuranceValidator;

    public Patient build(String identificationNumber, String fullName, String birthDate, 
                         String gender, String address, String phoneNumber, String email,
                         String ecFullName, String ecRelationship, String ecPhoneNumber,
                         String insuranceId) throws Exception {
        
        EmergencyContact contact = new EmergencyContact();
        contact.setFullName(patientValidator.stringValidator(ecFullName));
        contact.setRelationship(patientValidator.stringValidator(ecRelationship));
        contact.setPhoneNumber(patientValidator.phoneValidator(ecPhoneNumber));
        
        Insurance insurance = new Insurance();
        insurance.setId(insuranceValidator.idValidator(insuranceId));

        Patient patient = new Patient();
        patient.setIdentificationNumber(patientValidator.documentValidator(identificationNumber));
        patient.setFullName(patientValidator.stringValidator(fullName));
        patient.setBirthDate(patientValidator.dateValidator(birthDate));
        patient.setGender(patientValidator.stringValidator(gender));
        patient.setAddress(patientValidator.stringValidator(address));
        patient.setPhoneNumber(patientValidator.phoneValidator(phoneNumber));
        patient.setEmail(patientValidator.emailValidator(email));
        
        patient.setEmergencyContact(contact);
        patient.setInsurance(insurance);

        return patient;
    }
}
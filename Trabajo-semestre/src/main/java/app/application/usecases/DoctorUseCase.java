package app.application.usecases;

import app.domain.services.CreateClinicalOrder;
import app.domain.services.CreateClinicalRecord;
import app.domain.services.DefineHospitalizationAsProcedure;
import app.domain.services.EnsureUniqueOrderId;
import app.domain.services.UpdateClinicalOrder;
import app.domain.services.ValidateDiagnosticAidOrder;
import app.domain.services.ValidateOrderItemUniqueness;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.PatientVitals;
import app.domain.model.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorUseCase {

    @Autowired
    private CreateClinicalRecord createClinicalRecord;
    
    @Autowired
    private ValidateDiagnosticAidOrder validateDiagnosticAidOrder;
    
    @Autowired
    private EnsureUniqueOrderId ensureUniqueOrderId;
    
    @Autowired
    private ValidateOrderItemUniqueness validateOrderItemUniqueness;
    
    @Autowired
    private DefineHospitalizationAsProcedure defineHospitalizationAsProcedure;
    
    @Autowired
    private CreateClinicalOrder createClinicalOrder;
    
    @Autowired
    private UpdateClinicalOrder updateClinicalOrder;

    public ClinicalRecord createNewClinicalRecord(ClinicalRecord record, PatientVitals vitals) {
        record.setVitals(vitals);
        return createClinicalRecord.execute(record);
    }
    
    public ClinicalOrder createNewClinicalOrder(ClinicalOrder order) {
        ensureUniqueOrderId.execute(order.getId());
        validateDiagnosticAidOrder.execute(order);
        validateOrderItemUniqueness.execute(order);
        
        return createClinicalOrder.execute(order);
    }

    public ClinicalOrder manageHospitalization(ClinicalOrder order, Procedure hospitalizationDetails) {
        defineHospitalizationAsProcedure.execute(order, hospitalizationDetails);
        return updateClinicalOrder.execute(order);
    }
}
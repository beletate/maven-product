package univas.edu.vinicius.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univas.edu.vinicius.DAO.AuditingDAO;
import univas.edu.vinicius.Exceptions.ObjectNotFoundException;
import univas.edu.vinicius.model.Auditing;

import java.util.List;
import java.util.Optional;

@Service
public class AuditingService {
	@Autowired
    private AuditingDAO auditingDAO;

    public List<Auditing> getAllAuditings() {
        return auditingDAO.findAll();
    }

    public Auditing getAuditingById(Long id) {
        Optional<Auditing> obj = auditingDAO.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Auditing not found."));
    }

    public void createAuditing(Auditing auditing) {
        auditingDAO.save(auditing);
    }
}

package univas.edu.vinicius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import univas.edu.vinicius.model.Auditing;
import univas.edu.vinicius.service.AuditingService;

@RestController
@RequestMapping("/auditing")
public class AuditingController {
	@Autowired
    private AuditingService service;

    @GetMapping()
    public List<Auditing> getAllAuditings() {
        return service.getAllAuditings();
    }

    @GetMapping("/{code}")
    public Auditing getAuditingById(@PathVariable Long code) {
        Auditing auditing = service.getAuditingById(code);
        return auditing;
    }
}

package univas.edu.vinicius.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Auditing {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long identifier;
    private Long registerCode;
    private String operation;
    private Date datetime;

    public Auditing() {}

    public Auditing(Long registerCode, String operation, Date datetime) {
        super();
        this.registerCode = registerCode;
        this.operation = operation;
        this.datetime = datetime;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public Long getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(Long registerCode) {
        this.registerCode = registerCode;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}

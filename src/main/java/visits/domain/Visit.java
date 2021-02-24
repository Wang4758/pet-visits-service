package visits.domain;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity(name = "VISIT_ENTITY")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "owner_id")
    private int ownerId;

    @Column(name = "pet_id")
    private int petId;

    @Column(name = "visit_date")
    private ZonedDateTime date;

    @Column(name = "vet_id")
    private int vetId;

    @Enumerated(EnumType.STRING)
    @Column(length = 8, name = "status")
    private VisitStatus status;

    public Visit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public int getVetId() {
        return vetId;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public VisitStatus getStatus() {
        return status;
    }

    public void setStatus(VisitStatus status) {
        this.status = status;
    }

}

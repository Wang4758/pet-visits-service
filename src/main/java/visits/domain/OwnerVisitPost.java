package visits.domain;

import java.time.ZonedDateTime;

public class OwnerVisitPost {

    private int petId;
    private ZonedDateTime date;
    private int vetId;

    public OwnerVisitPost() {
    }

    public OwnerVisitPost(int petId, ZonedDateTime date, int vetId) {
        this.petId = petId;
        this.date = date;
        this.vetId = vetId;
    }

    public static Visit toVisit(OwnerVisitPost ownerVisitPost, int ownerId, VisitStatus status) {
        Visit visit = new Visit();
        visit.setPetId(ownerVisitPost.getPetId());
        visit.setDate(ownerVisitPost.getDate());
        visit.setVetId(ownerVisitPost.getVetId());
        visit.setOwnerId(ownerId);
        visit.setStatus(status);
        return visit;
    }

    public int getPetId() {
        return petId;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public int getVetId() {
        return vetId;
    }

}

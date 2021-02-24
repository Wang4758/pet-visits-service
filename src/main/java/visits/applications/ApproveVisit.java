package visits.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import visits.domain.Visit;
import visits.domain.VisitRepository;
import visits.domain.VisitStatus;

public class ApproveVisit {

    @Autowired
    private VisitRepository visitRepository;

    @PostMapping(path = "/vets/{vetId}/visits/{visitId}/approve")
    public ResponseEntity<Visit> approveVisit(
            @PathVariable("vetId") int vetId,
            @PathVariable("visitId") int visitId) {
        Visit visit = visitRepository.findById(visitId);
        if (visit.getVetId() != vetId) {
            return ResponseEntity.badRequest().body(visit);
        }
        visit.setStatus(VisitStatus.APPROVED);
        return ResponseEntity.ok(visitRepository.save(visit));
    }
}

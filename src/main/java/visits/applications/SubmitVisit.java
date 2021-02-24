package visits.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import visits.domain.OwnerVisitPost;
import visits.domain.Visit;
import visits.domain.VisitRepository;
import visits.domain.VisitStatus;

public class SubmitVisit {

    @Autowired
    private VisitRepository visitRepository;

    @PostMapping(path = "/owners/{ownerId}/visits/submit")
    public ResponseEntity<Visit> submitVisit(
            @PathVariable("ownerId") int ownerId,
            @RequestBody OwnerVisitPost ownerVisitView) {
        Visit visit = OwnerVisitPost.toVisit(ownerVisitView, ownerId, VisitStatus.PENDING);
        return ResponseEntity.ok(visitRepository.save(visit));
    }
}

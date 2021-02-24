package visits.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import visits.domain.Visit;
import visits.domain.VisitRepository;

import java.util.List;

public class GetVisits {

    @Autowired
    private VisitRepository visitRepository;

    @GetMapping(path = "/owners/{ownerId}/visits")
    public ResponseEntity<List<Visit>> getVisits(
            @PathVariable("ownerId") int ownerId) {
        return ResponseEntity.ok(visitRepository.findAllByOwnerId(ownerId));
    }
}

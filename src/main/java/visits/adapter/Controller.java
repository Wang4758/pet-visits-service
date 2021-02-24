package visits.adapter;

import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import visits.applications.ApproveVisit;
import visits.applications.GetVisits;
import visits.applications.RejectVisit;
import visits.applications.SubmitVisit;
import visits.domain.OwnerVisitPost;
import visits.domain.Visit;

import java.util.List;

public interface Controller {

    @GetMapping(path = "/owners/{ownerId}/visits")
    public ResponseEntity<List<Visit>> getVisits( @PathVariable("ownerId") int ownerId);

    @PostMapping(path = "/owners/{ownerId}/visits/submit")
    public ResponseEntity<Visit> submitVisit(
            @PathVariable("ownerId") int ownerId,
            @RequestBody OwnerVisitPost ownerVisitView);

    @PostMapping(path = "/vets/{vetId}/visits/{visitId}/approve")
    public ResponseEntity<Visit> approveVisit(
            @PathVariable("vetId") int vetId,
            @PathVariable("visitId") int visitId);

    @PostMapping(path = "/vets/{vetId}/visits/{visitId}/reject")
    public ResponseEntity<Visit> rejectVisit(
            @PathVariable("vetId") int vetId,
            @PathVariable("visitId") int visitId);
}

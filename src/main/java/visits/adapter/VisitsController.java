package visits.adapter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import visits.domain.OwnerVisitPost;
import visits.applications.ApproveVisit;
import visits.applications.GetVisits;
import visits.applications.RejectVisit;
import visits.applications.SubmitVisit;
import visits.domain.Visit;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
public class VisitsController implements Controller {

    private SubmitVisit submitVisit;
    private ApproveVisit approveVisit;
    private RejectVisit rejectVisit;
    private GetVisits getVisits;

    @GetMapping(path = "/owners/{ownerId}/visits")
    public ResponseEntity<List<Visit>> getVisits(
            @PathVariable("ownerId") int ownerId) {
        return getVisits.getVisits(ownerId);
    }

    @PostMapping(path = "/owners/{ownerId}/visits/submit")
    public ResponseEntity<Visit> submitVisit(
            @PathVariable("ownerId") int ownerId,
            @RequestBody OwnerVisitPost ownerVisitView) {
        return submitVisit.submitVisit(ownerId, ownerVisitView);
    }

    @PostMapping(path = "/vets/{vetId}/visits/{visitId}/approve")
    public ResponseEntity<Visit> approveVisit(
            @PathVariable("vetId") int vetId,
            @PathVariable("visitId") int visitId) {
        return approveVisit.approveVisit(vetId, visitId);
    }

    @PostMapping(path = "/vets/{vetId}/visits/{visitId}/reject")
    public ResponseEntity<Visit> rejectVisit(
            @PathVariable("vetId") int vetId,
            @PathVariable("visitId") int visitId) {
        return rejectVisit.rejectVisit(vetId, visitId);
    }

}

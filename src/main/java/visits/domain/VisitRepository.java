package visits.domain;

import org.springframework.data.repository.Repository;
import visits.domain.Visit;

import java.util.List;

public interface VisitRepository extends Repository<Visit, Long> {

    Visit findById(int id);

    List<Visit> findAllByOwnerId(int ownerId);

    Visit save(Visit visit);

}

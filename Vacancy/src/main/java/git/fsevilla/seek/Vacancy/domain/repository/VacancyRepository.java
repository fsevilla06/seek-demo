package git.fsevilla.seek.Vacancy.domain.repository;

import git.fsevilla.seek.Vacancy.domain.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}

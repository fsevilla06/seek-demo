package git.fsevilla.seek.jobApplication.domain.repository;

import git.fsevilla.seek.jobApplication.domain.model.Vacancy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vacancy")
public interface VacancyRepository {

    @GetMapping("/{id}")
    public Vacancy getVacancy(@PathVariable("id") Long id) throws Exception;
}

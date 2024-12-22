package git.fsevilla.seek.Vacancy.domain.service;

import git.fsevilla.seek.Vacancy.domain.exception.VacancyNotFoundException;
import git.fsevilla.seek.Vacancy.domain.model.Vacancy;

import java.util.List;

public interface FindVacancyUseCase {
    public List<Vacancy> findAll();
    public Vacancy find(Long id) throws VacancyNotFoundException;
}

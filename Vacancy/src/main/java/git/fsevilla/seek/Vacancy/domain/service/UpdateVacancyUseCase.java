package git.fsevilla.seek.Vacancy.domain.service;

import git.fsevilla.seek.Vacancy.domain.exception.InvalidDataException;
import git.fsevilla.seek.Vacancy.domain.exception.VacancyNotFoundException;
import git.fsevilla.seek.Vacancy.domain.model.Vacancy;

public interface UpdateVacancyUseCase {
    public Vacancy update(Vacancy vacancy) throws VacancyNotFoundException, InvalidDataException;
}

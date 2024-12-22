package git.fsevilla.seek.Vacancy.domain.service;

import git.fsevilla.seek.Vacancy.domain.exception.InvalidDataException;
import git.fsevilla.seek.Vacancy.domain.model.Vacancy;

public interface CreateVacancyUseCase {
    public Vacancy save(Vacancy vacancy) throws InvalidDataException;
}

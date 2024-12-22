package git.fsevilla.seek.Candidate.configuration;

import git.fsevilla.seek.Candidate.domain.model.CandidateGender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class GenderJpaConverter implements AttributeConverter<CandidateGender, String> {
    @Override
    public String convertToDatabaseColumn(CandidateGender attribute) {
        return attribute.getValue();
    }

    @Override
    public CandidateGender convertToEntityAttribute(String dbData) {
        return Stream.of(CandidateGender.values()).filter(v -> v.getValue().equals(dbData)).findAny().get();
    }
}

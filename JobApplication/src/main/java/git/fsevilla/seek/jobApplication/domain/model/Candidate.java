package git.fsevilla.seek.jobApplication.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Candidate(Long id) {
}

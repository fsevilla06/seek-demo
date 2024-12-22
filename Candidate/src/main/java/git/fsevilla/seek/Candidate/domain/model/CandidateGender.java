package git.fsevilla.seek.Candidate.domain.model;

public enum CandidateGender {
    MALE("M"), FEMALE("F");

    private String value;

    private CandidateGender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package refscheduler.tournament.builder;

import refscheduler.tournament.Tournament;

public class TournamentBuilder {

    private Long id;
    private String name;
    private String location;
    private Long pitches;

    private TournamentBuilder() {

    }

    public static TournamentBuilder newTournament() {
        return new TournamentBuilder();
    }

    public TournamentBuilder withId(final Long id) {
        this.id = id;
        return this;
    }

    public TournamentBuilder withName(final String name) {
        this.name = name;
        return this;
    }

    public TournamentBuilder withLocation(final String location) {
        this.location = location;
        return this;
    }

    public TournamentBuilder withPitches(final Long pitches) {
        this.pitches = pitches;
        return this;
    }

    public Tournament build() {
        Tournament tournament = new Tournament();
        tournament.setId(id);
        tournament.setName(name);
        tournament.setLocation(location);
        tournament.setPitches(pitches);
        return tournament;
    }
}

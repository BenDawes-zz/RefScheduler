package refscheduler.team.builder;

import refscheduler.team.Team;

public class TeamBuilder {

    private Long id;
    private String name;
    private String location;

    private TeamBuilder() {

    }

    public static TeamBuilder newTeam() {
        return new TeamBuilder();
    }

    public TeamBuilder withId(final Long id) {
        this.id = id;
        return this;
    }

    public TeamBuilder withName(final String name) {
        this.name = name;
        return this;
    }

    public TeamBuilder withLocation(final String location) {
        this.location = location;
        return this;
    }

    public Team build() {
        Team team = new Team();
        team.setId(id);
        team.setLocation(location);
        team.setName(name);
        return team;
    }
}

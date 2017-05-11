package refscheduler.game.builder;

import refscheduler.game.Game;
import refscheduler.person.Person;
import refscheduler.team.Team;
import refscheduler.timeslot.Timeslot;

public class GameBuilder {

    private Long id;
    private Timeslot timeslot;
    private Team teamA;
    private Team teamB;
    private Person headReferee;
    private Person assistantRefereeA;
    private Person assistantRefereeB;
    private Person assistantRefereeC;
    private Person assistantRefereeD;
    private Person snitchReferee;
    private Person snitch;
    private Long pitch;

    private GameBuilder() {

    }

    public static GameBuilder newGame() {
        return new GameBuilder();
    }

    public GameBuilder withId(final Long id) {
        this.id = id;
        return this;
    }

    public GameBuilder withTimeslot(final Timeslot timeslot) {
        this.timeslot = timeslot;
        return this;
    }

    public GameBuilder withTeamA(final Team teamA) {
        this.teamA = teamA;
        return this;
    }

    public GameBuilder withTeamB(final Team teamB) {
        this.teamB = teamB;
        return this;
    }

    public GameBuilder withHeadReferee(final Person headReferee) {
        this.headReferee = headReferee;
        return this;
    }

    public GameBuilder withAssistantRefereeA(final Person assistantRefereeA) {
        this.assistantRefereeA = assistantRefereeA;
        return this;
    }

    public GameBuilder withAssistantRefereeB(final Person assistantRefereeB) {
        this.assistantRefereeB = assistantRefereeB;
        return this;
    }

    public GameBuilder withAssistantRefereeC(final Person assistantRefereeC) {
        this.assistantRefereeC = assistantRefereeC;
        return this;
    }

    public GameBuilder withAssistantRefereeD(final Person assistantRefereeD) {
        this.assistantRefereeD = assistantRefereeD;
        return this;
    }

    public GameBuilder withSnitchReferee(final Person snitchReferee) {
        this.snitchReferee = snitchReferee;
        return this;
    }

    public GameBuilder withSnitch(final Person snitch) {
        this.snitch = snitch;
        return this;
    }

    public GameBuilder withPitch(final Long pitch) {
        this.pitch = pitch;
        return this;
    }

    public Game build() {
        Game game = new Game();
        game.setId(id);
        game.setTimeslot(timeslot);
        game.setTeamA(teamA);
        game.setTeamB(teamB);
        game.setHeadReferee(headReferee);
        game.setAssistantRefereeA(assistantRefereeA);
        game.setAssistantRefereeB(assistantRefereeB);
        game.setAssistantRefereeC(assistantRefereeC);
        game.setAssistantRefereeD(assistantRefereeD);
        game.setSnitchReferee(snitchReferee);
        game.setSnitch(snitch);
        game.setPitch(pitch);
        return game;
    }
}

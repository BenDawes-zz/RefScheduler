package refscheduler.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import refscheduler.domain.Level;

import javax.persistence.*;

/**
 * Person entity.
 */
@Entity
@Table(name = "PERSON")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "HEAD_REFEREE_LEVEL")
    private Level headRefereeLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "ASSISTANT_REFEREE_LEVEL")
    private Level assistantRefereeLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "SNITCH_REFEREE_LEVEL")
    private Level snitchRefereeLevel;

    @Column(name = "SNITCH")
    private Boolean snitch;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Level getHeadRefereeLevel() {
        return headRefereeLevel;
    }

    public void setHeadRefereeLevel(Level headRefereeLevel) {
        this.headRefereeLevel = headRefereeLevel;
    }

    public Level getAssistantRefereeLevel() {
        return assistantRefereeLevel;
    }

    public void setAssistantRefereeLevel(Level assistantRefereeLevel) {
        this.assistantRefereeLevel = assistantRefereeLevel;
    }

    public Level getSnitchRefereeLevel() {
        return snitchRefereeLevel;
    }

    public void setSnitchRefereeLevel(Level snitchRefereeLevel) {
        this.snitchRefereeLevel = snitchRefereeLevel;
    }

    public Boolean getSnitch() {
        return snitch;
    }

    public void setSnitch(Boolean snitch) {
        this.snitch = snitch;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}

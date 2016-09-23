package refscheduler.domain;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Person Get DTO.
 */
public class PersonGet {

    private Long personId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private Level headRefereeLevel;

    private Level assistantRefereeLevel;

    private Level snitchRefereeLevel;

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

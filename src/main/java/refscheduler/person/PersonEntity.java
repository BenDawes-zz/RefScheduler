package refscheduler.person;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Person entity.
 */
@Entity
@Table(name = "PERSON")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private Long id;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "SNITCH_LEVEL")
    private Level snitchLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Level getSnitchLevel() {
        return snitchLevel;
    }

    public void setSnitchLevel(Level snitchLevel) {
        this.snitchLevel = snitchLevel;
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

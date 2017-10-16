package refscheduler.person;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Random;

/**
 * Person Get DTO.
 */
public class Person implements Comparable<Person> {

    private Long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private Level headRefereeLevel;

    private Level assistantRefereeLevel;

    private Level snitchRefereeLevel;

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

    @Override
    public int compareTo(final Person that) {
        if (this.equals(that)) {
            return 0;
        }

        final int hrComparison = this.headRefereeLevel.compareTo(that.headRefereeLevel);
        final int arComparison = this.assistantRefereeLevel.compareTo(that.assistantRefereeLevel);
        final int srComparison = this.snitchRefereeLevel.compareTo(that.snitchRefereeLevel);

        if (hrComparison == 0) {
            if (arComparison == 0) {
                if (srComparison == 0) {
                    Random random = new Random();
                    return random.nextInt(3) - 1;
                } else {
                    return srComparison;
                }
            } else {
                return arComparison;
            }
        } else {
            return hrComparison;
        }
    }
}

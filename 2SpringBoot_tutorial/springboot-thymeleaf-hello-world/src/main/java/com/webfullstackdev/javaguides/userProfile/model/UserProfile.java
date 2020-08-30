package com.webfullstackdev.javaguides.userProfile.model;

import com.webfullstackdev.javaguides.user.model.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "USER_PROFILES")
public class UserProfile {

    @Id
    @GeneratedValue(generator ="uuid2",strategy = GenerationType.AUTO)
    @GenericGenerator( name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="USER_PROFILE_ID")
    private String userProfileId;

    @Column(name="SKILLS")
    private String skills;

    @Column(name="EXPERIENCE")
    private String experience;

    @Column(name="DOB")
    private LocalDate dob;


   // @OneToOne(mappedBy = "UserProfile", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    //@JoinColumn(name="")
   // private User user;

    public String getUserProfileId() {  return userProfileId;    }

    public void setUserProfileId(String userProfileId) {   this.userProfileId = userProfileId;   }

    public String getSkills() {    return skills;   }

    public void setSkills(String skills) {   this.skills = skills;   }

    public String getExperience() {    return experience;   }

    public void setExperience(String experience) {   this.experience = experience;   }

    public LocalDate getDob() {     return dob;   }

    public void setDob(LocalDate dob) {      this.dob = dob;   }
}

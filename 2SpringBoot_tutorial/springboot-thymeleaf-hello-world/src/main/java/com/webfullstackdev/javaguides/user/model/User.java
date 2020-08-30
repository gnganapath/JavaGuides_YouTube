package com.webfullstackdev.javaguides.user.model;

import com.webfullstackdev.javaguides.userProfile.model.UserProfile;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(generator = "uudi2",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="USER_ID")
    private String userId;
    @Column(name="NAME")
    private String name;
    @Column(name="EMAIL_ID")
    private String emailId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="userProfileId")
    private UserProfile userProfile;

    public User(){    }

    public User(String name, String emailId ) {
        this.name = name;
        this.emailId = emailId;
    }

    public String getUserId() {   return userId;   }

    public void setUserId(String userId) {  this.userId = userId;     }

    public String getName() {  return name;   }

    public void setName(String name) {  this.name = name;   }

    public String getEmailId() {  return emailId;   }

    public void setEmailId(String emailId) {  this.emailId = emailId;   }

    public UserProfile getUserProfile() {      return userProfile;    }

    public void setUserProfile(UserProfile instructorDetail) {    this.userProfile = userProfile;    }
}

package com.visioconference.visioservice.entities;

import com.visioconference.visioservice.entities.member.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Visio {
    @Id
    private String id;

    private String title;
    private String description;
    private String hostId;

    private Date startDateTime; //date de creation
    private Date endDateTime; //date de fin > soit programmée soit attribuée lors de la fin de la session

    @OneToMany(mappedBy = "myVisio", cascade = CascadeType.ALL)
    private List<Member> members;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        if (this.members.isEmpty()) this.members = members;
        else this.members.addAll(members);

    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    //---------------
    // --- Methode 1
    public void setStartDateTime() {
        this.startDateTime = new Date();
    }

    // -- Methode 2
    public void setStartDateTime(Date date) {
        this.startDateTime = date;
    }
    //---------------

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }
}



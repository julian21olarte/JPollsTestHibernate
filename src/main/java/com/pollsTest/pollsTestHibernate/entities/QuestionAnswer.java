/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pollsTest.pollsTestHibernate.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julian Olarte Torres
 */
@Entity
@Table(name = "questionanswers", catalog = "polls_test", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionAnswer.findAll", query = "SELECT q FROM QuestionAnswer q")
    , @NamedQuery(name = "QuestionAnswer.findById", query = "SELECT q FROM QuestionAnswer q WHERE q.id = :id")
    , @NamedQuery(name = "QuestionAnswer.findByPollId", query = "SELECT q FROM QuestionAnswer q WHERE q.pollId = :id")
    , @NamedQuery(name = "QuestionAnswer.findByQuestionId", query = "SELECT q FROM QuestionAnswer q WHERE q.questionId = :id")
    , @NamedQuery(name = "QuestionAnswer.findByAnswerId", query = "SELECT q FROM QuestionAnswer q WHERE q.answerId = :id")
    , @NamedQuery(name = "QuestionAnswer.findBySessionId", query = "SELECT q FROM QuestionAnswer q WHERE q.sessionId = :sessionId")
    , @NamedQuery(name = "QuestionAnswer.findByCreatedAt", query = "SELECT q FROM QuestionAnswer q WHERE q.createdAt = :createdAt")
    , @NamedQuery(name = "QuestionAnswer.findByUpdatedAt", query = "SELECT q FROM QuestionAnswer q WHERE q.updatedAt = :updatedAt")})
public class QuestionAnswer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "sessionId")
    private String sessionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @Column(name = "answerId")
    private Integer answerId;
    
    @Column(name = "pollId")
    private Integer pollId;
    
    @Column(name = "questionId")
    private Integer questionId;

    public QuestionAnswer() {
    }

    public QuestionAnswer(Integer id) {
        this.id = id;
    }

    public QuestionAnswer(Integer id, Date createdAt, Date updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getPollId() {
        return pollId;
    }

    public void setPollId(Integer pollId) {
        this.pollId = pollId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionAnswer)) {
            return false;
        }
        QuestionAnswer other = (QuestionAnswer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pollsTest.pollsTestHibernate.entities.QuestionAnswer[ id=" + id + " ]";
    }
    
}

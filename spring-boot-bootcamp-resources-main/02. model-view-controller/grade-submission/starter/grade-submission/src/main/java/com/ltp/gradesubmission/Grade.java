package com.ltp.gradesubmission;

public class Grade {

  private String name;
  private String subject;
  private String score;

  public Grade(String name, String subject, String score) {
    this.name = name;
    this.subject = subject;
    this.score = score;
  }

  public Grade() {
  }

  public String getName() {
    return name;
  }

  public void setName(String student) {
    this.name = student;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }
}

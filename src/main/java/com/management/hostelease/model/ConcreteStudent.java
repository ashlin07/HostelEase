package com.management.hostelease.model;

import jakarta.persistence.*;

@Entity
public class ConcreteStudent implements Student{
    @Id
    private int Srn;
    private String name;
    private String department;
    @ManyToOne
    private Room room;
    public ConcreteStudent() {}
    public ConcreteStudent(StudentBuilder builder) {
        this.name = builder.getName();
        this.Srn = builder.getSrn();
        this.department = builder.getDepartment();

    }

    // Getters for the properties
    public String getName() { return name; }
    public int getSrn() { return Srn; }
    public String getDepartment() { return department; }

    public int getRoomNumber() { return room.getRoomNumber(); }
    public void setRoom(Room room) { this.room = room; }

    // Static nested class: ConcreteStudentBuilder
    public static class ConcreteStudentBuilder implements StudentBuilder {
        private String name;
        private int Srn;
        private String department;



        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setSrn(int Srn) {
            this.Srn = Srn;
            return this;
        }

        public StudentBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }





        public String getName() { return name; }
        public int getSrn() { return Srn; }
        public String getDepartment() { return department; }



        public Student build() {
            return new ConcreteStudent(this);
        }
    }
}




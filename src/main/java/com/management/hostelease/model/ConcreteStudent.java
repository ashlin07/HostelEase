package com.management.hostelease.model;

import jakarta.persistence.*;

@Entity
public class ConcreteStudent implements Student{
    @Id
    private int Srn;
    private String name;
    private String department;
    private int roomNumber;
    public ConcreteStudent() {}
    public ConcreteStudent(StudentBuilder builder) {
        this.name = builder.getName();
        this.Srn = builder.getSrn();
        this.department = builder.getDepartment();
        this.roomNumber = builder.getRoomNumber();
    }

    // Getters for the properties
    public String getName() { return name; }
    public int getSrn() { return Srn; }
    public String getDepartment() { return department; }

    public int getRoomNumber() { return roomNumber; }


    // Static nested class: ConcreteStudentBuilder
    static class ConcreteStudentBuilder implements StudentBuilder {
        private String name;
        private int Srn;
        private String department;

        private int roomNumber;

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



        public StudentBuilder setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public String getName() { return name; }
        public int getSrn() { return Srn; }
        public String getDepartment() { return department; }

        public int getRoomNumber() { return roomNumber; }

        public Student build() {
            return new ConcreteStudent(this);
        }
    }
}




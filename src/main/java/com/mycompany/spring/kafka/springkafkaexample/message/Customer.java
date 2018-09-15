/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.spring.kafka.springkafkaexample.message;

import java.util.Date;
import java.util.Objects;

public class Customer {
    private String firstName;
    private String middleNames;
    private String lastName;
    private Date dob;
    private String email;
    private String telephoneNumber;

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(String middleNames) {
        this.middleNames = middleNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) &&
            Objects.equals(middleNames, customer.middleNames) &&
            Objects.equals(lastName, customer.lastName) &&
            Objects.equals(dob, customer.dob) &&
            Objects.equals(email, customer.email) &&
            Objects.equals(telephoneNumber, customer.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleNames, lastName, dob, email, telephoneNumber);
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
            .append("firstName", firstName)
            .append("middleNames", middleNames)
            .append("lastName", lastName)
            .append("dob", dob)
            .append("email", email)
            .append("telephoneNumber", telephoneNumber)
            .toString();
    }
}

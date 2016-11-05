package com.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by Santosh on 05-11-2016.
 */

public class Employee implements Parcelable{

    private String employeeName;
    private String employeeTechnology;
    private int experience;



    public Employee(){}

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeTechnology() {
        return employeeTechnology;
    }

    public void setEmployeeTechnology(String employeeTechnology) {
        this.employeeTechnology = employeeTechnology;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {
        Log.i("Employee","writeToParcel" +flags);
        destination.writeString(employeeName);
        destination.writeString(employeeTechnology);
        destination.writeInt(experience);
    }

    private Employee(Parcel in){
        this.employeeName = in.readString();
        this.employeeTechnology = in.readString();
        this.experience = in.readInt();
    }

    public static final Parcelable.Creator CREATOR = new Creator() {
        @Override
        public Employee createFromParcel(Parcel source) {
            return new Employee(source);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };
}

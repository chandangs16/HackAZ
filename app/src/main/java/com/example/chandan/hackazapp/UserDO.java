package com.example.chandan.hackazapp;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "hackaz-mobilehub-1334270061-User")

public class UserDO {
    private String _userId;
    private Double _gPS1;
    private Double _gPS2;
    private String _name;
    private Double _phoneNumber;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBAttribute(attributeName = "GPS1")
    public Double getGPS1() {
        return _gPS1;
    }

    public void setGPS1(final Double _gPS1) {
        this._gPS1 = _gPS1;
    }
    @DynamoDBAttribute(attributeName = "GPS2")
    public Double getGPS2() {
        return _gPS2;
    }

    public void setGPS2(final Double _gPS2) {
        this._gPS2 = _gPS2;
    }
    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return _name;
    }

    public void setName(final String _name) {
        this._name = _name;
    }
    @DynamoDBAttribute(attributeName = "Phone Number")
    public Double getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(final Double _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

}

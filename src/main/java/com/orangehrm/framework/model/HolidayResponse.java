package com.orangehrm.framework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class HolidayResponse {
    private List<Holiday> data;

    public List<Holiday> getData() {
        return data;
    }

    public void setData(List<Holiday> data) {
        this.data = data;
    }
}


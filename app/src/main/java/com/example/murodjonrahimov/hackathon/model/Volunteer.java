package com.example.murodjonrahimov.hackathon.model;

/**
 * Created by c4q on 3/3/18.
 */

public class Volunteer {

    private String addressesCount, contentId, createdDate, displayUrl, endDateDate, eventTime, hits, hours, lastModifiedDate, opportunityId, orgContentId, orgTitle, recurrenceType, region,
            startDateDate, status, summary, title, volRequests;

    private boolean isFavorite;

    public Volunteer(String addressesCount, String contentId, String createdDate, String displayUrl, String endDateDate, String eventTime, String hits, String hours, String lastModifiedDate, String opportunityId, String orgContentId, String orgTitle, String recurrenceType, String region, String startDateDate, String status, String summary, String title, String volRequests, boolean isFavorite) {
        this.addressesCount = addressesCount;
        this.contentId = contentId;
        this.createdDate = createdDate;
        this.displayUrl = displayUrl;
        this.endDateDate = endDateDate;
        this.eventTime = eventTime;
        this.hits = hits;
        this.hours = hours;
        this.lastModifiedDate = lastModifiedDate;
        this.opportunityId = opportunityId;
        this.orgContentId = orgContentId;
        this.orgTitle = orgTitle;
        this.recurrenceType = recurrenceType;
        this.region = region;
        this.startDateDate = startDateDate;
        this.status = status;
        this.summary = summary;
        this.title = title;
        this.volRequests = volRequests;
        this.isFavorite = isFavorite;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getAddressesCount() {
        return addressesCount;
    }

    public void setAddressesCount(String addressesCount) {
        this.addressesCount = addressesCount;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public String getEndDateDate() {
        return endDateDate;
    }

    public void setEndDateDate(String endDateDate) {
        this.endDateDate = endDateDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(String opportunityId) {
        this.opportunityId = opportunityId;
    }

    public String getOrgContentId() {
        return orgContentId;
    }

    public void setOrgContentId(String orgContentId) {
        this.orgContentId = orgContentId;
    }

    public String getOrgTitle() {
        return orgTitle;
    }

    public void setOrgTitle(String orgTitle) {
        this.orgTitle = orgTitle;
    }

    public String getRecurrenceType() {
        return recurrenceType;
    }

    public void setRecurrenceType(String recurrenceType) {
        this.recurrenceType = recurrenceType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStartDateDate() {
        return startDateDate;
    }

    public void setStartDateDate(String startDateDate) {
        this.startDateDate = startDateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVolRequests() {
        return volRequests;
    }

    public void setVolRequests(String volRequests) {
        this.volRequests = volRequests;
    }
}

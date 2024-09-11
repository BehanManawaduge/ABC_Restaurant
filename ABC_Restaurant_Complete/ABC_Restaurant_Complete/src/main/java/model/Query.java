// src/main/java/model/Query.java
package model;

public class Query {
    private int queryId;
    private int userId;
    private String queryText;
    private String responseText;
    private String status;

    public Query(int queryId, int userId, String queryText, String responseText, String status) {
        this.queryId = queryId;
        this.userId = userId;
        this.queryText = queryText;
        this.responseText = responseText;
        this.status = status;
    }

    // Getters
    public int getQueryId() {
        return queryId;
    }

    public int getUserId() {
        return userId;
    }

    public String getQueryText() {
        return queryText;
    }

    public String getResponseText() {
        return responseText;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

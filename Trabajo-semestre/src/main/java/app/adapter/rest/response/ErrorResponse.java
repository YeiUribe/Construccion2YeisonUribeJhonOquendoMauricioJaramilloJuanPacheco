package app.adapter.rest.response;

import java.time.Instant;

public class ErrorResponse {
    private String message;
    private String detail;
    private Instant timestamp;
    private int status;

    public ErrorResponse() {}

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
}

package com.store.management.store.error.handling;


import lombok.*;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorDetails {
    private Date timestamp;
    private String errorMessage;
    private String errorCode;
    private String errorDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorDetails)) return false;
        ErrorDetails that = (ErrorDetails) o;
        return timestamp.equals(that.timestamp) &&
                errorMessage.equals(that.errorMessage) &&
                errorCode.equals(that.errorCode) &&
                errorDetails.equals(that.errorDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, errorMessage, errorCode, errorDetails);
    }
}

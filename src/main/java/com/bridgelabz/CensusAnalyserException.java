package com.bridgelabz;

public class CensusAnalyserException extends Exception {

    public enum ExceptionType {
        STATE_CENSUS_FILE_PATH_PROBLEM, WRONG_FILE_TYPE, WRONG_FILE_DELIMITER
    }
    public ExceptionType type;
    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}

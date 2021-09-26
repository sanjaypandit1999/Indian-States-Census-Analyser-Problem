package com.bridgelabz;

public class CensusAnalyserException extends Exception {

    public enum ExceptionType {
        STATE_CENSUS_FILE_PATH_PROBLEM,
    }
    public ExceptionType type;
    public CensusAnalyserException(String message, ExceptionType censusFileProblem) {
        super(message);
        this.type = censusFileProblem;
    }
}

package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class StateCensusAnalyser {

    public  int CSVStateCensus(String csvFilepath) throws CensusAnalyserException {
        this.checkValidCSVFile(csvFilepath);
        int numOfRecords = 0;
        try {
            FileReader reader = new FileReader(csvFilepath);
            CSVReader csvReader = new CSVReader(reader);
            String[] line;
            int skipHeader = 0;
            while (((line = csvReader.readNext()) != null)) {
                if (skipHeader == 0) {
                    skipHeader++;
                    continue;
                }
                for (String token : line) {
                    System.out.print(token);
                }
                System.out.println();
                numOfRecords++;
            }
        } catch (RuntimeException e) {
            if (e.getMessage().contains("header!"))
                throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE_HEADER);
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE_DELIMITER);
        }catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.STATE_CENSUS_FILE_PATH_PROBLEM);
        }catch (CsvValidationException e) {
            e.printStackTrace();
        }
        return numOfRecords;
    }

    private void checkValidCSVFile(String csvFilePath) throws CensusAnalyserException {
        if (!csvFilePath.contains(".csv"))
            throw new CensusAnalyserException("This is invalid file type", CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
    }

}

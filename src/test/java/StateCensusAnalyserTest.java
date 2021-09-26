import com.bridgelabz.CensusAnalyserException;
import com.bridgelabz.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StateCensusAnalyserTest {
    private static final String INDIA_STATE_CENSUS_CSV_FILE_PATH = "C:\\Users\\Sanju\\Desktop\\Analyser\\IndianStates.csv";
    private static final String WRONG_CSV_FILE_PATH = "C:\\User\\Analyser\\IndianStates.csv";
    private static final String WRONG_CSV_FILE_TYPE = "C:\\Users\\Sanju\\Desktop\\Analyser\\IndianStates.pdf";
    @Test
    public void givenIndianStateCensusCSVFileReturnsCorrectRecords(){
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int numOfRecords = stateCensusAnalyser.CSVStateCensus(INDIA_STATE_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(22, numOfRecords);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaStateCensusData_WithWrongFile_ShouldThrowException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            stateCensusAnalyser.CSVStateCensus(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.STATE_CENSUS_FILE_PATH_PROBLEM, e.type);
            System.out.println(e.type);
        }
    }

    @Test
    public void givenIndianCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.CSVStateCensus(WRONG_CSV_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
            System.out.println(e.type);
        }
    }
}

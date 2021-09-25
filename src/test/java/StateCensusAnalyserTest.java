import com.bridgelabz.StateCensusAnalyser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {
    private static final String INDIA_STATE_CENSUS_CSV_FILE_PATH = "C:\\Users\\Sanju\\Desktop\\Analyser\\IndianStates.csv";
    @Test
    public void givenIndianStateCensusCSVFileReturnsCorrectRecords(){
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int numOfRecords = stateCensusAnalyser.CSVStateCensus(INDIA_STATE_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(22, numOfRecords);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

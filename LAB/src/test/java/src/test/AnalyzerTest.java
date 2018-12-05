package src.test;

import analyzer.Analyzer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzerTest {

    @Test
    public void timeOutForThreeIterations(){
        Analyzer analyzer = new Analyzer();
        assertTimeout(Duration.ofSeconds(10), () -> { analyzer.analize();});
    }

    @Test
    public void timeOutFortwoIterations(){
        Analyzer analyzer = new Analyzer();
        assertTimeout(Duration.ofSeconds(5), () -> { analyzer.analize();});
    }

    @Test
    public void checkThrows() {
        Assertions.assertThrows(StackOverflowError.class, () -> {new Analyzer().analize();});
    }

}
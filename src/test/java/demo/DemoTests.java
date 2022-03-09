package demo;

import com.idera.xray.junit.customjunitxml.XrayTestReporter;
import com.idera.xray.junit.customjunitxml.XrayTestReporterParameterResolver;
import com.idera.xray.junit.customjunitxml.annotations.XrayTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Tag("Demo")
@ExtendWith(XrayTestReporterParameterResolver.class)
public class DemoTests {

    @Test
    @XrayTest(key = "SANDBOX-425")
    public void addCommentsToTestRun(XrayTestReporter xrayReporter) {
        xrayReporter.addComment("A comment");
        assertThat(false, is(true));
    }

    @XrayTest(key = "SANDBOX-465")
    @Test
    public void addEvidenceToTestRun(XrayTestReporter xrayReporter) throws IOException {
        Path tempFile = Files.createTempFile("tmpEvidence", ".txt");
        Files.writeString(tempFile, "some String");
        xrayReporter.addTestRunEvidence(tempFile.toString());
        assertThat(false, is(true));
    }


}
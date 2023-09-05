package io.proleap.cobol.transform.complete.fixed;

import java.io.File;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.test.annotation.MicronautTest;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;
import io.proleap.cobol.transform.runner.CobolTransformationTestRunner;

@MicronautTest
public class RL101ATest {

	@Inject
	protected CobolTransformationTestRunner runner;

	@Test
	public void test() throws Exception {
		final File inputFile = new File("src/test/resources/io/proleap/cobol/transform/complete/fixed/RL101A.CBL");
		runner.transformFile(inputFile, CobolSourceFormatEnum.FIXED);
	}
}
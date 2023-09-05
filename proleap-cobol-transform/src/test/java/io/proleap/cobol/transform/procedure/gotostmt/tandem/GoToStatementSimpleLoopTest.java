package io.proleap.cobol.transform.procedure.gotostmt.tandem;

import java.io.File;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.test.annotation.MicronautTest;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;
import io.proleap.cobol.transform.runner.CobolTransformationTestRunner;

@MicronautTest
public class GoToStatementSimpleLoopTest {

	@Inject
	protected CobolTransformationTestRunner runner;

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/transform/procedure/gotostmt/tandem/GoToStatementSimpleLoop.cbl");
		runner.transformFile(inputFile, CobolSourceFormatEnum.TANDEM);
	}
}
package io.proleap.cobol.transform.procedure.paragraph.tandem;

import java.io.File;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.test.annotation.MicronautTest;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;
import io.proleap.cobol.transform.runner.CobolTransformationTestRunner;

@MicronautTest
public class ParagraphTest {

	@Inject
	protected CobolTransformationTestRunner runner;

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/transform/procedure/paragraph/tandem/Paragraph.cbl");
		runner.transformFile(inputFile, CobolSourceFormatEnum.TANDEM);
	}
}
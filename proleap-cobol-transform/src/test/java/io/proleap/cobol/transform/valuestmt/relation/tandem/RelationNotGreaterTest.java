package io.proleap.cobol.transform.valuestmt.relation.tandem;

import java.io.File;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.test.annotation.MicronautTest;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;
import io.proleap.cobol.transform.runner.CobolTransformationTestRunner;

@MicronautTest
public class RelationNotGreaterTest {

	@Inject
	protected CobolTransformationTestRunner runner;

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/transform/valuestmt/relation/tandem/RelationNotGreater.cbl");
		runner.transformFile(inputFile, CobolSourceFormatEnum.TANDEM);
	}
}
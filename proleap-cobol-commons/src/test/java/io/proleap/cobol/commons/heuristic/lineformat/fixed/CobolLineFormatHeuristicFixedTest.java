package io.proleap.cobol.commons.heuristic.lineformat.fixed;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import io.micronaut.test.annotation.MicronautTest;
import io.proleap.cobol.commons.TestBase;
import io.proleap.cobol.commons.heuristic.lineformat.impl.CobolLineFormatHeuristicImpl;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

@MicronautTest
public class CobolLineFormatHeuristicFixedTest extends TestBase {

	@Test
	public void testFixed1() throws Exception {
		final File file = new File("src/test/resources/io/proleap/cobol/commons/heuristic/lineformat/fixed/Fixed.cbl");
		final String cobolText = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		final CobolSourceFormatEnum lineFormat = new CobolLineFormatHeuristicImpl().determineLineFormat(cobolText);
		assertEquals(CobolSourceFormatEnum.FIXED, lineFormat);
	}

	@Test
	public void testFixedDeformedLines() throws Exception {
		final File file = new File(
				"src/test/resources/io/proleap/cobol/commons/heuristic/lineformat/fixed/DeformedLines.cbl");
		final String cobolText = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		final CobolSourceFormatEnum lineFormat = new CobolLineFormatHeuristicImpl().determineLineFormat(cobolText);
		assertEquals(CobolSourceFormatEnum.FIXED, lineFormat);
	}

	@Test
	public void testFixedLargeIdentification() throws Exception {
		final File file = new File(
				"src/test/resources/io/proleap/cobol/commons/heuristic/lineformat/fixed/FixedLargeIdentification.cbl");
		final String cobolText = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		final CobolSourceFormatEnum lineFormat = new CobolLineFormatHeuristicImpl().determineLineFormat(cobolText);
		assertEquals(CobolSourceFormatEnum.FIXED, lineFormat);
	}

	@Test
	public void testFixedWithVariableCommentLine() throws Exception {
		final File file = new File(
				"src/test/resources/io/proleap/cobol/commons/heuristic/lineformat/fixed/FixedWithVariableCommentLine.cbl");
		final String cobolText = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		final CobolSourceFormatEnum lineFormat = new CobolLineFormatHeuristicImpl().determineLineFormat(cobolText);
		assertEquals(CobolSourceFormatEnum.FIXED, lineFormat);
	}
}

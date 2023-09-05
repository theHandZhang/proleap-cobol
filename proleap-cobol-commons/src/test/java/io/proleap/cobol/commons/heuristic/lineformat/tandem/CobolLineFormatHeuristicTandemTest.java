package io.proleap.cobol.commons.heuristic.lineformat.tandem;

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
public class CobolLineFormatHeuristicTandemTest extends TestBase {

	@Test
	public void testTandem1() throws Exception {
		final File file = new File(
				"src/test/resources/io/proleap/cobol/commons/heuristic/lineformat/tandem/Tandem.cbl");
		final String cobolText = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		final CobolSourceFormatEnum lineFormat = new CobolLineFormatHeuristicImpl().determineLineFormat(cobolText);
		assertEquals(CobolSourceFormatEnum.TANDEM, lineFormat);
	}

	@Test
	public void testTandemEmptyLines() throws Exception {
		final File file = new File(
				"src/test/resources/io/proleap/cobol/commons/heuristic/lineformat/tandem/EmptyLines.cbl");
		final String cobolText = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		final CobolSourceFormatEnum lineFormat = new CobolLineFormatHeuristicImpl().determineLineFormat(cobolText);
		assertEquals(CobolSourceFormatEnum.TANDEM, lineFormat);
	}

	@Test
	public void testTandemLargeIdentification() throws Exception {
		final File file = new File(
				"src/test/resources/io/proleap/cobol/commons/heuristic/lineformat/tandem/TandemLargeIdentification.cbl");
		final String cobolText = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		final CobolSourceFormatEnum lineFormat = new CobolLineFormatHeuristicImpl().determineLineFormat(cobolText);
		assertEquals(CobolSourceFormatEnum.TANDEM, lineFormat);
	}
}

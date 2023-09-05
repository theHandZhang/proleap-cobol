package io.proleap.cobol.interpreter.procedure.add.corresponding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import io.micronaut.test.annotation.MicronautTest;
import io.proleap.cobol.asg.metamodel.Program;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.data.DataDivision;
import io.proleap.cobol.asg.metamodel.data.datadescription.DataDescriptionEntryGroup;
import io.proleap.cobol.asg.metamodel.data.workingstorage.WorkingStorageSection;
import io.proleap.cobol.asg.params.CobolParserParams;
import io.proleap.cobol.asg.runner.impl.CobolParserRunnerImpl;
import io.proleap.cobol.interpreter.TestBase;
import io.proleap.cobol.interpreter.domain.state.CobolState;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

@MicronautTest
public class AddCorrespondingStatementTest extends TestBase {

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/interpreter/procedure/add/corresponding/AddCorrespondingStatement.cbl");
		final CobolSourceFormatEnum format = CobolSourceFormatEnum.TANDEM;
		final CobolParserParams parserParams = createParserParams(format, inputFile);

		final Program program = new CobolParserRunnerImpl().analyzeFile(inputFile, format);
		final ProgramUnit programUnit = program.getCompilationUnit().getProgramUnit();
		final CobolState state = cobolInterpreterRunner.run(programUnit, createInterpreterParams(parserParams));

		final DataDivision dataDivision = programUnit.getDataDivision();
		final WorkingStorageSection workingStorageSection = dataDivision.getWorkingStorageSection();
		final DataDescriptionEntryGroup dataDescriptionEntryGroup2 = (DataDescriptionEntryGroup) workingStorageSection
				.getDataDescriptionEntry("GROUP2");

		assertEquals(BigDecimal.valueOf(2), valueService.getDecimal(
				storageService.getValue(dataDescriptionEntryGroup2.getDataDescriptionEntry("A"), state.getStorage())));
		assertEquals(BigDecimal.valueOf(2), valueService.getDecimal(
				storageService.getValue(dataDescriptionEntryGroup2.getDataDescriptionEntry("B"), state.getStorage())));
		assertEquals(BigDecimal.valueOf(6), valueService.getDecimal(
				storageService.getValue(dataDescriptionEntryGroup2.getDataDescriptionEntry("C"), state.getStorage())));
		assertEquals(BigDecimal.valueOf(4), valueService.getDecimal(
				storageService.getValue(dataDescriptionEntryGroup2.getDataDescriptionEntry("D"), state.getStorage())));
		assertEquals(BigDecimal.valueOf(10), valueService.getDecimal(
				storageService.getValue(dataDescriptionEntryGroup2.getDataDescriptionEntry("E"), state.getStorage())));
	}
}

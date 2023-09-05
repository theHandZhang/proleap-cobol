package io.proleap.cobol.interpreter.procedure.divide.intogiving;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import io.micronaut.test.annotation.MicronautTest;
import io.proleap.cobol.asg.metamodel.Program;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.params.CobolParserParams;
import io.proleap.cobol.asg.runner.impl.CobolParserRunnerImpl;
import io.proleap.cobol.interpreter.TestBase;
import io.proleap.cobol.interpreter.domain.state.CobolState;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

@MicronautTest
public class DivideIntoGivingStatementMultipleTest extends TestBase {

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/interpreter/procedure/divide/intogiving/DivideIntoGivingStatementMultiple.cbl");
		final CobolParserParams parserParams = createParserParams(CobolSourceFormatEnum.TANDEM, inputFile);
		final Program program = new CobolParserRunnerImpl().analyzeFile(inputFile, parserParams);
		final ProgramUnit programUnit = program.getCompilationUnit().getProgramUnit();
		final CobolState state = cobolInterpreterRunner.run(programUnit, createInterpreterParams(parserParams));

		assertEquals(BigDecimal.valueOf(21), valueService.getDecimal(getValue("SOMEID1", programUnit, state)));
		assertEquals(BigDecimal.valueOf(21), valueService.getDecimal(getValue("SOMEID2", programUnit, state)));
	}
}

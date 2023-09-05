package io.proleap.cobol.interpreter.procedure.perform;

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
public class PerformInlineTimesTest extends TestBase {

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/interpreter/procedure/perform/PerformInlineTimes.cbl");
		final CobolSourceFormatEnum format = CobolSourceFormatEnum.TANDEM;
		final CobolParserParams parserParams = createParserParams(format, inputFile);

		final Program program = new CobolParserRunnerImpl().analyzeFile(inputFile, format);
		final ProgramUnit programUnit = program.getCompilationUnit().getProgramUnit();
		final CobolState state = cobolInterpreterRunner.run(programUnit, createInterpreterParams(parserParams));

		assertEquals(BigDecimal.valueOf(3), valueService.getDecimal(getValue("TimesNum", programUnit, state)));

		assertEquals(5, state.getConsole().getLines().size());
		assertEquals("Starting program", state.getConsole().getLines().get(0));
		assertEquals("Inline perform", state.getConsole().getLines().get(1));
		assertEquals("Inline perform", state.getConsole().getLines().get(2));
		assertEquals("Inline perform", state.getConsole().getLines().get(3));
		assertEquals("Stopping program", state.getConsole().getLines().get(4));
	}
}

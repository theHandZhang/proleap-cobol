package io.proleap.cobol.analysis.issues.rules.data.file;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.proleap.cobol.analysis.issues.rules.FeatureGenerator;
import io.proleap.cobol.asg.metamodel.ASGElement;
import io.proleap.cobol.asg.metamodel.CompilationUnit;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.environment.EnvironmentDivision;
import io.proleap.cobol.asg.metamodel.environment.inputoutput.InputOutputSection;
import io.proleap.cobol.asg.metamodel.environment.inputoutput.filecontrol.AssignClause;
import io.proleap.cobol.asg.metamodel.environment.inputoutput.filecontrol.FileControlEntry;
import io.proleap.cobol.asg.metamodel.environment.inputoutput.filecontrol.FileControlParagraph;
import io.proleap.cobol.asg.metamodel.valuestmt.ValueStmt;
import io.proleap.cobol.asg.resolver.NameResolver;
import io.proleap.cobol.asg.resolver.impl.NameResolverImpl;
import io.proleap.cobol.commons.value.CobolValueService;
import io.proleap.cobol.commons.value.CobolValueStmtService;
import io.proleap.cobol.commons.value.domain.CobolValue;

@Singleton
public class FileCodeNamingConventionFeatureGenerator extends FeatureGenerator<ASGElement> {

	private static final String NAMING_CONVENTION = "FC-.*";

	@Inject
	private CobolValueService valueService;

	@Inject
	private CobolValueStmtService valueStmtService;

	@Override
	public Stream<ASGElement> getAll(final CompilationUnit compilationUnit) {
		return getAllFiles(compilationUnit);
	}

	protected Stream<ASGElement> getAllFiles(final CompilationUnit compilationUnit) {
		final ArrayList<ASGElement> result = new ArrayList<ASGElement>();
		final ProgramUnit programUnit = compilationUnit.getProgramUnit();

		if (programUnit != null) {
			final EnvironmentDivision environmentDivision = programUnit.getEnvironmentDivision();

			if (environmentDivision != null) {
				final InputOutputSection inputOutputSection = environmentDivision.getInputOutputSection();

				if (inputOutputSection != null) {
					final FileControlParagraph fileControlParagraph = inputOutputSection.getFileControlParagraph();

					if (fileControlParagraph != null) {
						final List<FileControlEntry> fileControlEntries = fileControlParagraph.getFileControlEntries();

						for (final FileControlEntry fileControlEntry : fileControlEntries) {
							final AssignClause assignClause = fileControlEntry.getAssignClause();
							final ValueStmt valueStmt = assignClause.getToValueStmt();
							final CobolValue value = valueStmtService.getValue(valueStmt, null);
							final String castString = valueService.getString(value);

							if (castString == null) {
								final NameResolver nameResolver = new NameResolverImpl();
								final String determineName = nameResolver.determineName(valueStmt.getCtx());

								if (determineName != null) {
									if (!isFollowingNamingConvention(determineName)) {
										result.add(fileControlEntry);
									}
								}
							}
						}
					}
				}
			}
		}

		return result.stream();
	}

	protected boolean isFollowingNamingConvention(final String name) {
		return name.matches(NAMING_CONVENTION);
	}
}

package io.proleap.cobol.commons.value.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.proleap.cobol.asg.metamodel.valuestmt.ValueStmt;
import io.proleap.cobol.commons.type.CobolTypeEnum;
import io.proleap.cobol.commons.type.CobolTypeService;
import io.proleap.cobol.commons.util.Java11To8;
import io.proleap.cobol.commons.value.CobolValueService;
import io.proleap.cobol.commons.value.CobolValueSpaceService;
import io.proleap.cobol.commons.value.CobolValueStmtService;
import io.proleap.cobol.commons.value.domain.CobolValue;

@Singleton
public class CobolValueSpaceServiceImpl implements CobolValueSpaceService {

	@Inject
	private CobolTypeService cobolTypeService;

	@Inject
	private CobolValueService valueService;

	@Inject
	private CobolValueStmtService valueStmtService;

	@Override
	public boolean isSpace(final ValueStmt valueStmt) {
		final CobolTypeEnum type = cobolTypeService.getType(valueStmt);
		final boolean result;

		if (!CobolTypeEnum.STRING.equals(type)) {
			result = false;
		} else {
			final CobolValue value = valueStmtService.getValue(valueStmt, null);
			final String stringValue = valueService.getString(value);
			result = value != null && (stringValue == null || Java11To8.isBlank(stringValue));
		}

		return result;
	}
}

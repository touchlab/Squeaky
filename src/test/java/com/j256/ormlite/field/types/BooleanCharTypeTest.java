package com.j256.ormlite.field.types;

import com.j256.ormlite.android.squeaky.Dao;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class BooleanCharTypeTest extends BaseTypeTest {

	private static final String BOOLEAN_COLUMN = "bool";

	@Test
	public void testBooleanObj() throws Exception {
		SimpleHelper helper = createHelper(LocalBooleanChar.class);

		Class<LocalBooleanChar> clazz = LocalBooleanChar.class;
		Dao<LocalBooleanChar, Object> dao = helper.getDao(clazz);
		boolean val = true;
		String valStr = Boolean.toString(val);
		LocalBooleanChar foo = new LocalBooleanChar();
		foo.bool = val;
		dao.create(foo);

		assertTrue(EqualsBuilder.reflectionEquals(foo, dao.queryForAll().get(0)));

		helper.close();
	}

	@DatabaseTable
	protected static class LocalBooleanChar {
		@DatabaseField(columnName = BOOLEAN_COLUMN, dataType = DataType.BOOLEAN_CHAR)
		boolean bool;
	}
}

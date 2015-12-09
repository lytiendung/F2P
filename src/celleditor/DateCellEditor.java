package celleditor;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.alee.laf.table.editors.WebDateEditor;

import dao.RootDao;

public class DateCellEditor extends WebDateEditor {
	private static final long serialVersionUID = 8988390758814353109L;

	public DateCellEditor() {
		setClickCountToStart(1);
		editorComponent.setDateFormat(RootDao.DATE_FORMAT_USER);
		delegate = new EditorDelegate<Object>() {
			private static final long serialVersionUID = -7748092569349070167L;
			private Date date;

			@Override
			public void setValue(final Object value) {
				try {
					date = RootDao.DATE_FORMAT_USER.parse((String) value);
				} catch (ParseException e) {
					e.printStackTrace();
					date = Calendar.getInstance().getTime();
				}
				editorComponent.setDate(date);
			}

			@Override
			public Object getCellEditorValue() {
				editorComponent.updateDateFromField(false);
				return RootDao.DATE_FORMAT_USER.format(editorComponent.getDate());
			}
		};
	}

}

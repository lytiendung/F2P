package dao;

import java.util.List;

import model.objs.AbstractModelObject;

public abstract class AbstractFragmentDao {

	public abstract List<AbstractModelObject> loadData();

	public abstract List<AbstractModelObject> loadTmpData();

	public abstract List<AbstractModelObject> loadDataByBreachId(long breachId);

	public abstract boolean saveOrUpdate(AbstractModelObject model, long breachId);

	public abstract boolean updateAllBreachId(List<AbstractModelObject> models, long breachId);

	public abstract boolean updateBreachId(AbstractModelObject model, long breachId);

	public abstract boolean deleteRecords(long[] ids);

	public abstract boolean deleteByBreachId(long breachId);

	public abstract boolean clearTable();

}

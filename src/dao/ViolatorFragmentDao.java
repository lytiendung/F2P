package dao;

import java.util.List;

import model.objs.AbstractModelObject;

public class ViolatorFragmentDao extends AbstractFragmentDao {

	@Override
	public List<AbstractModelObject> loadData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractModelObject> loadTmpData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractModelObject> loadDataByBreachId(long breachId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveOrUpdate(AbstractModelObject model, long breachId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAllBreachId(List<AbstractModelObject> models, long breachId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBreachId(AbstractModelObject model, long breachId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecords(long[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByBreachId(long breachId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clearTable() {
		// TODO Auto-generated method stub
		return false;
	}

}

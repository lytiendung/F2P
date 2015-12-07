package factory;

import dao.ForestFragmentDao;

public class FragmentDaoFactory {
	private static ForestFragmentDao forestDao;

	public static ForestFragmentDao getInstanceForest() {
		if (forestDao == null)
			forestDao = new ForestFragmentDao();
		return forestDao;
	}

}

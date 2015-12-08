package factory;

import dao.AbstractFragmentDao;
import dao.ForestFragmentDao;
import dao.ForestryOtherFragmentDao;
import dao.VehicleFragmentDao;
import dao.ViolatorFragmentDao;
import dao.WildAnimalFragmentDao;
import dao.WoodFragmentDao;

public class FragmentDaoFactory {
	private static ForestFragmentDao forestDao;
	private static VehicleFragmentDao vehicleDao;
	private static WildAnimalFragmentDao wildAnimalDao;
	private static ForestryOtherFragmentDao forestryOtherDao;
	private static WoodFragmentDao woodDao;
	private static ViolatorFragmentDao violatorDao;

	public static ForestFragmentDao getInstanceForest() {
		if (forestDao == null)
			forestDao = new ForestFragmentDao();
		return forestDao;
	}

	public static AbstractFragmentDao getInstanceVehicle() {
		if (vehicleDao == null)
			vehicleDao = new VehicleFragmentDao();
		return vehicleDao;
	}

	public static AbstractFragmentDao getInstanceWildAnimal() {
		if (wildAnimalDao == null)
			wildAnimalDao = new WildAnimalFragmentDao();
		return wildAnimalDao;
	}

	public static AbstractFragmentDao getInstanceForestryOther() {
		if (forestryOtherDao == null)
			forestryOtherDao = new ForestryOtherFragmentDao();
		return forestryOtherDao;
	}

	public static AbstractFragmentDao getInstanceWoodDao() {
		if (woodDao == null)
			woodDao = new WoodFragmentDao();
		return woodDao;
	}

	public static AbstractFragmentDao getInstanceViolatorDao() {
		if (violatorDao == null)
			violatorDao = new ViolatorFragmentDao();
		return violatorDao;
	}

}

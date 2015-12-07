package factory;

import dao.AbstractFragmentDao;
import dao.ForestFragmentDao;
import dao.ForestryOtherDao;
import dao.VehicleFragmentDao;
import dao.ViolatorDao;
import dao.WildAnimalDao;
import dao.WoodDao;

public class FragmentDaoFactory {
	private static ForestFragmentDao forestDao;
	private static VehicleFragmentDao vehicleDao;
	private static WildAnimalDao wildAnimalDao;
	private static ForestryOtherDao forestryOtherDao;
	private static WoodDao woodDao;
	private static ViolatorDao violatorDao;

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
			wildAnimalDao = new WildAnimalDao();
		return wildAnimalDao;
	}

	public static AbstractFragmentDao getInstanceForestryOther() {
		if (forestryOtherDao == null)
			forestryOtherDao = new ForestryOtherDao();
		return forestryOtherDao;
	}

	public static AbstractFragmentDao getInstanceWoodDao() {
		if (woodDao == null)
			woodDao = new WoodDao();
		return woodDao;
	}

	public static AbstractFragmentDao getInstanceViolatorDao() {
		if (violatorDao == null)
			violatorDao = new ViolatorDao();
		return violatorDao;
	}

}

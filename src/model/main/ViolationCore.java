package model.main;

import java.util.ArrayList;

import dao.ViolationDao;

public class ViolationCore implements Subject {
	private ArrayList<Observer> observers;

	public ViolationCore() {
		this.observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public boolean notifyUpdateBreachId() {
		long breachId = ViolationDao.getModel().getId();
		boolean result = true;

		for (Observer observer : observers) {
			observer.updateBreachId(breachId);
		}

		return result;
	}

	@Override
	public boolean notifyDelete() {
		long breachId = ViolationDao.getModel().getId();
		boolean result = true;

		for (Observer observer : observers) {
			observer.deleteByBreachId(breachId);
		}

		return result;
	}

	public boolean saveOrUpdate() {
		if (ViolationDao.updateTmpModel())
			return notifyUpdateBreachId();
		return false;
	}

	public boolean delete() {
		if (ViolationDao.delete(ViolationDao.getModel().getId()))
			return notifyDelete();
		return false;
	}

	public void resetViolation() {
		if (ViolationDao.isTmpModel()) {
			notifyDelete();
		} else {
			notifyUpdateBreachId();
		}
		ViolationDao.clearTmpModel();
	}

	public void addViolation() {
		ViolationDao.clearTmpModel();
	}

}

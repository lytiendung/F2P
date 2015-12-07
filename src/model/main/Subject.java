package model.main;

public interface Subject {

	public void registerObserver(Observer o);

	public boolean notifyUpdateBreachId();

	public boolean notifyDelete();
}

package model.objs;

public abstract class AbstractModelObject {
	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public abstract boolean isEmptyObj();

}

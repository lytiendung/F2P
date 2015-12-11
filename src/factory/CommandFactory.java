package factory;

public interface CommandFactory {
	public static final String ADD_CMD = "add";
	public static final String SHOW_CMD = "show";
	public static final String DELETE_CMD = "del";
	public static final String MODIFY_CMD = "mdf";
	public static final String RELOAD_CMD = "reld";
	public static final String CANCEL_CMD = "canl";
	public static final String EXIT_CMD = "exit";
	public static final String LOGGOUT_CMD = "lgt";
	public static final String POPUP_CMD = "popp";
	public static final String STATISTIC_CMD = "sta";
	public static final String REFRESH_CMD = "ref";
	public static final String COMPUTING_CMD = "comp";
	public static final String SAVE_CMD = "save";
	public static final String SETTINGS_CMD = "set";
	public static final String AUTO_CMD = "aut";
	public static final String GUESS_SESSION_CMD = "gus";
	public static final String BACK_CMD = "bak";
	public static final String CELL_CHECKBOX_CMD = "ccb";
	public static final String LOGIN_CMD = "login";
	public static final String RESET_TABLE_SORT_CMD = "rtso";
	public static final String RESET_CMD = "reset";
	public static final String CBX1_CMD = "cbx1";
	public static final String CBX2_CMD = "cbx2";
	public static final String OWNER_CMD = "owner";

	public static final String HOR_SCROLL_CMD = "hscroll";
	public static final String PACK_CURRENT_COL_CMD = "packcol";
	public static final String PACK_ALL_COL_CMD = "packall";

	// panel command name
	public static final String PANEL_LIB_TREE = "libTrees";
	public static final String PANEL_WORKSPACE = "workspace";
	public static final String PANEL_LOGIN = "plogin";
	public static final String PANEL_LIB_SOLUTION = "libSolution";
	public static final String PANEL_LIB_ANIMAL = "libanimal";
	public static final String PANEL_VIOLATION = "viopanel";
}

package model.objs;

import java.awt.Container;

import factory.MessageFactory;

public class LoginModel {

	public void doExit(Container view) {
		int answer = MessageFactory.showQuestionDialog(view, "Thoát khỏi hệ thống?", "Thoát",
				MessageFactory.QUESTION_MESSAGE);
		if (answer == MessageFactory.OK_OPTION)
			System.exit(0);
	}
}

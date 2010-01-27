package org.javarosa.formmanager.api;

import org.javarosa.core.api.State;
import org.javarosa.core.model.instance.FormInstance;
import org.javarosa.formmanager.api.transitions.CompletedFormOptionsTransitions;

public abstract class CompletedFormOptionsState implements CompletedFormOptionsTransitions, State {

	private FormInstance data;
	
	public CompletedFormOptionsState (FormInstance data) {
		this.data = data;
	}
	
	public void start () {
		CompletedFormOptionsController controller = getController();
		controller.setTransitions(this);
		controller.start();
	}
	
	protected CompletedFormOptionsController getController () {
		return new CompletedFormOptionsController(data);
	}
	
}
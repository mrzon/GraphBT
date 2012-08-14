package btdebuggertool.sourceProvider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class DebugToolsCommandSourceProvider extends AbstractSourceProvider {
	public final static String PLAY_COMMAND_STATE = "btdebuggertool.sourceProvider.playState";
	public final static String STOP_COMMAND_STATE = "btdebuggertool.sourceProvider.stopState";
	public final static String PAUSE_COMMAND_STATE = "btdebuggertool.sourceProvider.pauseState";
	public final static String STEP_COMMAND_STATE = "btdebuggertool.sourceProvider.stepState";
	
	public final static String TRUE = "enabled", FALSE = "disabled";
	
	private boolean playState, stopState, pauseState, stepState;
	
	@Override
	public void dispose() {
		
	}

	@Override
	public Map getCurrentState() {
		Map currentState = new HashMap();
		currentState.put(PLAY_COMMAND_STATE, this.playState ? TRUE : FALSE);
		currentState.put(STOP_COMMAND_STATE, this.stopState ? TRUE : FALSE);
		currentState.put(PAUSE_COMMAND_STATE, this.pauseState ? TRUE : FALSE);
		currentState.put(STEP_COMMAND_STATE, this.stepState ? TRUE : FALSE);
		
		return currentState;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[]{PLAY_COMMAND_STATE, STOP_COMMAND_STATE, PAUSE_COMMAND_STATE, STEP_COMMAND_STATE};
	}
	
	public void setPlayState(boolean enabled){
		if(this.playState == enabled)
			return;
		this.playState = enabled;
		fireSourceChanged(ISources.ACTIVE_PART_ID, PLAY_COMMAND_STATE, this.playState ? TRUE : FALSE);
	}
	
	public void setStopState(boolean enabled){
		if(this.stopState == enabled)
			return;
		this.stopState = enabled;
		fireSourceChanged(ISources.ACTIVE_PART_ID, STOP_COMMAND_STATE, this.stopState ? TRUE : FALSE);
	}
	
	public void setPauseState(boolean enabled){
		if(this.pauseState == enabled)
			return;
		this.pauseState = enabled;
		fireSourceChanged(ISources.ACTIVE_PART_ID, PAUSE_COMMAND_STATE, this.pauseState ? TRUE : FALSE);
	}
	
	public void setStepState(boolean enabled){
		if(this.stepState == enabled)
			return;
		this.stepState = enabled;
		fireSourceChanged(ISources.ACTIVE_PART_ID, STEP_COMMAND_STATE, this.stepState ? TRUE : FALSE);
	}

}

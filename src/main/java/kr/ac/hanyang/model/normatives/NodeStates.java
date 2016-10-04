package kr.ac.hanyang.model.normatives;

/**
 * Created by blainechai on 2016. 8. 24..
 */

/**
 * 3.3.1 Node States
 * <p>
 * Node State
 * <p>
 * Value Transitional Description
 * initial no Node is not yet created. Node only exists as a template definition.
 * creating yes Node is transitioning from initial state to created state.
 * created no Node software has been installed.
 * configuring yes Node is transitioning from created state to configured state.
 * configured no Node has been configured prior to being started.
 * starting yes Node is transitioning from configured state to started state.
 * started no Node is started.
 * stopping yes Node is transitioning from its current state to a configured state.
 * deleting yes Node is transitioning from its current state to one where it is deleted and its state is no longer tracked by the instance model.
 * error no Node is in an error state.
 */
public interface NodeStates {
    class state {

    }
}

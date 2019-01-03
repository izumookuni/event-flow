package cc.domovoi.eventflow.core.event;

public interface EventLike<S, SR> {

    SR init(S s);

    default SR flow(S s) {
        return init(s);
    }
}

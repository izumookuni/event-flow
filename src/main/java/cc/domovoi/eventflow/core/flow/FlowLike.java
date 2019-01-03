package cc.domovoi.eventflow.core.flow;

import cc.domovoi.eventflow.core.event.EventLike;

import java.util.function.Function;

public interface FlowLike<S, SR, O, OR extends EventLike<O, OR>> extends Function<S, O> {

    OR event();

    O flowOutFunction(S s);

    default OR flowOut(S s) {
        return event().init(flowOutFunction(s));
    }

    default O apply(S s) {
        return flowOutFunction(s);
    }

    default Function<? super S, ? extends OR> flowOutCurryingEvent(EventLike<O, OR> event) {
        return (s) -> event.init(flowOutFunction(s));
    }

    default Function<? super EventLike<O, OR>, ? extends OR> flowOutCurryingParam(S s) {
        return (event) -> event.init(flowOutFunction(s));
    }
}

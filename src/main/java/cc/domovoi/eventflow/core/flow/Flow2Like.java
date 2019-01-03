package cc.domovoi.eventflow.core.flow;

import cc.domovoi.ej.collection.tuple.Tuple2;
import cc.domovoi.eventflow.core.event.EventLike;
import cc.domovoi.eventflow.core.event.EventTuple2;

public interface Flow2Like<S, SR, O1, OR1 extends EventLike<O1, OR1>, O2, OR2 extends EventLike<O2, OR2>>
        extends FlowLike<S, SR, Tuple2<O1, O2>, EventTuple2<O1, OR1, O2, OR2>> {

    OR1 event1();

    OR2 event2();

    O1 flowOut1Function(S s);

    O2 flowOut2Function(S s);

    default OR1 flowOut1(S s) {
        return event1().init(flowOut1Function(s));
    }

    default OR2 flowOut2(S s) {
        return event2().init(flowOut2Function(s));
    }

    @Override
    default EventTuple2<O1, OR1, O2, OR2> event() {
        return EventTuple2.empty(event1(), event2());
    }

    @Override
    default Tuple2<O1, O2> flowOutFunction(S s) {
        return new Tuple2<>(flowOut1Function(s), flowOut2Function(s));
    }
}

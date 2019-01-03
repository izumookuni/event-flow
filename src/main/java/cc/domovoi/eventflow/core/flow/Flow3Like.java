package cc.domovoi.eventflow.core.flow;

import cc.domovoi.ej.collection.tuple.Tuple3;
import cc.domovoi.eventflow.core.event.EventLike;
import cc.domovoi.eventflow.core.event.EventTuple3;


public interface Flow3Like<S, SR, O1, OR1 extends EventLike<O1, OR1>, O2, OR2 extends EventLike<O2, OR2>, O3, OR3 extends EventLike<O3, OR3>>
        extends FlowLike<S, SR, Tuple3<O1, O2, O3>, EventTuple3<O1, OR1, O2, OR2, O3, OR3>> {

    OR1 event1();

    OR2 event2();

    OR3 event3();

    O1 flowOut1Function(S s);

    O2 flowOut2Function(S s);

    O3 flowOut3Function(S s);

    default OR1 flowOut1(S s) {
        return event1().init(flowOut1Function(s));
    }

    default OR2 flowOut2(S s) {
        return event2().init(flowOut2Function(s));
    }

    default OR3 flowOut3(S s) {
        return event3().init(flowOut3Function(s));
    }

    @Override
    default EventTuple3<O1, OR1, O2, OR2, O3, OR3> event() {
        return EventTuple3.empty(event1(), event2(), event3());
    }

    @Override
    default Tuple3<O1, O2, O3> flowOutFunction(S s) {
        return new Tuple3<>(flowOut1Function(s), flowOut2Function(s), flowOut3Function(s));
    }
}

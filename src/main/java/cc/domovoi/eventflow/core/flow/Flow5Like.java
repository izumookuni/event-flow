package cc.domovoi.eventflow.core.flow;

import cc.domovoi.ej.collection.tuple.Tuple5;
import cc.domovoi.eventflow.core.event.EventLike;
import cc.domovoi.eventflow.core.event.EventTuple5;

public interface Flow5Like<S, SR, O1, OR1 extends EventLike<O1, OR1>, O2, OR2 extends EventLike<O2, OR2>, O3, OR3 extends EventLike<O3, OR3>, O4, OR4 extends EventLike<O4, OR4>, O5, OR5 extends EventLike<O5, OR5>>
        extends FlowLike<S, SR, Tuple5<O1, O2, O3, O4, O5>, EventTuple5<O1, OR1, O2, OR2, O3, OR3, O4, OR4, O5, OR5>> {

    OR1 event1();

    OR2 event2();

    OR3 event3();

    OR4 event4();

    OR5 event5();

    O1 flowOut1Function(S s);

    O2 flowOut2Function(S s);

    O3 flowOut3Function(S s);

    O4 flowOut4Function(S s);

    O5 flowOut5Function(S s);

    default OR1 flowOut1(S s) {
        return event1().init(flowOut1Function(s));
    }

    default OR2 flowOut2(S s) {
        return event2().init(flowOut2Function(s));
    }

    default OR3 flowOut3(S s) {
        return event3().init(flowOut3Function(s));
    }

    default OR4 flowOut4(S s) {
        return event4().init(flowOut4Function(s));
    }

    default OR5 flowOut5(S s) {
        return event5().init(flowOut5Function(s));
    }

    @Override
    default EventTuple5<O1, OR1, O2, OR2, O3, OR3, O4, OR4, O5, OR5> event() {
        return EventTuple5.empty(event1(), event2(), event3(), event4(), event5());
    }

    @Override
    default Tuple5<O1, O2, O3, O4, O5> flowOutFunction(S s) {
        return new Tuple5<>(flowOut1Function(s), flowOut2Function(s), flowOut3Function(s), flowOut4Function(s), flowOut5Function(s));
    }
}

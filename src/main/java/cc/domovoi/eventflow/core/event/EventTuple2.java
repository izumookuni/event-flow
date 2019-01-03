package cc.domovoi.eventflow.core.event;

import cc.domovoi.ej.collection.tuple.Tuple2;
import cc.domovoi.eventflow.core.flow.FlowLike;

import java.io.Serializable;
import java.util.Objects;

public class EventTuple2<O1, OR1 extends EventLike<O1, OR1>, O2, OR2 extends EventLike<O2, OR2>>
        implements EventLike<Tuple2<O1, O2>, EventTuple2<O1, OR1, O2, OR2>>, Serializable, Cloneable {

    private O1 _1;

    private O2 _2;

    private OR1 event1;

    private OR2 event2;

    private EventTuple2(OR1 event1, OR2 event2) {
        this.event1 = event1;
        this.event2 = event2;
    }

    public EventTuple2(O1 _1, O2 _2, OR1 event1, OR2 event2) {
        this._1 = _1;
        this._2 = _2;
        this.event1 = event1;
        this.event2 = event2;
    }

    public static <P1, PR1 extends EventLike<P1, PR1>, P2, PR2 extends EventLike<P2, PR2>> EventTuple2<P1, PR1, P2, PR2> empty(PR1 event1, PR2 event2) {
        return new EventTuple2<>(event1, event2);
    }

    public OR1 init1(O1 o1) {
        return event1.init(o1);
    }

    public OR2 init2(O2 o2) {
        return event2.init(o2);
    }

    public OR1 flow1(O1 o1) {
        return event1.flow(o1);
    }

    public OR2 flow2(O2 o2) {
        return event2.flow(o2);
    }

    public <P1, PR1 extends EventLike<P1, PR1>> EventTuple2<P1, PR1, O2, OR2> flowMap1(FlowLike<O1, OR1, P1, PR1> flowLike) {
        return new EventTuple2<>(flowLike.flowOutFunction(_1), _2, flowLike.flowOut(_1), event2);
    }

    public <P2, PR2 extends EventLike<P2, PR2>> EventTuple2<O1, OR1, P2, PR2> flowMap2(FlowLike<O2, OR2, P2, PR2> flowLike) {
        return new EventTuple2<>(_1, flowLike.flowOutFunction(_2), event1, flowLike.flowOut(_2));
    }

    @Override
    public EventTuple2<O1, OR1, O2, OR2> init(Tuple2<O1, O2> t2) {
        return new EventTuple2<>(t2._1(), t2._2(), event1, event2);
    }

    @Override
    public EventTuple2<O1, OR1, O2, OR2> flow(Tuple2<O1, O2> t2) {
        return new EventTuple2<>(t2._1(), t2._2(),
                event1.flow(t2._1()), event2.flow(t2._2()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventTuple2<?, ?, ?, ?> that = (EventTuple2<?, ?, ?, ?>) o;
        return Objects.equals(_1, that._1) &&
                Objects.equals(_2, that._2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2);
    }

    @Override
    public String toString() {
        return "EventTuple2{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                '}';
    }

    public O1 _1() {
        return _1;
    }

    public O2 _2() {
        return _2;
    }

    public OR1 event1() {
        return event1;
    }

    public OR2 event2() {
        return event2;
    }
}

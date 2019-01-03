package cc.domovoi.eventflow.core.event;

import cc.domovoi.ej.collection.tuple.Tuple3;

import java.io.Serializable;
import java.util.Objects;

public class EventTuple3<O1, OR1 extends EventLike<O1, OR1>, O2, OR2 extends EventLike<O2, OR2>, O3, OR3 extends EventLike<O3, OR3>>
        implements EventLike<Tuple3<O1, O2, O3>, EventTuple3<O1, OR1, O2, OR2, O3, OR3>>, Serializable, Cloneable {

    private O1 _1;

    private O2 _2;

    private O3 _3;

    private OR1 event1;

    private OR2 event2;

    private OR3 event3;

    private EventTuple3(OR1 event1, OR2 event2, OR3 event3) {
        this.event1 = event1;
        this.event2 = event2;
        this.event3 = event3;
    }

    public EventTuple3(O1 _1, O2 _2, O3 _3, OR1 event1, OR2 event2, OR3 event3) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this.event1 = event1;
        this.event2 = event2;
        this.event3 = event3;
    }

    public static <P1, PR1 extends EventLike<P1, PR1>, P2, PR2 extends EventLike<P2, PR2>, P3, PR3 extends EventLike<P3, PR3>> EventTuple3<P1, PR1, P2, PR2, P3, PR3> empty(PR1 event1, PR2 event2, PR3 event3) {
        return new EventTuple3<>(event1, event2, event3);
    }

    public OR1 init1(O1 o1) {
        return event1.init(o1);
    }

    public OR2 init2(O2 o2) {
        return event2.init(o2);
    }

    public OR3 init3(O3 o3) {
        return event3.init(o3);
    }

    public OR1 flow1(O1 o1) {
        return event1.flow(o1);
    }

    public OR2 flow2(O2 o2) {
        return event2.flow(o2);
    }

    public OR3 flow3(O3 o3) {
        return event3.flow(o3);
    }

    @Override
    public EventTuple3<O1, OR1, O2, OR2, O3, OR3> init(Tuple3<O1, O2, O3> t3) {
        return new EventTuple3<>(t3._1(), t3._2(), t3._3(), event1, event2, event3);
    }

    @Override
    public EventTuple3<O1, OR1, O2, OR2, O3, OR3> flow(Tuple3<O1, O2, O3> t3) {
        return new EventTuple3<>(t3._1(), t3._2(), t3._3(),
                event1.flow(t3._1()), event2.flow(t3._2()), event3.flow(t3._3()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventTuple3<?, ?, ?, ?, ?, ?> that = (EventTuple3<?, ?, ?, ?, ?, ?>) o;
        return Objects.equals(_1, that._1) &&
                Objects.equals(_2, that._2) &&
                Objects.equals(_3, that._3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2, _3);
    }

    @Override
    public String toString() {
        return "EventTuple3{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                ", _3=" + _3 +
                '}';
    }

    public O1 _1() {
        return _1;
    }

    public O2 _2() {
        return _2;
    }

    public O3 _3() {
        return _3;
    }

    public OR1 event1() {
        return event1;
    }

    public OR2 event2() {
        return event2;
    }

    public OR3 event3() {
        return event3;
    }
}

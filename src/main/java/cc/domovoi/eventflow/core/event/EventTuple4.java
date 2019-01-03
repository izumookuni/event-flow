package cc.domovoi.eventflow.core.event;

import cc.domovoi.ej.collection.tuple.Tuple4;

import java.io.Serializable;
import java.util.Objects;

public class EventTuple4<O1, OR1 extends EventLike<O1, OR1>, O2, OR2 extends EventLike<O2, OR2>, O3, OR3 extends EventLike<O3, OR3>, O4, OR4 extends EventLike<O4, OR4>>
        implements EventLike<Tuple4<O1, O2, O3, O4>, EventTuple4<O1, OR1, O2, OR2, O3, OR3, O4, OR4>>, Serializable, Cloneable {

    private O1 _1;

    private O2 _2;

    private O3 _3;

    private O4 _4;

    private OR1 event1;

    private OR2 event2;

    private OR3 event3;

    private OR4 event4;

    public EventTuple4(OR1 event1, OR2 event2, OR3 event3, OR4 event4) {
        this.event1 = event1;
        this.event2 = event2;
        this.event3 = event3;
        this.event4 = event4;
    }

    public EventTuple4(O1 _1, O2 _2, O3 _3, O4 _4, OR1 event1, OR2 event2, OR3 event3, OR4 event4) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this.event1 = event1;
        this.event2 = event2;
        this.event3 = event3;
        this.event4 = event4;
    }

    public static <P1, PR1 extends EventLike<P1, PR1>, P2, PR2 extends EventLike<P2, PR2>, P3, PR3 extends EventLike<P3, PR3>, P4, PR4 extends EventLike<P4, PR4>> EventTuple4<P1, PR1, P2, PR2, P3, PR3, P4, PR4> empty(PR1 event1, PR2 event2, PR3 event3, PR4 event4) {
        return new EventTuple4<>(event1, event2, event3, event4);
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

    public OR4 init4(O4 o4) {
        return event4.init(o4);
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

    public OR4 flow4(O4 o4) {
        return event4.flow(o4);
    }

    @Override
    public EventTuple4<O1, OR1, O2, OR2, O3, OR3, O4, OR4> init(Tuple4<O1, O2, O3, O4> t4) {
        return new EventTuple4<>(t4._1(), t4._2(), t4._3(), t4._4(), event1, event2, event3, event4);
    }

    @Override
    public EventTuple4<O1, OR1, O2, OR2, O3, OR3, O4, OR4> flow(Tuple4<O1, O2, O3, O4> t4) {
        return new EventTuple4<>(t4._1(), t4._2(), t4._3(), t4._4(),
                event1.flow(t4._1()), event2.flow(t4._2()), event3.flow(t4._3()), event4.flow(t4._4()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventTuple4<?, ?, ?, ?, ?, ?, ?, ?> that = (EventTuple4<?, ?, ?, ?, ?, ?, ?, ?>) o;
        return Objects.equals(_1, that._1) &&
                Objects.equals(_2, that._2) &&
                Objects.equals(_3, that._3) &&
                Objects.equals(_4, that._4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2, _3, _4);
    }

    @Override
    public String toString() {
        return "EventTuple4{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                ", _3=" + _3 +
                ", _4=" + _4 +
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

    public O4 _4() {
        return _4;
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

    public OR4 event4() {
        return event4;
    }
}

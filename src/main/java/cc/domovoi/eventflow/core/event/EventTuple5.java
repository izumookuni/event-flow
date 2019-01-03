package cc.domovoi.eventflow.core.event;

import cc.domovoi.ej.collection.tuple.Tuple5;

import java.io.Serializable;
import java.util.Objects;

public class EventTuple5<O1, OR1 extends EventLike<O1, OR1>, O2, OR2 extends EventLike<O2, OR2>, O3, OR3 extends EventLike<O3, OR3>, O4, OR4 extends EventLike<O4, OR4>, O5, OR5 extends EventLike<O5, OR5>>
        implements EventLike<Tuple5<O1, O2, O3, O4, O5>, EventTuple5<O1, OR1, O2, OR2, O3, OR3, O4, OR4, O5, OR5>>, Serializable, Cloneable {

    private O1 _1;

    private O2 _2;

    private O3 _3;

    private O4 _4;

    private O5 _5;

    private OR1 event1;

    private OR2 event2;

    private OR3 event3;

    private OR4 event4;

    private OR5 event5;

    public EventTuple5(OR1 event1, OR2 event2, OR3 event3, OR4 event4, OR5 event5) {
        this.event1 = event1;
        this.event2 = event2;
        this.event3 = event3;
        this.event4 = event4;
        this.event5 = event5;
    }

    public EventTuple5(O1 _1, O2 _2, O3 _3, O4 _4, O5 _5, OR1 event1, OR2 event2, OR3 event3, OR4 event4, OR5 event5) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this.event1 = event1;
        this.event2 = event2;
        this.event3 = event3;
        this.event4 = event4;
        this.event5 = event5;
    }

    public static <P1, PR1 extends EventLike<P1, PR1>, P2, PR2 extends EventLike<P2, PR2>, P3, PR3 extends EventLike<P3, PR3>, P4, PR4 extends EventLike<P4, PR4>, P5, PR5 extends EventLike<P5, PR5>> EventTuple5<P1, PR1, P2, PR2, P3, PR3, P4, PR4, P5, PR5> empty(PR1 event1, PR2 event2, PR3 event3, PR4 event4, PR5 event5) {
        return new EventTuple5<>(event1, event2, event3, event4, event5);
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

    public OR5 init5(O5 o5) {
        return event5.init(o5);
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

    public OR5 flow5(O5 o5) {
        return event5.flow(o5);
    }

    @Override
    public EventTuple5<O1, OR1, O2, OR2, O3, OR3, O4, OR4, O5, OR5> init(Tuple5<O1, O2, O3, O4, O5> t5) {
        return new EventTuple5<>(t5._1(), t5._2(), t5._3(), t5._4(), t5._5(), event1, event2, event3, event4, event5);
    }

    @Override
    public EventTuple5<O1, OR1, O2, OR2, O3, OR3, O4, OR4, O5, OR5> flow(Tuple5<O1, O2, O3, O4, O5> t5) {
        return new EventTuple5<>(t5._1(), t5._2(), t5._3(), t5._4(), t5._5(),
                event1.flow(t5._1()), event2.flow(t5._2()), event3.flow(t5._3()), event4.flow(t5._4()), event5.flow(t5._5()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventTuple5<?, ?, ?, ?, ?, ?, ?, ?, ?, ?> that = (EventTuple5<?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) o;
        return Objects.equals(_1, that._1) &&
                Objects.equals(_2, that._2) &&
                Objects.equals(_3, that._3) &&
                Objects.equals(_4, that._4) &&
                Objects.equals(_5, that._5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2, _3, _4, _5);
    }

    @Override
    public String toString() {
        return "EventTuple5{" +
                "_1=" + _1 +
                ", _2=" + _2 +
                ", _3=" + _3 +
                ", _4=" + _4 +
                ", _5=" + _5 +
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

    public O5 _5() {
        return _5;
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

    public OR5 event5() {
        return event5;
    }
}

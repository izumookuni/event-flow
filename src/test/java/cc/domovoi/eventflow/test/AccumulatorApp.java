package cc.domovoi.eventflow.test;

import cc.domovoi.ej.collection.tuple.Tuple2;
import cc.domovoi.eventflow.core.event.EventLike;
import cc.domovoi.eventflow.core.event.EventTuple2;
import cc.domovoi.eventflow.core.flow.Flow2Like;
import org.junit.Assert;
import org.junit.Test;

public class AccumulatorApp {

    @Test
    public void testAccumulator() {

        Integer result1 = new Accumulator().accumulate().accumulate().accumulate().result().getResult();
        Assert.assertEquals(new Integer(3), result1);

        Integer result2 = new Accumulator().accumulate(3).accumulate(6).accumulate().result().getResult();
        Assert.assertEquals(new Integer(10), result2);

        Integer result3 = new Accumulator(100).accumulate().accumulate(10).result().getResult();
        Assert.assertEquals(new Integer(111), result3);

        EventTuple2<Integer, Accumulator, Integer, Result> resultTuple2 = new Accumulator().flowOut(100);
        for (int i = 0; i < 5; i++) {
            resultTuple2 = resultTuple2.init(new Tuple2<>(10, 100));
        }

        Integer result4 = resultTuple2.init1(5).result().getResult();
        Assert.assertEquals(new Integer(5), result4);

        Integer result5 = resultTuple2.init2(111).getResult();
        Assert.assertEquals(new Integer(111), result5);
    }

    class Accumulator implements Flow2Like<Integer, Accumulator, Integer, Accumulator, Integer, Result>, EventLike<Integer, Accumulator> {

        private Integer value;

        private Accumulator(Integer value) {
            this.value = value;
        }

        public Accumulator() {
            this.value = 0;
        }

        public Accumulator accumulate() {
            return flowOut1(1);
        }

        public Accumulator accumulate(Integer integer) {
            return flowOut1(integer);
        }

        public Result result() {
            return flowOut2(null);
        }

        @Override
        public Accumulator init(Integer integer) {
            return new Accumulator(integer);
        }

        @Override
        public Accumulator event1() {
            return new Accumulator();
        }

        @Override
        public Result event2() {
            return new Result();
        }

        @Override
        public Integer flowOut1Function(Integer integer) {
            return value + integer;
        }

        @Override
        public Integer flowOut2Function(Integer integer) {
            return value;
        }

        @Override
        public Accumulator flow(Integer integer) {
            return new Accumulator(this.value + integer);
        }
    }

    class Result implements EventLike<Integer, Result> {

        private Integer result;

        private Result(Integer result) {
            this.result = result;
        }

        public Result() {
        }

        @Override
        public Result init(Integer integer) {
            return new Result(integer);
        }

        @Override
        public Result flow(Integer integer) {
            return new Result(integer);
        }

        public Integer getResult() {
            return result;
        }
    }
}

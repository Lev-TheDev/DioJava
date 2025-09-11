package edu.lev.collections.calc;

import java.util.stream.LongStream;

public enum Operation {

    SUM(n -> LongStream.of(n).sum(), "+"),
    SUBTRACTION(n -> LongStream.of(n).reduce(0, (a, b) -> a - b), "-");

    private final ICalc operationCallback;

    private final String signal;

    Operation(ICalc operationCallback, String signal) {
        this.operationCallback = operationCallback;
        this.signal = signal;
    }

    public ICalc getOperationCallback() {
        return operationCallback;
    }

    public String getSignal() {
        return signal;
    }
}

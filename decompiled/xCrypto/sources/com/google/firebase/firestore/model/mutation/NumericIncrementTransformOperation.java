package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public class NumericIncrementTransformOperation implements TransformOperation {
    private C1698D operand;

    public NumericIncrementTransformOperation(C1698D c1698d) {
        Assert.hardAssert(Values.isNumber(c1698d), "NumericIncrementTransformOperation expects a NumberValue operand", new Object[0]);
        this.operand = c1698d;
    }

    private double operandAsDouble() {
        if (Values.isDouble(this.operand)) {
            return this.operand.z();
        }
        if (Values.isInteger(this.operand)) {
            return this.operand.B();
        }
        throw Assert.fail("Expected 'operand' to be of Number type, but was " + this.operand.getClass().getCanonicalName(), new Object[0]);
    }

    private long operandAsLong() {
        if (Values.isDouble(this.operand)) {
            return (long) this.operand.z();
        }
        if (Values.isInteger(this.operand)) {
            return this.operand.B();
        }
        throw Assert.fail("Expected 'operand' to be of Number type, but was " + this.operand.getClass().getCanonicalName(), new Object[0]);
    }

    private long safeIncrement(long j4, long j5) {
        long j6 = j4 + j5;
        return ((j4 ^ j6) & (j5 ^ j6)) >= 0 ? j6 : j6 >= 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public C1698D applyToLocalView(C1698D c1698d, Timestamp timestamp) {
        C1698D c1698dComputeBaseValue = computeBaseValue(c1698d);
        if (Values.isInteger(c1698dComputeBaseValue) && Values.isInteger(this.operand)) {
            return (C1698D) C1698D.I().m(safeIncrement(c1698dComputeBaseValue.B(), operandAsLong())).build();
        }
        if (Values.isInteger(c1698dComputeBaseValue)) {
            return (C1698D) C1698D.I().k(c1698dComputeBaseValue.B() + operandAsDouble()).build();
        }
        Assert.hardAssert(Values.isDouble(c1698dComputeBaseValue), "Expected NumberValue to be of type DoubleValue, but was ", c1698d.getClass().getCanonicalName());
        return (C1698D) C1698D.I().k(c1698dComputeBaseValue.z() + operandAsDouble()).build();
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public C1698D computeBaseValue(C1698D c1698d) {
        return Values.isNumber(c1698d) ? c1698d : (C1698D) C1698D.I().m(0L).build();
    }

    public C1698D getOperand() {
        return this.operand;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public C1698D applyToRemoteDocument(C1698D c1698d, C1698D c1698d2) {
        return c1698d2;
    }
}

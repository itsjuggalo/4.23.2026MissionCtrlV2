package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Values;
import java.util.Collections;
import java.util.List;
import p2.C1698D;
import p2.C1705b;

/* JADX INFO: loaded from: classes.dex */
public abstract class ArrayTransformOperation implements TransformOperation {
    private final List<C1698D> elements;

    public static class Remove extends ArrayTransformOperation {
        public Remove(List<C1698D> list) {
            super(list);
        }

        @Override // com.google.firebase.firestore.model.mutation.ArrayTransformOperation
        public C1698D apply(C1698D c1698d) {
            C1705b.C0224b c0224bCoercedFieldValuesArray = ArrayTransformOperation.coercedFieldValuesArray(c1698d);
            for (C1698D c1698d2 : getElements()) {
                int i4 = 0;
                while (i4 < c0224bCoercedFieldValuesArray.i()) {
                    if (Values.equals(c0224bCoercedFieldValuesArray.h(i4), c1698d2)) {
                        c0224bCoercedFieldValuesArray.j(i4);
                    } else {
                        i4++;
                    }
                }
            }
            return (C1698D) C1698D.I().g(c0224bCoercedFieldValuesArray).build();
        }
    }

    public static class Union extends ArrayTransformOperation {
        public Union(List<C1698D> list) {
            super(list);
        }

        @Override // com.google.firebase.firestore.model.mutation.ArrayTransformOperation
        public C1698D apply(C1698D c1698d) {
            C1705b.C0224b c0224bCoercedFieldValuesArray = ArrayTransformOperation.coercedFieldValuesArray(c1698d);
            for (C1698D c1698d2 : getElements()) {
                if (!Values.contains(c0224bCoercedFieldValuesArray, c1698d2)) {
                    c0224bCoercedFieldValuesArray.g(c1698d2);
                }
            }
            return (C1698D) C1698D.I().g(c0224bCoercedFieldValuesArray).build();
        }
    }

    public ArrayTransformOperation(List<C1698D> list) {
        this.elements = Collections.unmodifiableList(list);
    }

    public static C1705b.C0224b coercedFieldValuesArray(C1698D c1698d) {
        return Values.isArray(c1698d) ? (C1705b.C0224b) c1698d.v().toBuilder() : C1705b.t();
    }

    public abstract C1698D apply(C1698D c1698d);

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public C1698D applyToLocalView(C1698D c1698d, Timestamp timestamp) {
        return apply(c1698d);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public C1698D applyToRemoteDocument(C1698D c1698d, C1698D c1698d2) {
        return apply(c1698d);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public C1698D computeBaseValue(C1698D c1698d) {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.elements.equals(((ArrayTransformOperation) obj).elements);
    }

    public List<C1698D> getElements() {
        return this.elements;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.elements.hashCode();
    }
}

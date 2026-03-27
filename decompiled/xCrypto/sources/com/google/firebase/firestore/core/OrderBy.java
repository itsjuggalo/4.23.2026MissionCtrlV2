package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public class OrderBy {
    private final Direction direction;
    final FieldPath field;

    public enum Direction {
        ASCENDING(1),
        DESCENDING(-1);

        private final int comparisonModifier;

        Direction(int i4) {
            this.comparisonModifier = i4;
        }

        public int getComparisonModifier() {
            return this.comparisonModifier;
        }
    }

    private OrderBy(Direction direction, FieldPath fieldPath) {
        this.direction = direction;
        this.field = fieldPath;
    }

    public static OrderBy getInstance(Direction direction, FieldPath fieldPath) {
        return new OrderBy(direction, fieldPath);
    }

    public int compare(Document document, Document document2) {
        int comparisonModifier;
        int iCompare;
        if (this.field.equals(FieldPath.KEY_PATH)) {
            comparisonModifier = this.direction.getComparisonModifier();
            iCompare = document.getKey().compareTo(document2.getKey());
        } else {
            C1698D field = document.getField(this.field);
            C1698D field2 = document2.getField(this.field);
            Assert.hardAssert((field == null || field2 == null) ? false : true, "Trying to compare documents on fields that don't exist.", new Object[0]);
            comparisonModifier = this.direction.getComparisonModifier();
            iCompare = Values.compare(field, field2);
        }
        return comparisonModifier * iCompare;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof OrderBy)) {
            OrderBy orderBy = (OrderBy) obj;
            if (this.direction == orderBy.direction && this.field.equals(orderBy.field)) {
                return true;
            }
        }
        return false;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public FieldPath getField() {
        return this.field;
    }

    public int hashCode() {
        return ((899 + this.direction.hashCode()) * 31) + this.field.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.direction == Direction.ASCENDING ? "" : "-");
        sb.append(this.field.canonicalString());
        return sb.toString();
    }
}

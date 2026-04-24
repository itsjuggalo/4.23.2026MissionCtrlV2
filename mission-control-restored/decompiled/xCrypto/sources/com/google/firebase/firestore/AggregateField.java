package com.google.firebase.firestore;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class AggregateField {
    private final String alias;
    private final FieldPath fieldPath;
    private final String operator;

    public static class AverageAggregateField extends AggregateField {
        private AverageAggregateField(FieldPath fieldPath) {
            super(fieldPath, "average");
        }
    }

    public static class CountAggregateField extends AggregateField {
        /* JADX WARN: Multi-variable type inference failed */
        private CountAggregateField() {
            super(null, "count");
        }
    }

    public static class SumAggregateField extends AggregateField {
        private SumAggregateField(FieldPath fieldPath) {
            super(fieldPath, "sum");
        }
    }

    public static AverageAggregateField average(String str) {
        return new AverageAggregateField(FieldPath.fromDotSeparatedPath(str));
    }

    public static CountAggregateField count() {
        return new CountAggregateField();
    }

    public static SumAggregateField sum(String str) {
        return new SumAggregateField(FieldPath.fromDotSeparatedPath(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AggregateField)) {
            return false;
        }
        AggregateField aggregateField = (AggregateField) obj;
        FieldPath fieldPath = this.fieldPath;
        return (fieldPath == null || aggregateField.fieldPath == null) ? fieldPath == null && aggregateField.fieldPath == null : this.operator.equals(aggregateField.getOperator()) && getFieldPath().equals(aggregateField.getFieldPath());
    }

    public String getAlias() {
        return this.alias;
    }

    public String getFieldPath() {
        FieldPath fieldPath = this.fieldPath;
        return fieldPath == null ? "" : fieldPath.toString();
    }

    public String getOperator() {
        return this.operator;
    }

    public int hashCode() {
        return Objects.hash(getOperator(), getFieldPath());
    }

    private AggregateField(FieldPath fieldPath, String str) {
        String str2;
        this.fieldPath = fieldPath;
        this.operator = str;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (fieldPath == null) {
            str2 = "";
        } else {
            str2 = "_" + fieldPath;
        }
        sb.append(str2);
        this.alias = sb.toString();
    }

    public static AverageAggregateField average(FieldPath fieldPath) {
        return new AverageAggregateField(fieldPath);
    }

    public static SumAggregateField sum(FieldPath fieldPath) {
        return new SumAggregateField(fieldPath);
    }
}

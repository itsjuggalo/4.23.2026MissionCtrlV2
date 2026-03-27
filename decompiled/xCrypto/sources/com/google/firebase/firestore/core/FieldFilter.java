package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public class FieldFilter extends Filter {
    private final FieldPath field;
    private final Operator operator;
    private final C1698D value;

    /* JADX INFO: renamed from: com.google.firebase.firestore.core.FieldFilter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator;

        static {
            int[] iArr = new int[Operator.values().length];
            $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator = iArr;
            try {
                iArr[Operator.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[Operator.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[Operator.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[Operator.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[Operator.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum Operator {
        LESS_THAN("<"),
        LESS_THAN_OR_EQUAL("<="),
        EQUAL("=="),
        NOT_EQUAL("!="),
        GREATER_THAN(">"),
        GREATER_THAN_OR_EQUAL(">="),
        ARRAY_CONTAINS("array_contains"),
        ARRAY_CONTAINS_ANY("array_contains_any"),
        IN("in"),
        NOT_IN("not_in");

        private final String text;

        Operator(String str) {
            this.text = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.text;
        }
    }

    public FieldFilter(FieldPath fieldPath, Operator operator, C1698D c1698d) {
        this.field = fieldPath;
        this.operator = operator;
        this.value = c1698d;
    }

    public static FieldFilter create(FieldPath fieldPath, Operator operator, C1698D c1698d) {
        if (!fieldPath.isKeyField()) {
            return operator == Operator.ARRAY_CONTAINS ? new ArrayContainsFilter(fieldPath, c1698d) : operator == Operator.IN ? new InFilter(fieldPath, c1698d) : operator == Operator.ARRAY_CONTAINS_ANY ? new ArrayContainsAnyFilter(fieldPath, c1698d) : operator == Operator.NOT_IN ? new NotInFilter(fieldPath, c1698d) : new FieldFilter(fieldPath, operator, c1698d);
        }
        if (operator == Operator.IN) {
            return new KeyFieldInFilter(fieldPath, c1698d);
        }
        if (operator == Operator.NOT_IN) {
            return new KeyFieldNotInFilter(fieldPath, c1698d);
        }
        Assert.hardAssert((operator == Operator.ARRAY_CONTAINS || operator == Operator.ARRAY_CONTAINS_ANY) ? false : true, operator.toString() + "queries don't make sense on document keys", new Object[0]);
        return new KeyFieldFilter(fieldPath, operator, c1698d);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof FieldFilter)) {
            FieldFilter fieldFilter = (FieldFilter) obj;
            if (this.operator == fieldFilter.operator && this.field.equals(fieldFilter.field) && this.value.equals(fieldFilter.value)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public String getCanonicalId() {
        return getField().canonicalString() + getOperator().toString() + Values.canonicalId(getValue());
    }

    public FieldPath getField() {
        return this.field;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public List<Filter> getFilters() {
        return Collections.singletonList(this);
    }

    @Override // com.google.firebase.firestore.core.Filter
    public List<FieldFilter> getFlattenedFilters() {
        return Collections.singletonList(this);
    }

    public Operator getOperator() {
        return this.operator;
    }

    public C1698D getValue() {
        return this.value;
    }

    public int hashCode() {
        return ((((1147 + this.operator.hashCode()) * 31) + this.field.hashCode()) * 31) + this.value.hashCode();
    }

    public boolean isInequality() {
        return Arrays.asList(Operator.LESS_THAN, Operator.LESS_THAN_OR_EQUAL, Operator.GREATER_THAN, Operator.GREATER_THAN_OR_EQUAL, Operator.NOT_EQUAL, Operator.NOT_IN).contains(this.operator);
    }

    @Override // com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        C1698D field = document.getField(this.field);
        return this.operator == Operator.NOT_EQUAL ? (field == null || field.H() || !matchesComparison(Values.compare(field, this.value))) ? false : true : field != null && Values.typeOrder(field) == Values.typeOrder(this.value) && matchesComparison(Values.compare(field, this.value));
    }

    public boolean matchesComparison(int i4) {
        switch (AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$FieldFilter$Operator[this.operator.ordinal()]) {
            case 1:
                return i4 < 0;
            case 2:
                return i4 <= 0;
            case 3:
                return i4 == 0;
            case 4:
                return i4 != 0;
            case 5:
                return i4 > 0;
            case 6:
                return i4 >= 0;
            default:
                throw Assert.fail("Unknown FieldFilter operator: %s", this.operator);
        }
    }

    public String toString() {
        return getCanonicalId();
    }
}

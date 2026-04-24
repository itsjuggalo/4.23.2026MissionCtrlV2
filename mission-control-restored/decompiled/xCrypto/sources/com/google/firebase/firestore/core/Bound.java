package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import java.util.List;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public final class Bound {
    private final boolean inclusive;
    private final List<C1698D> position;

    public Bound(List<C1698D> list, boolean z4) {
        this.position = list;
        this.inclusive = z4;
    }

    private int compareToDocument(List<OrderBy> list, Document document) {
        int iCompare;
        Assert.hardAssert(this.position.size() <= list.size(), "Bound has more components than query's orderBy", new Object[0]);
        int i4 = 0;
        for (int i5 = 0; i5 < this.position.size(); i5++) {
            OrderBy orderBy = list.get(i5);
            C1698D c1698d = this.position.get(i5);
            if (orderBy.field.equals(FieldPath.KEY_PATH)) {
                Assert.hardAssert(Values.isReferenceValue(c1698d), "Bound has a non-key value where the key path is being used %s", c1698d);
                iCompare = DocumentKey.fromName(c1698d.D()).compareTo(document.getKey());
            } else {
                C1698D field = document.getField(orderBy.getField());
                Assert.hardAssert(field != null, "Field should exist since document matched the orderBy already.", new Object[0]);
                iCompare = Values.compare(c1698d, field);
            }
            if (orderBy.getDirection().equals(OrderBy.Direction.DESCENDING)) {
                iCompare *= -1;
            }
            i4 = iCompare;
            if (i4 != 0) {
                return i4;
            }
        }
        return i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Bound.class == obj.getClass()) {
            Bound bound = (Bound) obj;
            if (this.inclusive == bound.inclusive && this.position.equals(bound.position)) {
                return true;
            }
        }
        return false;
    }

    public List<C1698D> getPosition() {
        return this.position;
    }

    public int hashCode() {
        return ((this.inclusive ? 1 : 0) * 31) + this.position.hashCode();
    }

    public boolean isInclusive() {
        return this.inclusive;
    }

    public String positionString() {
        StringBuilder sb = new StringBuilder();
        boolean z4 = true;
        for (C1698D c1698d : this.position) {
            if (!z4) {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
            sb.append(Values.canonicalId(c1698d));
            z4 = false;
        }
        return sb.toString();
    }

    public boolean sortsAfterDocument(List<OrderBy> list, Document document) {
        int iCompareToDocument = compareToDocument(list, document);
        return this.inclusive ? iCompareToDocument >= 0 : iCompareToDocument > 0;
    }

    public boolean sortsBeforeDocument(List<OrderBy> list, Document document) {
        int iCompareToDocument = compareToDocument(list, document);
        return this.inclusive ? iCompareToDocument <= 0 : iCompareToDocument < 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bound(inclusive=");
        sb.append(this.inclusive);
        sb.append(", position=");
        for (int i4 = 0; i4 < this.position.size(); i4++) {
            if (i4 > 0) {
                sb.append(" and ");
            }
            sb.append(Values.canonicalId(this.position.get(i4)));
        }
        sb.append(")");
        return sb.toString();
    }
}

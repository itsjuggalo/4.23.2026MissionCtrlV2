package com.google.firebase.firestore.model;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class TargetIndexMatcher {
    private final String collectionId;
    private final List<FieldFilter> equalityFilters;
    private final SortedSet<FieldFilter> inequalityFilters;
    private final List<OrderBy> orderBys;

    public TargetIndexMatcher(Target target) {
        this.collectionId = target.getCollectionGroup() != null ? target.getCollectionGroup() : target.getPath().getLastSegment();
        this.orderBys = target.getOrderBy();
        this.inequalityFilters = new TreeSet(new Comparator() { // from class: com.google.firebase.firestore.model.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((FieldFilter) obj).getField().compareTo(((FieldFilter) obj2).getField());
            }
        });
        this.equalityFilters = new ArrayList();
        Iterator<Filter> it = target.getFilters().iterator();
        while (it.hasNext()) {
            FieldFilter fieldFilter = (FieldFilter) it.next();
            if (fieldFilter.isInequality()) {
                this.inequalityFilters.add(fieldFilter);
            } else {
                this.equalityFilters.add(fieldFilter);
            }
        }
    }

    private boolean hasMatchingEqualityFilter(FieldIndex.Segment segment) {
        Iterator<FieldFilter> it = this.equalityFilters.iterator();
        while (it.hasNext()) {
            if (matchesFilter(it.next(), segment)) {
                return true;
            }
        }
        return false;
    }

    private boolean matchesFilter(FieldFilter fieldFilter, FieldIndex.Segment segment) {
        if (fieldFilter != null && fieldFilter.getField().equals(segment.getFieldPath())) {
            if (segment.getKind().equals(FieldIndex.Segment.Kind.CONTAINS) == (fieldFilter.getOperator().equals(FieldFilter.Operator.ARRAY_CONTAINS) || fieldFilter.getOperator().equals(FieldFilter.Operator.ARRAY_CONTAINS_ANY))) {
                return true;
            }
        }
        return false;
    }

    private boolean matchesOrderBy(OrderBy orderBy, FieldIndex.Segment segment) {
        if (!orderBy.getField().equals(segment.getFieldPath())) {
            return false;
        }
        if (segment.getKind().equals(FieldIndex.Segment.Kind.ASCENDING) && orderBy.getDirection().equals(OrderBy.Direction.ASCENDING)) {
            return true;
        }
        return segment.getKind().equals(FieldIndex.Segment.Kind.DESCENDING) && orderBy.getDirection().equals(OrderBy.Direction.DESCENDING);
    }

    public FieldIndex buildTargetIndex() {
        if (hasMultipleInequality()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (FieldFilter fieldFilter : this.equalityFilters) {
            if (!fieldFilter.getField().isKeyField()) {
                if (fieldFilter.getOperator().equals(FieldFilter.Operator.ARRAY_CONTAINS) || fieldFilter.getOperator().equals(FieldFilter.Operator.ARRAY_CONTAINS_ANY)) {
                    arrayList.add(FieldIndex.Segment.create(fieldFilter.getField(), FieldIndex.Segment.Kind.CONTAINS));
                } else if (!hashSet.contains(fieldFilter.getField())) {
                    hashSet.add(fieldFilter.getField());
                    arrayList.add(FieldIndex.Segment.create(fieldFilter.getField(), FieldIndex.Segment.Kind.ASCENDING));
                }
            }
        }
        for (OrderBy orderBy : this.orderBys) {
            if (!orderBy.getField().isKeyField() && !hashSet.contains(orderBy.getField())) {
                hashSet.add(orderBy.getField());
                arrayList.add(FieldIndex.Segment.create(orderBy.getField(), orderBy.getDirection() == OrderBy.Direction.ASCENDING ? FieldIndex.Segment.Kind.ASCENDING : FieldIndex.Segment.Kind.DESCENDING));
            }
        }
        return FieldIndex.create(-1, this.collectionId, arrayList, FieldIndex.INITIAL_STATE);
    }

    public boolean hasMultipleInequality() {
        return this.inequalityFilters.size() > 1;
    }

    public boolean servedByIndex(FieldIndex fieldIndex) {
        Assert.hardAssert(fieldIndex.getCollectionGroup().equals(this.collectionId), "Collection IDs do not match", new Object[0]);
        if (hasMultipleInequality()) {
            return false;
        }
        FieldIndex.Segment arraySegment = fieldIndex.getArraySegment();
        if (arraySegment != null && !hasMatchingEqualityFilter(arraySegment)) {
            return false;
        }
        Iterator<OrderBy> it = this.orderBys.iterator();
        List<FieldIndex.Segment> directionalSegments = fieldIndex.getDirectionalSegments();
        HashSet hashSet = new HashSet();
        int i4 = 0;
        while (i4 < directionalSegments.size() && hasMatchingEqualityFilter(directionalSegments.get(i4))) {
            hashSet.add(directionalSegments.get(i4).getFieldPath().canonicalString());
            i4++;
        }
        if (i4 == directionalSegments.size()) {
            return true;
        }
        if (this.inequalityFilters.size() > 0) {
            FieldFilter fieldFilterFirst = this.inequalityFilters.first();
            if (!hashSet.contains(fieldFilterFirst.getField().canonicalString())) {
                FieldIndex.Segment segment = directionalSegments.get(i4);
                if (!matchesFilter(fieldFilterFirst, segment) || !matchesOrderBy(it.next(), segment)) {
                    return false;
                }
            }
            i4++;
        }
        while (i4 < directionalSegments.size()) {
            FieldIndex.Segment segment2 = directionalSegments.get(i4);
            if (!it.hasNext() || !matchesOrderBy(it.next(), segment2)) {
                return false;
            }
            i4++;
        }
        return true;
    }
}

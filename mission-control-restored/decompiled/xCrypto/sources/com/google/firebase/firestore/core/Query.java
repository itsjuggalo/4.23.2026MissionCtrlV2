package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class Query {
    private static final OrderBy KEY_ORDERING_ASC;
    private static final OrderBy KEY_ORDERING_DESC;
    private final String collectionGroup;
    private final Bound endAt;
    private final List<OrderBy> explicitSortOrder;
    private final List<Filter> filters;
    private final long limit;
    private final LimitType limitType;
    private Target memoizedAggregateTarget;
    private List<OrderBy> memoizedNormalizedOrderBys;
    private Target memoizedTarget;
    private final ResourcePath path;
    private final Bound startAt;

    public enum LimitType {
        LIMIT_TO_FIRST,
        LIMIT_TO_LAST
    }

    public static class QueryComparator implements Comparator<Document> {
        private final List<OrderBy> sortOrder;

        public QueryComparator(List<OrderBy> list) {
            boolean z4;
            Iterator<OrderBy> it = list.iterator();
            loop0: while (true) {
                z4 = false;
                while (it.hasNext()) {
                    z4 = (z4 || it.next().getField().equals(FieldPath.KEY_PATH)) ? true : z4;
                }
            }
            if (!z4) {
                throw new IllegalArgumentException("QueryComparator needs to have a key ordering");
            }
            this.sortOrder = list;
        }

        @Override // java.util.Comparator
        public int compare(Document document, Document document2) {
            Iterator<OrderBy> it = this.sortOrder.iterator();
            while (it.hasNext()) {
                int iCompare = it.next().compare(document, document2);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return 0;
        }
    }

    static {
        OrderBy.Direction direction = OrderBy.Direction.ASCENDING;
        FieldPath fieldPath = FieldPath.KEY_PATH;
        KEY_ORDERING_ASC = OrderBy.getInstance(direction, fieldPath);
        KEY_ORDERING_DESC = OrderBy.getInstance(OrderBy.Direction.DESCENDING, fieldPath);
    }

    public Query(ResourcePath resourcePath, String str, List<Filter> list, List<OrderBy> list2, long j4, LimitType limitType, Bound bound, Bound bound2) {
        this.path = resourcePath;
        this.collectionGroup = str;
        this.explicitSortOrder = list2;
        this.filters = list;
        this.limit = j4;
        this.limitType = limitType;
        this.startAt = bound;
        this.endAt = bound2;
    }

    public static Query atPath(ResourcePath resourcePath) {
        return new Query(resourcePath, null);
    }

    private boolean matchesBounds(Document document) {
        Bound bound = this.startAt;
        if (bound != null && !bound.sortsBeforeDocument(getNormalizedOrderBy(), document)) {
            return false;
        }
        Bound bound2 = this.endAt;
        return bound2 == null || bound2.sortsAfterDocument(getNormalizedOrderBy(), document);
    }

    private boolean matchesFilters(Document document) {
        Iterator<Filter> it = this.filters.iterator();
        while (it.hasNext()) {
            if (!it.next().matches(document)) {
                return false;
            }
        }
        return true;
    }

    private boolean matchesOrderBy(Document document) {
        for (OrderBy orderBy : getNormalizedOrderBy()) {
            if (!orderBy.getField().equals(FieldPath.KEY_PATH) && document.getField(orderBy.field) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean matchesPathAndCollectionGroup(Document document) {
        ResourcePath path = document.getKey().getPath();
        return this.collectionGroup != null ? document.getKey().hasCollectionId(this.collectionGroup) && this.path.isPrefixOf(path) : DocumentKey.isDocumentKey(this.path) ? this.path.equals(path) : this.path.isPrefixOf(path) && this.path.length() == path.length() - 1;
    }

    public Query asCollectionQueryAtPath(ResourcePath resourcePath) {
        return new Query(resourcePath, null, this.filters, this.explicitSortOrder, this.limit, this.limitType, this.startAt, this.endAt);
    }

    public Comparator<Document> comparator() {
        return new QueryComparator(getNormalizedOrderBy());
    }

    public Query endAt(Bound bound) {
        return new Query(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, this.limit, this.limitType, this.startAt, bound);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Query.class != obj.getClass()) {
            return false;
        }
        Query query = (Query) obj;
        if (this.limitType != query.limitType) {
            return false;
        }
        return toTarget().equals(query.toTarget());
    }

    public Query filter(Filter filter) {
        Assert.hardAssert(!isDocumentQuery(), "No filter is allowed for document query", new Object[0]);
        ArrayList arrayList = new ArrayList(this.filters);
        arrayList.add(filter);
        return new Query(this.path, this.collectionGroup, arrayList, this.explicitSortOrder, this.limit, this.limitType, this.startAt, this.endAt);
    }

    public String getCanonicalId() {
        return toTarget().getCanonicalId() + "|lt:" + this.limitType;
    }

    public String getCollectionGroup() {
        return this.collectionGroup;
    }

    public Bound getEndAt() {
        return this.endAt;
    }

    public List<OrderBy> getExplicitOrderBy() {
        return this.explicitSortOrder;
    }

    public List<Filter> getFilters() {
        return this.filters;
    }

    public SortedSet<FieldPath> getInequalityFilterFields() {
        TreeSet treeSet = new TreeSet();
        Iterator<Filter> it = getFilters().iterator();
        while (it.hasNext()) {
            for (FieldFilter fieldFilter : it.next().getFlattenedFilters()) {
                if (fieldFilter.isInequality()) {
                    treeSet.add(fieldFilter.getField());
                }
            }
        }
        return treeSet;
    }

    public long getLimit() {
        return this.limit;
    }

    public LimitType getLimitType() {
        return this.limitType;
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:509)
        */
    public synchronized java.util.List<com.google.firebase.firestore.core.OrderBy> getNormalizedOrderBy() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.List<com.google.firebase.firestore.core.OrderBy> r0 = r6.memoizedNormalizedOrderBys     // Catch: java.lang.Throwable -> L2e
            if (r0 != 0) goto L9b
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L2e
            r0.<init>()     // Catch: java.lang.Throwable -> L2e
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L2e
            r1.<init>()     // Catch: java.lang.Throwable -> L2e
            java.util.List<com.google.firebase.firestore.core.OrderBy> r2 = r6.explicitSortOrder     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L2e
        L15:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L30
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L2e
            com.google.firebase.firestore.core.OrderBy r3 = (com.google.firebase.firestore.core.OrderBy) r3     // Catch: java.lang.Throwable -> L2e
            r0.add(r3)     // Catch: java.lang.Throwable -> L2e
            com.google.firebase.firestore.model.FieldPath r3 = r3.field     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = r3.canonicalString()     // Catch: java.lang.Throwable -> L2e
            r1.add(r3)     // Catch: java.lang.Throwable -> L2e
            goto L15
        L2e:
            r0 = move-exception
            goto L9f
        L30:
            java.util.List<com.google.firebase.firestore.core.OrderBy> r2 = r6.explicitSortOrder     // Catch: java.lang.Throwable -> L2e
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L2e
            if (r2 <= 0) goto L4b
            java.util.List<com.google.firebase.firestore.core.OrderBy> r2 = r6.explicitSortOrder     // Catch: java.lang.Throwable -> L2e
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L2e
            int r3 = r3 + (-1)
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L2e
            com.google.firebase.firestore.core.OrderBy r2 = (com.google.firebase.firestore.core.OrderBy) r2     // Catch: java.lang.Throwable -> L2e
            com.google.firebase.firestore.core.OrderBy$Direction r2 = r2.getDirection()     // Catch: java.lang.Throwable -> L2e
            goto L4d
        L4b:
            com.google.firebase.firestore.core.OrderBy$Direction r2 = com.google.firebase.firestore.core.OrderBy.Direction.ASCENDING     // Catch: java.lang.Throwable -> L2e
        L4d:
            java.util.SortedSet r3 = r6.getInequalityFilterFields()     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L2e
        L55:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r4 == 0) goto L79
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L2e
            com.google.firebase.firestore.model.FieldPath r4 = (com.google.firebase.firestore.model.FieldPath) r4     // Catch: java.lang.Throwable -> L2e
            java.lang.String r5 = r4.canonicalString()     // Catch: java.lang.Throwable -> L2e
            boolean r5 = r1.contains(r5)     // Catch: java.lang.Throwable -> L2e
            if (r5 != 0) goto L55
            boolean r5 = r4.isKeyField()     // Catch: java.lang.Throwable -> L2e
            if (r5 != 0) goto L55
            com.google.firebase.firestore.core.OrderBy r4 = com.google.firebase.firestore.core.OrderBy.getInstance(r2, r4)     // Catch: java.lang.Throwable -> L2e
            r0.add(r4)     // Catch: java.lang.Throwable -> L2e
            goto L55
        L79:
            com.google.firebase.firestore.model.FieldPath r3 = com.google.firebase.firestore.model.FieldPath.KEY_PATH     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = r3.canonicalString()     // Catch: java.lang.Throwable -> L2e
            boolean r1 = r1.contains(r3)     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L95
            com.google.firebase.firestore.core.OrderBy$Direction r1 = com.google.firebase.firestore.core.OrderBy.Direction.ASCENDING     // Catch: java.lang.Throwable -> L2e
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L90
            com.google.firebase.firestore.core.OrderBy r1 = com.google.firebase.firestore.core.Query.KEY_ORDERING_ASC     // Catch: java.lang.Throwable -> L2e
            goto L92
        L90:
            com.google.firebase.firestore.core.OrderBy r1 = com.google.firebase.firestore.core.Query.KEY_ORDERING_DESC     // Catch: java.lang.Throwable -> L2e
        L92:
            r0.add(r1)     // Catch: java.lang.Throwable -> L2e
        L95:
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)     // Catch: java.lang.Throwable -> L2e
            r6.memoizedNormalizedOrderBys = r0     // Catch: java.lang.Throwable -> L2e
        L9b:
            java.util.List<com.google.firebase.firestore.core.OrderBy> r0 = r6.memoizedNormalizedOrderBys     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r6)
            return r0
        L9f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.core.Query.getNormalizedOrderBy():java.util.List");
    }

    public ResourcePath getPath() {
        return this.path;
    }

    public Bound getStartAt() {
        return this.startAt;
    }

    public boolean hasLimit() {
        return this.limit != -1;
    }

    public int hashCode() {
        return (toTarget().hashCode() * 31) + this.limitType.hashCode();
    }

    public boolean isCollectionGroupQuery() {
        return this.collectionGroup != null;
    }

    public boolean isDocumentQuery() {
        return DocumentKey.isDocumentKey(this.path) && this.collectionGroup == null && this.filters.isEmpty();
    }

    public Query limitToFirst(long j4) {
        return new Query(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, j4, LimitType.LIMIT_TO_FIRST, this.startAt, this.endAt);
    }

    public Query limitToLast(long j4) {
        return new Query(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, j4, LimitType.LIMIT_TO_LAST, this.startAt, this.endAt);
    }

    public boolean matches(Document document) {
        return document.isFoundDocument() && matchesPathAndCollectionGroup(document) && matchesOrderBy(document) && matchesFilters(document) && matchesBounds(document);
    }

    public boolean matchesAllDocuments() {
        return this.filters.isEmpty() && this.limit == -1 && this.startAt == null && this.endAt == null && (getExplicitOrderBy().isEmpty() || (getExplicitOrderBy().size() == 1 && getExplicitOrderBy().get(0).field.isKeyField()));
    }

    public Query orderBy(OrderBy orderBy) {
        Assert.hardAssert(!isDocumentQuery(), "No ordering is allowed for document query", new Object[0]);
        ArrayList arrayList = new ArrayList(this.explicitSortOrder);
        arrayList.add(orderBy);
        return new Query(this.path, this.collectionGroup, this.filters, arrayList, this.limit, this.limitType, this.startAt, this.endAt);
    }

    public Query startAt(Bound bound) {
        return new Query(this.path, this.collectionGroup, this.filters, this.explicitSortOrder, this.limit, this.limitType, bound, this.endAt);
    }

    public synchronized Target toAggregateTarget() {
        try {
            if (this.memoizedAggregateTarget == null) {
                this.memoizedAggregateTarget = toTarget(this.explicitSortOrder);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.memoizedAggregateTarget;
    }

    public String toString() {
        return "Query(target=" + toTarget().toString() + ";limitType=" + this.limitType.toString() + ")";
    }

    public synchronized Target toTarget() {
        try {
            if (this.memoizedTarget == null) {
                this.memoizedTarget = toTarget(getNormalizedOrderBy());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.memoizedTarget;
    }

    private synchronized Target toTarget(List<OrderBy> list) {
        if (this.limitType == LimitType.LIMIT_TO_FIRST) {
            return new Target(getPath(), getCollectionGroup(), getFilters(), list, this.limit, getStartAt(), getEndAt());
        }
        ArrayList arrayList = new ArrayList();
        for (OrderBy orderBy : list) {
            OrderBy.Direction direction = orderBy.getDirection();
            OrderBy.Direction direction2 = OrderBy.Direction.DESCENDING;
            if (direction == direction2) {
                direction2 = OrderBy.Direction.ASCENDING;
            }
            arrayList.add(OrderBy.getInstance(direction2, orderBy.getField()));
        }
        Bound bound = this.endAt;
        Bound bound2 = bound != null ? new Bound(bound.getPosition(), this.endAt.isInclusive()) : null;
        Bound bound3 = this.startAt;
        return new Target(getPath(), getCollectionGroup(), getFilters(), arrayList, this.limit, bound2, bound3 != null ? new Bound(bound3.getPosition(), this.startAt.isInclusive()) : null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Query(ResourcePath resourcePath, String str) {
        List list = Collections.EMPTY_LIST;
        this(resourcePath, str, list, list, -1L, LimitType.LIMIT_TO_FIRST, null, null);
    }
}

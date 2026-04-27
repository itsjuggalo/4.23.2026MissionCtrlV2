package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.CompositeFilter;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.google.firebase.firestore.index.IndexByteEncoder;
import com.google.firebase.firestore.index.IndexEntry;
import com.google.firebase.firestore.local.IndexManager;
import com.google.firebase.firestore.local.MemoryIndexManager;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.TargetIndexMatcher;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.LogicUtils;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;
import n2.C1632a;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
final class SQLiteIndexManager implements IndexManager {
    private static final byte[] EMPTY_BYTES_VALUE = new byte[0];
    private static final String TAG = "SQLiteIndexManager";
    private final SQLitePersistence db;
    private final LocalSerializer serializer;
    private final String uid;
    private final Map<Target, List<Target>> targetToDnfSubTargets = new HashMap();
    private final MemoryIndexManager.MemoryCollectionParentIndex collectionParentsCache = new MemoryIndexManager.MemoryCollectionParentIndex();
    private final Map<String, Map<Integer, FieldIndex>> memoizedIndexes = new HashMap();
    private final Queue<FieldIndex> nextIndexToUpdate = new PriorityQueue(10, new Comparator() { // from class: com.google.firebase.firestore.local.S
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return SQLiteIndexManager.e((FieldIndex) obj, (FieldIndex) obj2);
        }
    });
    private boolean started = false;
    private int memoizedMaxIndexId = -1;
    private long memoizedMaxSequenceNumber = -1;

    public SQLiteIndexManager(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer, User user) {
        this.db = sQLitePersistence;
        this.serializer = localSerializer;
        this.uid = user.isAuthenticated() ? user.getUid() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIndexEntry(Document document, IndexEntry indexEntry) {
        this.db.execute("INSERT INTO index_entries (index_id, uid, array_value, directional_value, document_key) VALUES(?, ?, ?, ?, ?)", Integer.valueOf(indexEntry.getIndexId()), this.uid, indexEntry.getArrayValue(), indexEntry.getDirectionalValue(), document.getKey().toString());
    }

    public static /* synthetic */ void c(SQLiteIndexManager sQLiteIndexManager, Map map, Cursor cursor) {
        sQLiteIndexManager.getClass();
        try {
            int i4 = cursor.getInt(0);
            sQLiteIndexManager.memoizeIndex(FieldIndex.create(i4, cursor.getString(1), sQLiteIndexManager.serializer.decodeFieldIndexSegments(C1632a.q(cursor.getBlob(2))), map.containsKey(Integer.valueOf(i4)) ? (FieldIndex.IndexState) map.get(Integer.valueOf(i4)) : FieldIndex.INITIAL_STATE));
        } catch (com.google.protobuf.D e4) {
            throw Assert.fail("Failed to decode index: " + e4, new Object[0]);
        }
    }

    private SortedSet<IndexEntry> computeIndexEntries(Document document, FieldIndex fieldIndex) {
        TreeSet treeSet = new TreeSet();
        byte[] bArrEncodeDirectionalElements = encodeDirectionalElements(fieldIndex, document);
        if (bArrEncodeDirectionalElements != null) {
            FieldIndex.Segment arraySegment = fieldIndex.getArraySegment();
            if (arraySegment == null) {
                treeSet.add(IndexEntry.create(fieldIndex.getIndexId(), document.getKey(), new byte[0], bArrEncodeDirectionalElements));
                return treeSet;
            }
            C1698D field = document.getField(arraySegment.getFieldPath());
            if (Values.isArray(field)) {
                Iterator it = field.v().a().iterator();
                while (it.hasNext()) {
                    treeSet.add(IndexEntry.create(fieldIndex.getIndexId(), document.getKey(), encodeSingleElement((C1698D) it.next()), bArrEncodeDirectionalElements));
                }
            }
        }
        return treeSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteIndexEntry(Document document, IndexEntry indexEntry) {
        this.db.execute("DELETE FROM index_entries WHERE index_id = ? AND uid = ? AND array_value = ? AND directional_value = ? AND document_key = ?", Integer.valueOf(indexEntry.getIndexId()), this.uid, indexEntry.getArrayValue(), indexEntry.getDirectionalValue(), document.getKey().toString());
    }

    public static /* synthetic */ int e(FieldIndex fieldIndex, FieldIndex fieldIndex2) {
        int iCompare = Long.compare(fieldIndex.getIndexState().getSequenceNumber(), fieldIndex2.getIndexState().getSequenceNumber());
        return iCompare == 0 ? fieldIndex.getCollectionGroup().compareTo(fieldIndex2.getCollectionGroup()) : iCompare;
    }

    private Object[] encodeBound(FieldIndex fieldIndex, Target target, Bound bound) {
        return encodeValues(fieldIndex, target, bound.getPosition());
    }

    private byte[] encodeDirectionalElements(FieldIndex fieldIndex, Document document) {
        IndexByteEncoder indexByteEncoder = new IndexByteEncoder();
        for (FieldIndex.Segment segment : fieldIndex.getDirectionalSegments()) {
            C1698D field = document.getField(segment.getFieldPath());
            if (field == null) {
                return null;
            }
            FirestoreIndexValueWriter.INSTANCE.writeIndexValue(field, indexByteEncoder.forKind(segment.getKind()));
        }
        return indexByteEncoder.getEncodedBytes();
    }

    private byte[] encodeSegments(FieldIndex fieldIndex) {
        return this.serializer.encodeFieldIndexSegments(fieldIndex.getSegments()).toByteArray();
    }

    private byte[] encodeSingleElement(C1698D c1698d) {
        IndexByteEncoder indexByteEncoder = new IndexByteEncoder();
        FirestoreIndexValueWriter.INSTANCE.writeIndexValue(c1698d, indexByteEncoder.forKind(FieldIndex.Segment.Kind.ASCENDING));
        return indexByteEncoder.getEncodedBytes();
    }

    private Object[] encodeValues(FieldIndex fieldIndex, Target target, Collection<C1698D> collection) {
        if (collection == null) {
            return null;
        }
        List<IndexByteEncoder> arrayList = new ArrayList<>();
        arrayList.add(new IndexByteEncoder());
        Iterator<C1698D> it = collection.iterator();
        for (FieldIndex.Segment segment : fieldIndex.getDirectionalSegments()) {
            C1698D next = it.next();
            for (IndexByteEncoder indexByteEncoder : arrayList) {
                if (isInFilter(target, segment.getFieldPath()) && Values.isArray(next)) {
                    arrayList = expandIndexValues(arrayList, segment, next);
                } else {
                    FirestoreIndexValueWriter.INSTANCE.writeIndexValue(next, indexByteEncoder.forKind(segment.getKind()));
                }
            }
        }
        return getEncodedBytes(arrayList);
    }

    private List<IndexByteEncoder> expandIndexValues(List<IndexByteEncoder> list, FieldIndex.Segment segment, C1698D c1698d) {
        ArrayList<IndexByteEncoder> arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        for (C1698D c1698d2 : c1698d.v().a()) {
            for (IndexByteEncoder indexByteEncoder : arrayList) {
                IndexByteEncoder indexByteEncoder2 = new IndexByteEncoder();
                indexByteEncoder2.seed(indexByteEncoder.getEncodedBytes());
                FirestoreIndexValueWriter.INSTANCE.writeIndexValue(c1698d2, indexByteEncoder2.forKind(segment.getKind()));
                arrayList2.add(indexByteEncoder2);
            }
        }
        return arrayList2;
    }

    private Object[] fillBounds(int i4, int i5, List<C1698D> list, Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = i4 / (list != null ? list.size() : 1);
        int i6 = 0;
        Object[] objArr4 = new Object[(i4 * 5) + (objArr3 != null ? objArr3.length : 0)];
        int i7 = 0;
        for (int i8 = 0; i8 < i4; i8++) {
            objArr4[i7] = Integer.valueOf(i5);
            int i9 = i7 + 2;
            objArr4[i7 + 1] = this.uid;
            int i10 = i7 + 3;
            objArr4[i9] = list != null ? encodeSingleElement(list.get(i8 / size)) : EMPTY_BYTES_VALUE;
            int i11 = i7 + 4;
            int i12 = i8 % size;
            objArr4[i10] = objArr[i12];
            i7 += 5;
            objArr4[i11] = objArr2[i12];
        }
        if (objArr3 != null) {
            int length = objArr3.length;
            while (i6 < length) {
                objArr4[i7] = objArr3[i6];
                i6++;
                i7++;
            }
        }
        return objArr4;
    }

    private Object[] generateQueryAndBindings(Target target, int i4, List<C1698D> list, Object[] objArr, String str, Object[] objArr2, String str2, Object[] objArr3) {
        int i5;
        StringBuilder sb;
        List<C1698D> list2;
        int size = (list != null ? list.size() : 1) * Math.max(objArr.length, objArr2.length);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT document_key, directional_value FROM index_entries ");
        sb2.append("WHERE index_id = ? AND uid = ? ");
        sb2.append("AND array_value = ? ");
        sb2.append("AND directional_value ");
        sb2.append(str);
        sb2.append(" ? ");
        sb2.append("AND directional_value ");
        sb2.append(str2);
        sb2.append(" ? ");
        CharSequence charSequenceRepeatSequence = Util.repeatSequence(sb2, size, " UNION ");
        if (objArr3 != null) {
            StringBuilder sb3 = new StringBuilder("SELECT document_key, directional_value FROM (");
            sb3.append(charSequenceRepeatSequence);
            sb3.append(") WHERE directional_value NOT IN (");
            sb3.append((CharSequence) Util.repeatSequence("?", objArr3.length, ", "));
            sb3.append(")");
            list2 = list;
            i5 = size;
            sb = sb3;
        } else {
            i5 = size;
            sb = charSequenceRepeatSequence;
            list2 = list;
        }
        Object[] objArrFillBounds = fillBounds(i5, i4, list2, objArr, objArr2, objArr3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(sb.toString());
        arrayList.addAll(Arrays.asList(objArrFillBounds));
        return arrayList.toArray();
    }

    private Object[] getEncodedBytes(List<IndexByteEncoder> list) {
        Object[] objArr = new Object[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            objArr[i4] = list.get(i4).getEncodedBytes();
        }
        return objArr;
    }

    private SortedSet<IndexEntry> getExistingIndexEntries(final DocumentKey documentKey, final FieldIndex fieldIndex) {
        final TreeSet treeSet = new TreeSet();
        this.db.query("SELECT array_value, directional_value FROM index_entries WHERE index_id = ? AND document_key = ? AND uid = ?").binding(Integer.valueOf(fieldIndex.getIndexId()), documentKey.toString(), this.uid).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.V
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                Cursor cursor = (Cursor) obj;
                treeSet.add(IndexEntry.create(fieldIndex.getIndexId(), documentKey, cursor.getBlob(0), cursor.getBlob(1)));
            }
        });
        return treeSet;
    }

    private FieldIndex getFieldIndex(Target target) {
        Assert.hardAssert(this.started, "IndexManager not started", new Object[0]);
        TargetIndexMatcher targetIndexMatcher = new TargetIndexMatcher(target);
        Collection<FieldIndex> fieldIndexes = getFieldIndexes(target.getCollectionGroup() != null ? target.getCollectionGroup() : target.getPath().getLastSegment());
        FieldIndex fieldIndex = null;
        if (fieldIndexes.isEmpty()) {
            return null;
        }
        for (FieldIndex fieldIndex2 : fieldIndexes) {
            if (targetIndexMatcher.servedByIndex(fieldIndex2) && (fieldIndex == null || fieldIndex2.getSegments().size() > fieldIndex.getSegments().size())) {
                fieldIndex = fieldIndex2;
            }
        }
        return fieldIndex;
    }

    private FieldIndex.IndexOffset getMinOffset(Collection<FieldIndex> collection) {
        Assert.hardAssert(!collection.isEmpty(), "Found empty index group when looking for least recent index offset.", new Object[0]);
        Iterator<FieldIndex> it = collection.iterator();
        FieldIndex.IndexOffset offset = it.next().getIndexState().getOffset();
        int largestBatchId = offset.getLargestBatchId();
        while (it.hasNext()) {
            FieldIndex.IndexOffset offset2 = it.next().getIndexState().getOffset();
            if (offset2.compareTo(offset) < 0) {
                offset = offset2;
            }
            largestBatchId = Math.max(offset2.getLargestBatchId(), largestBatchId);
        }
        return FieldIndex.IndexOffset.create(offset.getReadTime(), offset.getDocumentKey(), largestBatchId);
    }

    private List<Target> getSubTargets(Target target) {
        if (this.targetToDnfSubTargets.containsKey(target)) {
            return this.targetToDnfSubTargets.get(target);
        }
        ArrayList arrayList = new ArrayList();
        if (target.getFilters().isEmpty()) {
            arrayList.add(target);
        } else {
            Iterator<Filter> it = LogicUtils.getDnfTerms(new CompositeFilter(target.getFilters(), CompositeFilter.Operator.AND)).iterator();
            while (it.hasNext()) {
                arrayList.add(new Target(target.getPath(), target.getCollectionGroup(), it.next().getFilters(), target.getOrderBy(), target.getLimit(), target.getStartAt(), target.getEndAt()));
            }
        }
        this.targetToDnfSubTargets.put(target, arrayList);
        return arrayList;
    }

    private boolean isInFilter(Target target, FieldPath fieldPath) {
        for (Filter filter : target.getFilters()) {
            if (filter instanceof FieldFilter) {
                FieldFilter fieldFilter = (FieldFilter) filter;
                if (fieldFilter.getField().equals(fieldPath)) {
                    FieldFilter.Operator operator = fieldFilter.getOperator();
                    if (operator.equals(FieldFilter.Operator.IN) || operator.equals(FieldFilter.Operator.NOT_IN)) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    private void memoizeIndex(FieldIndex fieldIndex) {
        Map<Integer, FieldIndex> map = this.memoizedIndexes.get(fieldIndex.getCollectionGroup());
        if (map == null) {
            map = new HashMap<>();
            this.memoizedIndexes.put(fieldIndex.getCollectionGroup(), map);
        }
        FieldIndex fieldIndex2 = map.get(Integer.valueOf(fieldIndex.getIndexId()));
        if (fieldIndex2 != null) {
            this.nextIndexToUpdate.remove(fieldIndex2);
        }
        map.put(Integer.valueOf(fieldIndex.getIndexId()), fieldIndex);
        this.nextIndexToUpdate.add(fieldIndex);
        this.memoizedMaxIndexId = Math.max(this.memoizedMaxIndexId, fieldIndex.getIndexId());
        this.memoizedMaxSequenceNumber = Math.max(this.memoizedMaxSequenceNumber, fieldIndex.getIndexState().getSequenceNumber());
    }

    private void updateEntries(final Document document, SortedSet<IndexEntry> sortedSet, SortedSet<IndexEntry> sortedSet2) {
        Logger.debug(TAG, "Updating index entries for document '%s'", document.getKey());
        Util.diffCollections(sortedSet, sortedSet2, new Consumer() { // from class: com.google.firebase.firestore.local.P
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                this.f10534a.addIndexEntry(document, (IndexEntry) obj);
            }
        }, new Consumer() { // from class: com.google.firebase.firestore.local.Q
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                this.f10537a.deleteIndexEntry(document, (IndexEntry) obj);
            }
        });
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addFieldIndex(FieldIndex fieldIndex) {
        Assert.hardAssert(this.started, "IndexManager not started", new Object[0]);
        int i4 = this.memoizedMaxIndexId + 1;
        FieldIndex fieldIndexCreate = FieldIndex.create(i4, fieldIndex.getCollectionGroup(), fieldIndex.getSegments(), fieldIndex.getIndexState());
        this.db.execute("INSERT INTO index_configuration (index_id, collection_group, index_proto) VALUES(?, ?, ?)", Integer.valueOf(i4), fieldIndexCreate.getCollectionGroup(), encodeSegments(fieldIndexCreate));
        memoizeIndex(fieldIndexCreate);
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addToCollectionParentIndex(ResourcePath resourcePath) {
        Assert.hardAssert(this.started, "IndexManager not started", new Object[0]);
        Assert.hardAssert(resourcePath.length() % 2 == 1, "Expected a collection path.", new Object[0]);
        if (this.collectionParentsCache.add(resourcePath)) {
            this.db.execute("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)", resourcePath.getLastSegment(), EncodedPath.encode(resourcePath.popLast()));
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void createTargetIndexes(Target target) {
        Assert.hardAssert(this.started, "IndexManager not started", new Object[0]);
        for (Target target2 : getSubTargets(target)) {
            IndexManager.IndexType indexType = getIndexType(target2);
            if (indexType == IndexManager.IndexType.NONE || indexType == IndexManager.IndexType.PARTIAL) {
                FieldIndex fieldIndexBuildTargetIndex = new TargetIndexMatcher(target2).buildTargetIndex();
                if (fieldIndexBuildTargetIndex != null) {
                    addFieldIndex(fieldIndexBuildTargetIndex);
                }
            }
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void deleteAllFieldIndexes() {
        this.db.execute("DELETE FROM index_configuration", new Object[0]);
        this.db.execute("DELETE FROM index_entries", new Object[0]);
        this.db.execute("DELETE FROM index_state", new Object[0]);
        this.nextIndexToUpdate.clear();
        this.memoizedIndexes.clear();
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void deleteFieldIndex(FieldIndex fieldIndex) {
        this.db.execute("DELETE FROM index_configuration WHERE index_id = ?", Integer.valueOf(fieldIndex.getIndexId()));
        this.db.execute("DELETE FROM index_entries WHERE index_id = ?", Integer.valueOf(fieldIndex.getIndexId()));
        this.db.execute("DELETE FROM index_state WHERE index_id = ?", Integer.valueOf(fieldIndex.getIndexId()));
        this.nextIndexToUpdate.remove(fieldIndex);
        Map<Integer, FieldIndex> map = this.memoizedIndexes.get(fieldIndex.getCollectionGroup());
        if (map != null) {
            map.remove(Integer.valueOf(fieldIndex.getIndexId()));
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public List<ResourcePath> getCollectionParents(String str) {
        Assert.hardAssert(this.started, "IndexManager not started", new Object[0]);
        final ArrayList arrayList = new ArrayList();
        this.db.query("SELECT parent FROM collection_parents WHERE collection_id = ?").binding(str).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.T
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                arrayList.add(EncodedPath.decodeResourcePath(((Cursor) obj).getString(0)));
            }
        });
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public List<DocumentKey> getDocumentsMatchingTarget(Target target) {
        Assert.hardAssert(this.started, "IndexManager not started", new Object[0]);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Target target2 : getSubTargets(target)) {
            FieldIndex fieldIndex = getFieldIndex(target2);
            if (fieldIndex == null) {
                return null;
            }
            arrayList3.add(Pair.create(target2, fieldIndex));
        }
        Iterator it = arrayList3.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Pair pair = (Pair) it.next();
            Target target3 = (Target) pair.first;
            FieldIndex fieldIndex2 = (FieldIndex) pair.second;
            List<C1698D> arrayValues = target3.getArrayValues(fieldIndex2);
            Collection<C1698D> notInValues = target3.getNotInValues(fieldIndex2);
            Bound lowerBound = target3.getLowerBound(fieldIndex2);
            Bound upperBound = target3.getUpperBound(fieldIndex2);
            if (Logger.isDebugEnabled()) {
                Logger.debug(TAG, "Using index '%s' to execute '%s' (Arrays: %s, Lower bound: %s, Upper bound: %s)", fieldIndex2, target3, arrayValues, lowerBound, upperBound);
            }
            Object[] objArrGenerateQueryAndBindings = generateQueryAndBindings(target3, fieldIndex2.getIndexId(), arrayValues, encodeBound(fieldIndex2, target3, lowerBound), lowerBound.isInclusive() ? ">=" : ">", encodeBound(fieldIndex2, target3, upperBound), upperBound.isInclusive() ? "<=" : "<", encodeValues(fieldIndex2, target3, notInValues));
            arrayList.add(String.valueOf(objArrGenerateQueryAndBindings[0]));
            arrayList2.addAll(Arrays.asList(objArrGenerateQueryAndBindings).subList(1, objArrGenerateQueryAndBindings.length));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.join(" UNION ", arrayList));
        sb.append("ORDER BY directional_value, document_key ");
        sb.append(target.getKeyOrder().equals(OrderBy.Direction.ASCENDING) ? "asc " : "desc ");
        String str = "SELECT DISTINCT document_key FROM (" + sb.toString() + ")";
        if (target.hasLimit()) {
            str = str + " LIMIT " + target.getLimit();
        }
        Assert.hardAssert(arrayList2.size() < 1000, "Cannot perform query with more than 999 bind elements", new Object[0]);
        SQLitePersistence.Query queryBinding = this.db.query(str).binding(arrayList2.toArray());
        final ArrayList arrayList4 = new ArrayList();
        queryBinding.forEach(new Consumer() { // from class: com.google.firebase.firestore.local.U
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                arrayList4.add(DocumentKey.fromPath(ResourcePath.fromString(((Cursor) obj).getString(0))));
            }
        });
        Logger.debug(TAG, "Index scan returned %s documents", Integer.valueOf(arrayList4.size()));
        return arrayList4;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public Collection<FieldIndex> getFieldIndexes(String str) {
        Assert.hardAssert(this.started, "IndexManager not started", new Object[0]);
        Map<Integer, FieldIndex> map = this.memoizedIndexes.get(str);
        return map == null ? Collections.EMPTY_LIST : map.values();
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public IndexManager.IndexType getIndexType(Target target) {
        IndexManager.IndexType indexType = IndexManager.IndexType.FULL;
        List<Target> subTargets = getSubTargets(target);
        Iterator<Target> it = subTargets.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Target next = it.next();
            FieldIndex fieldIndex = getFieldIndex(next);
            if (fieldIndex == null) {
                indexType = IndexManager.IndexType.NONE;
                break;
            }
            if (fieldIndex.getSegments().size() < next.getSegmentCount()) {
                indexType = IndexManager.IndexType.PARTIAL;
            }
        }
        return (target.hasLimit() && subTargets.size() > 1 && indexType == IndexManager.IndexType.FULL) ? IndexManager.IndexType.PARTIAL : indexType;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public String getNextCollectionGroupToUpdate() {
        Assert.hardAssert(this.started, "IndexManager not started", new Object[0]);
        FieldIndex fieldIndexPeek = this.nextIndexToUpdate.peek();
        if (fieldIndexPeek != null) {
            return fieldIndexPeek.getCollectionGroup();
        }
        return null;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void start() {
        final HashMap map = new HashMap();
        this.db.query("SELECT index_id, sequence_number, read_time_seconds, read_time_nanos, document_key, largest_batch_id FROM index_state WHERE uid = ?").binding(this.uid).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.W
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                Cursor cursor = (Cursor) obj;
                map.put(Integer.valueOf(cursor.getInt(0)), FieldIndex.IndexState.create(cursor.getLong(1), new SnapshotVersion(new Timestamp(cursor.getLong(2), cursor.getInt(3))), DocumentKey.fromPath(EncodedPath.decodeResourcePath(cursor.getString(4))), cursor.getInt(5)));
            }
        });
        this.db.query("SELECT index_id, collection_group, index_proto FROM index_configuration").forEach(new Consumer() { // from class: com.google.firebase.firestore.local.X
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteIndexManager.c(this.f10555a, map, (Cursor) obj);
            }
        });
        this.started = true;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void updateCollectionGroup(String str, FieldIndex.IndexOffset indexOffset) {
        Assert.hardAssert(this.started, "IndexManager not started", new Object[0]);
        this.memoizedMaxSequenceNumber++;
        for (FieldIndex fieldIndex : getFieldIndexes(str)) {
            FieldIndex fieldIndexCreate = FieldIndex.create(fieldIndex.getIndexId(), fieldIndex.getCollectionGroup(), fieldIndex.getSegments(), FieldIndex.IndexState.create(this.memoizedMaxSequenceNumber, indexOffset));
            this.db.execute("REPLACE INTO index_state (index_id, uid,  sequence_number, read_time_seconds, read_time_nanos, document_key, largest_batch_id) VALUES(?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(fieldIndex.getIndexId()), this.uid, Long.valueOf(this.memoizedMaxSequenceNumber), Long.valueOf(indexOffset.getReadTime().getTimestamp().getSeconds()), Integer.valueOf(indexOffset.getReadTime().getTimestamp().getNanoseconds()), EncodedPath.encode(indexOffset.getDocumentKey().getPath()), Integer.valueOf(indexOffset.getLargestBatchId()));
            memoizeIndex(fieldIndexCreate);
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void updateIndexEntries(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
        Assert.hardAssert(this.started, "IndexManager not started", new Object[0]);
        for (Map.Entry<DocumentKey, Document> entry : immutableSortedMap) {
            for (FieldIndex fieldIndex : getFieldIndexes(entry.getKey().getCollectionGroup())) {
                SortedSet<IndexEntry> existingIndexEntries = getExistingIndexEntries(entry.getKey(), fieldIndex);
                SortedSet<IndexEntry> sortedSetComputeIndexEntries = computeIndexEntries(entry.getValue(), fieldIndex);
                if (!existingIndexEntries.equals(sortedSetComputeIndexEntries)) {
                    updateEntries(entry.getValue(), existingIndexEntries, sortedSetComputeIndexEntries);
                }
            }
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public Collection<FieldIndex> getFieldIndexes() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map<Integer, FieldIndex>> it = this.memoizedIndexes.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public FieldIndex.IndexOffset getMinOffset(String str) {
        Collection<FieldIndex> fieldIndexes = getFieldIndexes(str);
        Assert.hardAssert(!fieldIndexes.isEmpty(), "minOffset was called for collection without indexes", new Object[0]);
        return getMinOffset(fieldIndexes);
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public FieldIndex.IndexOffset getMinOffset(Target target) {
        ArrayList arrayList = new ArrayList();
        Iterator<Target> it = getSubTargets(target).iterator();
        while (it.hasNext()) {
            FieldIndex fieldIndex = getFieldIndex(it.next());
            if (fieldIndex != null) {
                arrayList.add(fieldIndex);
            }
        }
        return getMinOffset(arrayList);
    }
}

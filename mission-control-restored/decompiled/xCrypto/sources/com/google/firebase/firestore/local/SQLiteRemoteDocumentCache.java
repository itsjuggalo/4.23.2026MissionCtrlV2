package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.BackgroundQueue;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class SQLiteRemoteDocumentCache implements RemoteDocumentCache {
    static final int BINDS_PER_STATEMENT = 9;
    private final SQLitePersistence db;
    private IndexManager indexManager;
    private final LocalSerializer serializer;

    public SQLiteRemoteDocumentCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer) {
        this.db = sQLitePersistence;
        this.serializer = localSerializer;
    }

    public static /* synthetic */ void b(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, byte[] bArr, int i4, int i5, Function function, Map map) {
        MutableDocument mutableDocumentDecodeMaybeDocument = sQLiteRemoteDocumentCache.decodeMaybeDocument(bArr, i4, i5);
        if (function == null || ((Boolean) function.apply(mutableDocumentDecodeMaybeDocument)).booleanValue()) {
            synchronized (map) {
                map.put(mutableDocumentDecodeMaybeDocument.getKey(), mutableDocumentDecodeMaybeDocument);
            }
        }
    }

    public static /* synthetic */ void c(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, BackgroundQueue backgroundQueue, Map map, Function function, QueryContext queryContext, Cursor cursor) {
        sQLiteRemoteDocumentCache.processRowInBackground(backgroundQueue, map, cursor, function);
        if (queryContext != null) {
            queryContext.incrementDocumentReadCount();
        }
    }

    private MutableDocument decodeMaybeDocument(byte[] bArr, int i4, int i5) {
        try {
            return this.serializer.decodeMaybeDocument(MaybeDocument.parseFrom(bArr)).setReadTime(new SnapshotVersion(new Timestamp(i4, i5)));
        } catch (com.google.protobuf.D e4) {
            throw Assert.fail("MaybeDocument failed to parse: %s", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processRowInBackground(BackgroundQueue backgroundQueue, final Map<DocumentKey, MutableDocument> map, Cursor cursor, final Function<MutableDocument, Boolean> function) {
        final byte[] blob = cursor.getBlob(0);
        final int i4 = cursor.getInt(1);
        final int i5 = cursor.getInt(2);
        Executor executor = backgroundQueue;
        if (cursor.isLast()) {
            executor = Executors.DIRECT_EXECUTOR;
        }
        executor.execute(new Runnable() { // from class: com.google.firebase.firestore.local.t0
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteRemoteDocumentCache.b(this.f10617a, blob, i4, i5, function, map);
            }
        });
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void add(MutableDocument mutableDocument, SnapshotVersion snapshotVersion) {
        Assert.hardAssert(!snapshotVersion.equals(SnapshotVersion.NONE), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        DocumentKey key = mutableDocument.getKey();
        Timestamp timestamp = snapshotVersion.getTimestamp();
        this.db.execute("INSERT OR REPLACE INTO remote_documents (path, path_length, read_time_seconds, read_time_nanos, contents) VALUES (?, ?, ?, ?, ?)", EncodedPath.encode(key.getPath()), Integer.valueOf(key.getPath().length()), Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()), this.serializer.encodeMaybeDocument(mutableDocument).toByteArray());
        this.indexManager.addToCollectionParentIndex(mutableDocument.getKey().getCollectionPath());
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public MutableDocument get(DocumentKey documentKey) {
        return getAll(Collections.singletonList(documentKey)).get(documentKey);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MutableDocument> getAll(Iterable<DocumentKey> iterable) {
        final HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (DocumentKey documentKey : iterable) {
            arrayList.add(EncodedPath.encode(documentKey.getPath()));
            map.put(documentKey, MutableDocument.newInvalidDocument(documentKey));
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "SELECT contents, read_time_seconds, read_time_nanos FROM remote_documents WHERE path IN (", arrayList, ") ORDER BY path");
        final BackgroundQueue backgroundQueue = new BackgroundQueue();
        while (longQuery.hasMoreSubqueries()) {
            longQuery.performNextSubquery().forEach(new Consumer() { // from class: com.google.firebase.firestore.local.v0
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    this.f10634a.processRowInBackground(backgroundQueue, map, (Cursor) obj, null);
                }
            });
        }
        backgroundQueue.drain();
        return map;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MutableDocument> getDocumentsMatchingQuery(Query query, FieldIndex.IndexOffset indexOffset, Set<DocumentKey> set) {
        return getDocumentsMatchingQuery(query, indexOffset, set, null);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void removeAll(Collection<DocumentKey> collection) {
        if (collection.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ImmutableSortedMap<DocumentKey, Document> immutableSortedMapEmptyDocumentMap = DocumentCollections.emptyDocumentMap();
        for (DocumentKey documentKey : collection) {
            arrayList.add(EncodedPath.encode(documentKey.getPath()));
            immutableSortedMapEmptyDocumentMap = immutableSortedMapEmptyDocumentMap.insert(documentKey, MutableDocument.newNoDocument(documentKey, SnapshotVersion.NONE));
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "DELETE FROM remote_documents WHERE path IN (", arrayList, ")");
        while (longQuery.hasMoreSubqueries()) {
            longQuery.executeNextSubquery();
        }
        this.indexManager.updateIndexEntries(immutableSortedMapEmptyDocumentMap);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public void setIndexManager(IndexManager indexManager) {
        this.indexManager = indexManager;
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MutableDocument> getDocumentsMatchingQuery(final Query query, FieldIndex.IndexOffset indexOffset, final Set<DocumentKey> set, QueryContext queryContext) {
        return getAll(Collections.singletonList(query.getPath()), indexOffset, Integer.MAX_VALUE, new Function() { // from class: com.google.firebase.firestore.local.w0
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                MutableDocument mutableDocument = (MutableDocument) obj;
                return Boolean.valueOf(query.matches(mutableDocument) || set.contains(mutableDocument.getKey()));
            }
        }, queryContext);
    }

    @Override // com.google.firebase.firestore.local.RemoteDocumentCache
    public Map<DocumentKey, MutableDocument> getAll(String str, FieldIndex.IndexOffset indexOffset, int i4) {
        List<ResourcePath> collectionParents = this.indexManager.getCollectionParents(str);
        ArrayList arrayList = new ArrayList(collectionParents.size());
        Iterator<ResourcePath> it = collectionParents.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().append(str));
        }
        if (arrayList.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        if (arrayList.size() * 9 < 900) {
            return getAll(arrayList, indexOffset, i4, null);
        }
        HashMap map = new HashMap();
        int i5 = 0;
        while (i5 < arrayList.size()) {
            int i6 = i5 + 100;
            map.putAll(getAll(arrayList.subList(i5, Math.min(arrayList.size(), i6)), indexOffset, i4, null));
            i5 = i6;
        }
        return Util.firstNEntries(map, i4, FieldIndex.IndexOffset.DOCUMENT_COMPARATOR);
    }

    private Map<DocumentKey, MutableDocument> getAll(List<ResourcePath> list, FieldIndex.IndexOffset indexOffset, int i4, final Function<MutableDocument, Boolean> function, final QueryContext queryContext) {
        Timestamp timestamp = indexOffset.getReadTime().getTimestamp();
        DocumentKey documentKey = indexOffset.getDocumentKey();
        StringBuilder sbRepeatSequence = Util.repeatSequence("SELECT contents, read_time_seconds, read_time_nanos, path FROM remote_documents WHERE path >= ? AND path < ? AND path_length = ? AND (read_time_seconds > ? OR ( read_time_seconds = ? AND read_time_nanos > ?) OR ( read_time_seconds = ? AND read_time_nanos = ? and path > ?)) ", list.size(), " UNION ");
        sbRepeatSequence.append("ORDER BY read_time_seconds, read_time_nanos, path LIMIT ?");
        Object[] objArr = new Object[(list.size() * 9) + 1];
        int i5 = 0;
        for (ResourcePath resourcePath : list) {
            String strEncode = EncodedPath.encode(resourcePath);
            objArr[i5] = strEncode;
            objArr[i5 + 1] = EncodedPath.prefixSuccessor(strEncode);
            objArr[i5 + 2] = Integer.valueOf(resourcePath.length() + 1);
            objArr[i5 + 3] = Long.valueOf(timestamp.getSeconds());
            objArr[i5 + 4] = Long.valueOf(timestamp.getSeconds());
            objArr[i5 + 5] = Integer.valueOf(timestamp.getNanoseconds());
            objArr[i5 + 6] = Long.valueOf(timestamp.getSeconds());
            int i6 = i5 + 8;
            objArr[i5 + 7] = Integer.valueOf(timestamp.getNanoseconds());
            i5 += 9;
            objArr[i6] = EncodedPath.encode(documentKey.getPath());
        }
        objArr[i5] = Integer.valueOf(i4);
        final BackgroundQueue backgroundQueue = new BackgroundQueue();
        final HashMap map = new HashMap();
        this.db.query(sbRepeatSequence.toString()).binding(objArr).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.u0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteRemoteDocumentCache.c(this.f10626a, backgroundQueue, map, function, queryContext, (Cursor) obj);
            }
        });
        backgroundQueue.drain();
        return map;
    }

    private Map<DocumentKey, MutableDocument> getAll(List<ResourcePath> list, FieldIndex.IndexOffset indexOffset, int i4, Function<MutableDocument, Boolean> function) {
        return getAll(list, indexOffset, i4, function, null);
    }
}

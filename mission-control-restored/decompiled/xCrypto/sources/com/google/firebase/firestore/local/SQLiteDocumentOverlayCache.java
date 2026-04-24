package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.Overlay;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.BackgroundQueue;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;
import p2.C1699E;

/* JADX INFO: loaded from: classes.dex */
public class SQLiteDocumentOverlayCache implements DocumentOverlayCache {
    private final SQLitePersistence db;
    private final LocalSerializer serializer;
    private final String uid;

    public SQLiteDocumentOverlayCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer, User user) {
        this.db = sQLitePersistence;
        this.serializer = localSerializer;
        this.uid = user.isAuthenticated() ? user.getUid() : "";
    }

    public static /* synthetic */ void a(SQLiteDocumentOverlayCache sQLiteDocumentOverlayCache, byte[] bArr, int i4, Map map) {
        Overlay overlayDecodeOverlay = sQLiteDocumentOverlayCache.decodeOverlay(bArr, i4);
        synchronized (map) {
            map.put(overlayDecodeOverlay.getKey(), overlayDecodeOverlay);
        }
    }

    public static /* synthetic */ Overlay c(SQLiteDocumentOverlayCache sQLiteDocumentOverlayCache, Cursor cursor) {
        sQLiteDocumentOverlayCache.getClass();
        return sQLiteDocumentOverlayCache.decodeOverlay(cursor.getBlob(0), cursor.getInt(1));
    }

    private Overlay decodeOverlay(byte[] bArr, int i4) {
        try {
            return Overlay.create(i4, this.serializer.decodeMutation(C1699E.G(bArr)));
        } catch (com.google.protobuf.D e4) {
            throw Assert.fail("Overlay failed to parse: %s", e4);
        }
    }

    public static /* synthetic */ void e(SQLiteDocumentOverlayCache sQLiteDocumentOverlayCache, int[] iArr, String[] strArr, String[] strArr2, BackgroundQueue backgroundQueue, Map map, Cursor cursor) {
        sQLiteDocumentOverlayCache.getClass();
        iArr[0] = cursor.getInt(1);
        strArr[0] = cursor.getString(2);
        strArr2[0] = cursor.getString(3);
        sQLiteDocumentOverlayCache.processOverlaysInBackground(backgroundQueue, map, cursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processOverlaysInBackground(BackgroundQueue backgroundQueue, final Map<DocumentKey, Overlay> map, Cursor cursor) {
        final byte[] blob = cursor.getBlob(0);
        final int i4 = cursor.getInt(1);
        Executor executor = backgroundQueue;
        if (cursor.isLast()) {
            executor = Executors.DIRECT_EXECUTOR;
        }
        executor.execute(new Runnable() { // from class: com.google.firebase.firestore.local.J
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteDocumentOverlayCache.a(this.f10510a, blob, i4, map);
            }
        });
    }

    private void processSingleCollection(final Map<DocumentKey, Overlay> map, final BackgroundQueue backgroundQueue, ResourcePath resourcePath, List<Object> list) {
        if (list.isEmpty()) {
            return;
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND document_id IN (", Arrays.asList(this.uid, EncodedPath.encode(resourcePath)), list, ")");
        while (longQuery.hasMoreSubqueries()) {
            longQuery.performNextSubquery().forEach(new Consumer() { // from class: com.google.firebase.firestore.local.N
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    this.f10529a.processOverlaysInBackground(backgroundQueue, map, (Cursor) obj);
                }
            });
        }
    }

    private void saveOverlay(int i4, DocumentKey documentKey, Mutation mutation) {
        this.db.execute("INSERT OR REPLACE INTO document_overlays (uid, collection_group, collection_path, document_id, largest_batch_id, overlay_mutation) VALUES (?, ?, ?, ?, ?, ?)", this.uid, documentKey.getCollectionGroup(), EncodedPath.encode(documentKey.getPath().popLast()), documentKey.getPath().getLastSegment(), Integer.valueOf(i4), this.serializer.encodeMutation(mutation).toByteArray());
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Overlay getOverlay(DocumentKey documentKey) {
        return (Overlay) this.db.query("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND document_id = ?").binding(this.uid, EncodedPath.encode(documentKey.getPath().popLast()), documentKey.getPath().getLastSegment()).firstValue(new Function() { // from class: com.google.firebase.firestore.local.M
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return SQLiteDocumentOverlayCache.c(this.f10527a, (Cursor) obj);
            }
        });
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(SortedSet<DocumentKey> sortedSet) {
        Assert.hardAssert(sortedSet.comparator() == null, "getOverlays() requires natural order", new Object[0]);
        HashMap map = new HashMap();
        BackgroundQueue backgroundQueue = new BackgroundQueue();
        ResourcePath collectionPath = ResourcePath.EMPTY;
        ArrayList arrayList = new ArrayList();
        for (DocumentKey documentKey : sortedSet) {
            if (!collectionPath.equals(documentKey.getCollectionPath())) {
                processSingleCollection(map, backgroundQueue, collectionPath, arrayList);
                collectionPath = documentKey.getCollectionPath();
                arrayList.clear();
            }
            arrayList.add(documentKey.getDocumentId());
        }
        processSingleCollection(map, backgroundQueue, collectionPath, arrayList);
        backgroundQueue.drain();
        return map;
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public void removeOverlaysForBatchId(int i4) {
        this.db.execute("DELETE FROM document_overlays WHERE uid = ? AND largest_batch_id = ?", this.uid, Integer.valueOf(i4));
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public void saveOverlays(int i4, Map<DocumentKey, Mutation> map) {
        for (Map.Entry<DocumentKey, Mutation> entry : map.entrySet()) {
            DocumentKey key = entry.getKey();
            saveOverlay(i4, key, (Mutation) Preconditions.checkNotNull(entry.getValue(), "null value for key: %s", key));
        }
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(ResourcePath resourcePath, int i4) {
        final HashMap map = new HashMap();
        final BackgroundQueue backgroundQueue = new BackgroundQueue();
        this.db.query("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_path = ? AND largest_batch_id > ?").binding(this.uid, EncodedPath.encode(resourcePath), Integer.valueOf(i4)).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.I
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                this.f10506a.processOverlaysInBackground(backgroundQueue, map, (Cursor) obj);
            }
        });
        backgroundQueue.drain();
        return map;
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlayCache
    public Map<DocumentKey, Overlay> getOverlays(String str, int i4, int i5) {
        final HashMap map = new HashMap();
        final String[] strArr = new String[1];
        final String[] strArr2 = new String[1];
        final int[] iArr = new int[1];
        final BackgroundQueue backgroundQueue = new BackgroundQueue();
        this.db.query("SELECT overlay_mutation, largest_batch_id, collection_path, document_id  FROM document_overlays WHERE uid = ? AND collection_group = ? AND largest_batch_id > ? ORDER BY largest_batch_id, collection_path, document_id LIMIT ?").binding(this.uid, str, Integer.valueOf(i4), Integer.valueOf(i5)).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.K
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteDocumentOverlayCache.e(this.f10515a, iArr, strArr, strArr2, backgroundQueue, map, (Cursor) obj);
            }
        });
        if (strArr[0] == null) {
            return map;
        }
        SQLitePersistence.Query query = this.db.query("SELECT overlay_mutation, largest_batch_id FROM document_overlays WHERE uid = ? AND collection_group = ? AND (collection_path > ? OR (collection_path = ? AND document_id > ?)) AND largest_batch_id = ?");
        String str2 = this.uid;
        String str3 = strArr[0];
        query.binding(str2, str, str3, str3, strArr2[0], Integer.valueOf(iArr[0])).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.L
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                this.f10523a.processOverlaysInBackground(backgroundQueue, map, (Cursor) obj);
            }
        });
        backgroundQueue.drain();
        return map;
    }
}

package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.proto.WriteBatch;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.AbstractC1062i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class SQLiteMutationQueue implements MutationQueue {
    private static final int BLOB_MAX_INLINE_LENGTH = 1000000;
    private final SQLitePersistence db;
    private final IndexManager indexManager;
    private AbstractC1062i lastStreamToken;
    private int nextBatchId;
    private final LocalSerializer serializer;
    private final String uid;

    public static class BlobAccumulator implements Consumer<Cursor> {
        private final ArrayList<AbstractC1062i> chunks = new ArrayList<>();
        private boolean more = true;

        public BlobAccumulator(byte[] bArr) {
            addChunk(bArr);
        }

        private void addChunk(byte[] bArr) {
            this.chunks.add(AbstractC1062i.p(bArr));
        }

        public int numChunks() {
            return this.chunks.size();
        }

        public AbstractC1062i result() {
            return AbstractC1062i.o(this.chunks);
        }

        @Override // com.google.firebase.firestore.util.Consumer
        public void accept(Cursor cursor) {
            byte[] blob = cursor.getBlob(0);
            addChunk(blob);
            if (blob.length < SQLiteMutationQueue.BLOB_MAX_INLINE_LENGTH) {
                this.more = false;
            }
        }
    }

    public SQLiteMutationQueue(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer, User user, IndexManager indexManager) {
        this.db = sQLitePersistence;
        this.serializer = localSerializer;
        this.uid = user.isAuthenticated() ? user.getUid() : "";
        this.lastStreamToken = WriteStream.EMPTY_STREAM_TOKEN;
        this.indexManager = indexManager;
    }

    public static /* synthetic */ void b(SQLiteMutationQueue sQLiteMutationQueue, List list, Cursor cursor) {
        sQLiteMutationQueue.getClass();
        list.add(sQLiteMutationQueue.decodeInlineMutationBatch(cursor.getInt(0), cursor.getBlob(1)));
    }

    public static /* synthetic */ void c(SQLiteMutationQueue sQLiteMutationQueue, Cursor cursor) {
        sQLiteMutationQueue.getClass();
        sQLiteMutationQueue.lastStreamToken = AbstractC1062i.p(cursor.getBlob(0));
    }

    public static /* synthetic */ MutationBatch d(SQLiteMutationQueue sQLiteMutationQueue, Cursor cursor) {
        sQLiteMutationQueue.getClass();
        return sQLiteMutationQueue.decodeInlineMutationBatch(cursor.getInt(0), cursor.getBlob(1));
    }

    private MutationBatch decodeInlineMutationBatch(int i4, byte[] bArr) {
        try {
            if (bArr.length < BLOB_MAX_INLINE_LENGTH) {
                return this.serializer.decodeMutationBatch(WriteBatch.parseFrom(bArr));
            }
            BlobAccumulator blobAccumulator = new BlobAccumulator(bArr);
            while (blobAccumulator.more) {
                this.db.query("SELECT SUBSTR(mutations, ?, ?) FROM mutations WHERE uid = ? AND batch_id = ?").binding(Integer.valueOf((blobAccumulator.numChunks() * BLOB_MAX_INLINE_LENGTH) + 1), Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, Integer.valueOf(i4)).first(blobAccumulator);
            }
            return this.serializer.decodeMutationBatch(WriteBatch.parseFrom(blobAccumulator.result()));
        } catch (com.google.protobuf.D e4) {
            throw Assert.fail("MutationBatch failed to parse: %s", e4);
        }
    }

    public static /* synthetic */ MutationBatch e(SQLiteMutationQueue sQLiteMutationQueue, int i4, Cursor cursor) {
        sQLiteMutationQueue.getClass();
        return sQLiteMutationQueue.decodeInlineMutationBatch(i4, cursor.getBlob(0));
    }

    public static /* synthetic */ void h(SQLiteMutationQueue sQLiteMutationQueue, List list, Cursor cursor) {
        sQLiteMutationQueue.getClass();
        list.add(sQLiteMutationQueue.decodeInlineMutationBatch(cursor.getInt(0), cursor.getBlob(1)));
    }

    public static /* synthetic */ void i(SQLiteMutationQueue sQLiteMutationQueue, Set set, List list, Cursor cursor) {
        sQLiteMutationQueue.getClass();
        int i4 = cursor.getInt(0);
        if (set.contains(Integer.valueOf(i4))) {
            return;
        }
        set.add(Integer.valueOf(i4));
        list.add(sQLiteMutationQueue.decodeInlineMutationBatch(i4, cursor.getBlob(1)));
    }

    public static /* synthetic */ void j(SQLiteMutationQueue sQLiteMutationQueue, List list, int i4, Cursor cursor) {
        sQLiteMutationQueue.getClass();
        int i5 = cursor.getInt(0);
        int size = list.size();
        if ((size <= 0 || i5 != ((MutationBatch) list.get(size - 1)).getBatchId()) && EncodedPath.decodeResourcePath(cursor.getString(1)).length() == i4) {
            list.add(sQLiteMutationQueue.decodeInlineMutationBatch(i5, cursor.getBlob(2)));
        }
    }

    private void loadNextBatchIdAcrossAllUsers() {
        final ArrayList arrayList = new ArrayList();
        this.db.query("SELECT uid FROM mutation_queues").forEach(new Consumer() { // from class: com.google.firebase.firestore.local.j0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                arrayList.add(((Cursor) obj).getString(0));
            }
        });
        this.nextBatchId = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.db.query("SELECT MAX(batch_id) FROM mutations WHERE uid = ?").binding((String) it.next()).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.k0
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    SQLiteMutationQueue sQLiteMutationQueue = this.f10589a;
                    sQLiteMutationQueue.nextBatchId = Math.max(sQLiteMutationQueue.nextBatchId, ((Cursor) obj).getInt(0));
                }
            });
        }
        this.nextBatchId++;
    }

    private void writeMutationQueueMetadata() {
        this.db.execute("INSERT OR REPLACE INTO mutation_queues (uid, last_acknowledged_batch_id, last_stream_token) VALUES (?, ?, ?)", this.uid, -1, this.lastStreamToken.G());
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void acknowledgeBatch(MutationBatch mutationBatch, AbstractC1062i abstractC1062i) {
        this.lastStreamToken = (AbstractC1062i) Preconditions.checkNotNull(abstractC1062i);
        writeMutationQueueMetadata();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch addMutationBatch(Timestamp timestamp, List<Mutation> list, List<Mutation> list2) {
        int i4 = this.nextBatchId;
        this.nextBatchId = i4 + 1;
        MutationBatch mutationBatch = new MutationBatch(i4, timestamp, list, list2);
        this.db.execute("INSERT INTO mutations (uid, batch_id, mutations) VALUES (?, ?, ?)", this.uid, Integer.valueOf(i4), this.serializer.encodeMutationBatch(mutationBatch).toByteArray());
        HashSet hashSet = new HashSet();
        SQLiteStatement sQLiteStatementPrepare = this.db.prepare("INSERT INTO document_mutations (uid, path, batch_id) VALUES (?, ?, ?)");
        Iterator<Mutation> it = list2.iterator();
        while (it.hasNext()) {
            DocumentKey key = it.next().getKey();
            if (hashSet.add(key)) {
                this.db.execute(sQLiteStatementPrepare, this.uid, EncodedPath.encode(key.getPath()), Integer.valueOf(i4));
                this.indexManager.addToCollectionParentIndex(key.getCollectionPath());
            }
        }
        return mutationBatch;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> getAllMutationBatches() {
        final ArrayList arrayList = new ArrayList();
        this.db.query("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? ORDER BY batch_id ASC").binding(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.h0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteMutationQueue.h(this.f10577a, arrayList, (Cursor) obj);
            }
        });
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> getAllMutationBatchesAffectingDocumentKey(DocumentKey documentKey) {
        String strEncode = EncodedPath.encode(documentKey.getPath());
        final ArrayList arrayList = new ArrayList();
        this.db.query("SELECT m.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path = ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").binding(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, strEncode).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.b0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteMutationQueue.b(this.f10562a, arrayList, (Cursor) obj);
            }
        });
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> getAllMutationBatchesAffectingDocumentKeys(Iterable<DocumentKey> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<DocumentKey> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(EncodedPath.encode(it.next().getPath()));
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "SELECT DISTINCT dm.batch_id, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path IN (", Arrays.asList(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid), arrayList, ") AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id");
        final ArrayList arrayList2 = new ArrayList();
        final HashSet hashSet = new HashSet();
        while (longQuery.hasMoreSubqueries()) {
            longQuery.performNextSubquery().forEach(new Consumer() { // from class: com.google.firebase.firestore.local.m0
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    SQLiteMutationQueue.i(this.f10594a, hashSet, arrayList2, (Cursor) obj);
                }
            });
        }
        if (longQuery.getSubqueriesPerformed() > 1) {
            Collections.sort(arrayList2, new Comparator() { // from class: com.google.firebase.firestore.local.c0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Util.compareIntegers(((MutationBatch) obj).getBatchId(), ((MutationBatch) obj2).getBatchId());
                }
            });
        }
        return arrayList2;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public List<MutationBatch> getAllMutationBatchesAffectingQuery(Query query) {
        Assert.hardAssert(!query.isCollectionGroupQuery(), "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
        ResourcePath path = query.getPath();
        final int length = path.length() + 1;
        String strEncode = EncodedPath.encode(path);
        String strPrefixSuccessor = EncodedPath.prefixSuccessor(strEncode);
        final ArrayList arrayList = new ArrayList();
        this.db.query("SELECT dm.batch_id, dm.path, SUBSTR(m.mutations, 1, ?) FROM document_mutations dm, mutations m WHERE dm.uid = ? AND dm.path >= ? AND dm.path < ? AND dm.uid = m.uid AND dm.batch_id = m.batch_id ORDER BY dm.batch_id").binding(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, strEncode, strPrefixSuccessor).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.e0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteMutationQueue.j(this.f10569a, arrayList, length, (Cursor) obj);
            }
        });
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public int getHighestUnacknowledgedBatchId() {
        return ((Integer) this.db.query("SELECT IFNULL(MAX(batch_id), ?) FROM mutations WHERE uid = ?").binding(-1, this.uid).firstValue(new Function() { // from class: com.google.firebase.firestore.local.f0
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((Cursor) obj).getInt(0));
            }
        })).intValue();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public AbstractC1062i getLastStreamToken() {
        return this.lastStreamToken;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch getNextMutationBatchAfterBatchId(int i4) {
        return (MutationBatch) this.db.query("SELECT batch_id, SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id >= ? ORDER BY batch_id ASC LIMIT 1").binding(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, Integer.valueOf(i4 + 1)).firstValue(new Function() { // from class: com.google.firebase.firestore.local.l0
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return SQLiteMutationQueue.d(this.f10592a, (Cursor) obj);
            }
        });
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public boolean isEmpty() {
        return this.db.query("SELECT batch_id FROM mutations WHERE uid = ? LIMIT 1").binding(this.uid).isEmpty();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch lookupMutationBatch(final int i4) {
        return (MutationBatch) this.db.query("SELECT SUBSTR(mutations, 1, ?) FROM mutations WHERE uid = ? AND batch_id = ?").binding(Integer.valueOf(BLOB_MAX_INLINE_LENGTH), this.uid, Integer.valueOf(i4)).firstValue(new Function() { // from class: com.google.firebase.firestore.local.d0
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return SQLiteMutationQueue.e(this.f10566a, i4, (Cursor) obj);
            }
        });
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void performConsistencyCheck() {
        if (isEmpty()) {
            final ArrayList arrayList = new ArrayList();
            this.db.query("SELECT path FROM document_mutations WHERE uid = ?").binding(this.uid).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.i0
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    arrayList.add(EncodedPath.decodeResourcePath(((Cursor) obj).getString(0)));
                }
            });
            Assert.hardAssert(arrayList.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty. Dangling keys: %s", arrayList);
        }
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void removeMutationBatch(MutationBatch mutationBatch) {
        SQLiteStatement sQLiteStatementPrepare = this.db.prepare("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        SQLiteStatement sQLiteStatementPrepare2 = this.db.prepare("DELETE FROM document_mutations WHERE uid = ? AND path = ? AND batch_id = ?");
        int batchId = mutationBatch.getBatchId();
        Assert.hardAssert(this.db.execute(sQLiteStatementPrepare, this.uid, Integer.valueOf(batchId)) != 0, "Mutation batch (%s, %d) did not exist", this.uid, Integer.valueOf(mutationBatch.getBatchId()));
        Iterator<Mutation> it = mutationBatch.getMutations().iterator();
        while (it.hasNext()) {
            DocumentKey key = it.next().getKey();
            this.db.execute(sQLiteStatementPrepare2, this.uid, EncodedPath.encode(key.getPath()), Integer.valueOf(batchId));
            this.db.getReferenceDelegate().removeMutationReference(key);
        }
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void setLastStreamToken(AbstractC1062i abstractC1062i) {
        this.lastStreamToken = (AbstractC1062i) Preconditions.checkNotNull(abstractC1062i);
        writeMutationQueueMetadata();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void start() {
        loadNextBatchIdAcrossAllUsers();
        if (this.db.query("SELECT last_stream_token FROM mutation_queues WHERE uid = ?").binding(this.uid).first(new Consumer() { // from class: com.google.firebase.firestore.local.g0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteMutationQueue.c(this.f10574a, (Cursor) obj);
            }
        }) == 0) {
            writeMutationQueueMetadata();
        }
    }
}

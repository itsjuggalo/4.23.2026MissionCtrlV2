package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.SparseArray;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.SQLiteTargetCache;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
final class SQLiteTargetCache implements TargetCache {
    private final SQLitePersistence db;
    private int highestTargetId;
    private long lastListenSequenceNumber;
    private SnapshotVersion lastRemoteSnapshotVersion = SnapshotVersion.NONE;
    private final LocalSerializer localSerializer;
    private long targetCount;

    public static class DocumentKeysHolder {
        ImmutableSortedSet<DocumentKey> keys;

        private DocumentKeysHolder() {
            this.keys = DocumentKey.emptyKeySet();
        }
    }

    public static class TargetDataHolder {
        TargetData targetData;

        private TargetDataHolder() {
        }
    }

    public SQLiteTargetCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer) {
        this.db = sQLitePersistence;
        this.localSerializer = localSerializer;
    }

    public static /* synthetic */ void b(SQLiteTargetCache sQLiteTargetCache, Target target, TargetDataHolder targetDataHolder, Cursor cursor) {
        sQLiteTargetCache.getClass();
        TargetData targetDataDecodeTargetData = sQLiteTargetCache.decodeTargetData(cursor.getBlob(0));
        if (target.equals(targetDataDecodeTargetData.getTarget())) {
            targetDataHolder.targetData = targetDataDecodeTargetData;
        }
    }

    public static /* synthetic */ void c(SQLiteTargetCache sQLiteTargetCache, Cursor cursor) {
        sQLiteTargetCache.getClass();
        sQLiteTargetCache.highestTargetId = cursor.getInt(0);
        sQLiteTargetCache.lastListenSequenceNumber = cursor.getInt(1);
        sQLiteTargetCache.lastRemoteSnapshotVersion = new SnapshotVersion(new Timestamp(cursor.getLong(2), cursor.getInt(3)));
        sQLiteTargetCache.targetCount = cursor.getLong(4);
    }

    public static /* synthetic */ void d(SQLiteTargetCache sQLiteTargetCache, SparseArray sparseArray, int[] iArr, Cursor cursor) {
        sQLiteTargetCache.getClass();
        int i4 = cursor.getInt(0);
        if (sparseArray.get(i4) == null) {
            sQLiteTargetCache.removeTarget(i4);
            iArr[0] = iArr[0] + 1;
        }
    }

    private TargetData decodeTargetData(byte[] bArr) {
        try {
            return this.localSerializer.decodeTargetData(com.google.firebase.firestore.proto.Target.parseFrom(bArr));
        } catch (com.google.protobuf.D e4) {
            throw Assert.fail("TargetData failed to parse: %s", e4);
        }
    }

    public static /* synthetic */ void e(SQLiteTargetCache sQLiteTargetCache, Consumer consumer, Cursor cursor) {
        sQLiteTargetCache.getClass();
        consumer.accept(sQLiteTargetCache.decodeTargetData(cursor.getBlob(0)));
    }

    private void removeTarget(int i4) {
        removeMatchingKeysForTargetId(i4);
        this.db.execute("DELETE FROM targets WHERE target_id = ?", Integer.valueOf(i4));
        this.targetCount--;
    }

    private void saveTargetData(TargetData targetData) {
        int targetId = targetData.getTargetId();
        String canonicalId = targetData.getTarget().getCanonicalId();
        Timestamp timestamp = targetData.getSnapshotVersion().getTimestamp();
        this.db.execute("INSERT OR REPLACE INTO targets (target_id, canonical_id, snapshot_version_seconds, snapshot_version_nanos, resume_token, last_listen_sequence_number, target_proto) VALUES (?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(targetId), canonicalId, Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanoseconds()), targetData.getResumeToken().G(), Long.valueOf(targetData.getSequenceNumber()), this.localSerializer.encodeTargetData(targetData).toByteArray());
    }

    private boolean updateMetadata(TargetData targetData) {
        boolean z4;
        if (targetData.getTargetId() > this.highestTargetId) {
            this.highestTargetId = targetData.getTargetId();
            z4 = true;
        } else {
            z4 = false;
        }
        if (targetData.getSequenceNumber() <= this.lastListenSequenceNumber) {
            return z4;
        }
        this.lastListenSequenceNumber = targetData.getSequenceNumber();
        return true;
    }

    private void writeMetadata() {
        this.db.execute("UPDATE target_globals SET highest_target_id = ?, highest_listen_sequence_number = ?, last_remote_snapshot_version_seconds = ?, last_remote_snapshot_version_nanos = ?, target_count = ?", Integer.valueOf(this.highestTargetId), Long.valueOf(this.lastListenSequenceNumber), Long.valueOf(this.lastRemoteSnapshotVersion.getTimestamp().getSeconds()), Integer.valueOf(this.lastRemoteSnapshotVersion.getTimestamp().getNanoseconds()), Long.valueOf(this.targetCount));
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void addMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i4) {
        SQLiteStatement sQLiteStatementPrepare = this.db.prepare("INSERT OR IGNORE INTO target_documents (target_id, path) VALUES (?, ?)");
        SQLiteLruReferenceDelegate referenceDelegate = this.db.getReferenceDelegate();
        for (DocumentKey documentKey : immutableSortedSet) {
            this.db.execute(sQLiteStatementPrepare, Integer.valueOf(i4), EncodedPath.encode(documentKey.getPath()));
            referenceDelegate.addReference(documentKey);
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void addTargetData(TargetData targetData) {
        saveTargetData(targetData);
        updateMetadata(targetData);
        this.targetCount++;
        writeMetadata();
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public boolean containsKey(DocumentKey documentKey) {
        return !this.db.query("SELECT target_id FROM target_documents WHERE path = ? AND target_id != 0 LIMIT 1").binding(EncodedPath.encode(documentKey.getPath())).isEmpty();
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void forEachTarget(final Consumer<TargetData> consumer) {
        this.db.query("SELECT target_proto FROM targets").forEach(new Consumer() { // from class: com.google.firebase.firestore.local.R0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteTargetCache.e(this.f10542a, consumer, (Cursor) obj);
            }
        });
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public long getHighestListenSequenceNumber() {
        return this.lastListenSequenceNumber;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public int getHighestTargetId() {
        return this.highestTargetId;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.lastRemoteSnapshotVersion;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public ImmutableSortedSet<DocumentKey> getMatchingKeysForTargetId(int i4) {
        final DocumentKeysHolder documentKeysHolder = new DocumentKeysHolder();
        this.db.query("SELECT path FROM target_documents WHERE target_id = ?").binding(Integer.valueOf(i4)).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.S0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteTargetCache.DocumentKeysHolder documentKeysHolder2 = documentKeysHolder;
                documentKeysHolder2.keys = documentKeysHolder2.keys.insert(DocumentKey.fromPath(EncodedPath.decodeResourcePath(((Cursor) obj).getString(0))));
            }
        });
        return documentKeysHolder.keys;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public long getTargetCount() {
        return this.targetCount;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public TargetData getTargetData(final Target target) {
        String canonicalId = target.getCanonicalId();
        final TargetDataHolder targetDataHolder = new TargetDataHolder();
        this.db.query("SELECT target_proto FROM targets WHERE canonical_id = ?").binding(canonicalId).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.U0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteTargetCache.b(this.f10548a, target, targetDataHolder, (Cursor) obj);
            }
        });
        return targetDataHolder.targetData;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void removeMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i4) {
        SQLiteStatement sQLiteStatementPrepare = this.db.prepare("DELETE FROM target_documents WHERE target_id = ? AND path = ?");
        SQLiteLruReferenceDelegate referenceDelegate = this.db.getReferenceDelegate();
        for (DocumentKey documentKey : immutableSortedSet) {
            this.db.execute(sQLiteStatementPrepare, Integer.valueOf(i4), EncodedPath.encode(documentKey.getPath()));
            referenceDelegate.removeReference(documentKey);
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void removeMatchingKeysForTargetId(int i4) {
        this.db.execute("DELETE FROM target_documents WHERE target_id = ?", Integer.valueOf(i4));
    }

    public int removeQueries(long j4, final SparseArray<?> sparseArray) {
        final int[] iArr = new int[1];
        this.db.query("SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?").binding(Long.valueOf(j4)).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.Q0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteTargetCache.d(this.f10539a, sparseArray, iArr, (Cursor) obj);
            }
        });
        writeMetadata();
        return iArr[0];
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void removeTargetData(TargetData targetData) {
        removeTarget(targetData.getTargetId());
        writeMetadata();
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void setLastRemoteSnapshotVersion(SnapshotVersion snapshotVersion) {
        this.lastRemoteSnapshotVersion = snapshotVersion;
        writeMetadata();
    }

    public void start() {
        Assert.hardAssert(this.db.query("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1").first(new Consumer() { // from class: com.google.firebase.firestore.local.T0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteTargetCache.c(this.f10546a, (Cursor) obj);
            }
        }) == 1, "Missing target_globals entry", new Object[0]);
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void updateTargetData(TargetData targetData) {
        saveTargetData(targetData);
        if (updateMetadata(targetData)) {
            writeMetadata();
        }
    }
}

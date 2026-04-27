package com.google.firebase.firestore.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.google.firebase.firestore.local.MemoryIndexManager;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class SQLiteSchema {
    static final int MIGRATION_BATCH_SIZE = 100;
    static final int VERSION = 17;
    private final SQLiteDatabase db;
    private final LocalSerializer serializer;

    public SQLiteSchema(SQLiteDatabase sQLiteDatabase, LocalSerializer localSerializer) {
        this.db = sQLiteDatabase;
        this.serializer = localSerializer;
    }

    private void addPathLength() {
        if (tableContainsColumn("remote_documents", "path_length")) {
            return;
        }
        this.db.execSQL("ALTER TABLE remote_documents ADD COLUMN path_length INTEGER");
    }

    private void addPendingDataMigration(String str) {
        this.db.execSQL("INSERT OR IGNORE INTO data_migrations (migration_name) VALUES (?)", new String[]{str});
    }

    private void addReadTime() {
        this.db.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_seconds INTEGER");
        this.db.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_nanos INTEGER");
    }

    private void addSequenceNumber() {
        if (tableContainsColumn("target_documents", "sequence_number")) {
            return;
        }
        this.db.execSQL("ALTER TABLE target_documents ADD COLUMN sequence_number INTEGER");
    }

    private void addTargetCount() {
        if (!tableContainsColumn("target_globals", "target_count")) {
            this.db.execSQL("ALTER TABLE target_globals ADD COLUMN target_count INTEGER");
        }
        long jQueryNumEntries = DatabaseUtils.queryNumEntries(this.db, "targets");
        ContentValues contentValues = new ContentValues();
        contentValues.put("target_count", Long.valueOf(jQueryNumEntries));
        this.db.update("target_globals", contentValues, null, null);
    }

    private void createBundleCache() {
        ifTablesDontExist(new String[]{"bundles", "named_queries"}, new Runnable() { // from class: com.google.firebase.firestore.local.z0
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.f(this.f10649a);
            }
        });
    }

    private void createDataMigrationTable() {
        ifTablesDontExist(new String[]{"data_migrations"}, new Runnable() { // from class: com.google.firebase.firestore.local.L0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10526a.db.execSQL("CREATE TABLE data_migrations (migration_name TEXT, PRIMARY KEY (migration_name))");
            }
        });
    }

    private void createFieldIndex() {
        ifTablesDontExist(new String[]{"index_configuration", "index_state", "index_entries"}, new Runnable() { // from class: com.google.firebase.firestore.local.F0
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.q(this.f10499a);
            }
        });
    }

    private void createGlobalsTable() {
        ifTablesDontExist(new String[]{"globals"}, new Runnable() { // from class: com.google.firebase.firestore.local.M0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10528a.db.execSQL("CREATE TABLE globals (name TEXT PRIMARY KEY, value BLOB)");
            }
        });
    }

    private void createOverlays() {
        ifTablesDontExist(new String[]{"document_overlays"}, new Runnable() { // from class: com.google.firebase.firestore.local.B0
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.k(this.f10491a);
            }
        });
    }

    private void createV1MutationQueue() {
        ifTablesDontExist(new String[]{"mutation_queues", "mutations", "document_mutations"}, new Runnable() { // from class: com.google.firebase.firestore.local.C0
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.n(this.f10493a);
            }
        });
    }

    private void createV1RemoteDocumentCache() {
        ifTablesDontExist(new String[]{"remote_documents"}, new Runnable() { // from class: com.google.firebase.firestore.local.O0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10533a.db.execSQL("CREATE TABLE remote_documents (path TEXT PRIMARY KEY, contents BLOB)");
            }
        });
    }

    private void createV1TargetCache() {
        ifTablesDontExist(new String[]{"targets", "target_globals", "target_documents"}, new Runnable() { // from class: com.google.firebase.firestore.local.G0
            @Override // java.lang.Runnable
            public final void run() {
                SQLiteSchema.j(this.f10501a);
            }
        });
    }

    private void createV8CollectionParentsIndex() {
        ifTablesDontExist(new String[]{"collection_parents"}, new Runnable() { // from class: com.google.firebase.firestore.local.x0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10642a.db.execSQL("CREATE TABLE collection_parents (collection_id TEXT, parent TEXT, PRIMARY KEY(collection_id, parent))");
            }
        });
        final MemoryIndexManager.MemoryCollectionParentIndex memoryCollectionParentIndex = new MemoryIndexManager.MemoryCollectionParentIndex();
        final SQLiteStatement sQLiteStatementCompileStatement = this.db.compileStatement("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)");
        final Consumer consumer = new Consumer() { // from class: com.google.firebase.firestore.local.H0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.h(memoryCollectionParentIndex, sQLiteStatementCompileStatement, (ResourcePath) obj);
            }
        };
        new SQLitePersistence.Query(this.db, "SELECT path FROM remote_documents").forEach(new Consumer() { // from class: com.google.firebase.firestore.local.I0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                consumer.accept(EncodedPath.decodeResourcePath(((Cursor) obj).getString(0)).popLast());
            }
        });
        new SQLitePersistence.Query(this.db, "SELECT path FROM document_mutations").forEach(new Consumer() { // from class: com.google.firebase.firestore.local.J0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                consumer.accept(EncodedPath.decodeResourcePath(((Cursor) obj).getString(0)).popLast());
            }
        });
    }

    public static /* synthetic */ void d(SQLiteSchema sQLiteSchema, String str, Cursor cursor) {
        sQLiteSchema.getClass();
        sQLiteSchema.removeMutationBatch(str, cursor.getInt(0));
    }

    private void dropLastLimboFreeSnapshotVersion() {
        new SQLitePersistence.Query(this.db, "SELECT target_id, target_proto FROM targets").forEach(new Consumer() { // from class: com.google.firebase.firestore.local.N0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.s(this.f10532a, (Cursor) obj);
            }
        });
    }

    private void dropV1TargetCache() {
        if (tableExists("targets")) {
            this.db.execSQL("DROP TABLE targets");
        }
        if (tableExists("target_globals")) {
            this.db.execSQL("DROP TABLE target_globals");
        }
        if (tableExists("target_documents")) {
            this.db.execSQL("DROP TABLE target_documents");
        }
    }

    private void ensurePathLength() {
        final boolean[] zArr;
        SQLitePersistence.Query queryBinding = new SQLitePersistence.Query(this.db, "SELECT path FROM remote_documents WHERE path_length IS NULL LIMIT ?").binding(100);
        final SQLiteStatement sQLiteStatementCompileStatement = this.db.compileStatement("UPDATE remote_documents SET path_length = ? WHERE path = ?");
        do {
            zArr = new boolean[]{false};
            queryBinding.forEach(new Consumer() { // from class: com.google.firebase.firestore.local.y0
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    SQLiteSchema.m(zArr, sQLiteStatementCompileStatement, (Cursor) obj);
                }
            });
        } while (zArr[0]);
    }

    private void ensureReadTime() {
        this.db.execSQL("UPDATE remote_documents SET read_time_seconds = 0, read_time_nanos = 0 WHERE read_time_seconds IS NULL");
    }

    private void ensureSequenceNumbers() {
        final boolean[] zArr;
        Long l4 = (Long) new SQLitePersistence.Query(this.db, "SELECT highest_listen_sequence_number FROM target_globals LIMIT 1").firstValue(new Function() { // from class: com.google.firebase.firestore.local.D0
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                return Long.valueOf(((Cursor) obj).getLong(0));
            }
        });
        Assert.hardAssert(l4 != null, "Missing highest sequence number", new Object[0]);
        final long jLongValue = l4.longValue();
        final SQLiteStatement sQLiteStatementCompileStatement = this.db.compileStatement("INSERT INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)");
        SQLitePersistence.Query queryBinding = new SQLitePersistence.Query(this.db, "SELECT RD.path FROM remote_documents AS RD WHERE NOT EXISTS (SELECT TD.path FROM target_documents AS TD WHERE RD.path = TD.path AND TD.target_id = 0) LIMIT ?").binding(100);
        do {
            zArr = new boolean[]{false};
            queryBinding.forEach(new Consumer() { // from class: com.google.firebase.firestore.local.E0
                @Override // com.google.firebase.firestore.util.Consumer
                public final void accept(Object obj) {
                    SQLiteSchema.l(zArr, sQLiteStatementCompileStatement, jLongValue, (Cursor) obj);
                }
            });
        } while (zArr[0]);
    }

    private void ensureTargetGlobal() {
        if (DatabaseUtils.queryNumEntries(this.db, "target_globals") == 1) {
            return;
        }
        this.db.execSQL("INSERT INTO target_globals (highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos) VALUES (?, ?, ?, ?)", new String[]{"0", "0", "0", "0"});
    }

    public static /* synthetic */ void f(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE bundles (bundle_id TEXT PRIMARY KEY, create_time_seconds INTEGER, create_time_nanos INTEGER, schema_version INTEGER, total_documents INTEGER, total_bytes INTEGER)");
        sQLiteSchema.db.execSQL("CREATE TABLE named_queries (name TEXT PRIMARY KEY, read_time_seconds INTEGER, read_time_nanos INTEGER, bundled_query_proto BLOB)");
    }

    public static /* synthetic */ void g(SQLiteSchema sQLiteSchema, Cursor cursor) {
        sQLiteSchema.getClass();
        int i4 = cursor.getInt(0);
        try {
            sQLiteSchema.db.execSQL("UPDATE targets SET canonical_id  = ? WHERE target_id = ?", new Object[]{sQLiteSchema.serializer.decodeTargetData(Target.parseFrom(cursor.getBlob(1))).getTarget().getCanonicalId(), Integer.valueOf(i4)});
        } catch (com.google.protobuf.D unused) {
            throw Assert.fail("Failed to decode Query data for target %s", Integer.valueOf(i4));
        }
    }

    public static /* synthetic */ void h(MemoryIndexManager.MemoryCollectionParentIndex memoryCollectionParentIndex, SQLiteStatement sQLiteStatement, ResourcePath resourcePath) {
        if (memoryCollectionParentIndex.add(resourcePath)) {
            String lastSegment = resourcePath.getLastSegment();
            ResourcePath resourcePathPopLast = resourcePath.popLast();
            sQLiteStatement.clearBindings();
            sQLiteStatement.bindString(1, lastSegment);
            sQLiteStatement.bindString(2, EncodedPath.encode(resourcePathPopLast));
            sQLiteStatement.execute();
        }
    }

    private boolean hasReadTime() {
        boolean zTableContainsColumn = tableContainsColumn("remote_documents", "read_time_seconds");
        boolean zTableContainsColumn2 = tableContainsColumn("remote_documents", "read_time_nanos");
        Assert.hardAssert(zTableContainsColumn == zTableContainsColumn2, "Table contained just one of read_time_seconds or read_time_nanos", new Object[0]);
        return zTableContainsColumn && zTableContainsColumn2;
    }

    public static /* synthetic */ void i(final SQLiteSchema sQLiteSchema, Cursor cursor) {
        sQLiteSchema.getClass();
        final String string = cursor.getString(0);
        new SQLitePersistence.Query(sQLiteSchema.db, "SELECT batch_id FROM mutations WHERE uid = ? AND batch_id <= ?").binding(string, Long.valueOf(cursor.getLong(1))).forEach(new Consumer() { // from class: com.google.firebase.firestore.local.K0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.d(this.f10521a, string, (Cursor) obj);
            }
        });
    }

    private void ifTablesDontExist(String[] strArr, Runnable runnable) {
        String str = "[" + TextUtils.join(", ", strArr) + "]";
        boolean z4 = false;
        for (int i4 = 0; i4 < strArr.length; i4++) {
            String str2 = strArr[i4];
            boolean zTableExists = tableExists(str2);
            if (i4 == 0) {
                z4 = zTableExists;
            } else if (zTableExists != z4) {
                String str3 = "Expected all of " + str + " to either exist or not, but ";
                throw new IllegalStateException(z4 ? str3 + strArr[0] + " exists and " + str2 + " does not" : str3 + strArr[0] + " does not exist and " + str2 + " does");
            }
        }
        if (!z4) {
            runnable.run();
            return;
        }
        Logger.debug("SQLiteSchema", "Skipping migration because all of " + str + " already exist", new Object[0]);
    }

    public static /* synthetic */ void j(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE targets (target_id INTEGER PRIMARY KEY, canonical_id TEXT, snapshot_version_seconds INTEGER, snapshot_version_nanos INTEGER, resume_token BLOB, last_listen_sequence_number INTEGER,target_proto BLOB)");
        sQLiteSchema.db.execSQL("CREATE INDEX query_targets ON targets (canonical_id, target_id)");
        sQLiteSchema.db.execSQL("CREATE TABLE target_globals (highest_target_id INTEGER, highest_listen_sequence_number INTEGER, last_remote_snapshot_version_seconds INTEGER, last_remote_snapshot_version_nanos INTEGER)");
        sQLiteSchema.db.execSQL("CREATE TABLE target_documents (target_id INTEGER, path TEXT, PRIMARY KEY (target_id, path))");
        sQLiteSchema.db.execSQL("CREATE INDEX document_targets ON target_documents (path, target_id)");
    }

    public static /* synthetic */ void k(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE document_overlays (uid TEXT, collection_path TEXT, document_id TEXT, collection_group TEXT, largest_batch_id INTEGER, overlay_mutation BLOB, PRIMARY KEY (uid, collection_path, document_id))");
        sQLiteSchema.db.execSQL("CREATE INDEX batch_id_overlay ON document_overlays (uid, largest_batch_id)");
        sQLiteSchema.db.execSQL("CREATE INDEX collection_group_overlay ON document_overlays (uid, collection_group)");
    }

    public static /* synthetic */ void l(boolean[] zArr, SQLiteStatement sQLiteStatement, long j4, Cursor cursor) {
        zArr[0] = true;
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindString(1, cursor.getString(0));
        sQLiteStatement.bindLong(2, j4);
        Assert.hardAssert(sQLiteStatement.executeInsert() != -1, "Failed to insert a sentinel row", new Object[0]);
    }

    public static /* synthetic */ void m(boolean[] zArr, SQLiteStatement sQLiteStatement, Cursor cursor) {
        zArr[0] = true;
        String string = cursor.getString(0);
        ResourcePath resourcePathDecodeResourcePath = EncodedPath.decodeResourcePath(string);
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, resourcePathDecodeResourcePath.length());
        sQLiteStatement.bindString(2, string);
        Assert.hardAssert(sQLiteStatement.executeUpdateDelete() != -1, "Failed to update document path", new Object[0]);
    }

    public static /* synthetic */ void n(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE mutation_queues (uid TEXT PRIMARY KEY, last_acknowledged_batch_id INTEGER, last_stream_token BLOB)");
        sQLiteSchema.db.execSQL("CREATE TABLE mutations (uid TEXT, batch_id INTEGER, mutations BLOB, PRIMARY KEY (uid, batch_id))");
        sQLiteSchema.db.execSQL("CREATE TABLE document_mutations (uid TEXT, path TEXT, batch_id INTEGER, PRIMARY KEY (uid, path, batch_id))");
    }

    public static /* synthetic */ void q(SQLiteSchema sQLiteSchema) {
        sQLiteSchema.db.execSQL("CREATE TABLE index_configuration (index_id INTEGER, collection_group TEXT, index_proto BLOB, PRIMARY KEY (index_id))");
        sQLiteSchema.db.execSQL("CREATE TABLE index_state (index_id INTEGER, uid TEXT, sequence_number INTEGER, read_time_seconds INTEGER, read_time_nanos INTEGER, document_key TEXT, largest_batch_id INTEGER, PRIMARY KEY (index_id, uid))");
        sQLiteSchema.db.execSQL("CREATE TABLE index_entries (index_id INTEGER, uid TEXT, array_value BLOB, directional_value BLOB, document_key TEXT, PRIMARY KEY (index_id, uid, array_value, directional_value, document_key))");
        sQLiteSchema.db.execSQL("CREATE INDEX read_time ON remote_documents(read_time_seconds, read_time_nanos)");
    }

    private void removeAcknowledgedMutations() {
        new SQLitePersistence.Query(this.db, "SELECT uid, last_acknowledged_batch_id FROM mutation_queues").forEach(new Consumer() { // from class: com.google.firebase.firestore.local.A0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.i(this.f10489a, (Cursor) obj);
            }
        });
    }

    private void removeMutationBatch(String str, int i4) {
        SQLiteStatement sQLiteStatementCompileStatement = this.db.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        sQLiteStatementCompileStatement.bindString(1, str);
        sQLiteStatementCompileStatement.bindLong(2, i4);
        Assert.hardAssert(sQLiteStatementCompileStatement.executeUpdateDelete() != 0, "Mutation batch (%s, %d) did not exist", str, Integer.valueOf(i4));
        this.db.execSQL("DELETE FROM document_mutations WHERE uid = ? AND batch_id = ?", new Object[]{str, Integer.valueOf(i4)});
    }

    private void rewriteCanonicalIds() {
        new SQLitePersistence.Query(this.db, "SELECT target_id, target_proto FROM targets").forEach(new Consumer() { // from class: com.google.firebase.firestore.local.P0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteSchema.g(this.f10536a, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ void s(SQLiteSchema sQLiteSchema, Cursor cursor) {
        sQLiteSchema.getClass();
        int i4 = cursor.getInt(0);
        try {
            sQLiteSchema.db.execSQL("UPDATE targets SET target_proto = ? WHERE target_id = ?", new Object[]{((Target) ((Target.Builder) Target.parseFrom(cursor.getBlob(1)).toBuilder()).clearLastLimboFreeSnapshotVersion().build()).toByteArray(), Integer.valueOf(i4)});
        } catch (com.google.protobuf.D unused) {
            throw Assert.fail("Failed to decode Query data for target %s", Integer.valueOf(i4));
        }
    }

    private boolean tableContainsColumn(String str, String str2) {
        return getTableColumns(str).indexOf(str2) != -1;
    }

    private boolean tableExists(String str) {
        return !new SQLitePersistence.Query(this.db, "SELECT 1=1 FROM sqlite_master WHERE tbl_name = ?").binding(str).isEmpty();
    }

    public List<String> getTableColumns(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.db.rawQuery("PRAGMA table_info(" + str + ")", null);
            int columnIndex = cursorRawQuery.getColumnIndex("name");
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(cursorRawQuery.getString(columnIndex));
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public void runSchemaUpgrades() {
        runSchemaUpgrades(0);
    }

    public void runSchemaUpgrades(int i4) {
        runSchemaUpgrades(i4, 17);
    }

    public void runSchemaUpgrades(int i4, int i5) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i4 < 1 && i5 >= 1) {
            createV1MutationQueue();
            createV1TargetCache();
            createV1RemoteDocumentCache();
        }
        if (i4 < 3 && i5 >= 3 && i4 != 0) {
            dropV1TargetCache();
            createV1TargetCache();
        }
        if (i4 < 4 && i5 >= 4) {
            ensureTargetGlobal();
            addTargetCount();
        }
        if (i4 < 5 && i5 >= 5) {
            addSequenceNumber();
        }
        if (i4 < 6 && i5 >= 6) {
            removeAcknowledgedMutations();
        }
        if (i4 < 7 && i5 >= 7) {
            ensureSequenceNumbers();
        }
        if (i4 < 8 && i5 >= 8) {
            createV8CollectionParentsIndex();
        }
        if (i4 < 9 && i5 >= 9) {
            if (!hasReadTime()) {
                addReadTime();
            } else {
                dropLastLimboFreeSnapshotVersion();
            }
        }
        if (i4 == 9 && i5 >= 10) {
            dropLastLimboFreeSnapshotVersion();
        }
        if (i4 < 11 && i5 >= 11) {
            rewriteCanonicalIds();
        }
        if (i4 < 12 && i5 >= 12) {
            createBundleCache();
        }
        if (i4 < 13 && i5 >= 13) {
            addPathLength();
            ensurePathLength();
        }
        if (i4 < 14 && i5 >= 14) {
            createOverlays();
            createDataMigrationTable();
            addPendingDataMigration(Persistence.DATA_MIGRATION_BUILD_OVERLAYS);
        }
        if (i4 < 15 && i5 >= 15) {
            ensureReadTime();
        }
        if (i4 < 16 && i5 >= 16) {
            createFieldIndex();
        }
        if (i4 < 17 && i5 >= 17) {
            createGlobalsTable();
        }
        Logger.debug("SQLiteSchema", "Migration from version %s to %s took %s milliseconds", Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
    }
}

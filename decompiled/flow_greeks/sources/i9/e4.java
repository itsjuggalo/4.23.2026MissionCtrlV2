package i9;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import i9.e3;
import i9.w0;
import java.util.ArrayList;
import java.util.List;
import l9.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f11930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f11931b;

    public e4(SQLiteDatabase sQLiteDatabase, p pVar) {
        this.f11930a = sQLiteDatabase;
        this.f11931b = pVar;
    }

    public static /* synthetic */ void d(e4 e4Var, String str, Cursor cursor) {
        e4Var.getClass();
        e4Var.S(str, cursor.getInt(0));
    }

    public static /* synthetic */ void f(e4 e4Var) {
        e4Var.f11930a.execSQL("CREATE TABLE bundles (bundle_id TEXT PRIMARY KEY, create_time_seconds INTEGER, create_time_nanos INTEGER, schema_version INTEGER, total_documents INTEGER, total_bytes INTEGER)");
        e4Var.f11930a.execSQL("CREATE TABLE named_queries (name TEXT PRIMARY KEY, read_time_seconds INTEGER, read_time_nanos INTEGER, bundled_query_proto BLOB)");
    }

    public static /* synthetic */ void g(e4 e4Var, Cursor cursor) {
        e4Var.getClass();
        int i10 = cursor.getInt(0);
        try {
            e4Var.f11930a.execSQL("UPDATE targets SET canonical_id  = ? WHERE target_id = ?", new Object[]{e4Var.f11931b.h(l9.c.s0(cursor.getBlob(1))).g().c(), Integer.valueOf(i10)});
        } catch (com.google.protobuf.d0 unused) {
            throw n9.b.a("Failed to decode Query data for target %s", Integer.valueOf(i10));
        }
    }

    public static /* synthetic */ void h(w0.a aVar, SQLiteStatement sQLiteStatement, j9.t tVar) {
        if (aVar.a(tVar)) {
            String strM = tVar.m();
            j9.t tVar2 = (j9.t) tVar.w();
            sQLiteStatement.clearBindings();
            sQLiteStatement.bindString(1, strM);
            sQLiteStatement.bindString(2, f.c(tVar2));
            sQLiteStatement.execute();
        }
    }

    public static /* synthetic */ void i(final e4 e4Var, Cursor cursor) {
        e4Var.getClass();
        final String string = cursor.getString(0);
        new e3.d(e4Var.f11930a, "SELECT batch_id FROM mutations WHERE uid = ? AND batch_id <= ?").b(string, Long.valueOf(cursor.getLong(1))).e(new n9.n() { // from class: i9.u3
            @Override // n9.n
            public final void accept(Object obj) {
                e4.d(this.f12175a, string, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ void j(e4 e4Var) {
        e4Var.f11930a.execSQL("CREATE TABLE targets (target_id INTEGER PRIMARY KEY, canonical_id TEXT, snapshot_version_seconds INTEGER, snapshot_version_nanos INTEGER, resume_token BLOB, last_listen_sequence_number INTEGER,target_proto BLOB)");
        e4Var.f11930a.execSQL("CREATE INDEX query_targets ON targets (canonical_id, target_id)");
        e4Var.f11930a.execSQL("CREATE TABLE target_globals (highest_target_id INTEGER, highest_listen_sequence_number INTEGER, last_remote_snapshot_version_seconds INTEGER, last_remote_snapshot_version_nanos INTEGER)");
        e4Var.f11930a.execSQL("CREATE TABLE target_documents (target_id INTEGER, path TEXT, PRIMARY KEY (target_id, path))");
        e4Var.f11930a.execSQL("CREATE INDEX document_targets ON target_documents (path, target_id)");
    }

    public static /* synthetic */ void k(e4 e4Var) {
        e4Var.f11930a.execSQL("CREATE TABLE document_overlays (uid TEXT, collection_path TEXT, document_id TEXT, collection_group TEXT, largest_batch_id INTEGER, overlay_mutation BLOB, PRIMARY KEY (uid, collection_path, document_id))");
        e4Var.f11930a.execSQL("CREATE INDEX batch_id_overlay ON document_overlays (uid, largest_batch_id)");
        e4Var.f11930a.execSQL("CREATE INDEX collection_group_overlay ON document_overlays (uid, collection_group)");
    }

    public static /* synthetic */ void l(boolean[] zArr, SQLiteStatement sQLiteStatement, long j10, Cursor cursor) {
        zArr[0] = true;
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindString(1, cursor.getString(0));
        sQLiteStatement.bindLong(2, j10);
        n9.b.d(sQLiteStatement.executeInsert() != -1, "Failed to insert a sentinel row", new Object[0]);
    }

    public static /* synthetic */ void m(boolean[] zArr, SQLiteStatement sQLiteStatement, Cursor cursor) {
        zArr[0] = true;
        String string = cursor.getString(0);
        j9.t tVarB = f.b(string);
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, tVarB.u());
        sQLiteStatement.bindString(2, string);
        n9.b.d(sQLiteStatement.executeUpdateDelete() != -1, "Failed to update document path", new Object[0]);
    }

    public static /* synthetic */ void n(e4 e4Var) {
        e4Var.f11930a.execSQL("CREATE TABLE mutation_queues (uid TEXT PRIMARY KEY, last_acknowledged_batch_id INTEGER, last_stream_token BLOB)");
        e4Var.f11930a.execSQL("CREATE TABLE mutations (uid TEXT, batch_id INTEGER, mutations BLOB, PRIMARY KEY (uid, batch_id))");
        e4Var.f11930a.execSQL("CREATE TABLE document_mutations (uid TEXT, path TEXT, batch_id INTEGER, PRIMARY KEY (uid, path, batch_id))");
    }

    public static /* synthetic */ void q(e4 e4Var) {
        e4Var.f11930a.execSQL("CREATE TABLE index_configuration (index_id INTEGER, collection_group TEXT, index_proto BLOB, PRIMARY KEY (index_id))");
        e4Var.f11930a.execSQL("CREATE TABLE index_state (index_id INTEGER, uid TEXT, sequence_number INTEGER, read_time_seconds INTEGER, read_time_nanos INTEGER, document_key TEXT, largest_batch_id INTEGER, PRIMARY KEY (index_id, uid))");
        e4Var.f11930a.execSQL("CREATE TABLE index_entries (index_id INTEGER, uid TEXT, array_value BLOB, directional_value BLOB, document_key TEXT, PRIMARY KEY (index_id, uid, array_value, directional_value, document_key))");
        e4Var.f11930a.execSQL("CREATE INDEX read_time ON remote_documents(read_time_seconds, read_time_nanos)");
    }

    public static /* synthetic */ void s(e4 e4Var, Cursor cursor) {
        e4Var.getClass();
        int i10 = cursor.getInt(0);
        try {
            e4Var.f11930a.execSQL("UPDATE targets SET target_proto = ? WHERE target_id = ?", new Object[]{((l9.c) ((c.b) l9.c.s0(cursor.getBlob(1)).Y()).x().n()).i(), Integer.valueOf(i10)});
        } catch (com.google.protobuf.d0 unused) {
            throw n9.b.a("Failed to decode Query data for target %s", Integer.valueOf(i10));
        }
    }

    public final void A() {
        Q(new String[]{"data_migrations"}, new Runnable() { // from class: i9.y3
            @Override // java.lang.Runnable
            public final void run() {
                this.f12229a.f11930a.execSQL("CREATE TABLE data_migrations (migration_name TEXT, PRIMARY KEY (migration_name))");
            }
        });
    }

    public final void B() {
        Q(new String[]{"index_configuration", "index_state", "index_entries"}, new Runnable() { // from class: i9.s3
            @Override // java.lang.Runnable
            public final void run() {
                e4.q(this.f12159a);
            }
        });
    }

    public final void C() {
        Q(new String[]{"globals"}, new Runnable() { // from class: i9.z3
            @Override // java.lang.Runnable
            public final void run() {
                this.f12241a.f11930a.execSQL("CREATE TABLE globals (name TEXT PRIMARY KEY, value BLOB)");
            }
        });
    }

    public final void D() {
        Q(new String[]{"document_overlays"}, new Runnable() { // from class: i9.o3
            @Override // java.lang.Runnable
            public final void run() {
                e4.k(this.f12107a);
            }
        });
    }

    public final void E() {
        Q(new String[]{"mutation_queues", "mutations", "document_mutations"}, new Runnable() { // from class: i9.p3
            @Override // java.lang.Runnable
            public final void run() {
                e4.n(this.f12116a);
            }
        });
    }

    public final void F() {
        Q(new String[]{"remote_documents"}, new Runnable() { // from class: i9.b4
            @Override // java.lang.Runnable
            public final void run() {
                this.f11879a.f11930a.execSQL("CREATE TABLE remote_documents (path TEXT PRIMARY KEY, contents BLOB)");
            }
        });
    }

    public final void G() {
        Q(new String[]{"targets", "target_globals", "target_documents"}, new Runnable() { // from class: i9.t3
            @Override // java.lang.Runnable
            public final void run() {
                e4.j(this.f12165a);
            }
        });
    }

    public final void H() {
        Q(new String[]{"collection_parents"}, new Runnable() { // from class: i9.l3
            @Override // java.lang.Runnable
            public final void run() {
                this.f12076a.f11930a.execSQL("CREATE TABLE collection_parents (collection_id TEXT, parent TEXT, PRIMARY KEY(collection_id, parent))");
            }
        });
        final w0.a aVar = new w0.a();
        final SQLiteStatement sQLiteStatementCompileStatement = this.f11930a.compileStatement("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)");
        final n9.n nVar = new n9.n() { // from class: i9.v3
            @Override // n9.n
            public final void accept(Object obj) {
                e4.h(aVar, sQLiteStatementCompileStatement, (j9.t) obj);
            }
        };
        new e3.d(this.f11930a, "SELECT path FROM remote_documents").e(new n9.n() { // from class: i9.w3
            @Override // n9.n
            public final void accept(Object obj) {
                nVar.accept((j9.t) f.b(((Cursor) obj).getString(0)).w());
            }
        });
        new e3.d(this.f11930a, "SELECT path FROM document_mutations").e(new n9.n() { // from class: i9.x3
            @Override // n9.n
            public final void accept(Object obj) {
                nVar.accept((j9.t) f.b(((Cursor) obj).getString(0)).w());
            }
        });
    }

    public final void I() {
        new e3.d(this.f11930a, "SELECT target_id, target_proto FROM targets").e(new n9.n() { // from class: i9.a4
            @Override // n9.n
            public final void accept(Object obj) {
                e4.s(this.f11866a, (Cursor) obj);
            }
        });
    }

    public final void J() {
        if (X("targets")) {
            this.f11930a.execSQL("DROP TABLE targets");
        }
        if (X("target_globals")) {
            this.f11930a.execSQL("DROP TABLE target_globals");
        }
        if (X("target_documents")) {
            this.f11930a.execSQL("DROP TABLE target_documents");
        }
    }

    public final void K() {
        final boolean[] zArr;
        e3.d dVarB = new e3.d(this.f11930a, "SELECT path FROM remote_documents WHERE path_length IS NULL LIMIT ?").b(100);
        final SQLiteStatement sQLiteStatementCompileStatement = this.f11930a.compileStatement("UPDATE remote_documents SET path_length = ? WHERE path = ?");
        do {
            zArr = new boolean[]{false};
            dVarB.e(new n9.n() { // from class: i9.d4
                @Override // n9.n
                public final void accept(Object obj) {
                    e4.m(zArr, sQLiteStatementCompileStatement, (Cursor) obj);
                }
            });
        } while (zArr[0]);
    }

    public final void L() {
        this.f11930a.execSQL("UPDATE remote_documents SET read_time_seconds = 0, read_time_nanos = 0 WHERE read_time_seconds IS NULL");
    }

    public final void M() {
        final boolean[] zArr;
        Long l10 = (Long) new e3.d(this.f11930a, "SELECT highest_listen_sequence_number FROM target_globals LIMIT 1").d(new n9.t() { // from class: i9.q3
            @Override // n9.t
            public final Object apply(Object obj) {
                return Long.valueOf(((Cursor) obj).getLong(0));
            }
        });
        n9.b.d(l10 != null, "Missing highest sequence number", new Object[0]);
        final long jLongValue = l10.longValue();
        final SQLiteStatement sQLiteStatementCompileStatement = this.f11930a.compileStatement("INSERT INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)");
        e3.d dVarB = new e3.d(this.f11930a, "SELECT RD.path FROM remote_documents AS RD WHERE NOT EXISTS (SELECT TD.path FROM target_documents AS TD WHERE RD.path = TD.path AND TD.target_id = 0) LIMIT ?").b(100);
        do {
            zArr = new boolean[]{false};
            dVarB.e(new n9.n() { // from class: i9.r3
                @Override // n9.n
                public final void accept(Object obj) {
                    e4.l(zArr, sQLiteStatementCompileStatement, jLongValue, (Cursor) obj);
                }
            });
        } while (zArr[0]);
    }

    public final void N() {
        if (DatabaseUtils.queryNumEntries(this.f11930a, "target_globals") == 1) {
            return;
        }
        this.f11930a.execSQL("INSERT INTO target_globals (highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos) VALUES (?, ?, ?, ?)", new String[]{"0", "0", "0", "0"});
    }

    public List O(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.f11930a.rawQuery("PRAGMA table_info(" + str + ")", null);
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

    public final boolean P() {
        boolean zW = W("remote_documents", "read_time_seconds");
        boolean zW2 = W("remote_documents", "read_time_nanos");
        n9.b.d(zW == zW2, "Table contained just one of read_time_seconds or read_time_nanos", new Object[0]);
        return zW && zW2;
    }

    public final void Q(String[] strArr, Runnable runnable) {
        String str = "[" + TextUtils.join(", ", strArr) + "]";
        boolean z10 = false;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str2 = strArr[i10];
            boolean zX = X(str2);
            if (i10 == 0) {
                z10 = zX;
            } else if (zX != z10) {
                String str3 = "Expected all of " + str + " to either exist or not, but ";
                throw new IllegalStateException(z10 ? str3 + strArr[0] + " exists and " + str2 + " does not" : str3 + strArr[0] + " does not exist and " + str2 + " does");
            }
        }
        if (!z10) {
            runnable.run();
            return;
        }
        n9.v.a("SQLiteSchema", "Skipping migration because all of " + str + " already exist", new Object[0]);
    }

    public final void R() {
        new e3.d(this.f11930a, "SELECT uid, last_acknowledged_batch_id FROM mutation_queues").e(new n9.n() { // from class: i9.n3
            @Override // n9.n
            public final void accept(Object obj) {
                e4.i(this.f12092a, (Cursor) obj);
            }
        });
    }

    public final void S(String str, int i10) {
        SQLiteStatement sQLiteStatementCompileStatement = this.f11930a.compileStatement("DELETE FROM mutations WHERE uid = ? AND batch_id = ?");
        sQLiteStatementCompileStatement.bindString(1, str);
        sQLiteStatementCompileStatement.bindLong(2, i10);
        n9.b.d(sQLiteStatementCompileStatement.executeUpdateDelete() != 0, "Mutation batch (%s, %d) did not exist", str, Integer.valueOf(i10));
        this.f11930a.execSQL("DELETE FROM document_mutations WHERE uid = ? AND batch_id = ?", new Object[]{str, Integer.valueOf(i10)});
    }

    public final void T() {
        new e3.d(this.f11930a, "SELECT target_id, target_proto FROM targets").e(new n9.n() { // from class: i9.c4
            @Override // n9.n
            public final void accept(Object obj) {
                e4.g(this.f11888a, (Cursor) obj);
            }
        });
    }

    public void U(int i10) {
        V(i10, 18);
    }

    public void V(int i10, int i11) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i10 < 1 && i11 >= 1) {
            E();
            G();
            F();
        }
        if (i10 < 3 && i11 >= 3 && i10 != 0) {
            J();
            G();
        }
        if (i10 < 4 && i11 >= 4) {
            N();
            y();
        }
        if (i10 < 5 && i11 >= 5) {
            x();
        }
        if (i10 < 6 && i11 >= 6) {
            R();
        }
        if (i10 < 7 && i11 >= 7) {
            M();
        }
        if (i10 < 8 && i11 >= 8) {
            H();
        }
        if (i10 < 9 && i11 >= 9) {
            if (P()) {
                I();
            } else {
                w();
            }
        }
        if (i10 == 9 && i11 >= 10) {
            I();
        }
        if (i10 < 11 && i11 >= 11) {
            T();
        }
        if (i10 < 12 && i11 >= 12) {
            z();
        }
        if (i10 < 13 && i11 >= 13) {
            u();
            K();
        }
        if (i10 < 14 && i11 >= 14) {
            D();
            A();
            v(h1.f11953b);
        }
        if (i10 < 15 && i11 >= 15) {
            L();
        }
        if (i10 < 16 && i11 >= 16) {
            B();
        }
        if (i10 < 17 && i11 >= 17) {
            C();
        }
        if (i10 < 18 && i11 >= 18) {
            t();
        }
        n9.v.a("SQLiteSchema", "Migration from version %s to %s took %s milliseconds", Integer.valueOf(i10), Integer.valueOf(i11), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public final boolean W(String str, String str2) {
        return O(str).indexOf(str2) != -1;
    }

    public final boolean X(String str) {
        return !new e3.d(this.f11930a, "SELECT 1=1 FROM sqlite_master WHERE tbl_name = ?").b(str).f();
    }

    public final void t() {
        if (W("remote_documents", "document_type")) {
            return;
        }
        this.f11930a.execSQL("ALTER TABLE remote_documents ADD COLUMN document_type INTEGER");
    }

    public final void u() {
        if (W("remote_documents", "path_length")) {
            return;
        }
        this.f11930a.execSQL("ALTER TABLE remote_documents ADD COLUMN path_length INTEGER");
    }

    public final void v(String str) {
        this.f11930a.execSQL("INSERT OR IGNORE INTO data_migrations (migration_name) VALUES (?)", new String[]{str});
    }

    public final void w() {
        this.f11930a.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_seconds INTEGER");
        this.f11930a.execSQL("ALTER TABLE remote_documents ADD COLUMN read_time_nanos INTEGER");
    }

    public final void x() {
        if (W("target_documents", "sequence_number")) {
            return;
        }
        this.f11930a.execSQL("ALTER TABLE target_documents ADD COLUMN sequence_number INTEGER");
    }

    public final void y() {
        if (!W("target_globals", "target_count")) {
            this.f11930a.execSQL("ALTER TABLE target_globals ADD COLUMN target_count INTEGER");
        }
        long jQueryNumEntries = DatabaseUtils.queryNumEntries(this.f11930a, "targets");
        ContentValues contentValues = new ContentValues();
        contentValues.put("target_count", Long.valueOf(jQueryNumEntries));
        this.f11930a.update("target_globals", contentValues, null, null);
    }

    public final void z() {
        Q(new String[]{"bundles", "named_queries"}, new Runnable() { // from class: i9.m3
            @Override // java.lang.Runnable
            public final void run() {
                e4.f(this.f12086a);
            }
        });
    }
}

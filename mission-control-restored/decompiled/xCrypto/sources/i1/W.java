package i1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class W extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12200c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f12201d = 7;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f12202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f12204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f12205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f12206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f12207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f12208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List f12209l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12211b;

    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a aVar = new a() { // from class: i1.O
            @Override // i1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.e(sQLiteDatabase);
            }
        };
        f12202e = aVar;
        a aVar2 = new a() { // from class: i1.P
            @Override // i1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.A(sQLiteDatabase);
            }
        };
        f12203f = aVar2;
        a aVar3 = new a() { // from class: i1.Q
            @Override // i1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f12204g = aVar3;
        a aVar4 = new a() { // from class: i1.S
            @Override // i1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.E(sQLiteDatabase);
            }
        };
        f12205h = aVar4;
        a aVar5 = new a() { // from class: i1.T
            @Override // i1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.p(sQLiteDatabase);
            }
        };
        f12206i = aVar5;
        a aVar6 = new a() { // from class: i1.U
            @Override // i1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN product_id INTEGER");
            }
        };
        f12207j = aVar6;
        a aVar7 = new a() { // from class: i1.V
            @Override // i1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.f(sQLiteDatabase);
            }
        };
        f12208k = aVar7;
        f12209l = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public W(Context context, String str, int i4) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i4);
        this.f12211b = false;
        this.f12210a = i4;
    }

    public static /* synthetic */ void A(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void E(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    public static /* synthetic */ void e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN pseudonymous_id TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_clear_blob BLOB");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_encrypted_blob BLOB");
    }

    public static /* synthetic */ void p(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f12200c);
    }

    public final void G(SQLiteDatabase sQLiteDatabase) {
        if (this.f12211b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    public final void J(SQLiteDatabase sQLiteDatabase, int i4) {
        G(sQLiteDatabase);
        K(sQLiteDatabase, 0, i4);
    }

    public final void K(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        List list = f12209l;
        if (i5 <= list.size()) {
            while (i4 < i5) {
                ((a) f12209l.get(i4)).a(sQLiteDatabase);
                i4++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i4 + " to " + i5 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f12211b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        J(sQLiteDatabase, this.f12210a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        J(sQLiteDatabase, i5);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        G(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        G(sQLiteDatabase);
        K(sQLiteDatabase, i4, i5);
    }
}

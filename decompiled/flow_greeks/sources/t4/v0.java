package t4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20791c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f20792d = 7;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f20793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f20794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f20795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f20796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f20797i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f20798j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f20799k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List f20800l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20802b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a aVar = new a() { // from class: t4.o0
            @Override // t4.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                v0.b(sQLiteDatabase);
            }
        };
        f20793e = aVar;
        a aVar2 = new a() { // from class: t4.p0
            @Override // t4.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                v0.C(sQLiteDatabase);
            }
        };
        f20794f = aVar2;
        a aVar3 = new a() { // from class: t4.q0
            @Override // t4.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f20795g = aVar3;
        a aVar4 = new a() { // from class: t4.r0
            @Override // t4.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                v0.E(sQLiteDatabase);
            }
        };
        f20796h = aVar4;
        a aVar5 = new a() { // from class: t4.s0
            @Override // t4.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                v0.o(sQLiteDatabase);
            }
        };
        f20797i = aVar5;
        a aVar6 = new a() { // from class: t4.t0
            @Override // t4.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN product_id INTEGER");
            }
        };
        f20798j = aVar6;
        a aVar7 = new a() { // from class: t4.u0
            @Override // t4.v0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                v0.c(sQLiteDatabase);
            }
        };
        f20799k = aVar7;
        f20800l = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public v0(Context context, String str, int i10) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f20802b = false;
        this.f20801a = i10;
    }

    public static /* synthetic */ void C(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void E(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    public static /* synthetic */ void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN pseudonymous_id TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_clear_blob BLOB");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_encrypted_blob BLOB");
    }

    public static /* synthetic */ void o(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f20791c);
    }

    public final void G(SQLiteDatabase sQLiteDatabase) {
        if (this.f20802b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    public final void H(SQLiteDatabase sQLiteDatabase, int i10) {
        G(sQLiteDatabase);
        K(sQLiteDatabase, 0, i10);
    }

    public final void K(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        List list = f20800l;
        if (i11 <= list.size()) {
            while (i10 < i11) {
                ((a) f20800l.get(i10)).a(sQLiteDatabase);
                i10++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i10 + " to " + i11 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f20802b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        H(sQLiteDatabase, this.f20801a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        H(sQLiteDatabase, i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        G(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        G(sQLiteDatabase);
        K(sQLiteDatabase, i10, i11);
    }
}

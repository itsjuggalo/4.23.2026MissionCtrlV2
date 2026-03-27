package H1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class W extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3595c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f3596d = 7;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f3598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f3599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f3600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f3601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f3602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f3603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List f3604l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3606b;

    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a aVar = new a() { // from class: H1.O
            @Override // H1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.E(sQLiteDatabase);
            }
        };
        f3597e = aVar;
        a aVar2 = new a() { // from class: H1.P
            @Override // H1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.K(sQLiteDatabase);
            }
        };
        f3598f = aVar2;
        a aVar3 = new a() { // from class: H1.Q
            @Override // H1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f3599g = aVar3;
        a aVar4 = new a() { // from class: H1.S
            @Override // H1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.N(sQLiteDatabase);
            }
        };
        f3600h = aVar4;
        a aVar5 = new a() { // from class: H1.T
            @Override // H1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.O(sQLiteDatabase);
            }
        };
        f3601i = aVar5;
        a aVar6 = new a() { // from class: H1.U
            @Override // H1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN product_id INTEGER");
            }
        };
        f3602j = aVar6;
        a aVar7 = new a() { // from class: H1.V
            @Override // H1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.R(sQLiteDatabase);
            }
        };
        f3603k = aVar7;
        f3604l = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public W(Context context, String str, int i8) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i8);
        this.f3606b = false;
        this.f3605a = i8;
    }

    public static /* synthetic */ void E(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void K(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void N(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    public static /* synthetic */ void O(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f3595c);
    }

    public static /* synthetic */ void R(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN pseudonymous_id TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_clear_blob BLOB");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_encrypted_blob BLOB");
    }

    public final void D(SQLiteDatabase sQLiteDatabase) {
        if (this.f3606b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    public final void S(SQLiteDatabase sQLiteDatabase, int i8) {
        D(sQLiteDatabase);
        T(sQLiteDatabase, 0, i8);
    }

    public final void T(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
        List list = f3604l;
        if (i9 <= list.size()) {
            while (i8 < i9) {
                ((a) f3604l.get(i8)).a(sQLiteDatabase);
                i8++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i8 + " to " + i9 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f3606b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        S(sQLiteDatabase, this.f3605a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        S(sQLiteDatabase, i9);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        D(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
        D(sQLiteDatabase);
        T(sQLiteDatabase, i8, i9);
    }
}

package z1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class W extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25976c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f25977d = 7;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f25978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f25979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f25980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f25981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f25982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f25983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f25984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List f25985l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25987b;

    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a aVar = new a() { // from class: z1.O
            @Override // z1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.T(sQLiteDatabase);
            }
        };
        f25978e = aVar;
        a aVar2 = new a() { // from class: z1.P
            @Override // z1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.V(sQLiteDatabase);
            }
        };
        f25979f = aVar2;
        a aVar3 = new a() { // from class: z1.Q
            @Override // z1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f25980g = aVar3;
        a aVar4 = new a() { // from class: z1.S
            @Override // z1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.c0(sQLiteDatabase);
            }
        };
        f25981h = aVar4;
        a aVar5 = new a() { // from class: z1.T
            @Override // z1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.i0(sQLiteDatabase);
            }
        };
        f25982i = aVar5;
        a aVar6 = new a() { // from class: z1.U
            @Override // z1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN product_id INTEGER");
            }
        };
        f25983j = aVar6;
        a aVar7 = new a() { // from class: z1.V
            @Override // z1.W.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                W.z0(sQLiteDatabase);
            }
        };
        f25984k = aVar7;
        f25985l = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public W(Context context, String str, int i7) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i7);
        this.f25987b = false;
        this.f25986a = i7;
    }

    public static /* synthetic */ void T(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void V(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void c0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    public static /* synthetic */ void i0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f25976c);
    }

    public static /* synthetic */ void z0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN pseudonymous_id TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_clear_blob BLOB");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_encrypted_blob BLOB");
    }

    public final void A0(SQLiteDatabase sQLiteDatabase, int i7) {
        O(sQLiteDatabase);
        B0(sQLiteDatabase, 0, i7);
    }

    public final void B0(SQLiteDatabase sQLiteDatabase, int i7, int i8) {
        List list = f25985l;
        if (i8 <= list.size()) {
            while (i7 < i8) {
                ((a) f25985l.get(i7)).a(sQLiteDatabase);
                i7++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i7 + " to " + i8 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    public final void O(SQLiteDatabase sQLiteDatabase) {
        if (this.f25987b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f25987b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        A0(sQLiteDatabase, this.f25986a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i7, int i8) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        A0(sQLiteDatabase, i8);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        O(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i7, int i8) {
        O(sQLiteDatabase);
        B0(sQLiteDatabase, i7, i8);
    }
}

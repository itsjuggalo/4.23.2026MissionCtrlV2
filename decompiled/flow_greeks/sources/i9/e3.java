package i9;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import com.google.firebase.firestore.f;
import i9.e3;
import i9.q0;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e3 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f11909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f11910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k4 f11911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r1 f11912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k3 f11913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m2 f11914h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SQLiteTransactionListener f11915i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SQLiteDatabase f11916j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11917k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f11925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11926b;

        public /* synthetic */ c(Context context, p pVar, String str, a aVar) {
            this(context, pVar, str);
        }

        public final void b(SQLiteDatabase sQLiteDatabase) {
            if (this.f11926b) {
                return;
            }
            onConfigure(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f11926b = true;
            sQLiteDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            b(sQLiteDatabase);
            new e4(sQLiteDatabase, this.f11925a).U(0);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            b(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            b(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            b(sQLiteDatabase);
            new e4(sQLiteDatabase, this.f11925a).U(i10);
        }

        public c(Context context, p pVar, String str) {
            this(context, pVar, str, 18);
        }

        public c(Context context, p pVar, String str, int i10) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
            this.f11925a = pVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SQLiteDatabase f11927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SQLiteDatabase.CursorFactory f11929c;

        public d(SQLiteDatabase sQLiteDatabase, String str) {
            this.f11927a = sQLiteDatabase;
            this.f11928b = str;
        }

        public static /* synthetic */ Cursor a(Object[] objArr, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            e3.s(sQLiteQuery, objArr);
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public d b(final Object... objArr) {
            this.f11929c = new SQLiteDatabase.CursorFactory() { // from class: i9.f3
                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    return e3.d.a(objArr, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                }
            };
            return this;
        }

        public int c(n9.n nVar) {
            Cursor cursorG = g();
            try {
                if (!cursorG.moveToFirst()) {
                    cursorG.close();
                    return 0;
                }
                nVar.accept(cursorG);
                cursorG.close();
                return 1;
            } catch (Throwable th) {
                if (cursorG != null) {
                    try {
                        cursorG.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public Object d(n9.t tVar) {
            Cursor cursorG = g();
            try {
                if (!cursorG.moveToFirst()) {
                    cursorG.close();
                    return null;
                }
                Object objApply = tVar.apply(cursorG);
                cursorG.close();
                return objApply;
            } catch (Throwable th) {
                if (cursorG != null) {
                    try {
                        cursorG.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public int e(n9.n nVar) {
            Cursor cursorG = g();
            int i10 = 0;
            while (cursorG.moveToNext()) {
                try {
                    i10++;
                    nVar.accept(cursorG);
                } catch (Throwable th) {
                    if (cursorG != null) {
                        try {
                            cursorG.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            cursorG.close();
            return i10;
        }

        public boolean f() {
            Cursor cursorG = g();
            try {
                boolean z10 = !cursorG.moveToFirst();
                cursorG.close();
                return z10;
            } catch (Throwable th) {
                if (cursorG != null) {
                    try {
                        cursorG.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public final Cursor g() {
            SQLiteDatabase.CursorFactory cursorFactory = this.f11929c;
            return cursorFactory != null ? this.f11927a.rawQueryWithFactory(cursorFactory, this.f11928b, null, null) : this.f11927a.rawQuery(this.f11928b, null);
        }
    }

    public e3(Context context, String str, j9.f fVar, p pVar, q0.b bVar) {
        this(pVar, bVar, new c(context, pVar, u(str, fVar), (a) null));
    }

    public static void s(SQLiteProgram sQLiteProgram, Object[] objArr) {
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null) {
                sQLiteProgram.bindNull(i10 + 1);
            } else if (obj instanceof String) {
                sQLiteProgram.bindString(i10 + 1, (String) obj);
            } else if (obj instanceof Integer) {
                sQLiteProgram.bindLong(i10 + 1, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                sQLiteProgram.bindLong(i10 + 1, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                sQLiteProgram.bindDouble(i10 + 1, ((Double) obj).doubleValue());
            } else {
                if (!(obj instanceof byte[])) {
                    throw n9.b.a("Unknown argument %s of type %s", obj, obj.getClass());
                }
                sQLiteProgram.bindBlob(i10 + 1, (byte[]) obj);
            }
        }
    }

    public static void t(Context context, j9.f fVar, String str) {
        String path = context.getDatabasePath(u(str, fVar)).getPath();
        String str2 = path + "-wal";
        File file = new File(path);
        File file2 = new File(path + "-journal");
        File file3 = new File(str2);
        try {
            n9.s.a(file);
            n9.s.a(file2);
            n9.s.a(file3);
        } catch (IOException e10) {
            throw new com.google.firebase.firestore.f("Failed to clear persistence." + e10, f.a.UNKNOWN);
        }
    }

    public static String u(String str, j9.f fVar) {
        try {
            return "firestore." + URLEncoder.encode(str, "utf-8") + "." + URLEncoder.encode(fVar.i(), "utf-8") + "." + URLEncoder.encode(fVar.h(), "utf-8");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // i9.h1
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public m2 g() {
        return this.f11914h;
    }

    @Override // i9.h1
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public k4 i() {
        return this.f11911e;
    }

    public SQLiteStatement C(String str) {
        return this.f11916j.compileStatement(str);
    }

    public d D(String str) {
        return new d(this.f11916j, str);
    }

    @Override // i9.h1
    public i9.a a() {
        return this.f11912f;
    }

    @Override // i9.h1
    public i9.b b(e9.j jVar) {
        return new y1(this, this.f11910d, jVar);
    }

    @Override // i9.h1
    public g c() {
        return new z1(this);
    }

    @Override // i9.h1
    public m d(e9.j jVar) {
        return new i2(this, this.f11910d, jVar);
    }

    @Override // i9.h1
    public e1 e(e9.j jVar, m mVar) {
        return new x2(this, this.f11910d, jVar, mVar);
    }

    @Override // i9.h1
    public f1 f() {
        return new b3(this);
    }

    @Override // i9.h1
    public o1 h() {
        return this.f11913g;
    }

    @Override // i9.h1
    public boolean j() {
        return this.f11917k;
    }

    @Override // i9.h1
    public Object k(String str, n9.y yVar) {
        n9.v.a(h1.f11952a, "Starting transaction: %s", str);
        this.f11916j.beginTransactionWithListener(this.f11915i);
        try {
            Object obj = yVar.get();
            this.f11916j.setTransactionSuccessful();
            return obj;
        } finally {
            this.f11916j.endTransaction();
        }
    }

    @Override // i9.h1
    public void l(String str, Runnable runnable) {
        n9.v.a(h1.f11952a, "Starting transaction: %s", str);
        this.f11916j.beginTransactionWithListener(this.f11915i);
        try {
            runnable.run();
            this.f11916j.setTransactionSuccessful();
        } finally {
            this.f11916j.endTransaction();
        }
    }

    @Override // i9.h1
    public void m() {
        n9.b.d(this.f11917k, "SQLitePersistence shutdown without start!", new Object[0]);
        this.f11917k = false;
        this.f11916j.close();
        this.f11916j = null;
    }

    @Override // i9.h1
    public void n() {
        n9.b.d(!this.f11917k, "SQLitePersistence double-started!", new Object[0]);
        this.f11917k = true;
        try {
            this.f11916j = this.f11909c.getWritableDatabase();
            this.f11911e.w();
            this.f11914h.v(this.f11911e.r());
        } catch (SQLiteDatabaseLockedException e10) {
            throw new RuntimeException("Failed to gain exclusive lock to the Cloud Firestore client's offline persistence. This generally means you are using Cloud Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Cloud Firestore in your Application class. If you are intentionally using Cloud Firestore from multiple processes, you can only enable offline persistence (that is, call setPersistenceEnabled(true)) in one of them.", e10);
        }
    }

    public int v(SQLiteStatement sQLiteStatement, Object... objArr) {
        sQLiteStatement.clearBindings();
        s(sQLiteStatement, objArr);
        return sQLiteStatement.executeUpdateDelete();
    }

    public void w(String str, Object... objArr) {
        this.f11916j.execSQL(str, objArr);
    }

    public long x() {
        return y() * z();
    }

    public final long y() {
        return ((Long) D("PRAGMA page_count").d(new n9.t() { // from class: i9.c3
            @Override // n9.t
            public final Object apply(Object obj) {
                return Long.valueOf(((Cursor) obj).getLong(0));
            }
        })).longValue();
    }

    public final long z() {
        return ((Long) D("PRAGMA page_size").d(new n9.t() { // from class: i9.d3
            @Override // n9.t
            public final Object apply(Object obj) {
                return Long.valueOf(((Cursor) obj).getLong(0));
            }
        })).longValue();
    }

    public e3(p pVar, q0.b bVar, c cVar) {
        this.f11915i = new a();
        this.f11909c = cVar;
        this.f11910d = pVar;
        this.f11911e = new k4(this, pVar);
        this.f11912f = new r1(this, pVar);
        this.f11913g = new k3(this, pVar);
        this.f11914h = new m2(this, bVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e3 f11919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f11921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f11922d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11923e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Iterator f11924f;

        public b(e3 e3Var, String str, List list, String str2) {
            this.f11923e = 0;
            this.f11919a = e3Var;
            this.f11920b = str;
            this.f11922d = Collections.EMPTY_LIST;
            this.f11921c = str2;
            this.f11924f = list.iterator();
        }

        public void a() {
            this.f11923e++;
            Object[] objArrB = b();
            this.f11919a.w(this.f11920b + ((Object) n9.g0.u("?", objArrB.length, ", ")) + this.f11921c, objArrB);
        }

        public final Object[] b() {
            ArrayList arrayList = new ArrayList(this.f11922d);
            for (int i10 = 0; this.f11924f.hasNext() && i10 < 900 - this.f11922d.size(); i10++) {
                arrayList.add(this.f11924f.next());
            }
            return arrayList.toArray();
        }

        public int c() {
            return this.f11923e;
        }

        public boolean d() {
            return this.f11924f.hasNext();
        }

        public d e() {
            this.f11923e++;
            Object[] objArrB = b();
            return this.f11919a.D(this.f11920b + ((Object) n9.g0.u("?", objArrB.length, ", ")) + this.f11921c).b(objArrB);
        }

        public b(e3 e3Var, String str, List list, List list2, String str2) {
            this.f11923e = 0;
            this.f11919a = e3Var;
            this.f11920b = str;
            this.f11922d = list;
            this.f11921c = str2;
            this.f11924f = list2.iterator();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements SQLiteTransactionListener {
        public a() {
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onBegin() {
            e3.this.f11914h.g();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onCommit() {
            e3.this.f11914h.onTransactionCommitted();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onRollback() {
        }
    }
}

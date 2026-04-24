package F3;

import F3.C0494f1;
import F3.Q;
import K3.AbstractC0612b;
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
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: F3.f1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0494f1 extends AbstractC0502i0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f2144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0522p f2145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final L1 f2146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0528s0 f2147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0512l1 f2148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final N0 f2149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SQLiteTransactionListener f2150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SQLiteDatabase f2151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2152k;

    /* JADX INFO: renamed from: F3.f1$c */
    public static class c extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0522p f2160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2161b;

        public /* synthetic */ c(Context context, C0522p c0522p, String str, a aVar) {
            this(context, c0522p, str);
        }

        public final void h(SQLiteDatabase sQLiteDatabase) {
            if (this.f2161b) {
                return;
            }
            onConfigure(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f2161b = true;
            sQLiteDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            h(sQLiteDatabase);
            new F1(sQLiteDatabase, this.f2160a).m0(0);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i7, int i8) {
            h(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            h(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i7, int i8) {
            h(sQLiteDatabase);
            new F1(sQLiteDatabase, this.f2160a).m0(i7);
        }

        public c(Context context, C0522p c0522p, String str) {
            this(context, c0522p, str, 17);
        }

        public c(Context context, C0522p c0522p, String str, int i7) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i7);
            this.f2160a = c0522p;
        }
    }

    /* JADX INFO: renamed from: F3.f1$d */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SQLiteDatabase f2162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SQLiteDatabase.CursorFactory f2164c;

        public d(SQLiteDatabase sQLiteDatabase, String str) {
            this.f2162a = sQLiteDatabase;
            this.f2163b = str;
        }

        public static /* synthetic */ Cursor g(Object[] objArr, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            C0494f1.s(sQLiteQuery, objArr);
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public d b(final Object... objArr) {
            this.f2164c = new SQLiteDatabase.CursorFactory() { // from class: F3.g1
                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    return C0494f1.d.g(objArr, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                }
            };
            return this;
        }

        public int c(K3.n nVar) {
            Cursor cursorH = h();
            try {
                if (!cursorH.moveToFirst()) {
                    cursorH.close();
                    return 0;
                }
                nVar.accept(cursorH);
                cursorH.close();
                return 1;
            } catch (Throwable th) {
                if (cursorH != null) {
                    try {
                        cursorH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public Object d(K3.v vVar) {
            Cursor cursorH = h();
            try {
                if (!cursorH.moveToFirst()) {
                    cursorH.close();
                    return null;
                }
                Object objApply = vVar.apply(cursorH);
                cursorH.close();
                return objApply;
            } catch (Throwable th) {
                if (cursorH != null) {
                    try {
                        cursorH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public int e(K3.n nVar) {
            Cursor cursorH = h();
            int i7 = 0;
            while (cursorH.moveToNext()) {
                try {
                    i7++;
                    nVar.accept(cursorH);
                } catch (Throwable th) {
                    if (cursorH != null) {
                        try {
                            cursorH.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            cursorH.close();
            return i7;
        }

        public boolean f() {
            Cursor cursorH = h();
            try {
                boolean z7 = !cursorH.moveToFirst();
                cursorH.close();
                return z7;
            } catch (Throwable th) {
                if (cursorH != null) {
                    try {
                        cursorH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public final Cursor h() {
            SQLiteDatabase.CursorFactory cursorFactory = this.f2164c;
            return cursorFactory != null ? this.f2162a.rawQueryWithFactory(cursorFactory, this.f2163b, null, null) : this.f2162a.rawQuery(this.f2163b, null);
        }
    }

    public C0494f1(Context context, String str, G3.f fVar, C0522p c0522p, Q.b bVar) {
        this(c0522p, bVar, new c(context, c0522p, u(str, fVar), (a) null));
    }

    public static /* synthetic */ Long C(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    public static /* synthetic */ Long D(Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    public static void s(SQLiteProgram sQLiteProgram, Object[] objArr) {
        for (int i7 = 0; i7 < objArr.length; i7++) {
            Object obj = objArr[i7];
            if (obj == null) {
                sQLiteProgram.bindNull(i7 + 1);
            } else if (obj instanceof String) {
                sQLiteProgram.bindString(i7 + 1, (String) obj);
            } else if (obj instanceof Integer) {
                sQLiteProgram.bindLong(i7 + 1, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                sQLiteProgram.bindLong(i7 + 1, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                sQLiteProgram.bindDouble(i7 + 1, ((Double) obj).doubleValue());
            } else {
                if (!(obj instanceof byte[])) {
                    throw AbstractC0612b.a("Unknown argument %s of type %s", obj, obj.getClass());
                }
                sQLiteProgram.bindBlob(i7 + 1, (byte[]) obj);
            }
        }
    }

    public static void t(Context context, G3.f fVar, String str) throws com.google.firebase.firestore.f {
        String path = context.getDatabasePath(u(str, fVar)).getPath();
        String str2 = path + "-wal";
        File file = new File(path);
        File file2 = new File(path + "-journal");
        File file3 = new File(str2);
        try {
            K3.u.a(file);
            K3.u.a(file2);
            K3.u.a(file3);
        } catch (IOException e7) {
            throw new com.google.firebase.firestore.f("Failed to clear persistence." + e7, f.a.UNKNOWN);
        }
    }

    public static String u(String str, G3.f fVar) {
        try {
            return "firestore." + URLEncoder.encode(str, "utf-8") + "." + URLEncoder.encode(fVar.i(), "utf-8") + "." + URLEncoder.encode(fVar.h(), "utf-8");
        } catch (UnsupportedEncodingException e7) {
            throw new AssertionError(e7);
        }
    }

    @Override // F3.AbstractC0502i0
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public N0 g() {
        return this.f2149h;
    }

    @Override // F3.AbstractC0502i0
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public L1 i() {
        return this.f2146e;
    }

    public SQLiteStatement E(String str) {
        return this.f2151j.compileStatement(str);
    }

    public d F(String str) {
        return new d(this.f2151j, str);
    }

    @Override // F3.AbstractC0502i0
    public InterfaceC0477a a() {
        return this.f2147f;
    }

    @Override // F3.AbstractC0502i0
    public InterfaceC0480b b(B3.j jVar) {
        return new C0542z0(this, this.f2145d, jVar);
    }

    @Override // F3.AbstractC0502i0
    public InterfaceC0495g c() {
        return new A0(this);
    }

    @Override // F3.AbstractC0502i0
    public InterfaceC0513m d(B3.j jVar) {
        return new J0(this, this.f2145d, jVar);
    }

    @Override // F3.AbstractC0502i0
    public InterfaceC0493f0 e(B3.j jVar, InterfaceC0513m interfaceC0513m) {
        return new Y0(this, this.f2145d, jVar, interfaceC0513m);
    }

    @Override // F3.AbstractC0502i0
    public InterfaceC0496g0 f() {
        return new C0485c1(this);
    }

    @Override // F3.AbstractC0502i0
    public InterfaceC0523p0 h() {
        return this.f2148g;
    }

    @Override // F3.AbstractC0502i0
    public boolean j() {
        return this.f2152k;
    }

    @Override // F3.AbstractC0502i0
    public Object k(String str, K3.A a7) {
        K3.x.a(AbstractC0502i0.f2173a, "Starting transaction: %s", str);
        this.f2151j.beginTransactionWithListener(this.f2150i);
        try {
            Object obj = a7.get();
            this.f2151j.setTransactionSuccessful();
            return obj;
        } finally {
            this.f2151j.endTransaction();
        }
    }

    @Override // F3.AbstractC0502i0
    public void l(String str, Runnable runnable) {
        K3.x.a(AbstractC0502i0.f2173a, "Starting transaction: %s", str);
        this.f2151j.beginTransactionWithListener(this.f2150i);
        try {
            runnable.run();
            this.f2151j.setTransactionSuccessful();
        } finally {
            this.f2151j.endTransaction();
        }
    }

    @Override // F3.AbstractC0502i0
    public void m() {
        AbstractC0612b.d(this.f2152k, "SQLitePersistence shutdown without start!", new Object[0]);
        this.f2152k = false;
        this.f2151j.close();
        this.f2151j = null;
    }

    @Override // F3.AbstractC0502i0
    public void n() {
        AbstractC0612b.d(!this.f2152k, "SQLitePersistence double-started!", new Object[0]);
        this.f2152k = true;
        try {
            this.f2151j = this.f2144c.getWritableDatabase();
            this.f2146e.B();
            this.f2149h.z(this.f2146e.r());
        } catch (SQLiteDatabaseLockedException e7) {
            throw new RuntimeException("Failed to gain exclusive lock to the Cloud Firestore client's offline persistence. This generally means you are using Cloud Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Cloud Firestore in your Application class. If you are intentionally using Cloud Firestore from multiple processes, you can only enable offline persistence (that is, call setPersistenceEnabled(true)) in one of them.", e7);
        }
    }

    public int v(SQLiteStatement sQLiteStatement, Object... objArr) {
        sQLiteStatement.clearBindings();
        s(sQLiteStatement, objArr);
        return sQLiteStatement.executeUpdateDelete();
    }

    public void w(String str, Object... objArr) {
        this.f2151j.execSQL(str, objArr);
    }

    public long x() {
        return y() * z();
    }

    public final long y() {
        return ((Long) F("PRAGMA page_count").d(new K3.v() { // from class: F3.d1
            @Override // K3.v
            public final Object apply(Object obj) {
                return C0494f1.C((Cursor) obj);
            }
        })).longValue();
    }

    public final long z() {
        return ((Long) F("PRAGMA page_size").d(new K3.v() { // from class: F3.e1
            @Override // K3.v
            public final Object apply(Object obj) {
                return C0494f1.D((Cursor) obj);
            }
        })).longValue();
    }

    public C0494f1(C0522p c0522p, Q.b bVar, c cVar) {
        this.f2150i = new a();
        this.f2144c = cVar;
        this.f2145d = c0522p;
        this.f2146e = new L1(this, c0522p);
        this.f2147f = new C0528s0(this, c0522p);
        this.f2148g = new C0512l1(this, c0522p);
        this.f2149h = new N0(this, bVar);
    }

    /* JADX INFO: renamed from: F3.f1$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0494f1 f2154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f2156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f2157d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2158e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Iterator f2159f;

        public b(C0494f1 c0494f1, String str, List list, String str2) {
            this.f2158e = 0;
            this.f2154a = c0494f1;
            this.f2155b = str;
            this.f2157d = Collections.emptyList();
            this.f2156c = str2;
            this.f2159f = list.iterator();
        }

        public void a() {
            this.f2158e++;
            Object[] objArrB = b();
            this.f2154a.w(this.f2155b + ((Object) K3.I.B("?", objArrB.length, ", ")) + this.f2156c, objArrB);
        }

        public final Object[] b() {
            ArrayList arrayList = new ArrayList(this.f2157d);
            for (int i7 = 0; this.f2159f.hasNext() && i7 < 900 - this.f2157d.size(); i7++) {
                arrayList.add(this.f2159f.next());
            }
            return arrayList.toArray();
        }

        public int c() {
            return this.f2158e;
        }

        public boolean d() {
            return this.f2159f.hasNext();
        }

        public d e() {
            this.f2158e++;
            Object[] objArrB = b();
            return this.f2154a.F(this.f2155b + ((Object) K3.I.B("?", objArrB.length, ", ")) + this.f2156c).b(objArrB);
        }

        public b(C0494f1 c0494f1, String str, List list, List list2, String str2) {
            this.f2158e = 0;
            this.f2154a = c0494f1;
            this.f2155b = str;
            this.f2157d = list;
            this.f2156c = str2;
            this.f2159f = list2.iterator();
        }
    }

    /* JADX INFO: renamed from: F3.f1$a */
    public class a implements SQLiteTransactionListener {
        public a() {
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onBegin() {
            C0494f1.this.f2149h.f();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onCommit() {
            C0494f1.this.f2149h.c();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onRollback() {
        }
    }
}

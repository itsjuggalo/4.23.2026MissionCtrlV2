package P2;

import N1.C0091f0;
import a.AbstractC0284a;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteProgram;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import s1.C0994k;

/* JADX INFO: loaded from: classes.dex */
public final class P extends y5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final O f2396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Q3.h f2397d;
    public final U e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final A.c f2398f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0994k f2399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C0091f0 f2400l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final N f2401m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SQLiteDatabase f2402n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2403o;

    public P(Context context, String str, Q2.f fVar, Q3.h hVar, N2.A a6) {
        O o3 = new O(context, hVar, d0(str, fVar));
        this.f2401m = new N(this);
        this.f2396c = o3;
        this.f2397d = hVar;
        this.e = new U(this, hVar);
        this.f2398f = new A.c(19, this, hVar);
        this.f2399k = new C0994k(16, this, hVar);
        C0091f0 c0091f0 = new C0091f0();
        c0091f0.f1603a = -1L;
        c0091f0.f1604b = this;
        c0091f0.f1606d = new r(c0091f0, a6);
        this.f2400l = c0091f0;
    }

    public static void b0(SQLiteProgram sQLiteProgram, Object[] objArr) {
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                sQLiteProgram.bindNull(i + 1);
            } else if (obj instanceof String) {
                sQLiteProgram.bindString(i + 1, (String) obj);
            } else if (obj instanceof Integer) {
                sQLiteProgram.bindLong(i + 1, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                sQLiteProgram.bindLong(i + 1, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                sQLiteProgram.bindDouble(i + 1, ((Double) obj).doubleValue());
            } else {
                if (!(obj instanceof byte[])) {
                    D1.b.n("Unknown argument %s of type %s", obj, obj.getClass());
                    throw null;
                }
                sQLiteProgram.bindBlob(i + 1, (byte[]) obj);
            }
        }
    }

    public static void c0(Context context, Q2.f fVar, String str) {
        String path = context.getDatabasePath(d0(str, fVar)).getPath();
        String strJ = a3.d.j(path, "-journal");
        String strJ2 = a3.d.j(path, "-wal");
        File file = new File(path);
        File file2 = new File(strJ);
        File file3 = new File(strJ2);
        try {
            F1.h.q(file);
            F1.h.q(file2);
            F1.h.q(file3);
        } catch (IOException e) {
            throw new K2.K("Failed to clear persistence." + e, K2.J.UNKNOWN);
        }
    }

    public static String d0(String str, Q2.f fVar) {
        try {
            return "firestore." + URLEncoder.encode(str, "utf-8") + "." + URLEncoder.encode(fVar.f2669a, "utf-8") + "." + URLEncoder.encode(fVar.f2670b, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // y5.a
    public final D A() {
        return this.f2399k;
    }

    @Override // y5.a
    public final W B() {
        return this.e;
    }

    @Override // y5.a
    public final boolean C() {
        return this.f2403o;
    }

    @Override // y5.a
    public final Object P(String str, U2.p pVar) {
        AbstractC0284a.f(1, "a", "Starting transaction: %s", str);
        this.f2402n.beginTransactionWithListener(this.f2401m);
        try {
            Object obj = pVar.get();
            this.f2402n.setTransactionSuccessful();
            return obj;
        } finally {
            this.f2402n.endTransaction();
        }
    }

    @Override // y5.a
    public final void Q(String str, Runnable runnable) {
        AbstractC0284a.f(1, "a", "Starting transaction: %s", str);
        this.f2402n.beginTransactionWithListener(this.f2401m);
        try {
            runnable.run();
            this.f2402n.setTransactionSuccessful();
        } finally {
            this.f2402n.endTransaction();
        }
    }

    @Override // y5.a
    public final void S() {
        D1.b.w("SQLitePersistence shutdown without start!", this.f2403o, new Object[0]);
        this.f2403o = false;
        this.f2402n.close();
        this.f2402n = null;
    }

    @Override // y5.a
    public final void U() {
        boolean z6;
        D1.b.w("SQLitePersistence double-started!", !this.f2403o, new Object[0]);
        this.f2403o = true;
        try {
            this.f2402n = this.f2396c.getWritableDatabase();
            U u6 = this.e;
            C0994k c0994kF0 = u6.f2413a.f0("SELECT highest_target_id, highest_listen_sequence_number, last_remote_snapshot_version_seconds, last_remote_snapshot_version_nanos, target_count FROM target_globals LIMIT 1");
            I i = new I(u6, 2);
            Cursor cursorX = c0994kF0.X();
            try {
                if (cursorX.moveToFirst()) {
                    i.accept(cursorX);
                    cursorX.close();
                    z6 = true;
                } else {
                    cursorX.close();
                    z6 = false;
                }
                D1.b.w("Missing target_globals entry", z6, new Object[0]);
                long j4 = u6.f2416d;
                C0091f0 c0091f0 = this.f2400l;
                c0091f0.getClass();
                N2.A a6 = new N2.A();
                a6.f1899a = j4;
                c0091f0.f1605c = a6;
            } catch (Throwable th) {
                if (cursorX != null) {
                    try {
                        cursorX.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (SQLiteDatabaseLockedException e) {
            throw new RuntimeException("Failed to gain exclusive lock to the Cloud Firestore client's offline persistence. This generally means you are using Cloud Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Cloud Firestore in your Application class. If you are intentionally using Cloud Firestore from multiple processes, you can only enable offline persistence (that is, call setPersistenceEnabled(true)) in one of them.", e);
        }
    }

    public final void e0(String str, Object... objArr) {
        this.f2402n.execSQL(str, objArr);
    }

    public final C0994k f0(String str) {
        return new C0994k(15, this.f2402n, str);
    }

    @Override // y5.a
    public final A.c r() {
        return this.f2398f;
    }

    @Override // y5.a
    public final InterfaceC0203a t(L2.f fVar) {
        return new C0994k(this, this.f2397d, fVar);
    }

    @Override // y5.a
    public final InterfaceC0207e u(L2.f fVar) {
        return new K(this, this.f2397d, fVar);
    }

    @Override // y5.a
    public final InterfaceC0225x x(L2.f fVar, InterfaceC0207e interfaceC0207e) {
        Q3.h hVar = this.f2397d;
        N2.N n6 = new N2.N();
        n6.f1960b = this;
        n6.f1961c = hVar;
        String str = fVar.f1048a;
        if (str == null) {
            str = "";
        }
        n6.e = str;
        n6.f1963f = T2.K.f2929u;
        n6.f1962d = interfaceC0207e;
        return n6;
    }

    @Override // y5.a
    public final y y() {
        return new E.l(this, 14);
    }

    @Override // y5.a
    public final C z() {
        return this.f2400l;
    }
}

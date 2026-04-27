package y4;

import V4.j;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Boolean f25708n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f25709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f25710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f25712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f25713e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f25716h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SQLiteDatabase f25717i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f25720l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f25714f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f25715g = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25718j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25719k = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f25721m = 0;

    public i(Context context, String str, int i7, boolean z7, int i8) {
        this.f25713e = context;
        this.f25710b = str;
        this.f25709a = z7;
        this.f25711c = i7;
        this.f25712d = i8;
    }

    public static /* synthetic */ Cursor G(C c7, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        c7.a(sQLiteQuery);
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public static boolean i(Context context, String str, boolean z7) {
        try {
            String packageName = context.getPackageName();
            return (Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(128L)) : y(context, packageName, 128)).metaData.getBoolean(str, z7);
        } catch (Exception e7) {
            e7.printStackTrace();
            return false;
        }
    }

    public static boolean j(Context context) {
        return i(context, "com.tekartik.sqflite.wal_enabled", false);
    }

    public static void o(String str) {
        SQLiteDatabase.deleteDatabase(new File(str));
    }

    public static boolean x(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static ApplicationInfo y(Context context, String str, int i7) {
        return context.getPackageManager().getApplicationInfo(str, i7);
    }

    public String A() {
        return "[" + B() + "] ";
    }

    public String B() {
        Thread threadCurrentThread = Thread.currentThread();
        return this.f25711c + com.amazon.a.a.o.b.f.f9989a + threadCurrentThread.getName() + "(" + threadCurrentThread.getId() + ")";
    }

    public SQLiteDatabase C() {
        return this.f25717i;
    }

    public void D(Exception exc, A4.e eVar) {
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            eVar.b("sqlite_error", "open_failed " + this.f25710b, null);
            return;
        }
        if (exc instanceof SQLException) {
            eVar.b("sqlite_error", exc.getMessage(), A4.h.a(eVar));
        } else {
            eVar.b("sqlite_error", exc.getMessage(), A4.h.a(eVar));
        }
    }

    public void E(final A4.e eVar) {
        S(eVar, new Runnable() { // from class: y4.e
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f25702a.I(eVar);
            }
        });
    }

    public synchronized boolean F() {
        return this.f25718j > 0;
    }

    public final /* synthetic */ void H(A4.e eVar) {
        Boolean boolJ = eVar.j();
        boolean z7 = Boolean.TRUE.equals(boolJ) && eVar.g();
        if (z7) {
            int i7 = this.f25719k + 1;
            this.f25719k = i7;
            this.f25720l = Integer.valueOf(i7);
        }
        if (!w(eVar)) {
            if (z7) {
                this.f25720l = null;
            }
        } else if (z7) {
            HashMap map = new HashMap();
            map.put("transactionId", this.f25720l);
            eVar.a(map);
        } else {
            if (Boolean.FALSE.equals(boolJ)) {
                this.f25720l = null;
            }
            eVar.a(null);
        }
    }

    public void M() {
        if (f25708n == null) {
            Boolean boolValueOf = Boolean.valueOf(j(this.f25713e));
            f25708n = boolValueOf;
            if (boolValueOf.booleanValue() && q.c(this.f25712d)) {
                Log.d("Sqflite", A() + "[sqflite] WAL enabled");
            }
        }
        this.f25717i = SQLiteDatabase.openDatabase(this.f25710b, null, f25708n.booleanValue() ? 805306368 : 268435456);
    }

    public void N() {
        this.f25717i = SQLiteDatabase.openDatabase(this.f25710b, null, 1, new a());
    }

    public void O(final A4.e eVar) {
        S(eVar, new Runnable() { // from class: y4.c
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f25698a.J(eVar);
            }
        });
    }

    public void P(final A4.e eVar) {
        S(eVar, new Runnable() { // from class: y4.b
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f25696a.K(eVar);
            }
        });
    }

    public final void Q() {
        while (!this.f25714f.isEmpty() && this.f25720l == null) {
            ((A4.g) this.f25714f.get(0)).a();
            this.f25714f.remove(0);
        }
    }

    public void R(final A4.e eVar) {
        S(eVar, new Runnable() { // from class: y4.d
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f25700a.L(eVar);
            }
        });
    }

    public final void S(A4.e eVar, Runnable runnable) {
        Integer numF = eVar.f();
        Integer num = this.f25720l;
        if (num == null) {
            runnable.run();
            return;
        }
        if (numF == null || !(numF.equals(num) || numF.intValue() == -1)) {
            this.f25714f.add(new A4.g(eVar, runnable));
            return;
        }
        runnable.run();
        if (this.f25720l != null || this.f25714f.isEmpty()) {
            return;
        }
        this.f25716h.d(this, new Runnable() { // from class: y4.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f25707a.Q();
            }
        });
    }

    public void h(V4.i iVar, j.d dVar) {
        A4.c cVar;
        String strH;
        A4.d dVar2 = new A4.d(iVar, dVar);
        boolean zE = dVar2.e();
        boolean zL = dVar2.l();
        List list = (List) dVar2.c("operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            cVar = new A4.c((Map) it.next(), zE);
            strH = cVar.h();
            strH.hashCode();
            switch (strH) {
                case "execute":
                    if (!p(cVar)) {
                        if (!zL) {
                            cVar.r(dVar);
                            return;
                        }
                        cVar.s(arrayList);
                        break;
                    } else {
                        cVar.t(arrayList);
                        break;
                    }
                    break;
                case "insert":
                    if (!I(cVar)) {
                        if (!zL) {
                            cVar.r(dVar);
                            return;
                        }
                        cVar.s(arrayList);
                        break;
                    } else {
                        cVar.t(arrayList);
                        break;
                    }
                    break;
                case "update":
                    if (!L(cVar)) {
                        if (!zL) {
                            cVar.r(dVar);
                            return;
                        }
                        cVar.s(arrayList);
                        break;
                    } else {
                        cVar.t(arrayList);
                        break;
                    }
                    break;
                case "query":
                    if (!J(cVar)) {
                        if (!zL) {
                            cVar.r(dVar);
                            return;
                        }
                        cVar.s(arrayList);
                        break;
                    } else {
                        cVar.t(arrayList);
                        break;
                    }
                    break;
                default:
                    dVar.b("bad_param", "Batch method '" + strH + "' not supported", null);
                    return;
            }
        }
        if (zE) {
            dVar.a(null);
        } else {
            dVar.a(arrayList);
        }
    }

    public void k() {
        if (!this.f25715g.isEmpty() && q.b(this.f25712d)) {
            Log.d("Sqflite", A() + this.f25715g.size() + " cursor(s) are left opened");
        }
        this.f25717i.close();
    }

    public final void l(int i7) {
        s sVar = (s) this.f25715g.get(Integer.valueOf(i7));
        if (sVar != null) {
            m(sVar);
        }
    }

    public final void m(s sVar) {
        try {
            int i7 = sVar.f25748a;
            if (q.c(this.f25712d)) {
                Log.d("Sqflite", A() + "closing cursor " + i7);
            }
            this.f25715g.remove(Integer.valueOf(i7));
            sVar.f25750c.close();
        } catch (Exception unused) {
        }
    }

    public final Map n(Cursor cursor, Integer num) {
        HashMap map = null;
        int columnCount = 0;
        ArrayList arrayList = null;
        while (cursor.moveToNext()) {
            if (map == null) {
                ArrayList arrayList2 = new ArrayList();
                HashMap map2 = new HashMap();
                columnCount = cursor.getColumnCount();
                map2.put("columns", Arrays.asList(cursor.getColumnNames()));
                map2.put("rows", arrayList2);
                arrayList = arrayList2;
                map = map2;
            }
            arrayList.add(D.a(cursor, columnCount));
            if (num != null && arrayList.size() >= num.intValue()) {
                break;
            }
        }
        return map == null ? new HashMap() : map;
    }

    public final boolean p(A4.e eVar) {
        if (!w(eVar)) {
            return false;
        }
        eVar.a(null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d1  */
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean I(A4.e r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.i.I(A4.e):boolean");
    }

    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final boolean J(A4.e eVar) throws Throwable {
        Cursor cursorRawQueryWithFactory;
        Integer num = (Integer) eVar.c("cursorPageSize");
        final C cD = eVar.d();
        if (q.b(this.f25712d)) {
            Log.d("Sqflite", A() + cD);
        }
        s sVar = null;
        try {
            cursorRawQueryWithFactory = z().rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: y4.g
                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    return i.G(cD, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                }
            }, cD.c(), AbstractC2844a.f25695a, null);
            try {
                try {
                    Map mapN = n(cursorRawQueryWithFactory, num);
                    if (num != null && !cursorRawQueryWithFactory.isLast() && !cursorRawQueryWithFactory.isAfterLast()) {
                        int i7 = this.f25721m + 1;
                        this.f25721m = i7;
                        mapN.put("cursorId", Integer.valueOf(i7));
                        s sVar2 = new s(i7, num.intValue(), cursorRawQueryWithFactory);
                        try {
                            this.f25715g.put(Integer.valueOf(i7), sVar2);
                            sVar = sVar2;
                        } catch (Exception e7) {
                            e = e7;
                            sVar = sVar2;
                            D(e, eVar);
                            if (sVar != null) {
                                m(sVar);
                            }
                            if (sVar != null || cursorRawQueryWithFactory == null) {
                                return false;
                            }
                            cursorRawQueryWithFactory.close();
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            sVar = sVar2;
                            if (sVar == null && cursorRawQueryWithFactory != null) {
                                cursorRawQueryWithFactory.close();
                            }
                            throw th;
                        }
                    }
                    eVar.a(mapN);
                    if (sVar == null && cursorRawQueryWithFactory != null) {
                        cursorRawQueryWithFactory.close();
                    }
                    return true;
                } catch (Exception e8) {
                    e = e8;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e9) {
            e = e9;
            cursorRawQueryWithFactory = null;
        } catch (Throwable th3) {
            th = th3;
            cursorRawQueryWithFactory = null;
        }
    }

    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final boolean K(A4.e eVar) throws Throwable {
        boolean z7;
        Integer num = (Integer) eVar.c("cursorId");
        int iIntValue = num.intValue();
        boolean zEquals = Boolean.TRUE.equals(eVar.c("cancel"));
        if (q.c(this.f25712d)) {
            StringBuilder sb = new StringBuilder();
            sb.append(A());
            sb.append("cursor ");
            sb.append(iIntValue);
            sb.append(zEquals ? " cancel" : " next");
            Log.d("Sqflite", sb.toString());
        }
        s sVar = null;
        if (zEquals) {
            l(iIntValue);
            eVar.a(null);
            return true;
        }
        s sVar2 = (s) this.f25715g.get(num);
        int i7 = 0;
        try {
            try {
                if (sVar2 == null) {
                    throw new IllegalStateException("Cursor " + iIntValue + " not found");
                }
                Cursor cursor = sVar2.f25750c;
                Map mapN = n(cursor, Integer.valueOf(sVar2.f25749b));
                z7 = (cursor.isLast() || cursor.isAfterLast()) ? false : true;
                if (z7) {
                    try {
                        mapN.put("cursorId", num);
                    } catch (Exception e7) {
                        e = e7;
                        D(e, eVar);
                        if (sVar2 != null) {
                            m(sVar2);
                        } else {
                            sVar = sVar2;
                        }
                        if (!z7 && sVar != null) {
                            m(sVar);
                        }
                        return false;
                    }
                }
                eVar.a(mapN);
                if (!z7) {
                    m(sVar2);
                }
                return true;
            } catch (Throwable th) {
                th = th;
                i7 = iIntValue;
                if (i7 == 0 && sVar2 != null) {
                    m(sVar2);
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            z7 = false;
        } catch (Throwable th2) {
            th = th2;
            if (i7 == 0) {
                m(sVar2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final boolean L(A4.e eVar) throws Throwable {
        if (!w(eVar)) {
            return false;
        }
        Cursor cursor = null;
        if (eVar.e()) {
            eVar.a(null);
            return true;
        }
        try {
            try {
                Cursor cursorRawQuery = C().rawQuery("SELECT changes()", null);
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                            int i7 = cursorRawQuery.getInt(0);
                            if (q.b(this.f25712d)) {
                                Log.d("Sqflite", A() + "changed " + i7);
                            }
                            eVar.a(Integer.valueOf(i7));
                            cursorRawQuery.close();
                            return true;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        cursor = cursorRawQuery;
                        D(e, eVar);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                Log.e("Sqflite", A() + "fail to read changes for Update/Delete");
                eVar.a(null);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return true;
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void u(Boolean bool) {
        try {
            if (Boolean.TRUE.equals(bool)) {
                this.f25718j++;
            } else if (Boolean.FALSE.equals(bool)) {
                this.f25718j--;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void v(final A4.e eVar) {
        S(eVar, new Runnable() { // from class: y4.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f25704a.H(eVar);
            }
        });
    }

    public final boolean w(A4.e eVar) {
        C cD = eVar.d();
        if (q.b(this.f25712d)) {
            Log.d("Sqflite", A() + cD);
        }
        Boolean boolJ = eVar.j();
        try {
            C().execSQL(cD.c(), cD.d());
            u(boolJ);
            return true;
        } catch (Exception e7) {
            D(e7, eVar);
            return false;
        }
    }

    public SQLiteDatabase z() {
        return this.f25717i;
    }

    public class a implements DatabaseErrorHandler {
        public a() {
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        }
    }
}

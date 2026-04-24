package v4;

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
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Boolean f23835n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f23840e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f23843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SQLiteDatabase f23844i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f23847l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f23841f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f23842g = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f23845j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f23846k = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f23848m = 0;

    public k(Context context, String str, int i8, boolean z7, int i9) {
        this.f23840e = context;
        this.f23837b = str;
        this.f23836a = z7;
        this.f23838c = i8;
        this.f23839d = i9;
    }

    public static /* synthetic */ Cursor G(C2865E c2865e, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        c2865e.a(sQLiteQuery);
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public static boolean i(Context context, String str, boolean z7) {
        try {
            String packageName = context.getPackageName();
            return (Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(128L)) : y(context, packageName, 128)).metaData.getBoolean(str, z7);
        } catch (Exception e8) {
            e8.printStackTrace();
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

    public static ApplicationInfo y(Context context, String str, int i8) {
        return context.getPackageManager().getApplicationInfo(str, i8);
    }

    public String A() {
        return "[" + B() + "] ";
    }

    public String B() {
        Thread threadCurrentThread = Thread.currentThread();
        return this.f23838c + com.amazon.a.a.o.b.f.f14100a + threadCurrentThread.getName() + "(" + threadCurrentThread.getId() + ")";
    }

    public SQLiteDatabase C() {
        return this.f23844i;
    }

    public void D(Exception exc, x4.e eVar) {
        String message;
        Map mapA;
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            message = "open_failed " + this.f23837b;
            mapA = null;
        } else {
            boolean z7 = exc instanceof SQLException;
            message = exc.getMessage();
            mapA = x4.h.a(eVar);
        }
        eVar.error("sqlite_error", message, mapA);
    }

    public void E(final x4.e eVar) {
        S(eVar, new Runnable() { // from class: v4.g
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f23829a.I(eVar);
            }
        });
    }

    public synchronized boolean F() {
        return this.f23845j > 0;
    }

    public final /* synthetic */ void H(x4.e eVar) {
        Boolean boolH = eVar.h();
        boolean z7 = Boolean.TRUE.equals(boolH) && eVar.e();
        if (z7) {
            int i8 = this.f23846k + 1;
            this.f23846k = i8;
            this.f23847l = Integer.valueOf(i8);
        }
        if (!w(eVar)) {
            if (z7) {
                this.f23847l = null;
            }
        } else if (z7) {
            HashMap map = new HashMap();
            map.put("transactionId", this.f23847l);
            eVar.success(map);
        } else {
            if (Boolean.FALSE.equals(boolH)) {
                this.f23847l = null;
            }
            eVar.success(null);
        }
    }

    public void M() {
        if (f23835n == null) {
            Boolean boolValueOf = Boolean.valueOf(j(this.f23840e));
            f23835n = boolValueOf;
            if (boolValueOf.booleanValue() && s.c(this.f23839d)) {
                Log.d("Sqflite", A() + "[sqflite] WAL enabled");
            }
        }
        this.f23844i = SQLiteDatabase.openDatabase(this.f23837b, null, f23835n.booleanValue() ? 805306368 : 268435456);
    }

    public void N() {
        this.f23844i = SQLiteDatabase.openDatabase(this.f23837b, null, 1, new a());
    }

    public void O(final x4.e eVar) {
        S(eVar, new Runnable() { // from class: v4.e
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f23825a.J(eVar);
            }
        });
    }

    public void P(final x4.e eVar) {
        S(eVar, new Runnable() { // from class: v4.d
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f23823a.K(eVar);
            }
        });
    }

    public final void Q() {
        while (!this.f23841f.isEmpty() && this.f23847l == null) {
            ((x4.g) this.f23841f.get(0)).a();
            this.f23841f.remove(0);
        }
    }

    public void R(final x4.e eVar) {
        S(eVar, new Runnable() { // from class: v4.f
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f23827a.L(eVar);
            }
        });
    }

    public final void S(x4.e eVar, Runnable runnable) {
        Integer numD = eVar.d();
        Integer num = this.f23847l;
        if (num == null) {
            runnable.run();
            return;
        }
        if (numD == null || !(numD.equals(num) || numD.intValue() == -1)) {
            this.f23841f.add(new x4.g(eVar, runnable));
            return;
        }
        runnable.run();
        if (this.f23847l != null || this.f23841f.isEmpty()) {
            return;
        }
        this.f23843h.d(this, new Runnable() { // from class: v4.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f23834a.Q();
            }
        });
    }

    public void h(MethodCall methodCall, MethodChannel.Result result) {
        x4.c cVar;
        String strF;
        x4.d dVar = new x4.d(methodCall, result);
        boolean zC = dVar.c();
        boolean zJ = dVar.j();
        List list = (List) dVar.a("operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            cVar = new x4.c((Map) it.next(), zC);
            strF = cVar.f();
            strF.hashCode();
            switch (strF) {
                case "execute":
                    if (!p(cVar)) {
                        if (!zJ) {
                            cVar.p(result);
                            break;
                        }
                        cVar.q(arrayList);
                        break;
                    } else {
                        cVar.r(arrayList);
                        break;
                    }
                    break;
                case "insert":
                    if (!I(cVar)) {
                        if (!zJ) {
                            cVar.p(result);
                            break;
                        }
                        cVar.q(arrayList);
                        break;
                    } else {
                        cVar.r(arrayList);
                        break;
                    }
                    break;
                case "update":
                    if (!L(cVar)) {
                        if (!zJ) {
                            cVar.p(result);
                            break;
                        }
                        cVar.q(arrayList);
                        break;
                    } else {
                        cVar.r(arrayList);
                        break;
                    }
                    break;
                case "query":
                    if (!J(cVar)) {
                        if (!zJ) {
                            cVar.p(result);
                            break;
                        }
                        cVar.q(arrayList);
                        break;
                    } else {
                        cVar.r(arrayList);
                        break;
                    }
                    break;
                default:
                    result.error("bad_param", "Batch method '" + strF + "' not supported", null);
                    break;
            }
            return;
        }
        if (zC) {
            result.success(null);
        } else {
            result.success(arrayList);
        }
    }

    public void k() {
        if (!this.f23842g.isEmpty() && s.b(this.f23839d)) {
            Log.d("Sqflite", A() + this.f23842g.size() + " cursor(s) are left opened");
        }
        this.f23844i.close();
    }

    public final void l(int i8) {
        u uVar = (u) this.f23842g.get(Integer.valueOf(i8));
        if (uVar != null) {
            m(uVar);
        }
    }

    public final void m(u uVar) {
        try {
            int i8 = uVar.f23875a;
            if (s.c(this.f23839d)) {
                Log.d("Sqflite", A() + "closing cursor " + i8);
            }
            this.f23842g.remove(Integer.valueOf(i8));
            uVar.f23877c.close();
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
            arrayList.add(AbstractC2866F.a(cursor, columnCount));
            if (num != null && arrayList.size() >= num.intValue()) {
                break;
            }
        }
        return map == null ? new HashMap() : map;
    }

    public final boolean p(x4.e eVar) {
        if (!w(eVar)) {
            return false;
        }
        eVar.success(null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d1  */
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean I(x4.e r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.k.I(x4.e):boolean");
    }

    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final boolean J(x4.e eVar) throws Throwable {
        Cursor cursorRawQueryWithFactory;
        Integer num = (Integer) eVar.a("cursorPageSize");
        final C2865E c2865eB = eVar.b();
        if (s.b(this.f23839d)) {
            Log.d("Sqflite", A() + c2865eB);
        }
        u uVar = null;
        try {
            cursorRawQueryWithFactory = z().rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: v4.i
                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    return k.G(c2865eB, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                }
            }, c2865eB.c(), AbstractC2867a.f23822a, null);
            try {
                try {
                    Map mapN = n(cursorRawQueryWithFactory, num);
                    if (num != null && !cursorRawQueryWithFactory.isLast() && !cursorRawQueryWithFactory.isAfterLast()) {
                        int i8 = this.f23848m + 1;
                        this.f23848m = i8;
                        mapN.put("cursorId", Integer.valueOf(i8));
                        u uVar2 = new u(i8, num.intValue(), cursorRawQueryWithFactory);
                        try {
                            this.f23842g.put(Integer.valueOf(i8), uVar2);
                            uVar = uVar2;
                        } catch (Exception e8) {
                            e = e8;
                            uVar = uVar2;
                            D(e, eVar);
                            if (uVar != null) {
                                m(uVar);
                            }
                            if (uVar != null || cursorRawQueryWithFactory == null) {
                                return false;
                            }
                            cursorRawQueryWithFactory.close();
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            uVar = uVar2;
                            if (uVar == null && cursorRawQueryWithFactory != null) {
                                cursorRawQueryWithFactory.close();
                            }
                            throw th;
                        }
                    }
                    eVar.success(mapN);
                    if (uVar == null && cursorRawQueryWithFactory != null) {
                        cursorRawQueryWithFactory.close();
                    }
                    return true;
                } catch (Exception e9) {
                    e = e9;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
            cursorRawQueryWithFactory = null;
        } catch (Throwable th3) {
            th = th3;
            cursorRawQueryWithFactory = null;
        }
    }

    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final boolean K(x4.e eVar) throws Throwable {
        boolean z7;
        Integer num = (Integer) eVar.a("cursorId");
        int iIntValue = num.intValue();
        boolean zEquals = Boolean.TRUE.equals(eVar.a("cancel"));
        if (s.c(this.f23839d)) {
            StringBuilder sb = new StringBuilder();
            sb.append(A());
            sb.append("cursor ");
            sb.append(iIntValue);
            sb.append(zEquals ? " cancel" : " next");
            Log.d("Sqflite", sb.toString());
        }
        u uVar = null;
        if (zEquals) {
            l(iIntValue);
            eVar.success(null);
            return true;
        }
        u uVar2 = (u) this.f23842g.get(num);
        int i8 = 0;
        try {
            try {
                if (uVar2 == null) {
                    throw new IllegalStateException("Cursor " + iIntValue + " not found");
                }
                Cursor cursor = uVar2.f23877c;
                Map mapN = n(cursor, Integer.valueOf(uVar2.f23876b));
                z7 = (cursor.isLast() || cursor.isAfterLast()) ? false : true;
                if (z7) {
                    try {
                        mapN.put("cursorId", num);
                    } catch (Exception e8) {
                        e = e8;
                        D(e, eVar);
                        if (uVar2 != null) {
                            m(uVar2);
                        } else {
                            uVar = uVar2;
                        }
                        if (!z7 && uVar != null) {
                            m(uVar);
                        }
                        return false;
                    }
                }
                eVar.success(mapN);
                if (!z7) {
                    m(uVar2);
                }
                return true;
            } catch (Throwable th) {
                th = th;
                i8 = iIntValue;
                if (i8 == 0 && uVar2 != null) {
                    m(uVar2);
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            z7 = false;
        } catch (Throwable th2) {
            th = th2;
            if (i8 == 0) {
                m(uVar2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final boolean L(x4.e eVar) throws Throwable {
        if (!w(eVar)) {
            return false;
        }
        Cursor cursor = null;
        if (eVar.c()) {
            eVar.success(null);
            return true;
        }
        try {
            try {
                Cursor cursorRawQuery = C().rawQuery("SELECT changes()", null);
                if (cursorRawQuery != null) {
                    try {
                        if (cursorRawQuery.getCount() > 0 && cursorRawQuery.moveToFirst()) {
                            int i8 = cursorRawQuery.getInt(0);
                            if (s.b(this.f23839d)) {
                                Log.d("Sqflite", A() + "changed " + i8);
                            }
                            eVar.success(Integer.valueOf(i8));
                            cursorRawQuery.close();
                            return true;
                        }
                    } catch (Exception e8) {
                        e = e8;
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
                eVar.success(null);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return true;
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void u(Boolean bool) {
        try {
            if (Boolean.TRUE.equals(bool)) {
                this.f23845j++;
            } else if (Boolean.FALSE.equals(bool)) {
                this.f23845j--;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void v(final x4.e eVar) {
        S(eVar, new Runnable() { // from class: v4.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f23831a.H(eVar);
            }
        });
    }

    public final boolean w(x4.e eVar) {
        C2865E c2865eB = eVar.b();
        if (s.b(this.f23839d)) {
            Log.d("Sqflite", A() + c2865eB);
        }
        Boolean boolH = eVar.h();
        try {
            C().execSQL(c2865eB.c(), c2865eB.d());
            u(boolH);
            return true;
        } catch (Exception e8) {
            D(e8, eVar);
            return false;
        }
    }

    public SQLiteDatabase z() {
        return this.f23844i;
    }

    public class a implements DatabaseErrorHandler {
        public a() {
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        }
    }
}

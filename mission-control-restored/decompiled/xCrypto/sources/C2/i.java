package C2;

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
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Boolean f187n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f192e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f195h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SQLiteDatabase f196i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f199l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f193f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f194g = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f197j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f198k = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f200m = 0;

    public i(Context context, String str, int i4, boolean z4, int i5) {
        this.f192e = context;
        this.f189b = str;
        this.f188a = z4;
        this.f190c = i4;
        this.f191d = i5;
    }

    public static /* synthetic */ Cursor f(C c4, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        c4.a(sQLiteQuery);
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public static boolean i(Context context, String str, boolean z4) {
        try {
            String packageName = context.getPackageName();
            return (Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(128L)) : y(context, packageName, UserMetadata.MAX_ROLLOUT_ASSIGNMENTS)).metaData.getBoolean(str, z4);
        } catch (Exception e4) {
            e4.printStackTrace();
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

    public static ApplicationInfo y(Context context, String str, int i4) {
        return context.getPackageManager().getApplicationInfo(str, i4);
    }

    public String A() {
        return "[" + B() + "] ";
    }

    public String B() {
        Thread threadCurrentThread = Thread.currentThread();
        return this.f190c + com.amazon.a.a.o.b.f.f8804a + threadCurrentThread.getName() + "(" + E.d(threadCurrentThread) + ")";
    }

    public SQLiteDatabase C() {
        return this.f196i;
    }

    public void D(Exception exc, E2.e eVar) {
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            eVar.error("sqlite_error", "open_failed " + this.f189b, null);
            return;
        }
        if (exc instanceof SQLException) {
            eVar.error("sqlite_error", exc.getMessage(), E2.h.a(eVar));
        } else {
            eVar.error("sqlite_error", exc.getMessage(), E2.h.a(eVar));
        }
    }

    public void E(final E2.e eVar) {
        R(eVar, new Runnable() { // from class: C2.e
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f181a.H(eVar);
            }
        });
    }

    public synchronized boolean F() {
        return this.f197j > 0;
    }

    public final /* synthetic */ void G(E2.e eVar) {
        Boolean boolH = eVar.h();
        boolean z4 = Boolean.TRUE.equals(boolH) && eVar.e();
        if (z4) {
            int i4 = this.f198k + 1;
            this.f198k = i4;
            this.f199l = Integer.valueOf(i4);
        }
        if (!w(eVar)) {
            if (z4) {
                this.f199l = null;
            }
        } else if (z4) {
            HashMap map = new HashMap();
            map.put("transactionId", this.f199l);
            eVar.success(map);
        } else {
            if (Boolean.FALSE.equals(boolH)) {
                this.f199l = null;
            }
            eVar.success(null);
        }
    }

    public void L() {
        if (f187n == null) {
            Boolean boolValueOf = Boolean.valueOf(j(this.f192e));
            f187n = boolValueOf;
            if (boolValueOf.booleanValue() && q.c(this.f191d)) {
                Log.d("Sqflite", A() + "[sqflite] WAL enabled");
            }
        }
        this.f196i = SQLiteDatabase.openDatabase(this.f189b, null, f187n.booleanValue() ? 805306368 : 268435456);
    }

    public void M() {
        this.f196i = SQLiteDatabase.openDatabase(this.f189b, null, 1, new a());
    }

    public void N(final E2.e eVar) {
        R(eVar, new Runnable() { // from class: C2.c
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f177a.I(eVar);
            }
        });
    }

    public void O(final E2.e eVar) {
        R(eVar, new Runnable() { // from class: C2.b
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f175a.J(eVar);
            }
        });
    }

    public final void P() {
        while (!this.f193f.isEmpty() && this.f199l == null) {
            ((E2.g) this.f193f.get(0)).a();
            this.f193f.remove(0);
        }
    }

    public void Q(final E2.e eVar) {
        R(eVar, new Runnable() { // from class: C2.d
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f179a.K(eVar);
            }
        });
    }

    public final void R(E2.e eVar, Runnable runnable) {
        Integer numD = eVar.d();
        Integer num = this.f199l;
        if (num == null) {
            runnable.run();
            return;
        }
        if (numD == null || !(numD.equals(num) || numD.intValue() == -1)) {
            this.f193f.add(new E2.g(eVar, runnable));
            return;
        }
        runnable.run();
        if (this.f199l != null || this.f193f.isEmpty()) {
            return;
        }
        this.f195h.b(this, new Runnable() { // from class: C2.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f186a.P();
            }
        });
    }

    public void h(MethodCall methodCall, MethodChannel.Result result) {
        E2.c cVar;
        String strF;
        E2.d dVar = new E2.d(methodCall, result);
        boolean zC = dVar.c();
        boolean zJ = dVar.j();
        List list = (List) dVar.a("operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            cVar = new E2.c((Map) it.next(), zC);
            strF = cVar.f();
            strF.getClass();
            switch (strF) {
                case "execute":
                    if (!p(cVar)) {
                        if (!zJ) {
                            cVar.p(result);
                            return;
                        }
                        cVar.q(arrayList);
                        break;
                    } else {
                        cVar.r(arrayList);
                        break;
                    }
                    break;
                case "insert":
                    if (!H(cVar)) {
                        if (!zJ) {
                            cVar.p(result);
                            return;
                        }
                        cVar.q(arrayList);
                        break;
                    } else {
                        cVar.r(arrayList);
                        break;
                    }
                    break;
                case "update":
                    if (!K(cVar)) {
                        if (!zJ) {
                            cVar.p(result);
                            return;
                        }
                        cVar.q(arrayList);
                        break;
                    } else {
                        cVar.r(arrayList);
                        break;
                    }
                    break;
                case "query":
                    if (!I(cVar)) {
                        if (!zJ) {
                            cVar.p(result);
                            return;
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
                    return;
            }
        }
        if (zC) {
            result.success(null);
        } else {
            result.success(arrayList);
        }
    }

    public void k() {
        if (!this.f194g.isEmpty() && q.b(this.f191d)) {
            Log.d("Sqflite", A() + this.f194g.size() + " cursor(s) are left opened");
        }
        this.f196i.close();
    }

    public final void l(int i4) {
        s sVar = (s) this.f194g.get(Integer.valueOf(i4));
        if (sVar != null) {
            m(sVar);
        }
    }

    public final void m(s sVar) {
        try {
            int i4 = sVar.f227a;
            if (q.c(this.f191d)) {
                Log.d("Sqflite", A() + "closing cursor " + i4);
            }
            this.f194g.remove(Integer.valueOf(i4));
            sVar.f229c.close();
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
            arrayList.add(E.a(cursor, columnCount));
            if (num != null && arrayList.size() >= num.intValue()) {
                break;
            }
        }
        return map == null ? new HashMap() : map;
    }

    public final boolean p(E2.e eVar) {
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
    public final boolean H(E2.e r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C2.i.H(E2.e):boolean");
    }

    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final boolean I(E2.e eVar) throws Throwable {
        Cursor cursorRawQueryWithFactory;
        Integer num = (Integer) eVar.a("cursorPageSize");
        final C cB = eVar.b();
        if (q.b(this.f191d)) {
            Log.d("Sqflite", A() + cB);
        }
        s sVar = null;
        try {
            cursorRawQueryWithFactory = z().rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: C2.g
                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    return i.f(cB, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                }
            }, cB.c(), AbstractC0262a.f174a, null);
            try {
                try {
                    Map mapN = n(cursorRawQueryWithFactory, num);
                    if (num != null && !cursorRawQueryWithFactory.isLast() && !cursorRawQueryWithFactory.isAfterLast()) {
                        int i4 = this.f200m + 1;
                        this.f200m = i4;
                        mapN.put("cursorId", Integer.valueOf(i4));
                        s sVar2 = new s(i4, num.intValue(), cursorRawQueryWithFactory);
                        try {
                            this.f194g.put(Integer.valueOf(i4), sVar2);
                            sVar = sVar2;
                        } catch (Exception e4) {
                            e = e4;
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
                    eVar.success(mapN);
                    if (sVar == null && cursorRawQueryWithFactory != null) {
                        cursorRawQueryWithFactory.close();
                    }
                    return true;
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
            cursorRawQueryWithFactory = null;
        } catch (Throwable th3) {
            th = th3;
            cursorRawQueryWithFactory = null;
        }
    }

    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final boolean J(E2.e eVar) throws Throwable {
        boolean z4;
        Integer num = (Integer) eVar.a("cursorId");
        int iIntValue = num.intValue();
        boolean zEquals = Boolean.TRUE.equals(eVar.a("cancel"));
        if (q.c(this.f191d)) {
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
            eVar.success(null);
            return true;
        }
        s sVar2 = (s) this.f194g.get(num);
        int i4 = 0;
        try {
            try {
                if (sVar2 == null) {
                    throw new IllegalStateException("Cursor " + iIntValue + " not found");
                }
                Cursor cursor = sVar2.f229c;
                Map mapN = n(cursor, Integer.valueOf(sVar2.f228b));
                z4 = (cursor.isLast() || cursor.isAfterLast()) ? false : true;
                if (z4) {
                    try {
                        mapN.put("cursorId", num);
                    } catch (Exception e4) {
                        e = e4;
                        D(e, eVar);
                        if (sVar2 != null) {
                            m(sVar2);
                        } else {
                            sVar = sVar2;
                        }
                        if (!z4 && sVar != null) {
                            m(sVar);
                        }
                        return false;
                    }
                }
                eVar.success(mapN);
                if (!z4) {
                    m(sVar2);
                }
                return true;
            } catch (Throwable th) {
                th = th;
                i4 = iIntValue;
                if (i4 == 0 && sVar2 != null) {
                    m(sVar2);
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            z4 = false;
        } catch (Throwable th2) {
            th = th2;
            if (i4 == 0) {
                m(sVar2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final boolean K(E2.e eVar) throws Throwable {
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
                            int i4 = cursorRawQuery.getInt(0);
                            if (q.b(this.f191d)) {
                                Log.d("Sqflite", A() + "changed " + i4);
                            }
                            eVar.success(Integer.valueOf(i4));
                            cursorRawQuery.close();
                            return true;
                        }
                    } catch (Exception e4) {
                        e = e4;
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
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void u(Boolean bool) {
        try {
            if (Boolean.TRUE.equals(bool)) {
                this.f197j++;
            } else if (Boolean.FALSE.equals(bool)) {
                this.f197j--;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void v(final E2.e eVar) {
        R(eVar, new Runnable() { // from class: C2.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f183a.G(eVar);
            }
        });
    }

    public final boolean w(E2.e eVar) {
        C cB = eVar.b();
        if (q.b(this.f191d)) {
            Log.d("Sqflite", A() + cB);
        }
        Boolean boolH = eVar.h();
        try {
            C().execSQL(cB.c(), cB.d());
            u(boolH);
            return true;
        } catch (Exception e4) {
            D(e4, eVar);
            return false;
        }
    }

    public SQLiteDatabase z() {
        return this.f196i;
    }

    public class a implements DatabaseErrorHandler {
        public a() {
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        }
    }
}

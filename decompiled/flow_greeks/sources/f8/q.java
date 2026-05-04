package f8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.flutter.plugins.firebase.database.Constants;
import j8.c0;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import m8.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q implements l8.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f9398e = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f9399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q8.c f9400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9402d = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m8.d f9403a;

        public a(m8.d dVar) {
            this.f9403a = dVar;
        }

        @Override // m8.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(j8.l lVar, Void r22, Integer num) {
            return Integer.valueOf(this.f9403a.q(lVar) == null ? num.intValue() + 1 : num.intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m8.d f9405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f9406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j8.l f9407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ r8.n f9408d;

        public b(m8.d dVar, List list, j8.l lVar, r8.n nVar) {
            this.f9405a = dVar;
            this.f9406b = list;
            this.f9407c = lVar;
            this.f9408d = nVar;
        }

        @Override // m8.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(j8.l lVar, Void r42, Void r52) {
            if (this.f9405a.q(lVar) != null) {
                return null;
            }
            this.f9406b.add(new m8.g(this.f9407c.u(lVar), this.f9408d.O(lVar)));
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends SQLiteOpenHelper {
        public c(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        }

        public final void b(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
            sQLiteDatabase.execSQL("CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));");
            sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            m8.m.g(i11 == 2, "Why is onUpgrade() called with a different version?");
            if (i10 > 1) {
                throw new AssertionError("We don't handle upgrading to " + i11);
            }
            b(sQLiteDatabase, "serverCache");
            sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
            b(sQLiteDatabase, "complete");
            sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
        }
    }

    public q(Context context, j8.g gVar, String str) {
        try {
            String strEncode = URLEncoder.encode(str, "utf-8");
            this.f9400b = gVar.q("Persistence");
            this.f9399a = C(context, strEncode);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String E(String str) {
        m8.m.g(str.endsWith("/"), "Path keys must end with a '/'");
        return str.substring(0, str.length() - 1) + '0';
    }

    public static String F(j8.l lVar) {
        if (lVar.isEmpty()) {
            return "/";
        }
        return lVar.toString() + "/";
    }

    public static List M(byte[] bArr, int i10) {
        int length = ((bArr.length - 1) / i10) + 1;
        ArrayList arrayList = new ArrayList(length);
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * i10;
            int iMin = Math.min(i10, bArr.length - i12);
            byte[] bArr2 = new byte[iMin];
            System.arraycopy(bArr, i12, bArr2, 0, iMin);
            arrayList.add(bArr2);
        }
        return arrayList;
    }

    public static String w(j8.l lVar, String[] strArr) {
        int i10 = 0;
        m8.m.f(strArr.length >= lVar.size() + 1);
        StringBuilder sb2 = new StringBuilder("(");
        while (!lVar.isEmpty()) {
            sb2.append(Constants.PATH);
            sb2.append(" = ? OR ");
            strArr[i10] = F(lVar);
            lVar = lVar.L();
            i10++;
        }
        sb2.append(Constants.PATH);
        sb2.append(" = ?)");
        strArr[i10] = F(j8.l.G());
        return sb2.toString();
    }

    public final r8.n A(j8.l lVar) {
        long j10;
        r8.n nVarY;
        j8.l lVar2;
        int i10;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cursor cursorB = B(lVar, new String[]{Constants.PATH, "value"});
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        while (cursorB.moveToNext()) {
            try {
                arrayList.add(cursorB.getString(0));
                arrayList2.add(cursorB.getBlob(1));
            } catch (Throwable th) {
                cursorB.close();
                throw th;
            }
        }
        cursorB.close();
        long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis3;
        long jCurrentTimeMillis5 = System.currentTimeMillis();
        r8.n nVarY2 = r8.g.y();
        HashMap map = new HashMap();
        int i11 = 0;
        boolean z10 = false;
        while (i11 < arrayList2.size()) {
            long j11 = jCurrentTimeMillis;
            if (((String) arrayList.get(i11)).endsWith(".part-0000")) {
                j10 = jCurrentTimeMillis2;
                lVar2 = new j8.l(((String) arrayList.get(i11)).substring(0, r5.length() - 10));
                int iN = N(lVar2, arrayList, i11);
                if (this.f9400b.f()) {
                    i10 = iN;
                    this.f9400b.b("Loading split node with " + iN + " parts.", new Object[0]);
                } else {
                    i10 = iN;
                }
                int i12 = i11 + i10;
                nVarY = y(z(arrayList2.subList(i11, i12)));
                i11 = i12 - 1;
            } else {
                j10 = jCurrentTimeMillis2;
                nVarY = y((byte[]) arrayList2.get(i11));
                lVar2 = new j8.l((String) arrayList.get(i11));
            }
            if (lVar2.A() != null && lVar2.A().s()) {
                map.put(lVar2, nVarY);
            } else if (lVar2.y(lVar)) {
                m8.m.g(!z10, "Descendants of path must come after ancestors.");
                nVarY2 = nVarY.O(j8.l.R(lVar2, lVar));
            } else {
                if (!lVar.y(lVar2)) {
                    throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", lVar2, lVar));
                }
                nVarY2 = nVarY2.I(j8.l.R(lVar, lVar2), nVarY);
                z10 = true;
            }
            i11++;
            jCurrentTimeMillis = j11;
            jCurrentTimeMillis2 = j10;
        }
        long j12 = jCurrentTimeMillis;
        long j13 = jCurrentTimeMillis2;
        r8.n nVarI = nVarY2;
        for (Map.Entry entry : map.entrySet()) {
            nVarI = nVarI.I(j8.l.R(lVar, (j8.l) entry.getKey()), (r8.n) entry.getValue());
        }
        long jCurrentTimeMillis6 = System.currentTimeMillis() - jCurrentTimeMillis5;
        long jCurrentTimeMillis7 = System.currentTimeMillis() - j12;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", Integer.valueOf(arrayList2.size()), Integer.valueOf(m8.e.c(nVarI)), lVar, Long.valueOf(jCurrentTimeMillis7), Long.valueOf(j13), Long.valueOf(jCurrentTimeMillis4), Long.valueOf(jCurrentTimeMillis6)), new Object[0]);
        }
        return nVarI;
    }

    public final Cursor B(j8.l lVar, String[] strArr) {
        String strF = F(lVar);
        String strE = E(strF);
        String[] strArr2 = new String[lVar.size() + 3];
        String str = w(lVar, strArr2) + " OR (path > ? AND path < ?)";
        strArr2[lVar.size() + 1] = strF;
        strArr2[lVar.size() + 2] = strE;
        return this.f9399a.query("serverCache", strArr, str, strArr2, null, null, Constants.PATH);
    }

    public final SQLiteDatabase C(Context context, String str) {
        try {
            SQLiteDatabase writableDatabase = new c(context, str).getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        } catch (SQLiteException e10) {
            if (e10 instanceof SQLiteDatabaseLockedException) {
                throw new e8.d("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e10);
            }
            throw e10;
        }
    }

    public final String D(j8.l lVar, int i10) {
        return F(lVar) + String.format(Locale.US, ".part-%04d", Integer.valueOf(i10));
    }

    public final void G(j8.l lVar, j8.l lVar2, m8.d dVar, m8.d dVar2, l8.g gVar, List list) {
        if (dVar.getValue() == null) {
            for (Map.Entry entry : dVar.s()) {
                r8.b bVar = (r8.b) entry.getKey();
                G(lVar, lVar2.v(bVar), (m8.d) entry.getValue(), dVar2.r(bVar), gVar.a((r8.b) entry.getKey()), list);
            }
            return;
        }
        Integer num = (Integer) gVar.b(0, new a(dVar2));
        if (num.intValue() > 0) {
            j8.l lVarU = lVar.u(lVar2);
            if (this.f9400b.f()) {
                this.f9400b.b(String.format(Locale.US, "Need to rewrite %d nodes below path %s", num, lVarU), new Object[0]);
            }
            gVar.b(null, new b(dVar2, list, lVar2, A(lVarU)));
        }
    }

    public final int H(String str, j8.l lVar) {
        String strF = F(lVar);
        return this.f9399a.delete(str, "path >= ? AND path < ?", new String[]{strF, E(strF)});
    }

    public final int I(j8.l lVar, r8.n nVar) {
        long jB = m8.e.b(nVar);
        if (!(nVar instanceof r8.c) || jB <= 16384) {
            J(lVar, nVar);
            return 1;
        }
        int I = 0;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", lVar, Long.valueOf(jB), 16384), new Object[0]);
        }
        Iterator it = nVar.iterator();
        while (it.hasNext()) {
            r8.m mVar = (r8.m) it.next();
            I += I(lVar.v(mVar.c()), mVar.d());
        }
        if (!nVar.n().isEmpty()) {
            J(lVar.v(r8.b.m()), nVar.n());
            I++;
        }
        J(lVar, r8.g.y());
        return I + 1;
    }

    public final void J(j8.l lVar, r8.n nVar) {
        byte[] bArrL = L(nVar.N(true));
        if (bArrL.length < 262144) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.PATH, F(lVar));
            contentValues.put("value", bArrL);
            this.f9399a.insertWithOnConflict("serverCache", null, contentValues, 5);
            return;
        }
        List listM = M(bArrL, 262144);
        if (this.f9400b.f()) {
            this.f9400b.b("Saving huge leaf node with " + listM.size() + " parts.", new Object[0]);
        }
        for (int i10 = 0; i10 < listM.size(); i10++) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(Constants.PATH, D(lVar, i10));
            contentValues2.put("value", (byte[]) listM.get(i10));
            this.f9399a.insertWithOnConflict("serverCache", null, contentValues2, 5);
        }
    }

    public final void K(j8.l lVar, long j10, String str, byte[] bArr) {
        P();
        this.f9399a.delete("writes", "id = ?", new String[]{String.valueOf(j10)});
        if (bArr.length < 262144) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DiagnosticsEntry.ID_KEY, Long.valueOf(j10));
            contentValues.put(Constants.PATH, F(lVar));
            contentValues.put("type", str);
            contentValues.put("part", (Integer) null);
            contentValues.put("node", bArr);
            this.f9399a.insertWithOnConflict("writes", null, contentValues, 5);
            return;
        }
        List listM = M(bArr, 262144);
        for (int i10 = 0; i10 < listM.size(); i10++) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(DiagnosticsEntry.ID_KEY, Long.valueOf(j10));
            contentValues2.put(Constants.PATH, F(lVar));
            contentValues2.put("type", str);
            contentValues2.put("part", Integer.valueOf(i10));
            contentValues2.put("node", (byte[]) listM.get(i10));
            this.f9399a.insertWithOnConflict("writes", null, contentValues2, 5);
        }
    }

    public final byte[] L(Object obj) {
        try {
            return t8.b.d(obj).getBytes(f9398e);
        } catch (IOException e10) {
            throw new RuntimeException("Could not serialize leaf node", e10);
        }
    }

    public final int N(j8.l lVar, List list, int i10) {
        int i11 = i10 + 1;
        String strF = F(lVar);
        if (!((String) list.get(i10)).startsWith(strF)) {
            throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
        }
        while (i11 < list.size() && ((String) list.get(i11)).equals(D(lVar, i11 - i10))) {
            i11++;
        }
        if (i11 < list.size()) {
            if (((String) list.get(i11)).startsWith(strF + ".part-")) {
                throw new IllegalStateException("Run did not finish with all parts");
            }
        }
        return i11 - i10;
    }

    public final void O(j8.l lVar, r8.n nVar, boolean z10) {
        int I;
        int iH;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z10) {
            Iterator it = nVar.iterator();
            int I2 = 0;
            int iH2 = 0;
            while (it.hasNext()) {
                r8.m mVar = (r8.m) it.next();
                iH2 += H("serverCache", lVar.v(mVar.c()));
                I2 += I(lVar.v(mVar.c()), mVar.d());
            }
            I = I2;
            iH = iH2;
        } else {
            iH = H("serverCache", lVar);
            I = I(lVar, nVar);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", Integer.valueOf(I), Integer.valueOf(iH), lVar.toString(), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    public final void P() {
        m8.m.g(this.f9401c, "Transaction expected to already be in progress.");
    }

    @Override // l8.f
    public void a() {
        P();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iDelete = this.f9399a.delete("writes", null, null);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Deleted %d (all) write(s) in %dms", Integer.valueOf(iDelete), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // l8.f
    public void b(long j10) {
        P();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iDelete = this.f9399a.delete("writes", "id = ?", new String[]{String.valueOf(j10)});
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Deleted %d write(s) with writeId %d in %dms", Integer.valueOf(iDelete), Long.valueOf(j10), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // l8.f
    public void c(j8.l lVar, r8.n nVar, long j10) {
        P();
        long jCurrentTimeMillis = System.currentTimeMillis();
        K(lVar, j10, "o", L(nVar.N(true)));
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Persisted user overwrite in %dms", Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // l8.f
    public List d() {
        byte[] bArrZ;
        c0 c0Var;
        String[] strArr = {DiagnosticsEntry.ID_KEY, Constants.PATH, "type", "part", "node"};
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cursor cursorQuery = this.f9399a.query("writes", strArr, null, null, null, null, "id, part");
        ArrayList arrayList = new ArrayList();
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    long j10 = cursorQuery.getLong(0);
                    j8.l lVar = new j8.l(cursorQuery.getString(1));
                    String string = cursorQuery.getString(2);
                    if (cursorQuery.isNull(3)) {
                        bArrZ = cursorQuery.getBlob(4);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        do {
                            arrayList2.add(cursorQuery.getBlob(4));
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                        } while (cursorQuery.getLong(0) == j10);
                        cursorQuery.moveToPrevious();
                        bArrZ = z(arrayList2);
                    }
                    Object objB = t8.b.b(new String(bArrZ, f9398e));
                    if ("o".equals(string)) {
                        c0Var = new c0(j10, lVar, r8.o.a(objB), true);
                    } else {
                        if (!"m".equals(string)) {
                            throw new IllegalStateException("Got invalid write type: " + string);
                        }
                        c0Var = new c0(j10, lVar, j8.b.s((Map) objB));
                    }
                    arrayList.add(c0Var);
                } catch (IOException e10) {
                    throw new RuntimeException("Failed to load writes", e10);
                }
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Loaded %d writes in %dms", Integer.valueOf(arrayList.size()), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
        cursorQuery.close();
        return arrayList;
    }

    @Override // l8.f
    public void e(j8.l lVar, j8.b bVar, long j10) {
        P();
        long jCurrentTimeMillis = System.currentTimeMillis();
        K(lVar, j10, "m", L(bVar.w(true)));
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Persisted user merge in %dms", Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // l8.f
    public void f() {
        m8.m.g(!this.f9401c, "runInTransaction called when an existing transaction is already in progress.");
        if (this.f9400b.f()) {
            this.f9400b.b("Starting transaction.", new Object[0]);
        }
        this.f9399a.beginTransaction();
        this.f9401c = true;
        this.f9402d = System.currentTimeMillis();
    }

    @Override // l8.f
    public void g(long j10) {
        P();
        String strValueOf = String.valueOf(j10);
        this.f9399a.delete("trackedQueries", "id = ?", new String[]{strValueOf});
        this.f9399a.delete("trackedKeys", "id = ?", new String[]{strValueOf});
    }

    @Override // l8.f
    public Set h(long j10) {
        return m(Collections.singleton(Long.valueOf(j10)));
    }

    @Override // l8.f
    public void i(l8.h hVar) {
        P();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DiagnosticsEntry.ID_KEY, Long.valueOf(hVar.f15554a));
        contentValues.put(Constants.PATH, F(hVar.f15555b.e()));
        contentValues.put("queryParams", hVar.f15555b.d().y());
        contentValues.put("lastUse", Long.valueOf(hVar.f15556c));
        contentValues.put("complete", Boolean.valueOf(hVar.f15557d));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(hVar.f15558e));
        this.f9399a.insertWithOnConflict("trackedQueries", null, contentValues, 5);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Saved new tracked query in %dms", Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // l8.f
    public void j(j8.l lVar, r8.n nVar) {
        P();
        O(lVar, nVar, false);
    }

    @Override // l8.f
    public void k(j8.l lVar, l8.g gVar) {
        q qVar;
        int size;
        int size2;
        if (gVar.e()) {
            P();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Cursor cursorB = B(lVar, new String[]{"rowid", Constants.PATH});
            m8.d dVar = new m8.d(null);
            m8.d dVar2 = new m8.d(null);
            while (cursorB.moveToNext()) {
                long j10 = cursorB.getLong(0);
                j8.l lVar2 = new j8.l(cursorB.getString(1));
                if (lVar.y(lVar2)) {
                    j8.l lVarR = j8.l.R(lVar, lVar2);
                    if (gVar.g(lVarR)) {
                        dVar = dVar.A(lVarR, Long.valueOf(j10));
                    } else if (gVar.f(lVarR)) {
                        dVar2 = dVar2.A(lVarR, Long.valueOf(j10));
                    } else {
                        this.f9400b.i("We are pruning at " + lVar + " and have data at " + lVar2 + " that isn't marked for pruning or keeping. Ignoring.");
                    }
                } else {
                    this.f9400b.i("We are pruning at " + lVar + " but we have data stored higher up at " + lVar2 + ". Ignoring.");
                }
            }
            if (dVar.isEmpty()) {
                qVar = this;
                size = 0;
                size2 = 0;
            } else {
                ArrayList<m8.g> arrayList = new ArrayList();
                qVar = this;
                qVar.G(lVar, j8.l.G(), dVar, dVar2, gVar, arrayList);
                Collection collectionL = dVar.L();
                qVar.f9399a.delete("serverCache", "rowid IN (" + x(collectionL) + ")", null);
                for (m8.g gVar2 : arrayList) {
                    I(lVar.u((j8.l) gVar2.a()), (r8.n) gVar2.b());
                }
                size = collectionL.size();
                size2 = arrayList.size();
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (qVar.f9400b.f()) {
                qVar.f9400b.b(String.format(Locale.US, "Pruned %d rows with %d nodes resaved in %dms", Integer.valueOf(size), Integer.valueOf(size2), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
            }
        }
    }

    @Override // l8.f
    public void l() {
        this.f9399a.setTransactionSuccessful();
    }

    @Override // l8.f
    public Set m(Set set) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cursor cursorQuery = this.f9399a.query(true, "trackedKeys", new String[]{"key"}, "id IN (" + x(set) + ")", null, null, null, null, null);
        HashSet hashSet = new HashSet();
        while (cursorQuery.moveToNext()) {
            try {
                hashSet.add(r8.b.h(cursorQuery.getString(0)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Loaded %d tracked queries keys for tracked queries %s in %dms", Integer.valueOf(hashSet.size()), set.toString(), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
        cursorQuery.close();
        return hashSet;
    }

    @Override // l8.f
    public void n() {
        this.f9399a.endTransaction();
        this.f9401c = false;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f9402d;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Transaction completed. Elapsed: %dms", Long.valueOf(jCurrentTimeMillis)), new Object[0]);
        }
    }

    @Override // l8.f
    public void o(long j10) {
        P();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.FALSE);
        contentValues.put("lastUse", Long.valueOf(j10));
        this.f9399a.updateWithOnConflict("trackedQueries", contentValues, "active = 1", new String[0], 5);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Reset active tracked queries in %dms", Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // l8.f
    public void p(long j10, Set set) {
        P();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f9399a.delete("trackedKeys", "id = ?", new String[]{String.valueOf(j10)});
        Iterator it = set.iterator();
        while (it.hasNext()) {
            r8.b bVar = (r8.b) it.next();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DiagnosticsEntry.ID_KEY, Long.valueOf(j10));
            contentValues.put("key", bVar.b());
            this.f9399a.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Set %d tracked query keys for tracked query %d in %dms", Integer.valueOf(set.size()), Long.valueOf(j10), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // l8.f
    public long q() {
        Cursor cursorRawQuery = this.f9399a.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", "value", Constants.PATH, "serverCache"), null);
        try {
            if (cursorRawQuery.moveToFirst()) {
                return cursorRawQuery.getLong(0);
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            cursorRawQuery.close();
        }
    }

    @Override // l8.f
    public void r(j8.l lVar, j8.b bVar) {
        P();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator it = bVar.iterator();
        int iH = 0;
        int I = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iH += H("serverCache", lVar.u((j8.l) entry.getKey()));
            I += I(lVar.u((j8.l) entry.getKey()), (r8.n) entry.getValue());
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", Integer.valueOf(I), Integer.valueOf(iH), lVar.toString(), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // l8.f
    public List s() {
        String[] strArr = {DiagnosticsEntry.ID_KEY, Constants.PATH, "queryParams", "lastUse", "complete", AppMeasurementSdk.ConditionalUserProperty.ACTIVE};
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cursor cursorQuery = this.f9399a.query("trackedQueries", strArr, null, null, null, null, DiagnosticsEntry.ID_KEY);
        ArrayList arrayList = new ArrayList();
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    arrayList.add(new l8.h(cursorQuery.getLong(0), o8.i.b(new j8.l(cursorQuery.getString(1)), t8.b.a(cursorQuery.getString(2))), cursorQuery.getLong(3), cursorQuery.getInt(4) != 0, cursorQuery.getInt(5) != 0));
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Loaded %d tracked queries in %dms", Integer.valueOf(arrayList.size()), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
        cursorQuery.close();
        return arrayList;
    }

    @Override // l8.f
    public r8.n t(j8.l lVar) {
        return A(lVar);
    }

    @Override // l8.f
    public void u(long j10, Set set, Set set2) {
        P();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strValueOf = String.valueOf(j10);
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            this.f9399a.delete("trackedKeys", "id = ? AND key = ?", new String[]{strValueOf, ((r8.b) it.next()).b()});
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            r8.b bVar = (r8.b) it2.next();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DiagnosticsEntry.ID_KEY, Long.valueOf(j10));
            contentValues.put("key", bVar.b());
            this.f9399a.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.f9400b.f()) {
            this.f9400b.b(String.format(Locale.US, "Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", Integer.valueOf(set.size()), Integer.valueOf(set2.size()), Long.valueOf(j10), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // l8.f
    public void v(j8.l lVar, r8.n nVar) {
        P();
        O(lVar, nVar, true);
    }

    public final String x(Collection collection) {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = collection.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            long jLongValue = ((Long) it.next()).longValue();
            if (!z10) {
                sb2.append(com.amazon.a.a.o.b.f.f4598a);
            }
            sb2.append(jLongValue);
            z10 = false;
        }
        return sb2.toString();
    }

    public final r8.n y(byte[] bArr) {
        try {
            return r8.o.a(t8.b.b(new String(bArr, f9398e)));
        } catch (IOException e10) {
            throw new RuntimeException("Could not deserialize node: " + new String(bArr, f9398e), e10);
        }
    }

    public final byte[] z(List list) {
        Iterator it = list.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((byte[]) it.next()).length;
        }
        byte[] bArr = new byte[length];
        Iterator it2 = list.iterator();
        int length2 = 0;
        while (it2.hasNext()) {
            byte[] bArr2 = (byte[]) it2.next();
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }
}

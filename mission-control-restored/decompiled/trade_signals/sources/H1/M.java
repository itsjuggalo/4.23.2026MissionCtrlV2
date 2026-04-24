package H1;

import C1.a;
import C1.c;
import I1.b;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import io.flutter.plugins.firebase.database.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import n5.InterfaceC2426a;
import w1.C2900c;
import w1.EnumC2903f;
import z1.i;

/* JADX INFO: loaded from: classes.dex */
public class M implements InterfaceC0586d, I1.b, InterfaceC0585c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C2900c f3582f = C2900c.b("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W f3583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final J1.a f3584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final J1.a f3585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0587e f3586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2426a f3587e;

    public interface b {
        Object apply(Object obj);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3589b;

        public c(String str, String str2) {
            this.f3588a = str;
            this.f3589b = str2;
        }
    }

    public interface d {
        Object a();
    }

    public M(J1.a aVar, J1.a aVar2, AbstractC0587e abstractC0587e, W w8, InterfaceC2426a interfaceC2426a) {
        this.f3583a = w8;
        this.f3584b = aVar;
        this.f3585c = aVar2;
        this.f3586d = abstractC0587e;
        this.f3587e = interfaceC2426a;
    }

    public static /* synthetic */ Object O0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Object P0(Throwable th) {
        throw new I1.a("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ SQLiteDatabase Q0(Throwable th) {
        throw new I1.a("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Long R0(Cursor cursor) {
        return Long.valueOf(cursor.moveToNext() ? cursor.getLong(0) : 0L);
    }

    public static /* synthetic */ C1.f S0(long j8, Cursor cursor) {
        cursor.moveToNext();
        return C1.f.c().c(cursor.getLong(0)).b(j8).a();
    }

    public static /* synthetic */ C1.f T0(final long j8, SQLiteDatabase sQLiteDatabase) {
        return (C1.f) t1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: H1.D
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.S0(j8, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ Long U0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    public static /* synthetic */ List W0(SQLiteDatabase sQLiteDatabase) {
        return (List) t1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: H1.K
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.X0((Cursor) obj);
            }
        });
    }

    public static /* synthetic */ List X0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(z1.p.a().b(cursor.getString(1)).d(K1.a.b(cursor.getInt(2))).c(n1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ Object c1(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j8 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j8));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j8), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    public static /* synthetic */ byte[] e1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            byte[] bArr2 = (byte[]) arrayList.get(i8);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ Boolean h1(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    public static /* synthetic */ Object i1(String str, c.b bVar, long j8, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) t1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.d())}), new b() { // from class: H1.y
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.h1((Cursor) obj);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j8 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.d())});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(bVar.d()));
            contentValues.put("events_dropped_count", Long.valueOf(j8));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    public static /* synthetic */ Object j1(long j8, z1.p pVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j8));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(K1.a.a(pVar.d()))}) < 1) {
            contentValues.put("backend_name", pVar.b());
            contentValues.put(Constants.PRIORITY, Integer.valueOf(K1.a.a(pVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public static byte[] n1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static C2900c r1(String str) {
        return str == null ? f3582f : C2900c.b(str);
    }

    public static String s1(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((AbstractC0593k) it.next()).c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object t1(Cursor cursor, b bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final void A0(final SQLiteDatabase sQLiteDatabase) {
        q1(new d() { // from class: H1.l
            @Override // H1.M.d
            public final Object a() {
                return M.O0(sQLiteDatabase);
            }
        }, new b() { // from class: H1.w
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.P0((Throwable) obj);
            }
        });
    }

    public final long B0(SQLiteDatabase sQLiteDatabase, z1.p pVar) {
        Long lI0 = I0(sQLiteDatabase, pVar);
        if (lI0 != null) {
            return lI0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put(Constants.PRIORITY, Integer.valueOf(K1.a.a(pVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (pVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(pVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    public long C0() {
        return F0() * G0();
    }

    public SQLiteDatabase D0() {
        final W w8 = this.f3583a;
        Objects.requireNonNull(w8);
        return (SQLiteDatabase) q1(new d() { // from class: H1.E
            @Override // H1.M.d
            public final Object a() {
                return w8.getWritableDatabase();
            }
        }, new b() { // from class: H1.F
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.Q0((Throwable) obj);
            }
        });
    }

    public final C1.b E0() {
        return C1.b.b().b(C1.e.c().b(C0()).c(AbstractC0587e.f3623a.f()).a()).a();
    }

    public final long F0() {
        return D0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    public final long G0() {
        return D0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    public final C1.f H0() {
        final long jA = this.f3584b.a();
        return (C1.f) J0(new b() { // from class: H1.C
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.T0(jA, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // H1.InterfaceC0586d
    public long I(z1.p pVar) {
        return ((Long) t1(D0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(K1.a.a(pVar.d()))}), new b() { // from class: H1.H
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.R0((Cursor) obj);
            }
        })).longValue();
    }

    public final Long I0(SQLiteDatabase sQLiteDatabase, z1.p pVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(pVar.b(), String.valueOf(K1.a.a(pVar.d()))));
        if (pVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(pVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) t1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: H1.n
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.U0((Cursor) obj);
            }
        });
    }

    public Object J0(b bVar) {
        SQLiteDatabase sQLiteDatabaseD0 = D0();
        sQLiteDatabaseD0.beginTransaction();
        try {
            Object objApply = bVar.apply(sQLiteDatabaseD0);
            sQLiteDatabaseD0.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseD0.endTransaction();
        }
    }

    public final boolean K0() {
        return F0() * G0() >= this.f3586d.f();
    }

    @Override // H1.InterfaceC0586d
    public boolean L(final z1.p pVar) {
        return ((Boolean) J0(new b() { // from class: H1.o
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return this.f3631a.V0(pVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    public final List L0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            AbstractC0593k abstractC0593k = (AbstractC0593k) listIterator.next();
            if (map.containsKey(Long.valueOf(abstractC0593k.c()))) {
                i.a aVarP = abstractC0593k.b().p();
                for (c cVar : (Set) map.get(Long.valueOf(abstractC0593k.c()))) {
                    aVarP.c(cVar.f3588a, cVar.f3589b);
                }
                listIterator.set(AbstractC0593k.a(abstractC0593k.c(), abstractC0593k.d(), aVarP.d()));
            }
        }
        return list;
    }

    public final /* synthetic */ Object M0(Cursor cursor) {
        while (cursor.moveToNext()) {
            f(cursor.getInt(0), c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    public final /* synthetic */ Integer N0(long j8, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j8)};
        t1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: H1.s
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return this.f3639a.M0((Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    public final /* synthetic */ Boolean V0(z1.p pVar, SQLiteDatabase sQLiteDatabase) {
        Long lI0 = I0(sQLiteDatabase, pVar);
        return lI0 == null ? Boolean.FALSE : (Boolean) t1(D0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lI0.toString()}), new b() { // from class: H1.u
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    public final /* synthetic */ List Y0(z1.p pVar, SQLiteDatabase sQLiteDatabase) {
        List listL1 = l1(sQLiteDatabase, pVar, this.f3586d.d());
        for (EnumC2903f enumC2903f : EnumC2903f.values()) {
            if (enumC2903f != pVar.d()) {
                int iD = this.f3586d.d() - listL1.size();
                if (iD <= 0) {
                    break;
                }
                listL1.addAll(l1(sQLiteDatabase, pVar.f(enumC2903f), iD));
            }
        }
        return L0(listL1, m1(sQLiteDatabase, listL1));
    }

    public final /* synthetic */ C1.a Z0(Map map, a.C0008a c0008a, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            c.b bVarZ0 = z0(cursor.getInt(1));
            long j8 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(C1.c.c().c(bVarZ0).b(j8).a());
        }
        o1(c0008a, map);
        return c0008a.e(H0()).d(E0()).c((String) this.f3587e.get()).b();
    }

    @Override // H1.InterfaceC0585c
    public void a() {
        J0(new b() { // from class: H1.q
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return this.f3635a.k1((SQLiteDatabase) obj);
            }
        });
    }

    public final /* synthetic */ C1.a a1(String str, final Map map, final a.C0008a c0008a, SQLiteDatabase sQLiteDatabase) {
        return (C1.a) t1(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: H1.A
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return this.f3568a.Z0(map, c0008a, (Cursor) obj);
            }
        });
    }

    public final /* synthetic */ Object b1(List list, z1.p pVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j8 = cursor.getLong(0);
            boolean z7 = cursor.getInt(7) != 0;
            i.a aVarO = z1.i.a().n(cursor.getString(1)).i(cursor.getLong(2)).o(cursor.getLong(3));
            aVarO.h(z7 ? new z1.h(r1(cursor.getString(4)), cursor.getBlob(5)) : new z1.h(r1(cursor.getString(4)), p1(j8)));
            if (!cursor.isNull(6)) {
                aVarO.g(Integer.valueOf(cursor.getInt(6)));
            }
            if (!cursor.isNull(8)) {
                aVarO.l(Integer.valueOf(cursor.getInt(8)));
            }
            if (!cursor.isNull(9)) {
                aVarO.m(cursor.getString(9));
            }
            if (!cursor.isNull(10)) {
                aVarO.j(cursor.getBlob(10));
            }
            if (!cursor.isNull(11)) {
                aVarO.k(cursor.getBlob(11));
            }
            list.add(AbstractC0593k.a(j8, pVar, aVarO.d()));
        }
        return null;
    }

    @Override // I1.b
    public Object c(b.a aVar) {
        SQLiteDatabase sQLiteDatabaseD0 = D0();
        A0(sQLiteDatabaseD0);
        try {
            Object objA = aVar.a();
            sQLiteDatabaseD0.setTransactionSuccessful();
            return objA;
        } finally {
            sQLiteDatabaseD0.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3583a.close();
    }

    @Override // H1.InterfaceC0586d
    public void d0(final z1.p pVar, final long j8) {
        J0(new b() { // from class: H1.p
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.j1(j8, pVar, (SQLiteDatabase) obj);
            }
        });
    }

    public final /* synthetic */ Long d1(z1.i iVar, z1.p pVar, SQLiteDatabase sQLiteDatabase) {
        if (K0()) {
            f(1L, c.b.CACHE_FULL, iVar.n());
            return -1L;
        }
        long jB0 = B0(sQLiteDatabase, pVar);
        int iE = this.f3586d.e();
        byte[] bArrA = iVar.e().a();
        boolean z7 = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jB0));
        contentValues.put("transport_name", iVar.n());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.o()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put(Constants.ERROR_CODE, iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z7));
        contentValues.put("payload", z7 ? bArrA : new byte[0]);
        contentValues.put(DiagnosticsTracker.PRODUCT_ID_KEY, iVar.l());
        contentValues.put("pseudonymous_id", iVar.m());
        contentValues.put("experiment_ids_clear_blob", iVar.g());
        contentValues.put("experiment_ids_encrypted_blob", iVar.h());
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z7) {
            int iCeil = (int) Math.ceil(((double) bArrA.length) / ((double) iE));
            for (int i8 = 1; i8 <= iCeil; i8++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i8 - 1) * iE, Math.min(i8 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i8));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry entry : iVar.k().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", (String) entry.getKey());
            contentValues3.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    @Override // H1.InterfaceC0585c
    public C1.a e() {
        final a.C0008a c0008aE = C1.a.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (C1.a) J0(new b() { // from class: H1.t
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return this.f3640a.a1(str, map, c0008aE, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // H1.InterfaceC0585c
    public void f(final long j8, final c.b bVar, final String str) {
        J0(new b() { // from class: H1.r
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.i1(str, bVar, j8, (SQLiteDatabase) obj);
            }
        });
    }

    public final /* synthetic */ Object f1(Cursor cursor) {
        while (cursor.moveToNext()) {
            f(cursor.getInt(0), c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    public final /* synthetic */ Object g1(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        t1(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: H1.v
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return this.f3644a.f1((Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    @Override // H1.InterfaceC0586d
    public int i() {
        final long jA = this.f3584b.a() - this.f3586d.c();
        return ((Integer) J0(new b() { // from class: H1.J
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return this.f3577a.N0(jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    @Override // H1.InterfaceC0586d
    public void j0(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + s1(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            J0(new b() { // from class: H1.L
                @Override // H1.M.b
                public final Object apply(Object obj) {
                    return this.f3579a.g1(str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    @Override // H1.InterfaceC0586d
    public void k(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            D0().compileStatement("DELETE FROM events WHERE _id in " + s1(iterable)).execute();
        }
    }

    public final /* synthetic */ Object k1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f3584b.a()).execute();
        return null;
    }

    public final List l1(SQLiteDatabase sQLiteDatabase, final z1.p pVar, int i8) {
        final ArrayList arrayList = new ArrayList();
        Long lI0 = I0(sQLiteDatabase, pVar);
        if (lI0 == null) {
            return arrayList;
        }
        t1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", Constants.ERROR_CODE, "inline", DiagnosticsTracker.PRODUCT_ID_KEY, "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{lI0.toString()}, null, null, null, String.valueOf(i8)), new b() { // from class: H1.x
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return this.f3645a.b1(arrayList, pVar, (Cursor) obj);
            }
        });
        return arrayList;
    }

    public final Map m1(SQLiteDatabase sQLiteDatabase, List list) {
        final HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i8 = 0; i8 < list.size(); i8++) {
            sb.append(((AbstractC0593k) list.get(i8)).c());
            if (i8 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        t1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new b() { // from class: H1.z
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.c1(map, (Cursor) obj);
            }
        });
        return map;
    }

    @Override // H1.InterfaceC0586d
    public Iterable o(final z1.p pVar) {
        return (Iterable) J0(new b() { // from class: H1.m
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return this.f3629a.Y0(pVar, (SQLiteDatabase) obj);
            }
        });
    }

    public final void o1(a.C0008a c0008a, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            c0008a.a(C1.d.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    public final byte[] p1(long j8) {
        return (byte[]) t1(D0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j8)}, null, null, "sequence_num"), new b() { // from class: H1.B
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.e1((Cursor) obj);
            }
        });
    }

    public final Object q1(d dVar, b bVar) {
        long jA = this.f3585c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e8) {
                if (this.f3585c.a() >= ((long) this.f3586d.b()) + jA) {
                    return bVar.apply(e8);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // H1.InterfaceC0586d
    public AbstractC0593k u(final z1.p pVar, final z1.i iVar) {
        D1.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", pVar.d(), iVar.n(), pVar.b());
        long jLongValue = ((Long) J0(new b() { // from class: H1.I
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return this.f3574a.d1(iVar, pVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return AbstractC0593k.a(jLongValue, pVar, iVar);
    }

    @Override // H1.InterfaceC0586d
    public Iterable z() {
        return (Iterable) J0(new b() { // from class: H1.G
            @Override // H1.M.b
            public final Object apply(Object obj) {
                return M.W0((SQLiteDatabase) obj);
            }
        });
    }

    public final c.b z0(int i8) {
        c.b bVar = c.b.REASON_UNKNOWN;
        if (i8 == bVar.d()) {
            return bVar;
        }
        c.b bVar2 = c.b.MESSAGE_TOO_OLD;
        if (i8 == bVar2.d()) {
            return bVar2;
        }
        c.b bVar3 = c.b.CACHE_FULL;
        if (i8 == bVar3.d()) {
            return bVar3;
        }
        c.b bVar4 = c.b.PAYLOAD_TOO_BIG;
        if (i8 == bVar4.d()) {
            return bVar4;
        }
        c.b bVar5 = c.b.MAX_RETRIES_REACHED;
        if (i8 == bVar5.d()) {
            return bVar5;
        }
        c.b bVar6 = c.b.INVALID_PAYLOD;
        if (i8 == bVar6.d()) {
            return bVar6;
        }
        c.b bVar7 = c.b.SERVER_ERROR;
        if (i8 == bVar7.d()) {
            return bVar7;
        }
        D1.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i8));
        return bVar;
    }
}

package i1;

import a1.i;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import d1.C1210a;
import d1.C1211b;
import d1.C1212c;
import d1.C1213d;
import d1.C1214e;
import d1.C1215f;
import e1.AbstractC1228a;
import io.flutter.plugins.firebase.crashlytics.Constants;
import j1.C1561a;
import j1.InterfaceC1562b;
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
import k1.InterfaceC1567a;
import l1.AbstractC1589a;

/* JADX INFO: loaded from: classes.dex */
public class M implements InterfaceC1297d, InterfaceC1562b, InterfaceC1296c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final X0.c f12187f = X0.c.b("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W f12188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1567a f12189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC1567a f12190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC1298e f12191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final V2.a f12192e;

    public interface b {
        Object apply(Object obj);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f12194b;

        public c(String str, String str2) {
            this.f12193a = str;
            this.f12194b = str2;
        }
    }

    public interface d {
        Object a();
    }

    public M(InterfaceC1567a interfaceC1567a, InterfaceC1567a interfaceC1567a2, AbstractC1298e abstractC1298e, W w4, V2.a aVar) {
        this.f12188a = w4;
        this.f12189b = interfaceC1567a;
        this.f12190c = interfaceC1567a2;
        this.f12191d = abstractC1298e;
        this.f12192e = aVar;
    }

    public static /* synthetic */ List A(M m4, a1.p pVar, SQLiteDatabase sQLiteDatabase) {
        List listG0 = m4.G0(sQLiteDatabase, pVar, m4.f12191d.d());
        for (X0.f fVar : X0.f.values()) {
            if (fVar != pVar.d()) {
                int iD = m4.f12191d.d() - listG0.size();
                if (iD <= 0) {
                    break;
                }
                listG0.addAll(m4.G0(sQLiteDatabase, pVar.f(fVar), iD));
            }
        }
        return m4.F0(listG0, m4.H0(sQLiteDatabase, listG0));
    }

    public static /* synthetic */ List E(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(a1.p.a().b(cursor.getString(1)).d(AbstractC1589a.b(cursor.getInt(2))).c(I0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ Object G(M m4, Cursor cursor) {
        m4.getClass();
        while (cursor.moveToNext()) {
            m4.p(cursor.getInt(0), C1212c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    public static byte[] I0(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static /* synthetic */ SQLiteDatabase J(Throwable th) {
        throw new C1561a("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Object K(M m4, Cursor cursor) {
        m4.getClass();
        while (cursor.moveToNext()) {
            m4.p(cursor.getInt(0), C1212c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    public static X0.c M0(String str) {
        return str == null ? f12187f : X0.c.b(str);
    }

    public static String N0(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((AbstractC1304k) it.next()).c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object O0(Cursor cursor, b bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static /* synthetic */ Object P(final M m4, String str, String str2, SQLiteDatabase sQLiteDatabase) {
        m4.getClass();
        sQLiteDatabase.compileStatement(str).execute();
        O0(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: i1.p
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.G(this.f12240a, (Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public static /* synthetic */ Boolean S(M m4, a1.p pVar, SQLiteDatabase sQLiteDatabase) {
        Long lC0 = m4.C0(sQLiteDatabase, pVar);
        return lC0 == null ? Boolean.FALSE : (Boolean) O0(m4.x0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lC0.toString()}), new b() { // from class: i1.o
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    public static /* synthetic */ Object a0(long j4, a1.p pVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j4));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(AbstractC1589a.a(pVar.d()))}) < 1) {
            contentValues.put("backend_name", pVar.b());
            contentValues.put("priority", Integer.valueOf(AbstractC1589a.a(pVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public static /* synthetic */ byte[] d0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            byte[] bArr2 = (byte[]) arrayList.get(i4);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ List e0(SQLiteDatabase sQLiteDatabase) {
        return (List) O0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: i1.z
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.E((Cursor) obj);
            }
        });
    }

    public static /* synthetic */ C1210a f0(M m4, Map map, C1210a.C0183a c0183a, Cursor cursor) {
        m4.getClass();
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            C1212c.b bVarT0 = m4.t0(cursor.getInt(1));
            long j4 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(C1212c.c().c(bVarT0).b(j4).a());
        }
        m4.J0(c0183a, map);
        return c0183a.e(m4.B0()).d(m4.y0()).c((String) m4.f12192e.get()).b();
    }

    public static /* synthetic */ Long h0(M m4, a1.i iVar, a1.p pVar, SQLiteDatabase sQLiteDatabase) {
        if (m4.E0()) {
            m4.p(1L, C1212c.b.CACHE_FULL, iVar.n());
            return -1L;
        }
        long jV0 = m4.v0(sQLiteDatabase, pVar);
        int iE = m4.f12191d.e();
        byte[] bArrA = iVar.e().a();
        boolean z4 = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jV0));
        contentValues.put("transport_name", iVar.n());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.o()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z4));
        contentValues.put("payload", z4 ? bArrA : new byte[0]);
        contentValues.put(DiagnosticsTracker.PRODUCT_ID_KEY, iVar.l());
        contentValues.put("pseudonymous_id", iVar.m());
        contentValues.put("experiment_ids_clear_blob", iVar.g());
        contentValues.put("experiment_ids_encrypted_blob", iVar.h());
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z4) {
            int iCeil = (int) Math.ceil(((double) bArrA.length) / ((double) iE));
            for (int i4 = 1; i4 <= iCeil; i4++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i4 - 1) * iE, Math.min(i4 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i4));
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

    public static /* synthetic */ Object i0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Long j0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    public static /* synthetic */ Object k0(Throwable th) {
        throw new C1561a("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ Object l0(String str, C1212c.b bVar, long j4, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) O0(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())}), new b() { // from class: i1.r
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).getCount() > 0);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j4 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())});
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("log_source", str);
        contentValues.put(Constants.REASON, Integer.valueOf(bVar.getNumber()));
        contentValues.put("events_dropped_count", Long.valueOf(j4));
        sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        return null;
    }

    public static /* synthetic */ Object m0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j4 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j4));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j4), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    public static /* synthetic */ Integer n0(final M m4, long j4, SQLiteDatabase sQLiteDatabase) {
        m4.getClass();
        String[] strArr = {String.valueOf(j4)};
        O0(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: i1.C
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.K(this.f12174a, (Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    public static /* synthetic */ Object o0(M m4, List list, a1.p pVar, Cursor cursor) {
        m4.getClass();
        while (cursor.moveToNext()) {
            long j4 = cursor.getLong(0);
            boolean z4 = cursor.getInt(7) != 0;
            i.a aVarO = a1.i.a().n(cursor.getString(1)).i(cursor.getLong(2)).o(cursor.getLong(3));
            if (z4) {
                aVarO.h(new a1.h(M0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarO.h(new a1.h(M0(cursor.getString(4)), m4.K0(j4)));
            }
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
            list.add(AbstractC1304k.a(j4, pVar, aVarO.d()));
        }
        return null;
    }

    public static /* synthetic */ Object p0(M m4, SQLiteDatabase sQLiteDatabase) {
        m4.getClass();
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + m4.f12189b.a()).execute();
        return null;
    }

    public static /* synthetic */ C1210a q0(final M m4, String str, final Map map, final C1210a.C0183a c0183a, SQLiteDatabase sQLiteDatabase) {
        m4.getClass();
        return (C1210a) O0(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: i1.x
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.f0(this.f12249a, map, c0183a, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ Long r0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ C1215f s0(final long j4, SQLiteDatabase sQLiteDatabase) {
        return (C1215f) O0(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: i1.D
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.x(j4, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ C1215f x(long j4, Cursor cursor) {
        cursor.moveToNext();
        return C1215f.c().c(cursor.getLong(0)).b(j4).a();
    }

    public final long A0() {
        return x0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    @Override // i1.InterfaceC1297d
    public boolean B(final a1.p pVar) {
        return ((Boolean) D0(new b() { // from class: i1.I
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.S(this.f12179a, pVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    public final C1215f B0() {
        final long jA = this.f12189b.a();
        return (C1215f) D0(new b() { // from class: i1.B
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.s0(jA, (SQLiteDatabase) obj);
            }
        });
    }

    public final Long C0(SQLiteDatabase sQLiteDatabase, a1.p pVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(pVar.b(), String.valueOf(AbstractC1589a.a(pVar.d()))));
        if (pVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(pVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) O0(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: i1.u
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.j0((Cursor) obj);
            }
        });
    }

    @Override // i1.InterfaceC1297d
    public void D(final a1.p pVar, final long j4) {
        D0(new b() { // from class: i1.J
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.a0(j4, pVar, (SQLiteDatabase) obj);
            }
        });
    }

    public Object D0(b bVar) {
        SQLiteDatabase sQLiteDatabaseX0 = x0();
        sQLiteDatabaseX0.beginTransaction();
        try {
            Object objApply = bVar.apply(sQLiteDatabaseX0);
            sQLiteDatabaseX0.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseX0.endTransaction();
        }
    }

    public final boolean E0() {
        return z0() * A0() >= this.f12191d.f();
    }

    public final List F0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            AbstractC1304k abstractC1304k = (AbstractC1304k) listIterator.next();
            if (map.containsKey(Long.valueOf(abstractC1304k.c()))) {
                i.a aVarP = abstractC1304k.b().p();
                for (c cVar : (Set) map.get(Long.valueOf(abstractC1304k.c()))) {
                    aVarP.c(cVar.f12193a, cVar.f12194b);
                }
                listIterator.set(AbstractC1304k.a(abstractC1304k.c(), abstractC1304k.d(), aVarP.d()));
            }
        }
        return list;
    }

    public final List G0(SQLiteDatabase sQLiteDatabase, final a1.p pVar, int i4) {
        final ArrayList arrayList = new ArrayList();
        Long lC0 = C0(sQLiteDatabase, pVar);
        if (lC0 == null) {
            return arrayList;
        }
        O0(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", DiagnosticsTracker.PRODUCT_ID_KEY, "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{lC0.toString()}, null, null, null, String.valueOf(i4)), new b() { // from class: i1.q
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.o0(this.f12241a, arrayList, pVar, (Cursor) obj);
            }
        });
        return arrayList;
    }

    public final Map H0(SQLiteDatabase sQLiteDatabase, List list) {
        final HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i4 = 0; i4 < list.size(); i4++) {
            sb.append(((AbstractC1304k) list.get(i4)).c());
            if (i4 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        O0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new b() { // from class: i1.s
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.m0(map, (Cursor) obj);
            }
        });
        return map;
    }

    public final void J0(C1210a.C0183a c0183a, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            c0183a.a(C1213d.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    public final byte[] K0(long j4) {
        return (byte[]) O0(x0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j4)}, null, null, "sequence_num"), new b() { // from class: i1.A
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.d0((Cursor) obj);
            }
        });
    }

    public final Object L0(d dVar, b bVar) {
        long jA = this.f12190c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e4) {
                if (this.f12190c.a() >= ((long) this.f12191d.b()) + jA) {
                    return bVar.apply(e4);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // i1.InterfaceC1297d
    public long T(a1.p pVar) {
        return ((Long) O0(x0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(AbstractC1589a.a(pVar.d()))}), new b() { // from class: i1.m
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.r0((Cursor) obj);
            }
        })).longValue();
    }

    @Override // i1.InterfaceC1297d
    public void U(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + N0(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            D0(new b() { // from class: i1.l
                @Override // i1.M.b
                public final Object apply(Object obj) {
                    return M.P(this.f12233a, str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12188a.close();
    }

    @Override // i1.InterfaceC1296c
    public void e() {
        D0(new b() { // from class: i1.K
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.p0(this.f12183a, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // j1.InterfaceC1562b
    public Object f(InterfaceC1562b.a aVar) {
        SQLiteDatabase sQLiteDatabaseX0 = x0();
        u0(sQLiteDatabaseX0);
        try {
            Object objA = aVar.a();
            sQLiteDatabaseX0.setTransactionSuccessful();
            return objA;
        } finally {
            sQLiteDatabaseX0.endTransaction();
        }
    }

    @Override // i1.InterfaceC1296c
    public C1210a g() {
        final C1210a.C0183a c0183aE = C1210a.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (C1210a) D0(new b() { // from class: i1.n
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.q0(this.f12236a, str, map, c0183aE, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // i1.InterfaceC1297d
    public int h() {
        final long jA = this.f12189b.a() - this.f12191d.c();
        return ((Integer) D0(new b() { // from class: i1.y
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.n0(this.f12252a, jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    @Override // i1.InterfaceC1297d
    public void i(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            x0().compileStatement("DELETE FROM events WHERE _id in " + N0(iterable)).execute();
        }
    }

    @Override // i1.InterfaceC1297d
    public Iterable k(final a1.p pVar) {
        return (Iterable) D0(new b() { // from class: i1.F
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.A(this.f12176a, pVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // i1.InterfaceC1297d
    public AbstractC1304k n(final a1.p pVar, final a1.i iVar) {
        AbstractC1228a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", pVar.d(), iVar.n(), pVar.b());
        long jLongValue = ((Long) D0(new b() { // from class: i1.v
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.h0(this.f12245a, iVar, pVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return AbstractC1304k.a(jLongValue, pVar, iVar);
    }

    @Override // i1.InterfaceC1296c
    public void p(final long j4, final C1212c.b bVar, final String str) {
        D0(new b() { // from class: i1.L
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.l0(str, bVar, j4, (SQLiteDatabase) obj);
            }
        });
    }

    public final C1212c.b t0(int i4) {
        C1212c.b bVar = C1212c.b.REASON_UNKNOWN;
        if (i4 == bVar.getNumber()) {
            return bVar;
        }
        C1212c.b bVar2 = C1212c.b.MESSAGE_TOO_OLD;
        if (i4 == bVar2.getNumber()) {
            return bVar2;
        }
        C1212c.b bVar3 = C1212c.b.CACHE_FULL;
        if (i4 == bVar3.getNumber()) {
            return bVar3;
        }
        C1212c.b bVar4 = C1212c.b.PAYLOAD_TOO_BIG;
        if (i4 == bVar4.getNumber()) {
            return bVar4;
        }
        C1212c.b bVar5 = C1212c.b.MAX_RETRIES_REACHED;
        if (i4 == bVar5.getNumber()) {
            return bVar5;
        }
        C1212c.b bVar6 = C1212c.b.INVALID_PAYLOD;
        if (i4 == bVar6.getNumber()) {
            return bVar6;
        }
        C1212c.b bVar7 = C1212c.b.SERVER_ERROR;
        if (i4 == bVar7.getNumber()) {
            return bVar7;
        }
        AbstractC1228a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i4));
        return bVar;
    }

    @Override // i1.InterfaceC1297d
    public Iterable u() {
        return (Iterable) D0(new b() { // from class: i1.t
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.e0((SQLiteDatabase) obj);
            }
        });
    }

    public final void u0(final SQLiteDatabase sQLiteDatabase) {
        L0(new d() { // from class: i1.w
            @Override // i1.M.d
            public final Object a() {
                return M.i0(sQLiteDatabase);
            }
        }, new b() { // from class: i1.E
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.k0((Throwable) obj);
            }
        });
    }

    public final long v0(SQLiteDatabase sQLiteDatabase, a1.p pVar) {
        Long lC0 = C0(sQLiteDatabase, pVar);
        if (lC0 != null) {
            return lC0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put("priority", Integer.valueOf(AbstractC1589a.a(pVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (pVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(pVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    public long w0() {
        return z0() * A0();
    }

    public SQLiteDatabase x0() {
        final W w4 = this.f12188a;
        Objects.requireNonNull(w4);
        return (SQLiteDatabase) L0(new d() { // from class: i1.G
            @Override // i1.M.d
            public final Object a() {
                return w4.getWritableDatabase();
            }
        }, new b() { // from class: i1.H
            @Override // i1.M.b
            public final Object apply(Object obj) {
                return M.J((Throwable) obj);
            }
        });
    }

    public final C1211b y0() {
        return C1211b.b().b(C1214e.c().b(w0()).c(AbstractC1298e.f12228a.f()).a()).a();
    }

    public final long z0() {
        return x0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }
}

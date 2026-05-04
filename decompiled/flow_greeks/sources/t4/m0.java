package t4;

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
import l4.i;
import o4.a;
import o4.c;
import u4.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m0 implements t4.d, u4.b, t4.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i4.c f20764f = i4.c.b("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0 f20765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v4.a f20766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v4.a f20767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f20768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f20769e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        Object apply(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f20771b;

        public c(String str, String str2) {
            this.f20770a = str;
            this.f20771b = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        Object a();
    }

    public m0(v4.a aVar, v4.a aVar2, e eVar, v0 v0Var, bd.a aVar3) {
        this.f20765a = v0Var;
        this.f20766b = aVar;
        this.f20767c = aVar2;
        this.f20768d = eVar;
        this.f20769e = aVar3;
    }

    public static /* synthetic */ List C(m0 m0Var, l4.p pVar, SQLiteDatabase sQLiteDatabase) {
        List listC0 = m0Var.C0(sQLiteDatabase, pVar, m0Var.f20768d.d());
        for (i4.f fVar : i4.f.values()) {
            if (fVar != pVar.d()) {
                int iD = m0Var.f20768d.d() - listC0.size();
                if (iD <= 0) {
                    break;
                }
                listC0.addAll(m0Var.C0(sQLiteDatabase, pVar.f(fVar), iD));
            }
        }
        return m0Var.B0(listC0, m0Var.D0(sQLiteDatabase, listC0));
    }

    public static /* synthetic */ List E(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(l4.p.a().b(cursor.getString(1)).d(w4.a.b(cursor.getInt(2))).c(E0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static byte[] E0(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static /* synthetic */ Object G(m0 m0Var, Cursor cursor) {
        m0Var.getClass();
        while (cursor.moveToNext()) {
            m0Var.b(cursor.getInt(0), c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    public static /* synthetic */ SQLiteDatabase H(Throwable th) {
        throw new u4.a("Timed out while trying to open db.", th);
    }

    public static i4.c I0(String str) {
        return str == null ? f20764f : i4.c.b(str);
    }

    public static String J0(Iterable iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(((k) it.next()).c());
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static /* synthetic */ Object K(m0 m0Var, Cursor cursor) {
        m0Var.getClass();
        while (cursor.moveToNext()) {
            m0Var.b(cursor.getInt(0), c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    public static Object K0(Cursor cursor, b bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static /* synthetic */ Object N(final m0 m0Var, String str, String str2, SQLiteDatabase sQLiteDatabase) {
        m0Var.getClass();
        sQLiteDatabase.compileStatement(str).execute();
        K0(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: t4.v
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.G(this.f20790a, (Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public static /* synthetic */ Boolean O(m0 m0Var, l4.p pVar, SQLiteDatabase sQLiteDatabase) {
        Long lY0 = m0Var.y0(sQLiteDatabase, pVar);
        return lY0 == null ? Boolean.FALSE : (Boolean) K0(m0Var.t0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lY0.toString()}), new b() { // from class: t4.u
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    public static /* synthetic */ Object R(long j10, l4.p pVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j10));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(w4.a.a(pVar.d()))}) < 1) {
            contentValues.put("backend_name", pVar.b());
            contentValues.put(Constants.PRIORITY, Integer.valueOf(w4.a.a(pVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public static /* synthetic */ byte[] Z(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            byte[] bArr2 = (byte[]) arrayList.get(i10);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ List a0(SQLiteDatabase sQLiteDatabase) {
        return (List) K0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: t4.k0
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.E((Cursor) obj);
            }
        });
    }

    public static /* synthetic */ o4.a b0(m0 m0Var, Map map, a.C0305a c0305a, Cursor cursor) {
        m0Var.getClass();
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            c.b bVarP0 = m0Var.p0(cursor.getInt(1));
            long j10 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(o4.c.c().c(bVarP0).b(j10).a());
        }
        m0Var.F0(c0305a, map);
        return c0305a.e(m0Var.x0()).d(m0Var.u0()).c((String) m0Var.f20769e.get()).b();
    }

    public static /* synthetic */ Long d0(m0 m0Var, l4.i iVar, l4.p pVar, SQLiteDatabase sQLiteDatabase) {
        if (m0Var.A0()) {
            m0Var.b(1L, c.b.CACHE_FULL, iVar.n());
            return -1L;
        }
        long jR0 = m0Var.r0(sQLiteDatabase, pVar);
        int iE = m0Var.f20768d.e();
        byte[] bArrA = iVar.e().a();
        boolean z10 = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jR0));
        contentValues.put("transport_name", iVar.n());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.o()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put(Constants.ERROR_CODE, iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z10));
        contentValues.put("payload", z10 ? bArrA : new byte[0]);
        contentValues.put(DiagnosticsTracker.PRODUCT_ID_KEY, iVar.l());
        contentValues.put("pseudonymous_id", iVar.m());
        contentValues.put("experiment_ids_clear_blob", iVar.g());
        contentValues.put("experiment_ids_encrypted_blob", iVar.h());
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z10) {
            int iCeil = (int) Math.ceil(((double) bArrA.length) / ((double) iE));
            for (int i10 = 1; i10 <= iCeil; i10++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i10 - 1) * iE, Math.min(i10 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i10));
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

    public static /* synthetic */ Object e0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Long f0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    public static /* synthetic */ Object g0(Throwable th) {
        throw new u4.a("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ Object h0(String str, c.b bVar, long j10, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) K0(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.d())}), new b() { // from class: t4.y
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).getCount() > 0);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j10 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.d())});
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("log_source", str);
        contentValues.put("reason", Integer.valueOf(bVar.d()));
        contentValues.put("events_dropped_count", Long.valueOf(j10));
        sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        return null;
    }

    public static /* synthetic */ Object i0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j10 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j10));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j10), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    public static /* synthetic */ Integer j0(final m0 m0Var, long j10, SQLiteDatabase sQLiteDatabase) {
        m0Var.getClass();
        String[] strArr = {String.valueOf(j10)};
        K0(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: t4.s
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.K(this.f20785a, (Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    public static /* synthetic */ Object k0(m0 m0Var, List list, l4.p pVar, Cursor cursor) {
        m0Var.getClass();
        while (cursor.moveToNext()) {
            long j10 = cursor.getLong(0);
            boolean z10 = cursor.getInt(7) != 0;
            i.a aVarO = l4.i.a().n(cursor.getString(1)).i(cursor.getLong(2)).o(cursor.getLong(3));
            if (z10) {
                aVarO.h(new l4.h(I0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarO.h(new l4.h(I0(cursor.getString(4)), m0Var.G0(j10)));
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
            list.add(k.a(j10, pVar, aVarO.d()));
        }
        return null;
    }

    public static /* synthetic */ Object l0(m0 m0Var, SQLiteDatabase sQLiteDatabase) {
        m0Var.getClass();
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + m0Var.f20766b.a()).execute();
        return null;
    }

    public static /* synthetic */ o4.a m0(final m0 m0Var, String str, final Map map, final a.C0305a c0305a, SQLiteDatabase sQLiteDatabase) {
        m0Var.getClass();
        return (o4.a) K0(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: t4.a0
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.b0(this.f20739a, map, c0305a, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ Long n0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ o4.f o0(final long j10, SQLiteDatabase sQLiteDatabase) {
        return (o4.f) K0(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: t4.d0
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.u(j10, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ o4.f u(long j10, Cursor cursor) {
        cursor.moveToNext();
        return o4.f.c().c(cursor.getLong(0)).b(j10).a();
    }

    @Override // t4.d
    public Iterable A(final l4.p pVar) {
        return (Iterable) z0(new b() { // from class: t4.m
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.C(this.f20762a, pVar, (SQLiteDatabase) obj);
            }
        });
    }

    public final boolean A0() {
        return v0() * w0() >= this.f20768d.f();
    }

    public final List B0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            k kVar = (k) listIterator.next();
            if (map.containsKey(Long.valueOf(kVar.c()))) {
                i.a aVarP = kVar.b().p();
                for (c cVar : (Set) map.get(Long.valueOf(kVar.c()))) {
                    aVarP.c(cVar.f20770a, cVar.f20771b);
                }
                listIterator.set(k.a(kVar.c(), kVar.d(), aVarP.d()));
            }
        }
        return list;
    }

    public final List C0(SQLiteDatabase sQLiteDatabase, final l4.p pVar, int i10) {
        final ArrayList arrayList = new ArrayList();
        Long lY0 = y0(sQLiteDatabase, pVar);
        if (lY0 == null) {
            return arrayList;
        }
        K0(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", Constants.ERROR_CODE, "inline", DiagnosticsTracker.PRODUCT_ID_KEY, "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{lY0.toString()}, null, null, null, String.valueOf(i10)), new b() { // from class: t4.x
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.k0(this.f20806a, arrayList, pVar, (Cursor) obj);
            }
        });
        return arrayList;
    }

    public final Map D0(SQLiteDatabase sQLiteDatabase, List list) {
        final HashMap map = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i10 = 0; i10 < list.size(); i10++) {
            sb2.append(((k) list.get(i10)).c());
            if (i10 < list.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        K0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb2.toString(), null, null, null, null), new b() { // from class: t4.z
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.i0(map, (Cursor) obj);
            }
        });
        return map;
    }

    @Override // t4.d
    public void F(final l4.p pVar, final long j10) {
        z0(new b() { // from class: t4.p
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.R(j10, pVar, (SQLiteDatabase) obj);
            }
        });
    }

    public final void F0(a.C0305a c0305a, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            c0305a.a(o4.d.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    public final byte[] G0(long j10) {
        return (byte[]) K0(t0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j10)}, null, null, "sequence_num"), new b() { // from class: t4.b0
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.Z((Cursor) obj);
            }
        });
    }

    public final Object H0(d dVar, b bVar) {
        long jA = this.f20767c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e10) {
                if (this.f20767c.a() >= ((long) this.f20768d.b()) + jA) {
                    return bVar.apply(e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // t4.d
    public void S(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + J0(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            z0(new b() { // from class: t4.l0
                @Override // t4.m0.b
                public final Object apply(Object obj) {
                    return m0.N(this.f20759a, str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    @Override // t4.c
    public void b(final long j10, final c.b bVar, final String str) {
        z0(new b() { // from class: t4.r
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.h0(str, bVar, j10, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // t4.c
    public void c() {
        z0(new b() { // from class: t4.q
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.l0(this.f20781a, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f20765a.close();
    }

    @Override // u4.b
    public Object e(b.a aVar) {
        SQLiteDatabase sQLiteDatabaseT0 = t0();
        q0(sQLiteDatabaseT0);
        try {
            Object objA = aVar.a();
            sQLiteDatabaseT0.setTransactionSuccessful();
            return objA;
        } finally {
            sQLiteDatabaseT0.endTransaction();
        }
    }

    @Override // t4.d
    public int h() {
        final long jA = this.f20766b.a() - this.f20768d.c();
        return ((Integer) z0(new b() { // from class: t4.j0
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.j0(this.f20756a, jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    @Override // t4.d
    public void i(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            t0().compileStatement("DELETE FROM events WHERE _id in " + J0(iterable)).execute();
        }
    }

    @Override // t4.c
    public o4.a o() {
        final a.C0305a c0305aE = o4.a.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (o4.a) z0(new b() { // from class: t4.t
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.m0(this.f20786a, str, map, c0305aE, (SQLiteDatabase) obj);
            }
        });
    }

    public final c.b p0(int i10) {
        c.b bVar = c.b.REASON_UNKNOWN;
        if (i10 == bVar.d()) {
            return bVar;
        }
        c.b bVar2 = c.b.MESSAGE_TOO_OLD;
        if (i10 == bVar2.d()) {
            return bVar2;
        }
        c.b bVar3 = c.b.CACHE_FULL;
        if (i10 == bVar3.d()) {
            return bVar3;
        }
        c.b bVar4 = c.b.PAYLOAD_TOO_BIG;
        if (i10 == bVar4.d()) {
            return bVar4;
        }
        c.b bVar5 = c.b.MAX_RETRIES_REACHED;
        if (i10 == bVar5.d()) {
            return bVar5;
        }
        c.b bVar6 = c.b.INVALID_PAYLOD;
        if (i10 == bVar6.d()) {
            return bVar6;
        }
        c.b bVar7 = c.b.SERVER_ERROR;
        if (i10 == bVar7.d()) {
            return bVar7;
        }
        p4.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i10));
        return bVar;
    }

    public final void q0(final SQLiteDatabase sQLiteDatabase) {
        H0(new d() { // from class: t4.l
            @Override // t4.m0.d
            public final Object a() {
                return m0.e0(sQLiteDatabase);
            }
        }, new b() { // from class: t4.w
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.g0((Throwable) obj);
            }
        });
    }

    public final long r0(SQLiteDatabase sQLiteDatabase, l4.p pVar) {
        Long lY0 = y0(sQLiteDatabase, pVar);
        if (lY0 != null) {
            return lY0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put(Constants.PRIORITY, Integer.valueOf(w4.a.a(pVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (pVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(pVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    @Override // t4.d
    public Iterable s() {
        return (Iterable) z0(new b() { // from class: t4.g0
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.a0((SQLiteDatabase) obj);
            }
        });
    }

    public long s0() {
        return v0() * w0();
    }

    @Override // t4.d
    public k t(final l4.p pVar, final l4.i iVar) {
        p4.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", pVar.d(), iVar.n(), pVar.b());
        long jLongValue = ((Long) z0(new b() { // from class: t4.i0
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.d0(this.f20752a, iVar, pVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return k.a(jLongValue, pVar, iVar);
    }

    public SQLiteDatabase t0() {
        final v0 v0Var = this.f20765a;
        Objects.requireNonNull(v0Var);
        return (SQLiteDatabase) H0(new d() { // from class: t4.e0
            @Override // t4.m0.d
            public final Object a() {
                return v0Var.getWritableDatabase();
            }
        }, new b() { // from class: t4.f0
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.H((Throwable) obj);
            }
        });
    }

    public final o4.b u0() {
        return o4.b.b().b(o4.e.c().b(s0()).c(e.f20747a.f()).a()).a();
    }

    public final long v0() {
        return t0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    @Override // t4.d
    public long w(l4.p pVar) {
        return ((Long) K0(t0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(w4.a.a(pVar.d()))}), new b() { // from class: t4.h0
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.n0((Cursor) obj);
            }
        })).longValue();
    }

    public final long w0() {
        return t0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    public final o4.f x0() {
        final long jA = this.f20766b.a();
        return (o4.f) z0(new b() { // from class: t4.c0
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.o0(jA, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // t4.d
    public boolean y(final l4.p pVar) {
        return ((Boolean) z0(new b() { // from class: t4.o
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.O(this.f20777a, pVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    public final Long y0(SQLiteDatabase sQLiteDatabase, l4.p pVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(pVar.b(), String.valueOf(w4.a.a(pVar.d()))));
        if (pVar.c() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(pVar.c(), 0));
        } else {
            sb2.append(" and extras is null");
        }
        return (Long) K0(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: t4.n
            @Override // t4.m0.b
            public final Object apply(Object obj) {
                return m0.f0((Cursor) obj);
            }
        });
    }

    public Object z0(b bVar) {
        SQLiteDatabase sQLiteDatabaseT0 = t0();
        sQLiteDatabaseT0.beginTransaction();
        try {
            Object objApply = bVar.apply(sQLiteDatabaseT0);
            sQLiteDatabaseT0.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseT0.endTransaction();
        }
    }
}

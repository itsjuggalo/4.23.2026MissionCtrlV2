package z1;

import A1.b;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
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
import o1.C2291c;
import o1.EnumC2294f;
import r1.i;
import u1.C2745a;
import u1.C2746b;
import u1.C2747c;
import u1.C2748d;
import u1.C2749e;
import u1.C2750f;
import v1.AbstractC2763a;

/* JADX INFO: loaded from: classes.dex */
public class M implements InterfaceC2859d, A1.b, InterfaceC2858c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C2291c f25963f = C2291c.b("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W f25964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B1.a f25965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B1.a f25966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC2860e f25967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final D5.a f25968e;

    public interface b {
        Object apply(Object obj);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f25970b;

        public c(String str, String str2) {
            this.f25969a = str;
            this.f25970b = str2;
        }
    }

    public interface d {
        Object a();
    }

    public M(B1.a aVar, B1.a aVar2, AbstractC2860e abstractC2860e, W w7, D5.a aVar3) {
        this.f25964a = w7;
        this.f25965b = aVar;
        this.f25966c = aVar2;
        this.f25967d = abstractC2860e;
        this.f25968e = aVar3;
    }

    public static byte[] C1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static C2291c G1(String str) {
        return str == null ? f25963f : C2291c.b(str);
    }

    public static String H1(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((AbstractC2866k) it.next()).c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object I1(Cursor cursor, b bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static /* synthetic */ Object d1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Object e1(Throwable th) {
        throw new A1.a("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ SQLiteDatabase f1(Throwable th) {
        throw new A1.a("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Long g1(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ C2750f h1(long j7, Cursor cursor) {
        cursor.moveToNext();
        return C2750f.c().c(cursor.getLong(0)).b(j7).a();
    }

    public static /* synthetic */ C2750f i1(final long j7, SQLiteDatabase sQLiteDatabase) {
        return (C2750f) I1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: z1.D
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.h1(j7, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ Long j1(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    public static /* synthetic */ List l1(SQLiteDatabase sQLiteDatabase) {
        return (List) I1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: z1.K
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.m1((Cursor) obj);
            }
        });
    }

    public static /* synthetic */ List m1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(r1.p.a().b(cursor.getString(1)).d(C1.a.b(cursor.getInt(2))).c(C1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ Object r1(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j7 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j7));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j7), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    public static /* synthetic */ byte[] t1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            byte[] bArr2 = (byte[]) arrayList.get(i7);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ Boolean w1(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    public static /* synthetic */ Object x1(String str, C2747c.b bVar, long j7, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) I1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.d())}), new b() { // from class: z1.y
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.w1((Cursor) obj);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j7 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.d())});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(bVar.d()));
            contentValues.put("events_dropped_count", Long.valueOf(j7));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    public static /* synthetic */ Object y1(long j7, r1.p pVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j7));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(C1.a.a(pVar.d()))}) < 1) {
            contentValues.put("backend_name", pVar.b());
            contentValues.put("priority", Integer.valueOf(C1.a.a(pVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    @Override // z1.InterfaceC2858c
    public void A() {
        Y0(new b() { // from class: z1.q
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return this.f26016a.z1((SQLiteDatabase) obj);
            }
        });
    }

    public final List A1(SQLiteDatabase sQLiteDatabase, final r1.p pVar, int i7) {
        final ArrayList arrayList = new ArrayList();
        Long lX0 = X0(sQLiteDatabase, pVar);
        if (lX0 == null) {
            return arrayList;
        }
        I1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", DiagnosticsTracker.PRODUCT_ID_KEY, "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{lX0.toString()}, null, null, null, String.valueOf(i7)), new b() { // from class: z1.x
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return this.f26026a.q1(arrayList, pVar, (Cursor) obj);
            }
        });
        return arrayList;
    }

    public final Map B1(SQLiteDatabase sQLiteDatabase, List list) {
        final HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i7 = 0; i7 < list.size(); i7++) {
            sb.append(((AbstractC2866k) list.get(i7)).c());
            if (i7 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        I1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new b() { // from class: z1.z
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.r1(map, (Cursor) obj);
            }
        });
        return map;
    }

    public final void D1(C2745a.C0377a c0377a, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            c0377a.a(C2748d.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    public final byte[] E1(long j7) {
        return (byte[]) I1(S0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j7)}, null, null, "sequence_num"), new b() { // from class: z1.B
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.t1((Cursor) obj);
            }
        });
    }

    public final Object F1(d dVar, b bVar) {
        long jA = this.f25966c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e7) {
                if (this.f25966c.a() >= ((long) this.f25967d.b()) + jA) {
                    return bVar.apply(e7);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // z1.InterfaceC2858c
    public C2745a G() {
        final C2745a.C0377a c0377aE = C2745a.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (C2745a) Y0(new b() { // from class: z1.t
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return this.f26021a.p1(str, map, c0377aE, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // z1.InterfaceC2859d
    public AbstractC2866k N(final r1.p pVar, final r1.i iVar) {
        AbstractC2763a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", pVar.d(), iVar.n(), pVar.b());
        long jLongValue = ((Long) Y0(new b() { // from class: z1.I
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return this.f25955a.s1(iVar, pVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return AbstractC2866k.a(jLongValue, pVar, iVar);
    }

    public final C2747c.b O0(int i7) {
        C2747c.b bVar = C2747c.b.REASON_UNKNOWN;
        if (i7 == bVar.d()) {
            return bVar;
        }
        C2747c.b bVar2 = C2747c.b.MESSAGE_TOO_OLD;
        if (i7 == bVar2.d()) {
            return bVar2;
        }
        C2747c.b bVar3 = C2747c.b.CACHE_FULL;
        if (i7 == bVar3.d()) {
            return bVar3;
        }
        C2747c.b bVar4 = C2747c.b.PAYLOAD_TOO_BIG;
        if (i7 == bVar4.d()) {
            return bVar4;
        }
        C2747c.b bVar5 = C2747c.b.MAX_RETRIES_REACHED;
        if (i7 == bVar5.d()) {
            return bVar5;
        }
        C2747c.b bVar6 = C2747c.b.INVALID_PAYLOD;
        if (i7 == bVar6.d()) {
            return bVar6;
        }
        C2747c.b bVar7 = C2747c.b.SERVER_ERROR;
        if (i7 == bVar7.d()) {
            return bVar7;
        }
        AbstractC2763a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i7));
        return bVar;
    }

    public final void P0(final SQLiteDatabase sQLiteDatabase) {
        F1(new d() { // from class: z1.l
            @Override // z1.M.d
            public final Object a() {
                return M.d1(sQLiteDatabase);
            }
        }, new b() { // from class: z1.w
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.e1((Throwable) obj);
            }
        });
    }

    public final long Q0(SQLiteDatabase sQLiteDatabase, r1.p pVar) {
        Long lX0 = X0(sQLiteDatabase, pVar);
        if (lX0 != null) {
            return lX0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put("priority", Integer.valueOf(C1.a.a(pVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (pVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(pVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    public long R0() {
        return U0() * V0();
    }

    public SQLiteDatabase S0() {
        final W w7 = this.f25964a;
        Objects.requireNonNull(w7);
        return (SQLiteDatabase) F1(new d() { // from class: z1.E
            @Override // z1.M.d
            public final Object a() {
                return w7.getWritableDatabase();
            }
        }, new b() { // from class: z1.F
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.f1((Throwable) obj);
            }
        });
    }

    public final C2746b T0() {
        return C2746b.b().b(C2749e.c().b(R0()).c(AbstractC2860e.f26004a.f()).a()).a();
    }

    public final long U0() {
        return S0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    public final long V0() {
        return S0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    public final C2750f W0() {
        final long jA = this.f25965b.a();
        return (C2750f) Y0(new b() { // from class: z1.C
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.i1(jA, (SQLiteDatabase) obj);
            }
        });
    }

    public final Long X0(SQLiteDatabase sQLiteDatabase, r1.p pVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(pVar.b(), String.valueOf(C1.a.a(pVar.d()))));
        if (pVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(pVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) I1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: z1.n
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.j1((Cursor) obj);
            }
        });
    }

    public Object Y0(b bVar) {
        SQLiteDatabase sQLiteDatabaseS0 = S0();
        sQLiteDatabaseS0.beginTransaction();
        try {
            Object objApply = bVar.apply(sQLiteDatabaseS0);
            sQLiteDatabaseS0.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseS0.endTransaction();
        }
    }

    @Override // z1.InterfaceC2859d
    public void Z(final r1.p pVar, final long j7) {
        Y0(new b() { // from class: z1.p
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.y1(j7, pVar, (SQLiteDatabase) obj);
            }
        });
    }

    public final boolean Z0() {
        return U0() * V0() >= this.f25967d.f();
    }

    public final List a1(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            AbstractC2866k abstractC2866k = (AbstractC2866k) listIterator.next();
            if (map.containsKey(Long.valueOf(abstractC2866k.c()))) {
                i.a aVarP = abstractC2866k.b().p();
                for (c cVar : (Set) map.get(Long.valueOf(abstractC2866k.c()))) {
                    aVarP.c(cVar.f25969a, cVar.f25970b);
                }
                listIterator.set(AbstractC2866k.a(abstractC2866k.c(), abstractC2866k.d(), aVarP.d()));
            }
        }
        return list;
    }

    public final /* synthetic */ Object b1(Cursor cursor) {
        while (cursor.moveToNext()) {
            i(cursor.getInt(0), C2747c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    public final /* synthetic */ Integer c1(long j7, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j7)};
        I1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: z1.s
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return this.f26020a.b1((Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f25964a.close();
    }

    @Override // z1.InterfaceC2859d
    public boolean g0(final r1.p pVar) {
        return ((Boolean) Y0(new b() { // from class: z1.o
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return this.f26012a.k1(pVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    @Override // A1.b
    public Object h(b.a aVar) {
        SQLiteDatabase sQLiteDatabaseS0 = S0();
        P0(sQLiteDatabaseS0);
        try {
            Object objA = aVar.a();
            sQLiteDatabaseS0.setTransactionSuccessful();
            return objA;
        } finally {
            sQLiteDatabaseS0.endTransaction();
        }
    }

    @Override // z1.InterfaceC2858c
    public void i(final long j7, final C2747c.b bVar, final String str) {
        Y0(new b() { // from class: z1.r
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.x1(str, bVar, j7, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // z1.InterfaceC2859d
    public int j() {
        final long jA = this.f25965b.a() - this.f25967d.c();
        return ((Integer) Y0(new b() { // from class: z1.J
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return this.f25958a.c1(jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    public final /* synthetic */ Boolean k1(r1.p pVar, SQLiteDatabase sQLiteDatabase) {
        Long lX0 = X0(sQLiteDatabase, pVar);
        return lX0 == null ? Boolean.FALSE : (Boolean) I1(S0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lX0.toString()}), new b() { // from class: z1.u
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    @Override // z1.InterfaceC2859d
    public void l(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            S0().compileStatement("DELETE FROM events WHERE _id in " + H1(iterable)).execute();
        }
    }

    @Override // z1.InterfaceC2859d
    public void l0(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + H1(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            Y0(new b() { // from class: z1.L
                @Override // z1.M.b
                public final Object apply(Object obj) {
                    return this.f25960a.v1(str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    public final /* synthetic */ List n1(r1.p pVar, SQLiteDatabase sQLiteDatabase) {
        List listA1 = A1(sQLiteDatabase, pVar, this.f25967d.d());
        for (EnumC2294f enumC2294f : EnumC2294f.values()) {
            if (enumC2294f != pVar.d()) {
                int iD = this.f25967d.d() - listA1.size();
                if (iD <= 0) {
                    break;
                }
                listA1.addAll(A1(sQLiteDatabase, pVar.f(enumC2294f), iD));
            }
        }
        return a1(listA1, B1(sQLiteDatabase, listA1));
    }

    public final /* synthetic */ C2745a o1(Map map, C2745a.C0377a c0377a, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            C2747c.b bVarO0 = O0(cursor.getInt(1));
            long j7 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(C2747c.c().c(bVarO0).b(j7).a());
        }
        D1(c0377a, map);
        return c0377a.e(W0()).d(T0()).c((String) this.f25968e.get()).b();
    }

    public final /* synthetic */ C2745a p1(String str, final Map map, final C2745a.C0377a c0377a, SQLiteDatabase sQLiteDatabase) {
        return (C2745a) I1(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: z1.A
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return this.f25949a.o1(map, c0377a, (Cursor) obj);
            }
        });
    }

    public final /* synthetic */ Object q1(List list, r1.p pVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j7 = cursor.getLong(0);
            boolean z7 = cursor.getInt(7) != 0;
            i.a aVarO = r1.i.a().n(cursor.getString(1)).i(cursor.getLong(2)).o(cursor.getLong(3));
            if (z7) {
                aVarO.h(new r1.h(G1(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarO.h(new r1.h(G1(cursor.getString(4)), E1(j7)));
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
            list.add(AbstractC2866k.a(j7, pVar, aVarO.d()));
        }
        return null;
    }

    public final /* synthetic */ Long s1(r1.i iVar, r1.p pVar, SQLiteDatabase sQLiteDatabase) {
        if (Z0()) {
            i(1L, C2747c.b.CACHE_FULL, iVar.n());
            return -1L;
        }
        long jQ0 = Q0(sQLiteDatabase, pVar);
        int iE = this.f25967d.e();
        byte[] bArrA = iVar.e().a();
        boolean z7 = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jQ0));
        contentValues.put("transport_name", iVar.n());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.o()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
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
            for (int i7 = 1; i7 <= iCeil; i7++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i7 - 1) * iE, Math.min(i7 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i7));
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

    public final /* synthetic */ Object u1(Cursor cursor) {
        while (cursor.moveToNext()) {
            i(cursor.getInt(0), C2747c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    public final /* synthetic */ Object v1(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        I1(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: z1.v
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return this.f26025a.u1((Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    @Override // z1.InterfaceC2859d
    public long w0(r1.p pVar) {
        return ((Long) I1(S0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(C1.a.a(pVar.d()))}), new b() { // from class: z1.H
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.g1((Cursor) obj);
            }
        })).longValue();
    }

    @Override // z1.InterfaceC2859d
    public Iterable x(final r1.p pVar) {
        return (Iterable) Y0(new b() { // from class: z1.m
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return this.f26010a.n1(pVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // z1.InterfaceC2859d
    public Iterable y() {
        return (Iterable) Y0(new b() { // from class: z1.G
            @Override // z1.M.b
            public final Object apply(Object obj) {
                return M.l1((SQLiteDatabase) obj);
            }
        });
    }

    public final /* synthetic */ Object z1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f25965b.a()).execute();
        return null;
    }
}

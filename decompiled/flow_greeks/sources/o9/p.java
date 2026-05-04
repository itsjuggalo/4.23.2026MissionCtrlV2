package o9;

import android.content.Context;
import android.os.Build;
import cd.h0;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DateRetargetClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import p1.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f.a f17687b = p1.i.f("fire-global");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f.a f17688c = p1.i.f("fire-count");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f.a f17689d = p1.i.g("last-used-date");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u8.c f17690a;

    public p(Context context, String str) {
        this.f17690a = new u8.c(context, "FirebaseHeartBeat" + str);
    }

    public static /* synthetic */ h0 a(long j10, p1.c cVar) {
        cVar.j(f17687b, Long.valueOf(j10));
        return null;
    }

    public static /* synthetic */ h0 b(p pVar, String str, String str2, f.a aVar, p1.c cVar) {
        pVar.getClass();
        f.a aVar2 = f17689d;
        if (((String) u8.d.a(cVar, aVar2, "")).equals(str)) {
            f.a aVarI = pVar.i(cVar, str);
            if (aVarI == null || aVarI.a().equals(str2)) {
                return null;
            }
            pVar.q(cVar, aVar, str);
            return null;
        }
        f.a aVar3 = f17688c;
        long jLongValue = ((Long) u8.d.a(cVar, aVar3, 0L)).longValue();
        if (jLongValue + 1 == 30) {
            jLongValue = pVar.e(cVar);
        }
        HashSet hashSet = new HashSet((Collection) u8.d.a(cVar, aVar, new HashSet()));
        hashSet.add(str);
        cVar.j(aVar, hashSet);
        cVar.j(aVar3, Long.valueOf(jLongValue + 1));
        cVar.j(aVar2, str);
        return null;
    }

    public static /* synthetic */ h0 c(p pVar, p1.c cVar) {
        pVar.getClass();
        long j10 = 0;
        for (Map.Entry entry : cVar.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                f.a aVar = (f.a) entry.getKey();
                Set set = (Set) entry.getValue();
                String strH = pVar.h(System.currentTimeMillis());
                if (set.contains(strH)) {
                    cVar.j(aVar, com.google.android.gms.measurement.internal.c.a(new Object[]{strH}));
                    j10++;
                } else {
                    cVar.i(aVar);
                }
            }
        }
        if (j10 == 0) {
            cVar.i(f17688c);
            return null;
        }
        cVar.j(f17688c, Long.valueOf(j10));
        return null;
    }

    public static /* synthetic */ h0 d(p pVar, String str, p1.c cVar) {
        pVar.getClass();
        cVar.j(f17689d, str);
        pVar.l(cVar, str);
        return null;
    }

    public final synchronized long e(p1.c cVar) {
        long j10;
        try {
            long jLongValue = ((Long) u8.d.a(cVar, f17688c, 0L)).longValue();
            String strA = "";
            Set hashSet = new HashSet();
            String str = null;
            for (Map.Entry entry : cVar.a().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set<String> set = (Set) entry.getValue();
                    for (String str2 : set) {
                        if (str == null || str.compareTo(str2) > 0) {
                            strA = ((f.a) entry.getKey()).a();
                            hashSet = set;
                            str = str2;
                        }
                    }
                }
            }
            HashSet hashSet2 = new HashSet(hashSet);
            hashSet2.remove(str);
            cVar.j(p1.i.h(strA), hashSet2);
            j10 = jLongValue - 1;
            cVar.j(f17688c, Long.valueOf(j10));
        } catch (Throwable th) {
            throw th;
        }
        return j10;
    }

    public synchronized void f() {
        this.f17690a.g(new pd.k() { // from class: o9.m
            @Override // pd.k
            public final Object invoke(Object obj) {
                return p.c(this.f17683a, (p1.c) obj);
            }
        });
    }

    public synchronized List g() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            String strH = h(System.currentTimeMillis());
            for (Map.Entry entry : this.f17690a.h().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(strH);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(q.a(((f.a) entry.getKey()).a(), new ArrayList(hashSet)));
                    }
                }
            }
            p(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized String h(long j10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateRetargetClass.toInstant(new Date(j10)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j10));
    }

    public final synchronized f.a i(p1.c cVar, String str) {
        for (Map.Entry entry : cVar.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return p1.i.h(((f.a) entry.getKey()).a());
                    }
                }
            }
        }
        return null;
    }

    public synchronized boolean j(long j10, long j11) {
        return h(j10).equals(h(j11));
    }

    public synchronized void k() {
        final String strH = h(System.currentTimeMillis());
        this.f17690a.g(new pd.k() { // from class: o9.n
            @Override // pd.k
            public final Object invoke(Object obj) {
                return p.d(this.f17684a, strH, (p1.c) obj);
            }
        });
    }

    public final synchronized void l(p1.c cVar, String str) {
        try {
            f.a aVarI = i(cVar, str);
            if (aVarI == null) {
                return;
            }
            HashSet hashSet = new HashSet((Collection) u8.d.a(cVar, aVarI, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                cVar.i(aVarI);
            } else {
                cVar.j(aVarI, hashSet);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean m(long j10) {
        return n(f17687b, j10);
    }

    public synchronized boolean n(f.a aVar, long j10) {
        if (j(((Long) this.f17690a.j(aVar, -1L)).longValue(), j10)) {
            return false;
        }
        this.f17690a.k(aVar, Long.valueOf(j10));
        return true;
    }

    public synchronized void o(long j10, final String str) {
        final String strH = h(j10);
        final f.a aVarH = p1.i.h(str);
        this.f17690a.g(new pd.k() { // from class: o9.l
            @Override // pd.k
            public final Object invoke(Object obj) {
                return p.b(this.f17679a, strH, str, aVarH, (p1.c) obj);
            }
        });
    }

    public synchronized void p(final long j10) {
        this.f17690a.g(new pd.k() { // from class: o9.o
            @Override // pd.k
            public final Object invoke(Object obj) {
                return p.a(j10, (p1.c) obj);
            }
        });
    }

    public final synchronized void q(p1.c cVar, f.a aVar, String str) {
        l(cVar, str);
        HashSet hashSet = new HashSet((Collection) u8.d.a(cVar, aVar, new HashSet()));
        hashSet.add(str);
        cVar.j(aVar, hashSet);
    }
}

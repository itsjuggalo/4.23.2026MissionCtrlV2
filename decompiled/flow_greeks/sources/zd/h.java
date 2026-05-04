package zd;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25729a = b.a(c.f25686a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f25730b = b.a(d.f25702a);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25731c = b.a(e.f25711a);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f25732d = b.a(f.f25718a);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f25733e = b.a(g.f25723a);

    public static final wd.q a(Class it) {
        kotlin.jvm.internal.t.f(it, "it");
        return xd.c.b(k(it), dd.r.k(), false, dd.r.k());
    }

    public static final ConcurrentHashMap b(Class it) {
        kotlin.jvm.internal.t.f(it, "it");
        return new ConcurrentHashMap();
    }

    public static final wd.q c(Class it) {
        kotlin.jvm.internal.t.f(it, "it");
        return xd.c.b(k(it), dd.r.k(), true, dd.r.k());
    }

    public static final w0 d(Class it) {
        kotlin.jvm.internal.t.f(it, "it");
        return new w0(it);
    }

    public static final u1 e(Class it) {
        kotlin.jvm.internal.t.f(it, "it");
        return new u1(it);
    }

    public static final w0 k(Class jClass) {
        kotlin.jvm.internal.t.f(jClass, "jClass");
        Object objA = f25729a.a(jClass);
        kotlin.jvm.internal.t.d(objA, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return (w0) objA;
    }

    public static final wd.g l(Class jClass) {
        kotlin.jvm.internal.t.f(jClass, "jClass");
        return (wd.g) f25730b.a(jClass);
    }
}

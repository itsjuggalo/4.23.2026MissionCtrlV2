package L5;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: renamed from: L5.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0661h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0647a f5175a = AbstractC0649b.a(C0651c.f5145a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0647a f5176b = AbstractC0649b.a(C0653d.f5148a);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractC0647a f5177c = AbstractC0649b.a(C0655e.f5162a);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC0647a f5178d = AbstractC0649b.a(C0657f.f5167a);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AbstractC0647a f5179e = AbstractC0649b.a(C0659g.f5172a);

    public static final I5.q a(Class it) {
        AbstractC2304t.f(it, "it");
        return J5.c.b(k(it), AbstractC2595q.i(), false, AbstractC2595q.i());
    }

    public static final ConcurrentHashMap b(Class it) {
        AbstractC2304t.f(it, "it");
        return new ConcurrentHashMap();
    }

    public static final I5.q c(Class it) {
        AbstractC2304t.f(it, "it");
        return J5.c.b(k(it), AbstractC2595q.i(), true, AbstractC2595q.i());
    }

    public static final X d(Class it) {
        AbstractC2304t.f(it, "it");
        return new X(it);
    }

    public static final C0689v0 e(Class it) {
        AbstractC2304t.f(it, "it");
        return new C0689v0(it);
    }

    public static final X k(Class jClass) {
        AbstractC2304t.f(jClass, "jClass");
        Object objA = f5175a.a(jClass);
        AbstractC2304t.d(objA, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return (X) objA;
    }

    public static final I5.g l(Class jClass) {
        AbstractC2304t.f(jClass, "jClass");
        return (I5.g) f5176b.a(jClass);
    }
}

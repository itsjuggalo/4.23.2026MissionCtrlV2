package p5;

import kotlin.jvm.internal.AbstractC2148j;
import p5.Q3;

/* JADX INFO: loaded from: classes2.dex */
public final class Q3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f21679f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f21682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f21683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f21684e;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public static final E5.E c(Q5.k result, E5.p pVar) {
            kotlin.jvm.internal.r.f(result, "$result");
            result.invoke(new Q3(pVar.j()));
            return E5.E.f1657a;
        }

        public final Q5.k b(final Q5.k result) {
            kotlin.jvm.internal.r.f(result, "result");
            return new Q5.k() { // from class: p5.P3
                @Override // Q5.k
                public final Object invoke(Object obj) {
                    return Q3.a.c(result, (E5.p) obj);
                }
            };
        }

        public final void d(Object obj, Object callback) {
            kotlin.jvm.internal.r.f(callback, "callback");
            ((Q5.k) kotlin.jvm.internal.L.b(callback, 1)).invoke(E5.p.a(E5.p.b(obj)));
        }

        public a() {
        }
    }

    public Q3(Object obj) {
        this.f21680a = obj;
        this.f21681b = E5.p.g(obj) ? null : obj;
        this.f21682c = E5.p.e(obj);
        this.f21683d = E5.p.h(obj);
        this.f21684e = E5.p.g(obj);
    }

    public static final Q5.k a(Q5.k kVar) {
        return f21679f.b(kVar);
    }

    public static final void e(Object obj, Object obj2) {
        f21679f.d(obj, obj2);
    }

    public final Throwable b() {
        return this.f21682c;
    }

    public final Object c() {
        return this.f21681b;
    }

    public final boolean d() {
        return this.f21684e;
    }
}

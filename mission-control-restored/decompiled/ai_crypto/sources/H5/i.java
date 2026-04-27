package H5;

import E5.p;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import v.AbstractC2759b;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements d, J5.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f2672b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2673c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "result");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2674a;
    private volatile Object result;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public i(d delegate, Object obj) {
        r.f(delegate, "delegate");
        this.f2674a = delegate;
        this.result = obj;
    }

    public final Object a() throws Throwable {
        Object obj = this.result;
        I5.a aVar = I5.a.f3044b;
        if (obj == aVar) {
            if (AbstractC2759b.a(f2673c, this, aVar, I5.c.e())) {
                return I5.c.e();
            }
            obj = this.result;
        }
        if (obj == I5.a.f3045c) {
            return I5.c.e();
        }
        if (obj instanceof p.b) {
            throw ((p.b) obj).f1683a;
        }
        return obj;
    }

    @Override // J5.e
    public J5.e getCallerFrame() {
        d dVar = this.f2674a;
        if (dVar instanceof J5.e) {
            return (J5.e) dVar;
        }
        return null;
    }

    @Override // H5.d
    public g getContext() {
        return this.f2674a.getContext();
    }

    @Override // H5.d
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            I5.a aVar = I5.a.f3044b;
            if (obj2 == aVar) {
                if (AbstractC2759b.a(f2673c, this, aVar, obj)) {
                    return;
                }
            } else {
                if (obj2 != I5.c.e()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (AbstractC2759b.a(f2673c, this, I5.c.e(), I5.a.f3045c)) {
                    this.f2674a.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.f2674a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(d delegate) {
        this(delegate, I5.a.f3044b);
        r.f(delegate, "delegate");
    }
}

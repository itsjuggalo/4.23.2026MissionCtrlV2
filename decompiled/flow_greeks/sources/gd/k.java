package gd;

import cd.r;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements e, id.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10532b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10533c = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "result");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f10534a;
    private volatile Object result;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public k(e delegate, Object obj) {
        t.f(delegate, "delegate");
        this.f10534a = delegate;
        this.result = obj;
    }

    public final Object a() throws Throwable {
        Object obj = this.result;
        hd.a aVar = hd.a.f11290b;
        if (obj == aVar) {
            if (y.b.a(f10533c, this, aVar, hd.c.f())) {
                return hd.c.f();
            }
            obj = this.result;
        }
        if (obj == hd.a.f11291c) {
            return hd.c.f();
        }
        if (obj instanceof r.b) {
            throw ((r.b) obj).f3872a;
        }
        return obj;
    }

    @Override // id.e
    public id.e getCallerFrame() {
        e eVar = this.f10534a;
        if (eVar instanceof id.e) {
            return (id.e) eVar;
        }
        return null;
    }

    @Override // gd.e
    public i getContext() {
        return this.f10534a.getContext();
    }

    @Override // gd.e
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            hd.a aVar = hd.a.f11290b;
            if (obj2 == aVar) {
                if (y.b.a(f10533c, this, aVar, obj)) {
                    return;
                }
            } else {
                if (obj2 != hd.c.f()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (y.b.a(f10533c, this, hd.c.f(), hd.a.f11291c)) {
                    this.f10534a.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.f10534a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(e delegate) {
        this(delegate, hd.a.f11290b);
        t.f(delegate, "delegate");
    }
}

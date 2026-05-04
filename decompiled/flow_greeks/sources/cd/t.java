package cd;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements k, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3873d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f3874e = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Function0 f3875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f3876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3877c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public t(Function0 initializer) {
        kotlin.jvm.internal.t.f(initializer, "initializer");
        this.f3875a = initializer;
        d0 d0Var = d0.f3845a;
        this.f3876b = d0Var;
        this.f3877c = d0Var;
    }

    @Override // cd.k
    public boolean d() {
        return this.f3876b != d0.f3845a;
    }

    @Override // cd.k
    public Object getValue() {
        Object obj = this.f3876b;
        d0 d0Var = d0.f3845a;
        if (obj != d0Var) {
            return obj;
        }
        Function0 function0 = this.f3875a;
        if (function0 != null) {
            Object objInvoke = function0.invoke();
            if (y.b.a(f3874e, this, d0Var, objInvoke)) {
                this.f3875a = null;
                return objInvoke;
            }
        }
        return this.f3876b;
    }

    public String toString() {
        return d() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}

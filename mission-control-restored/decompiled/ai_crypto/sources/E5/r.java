package E5;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import v.AbstractC2759b;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements j, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1684d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1685e = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Function0 f1686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f1687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1688c;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public r(Function0 initializer) {
        kotlin.jvm.internal.r.f(initializer, "initializer");
        this.f1686a = initializer;
        A a7 = A.f1651a;
        this.f1687b = a7;
        this.f1688c = a7;
    }

    @Override // E5.j
    public boolean d() {
        return this.f1687b != A.f1651a;
    }

    @Override // E5.j
    public Object getValue() {
        Object obj = this.f1687b;
        A a7 = A.f1651a;
        if (obj != a7) {
            return obj;
        }
        Function0 function0 = this.f1686a;
        if (function0 != null) {
            Object objInvoke = function0.invoke();
            if (AbstractC2759b.a(f1685e, this, a7, objInvoke)) {
                this.f1686a = null;
                return objInvoke;
            }
        }
        return this.f1687b;
    }

    public String toString() {
        return d() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}

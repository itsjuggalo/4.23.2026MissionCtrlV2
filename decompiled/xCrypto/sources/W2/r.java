package W2;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements j, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5490d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5491e = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Function0 f5492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f5493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5494c;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public r(Function0 initializer) {
        kotlin.jvm.internal.r.f(initializer, "initializer");
        this.f5492a = initializer;
        A a4 = A.f5457a;
        this.f5493b = a4;
        this.f5494c = a4;
    }

    @Override // W2.j
    public Object getValue() {
        Object obj = this.f5493b;
        A a4 = A.f5457a;
        if (obj != a4) {
            return obj;
        }
        Function0 function0 = this.f5492a;
        if (function0 != null) {
            Object objInvoke = function0.invoke();
            if (androidx.concurrent.futures.b.a(f5491e, this, a4, objInvoke)) {
                this.f5492a = null;
                return objInvoke;
            }
        }
        return this.f5493b;
    }

    @Override // W2.j
    public boolean isInitialized() {
        return this.f5493b != A.f5457a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}

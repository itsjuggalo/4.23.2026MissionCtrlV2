package cd;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements k, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0 f3878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f3879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3880c;

    public u(Function0 initializer, Object obj) {
        kotlin.jvm.internal.t.f(initializer, "initializer");
        this.f3878a = initializer;
        this.f3879b = d0.f3845a;
        this.f3880c = obj == null ? this : obj;
    }

    @Override // cd.k
    public boolean d() {
        return this.f3879b != d0.f3845a;
    }

    @Override // cd.k
    public Object getValue() {
        Object objInvoke;
        Object obj = this.f3879b;
        d0 d0Var = d0.f3845a;
        if (obj != d0Var) {
            return obj;
        }
        synchronized (this.f3880c) {
            objInvoke = this.f3879b;
            if (objInvoke == d0Var) {
                Function0 function0 = this.f3878a;
                kotlin.jvm.internal.t.c(function0);
                objInvoke = function0.invoke();
                this.f3879b = objInvoke;
                this.f3878a = null;
            }
        }
        return objInvoke;
    }

    public String toString() {
        return d() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ u(Function0 function0, Object obj, int i10, kotlin.jvm.internal.k kVar) {
        this(function0, (i10 & 2) != 0 ? null : obj);
    }
}

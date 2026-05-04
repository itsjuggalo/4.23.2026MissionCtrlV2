package cd;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements k, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0 f3859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f3860b;

    public i0(Function0 initializer) {
        kotlin.jvm.internal.t.f(initializer, "initializer");
        this.f3859a = initializer;
        this.f3860b = d0.f3845a;
    }

    @Override // cd.k
    public boolean d() {
        return this.f3860b != d0.f3845a;
    }

    @Override // cd.k
    public Object getValue() {
        if (this.f3860b == d0.f3845a) {
            Function0 function0 = this.f3859a;
            kotlin.jvm.internal.t.c(function0);
            this.f3860b = function0.invoke();
            this.f3859a = null;
        }
        return this.f3860b;
    }

    public String toString() {
        return d() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}

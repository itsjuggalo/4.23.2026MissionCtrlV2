package E5;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class F implements j, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0 f1658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1659b;

    public F(Function0 initializer) {
        kotlin.jvm.internal.r.f(initializer, "initializer");
        this.f1658a = initializer;
        this.f1659b = A.f1651a;
    }

    @Override // E5.j
    public boolean d() {
        return this.f1659b != A.f1651a;
    }

    @Override // E5.j
    public Object getValue() {
        if (this.f1659b == A.f1651a) {
            Function0 function0 = this.f1658a;
            kotlin.jvm.internal.r.c(function0);
            this.f1659b = function0.invoke();
            this.f1658a = null;
        }
        return this.f1659b;
    }

    public String toString() {
        return d() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}

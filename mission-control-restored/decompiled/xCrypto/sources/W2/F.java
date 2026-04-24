package W2;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class F implements j, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0 f5464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5465b;

    public F(Function0 initializer) {
        kotlin.jvm.internal.r.f(initializer, "initializer");
        this.f5464a = initializer;
        this.f5465b = A.f5457a;
    }

    @Override // W2.j
    public Object getValue() {
        if (this.f5465b == A.f5457a) {
            Function0 function0 = this.f5464a;
            kotlin.jvm.internal.r.c(function0);
            this.f5465b = function0.invoke();
            this.f5464a = null;
        }
        return this.f5465b;
    }

    @Override // W2.j
    public boolean isInitialized() {
        return this.f5465b != A.f5457a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}

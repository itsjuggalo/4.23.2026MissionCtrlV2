package o5;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o5.I, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2471I implements InterfaceC2483k, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0 f21957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f21958b;

    public C2471I(Function0 initializer) {
        AbstractC2304t.f(initializer, "initializer");
        this.f21957a = initializer;
        this.f21958b = C2466D.f21950a;
    }

    @Override // o5.InterfaceC2483k
    public boolean e() {
        return this.f21958b != C2466D.f21950a;
    }

    @Override // o5.InterfaceC2483k
    public Object getValue() {
        if (this.f21958b == C2466D.f21950a) {
            Function0 function0 = this.f21957a;
            AbstractC2304t.c(function0);
            this.f21958b = function0.invoke();
            this.f21957a = null;
        }
        return this.f21958b;
    }

    public String toString() {
        return e() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}

package H5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    public static final void a(boolean z7, Number step) {
        AbstractC2304t.f(step, "step");
        if (z7) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + com.amazon.a.a.o.c.a.b.f14112a);
    }
}

package W5;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {
    public static final void a(boolean z7, Number step) {
        r.f(step, "step");
        if (z7) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + com.amazon.a.a.o.c.a.b.f10001a);
    }
}

package o3;

import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: o3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1680k {
    public static final void a(boolean z4, Number step) {
        r.f(step, "step");
        if (z4) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + com.amazon.a.a.o.c.a.b.f8816a);
    }
}

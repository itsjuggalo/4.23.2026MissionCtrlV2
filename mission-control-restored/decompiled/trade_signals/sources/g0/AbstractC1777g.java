package g0;

import g0.AbstractC1776f;
import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: g0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1777g {
    public static final AbstractC1776f a() {
        return new C1773c(null, true, 1, null);
    }

    public static final C1773c b(AbstractC1776f.b... pairs) {
        AbstractC2304t.f(pairs, "pairs");
        C1773c c1773c = new C1773c(null, false, 1, null);
        c1773c.h((AbstractC1776f.b[]) Arrays.copyOf(pairs, pairs.length));
        return c1773c;
    }
}

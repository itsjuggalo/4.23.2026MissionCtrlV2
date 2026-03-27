package g0;

import g0.f;
import java.util.Arrays;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static final f a() {
        return new C1631c(null, true, 1, null);
    }

    public static final C1631c b(f.b... pairs) {
        r.f(pairs, "pairs");
        C1631c c1631c = new C1631c(null, false, 1, null);
        c1631c.h((f.b[]) Arrays.copyOf(pairs, pairs.length));
        return c1631c;
    }
}

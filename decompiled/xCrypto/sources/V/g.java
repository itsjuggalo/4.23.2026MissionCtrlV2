package V;

import V.f;
import java.util.Arrays;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static final f a() {
        return new c(null, true, 1, null);
    }

    public static final c b(f.b... pairs) {
        r.f(pairs, "pairs");
        c cVar = new c(null, false, 1, null);
        cVar.h((f.b[]) Arrays.copyOf(pairs, pairs.length));
        return cVar;
    }
}

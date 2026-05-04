package p1;

import java.util.Arrays;
import kotlin.jvm.internal.t;
import p1.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static final f a() {
        return new c(null, true, 1, null);
    }

    public static final c b(f.b... pairs) {
        t.f(pairs, "pairs");
        c cVar = new c(null, false, 1, null);
        cVar.h((f.b[]) Arrays.copyOf(pairs, pairs.length));
        return cVar;
    }
}

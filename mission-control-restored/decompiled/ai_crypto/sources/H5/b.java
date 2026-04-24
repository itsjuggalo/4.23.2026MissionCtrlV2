package H5;

import H5.g;
import Q5.k;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements g.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f2663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g.c f2664b;

    public b(g.c baseKey, k safeCast) {
        r.f(baseKey, "baseKey");
        r.f(safeCast, "safeCast");
        this.f2663a = safeCast;
        this.f2664b = baseKey instanceof b ? ((b) baseKey).f2664b : baseKey;
    }

    public final boolean a(g.c key) {
        r.f(key, "key");
        return key == this || this.f2664b == key;
    }

    public final g.b b(g.b element) {
        r.f(element, "element");
        return (g.b) this.f2663a.invoke(element);
    }
}

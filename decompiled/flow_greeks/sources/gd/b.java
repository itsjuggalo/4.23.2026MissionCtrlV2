package gd;

import gd.i;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pd.k f10526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i.c f10527b;

    public b(i.c baseKey, pd.k safeCast) {
        t.f(baseKey, "baseKey");
        t.f(safeCast, "safeCast");
        this.f10526a = safeCast;
        this.f10527b = baseKey instanceof b ? ((b) baseKey).f10527b : baseKey;
    }

    public final boolean a(i.c key) {
        t.f(key, "key");
        return key == this || this.f10527b == key;
    }

    public final i.b b(i.b element) {
        t.f(element, "element");
        return (i.b) this.f10526a.invoke(element);
    }
}

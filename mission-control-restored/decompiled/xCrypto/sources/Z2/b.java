package Z2;

import Z2.i;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i3.k f6006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i.c f6007b;

    public b(i.c baseKey, i3.k safeCast) {
        r.f(baseKey, "baseKey");
        r.f(safeCast, "safeCast");
        this.f6006a = safeCast;
        this.f6007b = baseKey instanceof b ? ((b) baseKey).f6007b : baseKey;
    }

    public final boolean a(i.c key) {
        r.f(key, "key");
        return key == this || this.f6007b == key;
    }

    public final i.b b(i.b element) {
        r.f(element, "element");
        return (i.b) this.f6006a.invoke(element);
    }
}

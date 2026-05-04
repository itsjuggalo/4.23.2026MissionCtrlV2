package y1;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import y1.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // y1.a
    public Object a(a.b key) {
        t.f(key, "key");
        return b().get(key);
    }

    public final void c(a.b key, Object obj) {
        t.f(key, "key");
        b().put(key, obj);
    }

    public b(a initialExtras) {
        t.f(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    public /* synthetic */ b(a aVar, int i10, k kVar) {
        this((i10 & 1) != 0 ? a.C0467a.f25165b : aVar);
    }
}

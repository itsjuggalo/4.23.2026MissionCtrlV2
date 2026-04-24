package s0;

import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import s0.AbstractC2640a;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AbstractC2640a {
    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // s0.AbstractC2640a
    public Object a(AbstractC2640a.b key) {
        r.f(key, "key");
        return b().get(key);
    }

    public final void c(AbstractC2640a.b key, Object obj) {
        r.f(key, "key");
        b().put(key, obj);
    }

    public b(AbstractC2640a initialExtras) {
        r.f(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    public /* synthetic */ b(AbstractC2640a abstractC2640a, int i7, AbstractC2148j abstractC2148j) {
        this((i7 & 1) != 0 ? AbstractC2640a.C0354a.f22964b : abstractC2640a);
    }
}

package p0;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p0.AbstractC2539a;

/* JADX INFO: renamed from: p0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2540b extends AbstractC2539a {
    /* JADX WARN: Multi-variable type inference failed */
    public C2540b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // p0.AbstractC2539a
    public Object a(AbstractC2539a.b key) {
        AbstractC2304t.f(key, "key");
        return b().get(key);
    }

    public final void c(AbstractC2539a.b key, Object obj) {
        AbstractC2304t.f(key, "key");
        b().put(key, obj);
    }

    public C2540b(AbstractC2539a initialExtras) {
        AbstractC2304t.f(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    public /* synthetic */ C2540b(AbstractC2539a abstractC2539a, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? AbstractC2539a.C0373a.f22251b : abstractC2539a);
    }
}

package c0;

import c0.AbstractC0870a;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: c0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0871b extends AbstractC0870a {
    /* JADX WARN: Multi-variable type inference failed */
    public C0871b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c0.AbstractC0870a
    public Object a(AbstractC0870a.b key) {
        r.f(key, "key");
        return b().get(key);
    }

    public final void c(AbstractC0870a.b key, Object obj) {
        r.f(key, "key");
        b().put(key, obj);
    }

    public C0871b(AbstractC0870a initialExtras) {
        r.f(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    public /* synthetic */ C0871b(AbstractC0870a abstractC0870a, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? AbstractC0870a.C0128a.f8302b : abstractC0870a);
    }
}

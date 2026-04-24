package X5;

import h6.InterfaceC1899h;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends AbstractC0992h implements InterfaceC1899h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f9444c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(q6.f fVar, Class klass) {
        super(fVar, null);
        AbstractC2304t.f(klass, "klass");
        this.f9444c = klass;
    }

    @Override // h6.InterfaceC1899h
    public h6.x c() {
        return E.f9397a.a(this.f9444c);
    }
}

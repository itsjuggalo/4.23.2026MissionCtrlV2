package R5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends AbstractC0863u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0 f7256a;

    public r(x0 delegate) {
        AbstractC2304t.f(delegate, "delegate");
        this.f7256a = delegate;
    }

    @Override // R5.AbstractC0863u
    public x0 b() {
        return this.f7256a;
    }

    @Override // R5.AbstractC0863u
    public String c() {
        return b().b();
    }

    @Override // R5.AbstractC0863u
    public AbstractC0863u f() {
        AbstractC0863u abstractC0863uJ = AbstractC0862t.j(b().d());
        AbstractC2304t.e(abstractC0863uJ, "toDescriptorVisibility(...)");
        return abstractC0863uJ;
    }
}

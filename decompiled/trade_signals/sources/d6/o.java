package d6;

import R5.InterfaceC0848e;
import h6.InterfaceC1898g;
import kotlin.jvm.internal.AbstractC2304t;
import z6.C3019c;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C3019c f17021a;

    @Override // d6.n
    public InterfaceC0848e a(InterfaceC1898g javaClass) {
        AbstractC2304t.f(javaClass, "javaClass");
        return b().b(javaClass);
    }

    public final C3019c b() {
        C3019c c3019c = this.f17021a;
        if (c3019c != null) {
            return c3019c;
        }
        AbstractC2304t.s("resolver");
        return null;
    }

    public final void c(C3019c c3019c) {
        AbstractC2304t.f(c3019c, "<set-?>");
        this.f17021a = c3019c;
    }
}

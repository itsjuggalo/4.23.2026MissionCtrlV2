package M2;

import K2.AbstractC0363k;
import M2.InterfaceC0443s;
import com.google.firebase.messaging.Constants;

/* JADX INFO: loaded from: classes3.dex */
public final class G extends C0439p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final K2.l0 f1909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0443s.a f1910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbstractC0363k[] f1911e;

    public G(K2.l0 l0Var, AbstractC0363k[] abstractC0363kArr) {
        this(l0Var, InterfaceC0443s.a.PROCESSED, abstractC0363kArr);
    }

    @Override // M2.C0439p0, M2.r
    public void i(InterfaceC0443s interfaceC0443s) {
        Z1.m.u(!this.f1908b, "already started");
        this.f1908b = true;
        for (AbstractC0363k abstractC0363k : this.f1911e) {
            abstractC0363k.i(this.f1909c);
        }
        interfaceC0443s.b(this.f1909c, this.f1910d, new K2.Z());
    }

    @Override // M2.C0439p0, M2.r
    public void n(Y y4) {
        y4.b(Constants.IPC_BUNDLE_KEY_SEND_ERROR, this.f1909c).b("progress", this.f1910d);
    }

    public G(K2.l0 l0Var, InterfaceC0443s.a aVar, AbstractC0363k[] abstractC0363kArr) {
        Z1.m.e(!l0Var.o(), "error must not be OK");
        this.f1909c = l0Var;
        this.f1910d = aVar;
        this.f1911e = abstractC0363kArr;
    }
}

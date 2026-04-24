package t5;

import r5.AbstractC2595k;
import t5.InterfaceC2698s;

/* JADX INFO: loaded from: classes2.dex */
public final class G extends C2694p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r5.l0 f23460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2698s.a f23461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbstractC2595k[] f23462e;

    public G(r5.l0 l0Var, AbstractC2595k[] abstractC2595kArr) {
        this(l0Var, InterfaceC2698s.a.PROCESSED, abstractC2595kArr);
    }

    @Override // t5.C2694p0, t5.r
    public void k(Y y7) {
        y7.b("error", this.f23460c).b("progress", this.f23461d);
    }

    @Override // t5.C2694p0, t5.r
    public void n(InterfaceC2698s interfaceC2698s) {
        H2.m.u(!this.f23459b, "already started");
        this.f23459b = true;
        for (AbstractC2595k abstractC2595k : this.f23462e) {
            abstractC2595k.i(this.f23460c);
        }
        interfaceC2698s.b(this.f23460c, this.f23461d, new r5.Z());
    }

    public G(r5.l0 l0Var, InterfaceC2698s.a aVar, AbstractC2595k[] abstractC2595kArr) {
        H2.m.e(!l0Var.o(), "error must not be OK");
        this.f23460c = l0Var;
        this.f23461d = aVar;
        this.f23462e = abstractC2595kArr;
    }
}

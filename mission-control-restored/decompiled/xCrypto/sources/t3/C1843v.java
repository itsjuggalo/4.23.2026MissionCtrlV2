package t3;

/* JADX INFO: renamed from: t3.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1843v extends AbstractC1850y0 implements InterfaceC1841u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC1845w f15037e;

    public C1843v(InterfaceC1845w interfaceC1845w) {
        this.f15037e = interfaceC1845w;
    }

    @Override // t3.InterfaceC1841u
    public boolean c(Throwable th) {
        return r().L(th);
    }

    @Override // t3.InterfaceC1841u
    public InterfaceC1846w0 getParent() {
        return r();
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return W2.E.f5463a;
    }

    @Override // t3.E
    public void q(Throwable th) {
        this.f15037e.x(r());
    }
}

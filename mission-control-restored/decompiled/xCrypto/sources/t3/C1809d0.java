package t3;

/* JADX INFO: renamed from: t3.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1809d0 extends AbstractC1826m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1807c0 f14983a;

    public C1809d0(InterfaceC1807c0 interfaceC1807c0) {
        this.f14983a = interfaceC1807c0;
    }

    @Override // t3.AbstractC1828n
    public void a(Throwable th) {
        this.f14983a.dispose();
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return W2.E.f5463a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f14983a + ']';
    }
}

package b6;

/* JADX INFO: renamed from: b6.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1064d0 extends AbstractC1081m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1062c0 f9041a;

    public C1064d0(InterfaceC1062c0 interfaceC1062c0) {
        this.f9041a = interfaceC1062c0;
    }

    @Override // b6.AbstractC1083n
    public void a(Throwable th) {
        this.f9041a.a();
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return E5.E.f1657a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f9041a + ']';
    }
}

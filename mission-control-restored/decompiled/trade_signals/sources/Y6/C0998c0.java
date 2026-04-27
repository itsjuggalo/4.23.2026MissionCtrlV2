package Y6;

/* JADX INFO: renamed from: Y6.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0998c0 implements InterfaceC1013k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0996b0 f9655a;

    public C0998c0(InterfaceC0996b0 interfaceC0996b0) {
        this.f9655a = interfaceC0996b0;
    }

    @Override // Y6.InterfaceC1013k
    public void a(Throwable th) {
        this.f9655a.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f9655a + ']';
    }
}

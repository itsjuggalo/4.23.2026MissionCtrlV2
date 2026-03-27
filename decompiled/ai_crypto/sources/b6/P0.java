package b6;

/* JADX INFO: loaded from: classes2.dex */
public final class P0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f9018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1085o f9019b;

    public P0(I i7, InterfaceC1085o interfaceC1085o) {
        this.f9018a = i7;
        this.f9019b = interfaceC1085o;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9019b.i(this.f9018a, E5.E.f1657a);
    }
}

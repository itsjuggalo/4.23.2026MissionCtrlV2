package k3;

/* JADX INFO: renamed from: k3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2272f implements InterfaceC2267a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2267a f20369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20370b;

    public C2272f(InterfaceC2267a interfaceC2267a, long j8) {
        this.f20369a = interfaceC2267a;
        this.f20370b = j8;
    }

    @Override // k3.InterfaceC2267a
    public long a() {
        return this.f20369a.a() + this.f20370b;
    }

    public void b(long j8) {
        this.f20370b = j8;
    }
}

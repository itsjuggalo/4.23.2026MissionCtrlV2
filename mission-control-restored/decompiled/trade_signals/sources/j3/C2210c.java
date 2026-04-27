package j3;

/* JADX INFO: renamed from: j3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2210c implements InterfaceC2208a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20004a;

    public C2210c(long j8) {
        this.f20004a = j8;
    }

    @Override // j3.InterfaceC2208a
    public boolean a(long j8, long j9) {
        return j8 > this.f20004a || j9 > 1000;
    }

    @Override // j3.InterfaceC2208a
    public long b() {
        return 1000L;
    }

    @Override // j3.InterfaceC2208a
    public float c() {
        return 0.2f;
    }

    @Override // j3.InterfaceC2208a
    public boolean d(long j8) {
        return j8 > 1000;
    }
}

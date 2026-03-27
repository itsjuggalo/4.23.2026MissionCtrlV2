package N1;

/* JADX INFO: renamed from: N1.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0480p implements InterfaceC0456a {
    ED256(-260),
    ED512(-261),
    ED25519(-8),
    ES256(-7),
    ECDH_HKDF_256(-25),
    ES384(-35),
    ES512(-36);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2815a;

    EnumC0480p(int i4) {
        this.f2815a = i4;
    }

    @Override // N1.InterfaceC0456a
    public int a() {
        return this.f2815a;
    }
}

package d2;

/* JADX INFO: renamed from: d2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1443p implements InterfaceC1419a {
    ED256(-260),
    ED512(-261),
    ED25519(-8),
    ES256(-7),
    ECDH_HKDF_256(-25),
    ES384(-35),
    ES512(-36);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13271a;

    EnumC1443p(int i7) {
        this.f13271a = i7;
    }

    @Override // d2.InterfaceC1419a
    public int a() {
        return this.f13271a;
    }
}

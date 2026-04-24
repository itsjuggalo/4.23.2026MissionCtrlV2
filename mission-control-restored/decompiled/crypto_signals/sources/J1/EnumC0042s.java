package J1;

/* JADX INFO: renamed from: J1.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0042s implements InterfaceC0025a {
    /* JADX INFO: Fake field, exist only in values array */
    ED256(-260),
    /* JADX INFO: Fake field, exist only in values array */
    ED512(-261),
    /* JADX INFO: Fake field, exist only in values array */
    ED25519(-8),
    /* JADX INFO: Fake field, exist only in values array */
    ES256(-7),
    /* JADX INFO: Fake field, exist only in values array */
    ECDH_HKDF_256(-25),
    /* JADX INFO: Fake field, exist only in values array */
    ES384(-35),
    /* JADX INFO: Fake field, exist only in values array */
    ES512(-36);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f754a;

    EnumC0042s(int i) {
        this.f754a = i;
    }

    @Override // J1.InterfaceC0025a
    public final int a() {
        return this.f754a;
    }
}

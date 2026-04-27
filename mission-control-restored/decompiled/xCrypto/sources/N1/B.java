package N1;

/* JADX INFO: loaded from: classes.dex */
public enum B implements InterfaceC0456a {
    RS256(-257),
    RS384(-258),
    RS512(-259),
    LEGACY_RS1(-262),
    PS256(-37),
    PS384(-38),
    PS512(-39),
    RS1(-65535);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2728a;

    B(int i4) {
        this.f2728a = i4;
    }

    @Override // N1.InterfaceC0456a
    public int a() {
        return this.f2728a;
    }
}

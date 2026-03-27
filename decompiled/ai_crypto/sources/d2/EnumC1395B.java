package d2;

/* JADX INFO: renamed from: d2.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1395B implements InterfaceC1419a {
    RS256(-257),
    RS384(-258),
    RS512(-259),
    LEGACY_RS1(-262),
    PS256(-37),
    PS384(-38),
    PS512(-39),
    RS1(-65535);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13184a;

    EnumC1395B(int i7) {
        this.f13184a = i7;
    }

    @Override // d2.InterfaceC1419a
    public int a() {
        return this.f13184a;
    }
}

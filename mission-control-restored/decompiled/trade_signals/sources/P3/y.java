package P3;

/* JADX INFO: loaded from: classes.dex */
public final class y implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0786w f6430a;

    public y(C0786w c0786w) {
        this.f6430a = c0786w;
    }

    public static y a(C0786w c0786w) {
        return new y(c0786w);
    }

    public static String c(C0786w c0786w) {
        return (String) E3.d.e(c0786w.b());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c(this.f6430a);
    }
}

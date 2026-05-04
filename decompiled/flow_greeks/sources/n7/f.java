package n7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends m7.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16754c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16755d = false;

    @Override // m7.w
    public final void a(boolean z10) {
        this.f16755d = z10;
    }

    @Override // m7.w
    public final void b(boolean z10) {
        this.f16754c = z10;
    }

    @Override // m7.w
    public final void c(String str, String str2) {
        this.f16752a = str;
        this.f16753b = str2;
    }

    public final String d() {
        return this.f16752a;
    }

    public final String e() {
        return this.f16753b;
    }

    public final boolean f() {
        return this.f16755d;
    }

    public final boolean g() {
        return (this.f16752a == null || this.f16753b == null) ? false : true;
    }

    public final boolean h() {
        return this.f16754c;
    }
}

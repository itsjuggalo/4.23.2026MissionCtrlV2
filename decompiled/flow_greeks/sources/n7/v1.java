package n7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v1 extends r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16867c;

    @Override // n7.r1
    public final r1 a(String str) {
        this.f16866b = str;
        return this;
    }

    @Override // n7.r1
    public final s1 b() {
        return new w1(this.f16865a, this.f16866b, this.f16867c);
    }

    @Override // n7.r1
    public final r1 c(String str) {
        this.f16867c = str;
        return this;
    }

    @Override // n7.r1
    public final r1 d(String str) {
        this.f16865a = str;
        return this;
    }
}

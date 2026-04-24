package I2;

/* JADX INFO: loaded from: classes.dex */
public final class h implements F2.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f638a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f639b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public F2.c f640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f641d;

    public h(f fVar) {
        this.f641d = fVar;
    }

    @Override // F2.g
    public final F2.g c(String str) {
        if (this.f638a) {
            throw new F2.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f638a = true;
        this.f641d.h(this.f640c, str, this.f639b);
        return this;
    }

    @Override // F2.g
    public final F2.g d(boolean z6) {
        if (this.f638a) {
            throw new F2.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f638a = true;
        this.f641d.d(this.f640c, z6 ? 1 : 0, this.f639b);
        return this;
    }
}

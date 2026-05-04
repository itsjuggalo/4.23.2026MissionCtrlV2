package b9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i implements y8.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3059a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3060b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y8.d f3061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f3062d;

    public i(f fVar) {
        this.f3062d = fVar;
    }

    public final void a() {
        if (this.f3059a) {
            throw new y8.c("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f3059a = true;
    }

    public void b(y8.d dVar, boolean z10) {
        this.f3059a = false;
        this.f3061c = dVar;
        this.f3060b = z10;
    }

    @Override // y8.h
    public y8.h f(String str) {
        a();
        this.f3062d.o(this.f3061c, str, this.f3060b);
        return this;
    }

    @Override // y8.h
    public y8.h g(boolean z10) {
        a();
        this.f3062d.l(this.f3061c, z10, this.f3060b);
        return this;
    }
}

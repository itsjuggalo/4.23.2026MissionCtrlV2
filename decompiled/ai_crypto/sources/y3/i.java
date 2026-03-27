package y3;

/* JADX INFO: loaded from: classes.dex */
public class i implements v3.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25667a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25668b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v3.d f25669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f25670d;

    public i(f fVar) {
        this.f25670d = fVar;
    }

    public final void a() {
        if (this.f25667a) {
            throw new v3.c("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f25667a = true;
    }

    public void b(v3.d dVar, boolean z7) {
        this.f25667a = false;
        this.f25669c = dVar;
        this.f25668b = z7;
    }

    @Override // v3.h
    public v3.h f(String str) {
        a();
        this.f25670d.i(this.f25669c, str, this.f25668b);
        return this;
    }

    @Override // v3.h
    public v3.h g(boolean z7) {
        a();
        this.f25670d.o(this.f25669c, z7, this.f25668b);
        return this;
    }
}

package z3;

/* JADX INFO: loaded from: classes.dex */
public class i implements w3.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24758a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24759b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w3.d f24760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f24761d;

    public i(f fVar) {
        this.f24761d = fVar;
    }

    public final void a() {
        if (this.f24758a) {
            throw new w3.c("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f24758a = true;
    }

    public void b(w3.d dVar, boolean z7) {
        this.f24758a = false;
        this.f24760c = dVar;
        this.f24759b = z7;
    }

    @Override // w3.h
    public w3.h e(String str) {
        a();
        this.f24761d.i(this.f24760c, str, this.f24759b);
        return this;
    }

    @Override // w3.h
    public w3.h f(boolean z7) {
        a();
        this.f24761d.o(this.f24760c, z7, this.f24759b);
        return this;
    }
}

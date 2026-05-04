package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final eh.b f9626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9627d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(w writer, eh.b json) {
        super(writer);
        kotlin.jvm.internal.t.f(writer, "writer");
        kotlin.jvm.internal.t.f(json, "json");
        this.f9626c = json;
    }

    @Override // fh.n
    public void b() {
        o(true);
        this.f9627d++;
    }

    @Override // fh.n
    public void c() {
        o(false);
        k("\n");
        int i10 = this.f9627d;
        for (int i11 = 0; i11 < i10; i11++) {
            k(this.f9626c.f().n());
        }
    }

    @Override // fh.n
    public void d() {
        if (a()) {
            o(false);
        } else {
            c();
        }
    }

    @Override // fh.n
    public void p() {
        f(' ');
    }

    @Override // fh.n
    public void q() {
        this.f9627d--;
    }
}

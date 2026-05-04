package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9603c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(w writer, boolean z10) {
        super(writer);
        kotlin.jvm.internal.t.f(writer, "writer");
        this.f9603c = z10;
    }

    @Override // fh.n
    public void n(String value) {
        kotlin.jvm.internal.t.f(value, "value");
        if (this.f9603c) {
            super.n(value);
        } else {
            super.k(value);
        }
    }
}

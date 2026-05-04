package fh;

import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9624c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(w writer, boolean z10) {
        super(writer);
        kotlin.jvm.internal.t.f(writer, "writer");
        this.f9624c = z10;
    }

    @Override // fh.n
    public void e(byte b10) {
        boolean z10 = this.f9624c;
        String strI = cd.x.i(cd.x.b(b10));
        if (z10) {
            n(strI);
        } else {
            k(strI);
        }
    }

    @Override // fh.n
    public void i(int i10) {
        boolean z10 = this.f9624c;
        String string = Long.toString(((long) cd.z.b(i10)) & KeyboardMap.kValueMask, 10);
        if (z10) {
            n(string);
        } else {
            k(string);
        }
    }

    @Override // fh.n
    public void j(long j10) {
        boolean z10 = this.f9624c;
        long jB = cd.b0.b(j10);
        if (z10) {
            n(h.a(jB, 10));
        } else {
            k(h.a(jB, 10));
        }
    }

    @Override // fh.n
    public void l(short s10) {
        boolean z10 = this.f9624c;
        String strI = cd.e0.i(cd.e0.b(s10));
        if (z10) {
            n(strI);
        } else {
            k(strI);
        }
    }
}

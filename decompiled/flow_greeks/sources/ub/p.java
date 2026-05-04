package ub;

import tb.u2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class p implements u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hh.d f22891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22893c;

    public p(hh.d dVar, int i10) {
        this.f22891a = dVar;
        this.f22892b = i10;
    }

    @Override // tb.u2
    public int a() {
        return this.f22892b;
    }

    @Override // tb.u2
    public void b(byte b10) {
        this.f22891a.writeByte(b10);
        this.f22892b--;
        this.f22893c++;
    }

    public hh.d c() {
        return this.f22891a;
    }

    @Override // tb.u2
    public int d() {
        return this.f22893c;
    }

    @Override // tb.u2
    public void write(byte[] bArr, int i10, int i11) {
        this.f22891a.l0(bArr, i10, i11);
        this.f22892b -= i11;
        this.f22893c += i11;
    }

    @Override // tb.u2
    public void release() {
    }
}

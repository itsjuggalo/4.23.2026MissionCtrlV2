package N2;

import M2.V0;

/* JADX INFO: loaded from: classes3.dex */
public class p implements V0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O3.d f3080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3082c;

    public p(O3.d dVar, int i4) {
        this.f3080a = dVar;
        this.f3081b = i4;
    }

    @Override // M2.V0
    public void a(byte[] bArr, int i4, int i5) {
        this.f3080a.o0(bArr, i4, i5);
        this.f3081b -= i5;
        this.f3082c += i5;
    }

    @Override // M2.V0
    public int b() {
        return this.f3081b;
    }

    @Override // M2.V0
    public void c(byte b4) {
        this.f3080a.s(b4);
        this.f3081b--;
        this.f3082c++;
    }

    @Override // M2.V0
    public int d() {
        return this.f3082c;
    }

    public O3.d e() {
        return this.f3080a;
    }

    @Override // M2.V0
    public void release() {
    }
}

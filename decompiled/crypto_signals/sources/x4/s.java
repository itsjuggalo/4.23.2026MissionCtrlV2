package x4;

import u5.C1250g;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1250g f11603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11605c;

    public s(C1250g c1250g, int i) {
        this.f11603a = c1250g;
        this.f11604b = i;
    }

    public final void a(byte[] bArr, int i, int i6) {
        this.f11603a.z(bArr, i, i6);
        this.f11604b -= i6;
        this.f11605c += i6;
    }
}

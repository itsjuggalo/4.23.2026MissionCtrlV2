package qa;

import pa.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19025b;

    public q(String str, int i10) {
        this.f19024a = str;
        this.f19025b = i10;
    }

    @Override // pa.v
    public byte[] a() {
        return this.f19025b == 0 ? pa.o.f18444n : this.f19024a.getBytes(l.f18997e);
    }

    @Override // pa.v
    public int j() {
        return this.f19025b;
    }
}

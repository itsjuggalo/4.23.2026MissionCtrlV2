package q3;

import c4.k;
import i3.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f18784a;

    public b(byte[] bArr) {
        this.f18784a = (byte[]) k.e(bArr);
    }

    @Override // i3.v
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f18784a;
    }

    @Override // i3.v
    public int c() {
        return this.f18784a.length;
    }

    @Override // i3.v
    public Class d() {
        return byte[].class;
    }

    @Override // i3.v
    public void b() {
    }
}

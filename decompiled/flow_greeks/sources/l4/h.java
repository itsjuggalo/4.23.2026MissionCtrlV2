package l4;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.c f15406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f15407b;

    public h(i4.c cVar, byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f15406a = cVar;
        this.f15407b = bArr;
    }

    public byte[] a() {
        return this.f15407b;
    }

    public i4.c b() {
        return this.f15406a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f15406a.equals(hVar.f15406a)) {
            return Arrays.equals(this.f15407b, hVar.f15407b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f15406a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f15407b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f15406a + ", bytes=[...]}";
    }
}

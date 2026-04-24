package a1;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X0.c f6092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f6093b;

    public h(X0.c cVar, byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f6092a = cVar;
        this.f6093b = bArr;
    }

    public byte[] a() {
        return this.f6093b;
    }

    public X0.c b() {
        return this.f6092a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f6092a.equals(hVar.f6092a)) {
            return Arrays.equals(this.f6093b, hVar.f6093b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f6092a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f6093b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f6092a + ", bytes=[...]}";
    }
}

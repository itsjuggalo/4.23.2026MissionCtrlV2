package z1;

import java.util.Arrays;
import w1.C2900c;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2900c f24708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f24709b;

    public h(C2900c c2900c, byte[] bArr) {
        if (c2900c == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f24708a = c2900c;
        this.f24709b = bArr;
    }

    public byte[] a() {
        return this.f24709b;
    }

    public C2900c b() {
        return this.f24708a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f24708a.equals(hVar.f24708a)) {
            return Arrays.equals(this.f24709b, hVar.f24709b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f24708a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f24709b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f24708a + ", bytes=[...]}";
    }
}

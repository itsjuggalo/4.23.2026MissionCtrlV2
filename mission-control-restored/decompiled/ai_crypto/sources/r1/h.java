package r1;

import java.util.Arrays;
import o1.C2291c;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2291c f22427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f22428b;

    public h(C2291c c2291c, byte[] bArr) {
        if (c2291c == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f22427a = c2291c;
        this.f22428b = bArr;
    }

    public byte[] a() {
        return this.f22428b;
    }

    public C2291c b() {
        return this.f22427a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f22427a.equals(hVar.f22427a)) {
            return Arrays.equals(this.f22428b, hVar.f22428b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f22427a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f22428b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f22427a + ", bytes=[...]}";
    }
}

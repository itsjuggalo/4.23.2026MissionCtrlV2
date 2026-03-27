package Y0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V0.c f3573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f3574b;

    public l(V0.c cVar, byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f3573a = cVar;
        this.f3574b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f3573a.equals(lVar.f3573a)) {
            return Arrays.equals(this.f3574b, lVar.f3574b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f3573a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f3574b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f3573a + ", bytes=[...]}";
    }
}

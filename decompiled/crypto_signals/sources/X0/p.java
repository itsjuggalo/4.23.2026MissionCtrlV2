package X0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class p extends C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f3490b;

    public p(byte[] bArr, byte[] bArr2) {
        this.f3489a = bArr;
        this.f3490b = bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C) {
            C c6 = (C) obj;
            boolean z6 = c6 instanceof p;
            if (Arrays.equals(this.f3489a, z6 ? ((p) c6).f3489a : ((p) c6).f3489a)) {
                if (Arrays.equals(this.f3490b, z6 ? ((p) c6).f3490b : ((p) c6).f3490b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.f3489a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f3490b);
    }

    public final String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f3489a) + ", encryptedBlob=" + Arrays.toString(this.f3490b) + "}";
    }
}

package k4;

import java.util.Arrays;
import k4.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14608b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f14609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f14610b;

        @Override // k4.q.a
        public q a() {
            return new g(this.f14609a, this.f14610b);
        }

        @Override // k4.q.a
        public q.a b(byte[] bArr) {
            this.f14609a = bArr;
            return this;
        }

        @Override // k4.q.a
        public q.a c(byte[] bArr) {
            this.f14610b = bArr;
            return this;
        }
    }

    @Override // k4.q
    public byte[] b() {
        return this.f14607a;
    }

    @Override // k4.q
    public byte[] c() {
        return this.f14608b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            boolean z10 = qVar instanceof g;
            if (Arrays.equals(this.f14607a, z10 ? ((g) qVar).f14607a : qVar.b())) {
                if (Arrays.equals(this.f14608b, z10 ? ((g) qVar).f14608b : qVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.f14607a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f14608b);
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f14607a) + ", encryptedBlob=" + Arrays.toString(this.f14608b) + "}";
    }

    public g(byte[] bArr, byte[] bArr2) {
        this.f14607a = bArr;
        this.f14608b = bArr2;
    }
}

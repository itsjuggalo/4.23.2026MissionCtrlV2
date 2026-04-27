package Z0;

import Z0.q;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class g extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f5852b;

    public static final class b extends q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f5853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f5854b;

        @Override // Z0.q.a
        public q a() {
            return new g(this.f5853a, this.f5854b);
        }

        @Override // Z0.q.a
        public q.a b(byte[] bArr) {
            this.f5853a = bArr;
            return this;
        }

        @Override // Z0.q.a
        public q.a c(byte[] bArr) {
            this.f5854b = bArr;
            return this;
        }
    }

    @Override // Z0.q
    public byte[] b() {
        return this.f5851a;
    }

    @Override // Z0.q
    public byte[] c() {
        return this.f5852b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            boolean z4 = qVar instanceof g;
            if (Arrays.equals(this.f5851a, z4 ? ((g) qVar).f5851a : qVar.b())) {
                if (Arrays.equals(this.f5852b, z4 ? ((g) qVar).f5852b : qVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.f5851a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5852b);
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f5851a) + ", encryptedBlob=" + Arrays.toString(this.f5852b) + "}";
    }

    public g(byte[] bArr, byte[] bArr2) {
        this.f5851a = bArr;
        this.f5852b = bArr2;
    }
}

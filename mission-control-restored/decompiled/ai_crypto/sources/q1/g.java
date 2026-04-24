package q1;

import java.util.Arrays;
import q1.q;

/* JADX INFO: loaded from: classes.dex */
public final class g extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f22193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f22194b;

    public static final class b extends q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f22195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f22196b;

        @Override // q1.q.a
        public q a() {
            return new g(this.f22195a, this.f22196b);
        }

        @Override // q1.q.a
        public q.a b(byte[] bArr) {
            this.f22195a = bArr;
            return this;
        }

        @Override // q1.q.a
        public q.a c(byte[] bArr) {
            this.f22196b = bArr;
            return this;
        }
    }

    @Override // q1.q
    public byte[] b() {
        return this.f22193a;
    }

    @Override // q1.q
    public byte[] c() {
        return this.f22194b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        boolean z7 = qVar instanceof g;
        if (Arrays.equals(this.f22193a, z7 ? ((g) qVar).f22193a : qVar.b())) {
            if (Arrays.equals(this.f22194b, z7 ? ((g) qVar).f22194b : qVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.f22193a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f22194b);
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f22193a) + ", encryptedBlob=" + Arrays.toString(this.f22194b) + "}";
    }

    public g(byte[] bArr, byte[] bArr2) {
        this.f22193a = bArr;
        this.f22194b = bArr2;
    }
}

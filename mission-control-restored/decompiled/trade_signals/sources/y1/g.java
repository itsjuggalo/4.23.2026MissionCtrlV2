package y1;

import java.util.Arrays;
import y1.q;

/* JADX INFO: loaded from: classes.dex */
public final class g extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f24346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f24347b;

    public static final class b extends q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f24348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f24349b;

        @Override // y1.q.a
        public q a() {
            return new g(this.f24348a, this.f24349b);
        }

        @Override // y1.q.a
        public q.a b(byte[] bArr) {
            this.f24348a = bArr;
            return this;
        }

        @Override // y1.q.a
        public q.a c(byte[] bArr) {
            this.f24349b = bArr;
            return this;
        }
    }

    public g(byte[] bArr, byte[] bArr2) {
        this.f24346a = bArr;
        this.f24347b = bArr2;
    }

    @Override // y1.q
    public byte[] b() {
        return this.f24346a;
    }

    @Override // y1.q
    public byte[] c() {
        return this.f24347b;
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
        if (Arrays.equals(this.f24346a, z7 ? ((g) qVar).f24346a : qVar.b())) {
            if (Arrays.equals(this.f24347b, z7 ? ((g) qVar).f24347b : qVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.f24346a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f24347b);
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f24346a) + ", encryptedBlob=" + Arrays.toString(this.f24347b) + "}";
    }
}

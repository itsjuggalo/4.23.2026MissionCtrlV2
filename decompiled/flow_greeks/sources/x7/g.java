package x7;

import java.util.Arrays;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends f0.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f24483b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.d.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f24485b;

        @Override // x7.f0.d.b.a
        public f0.d.b a() {
            byte[] bArr;
            String str = this.f24484a;
            if (str != null && (bArr = this.f24485b) != null) {
                return new g(str, bArr);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24484a == null) {
                sb2.append(" filename");
            }
            if (this.f24485b == null) {
                sb2.append(" contents");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.d.b.a
        public f0.d.b.a b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.f24485b = bArr;
            return this;
        }

        @Override // x7.f0.d.b.a
        public f0.d.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.f24484a = str;
            return this;
        }
    }

    @Override // x7.f0.d.b
    public byte[] b() {
        return this.f24483b;
    }

    @Override // x7.f0.d.b
    public String c() {
        return this.f24482a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.d.b) {
            f0.d.b bVar = (f0.d.b) obj;
            if (this.f24482a.equals(bVar.c())) {
                if (Arrays.equals(this.f24483b, bVar instanceof g ? ((g) bVar).f24483b : bVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f24482a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f24483b);
    }

    public String toString() {
        return "File{filename=" + this.f24482a + ", contents=" + Arrays.toString(this.f24483b) + "}";
    }

    public g(String str, byte[] bArr) {
        this.f24482a = str;
        this.f24483b = bArr;
    }
}

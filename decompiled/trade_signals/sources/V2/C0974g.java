package V2;

import V2.F;
import java.util.Arrays;

/* JADX INFO: renamed from: V2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0974g extends F.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f8725b;

    /* JADX INFO: renamed from: V2.g$b */
    public static final class b extends F.d.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f8727b;

        @Override // V2.F.d.b.a
        public F.d.b a() {
            byte[] bArr;
            String str = this.f8726a;
            if (str != null && (bArr = this.f8727b) != null) {
                return new C0974g(str, bArr);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8726a == null) {
                sb.append(" filename");
            }
            if (this.f8727b == null) {
                sb.append(" contents");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.d.b.a
        public F.d.b.a b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.f8727b = bArr;
            return this;
        }

        @Override // V2.F.d.b.a
        public F.d.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.f8726a = str;
            return this;
        }
    }

    public C0974g(String str, byte[] bArr) {
        this.f8724a = str;
        this.f8725b = bArr;
    }

    @Override // V2.F.d.b
    public byte[] b() {
        return this.f8725b;
    }

    @Override // V2.F.d.b
    public String c() {
        return this.f8724a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.d.b)) {
            return false;
        }
        F.d.b bVar = (F.d.b) obj;
        if (this.f8724a.equals(bVar.c())) {
            if (Arrays.equals(this.f8725b, bVar instanceof C0974g ? ((C0974g) bVar).f8725b : bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f8724a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f8725b);
    }

    public String toString() {
        return "File{filename=" + this.f8724a + ", contents=" + Arrays.toString(this.f8725b) + "}";
    }
}

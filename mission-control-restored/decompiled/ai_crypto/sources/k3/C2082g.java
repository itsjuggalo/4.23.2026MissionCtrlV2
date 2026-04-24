package k3;

import java.util.Arrays;
import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2082g extends AbstractC2074F.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f17804b;

    /* JADX INFO: renamed from: k3.g$b */
    public static final class b extends AbstractC2074F.d.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f17806b;

        @Override // k3.AbstractC2074F.d.b.a
        public AbstractC2074F.d.b a() {
            byte[] bArr;
            String str = this.f17805a;
            if (str != null && (bArr = this.f17806b) != null) {
                return new C2082g(str, bArr);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17805a == null) {
                sb.append(" filename");
            }
            if (this.f17806b == null) {
                sb.append(" contents");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.d.b.a
        public AbstractC2074F.d.b.a b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.f17806b = bArr;
            return this;
        }

        @Override // k3.AbstractC2074F.d.b.a
        public AbstractC2074F.d.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.f17805a = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.d.b
    public byte[] b() {
        return this.f17804b;
    }

    @Override // k3.AbstractC2074F.d.b
    public String c() {
        return this.f17803a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.d.b)) {
            return false;
        }
        AbstractC2074F.d.b bVar = (AbstractC2074F.d.b) obj;
        if (this.f17803a.equals(bVar.c())) {
            if (Arrays.equals(this.f17804b, bVar instanceof C2082g ? ((C2082g) bVar).f17804b : bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f17803a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f17804b);
    }

    public String toString() {
        return "File{filename=" + this.f17803a + ", contents=" + Arrays.toString(this.f17804b) + "}";
    }

    public C2082g(String str, byte[] bArr) {
        this.f17803a = str;
        this.f17804b = bArr;
    }
}

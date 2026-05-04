package m4;

import java.util.Arrays;
import m4.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable f15852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f15853b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterable f15854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f15855b;

        @Override // m4.f.a
        public f a() {
            String str = "";
            if (this.f15854a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f15854a, this.f15855b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // m4.f.a
        public f.a b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f15854a = iterable;
            return this;
        }

        @Override // m4.f.a
        public f.a c(byte[] bArr) {
            this.f15855b = bArr;
            return this;
        }
    }

    @Override // m4.f
    public Iterable b() {
        return this.f15852a;
    }

    @Override // m4.f
    public byte[] c() {
        return this.f15853b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f15852a.equals(fVar.b())) {
                if (Arrays.equals(this.f15853b, fVar instanceof a ? ((a) fVar).f15853b : fVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f15852a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f15853b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f15852a + ", extras=" + Arrays.toString(this.f15853b) + "}";
    }

    public a(Iterable iterable, byte[] bArr) {
        this.f15852a = iterable;
        this.f15853b = bArr;
    }
}

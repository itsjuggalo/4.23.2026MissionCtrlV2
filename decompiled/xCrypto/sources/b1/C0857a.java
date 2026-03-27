package b1;

import b1.f;
import java.util.Arrays;

/* JADX INFO: renamed from: b1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0857a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable f8238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f8239b;

    /* JADX INFO: renamed from: b1.a$b */
    public static final class b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterable f8240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f8241b;

        @Override // b1.f.a
        public f a() {
            String str = "";
            if (this.f8240a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new C0857a(this.f8240a, this.f8241b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // b1.f.a
        public f.a b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f8240a = iterable;
            return this;
        }

        @Override // b1.f.a
        public f.a c(byte[] bArr) {
            this.f8241b = bArr;
            return this;
        }
    }

    @Override // b1.f
    public Iterable b() {
        return this.f8238a;
    }

    @Override // b1.f
    public byte[] c() {
        return this.f8239b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f8238a.equals(fVar.b())) {
                if (Arrays.equals(this.f8239b, fVar instanceof C0857a ? ((C0857a) fVar).f8239b : fVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f8238a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f8239b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f8238a + ", extras=" + Arrays.toString(this.f8239b) + "}";
    }

    public C0857a(Iterable iterable, byte[] bArr) {
        this.f8238a = iterable;
        this.f8239b = bArr;
    }
}

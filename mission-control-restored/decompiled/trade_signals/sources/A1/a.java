package A1;

import A1.f;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable f12a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13b;

    public static final class b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterable f14a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f15b;

        @Override // A1.f.a
        public f a() {
            String str = "";
            if (this.f14a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f14a, this.f15b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // A1.f.a
        public f.a b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f14a = iterable;
            return this;
        }

        @Override // A1.f.a
        public f.a c(byte[] bArr) {
            this.f15b = bArr;
            return this;
        }
    }

    public a(Iterable iterable, byte[] bArr) {
        this.f12a = iterable;
        this.f13b = bArr;
    }

    @Override // A1.f
    public Iterable b() {
        return this.f12a;
    }

    @Override // A1.f
    public byte[] c() {
        return this.f13b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f12a.equals(fVar.b())) {
            if (Arrays.equals(this.f13b, fVar instanceof a ? ((a) fVar).f13b : fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f12a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f13b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f12a + ", extras=" + Arrays.toString(this.f13b) + "}";
    }
}

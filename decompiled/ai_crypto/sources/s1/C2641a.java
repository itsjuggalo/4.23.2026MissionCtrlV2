package s1;

import java.util.Arrays;
import s1.f;

/* JADX INFO: renamed from: s1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2641a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable f22966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f22967b;

    /* JADX INFO: renamed from: s1.a$b */
    public static final class b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterable f22968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f22969b;

        @Override // s1.f.a
        public f a() {
            String str = "";
            if (this.f22968a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new C2641a(this.f22968a, this.f22969b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // s1.f.a
        public f.a b(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f22968a = iterable;
            return this;
        }

        @Override // s1.f.a
        public f.a c(byte[] bArr) {
            this.f22969b = bArr;
            return this;
        }
    }

    @Override // s1.f
    public Iterable b() {
        return this.f22966a;
    }

    @Override // s1.f
    public byte[] c() {
        return this.f22967b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f22966a.equals(fVar.b())) {
            if (Arrays.equals(this.f22967b, fVar instanceof C2641a ? ((C2641a) fVar).f22967b : fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f22966a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f22967b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f22966a + ", extras=" + Arrays.toString(this.f22967b) + "}";
    }

    public C2641a(Iterable iterable, byte[] bArr) {
        this.f22966a = iterable;
        this.f22967b = bArr;
    }
}

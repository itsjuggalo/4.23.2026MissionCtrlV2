package a1;

import a1.p;
import java.util.Arrays;

/* JADX INFO: renamed from: a1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0779d extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f6072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final X0.f f6073c;

    /* JADX INFO: renamed from: a1.d$b */
    public static final class b extends p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f6075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public X0.f f6076c;

        @Override // a1.p.a
        public p a() {
            String str = "";
            if (this.f6074a == null) {
                str = " backendName";
            }
            if (this.f6076c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new C0779d(this.f6074a, this.f6075b, this.f6076c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // a1.p.a
        public p.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f6074a = str;
            return this;
        }

        @Override // a1.p.a
        public p.a c(byte[] bArr) {
            this.f6075b = bArr;
            return this;
        }

        @Override // a1.p.a
        public p.a d(X0.f fVar) {
            if (fVar == null) {
                throw new NullPointerException("Null priority");
            }
            this.f6076c = fVar;
            return this;
        }
    }

    @Override // a1.p
    public String b() {
        return this.f6071a;
    }

    @Override // a1.p
    public byte[] c() {
        return this.f6072b;
    }

    @Override // a1.p
    public X0.f d() {
        return this.f6073c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f6071a.equals(pVar.b())) {
                if (Arrays.equals(this.f6072b, pVar instanceof C0779d ? ((C0779d) pVar).f6072b : pVar.c()) && this.f6073c.equals(pVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f6071a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f6072b)) * 1000003) ^ this.f6073c.hashCode();
    }

    public C0779d(String str, byte[] bArr, X0.f fVar) {
        this.f6071a = str;
        this.f6072b = bArr;
        this.f6073c = fVar;
    }
}

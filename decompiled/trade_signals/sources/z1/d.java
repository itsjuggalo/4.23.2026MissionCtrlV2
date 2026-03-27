package z1;

import java.util.Arrays;
import w1.EnumC2903f;
import z1.p;

/* JADX INFO: loaded from: classes.dex */
public final class d extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f24688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnumC2903f f24689c;

    public static final class b extends p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f24691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public EnumC2903f f24692c;

        @Override // z1.p.a
        public p a() {
            String str = "";
            if (this.f24690a == null) {
                str = " backendName";
            }
            if (this.f24692c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f24690a, this.f24691b, this.f24692c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // z1.p.a
        public p.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f24690a = str;
            return this;
        }

        @Override // z1.p.a
        public p.a c(byte[] bArr) {
            this.f24691b = bArr;
            return this;
        }

        @Override // z1.p.a
        public p.a d(EnumC2903f enumC2903f) {
            if (enumC2903f == null) {
                throw new NullPointerException("Null priority");
            }
            this.f24692c = enumC2903f;
            return this;
        }
    }

    public d(String str, byte[] bArr, EnumC2903f enumC2903f) {
        this.f24687a = str;
        this.f24688b = bArr;
        this.f24689c = enumC2903f;
    }

    @Override // z1.p
    public String b() {
        return this.f24687a;
    }

    @Override // z1.p
    public byte[] c() {
        return this.f24688b;
    }

    @Override // z1.p
    public EnumC2903f d() {
        return this.f24689c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f24687a.equals(pVar.b())) {
            if (Arrays.equals(this.f24688b, pVar instanceof d ? ((d) pVar).f24688b : pVar.c()) && this.f24689c.equals(pVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f24687a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f24688b)) * 1000003) ^ this.f24689c.hashCode();
    }
}

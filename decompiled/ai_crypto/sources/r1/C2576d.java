package r1;

import java.util.Arrays;
import o1.EnumC2294f;
import r1.p;

/* JADX INFO: renamed from: r1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2576d extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f22407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnumC2294f f22408c;

    /* JADX INFO: renamed from: r1.d$b */
    public static final class b extends p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f22410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public EnumC2294f f22411c;

        @Override // r1.p.a
        public p a() {
            String str = "";
            if (this.f22409a == null) {
                str = " backendName";
            }
            if (this.f22411c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new C2576d(this.f22409a, this.f22410b, this.f22411c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // r1.p.a
        public p.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f22409a = str;
            return this;
        }

        @Override // r1.p.a
        public p.a c(byte[] bArr) {
            this.f22410b = bArr;
            return this;
        }

        @Override // r1.p.a
        public p.a d(EnumC2294f enumC2294f) {
            if (enumC2294f == null) {
                throw new NullPointerException("Null priority");
            }
            this.f22411c = enumC2294f;
            return this;
        }
    }

    @Override // r1.p
    public String b() {
        return this.f22406a;
    }

    @Override // r1.p
    public byte[] c() {
        return this.f22407b;
    }

    @Override // r1.p
    public EnumC2294f d() {
        return this.f22408c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f22406a.equals(pVar.b())) {
            if (Arrays.equals(this.f22407b, pVar instanceof C2576d ? ((C2576d) pVar).f22407b : pVar.c()) && this.f22408c.equals(pVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f22406a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f22407b)) * 1000003) ^ this.f22408c.hashCode();
    }

    public C2576d(String str, byte[] bArr, EnumC2294f enumC2294f) {
        this.f22406a = str;
        this.f22407b = bArr;
        this.f22408c = enumC2294f;
    }
}

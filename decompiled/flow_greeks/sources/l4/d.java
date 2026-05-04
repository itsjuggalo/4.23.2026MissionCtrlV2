package l4;

import java.util.Arrays;
import l4.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f15386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i4.f f15387c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f15389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public i4.f f15390c;

        @Override // l4.p.a
        public p a() {
            String str = "";
            if (this.f15388a == null) {
                str = " backendName";
            }
            if (this.f15390c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f15388a, this.f15389b, this.f15390c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // l4.p.a
        public p.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f15388a = str;
            return this;
        }

        @Override // l4.p.a
        public p.a c(byte[] bArr) {
            this.f15389b = bArr;
            return this;
        }

        @Override // l4.p.a
        public p.a d(i4.f fVar) {
            if (fVar == null) {
                throw new NullPointerException("Null priority");
            }
            this.f15390c = fVar;
            return this;
        }
    }

    @Override // l4.p
    public String b() {
        return this.f15385a;
    }

    @Override // l4.p
    public byte[] c() {
        return this.f15386b;
    }

    @Override // l4.p
    public i4.f d() {
        return this.f15387c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f15385a.equals(pVar.b())) {
                if (Arrays.equals(this.f15386b, pVar instanceof d ? ((d) pVar).f15386b : pVar.c()) && this.f15387c.equals(pVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f15385a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f15386b)) * 1000003) ^ this.f15387c.hashCode();
    }

    public d(String str, byte[] bArr, i4.f fVar) {
        this.f15385a = str;
        this.f15386b = bArr;
        this.f15387c = fVar;
    }
}

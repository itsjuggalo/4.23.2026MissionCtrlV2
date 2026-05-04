package l4;

import java.util.Arrays;
import java.util.Map;
import l4.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f15356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f15357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f15358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f15359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f15360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f15361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f15362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f15363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f15364j;

    /* JADX INFO: renamed from: l4.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0274b extends i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f15366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f15367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f15368d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f15369e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map f15370f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f15371g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f15372h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f15373i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte[] f15374j;

        @Override // l4.i.a
        public i d() {
            String str = "";
            if (this.f15365a == null) {
                str = " transportName";
            }
            if (this.f15367c == null) {
                str = str + " encodedPayload";
            }
            if (this.f15368d == null) {
                str = str + " eventMillis";
            }
            if (this.f15369e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f15370f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.f15365a, this.f15366b, this.f15367c, this.f15368d.longValue(), this.f15369e.longValue(), this.f15370f, this.f15371g, this.f15372h, this.f15373i, this.f15374j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // l4.i.a
        public Map e() {
            Map map = this.f15370f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // l4.i.a
        public i.a f(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f15370f = map;
            return this;
        }

        @Override // l4.i.a
        public i.a g(Integer num) {
            this.f15366b = num;
            return this;
        }

        @Override // l4.i.a
        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f15367c = hVar;
            return this;
        }

        @Override // l4.i.a
        public i.a i(long j10) {
            this.f15368d = Long.valueOf(j10);
            return this;
        }

        @Override // l4.i.a
        public i.a j(byte[] bArr) {
            this.f15373i = bArr;
            return this;
        }

        @Override // l4.i.a
        public i.a k(byte[] bArr) {
            this.f15374j = bArr;
            return this;
        }

        @Override // l4.i.a
        public i.a l(Integer num) {
            this.f15371g = num;
            return this;
        }

        @Override // l4.i.a
        public i.a m(String str) {
            this.f15372h = str;
            return this;
        }

        @Override // l4.i.a
        public i.a n(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f15365a = str;
            return this;
        }

        @Override // l4.i.a
        public i.a o(long j10) {
            this.f15369e = Long.valueOf(j10);
            return this;
        }
    }

    @Override // l4.i
    public Map c() {
        return this.f15360f;
    }

    @Override // l4.i
    public Integer d() {
        return this.f15356b;
    }

    @Override // l4.i
    public h e() {
        return this.f15357c;
    }

    public boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f15355a.equals(iVar.n()) && ((num = this.f15356b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f15357c.equals(iVar.e()) && this.f15358d == iVar.f() && this.f15359e == iVar.o() && this.f15360f.equals(iVar.c()) && ((num2 = this.f15361g) != null ? num2.equals(iVar.l()) : iVar.l() == null) && ((str = this.f15362h) != null ? str.equals(iVar.m()) : iVar.m() == null)) {
                boolean z10 = iVar instanceof b;
                if (Arrays.equals(this.f15363i, z10 ? ((b) iVar).f15363i : iVar.g())) {
                    if (Arrays.equals(this.f15364j, z10 ? ((b) iVar).f15364j : iVar.h())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // l4.i
    public long f() {
        return this.f15358d;
    }

    @Override // l4.i
    public byte[] g() {
        return this.f15363i;
    }

    @Override // l4.i
    public byte[] h() {
        return this.f15364j;
    }

    public int hashCode() {
        int iHashCode = (this.f15355a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f15356b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f15357c.hashCode()) * 1000003;
        long j10 = this.f15358d;
        int i10 = (iHashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f15359e;
        int iHashCode3 = (((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f15360f.hashCode()) * 1000003;
        Integer num2 = this.f15361g;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.f15362h;
        return ((((iHashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.f15363i)) * 1000003) ^ Arrays.hashCode(this.f15364j);
    }

    @Override // l4.i
    public Integer l() {
        return this.f15361g;
    }

    @Override // l4.i
    public String m() {
        return this.f15362h;
    }

    @Override // l4.i
    public String n() {
        return this.f15355a;
    }

    @Override // l4.i
    public long o() {
        return this.f15359e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f15355a + ", code=" + this.f15356b + ", encodedPayload=" + this.f15357c + ", eventMillis=" + this.f15358d + ", uptimeMillis=" + this.f15359e + ", autoMetadata=" + this.f15360f + ", productId=" + this.f15361g + ", pseudonymousId=" + this.f15362h + ", experimentIdsClear=" + Arrays.toString(this.f15363i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f15364j) + "}";
    }

    public b(String str, Integer num, h hVar, long j10, long j11, Map map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f15355a = str;
        this.f15356b = num;
        this.f15357c = hVar;
        this.f15358d = j10;
        this.f15359e = j11;
        this.f15360f = map;
        this.f15361g = num2;
        this.f15362h = str2;
        this.f15363i = bArr;
        this.f15364j = bArr2;
    }
}

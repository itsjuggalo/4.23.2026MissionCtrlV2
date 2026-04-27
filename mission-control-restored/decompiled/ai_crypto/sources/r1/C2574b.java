package r1;

import java.util.Arrays;
import java.util.Map;
import r1.i;

/* JADX INFO: renamed from: r1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2574b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f22377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f22378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f22379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f22380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f22381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f22382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f22383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f22384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f22385j;

    /* JADX INFO: renamed from: r1.b$b, reason: collision with other inner class name */
    public static final class C0342b extends i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f22387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f22388c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f22389d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f22390e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map f22391f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f22392g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f22393h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f22394i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte[] f22395j;

        @Override // r1.i.a
        public i d() {
            String str = "";
            if (this.f22386a == null) {
                str = " transportName";
            }
            if (this.f22388c == null) {
                str = str + " encodedPayload";
            }
            if (this.f22389d == null) {
                str = str + " eventMillis";
            }
            if (this.f22390e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f22391f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new C2574b(this.f22386a, this.f22387b, this.f22388c, this.f22389d.longValue(), this.f22390e.longValue(), this.f22391f, this.f22392g, this.f22393h, this.f22394i, this.f22395j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // r1.i.a
        public Map e() {
            Map map = this.f22391f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // r1.i.a
        public i.a f(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f22391f = map;
            return this;
        }

        @Override // r1.i.a
        public i.a g(Integer num) {
            this.f22387b = num;
            return this;
        }

        @Override // r1.i.a
        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f22388c = hVar;
            return this;
        }

        @Override // r1.i.a
        public i.a i(long j7) {
            this.f22389d = Long.valueOf(j7);
            return this;
        }

        @Override // r1.i.a
        public i.a j(byte[] bArr) {
            this.f22394i = bArr;
            return this;
        }

        @Override // r1.i.a
        public i.a k(byte[] bArr) {
            this.f22395j = bArr;
            return this;
        }

        @Override // r1.i.a
        public i.a l(Integer num) {
            this.f22392g = num;
            return this;
        }

        @Override // r1.i.a
        public i.a m(String str) {
            this.f22393h = str;
            return this;
        }

        @Override // r1.i.a
        public i.a n(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f22386a = str;
            return this;
        }

        @Override // r1.i.a
        public i.a o(long j7) {
            this.f22390e = Long.valueOf(j7);
            return this;
        }
    }

    @Override // r1.i
    public Map c() {
        return this.f22381f;
    }

    @Override // r1.i
    public Integer d() {
        return this.f22377b;
    }

    @Override // r1.i
    public h e() {
        return this.f22378c;
    }

    public boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f22376a.equals(iVar.n()) && ((num = this.f22377b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f22378c.equals(iVar.e()) && this.f22379d == iVar.f() && this.f22380e == iVar.o() && this.f22381f.equals(iVar.c()) && ((num2 = this.f22382g) != null ? num2.equals(iVar.l()) : iVar.l() == null) && ((str = this.f22383h) != null ? str.equals(iVar.m()) : iVar.m() == null)) {
            boolean z7 = iVar instanceof C2574b;
            if (Arrays.equals(this.f22384i, z7 ? ((C2574b) iVar).f22384i : iVar.g())) {
                if (Arrays.equals(this.f22385j, z7 ? ((C2574b) iVar).f22385j : iVar.h())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // r1.i
    public long f() {
        return this.f22379d;
    }

    @Override // r1.i
    public byte[] g() {
        return this.f22384i;
    }

    @Override // r1.i
    public byte[] h() {
        return this.f22385j;
    }

    public int hashCode() {
        int iHashCode = (this.f22376a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f22377b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f22378c.hashCode()) * 1000003;
        long j7 = this.f22379d;
        int i7 = (iHashCode2 ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        long j8 = this.f22380e;
        int iHashCode3 = (((i7 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ this.f22381f.hashCode()) * 1000003;
        Integer num2 = this.f22382g;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.f22383h;
        return ((((iHashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.f22384i)) * 1000003) ^ Arrays.hashCode(this.f22385j);
    }

    @Override // r1.i
    public Integer l() {
        return this.f22382g;
    }

    @Override // r1.i
    public String m() {
        return this.f22383h;
    }

    @Override // r1.i
    public String n() {
        return this.f22376a;
    }

    @Override // r1.i
    public long o() {
        return this.f22380e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f22376a + ", code=" + this.f22377b + ", encodedPayload=" + this.f22378c + ", eventMillis=" + this.f22379d + ", uptimeMillis=" + this.f22380e + ", autoMetadata=" + this.f22381f + ", productId=" + this.f22382g + ", pseudonymousId=" + this.f22383h + ", experimentIdsClear=" + Arrays.toString(this.f22384i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f22385j) + "}";
    }

    public C2574b(String str, Integer num, h hVar, long j7, long j8, Map map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f22376a = str;
        this.f22377b = num;
        this.f22378c = hVar;
        this.f22379d = j7;
        this.f22380e = j8;
        this.f22381f = map;
        this.f22382g = num2;
        this.f22383h = str2;
        this.f22384i = bArr;
        this.f22385j = bArr2;
    }
}

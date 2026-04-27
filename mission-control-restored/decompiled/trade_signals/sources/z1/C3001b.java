package z1;

import java.util.Arrays;
import java.util.Map;
import z1.i;

/* JADX INFO: renamed from: z1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C3001b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f24658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f24659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f24661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f24662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f24663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f24664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f24665i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f24666j;

    /* JADX INFO: renamed from: z1.b$b, reason: collision with other inner class name */
    public static final class C0439b extends i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f24668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f24669c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f24670d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f24671e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map f24672f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f24673g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f24674h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f24675i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte[] f24676j;

        @Override // z1.i.a
        public i d() {
            String str = "";
            if (this.f24667a == null) {
                str = " transportName";
            }
            if (this.f24669c == null) {
                str = str + " encodedPayload";
            }
            if (this.f24670d == null) {
                str = str + " eventMillis";
            }
            if (this.f24671e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f24672f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new C3001b(this.f24667a, this.f24668b, this.f24669c, this.f24670d.longValue(), this.f24671e.longValue(), this.f24672f, this.f24673g, this.f24674h, this.f24675i, this.f24676j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // z1.i.a
        public Map e() {
            Map map = this.f24672f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // z1.i.a
        public i.a f(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f24672f = map;
            return this;
        }

        @Override // z1.i.a
        public i.a g(Integer num) {
            this.f24668b = num;
            return this;
        }

        @Override // z1.i.a
        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f24669c = hVar;
            return this;
        }

        @Override // z1.i.a
        public i.a i(long j8) {
            this.f24670d = Long.valueOf(j8);
            return this;
        }

        @Override // z1.i.a
        public i.a j(byte[] bArr) {
            this.f24675i = bArr;
            return this;
        }

        @Override // z1.i.a
        public i.a k(byte[] bArr) {
            this.f24676j = bArr;
            return this;
        }

        @Override // z1.i.a
        public i.a l(Integer num) {
            this.f24673g = num;
            return this;
        }

        @Override // z1.i.a
        public i.a m(String str) {
            this.f24674h = str;
            return this;
        }

        @Override // z1.i.a
        public i.a n(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f24667a = str;
            return this;
        }

        @Override // z1.i.a
        public i.a o(long j8) {
            this.f24671e = Long.valueOf(j8);
            return this;
        }
    }

    public C3001b(String str, Integer num, h hVar, long j8, long j9, Map map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f24657a = str;
        this.f24658b = num;
        this.f24659c = hVar;
        this.f24660d = j8;
        this.f24661e = j9;
        this.f24662f = map;
        this.f24663g = num2;
        this.f24664h = str2;
        this.f24665i = bArr;
        this.f24666j = bArr2;
    }

    @Override // z1.i
    public Map c() {
        return this.f24662f;
    }

    @Override // z1.i
    public Integer d() {
        return this.f24658b;
    }

    @Override // z1.i
    public h e() {
        return this.f24659c;
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
        if (this.f24657a.equals(iVar.n()) && ((num = this.f24658b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f24659c.equals(iVar.e()) && this.f24660d == iVar.f() && this.f24661e == iVar.o() && this.f24662f.equals(iVar.c()) && ((num2 = this.f24663g) != null ? num2.equals(iVar.l()) : iVar.l() == null) && ((str = this.f24664h) != null ? str.equals(iVar.m()) : iVar.m() == null)) {
            boolean z7 = iVar instanceof C3001b;
            if (Arrays.equals(this.f24665i, z7 ? ((C3001b) iVar).f24665i : iVar.g())) {
                if (Arrays.equals(this.f24666j, z7 ? ((C3001b) iVar).f24666j : iVar.h())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // z1.i
    public long f() {
        return this.f24660d;
    }

    @Override // z1.i
    public byte[] g() {
        return this.f24665i;
    }

    @Override // z1.i
    public byte[] h() {
        return this.f24666j;
    }

    public int hashCode() {
        int iHashCode = (this.f24657a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f24658b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f24659c.hashCode()) * 1000003;
        long j8 = this.f24660d;
        int i8 = (iHashCode2 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        long j9 = this.f24661e;
        int iHashCode3 = (((i8 ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003) ^ this.f24662f.hashCode()) * 1000003;
        Integer num2 = this.f24663g;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.f24664h;
        return ((((iHashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.f24665i)) * 1000003) ^ Arrays.hashCode(this.f24666j);
    }

    @Override // z1.i
    public Integer l() {
        return this.f24663g;
    }

    @Override // z1.i
    public String m() {
        return this.f24664h;
    }

    @Override // z1.i
    public String n() {
        return this.f24657a;
    }

    @Override // z1.i
    public long o() {
        return this.f24661e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f24657a + ", code=" + this.f24658b + ", encodedPayload=" + this.f24659c + ", eventMillis=" + this.f24660d + ", uptimeMillis=" + this.f24661e + ", autoMetadata=" + this.f24662f + ", productId=" + this.f24663g + ", pseudonymousId=" + this.f24664h + ", experimentIdsClear=" + Arrays.toString(this.f24665i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f24666j) + "}";
    }
}

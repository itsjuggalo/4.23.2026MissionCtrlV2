package a1;

import a1.i;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: a1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0777b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f6042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f6043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f6046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f6047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f6048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f6049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f6050j;

    /* JADX INFO: renamed from: a1.b$b, reason: collision with other inner class name */
    public static final class C0085b extends i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f6052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f6053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f6054d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f6055e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map f6056f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f6057g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f6058h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f6059i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte[] f6060j;

        @Override // a1.i.a
        public i d() {
            String str = "";
            if (this.f6051a == null) {
                str = " transportName";
            }
            if (this.f6053c == null) {
                str = str + " encodedPayload";
            }
            if (this.f6054d == null) {
                str = str + " eventMillis";
            }
            if (this.f6055e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f6056f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new C0777b(this.f6051a, this.f6052b, this.f6053c, this.f6054d.longValue(), this.f6055e.longValue(), this.f6056f, this.f6057g, this.f6058h, this.f6059i, this.f6060j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // a1.i.a
        public Map e() {
            Map map = this.f6056f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // a1.i.a
        public i.a f(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f6056f = map;
            return this;
        }

        @Override // a1.i.a
        public i.a g(Integer num) {
            this.f6052b = num;
            return this;
        }

        @Override // a1.i.a
        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f6053c = hVar;
            return this;
        }

        @Override // a1.i.a
        public i.a i(long j4) {
            this.f6054d = Long.valueOf(j4);
            return this;
        }

        @Override // a1.i.a
        public i.a j(byte[] bArr) {
            this.f6059i = bArr;
            return this;
        }

        @Override // a1.i.a
        public i.a k(byte[] bArr) {
            this.f6060j = bArr;
            return this;
        }

        @Override // a1.i.a
        public i.a l(Integer num) {
            this.f6057g = num;
            return this;
        }

        @Override // a1.i.a
        public i.a m(String str) {
            this.f6058h = str;
            return this;
        }

        @Override // a1.i.a
        public i.a n(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f6051a = str;
            return this;
        }

        @Override // a1.i.a
        public i.a o(long j4) {
            this.f6055e = Long.valueOf(j4);
            return this;
        }
    }

    @Override // a1.i
    public Map c() {
        return this.f6046f;
    }

    @Override // a1.i
    public Integer d() {
        return this.f6042b;
    }

    @Override // a1.i
    public h e() {
        return this.f6043c;
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
            if (this.f6041a.equals(iVar.n()) && ((num = this.f6042b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f6043c.equals(iVar.e()) && this.f6044d == iVar.f() && this.f6045e == iVar.o() && this.f6046f.equals(iVar.c()) && ((num2 = this.f6047g) != null ? num2.equals(iVar.l()) : iVar.l() == null) && ((str = this.f6048h) != null ? str.equals(iVar.m()) : iVar.m() == null)) {
                boolean z4 = iVar instanceof C0777b;
                if (Arrays.equals(this.f6049i, z4 ? ((C0777b) iVar).f6049i : iVar.g())) {
                    if (Arrays.equals(this.f6050j, z4 ? ((C0777b) iVar).f6050j : iVar.h())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // a1.i
    public long f() {
        return this.f6044d;
    }

    @Override // a1.i
    public byte[] g() {
        return this.f6049i;
    }

    @Override // a1.i
    public byte[] h() {
        return this.f6050j;
    }

    public int hashCode() {
        int iHashCode = (this.f6041a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f6042b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f6043c.hashCode()) * 1000003;
        long j4 = this.f6044d;
        int i4 = (iHashCode2 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j5 = this.f6045e;
        int iHashCode3 = (((i4 ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ this.f6046f.hashCode()) * 1000003;
        Integer num2 = this.f6047g;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.f6048h;
        return ((((iHashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.f6049i)) * 1000003) ^ Arrays.hashCode(this.f6050j);
    }

    @Override // a1.i
    public Integer l() {
        return this.f6047g;
    }

    @Override // a1.i
    public String m() {
        return this.f6048h;
    }

    @Override // a1.i
    public String n() {
        return this.f6041a;
    }

    @Override // a1.i
    public long o() {
        return this.f6045e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f6041a + ", code=" + this.f6042b + ", encodedPayload=" + this.f6043c + ", eventMillis=" + this.f6044d + ", uptimeMillis=" + this.f6045e + ", autoMetadata=" + this.f6046f + ", productId=" + this.f6047g + ", pseudonymousId=" + this.f6048h + ", experimentIdsClear=" + Arrays.toString(this.f6049i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f6050j) + "}";
    }

    public C0777b(String str, Integer num, h hVar, long j4, long j5, Map map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f6041a = str;
        this.f6042b = num;
        this.f6043c = hVar;
        this.f6044d = j4;
        this.f6045e = j5;
        this.f6046f = map;
        this.f6047g = num2;
        this.f6048h = str2;
        this.f6049i = bArr;
        this.f6050j = bArr2;
    }
}

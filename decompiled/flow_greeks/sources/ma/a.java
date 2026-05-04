package ma;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f16364p = new C0290a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f16365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f16368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f16369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f16370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f16371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f16372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f16373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f16374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f16375k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f16376l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f16377m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f16378n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f16379o;

    /* JADX INFO: renamed from: ma.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0290a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f16380a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16381b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f16382c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f16383d = c.UNKNOWN;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f16384e = d.UNKNOWN_OS;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f16385f = "";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f16386g = "";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f16387h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f16388i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f16389j = "";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f16390k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public b f16391l = b.UNKNOWN_EVENT;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f16392m = "";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f16393n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f16394o = "";

        public a a() {
            return new a(this.f16380a, this.f16381b, this.f16382c, this.f16383d, this.f16384e, this.f16385f, this.f16386g, this.f16387h, this.f16388i, this.f16389j, this.f16390k, this.f16391l, this.f16392m, this.f16393n, this.f16394o);
        }

        public C0290a b(String str) {
            this.f16392m = str;
            return this;
        }

        public C0290a c(String str) {
            this.f16386g = str;
            return this;
        }

        public C0290a d(String str) {
            this.f16394o = str;
            return this;
        }

        public C0290a e(b bVar) {
            this.f16391l = bVar;
            return this;
        }

        public C0290a f(String str) {
            this.f16382c = str;
            return this;
        }

        public C0290a g(String str) {
            this.f16381b = str;
            return this;
        }

        public C0290a h(c cVar) {
            this.f16383d = cVar;
            return this;
        }

        public C0290a i(String str) {
            this.f16385f = str;
            return this;
        }

        public C0290a j(int i10) {
            this.f16387h = i10;
            return this;
        }

        public C0290a k(long j10) {
            this.f16380a = j10;
            return this;
        }

        public C0290a l(d dVar) {
            this.f16384e = dVar;
            return this;
        }

        public C0290a m(String str) {
            this.f16389j = str;
            return this;
        }

        public C0290a n(int i10) {
            this.f16388i = i10;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b implements b9.c {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16399a;

        b(int i10) {
            this.f16399a = i10;
        }

        @Override // b9.c
        public int d() {
            return this.f16399a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum c implements b9.c {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16405a;

        c(int i10) {
            this.f16405a = i10;
        }

        @Override // b9.c
        public int d() {
            return this.f16405a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum d implements b9.c {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16411a;

        d(int i10) {
            this.f16411a = i10;
        }

        @Override // b9.c
        public int d() {
            return this.f16411a;
        }
    }

    public a(long j10, String str, String str2, c cVar, d dVar, String str3, String str4, int i10, int i11, String str5, long j11, b bVar, String str6, long j12, String str7) {
        this.f16365a = j10;
        this.f16366b = str;
        this.f16367c = str2;
        this.f16368d = cVar;
        this.f16369e = dVar;
        this.f16370f = str3;
        this.f16371g = str4;
        this.f16372h = i10;
        this.f16373i = i11;
        this.f16374j = str5;
        this.f16375k = j11;
        this.f16376l = bVar;
        this.f16377m = str6;
        this.f16378n = j12;
        this.f16379o = str7;
    }

    public static C0290a p() {
        return new C0290a();
    }

    public String a() {
        return this.f16377m;
    }

    public long b() {
        return this.f16375k;
    }

    public long c() {
        return this.f16378n;
    }

    public String d() {
        return this.f16371g;
    }

    public String e() {
        return this.f16379o;
    }

    public b f() {
        return this.f16376l;
    }

    public String g() {
        return this.f16367c;
    }

    public String h() {
        return this.f16366b;
    }

    public c i() {
        return this.f16368d;
    }

    public String j() {
        return this.f16370f;
    }

    public int k() {
        return this.f16372h;
    }

    public long l() {
        return this.f16365a;
    }

    public d m() {
        return this.f16369e;
    }

    public String n() {
        return this.f16374j;
    }

    public int o() {
        return this.f16373i;
    }
}

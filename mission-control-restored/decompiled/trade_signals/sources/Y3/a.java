package Y3;

import z3.InterfaceC3007c;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f9550p = new C0156a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f9554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f9555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f9556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f9558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f9559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f9560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f9561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f9562l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f9563m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f9564n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f9565o;

    /* JADX INFO: renamed from: Y3.a$a, reason: collision with other inner class name */
    public static final class C0156a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9566a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9567b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9568c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f9569d = c.UNKNOWN;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f9570e = d.UNKNOWN_OS;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f9571f = "";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f9572g = "";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f9573h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f9574i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f9575j = "";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f9576k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public b f9577l = b.UNKNOWN_EVENT;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f9578m = "";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f9579n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f9580o = "";

        public a a() {
            return new a(this.f9566a, this.f9567b, this.f9568c, this.f9569d, this.f9570e, this.f9571f, this.f9572g, this.f9573h, this.f9574i, this.f9575j, this.f9576k, this.f9577l, this.f9578m, this.f9579n, this.f9580o);
        }

        public C0156a b(String str) {
            this.f9578m = str;
            return this;
        }

        public C0156a c(String str) {
            this.f9572g = str;
            return this;
        }

        public C0156a d(String str) {
            this.f9580o = str;
            return this;
        }

        public C0156a e(b bVar) {
            this.f9577l = bVar;
            return this;
        }

        public C0156a f(String str) {
            this.f9568c = str;
            return this;
        }

        public C0156a g(String str) {
            this.f9567b = str;
            return this;
        }

        public C0156a h(c cVar) {
            this.f9569d = cVar;
            return this;
        }

        public C0156a i(String str) {
            this.f9571f = str;
            return this;
        }

        public C0156a j(int i8) {
            this.f9573h = i8;
            return this;
        }

        public C0156a k(long j8) {
            this.f9566a = j8;
            return this;
        }

        public C0156a l(d dVar) {
            this.f9570e = dVar;
            return this;
        }

        public C0156a m(String str) {
            this.f9575j = str;
            return this;
        }

        public C0156a n(int i8) {
            this.f9574i = i8;
            return this;
        }
    }

    public enum b implements InterfaceC3007c {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9585a;

        b(int i8) {
            this.f9585a = i8;
        }

        @Override // z3.InterfaceC3007c
        public int d() {
            return this.f9585a;
        }
    }

    public enum c implements InterfaceC3007c {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9591a;

        c(int i8) {
            this.f9591a = i8;
        }

        @Override // z3.InterfaceC3007c
        public int d() {
            return this.f9591a;
        }
    }

    public enum d implements InterfaceC3007c {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9597a;

        d(int i8) {
            this.f9597a = i8;
        }

        @Override // z3.InterfaceC3007c
        public int d() {
            return this.f9597a;
        }
    }

    public a(long j8, String str, String str2, c cVar, d dVar, String str3, String str4, int i8, int i9, String str5, long j9, b bVar, String str6, long j10, String str7) {
        this.f9551a = j8;
        this.f9552b = str;
        this.f9553c = str2;
        this.f9554d = cVar;
        this.f9555e = dVar;
        this.f9556f = str3;
        this.f9557g = str4;
        this.f9558h = i8;
        this.f9559i = i9;
        this.f9560j = str5;
        this.f9561k = j9;
        this.f9562l = bVar;
        this.f9563m = str6;
        this.f9564n = j10;
        this.f9565o = str7;
    }

    public static C0156a p() {
        return new C0156a();
    }

    public String a() {
        return this.f9563m;
    }

    public long b() {
        return this.f9561k;
    }

    public long c() {
        return this.f9564n;
    }

    public String d() {
        return this.f9557g;
    }

    public String e() {
        return this.f9565o;
    }

    public b f() {
        return this.f9562l;
    }

    public String g() {
        return this.f9553c;
    }

    public String h() {
        return this.f9552b;
    }

    public c i() {
        return this.f9554d;
    }

    public String j() {
        return this.f9556f;
    }

    public int k() {
        return this.f9558h;
    }

    public long l() {
        return this.f9551a;
    }

    public d m() {
        return this.f9555e;
    }

    public String n() {
        return this.f9560j;
    }

    public int o() {
        return this.f9559i;
    }
}

package V3;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f5257p = new C0089a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f5261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f5262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f5266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f5267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f5268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f5269l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f5270m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f5271n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f5272o;

    /* JADX INFO: renamed from: V3.a$a, reason: collision with other inner class name */
    public static final class C0089a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5273a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5274b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f5275c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f5276d = c.UNKNOWN;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f5277e = d.UNKNOWN_OS;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f5278f = "";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f5279g = "";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f5280h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f5281i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f5282j = "";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f5283k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public b f5284l = b.UNKNOWN_EVENT;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f5285m = "";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f5286n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f5287o = "";

        public a a() {
            return new a(this.f5273a, this.f5274b, this.f5275c, this.f5276d, this.f5277e, this.f5278f, this.f5279g, this.f5280h, this.f5281i, this.f5282j, this.f5283k, this.f5284l, this.f5285m, this.f5286n, this.f5287o);
        }

        public C0089a b(String str) {
            this.f5285m = str;
            return this;
        }

        public C0089a c(String str) {
            this.f5279g = str;
            return this;
        }

        public C0089a d(String str) {
            this.f5287o = str;
            return this;
        }

        public C0089a e(b bVar) {
            this.f5284l = bVar;
            return this;
        }

        public C0089a f(String str) {
            this.f5275c = str;
            return this;
        }

        public C0089a g(String str) {
            this.f5274b = str;
            return this;
        }

        public C0089a h(c cVar) {
            this.f5276d = cVar;
            return this;
        }

        public C0089a i(String str) {
            this.f5278f = str;
            return this;
        }

        public C0089a j(int i7) {
            this.f5280h = i7;
            return this;
        }

        public C0089a k(long j7) {
            this.f5273a = j7;
            return this;
        }

        public C0089a l(d dVar) {
            this.f5277e = dVar;
            return this;
        }

        public C0089a m(String str) {
            this.f5282j = str;
            return this;
        }

        public C0089a n(int i7) {
            this.f5281i = i7;
            return this;
        }
    }

    public enum b implements y3.c {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5292a;

        b(int i7) {
            this.f5292a = i7;
        }

        @Override // y3.c
        public int d() {
            return this.f5292a;
        }
    }

    public enum c implements y3.c {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5298a;

        c(int i7) {
            this.f5298a = i7;
        }

        @Override // y3.c
        public int d() {
            return this.f5298a;
        }
    }

    public enum d implements y3.c {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5304a;

        d(int i7) {
            this.f5304a = i7;
        }

        @Override // y3.c
        public int d() {
            return this.f5304a;
        }
    }

    public a(long j7, String str, String str2, c cVar, d dVar, String str3, String str4, int i7, int i8, String str5, long j8, b bVar, String str6, long j9, String str7) {
        this.f5258a = j7;
        this.f5259b = str;
        this.f5260c = str2;
        this.f5261d = cVar;
        this.f5262e = dVar;
        this.f5263f = str3;
        this.f5264g = str4;
        this.f5265h = i7;
        this.f5266i = i8;
        this.f5267j = str5;
        this.f5268k = j8;
        this.f5269l = bVar;
        this.f5270m = str6;
        this.f5271n = j9;
        this.f5272o = str7;
    }

    public static C0089a p() {
        return new C0089a();
    }

    public String a() {
        return this.f5270m;
    }

    public long b() {
        return this.f5268k;
    }

    public long c() {
        return this.f5271n;
    }

    public String d() {
        return this.f5264g;
    }

    public String e() {
        return this.f5272o;
    }

    public b f() {
        return this.f5269l;
    }

    public String g() {
        return this.f5260c;
    }

    public String h() {
        return this.f5259b;
    }

    public c i() {
        return this.f5261d;
    }

    public String j() {
        return this.f5263f;
    }

    public int k() {
        return this.f5265h;
    }

    public long l() {
        return this.f5258a;
    }

    public d m() {
        return this.f5262e;
    }

    public String n() {
        return this.f5267j;
    }

    public int o() {
        return this.f5266i;
    }
}

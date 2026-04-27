package C1;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f595b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f596a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f597a = null;

        public b a() {
            return new b(this.f597a);
        }

        public a b(e eVar) {
            this.f597a = eVar;
            return this;
        }
    }

    public b(e eVar) {
        this.f596a = eVar;
    }

    public static a b() {
        return new a();
    }

    public e a() {
        return this.f596a;
    }
}

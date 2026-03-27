package Z2;

/* JADX INFO: renamed from: Z2.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0778x extends C0772q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AbstractC0759h f5811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5812c;

    public C0778x(String str, String str2) {
        super(str, str2);
    }

    public final String b() {
        return this.f5812c;
    }

    public final AbstractC0759h c() {
        return this.f5811b;
    }

    public final C0778x d(AbstractC0759h abstractC0759h) {
        this.f5811b = abstractC0759h;
        return this;
    }

    public final C0778x e(String str) {
        this.f5812c = str;
        return this;
    }
}

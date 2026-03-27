package T3;

/* JADX INFO: loaded from: classes.dex */
public class i extends G2.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7981a;

    public enum a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public i(a aVar) {
        this.f7981a = aVar;
    }

    public i(String str, a aVar) {
        super(str);
        this.f7981a = aVar;
    }
}

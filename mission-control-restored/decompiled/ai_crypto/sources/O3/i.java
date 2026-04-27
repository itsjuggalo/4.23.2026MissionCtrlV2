package O3;

/* JADX INFO: loaded from: classes.dex */
public class i extends Q2.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4185a;

    public enum a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public i(a aVar) {
        this.f4185a = aVar;
    }

    public i(String str, a aVar) {
        super(str);
        this.f4185a = aVar;
    }
}

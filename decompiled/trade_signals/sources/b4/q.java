package b4;

/* JADX INFO: loaded from: classes.dex */
public class q extends G2.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f12923a;

    public enum a {
        UNKNOWN(0),
        CONFIG_UPDATE_STREAM_ERROR(1),
        CONFIG_UPDATE_MESSAGE_INVALID(2),
        CONFIG_UPDATE_NOT_FETCHED(3),
        CONFIG_UPDATE_UNAVAILABLE(4);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12930a;

        a(int i8) {
            this.f12930a = i8;
        }
    }

    public q(String str) {
        super(str);
        this.f12923a = a.UNKNOWN;
    }

    public q(String str, a aVar) {
        super(str);
        this.f12923a = aVar;
    }

    public q(String str, Throwable th) {
        super(str, th);
        this.f12923a = a.UNKNOWN;
    }

    public q(String str, Throwable th, a aVar) {
        super(str, th);
        this.f12923a = aVar;
    }
}

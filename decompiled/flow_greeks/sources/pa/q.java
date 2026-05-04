package pa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q extends a7.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f18458a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        UNKNOWN(0),
        CONFIG_UPDATE_STREAM_ERROR(1),
        CONFIG_UPDATE_MESSAGE_INVALID(2),
        CONFIG_UPDATE_NOT_FETCHED(3),
        CONFIG_UPDATE_UNAVAILABLE(4);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18465a;

        a(int i10) {
            this.f18465a = i10;
        }
    }

    public q(String str) {
        super(str);
        this.f18458a = a.UNKNOWN;
    }

    public q(String str, Throwable th) {
        super(str, th);
        this.f18458a = a.UNKNOWN;
    }

    public q(String str, a aVar) {
        super(str);
        this.f18458a = aVar;
    }

    public q(String str, Throwable th, a aVar) {
        super(str, th);
        this.f18458a = aVar;
    }
}

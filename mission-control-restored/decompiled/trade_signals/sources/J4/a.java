package J4;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    NO_ERROR(0, -1, 0),
    PROTOCOL_ERROR(1, 1, 1),
    INVALID_STREAM(1, 2, -1),
    UNSUPPORTED_VERSION(1, 4, -1),
    STREAM_IN_USE(1, 8, -1),
    STREAM_ALREADY_CLOSED(1, 9, -1),
    INTERNAL_ERROR(2, 6, 2),
    FLOW_CONTROL_ERROR(3, 7, -1),
    STREAM_CLOSED(5, -1, -1),
    FRAME_TOO_LARGE(6, 11, -1),
    REFUSED_STREAM(7, 3, -1),
    CANCEL(8, 5, -1),
    COMPRESSION_ERROR(9, -1, -1),
    CONNECT_ERROR(10, -1, -1),
    ENHANCE_YOUR_CALM(11, -1, -1),
    INADEQUATE_SECURITY(12, -1, -1),
    HTTP_1_1_REQUIRED(13, -1, -1),
    INVALID_CREDENTIALS(-1, 10, -1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4571c;

    a(int i8, int i9, int i10) {
        this.f4569a = i8;
        this.f4570b = i9;
        this.f4571c = i10;
    }

    public static a a(int i8) {
        for (a aVar : values()) {
            if (aVar.f4569a == i8) {
                return aVar;
            }
        }
        return null;
    }
}

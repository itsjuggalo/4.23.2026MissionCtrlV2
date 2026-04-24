package d1;

import com.google.firebase.encoders.proto.ProtoEnum;

/* JADX INFO: renamed from: d1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1212c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1212c f11399c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11401b;

    /* JADX INFO: renamed from: d1.c$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11402a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f11403b = b.REASON_UNKNOWN;

        public C1212c a() {
            return new C1212c(this.f11402a, this.f11403b);
        }

        public a b(long j4) {
            this.f11402a = j4;
            return this;
        }

        public a c(b bVar) {
            this.f11403b = bVar;
            return this;
        }
    }

    /* JADX INFO: renamed from: d1.c$b */
    public enum b implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11412a;

        b(int i4) {
            this.f11412a = i4;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.f11412a;
        }
    }

    public C1212c(long j4, b bVar) {
        this.f11400a = j4;
        this.f11401b = bVar;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f11400a;
    }

    public b b() {
        return this.f11401b;
    }
}

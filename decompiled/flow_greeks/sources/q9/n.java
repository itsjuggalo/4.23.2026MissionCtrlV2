package q9;

import com.google.protobuf.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public enum n implements c0.a {
    UNSPECIFIED_FETCH_ERROR(0),
    SERVER_ERROR(1),
    CLIENT_ERROR(2),
    NETWORK_ERROR(3);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c0.b f18924f = new c0.b() { // from class: q9.n.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18926a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements c0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c0.c f18927a = new b();

        @Override // com.google.protobuf.c0.c
        public boolean a(int i10) {
            return n.b(i10) != null;
        }
    }

    n(int i10) {
        this.f18926a = i10;
    }

    public static n b(int i10) {
        if (i10 == 0) {
            return UNSPECIFIED_FETCH_ERROR;
        }
        if (i10 == 1) {
            return SERVER_ERROR;
        }
        if (i10 == 2) {
            return CLIENT_ERROR;
        }
        if (i10 != 3) {
            return null;
        }
        return NETWORK_ERROR;
    }

    public static c0.c c() {
        return b.f18927a;
    }

    @Override // com.google.protobuf.c0.a
    public final int d() {
        return this.f18926a;
    }
}

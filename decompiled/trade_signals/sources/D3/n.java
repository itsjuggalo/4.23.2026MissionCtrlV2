package D3;

import com.google.protobuf.AbstractC1481u;

/* JADX INFO: loaded from: classes.dex */
public enum n implements AbstractC1481u.a {
    UNSPECIFIED_FETCH_ERROR(0),
    SERVER_ERROR(1),
    CLIENT_ERROR(2),
    NETWORK_ERROR(3);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC1481u.b f819f = new AbstractC1481u.b() { // from class: D3.n.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f821a;

    public static final class b implements AbstractC1481u.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AbstractC1481u.c f822a = new b();

        @Override // com.google.protobuf.AbstractC1481u.c
        public boolean a(int i8) {
            return n.b(i8) != null;
        }
    }

    n(int i8) {
        this.f821a = i8;
    }

    public static n b(int i8) {
        if (i8 == 0) {
            return UNSPECIFIED_FETCH_ERROR;
        }
        if (i8 == 1) {
            return SERVER_ERROR;
        }
        if (i8 == 2) {
            return CLIENT_ERROR;
        }
        if (i8 != 3) {
            return null;
        }
        return NETWORK_ERROR;
    }

    public static AbstractC1481u.c g() {
        return b.f822a;
    }

    @Override // com.google.protobuf.AbstractC1481u.a
    public final int d() {
        return this.f821a;
    }
}

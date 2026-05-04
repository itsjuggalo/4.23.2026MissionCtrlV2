package q9;

import com.google.protobuf.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public enum d0 implements c0.a {
    UNSPECIFIED_RENDER_ERROR(0),
    IMAGE_FETCH_ERROR(1),
    IMAGE_DISPLAY_ERROR(2),
    IMAGE_UNSUPPORTED_FORMAT(3);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c0.b f18893f = new c0.b() { // from class: q9.d0.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18895a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements c0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c0.c f18896a = new b();

        @Override // com.google.protobuf.c0.c
        public boolean a(int i10) {
            return d0.b(i10) != null;
        }
    }

    d0(int i10) {
        this.f18895a = i10;
    }

    public static d0 b(int i10) {
        if (i10 == 0) {
            return UNSPECIFIED_RENDER_ERROR;
        }
        if (i10 == 1) {
            return IMAGE_FETCH_ERROR;
        }
        if (i10 == 2) {
            return IMAGE_DISPLAY_ERROR;
        }
        if (i10 != 3) {
            return null;
        }
        return IMAGE_UNSUPPORTED_FORMAT;
    }

    public static c0.c c() {
        return b.f18896a;
    }

    @Override // com.google.protobuf.c0.a
    public final int d() {
        return this.f18895a;
    }
}

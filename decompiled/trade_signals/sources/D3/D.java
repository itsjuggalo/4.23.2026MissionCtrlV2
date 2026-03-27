package D3;

import com.google.protobuf.AbstractC1481u;

/* JADX INFO: loaded from: classes.dex */
public enum D implements AbstractC1481u.a {
    UNSPECIFIED_RENDER_ERROR(0),
    IMAGE_FETCH_ERROR(1),
    IMAGE_DISPLAY_ERROR(2),
    IMAGE_UNSUPPORTED_FORMAT(3);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC1481u.b f785f = new AbstractC1481u.b() { // from class: D3.D.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f787a;

    public static final class b implements AbstractC1481u.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AbstractC1481u.c f788a = new b();

        @Override // com.google.protobuf.AbstractC1481u.c
        public boolean a(int i8) {
            return D.b(i8) != null;
        }
    }

    D(int i8) {
        this.f787a = i8;
    }

    public static D b(int i8) {
        if (i8 == 0) {
            return UNSPECIFIED_RENDER_ERROR;
        }
        if (i8 == 1) {
            return IMAGE_FETCH_ERROR;
        }
        if (i8 == 2) {
            return IMAGE_DISPLAY_ERROR;
        }
        if (i8 != 3) {
            return null;
        }
        return IMAGE_UNSUPPORTED_FORMAT;
    }

    public static AbstractC1481u.c g() {
        return b.f788a;
    }

    @Override // com.google.protobuf.AbstractC1481u.a
    public final int d() {
        return this.f787a;
    }
}

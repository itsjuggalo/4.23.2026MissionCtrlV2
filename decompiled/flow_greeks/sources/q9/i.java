package q9;

import com.google.protobuf.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public enum i implements c0.a {
    UNKNOWN_DISMISS_TYPE(0),
    AUTO(1),
    CLICK(2),
    SWIPE(3);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c0.b f18908f = new c0.b() { // from class: q9.i.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18910a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements c0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c0.c f18911a = new b();

        @Override // com.google.protobuf.c0.c
        public boolean a(int i10) {
            return i.b(i10) != null;
        }
    }

    i(int i10) {
        this.f18910a = i10;
    }

    public static i b(int i10) {
        if (i10 == 0) {
            return UNKNOWN_DISMISS_TYPE;
        }
        if (i10 == 1) {
            return AUTO;
        }
        if (i10 == 2) {
            return CLICK;
        }
        if (i10 != 3) {
            return null;
        }
        return SWIPE;
    }

    public static c0.c c() {
        return b.f18911a;
    }

    @Override // com.google.protobuf.c0.a
    public final int d() {
        return this.f18910a;
    }
}

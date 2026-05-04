package q9;

import com.google.protobuf.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public enum j implements c0.a {
    UNKNOWN_EVENT_TYPE(0),
    IMPRESSION_EVENT_TYPE(1),
    CLICK_EVENT_TYPE(2);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0.b f18915e = new c0.b() { // from class: q9.j.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18917a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements c0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c0.c f18918a = new b();

        @Override // com.google.protobuf.c0.c
        public boolean a(int i10) {
            return j.b(i10) != null;
        }
    }

    j(int i10) {
        this.f18917a = i10;
    }

    public static j b(int i10) {
        if (i10 == 0) {
            return UNKNOWN_EVENT_TYPE;
        }
        if (i10 == 1) {
            return IMPRESSION_EVENT_TYPE;
        }
        if (i10 != 2) {
            return null;
        }
        return CLICK_EVENT_TYPE;
    }

    public static c0.c c() {
        return b.f18918a;
    }

    @Override // com.google.protobuf.c0.a
    public final int d() {
        return this.f18917a;
    }
}

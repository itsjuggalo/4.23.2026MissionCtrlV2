package D3;

import com.google.protobuf.AbstractC1481u;

/* JADX INFO: loaded from: classes.dex */
public enum j implements AbstractC1481u.a {
    UNKNOWN_EVENT_TYPE(0),
    IMPRESSION_EVENT_TYPE(1),
    CLICK_EVENT_TYPE(2);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AbstractC1481u.b f810e = new AbstractC1481u.b() { // from class: D3.j.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f812a;

    public static final class b implements AbstractC1481u.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AbstractC1481u.c f813a = new b();

        @Override // com.google.protobuf.AbstractC1481u.c
        public boolean a(int i8) {
            return j.b(i8) != null;
        }
    }

    j(int i8) {
        this.f812a = i8;
    }

    public static j b(int i8) {
        if (i8 == 0) {
            return UNKNOWN_EVENT_TYPE;
        }
        if (i8 == 1) {
            return IMPRESSION_EVENT_TYPE;
        }
        if (i8 != 2) {
            return null;
        }
        return CLICK_EVENT_TYPE;
    }

    public static AbstractC1481u.c g() {
        return b.f813a;
    }

    @Override // com.google.protobuf.AbstractC1481u.a
    public final int d() {
        return this.f812a;
    }
}

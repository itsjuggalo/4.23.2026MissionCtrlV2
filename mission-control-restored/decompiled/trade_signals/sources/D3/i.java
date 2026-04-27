package D3;

import com.google.protobuf.AbstractC1481u;

/* JADX INFO: loaded from: classes.dex */
public enum i implements AbstractC1481u.a {
    UNKNOWN_DISMISS_TYPE(0),
    AUTO(1),
    CLICK(2),
    SWIPE(3);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC1481u.b f803f = new AbstractC1481u.b() { // from class: D3.i.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f805a;

    public static final class b implements AbstractC1481u.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AbstractC1481u.c f806a = new b();

        @Override // com.google.protobuf.AbstractC1481u.c
        public boolean a(int i8) {
            return i.b(i8) != null;
        }
    }

    i(int i8) {
        this.f805a = i8;
    }

    public static i b(int i8) {
        if (i8 == 0) {
            return UNKNOWN_DISMISS_TYPE;
        }
        if (i8 == 1) {
            return AUTO;
        }
        if (i8 == 2) {
            return CLICK;
        }
        if (i8 != 3) {
            return null;
        }
        return SWIPE;
    }

    public static AbstractC1481u.c g() {
        return b.f806a;
    }

    @Override // com.google.protobuf.AbstractC1481u.a
    public final int d() {
        return this.f805a;
    }
}

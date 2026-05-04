package q9;

import com.google.protobuf.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public enum f implements c0.a {
    UNKNOWN_TRIGGER(0),
    APP_LAUNCH(1),
    ON_FOREGROUND(2),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c0.b f18901f = new c0.b() { // from class: q9.f.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18903a;

    f(int i10) {
        this.f18903a = i10;
    }

    public static f b(int i10) {
        if (i10 == 0) {
            return UNKNOWN_TRIGGER;
        }
        if (i10 == 1) {
            return APP_LAUNCH;
        }
        if (i10 != 2) {
            return null;
        }
        return ON_FOREGROUND;
    }

    @Override // com.google.protobuf.c0.a
    public final int d() {
        if (this != UNRECOGNIZED) {
            return this.f18903a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

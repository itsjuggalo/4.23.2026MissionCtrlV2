package D3;

import com.google.protobuf.AbstractC1481u;

/* JADX INFO: loaded from: classes.dex */
public enum f implements AbstractC1481u.a {
    UNKNOWN_TRIGGER(0),
    APP_LAUNCH(1),
    ON_FOREGROUND(2),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC1481u.b f796f = new AbstractC1481u.b() { // from class: D3.f.a
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f798a;

    f(int i8) {
        this.f798a = i8;
    }

    public static f b(int i8) {
        if (i8 == 0) {
            return UNKNOWN_TRIGGER;
        }
        if (i8 == 1) {
            return APP_LAUNCH;
        }
        if (i8 != 2) {
            return null;
        }
        return ON_FOREGROUND;
    }

    @Override // com.google.protobuf.AbstractC1481u.a
    public final int d() {
        if (this != UNRECOGNIZED) {
            return this.f798a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}

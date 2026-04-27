package l6;

import s6.AbstractC2723j;

/* JADX INFO: loaded from: classes2.dex */
public enum x implements AbstractC2723j.a {
    INTERNAL(0, 0),
    PRIVATE(1, 1),
    PROTECTED(2, 2),
    PUBLIC(3, 3),
    PRIVATE_TO_THIS(4, 4),
    LOCAL(5, 5);


    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static AbstractC2723j.b f21173h = new AbstractC2723j.b() { // from class: l6.x.a
        @Override // s6.AbstractC2723j.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public x a(int i8) {
            return x.a(i8);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21175a;

    x(int i8, int i9) {
        this.f21175a = i9;
    }

    public static x a(int i8) {
        if (i8 == 0) {
            return INTERNAL;
        }
        if (i8 == 1) {
            return PRIVATE;
        }
        if (i8 == 2) {
            return PROTECTED;
        }
        if (i8 == 3) {
            return PUBLIC;
        }
        if (i8 == 4) {
            return PRIVATE_TO_THIS;
        }
        if (i8 != 5) {
            return null;
        }
        return LOCAL;
    }

    @Override // s6.AbstractC2723j.a
    public final int d() {
        return this.f21175a;
    }
}

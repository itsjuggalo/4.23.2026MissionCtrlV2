package l6;

import s6.AbstractC2723j;

/* JADX INFO: loaded from: classes2.dex */
public enum k implements AbstractC2723j.a {
    FINAL(0, 0),
    OPEN(1, 1),
    ABSTRACT(2, 2),
    SEALED(3, 3);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AbstractC2723j.b f20886f = new AbstractC2723j.b() { // from class: l6.k.a
        @Override // s6.AbstractC2723j.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k a(int i8) {
            return k.a(i8);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20888a;

    k(int i8, int i9) {
        this.f20888a = i9;
    }

    public static k a(int i8) {
        if (i8 == 0) {
            return FINAL;
        }
        if (i8 == 1) {
            return OPEN;
        }
        if (i8 == 2) {
            return ABSTRACT;
        }
        if (i8 != 3) {
            return null;
        }
        return SEALED;
    }

    @Override // s6.AbstractC2723j.a
    public final int d() {
        return this.f20888a;
    }
}

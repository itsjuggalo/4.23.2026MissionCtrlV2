package l6;

import s6.AbstractC2723j;

/* JADX INFO: loaded from: classes2.dex */
public enum j implements AbstractC2723j.a {
    DECLARATION(0, 0),
    FAKE_OVERRIDE(1, 1),
    DELEGATION(2, 2),
    SYNTHESIZED(3, 3);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AbstractC2723j.b f20879f = new AbstractC2723j.b() { // from class: l6.j.a
        @Override // s6.AbstractC2723j.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(int i8) {
            return j.a(i8);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20881a;

    j(int i8, int i9) {
        this.f20881a = i9;
    }

    public static j a(int i8) {
        if (i8 == 0) {
            return DECLARATION;
        }
        if (i8 == 1) {
            return FAKE_OVERRIDE;
        }
        if (i8 == 2) {
            return DELEGATION;
        }
        if (i8 != 3) {
            return null;
        }
        return SYNTHESIZED;
    }

    @Override // s6.AbstractC2723j.a
    public final int d() {
        return this.f20881a;
    }
}

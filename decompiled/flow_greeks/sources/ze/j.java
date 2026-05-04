package ze;

import gf.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public enum j implements j.a {
    DECLARATION(0, 0),
    FAKE_OVERRIDE(1, 1),
    DELEGATION(2, 2),
    SYNTHESIZED(3, 3);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static j.b f26159f = new j.b() { // from class: ze.j.a
        @Override // gf.j.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(int i10) {
            return j.a(i10);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f26161a;

    j(int i10, int i11) {
        this.f26161a = i11;
    }

    public static j a(int i10) {
        if (i10 == 0) {
            return DECLARATION;
        }
        if (i10 == 1) {
            return FAKE_OVERRIDE;
        }
        if (i10 == 2) {
            return DELEGATION;
        }
        if (i10 != 3) {
            return null;
        }
        return SYNTHESIZED;
    }

    @Override // gf.j.a
    public final int d() {
        return this.f26161a;
    }
}

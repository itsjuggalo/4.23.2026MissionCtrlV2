package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f1922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f1924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1925d;

    public v0(j0 j0Var, String str, Object[] objArr) {
        this.f1922a = j0Var;
        this.f1923b = str;
        this.f1924c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f1925d = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 < 55296) {
                this.f1925d = i10 | (cCharAt2 << i11);
                return;
            } else {
                i10 |= (cCharAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public boolean a() {
        return (this.f1925d & 2) == 2;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public j0 b() {
        return this.f1922a;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public s0 c() {
        int i10 = this.f1925d;
        return (i10 & 1) != 0 ? s0.PROTO2 : (i10 & 4) == 4 ? s0.EDITIONS : s0.PROTO3;
    }

    public Object[] d() {
        return this.f1924c;
    }

    public String e() {
        return this.f1923b;
    }
}

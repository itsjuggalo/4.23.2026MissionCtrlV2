package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j1 implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f7064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f7066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7067d;

    public j1(u0 u0Var, String str, Object[] objArr) {
        this.f7064a = u0Var;
        this.f7065b = str;
        this.f7066c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f7067d = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 < 55296) {
                this.f7067d = i10 | (cCharAt2 << i11);
                return;
            } else {
                i10 |= (cCharAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            }
        }
    }

    @Override // com.google.protobuf.s0
    public boolean a() {
        return (this.f7067d & 2) == 2;
    }

    @Override // com.google.protobuf.s0
    public u0 b() {
        return this.f7064a;
    }

    @Override // com.google.protobuf.s0
    public g1 c() {
        int i10 = this.f7067d;
        return (i10 & 1) != 0 ? g1.PROTO2 : (i10 & 4) == 4 ? g1.EDITIONS : g1.PROTO3;
    }

    public Object[] d() {
        return this.f7066c;
    }

    public String e() {
        return this.f7065b;
    }
}

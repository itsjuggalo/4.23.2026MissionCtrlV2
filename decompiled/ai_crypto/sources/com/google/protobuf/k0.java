package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class k0 implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f12719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f12721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12722d;

    public k0(V v7, String str, Object[] objArr) {
        this.f12719a = v7;
        this.f12720b = str;
        this.f12721c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f12722d = cCharAt;
            return;
        }
        int i7 = cCharAt & 8191;
        int i8 = 13;
        int i9 = 1;
        while (true) {
            int i10 = i9 + 1;
            char cCharAt2 = str.charAt(i9);
            if (cCharAt2 < 55296) {
                this.f12722d = i7 | (cCharAt2 << i8);
                return;
            } else {
                i7 |= (cCharAt2 & 8191) << i8;
                i8 += 13;
                i9 = i10;
            }
        }
    }

    @Override // com.google.protobuf.T
    public boolean a() {
        return (this.f12722d & 2) == 2;
    }

    @Override // com.google.protobuf.T
    public V b() {
        return this.f12719a;
    }

    @Override // com.google.protobuf.T
    public h0 c() {
        int i7 = this.f12722d;
        return (i7 & 1) != 0 ? h0.PROTO2 : (i7 & 4) == 4 ? h0.EDITIONS : h0.PROTO3;
    }

    public Object[] d() {
        return this.f12721c;
    }

    public String e() {
        return this.f12720b;
    }
}

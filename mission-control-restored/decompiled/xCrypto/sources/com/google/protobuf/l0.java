package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class l0 implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W f11113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f11115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11116d;

    public l0(W w4, String str, Object[] objArr) {
        this.f11113a = w4;
        this.f11114b = str;
        this.f11115c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f11116d = cCharAt;
            return;
        }
        int i4 = cCharAt & 8191;
        int i5 = 13;
        int i6 = 1;
        while (true) {
            int i7 = i6 + 1;
            char cCharAt2 = str.charAt(i6);
            if (cCharAt2 < 55296) {
                this.f11116d = i4 | (cCharAt2 << i5);
                return;
            } else {
                i4 |= (cCharAt2 & 8191) << i5;
                i5 += 13;
                i6 = i7;
            }
        }
    }

    @Override // com.google.protobuf.U
    public boolean a() {
        return (this.f11116d & 2) == 2;
    }

    @Override // com.google.protobuf.U
    public W b() {
        return this.f11113a;
    }

    @Override // com.google.protobuf.U
    public i0 c() {
        int i4 = this.f11116d;
        return (i4 & 1) != 0 ? i0.PROTO2 : (i4 & 4) == 4 ? i0.EDITIONS : i0.PROTO3;
    }

    public Object[] d() {
        return this.f11115c;
    }

    public String e() {
        return this.f11114b;
    }
}

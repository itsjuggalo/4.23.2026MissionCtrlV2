package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0483q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0450a f5785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f5787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5788d;

    public C0483q0(AbstractC0450a abstractC0450a, String str, Object[] objArr) {
        this.f5785a = abstractC0450a;
        this.f5786b = str;
        this.f5787c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f5788d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i6 = 1;
        int i7 = 13;
        while (true) {
            int i8 = i6 + 1;
            char cCharAt2 = str.charAt(i6);
            if (cCharAt2 < 55296) {
                this.f5788d = i | (cCharAt2 << i7);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i7;
                i7 += 13;
                i6 = i8;
            }
        }
    }

    public final int a() {
        int i = this.f5788d;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }
}

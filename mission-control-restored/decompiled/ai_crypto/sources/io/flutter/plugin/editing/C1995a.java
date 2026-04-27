package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

/* JADX INFO: renamed from: io.flutter.plugin.editing.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1995a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f16645a;

    public C1995a(FlutterJNI flutterJNI) {
        this.f16645a = flutterJNI;
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x0137 A[PHI: r2 r4
      0x0137: PHI (r2v2 int) = (r2v1 int), (r2v4 int) binds: [B:58:0x00b9, B:81:0x0112] A[DONT_GENERATE, DONT_INLINE]
      0x0137: PHI (r4v2 int) = (r4v1 int), (r4v4 int) binds: [B:58:0x00b9, B:81:0x0112] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(java.lang.CharSequence r10, int r11) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.C1995a.a(java.lang.CharSequence, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0149 A[PHI: r2 r4
      0x0149: PHI (r2v6 int) = (r2v3 int), (r2v8 int) binds: [B:80:0x0117, B:82:0x0124] A[DONT_GENERATE, DONT_INLINE]
      0x0149: PHI (r4v5 int) = (r4v3 int), (r4v7 int) binds: [B:80:0x0117, B:82:0x0124] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int b(java.lang.CharSequence r9, int r10) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.C1995a.b(java.lang.CharSequence, int):int");
    }

    public boolean c(int i7) {
        return this.f16645a.isCodePointEmoji(i7);
    }

    public boolean d(int i7) {
        return this.f16645a.isCodePointEmojiModifier(i7);
    }

    public boolean e(int i7) {
        return this.f16645a.isCodePointEmojiModifierBase(i7);
    }

    public boolean f(int i7) {
        return (48 <= i7 && i7 <= 57) || i7 == 35 || i7 == 42;
    }

    public boolean g(int i7) {
        return this.f16645a.isCodePointRegionalIndicator(i7);
    }

    public boolean h(int i7) {
        return 917536 <= i7 && i7 <= 917630;
    }

    public boolean i(int i7) {
        return this.f16645a.isCodePointVariantSelector(i7);
    }
}

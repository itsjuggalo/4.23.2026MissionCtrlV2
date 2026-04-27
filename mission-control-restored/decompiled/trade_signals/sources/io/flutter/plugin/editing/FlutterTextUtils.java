package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

/* JADX INFO: loaded from: classes.dex */
class FlutterTextUtils {
    public static final int CANCEL_TAG = 917631;
    public static final int CARRIAGE_RETURN = 13;
    public static final int COMBINING_ENCLOSING_KEYCAP = 8419;
    public static final int LINE_FEED = 10;
    public static final int ZERO_WIDTH_JOINER = 8205;
    private final FlutterJNI flutterJNI;

    public FlutterTextUtils(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x0133 A[PHI: r2 r4
      0x0133: PHI (r2v2 int) = (r2v1 int), (r2v4 int) binds: [B:58:0x00b9, B:80:0x010e] A[DONT_GENERATE, DONT_INLINE]
      0x0133: PHI (r4v2 int) = (r4v1 int), (r4v4 int) binds: [B:58:0x00b9, B:80:0x010e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getOffsetAfter(java.lang.CharSequence r10, int r11) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.FlutterTextUtils.getOffsetAfter(java.lang.CharSequence, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x0141 A[PHI: r2 r4
      0x0141: PHI (r2v6 int) = (r2v3 int), (r2v8 int) binds: [B:79:0x010f, B:81:0x011c] A[DONT_GENERATE, DONT_INLINE]
      0x0141: PHI (r4v5 int) = (r4v3 int), (r4v7 int) binds: [B:79:0x010f, B:81:0x011c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getOffsetBefore(java.lang.CharSequence r9, int r10) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.FlutterTextUtils.getOffsetBefore(java.lang.CharSequence, int):int");
    }

    public boolean isEmoji(int i8) {
        return this.flutterJNI.isCodePointEmoji(i8);
    }

    public boolean isEmojiModifier(int i8) {
        return this.flutterJNI.isCodePointEmojiModifier(i8);
    }

    public boolean isEmojiModifierBase(int i8) {
        return this.flutterJNI.isCodePointEmojiModifierBase(i8);
    }

    public boolean isKeycapBase(int i8) {
        return (48 <= i8 && i8 <= 57) || i8 == 35 || i8 == 42;
    }

    public boolean isRegionalIndicatorSymbol(int i8) {
        return this.flutterJNI.isCodePointRegionalIndicator(i8);
    }

    public boolean isTagSpecChar(int i8) {
        return 917536 <= i8 && i8 <= 917630;
    }

    public boolean isVariationSelector(int i8) {
        return this.flutterJNI.isCodePointVariantSelector(i8);
    }
}

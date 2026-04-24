package io.flutter.util;

import q0.AbstractC1718a;

/* JADX INFO: loaded from: classes3.dex */
public final class TraceSection implements AutoCloseable {
    private TraceSection(String str) {
        begin(str);
    }

    public static void begin(String str) {
        AbstractC1718a.c(cropSectionName(str));
    }

    public static void beginAsyncSection(String str, int i4) {
        AbstractC1718a.a(cropSectionName(str), i4);
    }

    private static String cropSectionName(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void end() {
        AbstractC1718a.f();
    }

    public static void endAsyncSection(String str, int i4) {
        AbstractC1718a.d(cropSectionName(str), i4);
    }

    public static TraceSection scoped(String str) {
        return new TraceSection(str);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end();
    }
}

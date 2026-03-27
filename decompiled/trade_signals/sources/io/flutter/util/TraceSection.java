package io.flutter.util;

import B0.a;

/* JADX INFO: loaded from: classes.dex */
public final class TraceSection implements AutoCloseable {
    private TraceSection(String str) {
        begin(str);
    }

    public static void begin(String str) {
        a.c(cropSectionName(str));
    }

    public static void beginAsyncSection(String str, int i8) {
        a.a(cropSectionName(str), i8);
    }

    private static String cropSectionName(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void end() {
        a.f();
    }

    public static void endAsyncSection(String str, int i8) {
        a.d(cropSectionName(str), i8);
    }

    public static TraceSection scoped(String str) {
        return new TraceSection(str);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end();
    }
}

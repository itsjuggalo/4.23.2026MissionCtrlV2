package com.google.android.gms.common.internal;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0937o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0932j f9939b = new C0932j("LibraryVersion", "");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0937o f9940c = new C0937o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f9941a = new ConcurrentHashMap();

    public static C0937o a() {
        return f9940c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r7v0 */
    public String b(String str) throws Throwable {
        ?? r4;
        InputStream resourceAsStream;
        AbstractC0940s.f(str, "Please provide a valid libraryName");
        if (this.f9941a.containsKey(str)) {
            return (String) this.f9941a.get(str);
        }
        Properties properties = new Properties();
        ?? r32 = 0;
        r32 = 0;
        r32 = 0;
        InputStream inputStream = null;
        try {
            try {
                resourceAsStream = C0937o.class.getResourceAsStream(String.format("/%s.properties", str));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e4) {
            e = e4;
            r4 = 0;
        }
        try {
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                String property = properties.getProperty(DiagnosticsEntry.VERSION_KEY, null);
                f9939b.d("LibraryVersion", str + " version is " + property);
                r32 = property;
            } else {
                f9939b.e("LibraryVersion", "Failed to get app version for libraryName: " + str);
            }
        } catch (IOException e5) {
            e = e5;
            r4 = r32;
            inputStream = resourceAsStream;
            f9939b.c("LibraryVersion", "Failed to get app version for libraryName: " + str, e);
            ?? r7 = r4;
            resourceAsStream = inputStream;
            r32 = r7;
        } catch (Throwable th2) {
            th = th2;
            r32 = resourceAsStream;
            if (r32 != 0) {
                G1.j.a(r32);
            }
            throw th;
        }
        if (resourceAsStream != null) {
            G1.j.a(resourceAsStream);
        }
        if (r32 == 0) {
            f9939b.b("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            r32 = "UNKNOWN";
        }
        this.f9941a.put(str, r32);
        return r32;
    }
}

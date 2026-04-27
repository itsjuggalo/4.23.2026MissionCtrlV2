package com.google.android.gms.common.internal;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1204o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1199j f11122b = new C1199j("LibraryVersion", "");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1204o f11123c = new C1204o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f11124a = new ConcurrentHashMap();

    public static C1204o a() {
        return f11123c;
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
        ?? r42;
        InputStream resourceAsStream;
        AbstractC1207s.f(str, "Please provide a valid libraryName");
        if (this.f11124a.containsKey(str)) {
            return (String) this.f11124a.get(str);
        }
        Properties properties = new Properties();
        ?? r32 = 0;
        r32 = 0;
        r32 = 0;
        InputStream inputStream = null;
        try {
            try {
                resourceAsStream = C1204o.class.getResourceAsStream(String.format("/%s.properties", str));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e7) {
            e = e7;
            r42 = 0;
        }
        try {
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                String property = properties.getProperty(DiagnosticsEntry.VERSION_KEY, null);
                f11122b.d("LibraryVersion", str + " version is " + property);
                r32 = property;
            } else {
                f11122b.e("LibraryVersion", "Failed to get app version for libraryName: " + str);
            }
        } catch (IOException e8) {
            e = e8;
            r42 = r32;
            inputStream = resourceAsStream;
            f11122b.c("LibraryVersion", "Failed to get app version for libraryName: " + str, e);
            ?? r7 = r42;
            resourceAsStream = inputStream;
            r32 = r7;
        } catch (Throwable th2) {
            th = th2;
            r32 = resourceAsStream;
            if (r32 != 0) {
                W1.j.a(r32);
            }
            throw th;
        }
        if (resourceAsStream != null) {
            W1.j.a(resourceAsStream);
        }
        if (r32 == 0) {
            f11122b.b("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            r32 = "UNKNOWN";
        }
        this.f11124a.put(str, r32);
        return r32;
    }
}

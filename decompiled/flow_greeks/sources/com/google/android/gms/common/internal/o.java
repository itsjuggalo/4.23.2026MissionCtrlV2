package com.google.android.gms.common.internal;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f5754b = new j("LibraryVersion", "");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f5755c = new o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f5756a = new ConcurrentHashMap();

    public static o a() {
        return f5755c;
    }

    public String b(String str) throws Throwable {
        String str2;
        InputStream resourceAsStream;
        s.f(str, "Please provide a valid libraryName");
        ConcurrentHashMap concurrentHashMap = this.f5756a;
        if (concurrentHashMap.containsKey(str)) {
            return (String) concurrentHashMap.get(str);
        }
        Properties properties = new Properties();
        InputStream inputStream = null;
        property = null;
        String property = null;
        inputStream = null;
        try {
            try {
                resourceAsStream = o.class.getResourceAsStream(String.format("/%s.properties", str));
            } catch (IOException e10) {
                e = e10;
                str2 = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                property = properties.getProperty(DiagnosticsEntry.VERSION_KEY, null);
                j jVar = f5754b;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(property).length());
                sb2.append(str);
                sb2.append(" version is ");
                sb2.append(property);
                jVar.d("LibraryVersion", sb2.toString());
            } else {
                j jVar2 = f5754b;
                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 43);
                sb3.append("Failed to get app version for libraryName: ");
                sb3.append(str);
                jVar2.e("LibraryVersion", sb3.toString());
            }
        } catch (IOException e11) {
            e = e11;
            str2 = property;
            inputStream = resourceAsStream;
            j jVar3 = f5754b;
            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 43);
            sb4.append("Failed to get app version for libraryName: ");
            sb4.append(str);
            jVar3.c("LibraryVersion", sb4.toString(), e);
            resourceAsStream = inputStream;
            property = str2;
        } catch (Throwable th2) {
            th = th2;
            inputStream = resourceAsStream;
            if (inputStream != null) {
                t5.k.a(inputStream);
            }
            throw th;
        }
        if (resourceAsStream != null) {
            t5.k.a(resourceAsStream);
        }
        if (property == null) {
            f5754b.b("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            property = "UNKNOWN";
        }
        this.f5756a.put(str, property);
        return property;
    }
}

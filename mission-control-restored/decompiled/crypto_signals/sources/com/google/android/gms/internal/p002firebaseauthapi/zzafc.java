package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.C0435m;
import com.google.android.gms.common.internal.C0439q;
import com.google.android.gms.common.internal.I;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class zzafc {
    private final int zza;

    private zzafc(String str) {
        this.zza = zza(str);
    }

    private static int zza(String str) {
        try {
            List<String> listZza = zzt.zza("[.-]").zza((CharSequence) str);
            if (listZza.size() == 1) {
                return Integer.parseInt(str);
            }
            if (listZza.size() < 3) {
                return -1;
            }
            return (Integer.parseInt(listZza.get(1)) * 1000) + (Integer.parseInt(listZza.get(0)) * 1000000) + Integer.parseInt(listZza.get(2));
        } catch (IllegalArgumentException e) {
            if (!Log.isLoggable("LibraryVersionContainer", 3)) {
                return -1;
            }
            Log.d("LibraryVersionContainer", String.format("Version code parsing failed for: %s with exception %s.", str, e));
            return -1;
        }
    }

    public final String zzb() {
        return AbstractC1024h.b("X", Integer.toString(this.zza));
    }

    public static zzafc zza() throws Throwable {
        String str;
        InputStream resourceAsStream;
        String str2;
        String strConcat = "Failed to get app version for libraryName: firebase-auth";
        C0439q c0439q = C0439q.f5269c;
        c0439q.getClass();
        C0435m c0435m = C0439q.f5268b;
        I.e("firebase-auth", "Please provide a valid libraryName");
        ConcurrentHashMap concurrentHashMap = c0439q.f5270a;
        if (concurrentHashMap.containsKey("firebase-auth")) {
            str2 = (String) concurrentHashMap.get("firebase-auth");
        } else {
            Properties properties = new Properties();
            InputStream inputStream = null;
            property = null;
            String property = null;
            InputStream inputStream2 = null;
            try {
                try {
                    resourceAsStream = C0439q.class.getResourceAsStream("/firebase-auth.properties");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
                str = null;
            }
            try {
                if (resourceAsStream != null) {
                    properties.load(resourceAsStream);
                    property = properties.getProperty("version", null);
                    String strConcat2 = "firebase-auth version is " + property;
                    if (Log.isLoggable(c0435m.f5266a, 2)) {
                        String str3 = c0435m.f5267b;
                        if (str3 != null) {
                            strConcat2 = str3.concat(strConcat2);
                        }
                        Log.v("LibraryVersion", strConcat2);
                    }
                } else if (Log.isLoggable(c0435m.f5266a, 5)) {
                    String str4 = c0435m.f5267b;
                    Log.w("LibraryVersion", str4 == null ? "Failed to get app version for libraryName: firebase-auth" : str4.concat("Failed to get app version for libraryName: firebase-auth"));
                }
            } catch (IOException e2) {
                e = e2;
                str = null;
                inputStream = resourceAsStream;
                if (Log.isLoggable(c0435m.f5266a, 6)) {
                    String str5 = c0435m.f5267b;
                    if (str5 != null) {
                        strConcat = str5.concat("Failed to get app version for libraryName: firebase-auth");
                    }
                    Log.e("LibraryVersion", strConcat, e);
                }
                resourceAsStream = inputStream;
                property = str;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = resourceAsStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException unused2) {
                }
            }
            if (property == null) {
                if (Log.isLoggable(c0435m.f5266a, 3)) {
                    String str6 = c0435m.f5267b;
                    Log.d("LibraryVersion", str6 != null ? str6.concat(".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used") : ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
                }
                str2 = "UNKNOWN";
            } else {
                str2 = property;
            }
            concurrentHashMap.put("firebase-auth", str2);
        }
        if (TextUtils.isEmpty(str2) || str2.equals("UNKNOWN")) {
            str2 = "-1";
        }
        return new zzafc(str2);
    }
}

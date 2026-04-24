package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import q2.AbstractC0928g;
import s3.AbstractC1024h;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0435m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5267b;

    public C0435m(String str) {
        this.f5266a = "LibraryVersion";
        this.f5267b = (str == null || str.length() <= 0) ? null : str;
    }

    public C0435m(io.flutter.plugin.platform.p pVar) {
        int iD = AbstractC0928g.d((Context) pVar.f7201b, "com.google.firebase.crashlytics.unity_version", "string");
        Context context = (Context) pVar.f7201b;
        if (iD != 0) {
            this.f5266a = "Unity";
            String string = context.getResources().getString(iD);
            this.f5267b = string;
            String strB = AbstractC1024h.b("Unity Editor version is: ", string);
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", strB, null);
                return;
            }
            return;
        }
        if (context.getAssets() != null) {
            try {
                InputStream inputStreamOpen = context.getAssets().open("flutter_assets/NOTICES.Z");
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                this.f5266a = "Flutter";
                this.f5267b = null;
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Development platform is: Flutter", null);
                    return;
                }
                return;
            } catch (IOException unused) {
            }
        }
        this.f5266a = null;
        this.f5267b = null;
    }
}

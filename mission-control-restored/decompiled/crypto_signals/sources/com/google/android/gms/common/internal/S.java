package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class S {
    public static final Uri e = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ComponentName f5216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5217d;

    public S(ComponentName componentName) {
        this.f5214a = null;
        this.f5215b = null;
        I.g(componentName);
        this.f5216c = componentName;
        this.f5217d = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.Intent a(android.content.Context r6) throws com.google.android.gms.common.internal.J {
        /*
            r5 = this;
            java.lang.String r0 = "ConnectionStatusConfig"
            java.lang.String r1 = r5.f5214a
            if (r1 == 0) goto La3
            boolean r2 = r5.f5217d
            r3 = 0
            if (r2 == 0) goto L94
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r4 = "serviceActionBundleKey"
            r2.putString(r4, r1)
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            android.net.Uri r4 = com.google.android.gms.common.internal.S.e     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            android.content.ContentProviderClient r6 = r6.acquireUnstableContentProviderClient(r4)     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            if (r6 == 0) goto L38
            java.lang.String r4 = "serviceIntentCall"
            android.os.Bundle r2 = r6.call(r4, r3, r2)     // Catch: java.lang.Throwable -> L2f
            r6.release()     // Catch: java.lang.IllegalArgumentException -> L2b android.os.RemoteException -> L2d
            goto L4e
        L2b:
            r6 = move-exception
            goto L41
        L2d:
            r6 = move-exception
            goto L41
        L2f:
            r2 = move-exception
            r6.release()     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            throw r2     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
        L34:
            r6 = move-exception
            goto L40
        L36:
            r6 = move-exception
            goto L40
        L38:
            android.os.RemoteException r6 = new android.os.RemoteException     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            java.lang.String r2 = "Failed to acquire ContentProviderClient"
            r6.<init>(r2)     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            throw r6     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
        L40:
            r2 = r3
        L41:
            java.lang.String r4 = "Dynamic intent resolution failed: "
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r4.concat(r6)
            android.util.Log.w(r0, r6)
        L4e:
            if (r2 == 0) goto L89
            java.lang.String r6 = "serviceResponseIntentKey"
            android.os.Parcelable r6 = r2.getParcelable(r6)
            r3 = r6
            android.content.Intent r3 = (android.content.Intent) r3
            if (r3 != 0) goto L89
            java.lang.String r6 = "serviceMissingResolutionIntentKey"
            android.os.Parcelable r6 = r2.getParcelable(r6)
            android.app.PendingIntent r6 = (android.app.PendingIntent) r6
            if (r6 != 0) goto L66
            goto L89
        L66:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Dynamic lookup for intent failed for action "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = " but has possible resolution"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.util.Log.w(r0, r1)
            com.google.android.gms.common.internal.J r0 = new com.google.android.gms.common.internal.J
            u1.b r1 = new u1.b
            r2 = 25
            r1.<init>(r2, r6)
            r0.<init>(r1)
            throw r0
        L89:
            if (r3 != 0) goto L94
            java.lang.String r6 = "Dynamic lookup for intent failed for action: "
            java.lang.String r6 = r6.concat(r1)
            android.util.Log.w(r0, r6)
        L94:
            if (r3 != 0) goto La2
            android.content.Intent r6 = new android.content.Intent
            r6.<init>(r1)
            java.lang.String r0 = r5.f5215b
            android.content.Intent r6 = r6.setPackage(r0)
            return r6
        La2:
            return r3
        La3:
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            android.content.ComponentName r0 = r5.f5216c
            android.content.Intent r6 = r6.setComponent(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.S.a(android.content.Context):android.content.Intent");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S)) {
            return false;
        }
        S s6 = (S) obj;
        return I.j(this.f5214a, s6.f5214a) && I.j(this.f5215b, s6.f5215b) && I.j(this.f5216c, s6.f5216c) && this.f5217d == s6.f5217d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5214a, this.f5215b, this.f5216c, 4225, Boolean.valueOf(this.f5217d)});
    }

    public final String toString() {
        String str = this.f5214a;
        if (str != null) {
            return str;
        }
        ComponentName componentName = this.f5216c;
        I.g(componentName);
        return componentName.flattenToString();
    }

    public S(String str, String str2, boolean z6) {
        I.d(str);
        this.f5214a = str;
        I.d(str2);
        this.f5215b = str2;
        this.f5216c = null;
        this.f5217d = z6;
    }
}

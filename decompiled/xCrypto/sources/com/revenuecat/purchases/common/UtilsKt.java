package com.revenuecat.purchases.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import kotlin.jvm.internal.r;
import r3.C1756c;

/* JADX INFO: loaded from: classes.dex */
public final class UtilsKt {
    public static final Locale getLocale(Context context) {
        r.f(context, "<this>");
        return context.getResources().getConfiguration().getLocales().get(0);
    }

    public static final String getPlayServicesVersionName(Context context) {
        r.f(context, "<this>");
        return packageVersionName(context, "com.google.android.gms");
    }

    public static final String getPlayStoreVersionName(Context context) {
        r.f(context, "<this>");
        return packageVersionName(context, "com.android.vending");
    }

    public static final String getVersionName(Context context) {
        r.f(context, "<this>");
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    }

    public static final boolean isDeviceProtectedStorageCompat(Context context) {
        r.f(context, "<this>");
        return context.isDeviceProtectedStorage();
    }

    private static final String packageVersionName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static final String sha1(String str) throws NoSuchAlgorithmException {
        r.f(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        Charset charset = C1756c.f14563b;
        byte[] bytes = str.getBytes(charset);
        r.e(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArrEncode = Base64.encode(messageDigest.digest(bytes), 2);
        r.e(bArrEncode, "encode(it, Base64.NO_WRAP)");
        return new String(bArrEncode, charset);
    }

    public static final String sha256(String str) throws NoSuchAlgorithmException {
        r.f(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        Charset charset = C1756c.f14563b;
        byte[] bytes = str.getBytes(charset);
        r.e(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArrEncode = Base64.encode(messageDigest.digest(bytes), 2);
        r.e(bArrEncode, "encode(it, Base64.NO_WRAP)");
        return new String(bArrEncode, charset);
    }
}

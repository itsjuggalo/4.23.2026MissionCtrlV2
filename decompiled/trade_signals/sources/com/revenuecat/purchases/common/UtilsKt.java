package com.revenuecat.purchases.common;

import V6.C0977c;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u0002H\u0000\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0010\u001a\u00020\u0005*\u00020\u0005H\u0000\u001a\f\u0010\u0011\u001a\u00020\u0005*\u00020\u0005H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u001a\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007\"\u001a\u0010\n\u001a\u0004\u0018\u00010\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0012"}, d2 = {"isDeviceProtectedStorageCompat", "", "Landroid/content/Context;", "(Landroid/content/Context;)Z", "playServicesVersionName", "", "getPlayServicesVersionName", "(Landroid/content/Context;)Ljava/lang/String;", "playStoreVersionName", "getPlayStoreVersionName", "versionName", "getVersionName", "getLocale", "Ljava/util/Locale;", "packageVersionName", "packageName", "sha1", SigningManager.POST_PARAMS_ALGORITHM, "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UtilsKt {
    public static final Locale getLocale(Context context) {
        AbstractC2304t.f(context, "<this>");
        return context.getResources().getConfiguration().getLocales().get(0);
    }

    public static final String getPlayServicesVersionName(Context context) {
        AbstractC2304t.f(context, "<this>");
        return packageVersionName(context, "com.google.android.gms");
    }

    public static final String getPlayStoreVersionName(Context context) {
        AbstractC2304t.f(context, "<this>");
        return packageVersionName(context, "com.android.vending");
    }

    public static final String getVersionName(Context context) {
        AbstractC2304t.f(context, "<this>");
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    }

    public static final boolean isDeviceProtectedStorageCompat(Context context) {
        AbstractC2304t.f(context, "<this>");
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
        AbstractC2304t.f(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        Charset charset = C0977c.f8956b;
        byte[] bytes = str.getBytes(charset);
        AbstractC2304t.e(bytes, "getBytes(...)");
        byte[] bArrEncode = Base64.encode(messageDigest.digest(bytes), 2);
        AbstractC2304t.e(bArrEncode, "encode(it, Base64.NO_WRAP)");
        return new String(bArrEncode, charset);
    }

    public static final String sha256(String str) throws NoSuchAlgorithmException {
        AbstractC2304t.f(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        Charset charset = C0977c.f8956b;
        byte[] bytes = str.getBytes(charset);
        AbstractC2304t.e(bytes, "getBytes(...)");
        byte[] bArrEncode = Base64.encode(messageDigest.digest(bytes), 2);
        AbstractC2304t.e(bArrEncode, "encode(it, Base64.NO_WRAP)");
        return new String(bArrEncode, charset);
    }
}

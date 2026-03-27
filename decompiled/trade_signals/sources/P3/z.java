package P3;

import F4.AbstractC0490d;
import F4.AbstractC0496j;
import F4.X;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import r4.g;
import x2.AbstractC2954a;

/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G2.f f6431a;

    public z(G2.f fVar) {
        this.f6431a = fVar;
    }

    public static String a(PackageManager packageManager, String str) {
        Signature[] signatureArr;
        Signature signature;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0 && (signature = signatureArr[0]) != null) {
                return d(signature);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static String d(Signature signature) {
        try {
            return AbstractC2954a.a().n().f(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public F4.X b() {
        X.d dVar = F4.X.f1686e;
        X.g gVarE = X.g.e("X-Goog-Api-Key", dVar);
        X.g gVarE2 = X.g.e("X-Android-Package", dVar);
        X.g gVarE3 = X.g.e("X-Android-Cert", dVar);
        F4.X x8 = new F4.X();
        String packageName = this.f6431a.m().getPackageName();
        x8.o(gVarE, this.f6431a.r().b());
        x8.o(gVarE2, packageName);
        String strA = a(this.f6431a.m().getPackageManager(), packageName);
        if (strA != null) {
            x8.o(gVarE3, strA);
        }
        return x8;
    }

    public g.b c(AbstractC0490d abstractC0490d, F4.X x8) {
        return r4.g.b(AbstractC0496j.b(abstractC0490d, M4.d.a(x8)));
    }
}

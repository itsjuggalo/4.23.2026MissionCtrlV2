package ca;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import ib.g;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import rb.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f3817a;

    public z(a7.g gVar) {
        this.f3817a = gVar;
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
            return r6.a.a().n().f(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public y0 b() {
        y0.d dVar = y0.f19747e;
        y0.g gVarE = y0.g.e("X-Goog-Api-Key", dVar);
        y0.g gVarE2 = y0.g.e("X-Android-Package", dVar);
        y0.g gVarE3 = y0.g.e("X-Android-Cert", dVar);
        y0 y0Var = new y0();
        String packageName = this.f3817a.m().getPackageName();
        y0Var.p(gVarE, this.f3817a.r().b());
        y0Var.p(gVarE2, packageName);
        String strA = a(this.f3817a.m().getPackageManager(), packageName);
        if (strA != null) {
            y0Var.p(gVarE3, strA);
        }
        return y0Var;
    }

    public g.b c(rb.d dVar, y0 y0Var) {
        return ib.g.b(rb.j.b(dVar, zb.e.a(y0Var)));
    }
}

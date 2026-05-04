package com.amazon.a.a.n.a;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f4423a = new com.amazon.a.a.o.c("CommandResultVerifier");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f4424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.o.b.b f4425c;

    private boolean b(String str, Signature signature) {
        boolean zEquals = false;
        try {
            zEquals = str.equals(a(signature));
            f4423a.a("Signature valid: " + zEquals);
            return zEquals;
        } catch (CertificateException unused) {
            f4423a.b("Failed to extract fingerprint from signature");
            return zEquals;
        }
    }

    public void a(String str, String str2) throws com.amazon.a.a.n.a.a.a {
        if (com.amazon.a.a.o.c.f4603a) {
            f4423a.a("Verifying auth token: " + str);
        }
        for (Signature signature : a(str2).signatures) {
            if (a(str, signature)) {
                return;
            }
        }
        throw new com.amazon.a.a.n.a.a.a();
    }

    private X509Certificate b(Signature signature) {
        return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
    }

    public boolean a(String str, List<String> list) {
        f4423a.a("checkSignatures(" + str + ", " + list);
        try {
            for (Signature signature : a(str).signatures) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (b(it.next(), signature)) {
                        return true;
                    }
                }
            }
        } catch (com.amazon.a.a.n.a.a.c e10) {
            f4423a.b("isPackageSignatureValid: caught exception while checking", e10);
        }
        return false;
    }

    private boolean a(String str, Signature signature) {
        try {
            return com.amazon.a.a.o.b.e.a(a(signature), str, this.f4425c.a());
        } catch (CertificateException unused) {
            if (!com.amazon.a.a.o.c.f4604b) {
                return false;
            }
            f4423a.b("Failed to extract fingerprint from signature: " + signature);
            return false;
        }
    }

    private PackageInfo a(String str) throws com.amazon.a.a.n.a.a.c {
        try {
            return this.f4424b.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e10) {
            f4423a.a("getPackageInfo() caught exception" + e10);
            throw new com.amazon.a.a.n.a.a.c();
        }
    }

    private String a(Signature signature) {
        return com.amazon.c.a.a.c.a(b(signature).getSignature());
    }
}

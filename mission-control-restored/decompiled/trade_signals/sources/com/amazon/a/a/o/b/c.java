package com.amazon.a.a.o.b;

import android.app.Application;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: classes.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f14086a = new com.amazon.a.a.o.c("DataAuthenticationKeyLoaderV2");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14087b = "kiwi";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f14088c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f14089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f14090e;

    private PublicKey b() {
        if (com.amazon.a.a.o.c.f14105a) {
            f14086a.a("Checking KiwiDataStore for key...");
        }
        PublicKey publicKey = (PublicKey) this.f14090e.a(com.amazon.a.a.m.c.f13876a);
        if (com.amazon.a.a.o.c.f14105a) {
            com.amazon.a.a.o.c cVar = f14086a;
            StringBuilder sb = new StringBuilder();
            sb.append("Key was cached: ");
            sb.append(publicKey != null);
            cVar.a(sb.toString());
        }
        return publicKey;
    }

    private PublicKey c() throws com.amazon.a.a.o.b.a.a {
        if (com.amazon.a.a.o.c.f14105a) {
            f14086a.a("Loading authentication key from apk...");
        }
        CertPath certPathD = d();
        if (!a(certPathD)) {
            throw com.amazon.a.a.o.b.a.a.e();
        }
        d(certPathD);
        return b(certPathD);
    }

    private CertPath d() throws com.amazon.a.a.o.b.a.a {
        JarFile jarFileE = e();
        return a(jarFileE, a(jarFileE));
    }

    private JarFile e() throws com.amazon.a.a.o.b.a.a {
        String packageCodePath = this.f14089d.getPackageCodePath();
        if (com.amazon.a.a.o.c.f14105a) {
            f14086a.a("Opening apk: " + packageCodePath);
        }
        try {
            return new JarFile(packageCodePath, false);
        } catch (IOException e8) {
            throw com.amazon.a.a.o.b.a.a.a((Throwable) e8);
        }
    }

    private a f() throws com.amazon.a.a.o.b.a.a {
        try {
            return new a();
        } catch (GeneralSecurityException e8) {
            throw com.amazon.a.a.o.b.a.a.b((Throwable) e8);
        }
    }

    @Override // com.amazon.a.a.o.b.b
    public PublicKey a() throws com.amazon.a.a.o.b.a.a {
        if (com.amazon.a.a.o.c.f14105a) {
            f14086a.a("Loading data authentication key...");
        }
        PublicKey publicKeyB = b();
        if (publicKeyB != null) {
            return publicKeyB;
        }
        PublicKey publicKeyC = c();
        a(publicKeyC);
        return publicKeyC;
    }

    private CertPath a(JarFile jarFile, JarEntry jarEntry) throws com.amazon.a.a.o.b.a.a {
        try {
            if (com.amazon.a.a.o.c.f14105a) {
                f14086a.a("Extracting cert from entry: " + jarEntry.getName());
            }
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            if (com.amazon.a.a.o.c.f14105a) {
                f14086a.a("Generating certificates from entry input stream");
            }
            return certificateFactory.generateCertPath(a(certificateFactory.generateCertificates(jarFile.getInputStream(jarEntry))));
        } catch (Exception e8) {
            throw com.amazon.a.a.o.b.a.a.a((Throwable) e8);
        }
    }

    private PublicKey b(CertPath certPath) {
        return c(certPath).getPublicKey();
    }

    private X509Certificate c(CertPath certPath) {
        return (X509Certificate) certPath.getCertificates().get(0);
    }

    private void d(CertPath certPath) throws com.amazon.a.a.o.b.a.a {
        if (!f().a(certPath)) {
            throw com.amazon.a.a.o.b.a.a.f();
        }
    }

    public List<? extends Certificate> a(Collection<? extends Certificate> collection) {
        return new ArrayList(collection);
    }

    private JarEntry a(JarFile jarFile) throws com.amazon.a.a.o.b.a.a {
        if (com.amazon.a.a.o.c.f14105a) {
            f14086a.a("Searching for cert in apk");
        }
        Enumeration<JarEntry> enumerationEntries = jarFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            JarEntry jarEntryNextElement = enumerationEntries.nextElement();
            if (!jarEntryNextElement.isDirectory() && jarEntryNextElement.getName().equals(f14087b)) {
                return jarEntryNextElement;
            }
        }
        throw com.amazon.a.a.o.b.a.a.d();
    }

    private void a(PublicKey publicKey) {
        if (com.amazon.a.a.o.c.f14105a) {
            f14086a.a("Placing auth key into storage");
        }
        this.f14090e.a(com.amazon.a.a.m.c.f13876a, publicKey);
    }

    private boolean a(CertPath certPath) {
        if (certPath != null && certPath.getCertificates().size() > 0) {
            Certificate certificate = certPath.getCertificates().get(0);
            if (!(certificate instanceof X509Certificate)) {
                return false;
            }
            String name = ((X509Certificate) certificate).getSubjectX500Principal().getName();
            if (com.amazon.a.a.o.c.f14105a) {
                f14086a.a("Kiwi Cert Details: " + name);
            }
            return name.contains("O=Amazon.com\\, Inc.") && name.contains("C=US") && name.contains("ST=Washington") && name.contains("L=Seattle");
        }
        return false;
    }
}

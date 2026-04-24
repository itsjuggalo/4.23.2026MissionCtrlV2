package com.amazon.a.a.o.b;

import android.app.Application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f9980a = new com.amazon.a.a.o.c("DataAuthenticationKeyLoaderV3");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9981b = "AppstoreAuthenticationKey.pem";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9982c = "-----BEGIN PUBLIC KEY-----";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9983d = "-----END PUBLIC KEY-----";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f9984e = "RSA";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f9985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f9986g;

    private PublicKey b() {
        if (com.amazon.a.a.o.c.f9994a) {
            f9980a.a("Checking KiwiDataStore for key...");
        }
        PublicKey publicKey = (PublicKey) this.f9986g.a(com.amazon.a.a.m.c.f9765a);
        if (com.amazon.a.a.o.c.f9994a) {
            com.amazon.a.a.o.c cVar = f9980a;
            StringBuilder sb = new StringBuilder();
            sb.append("Key was cached: ");
            sb.append(publicKey != null);
            cVar.a(sb.toString());
        }
        return publicKey;
    }

    private PublicKey c() throws Throwable {
        if (com.amazon.a.a.o.c.f9994a) {
            f9980a.a("Loading authentication key from apk...");
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(this.f9985f.getAssets().open(f9981b)));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line != null) {
                            sb.append(line);
                        } else {
                            try {
                                break;
                            } catch (IOException e7) {
                                if (com.amazon.a.a.o.c.f9994a) {
                                    f9980a.b("Failed to close stream", e7);
                                }
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                        f9980a.b("Unable to load authentication Key", e);
                        throw com.amazon.a.a.o.b.a.a.d();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e9) {
                                if (com.amazon.a.a.o.c.f9994a) {
                                    f9980a.b("Failed to close stream", e9);
                                }
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                return a(sb.toString());
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    @Override // com.amazon.a.a.o.b.b
    public PublicKey a() throws Throwable {
        if (com.amazon.a.a.o.c.f9994a) {
            f9980a.a("Loading data authentication key...");
        }
        PublicKey publicKeyB = b();
        if (publicKeyB != null) {
            return publicKeyB;
        }
        PublicKey publicKeyC = c();
        a(publicKeyC);
        return publicKeyC;
    }

    private void a(PublicKey publicKey) {
        if (com.amazon.a.a.o.c.f9994a) {
            f9980a.a("Placing auth key into storage");
        }
        this.f9986g.a(com.amazon.a.a.m.c.f9765a, publicKey);
    }

    public PublicKey a(String str) throws com.amazon.a.a.o.b.a.a {
        try {
            return KeyFactory.getInstance(f9984e).generatePublic(new X509EncodedKeySpec(com.amazon.c.a.a.c.a(str.replace(f9982c, "").replace(f9983d, ""))));
        } catch (Exception e7) {
            throw com.amazon.a.a.o.b.a.a.a((Throwable) e7);
        }
    }
}

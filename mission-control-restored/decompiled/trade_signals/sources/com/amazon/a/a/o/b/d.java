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
    private static final com.amazon.a.a.o.c f14091a = new com.amazon.a.a.o.c("DataAuthenticationKeyLoaderV3");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14092b = "AppstoreAuthenticationKey.pem";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14093c = "-----BEGIN PUBLIC KEY-----";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14094d = "-----END PUBLIC KEY-----";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f14095e = "RSA";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private Application f14096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c f14097g;

    private PublicKey b() {
        if (com.amazon.a.a.o.c.f14105a) {
            f14091a.a("Checking KiwiDataStore for key...");
        }
        PublicKey publicKey = (PublicKey) this.f14097g.a(com.amazon.a.a.m.c.f13876a);
        if (com.amazon.a.a.o.c.f14105a) {
            com.amazon.a.a.o.c cVar = f14091a;
            StringBuilder sb = new StringBuilder();
            sb.append("Key was cached: ");
            sb.append(publicKey != null);
            cVar.a(sb.toString());
        }
        return publicKey;
    }

    private PublicKey c() throws Throwable {
        if (com.amazon.a.a.o.c.f14105a) {
            f14091a.a("Loading authentication key from apk...");
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(this.f14096f.getAssets().open(f14092b)));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line != null) {
                            sb.append(line);
                        } else {
                            try {
                                break;
                            } catch (IOException e8) {
                                if (com.amazon.a.a.o.c.f14105a) {
                                    f14091a.b("Failed to close stream", e8);
                                }
                            }
                        }
                    } catch (Exception e9) {
                        e = e9;
                        f14091a.b("Unable to load authentication Key", e);
                        throw com.amazon.a.a.o.b.a.a.d();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                if (com.amazon.a.a.o.c.f14105a) {
                                    f14091a.b("Failed to close stream", e10);
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
        } catch (Exception e11) {
            e = e11;
        }
    }

    @Override // com.amazon.a.a.o.b.b
    public PublicKey a() throws Throwable {
        if (com.amazon.a.a.o.c.f14105a) {
            f14091a.a("Loading data authentication key...");
        }
        PublicKey publicKeyB = b();
        if (publicKeyB != null) {
            return publicKeyB;
        }
        PublicKey publicKeyC = c();
        a(publicKeyC);
        return publicKeyC;
    }

    public PublicKey a(String str) throws com.amazon.a.a.o.b.a.a {
        try {
            return KeyFactory.getInstance(f14095e).generatePublic(new X509EncodedKeySpec(com.amazon.c.a.a.c.a(str.replace(f14093c, "").replace(f14094d, ""))));
        } catch (Exception e8) {
            throw com.amazon.a.a.o.b.a.a.a((Throwable) e8);
        }
    }

    private void a(PublicKey publicKey) {
        if (com.amazon.a.a.o.c.f14105a) {
            f14091a.a("Placing auth key into storage");
        }
        this.f14097g.a(com.amazon.a.a.m.c.f13876a, publicKey);
    }
}

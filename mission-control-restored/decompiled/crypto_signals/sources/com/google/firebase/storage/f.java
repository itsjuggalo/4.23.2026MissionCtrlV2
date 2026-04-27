package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.I;
import f2.C0598d;
import h2.InterfaceC0620b;
import j2.InterfaceC0725a;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z1.h f5552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X2.b f5553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final X2.b f5554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5555d;
    public long e = 600000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5556f = 600000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5557g = 120000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public E2.a f5558h;

    public f(String str, Z1.h hVar, X2.b bVar, X2.b bVar2) {
        this.f5555d = str;
        this.f5552a = hVar;
        this.f5553b = bVar;
        this.f5554c = bVar2;
        if (bVar2 == null || bVar2.get() == null) {
            return;
        }
        ((C0598d) ((InterfaceC0620b) bVar2.get())).a(new N1.A(21));
    }

    public static f c(Z1.h hVar, Uri uri) {
        f fVar;
        String host = uri != null ? uri.getHost() : null;
        if (uri != null && !TextUtils.isEmpty(uri.getPath())) {
            throw new IllegalArgumentException("The storage Uri cannot contain a path element.");
        }
        g gVar = (g) hVar.c(g.class);
        I.h(gVar, "Firebase Storage component is not present.");
        synchronized (gVar) {
            fVar = (f) gVar.f5559a.get(host);
            if (fVar == null) {
                fVar = new f(host, gVar.f5560b, gVar.f5561c, gVar.f5562d);
                gVar.f5559a.put(host, fVar);
            }
        }
        return fVar;
    }

    public final InterfaceC0620b a() {
        X2.b bVar = this.f5554c;
        if (bVar != null) {
            return (InterfaceC0620b) bVar.get();
        }
        return null;
    }

    public final InterfaceC0725a b() {
        X2.b bVar = this.f5553b;
        if (bVar != null) {
            return (InterfaceC0725a) bVar.get();
        }
        return null;
    }

    public final m d(String str) {
        String strReplace;
        I.a("location must not be null or empty", !TextUtils.isEmpty(str));
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("gs://") || lowerCase.startsWith("https://") || lowerCase.startsWith("http://")) {
            throw new IllegalArgumentException("location should not be a full URL.");
        }
        String str2 = this.f5555d;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalStateException("FirebaseApp was not initialized with a bucket name.");
        }
        Uri uriBuild = new Uri.Builder().scheme("gs").authority(str2).path("/").build();
        I.h(uriBuild, "uri must not be null");
        I.a("The supplied bucketname does not match the storage bucket of the current instance.", TextUtils.isEmpty(str2) || uriBuild.getAuthority().equalsIgnoreCase(str2));
        I.a("childName cannot be null or empty", !TextUtils.isEmpty(str));
        String strG = y5.a.G(str);
        Uri.Builder builderBuildUpon = uriBuild.buildUpon();
        if (TextUtils.isEmpty(strG)) {
            strReplace = "";
        } else {
            String strEncode = Uri.encode(strG);
            I.g(strEncode);
            strReplace = strEncode.replace("%2F", "/");
        }
        return new m(builderBuildUpon.appendEncodedPath(strReplace).build(), this);
    }
}

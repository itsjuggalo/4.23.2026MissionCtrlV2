package com.google.firebase.storage;

import a3.InterfaceC0841b;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.io.UnsupportedEncodingException;
import u3.C2752a;

/* JADX INFO: renamed from: com.google.firebase.storage.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1220f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q2.g f12430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final N3.b f12431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final N3.b f12432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12434e = 600000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f12435f = 60000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f12436g = 600000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f12437h = 120000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C2752a f12438i;

    public C1220f(String str, Q2.g gVar, N3.b bVar, N3.b bVar2) {
        this.f12433d = str;
        this.f12430a = gVar;
        this.f12431b = bVar;
        this.f12432c = bVar2;
        if (bVar2 == null || bVar2.get() == null) {
            return;
        }
        ((Y2.b) bVar2.get()).c(new a());
    }

    public static C1220f f(Q2.g gVar, String str) {
        AbstractC1207s.b(gVar != null, "Null is not a valid value for the FirebaseApp.");
        AbstractC1207s.b(str != null, "Null is not a valid value for the Firebase Storage URL.");
        if (!str.toLowerCase().startsWith("gs://")) {
            throw new IllegalArgumentException("Please use a gs:// URL for your Firebase Storage bucket.");
        }
        try {
            return g(gVar, e4.i.d(gVar, str));
        } catch (UnsupportedEncodingException e7) {
            Log.e("FirebaseStorage", "Unable to parse url:" + str, e7);
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
    }

    public static C1220f g(Q2.g gVar, Uri uri) {
        String host = uri != null ? uri.getHost() : null;
        if (uri != null && !TextUtils.isEmpty(uri.getPath())) {
            throw new IllegalArgumentException("The storage Uri cannot contain a path element.");
        }
        AbstractC1207s.l(gVar, "Provided FirebaseApp must not be null.");
        C1221g c1221g = (C1221g) gVar.k(C1221g.class);
        AbstractC1207s.l(c1221g, "Firebase Storage component is not present.");
        return c1221g.a(host);
    }

    public Q2.g a() {
        return this.f12430a;
    }

    public Y2.b b() {
        N3.b bVar = this.f12432c;
        if (bVar != null) {
            return (Y2.b) bVar.get();
        }
        return null;
    }

    public InterfaceC0841b c() {
        N3.b bVar = this.f12431b;
        if (bVar != null) {
            return (InterfaceC0841b) bVar.get();
        }
        return null;
    }

    public final String d() {
        return this.f12433d;
    }

    public C2752a e() {
        return this.f12438i;
    }

    public long h() {
        return this.f12435f;
    }

    public long i() {
        return this.f12436g;
    }

    public long j() {
        return this.f12437h;
    }

    public long k() {
        return this.f12434e;
    }

    public p l() {
        if (TextUtils.isEmpty(d())) {
            throw new IllegalStateException("FirebaseApp was not initialized with a bucket name.");
        }
        return m(new Uri.Builder().scheme("gs").authority(d()).path("/").build());
    }

    public final p m(Uri uri) {
        AbstractC1207s.l(uri, "uri must not be null");
        String strD = d();
        AbstractC1207s.b(TextUtils.isEmpty(strD) || uri.getAuthority().equalsIgnoreCase(strD), "The supplied bucketname does not match the storage bucket of the current instance.");
        return new p(uri, this);
    }

    public p n(String str) {
        AbstractC1207s.b(!TextUtils.isEmpty(str), "location must not be null or empty");
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("gs://") || lowerCase.startsWith("https://") || lowerCase.startsWith("http://")) {
            throw new IllegalArgumentException("location should not be a full URL.");
        }
        return l().b(str);
    }

    public void o(long j7) {
        this.f12436g = j7;
    }

    public void p(long j7) {
        this.f12437h = j7;
    }

    public void q(long j7) {
        this.f12434e = j7;
    }

    public void r(String str, int i7) {
        this.f12438i = new C2752a(str, i7);
    }

    /* JADX INFO: renamed from: com.google.firebase.storage.f$a */
    public class a implements Y2.a {
        public a() {
        }

        @Override // Y2.a
        public void a(V2.b bVar) {
        }
    }
}

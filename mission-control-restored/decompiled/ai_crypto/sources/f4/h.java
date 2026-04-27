package f4;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class h extends f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f14138n = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Uri f14139m;

    public h(e4.h hVar, Q2.g gVar, Uri uri) {
        super(hVar, gVar);
        f14138n = true;
        this.f14139m = uri;
        super.G("X-Goog-Upload-Protocol", "resumable");
        super.G("X-Goog-Upload-Command", "cancel");
    }

    @Override // f4.e
    public String e() {
        return "POST";
    }

    @Override // f4.e
    public Uri u() {
        return this.f14139m;
    }
}

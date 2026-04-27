package f4;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class i extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Uri f14140m;

    public i(e4.h hVar, Q2.g gVar, Uri uri) {
        super(hVar, gVar);
        this.f14140m = uri;
        super.G("X-Goog-Upload-Protocol", "resumable");
        super.G("X-Goog-Upload-Command", "query");
    }

    @Override // f4.e
    public String e() {
        return "POST";
    }

    @Override // f4.e
    public Uri u() {
        return this.f14140m;
    }
}

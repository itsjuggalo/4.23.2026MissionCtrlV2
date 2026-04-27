package f4;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Uri f14133m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final byte[] f14134n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f14135o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f14136p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f14137q;

    public g(e4.h hVar, Q2.g gVar, Uri uri, byte[] bArr, long j7, int i7, boolean z7) {
        super(hVar, gVar);
        if (bArr == null && i7 != -1) {
            this.f14123a = new IllegalArgumentException("contentType is null or empty");
        }
        if (j7 < 0) {
            this.f14123a = new IllegalArgumentException("offset cannot be negative");
        }
        this.f14137q = i7;
        this.f14133m = uri;
        this.f14134n = i7 <= 0 ? null : bArr;
        this.f14135o = j7;
        this.f14136p = z7;
        super.G("X-Goog-Upload-Protocol", "resumable");
        if (z7 && i7 > 0) {
            super.G("X-Goog-Upload-Command", "upload, finalize");
        } else if (z7) {
            super.G("X-Goog-Upload-Command", "finalize");
        } else {
            super.G("X-Goog-Upload-Command", "upload");
        }
        super.G("X-Goog-Upload-Offset", Long.toString(j7));
    }

    @Override // f4.e
    public String e() {
        return "POST";
    }

    @Override // f4.e
    public byte[] h() {
        return this.f14134n;
    }

    @Override // f4.e
    public int i() {
        int i7 = this.f14137q;
        if (i7 > 0) {
            return i7;
        }
        return 0;
    }

    @Override // f4.e
    public Uri u() {
        return this.f14133m;
    }
}

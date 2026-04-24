package p2;

import com.google.android.play.core.install.InstallState;

/* JADX INFO: renamed from: p2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2546c extends InstallState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f22258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22259e;

    public C2546c(int i8, long j8, long j9, int i9, String str) {
        this.f22255a = i8;
        this.f22256b = j8;
        this.f22257c = j9;
        this.f22258d = i9;
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.f22259e = str;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long a() {
        return this.f22256b;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int b() {
        return this.f22258d;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int c() {
        return this.f22255a;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String d() {
        return this.f22259e;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long e() {
        return this.f22257c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            if (this.f22255a == installState.c() && this.f22256b == installState.a() && this.f22257c == installState.e() && this.f22258d == installState.b() && this.f22259e.equals(installState.d())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i8 = this.f22255a ^ 1000003;
        long j8 = this.f22256b;
        long j9 = this.f22257c;
        return (((((((i8 * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003) ^ this.f22258d) * 1000003) ^ this.f22259e.hashCode();
    }

    public final String toString() {
        return "InstallState{installStatus=" + this.f22255a + ", bytesDownloaded=" + this.f22256b + ", totalBytesToDownload=" + this.f22257c + ", installErrorCode=" + this.f22258d + ", packageName=" + this.f22259e + "}";
    }
}

package k6;

import android.app.PendingIntent;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f14732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14733b;

    public e(PendingIntent pendingIntent, boolean z10) {
        if (pendingIntent == null) {
            throw new NullPointerException("Null pendingIntent");
        }
        this.f14732a = pendingIntent;
        this.f14733b = z10;
    }

    @Override // k6.b
    public final PendingIntent a() {
        return this.f14732a;
    }

    @Override // k6.b
    public final boolean b() {
        return this.f14733b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f14732a.equals(bVar.a()) && this.f14733b == bVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f14732a.hashCode() ^ 1000003) * 1000003) ^ (true != this.f14733b ? 1237 : 1231);
    }

    public final String toString() {
        return "ReviewInfo{pendingIntent=" + this.f14732a.toString() + ", isNoOp=" + this.f14733b + "}";
    }
}

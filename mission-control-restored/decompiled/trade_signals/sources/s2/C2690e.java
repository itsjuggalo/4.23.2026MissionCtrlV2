package s2;

import android.app.PendingIntent;

/* JADX INFO: renamed from: s2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2690e extends AbstractC2687b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f23068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23069b;

    public C2690e(PendingIntent pendingIntent, boolean z7) {
        if (pendingIntent == null) {
            throw new NullPointerException("Null pendingIntent");
        }
        this.f23068a = pendingIntent;
        this.f23069b = z7;
    }

    @Override // s2.AbstractC2687b
    public final PendingIntent a() {
        return this.f23068a;
    }

    @Override // s2.AbstractC2687b
    public final boolean b() {
        return this.f23069b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2687b) {
            AbstractC2687b abstractC2687b = (AbstractC2687b) obj;
            if (this.f23068a.equals(abstractC2687b.a()) && this.f23069b == abstractC2687b.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f23068a.hashCode() ^ 1000003) * 1000003) ^ (true != this.f23069b ? 1237 : 1231);
    }

    public final String toString() {
        return "ReviewInfo{pendingIntent=" + this.f23068a.toString() + ", isNoOp=" + this.f23069b + "}";
    }
}

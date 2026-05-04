package c6;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f3701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3700b = new a(null);
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public j(PendingIntent pendingIntent) {
        t.f(pendingIntent, "pendingIntent");
        this.f3701a = pendingIntent;
    }

    public final PendingIntent R() {
        return this.f3701a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        t.f(dest, "dest");
        k.c(this, dest, i10);
    }
}

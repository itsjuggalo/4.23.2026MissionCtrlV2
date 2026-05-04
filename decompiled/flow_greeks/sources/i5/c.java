package i5;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f11808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11807b = new a(null);
    public static final Parcelable.Creator<c> CREATOR = new d();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public c(Bundle requestBundle) {
        t.f(requestBundle, "requestBundle");
        this.f11808a = requestBundle;
    }

    public final Bundle R() {
        return this.f11808a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        t.f(dest, "dest");
        d.c(this, dest, i10);
    }
}

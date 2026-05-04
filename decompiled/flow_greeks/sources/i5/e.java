package i5;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f11810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11809b = new a(null);
    public static final Parcelable.Creator<e> CREATOR = new f();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public e(Bundle responseBundle) {
        t.f(responseBundle, "responseBundle");
        this.f11810a = responseBundle;
    }

    public final Bundle R() {
        return this.f11810a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        t.f(dest, "dest");
        f.c(this, dest, i10);
    }
}

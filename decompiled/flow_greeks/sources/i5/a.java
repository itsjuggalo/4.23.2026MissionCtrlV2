package i5;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f11806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0223a f11805b = new C0223a(null);
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* JADX INFO: renamed from: i5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0223a {
        public C0223a() {
        }

        public /* synthetic */ C0223a(k kVar) {
            this();
        }
    }

    public a(Bundle requestBundle) {
        t.f(requestBundle, "requestBundle");
        this.f11806a = requestBundle;
    }

    public final Bundle R() {
        return this.f11806a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        t.f(dest, "dest");
        b.c(this, dest, i10);
    }
}

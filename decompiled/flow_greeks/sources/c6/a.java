package c6;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0068a f3688b = new C0068a(null);
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* JADX INFO: renamed from: c6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0068a {
        public C0068a() {
        }

        public /* synthetic */ C0068a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public a(boolean z10) {
        this.f3689a = z10;
    }

    public final boolean R() {
        return this.f3689a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        t.f(dest, "dest");
        b.c(this, dest, i10);
    }
}

package c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import c.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3408a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f3409b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.a f3410c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    /* JADX INFO: renamed from: c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class BinderC0065b extends a.AbstractBinderC0063a {
        public BinderC0065b() {
        }

        @Override // c.a
        public void G(int i10, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f3409b;
            if (handler != null) {
                handler.post(bVar.new c(i10, bundle));
            } else {
                bVar.a(i10, bundle);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f3413b;

        public c(int i10, Bundle bundle) {
            this.f3412a = i10;
            this.f3413b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f3412a, this.f3413b);
        }
    }

    public b(Parcel parcel) {
        this.f3410c = a.AbstractBinderC0063a.H(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        synchronized (this) {
            try {
                if (this.f3410c == null) {
                    this.f3410c = new BinderC0065b();
                }
                parcel.writeStrongBinder(this.f3410c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i10, Bundle bundle) {
    }
}

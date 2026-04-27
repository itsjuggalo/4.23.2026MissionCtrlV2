package c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import c.InterfaceC0869a;

/* JADX INFO: loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8294a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f8295b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0869a f8296c;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i4) {
            return new b[i4];
        }
    }

    /* JADX INFO: renamed from: c.b$b, reason: collision with other inner class name */
    public class BinderC0127b extends InterfaceC0869a.AbstractBinderC0125a {
        public BinderC0127b() {
        }

        @Override // c.InterfaceC0869a
        public void Z(int i4, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f8295b;
            if (handler != null) {
                handler.post(bVar.new c(i4, bundle));
            } else {
                bVar.a(i4, bundle);
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f8299b;

        public c(int i4, Bundle bundle) {
            this.f8298a = i4;
            this.f8299b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f8298a, this.f8299b);
        }
    }

    public b(Parcel parcel) {
        this.f8296c = InterfaceC0869a.AbstractBinderC0125a.b(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        synchronized (this) {
            try {
                if (this.f8296c == null) {
                    this.f8296c = new BinderC0127b();
                }
                parcel.writeStrongBinder(this.f8296c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i4, Bundle bundle) {
    }
}

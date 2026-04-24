package c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import c.InterfaceC1108a;

/* JADX INFO: renamed from: c.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1109b implements Parcelable {
    public static final Parcelable.Creator<C1109b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9103a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f9104b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC1108a f9105c;

    /* JADX INFO: renamed from: c.b$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1109b createFromParcel(Parcel parcel) {
            return new C1109b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1109b[] newArray(int i7) {
            return new C1109b[i7];
        }
    }

    /* JADX INFO: renamed from: c.b$b, reason: collision with other inner class name */
    public class BinderC0151b extends InterfaceC1108a.AbstractBinderC0149a {
        public BinderC0151b() {
        }

        @Override // c.InterfaceC1108a
        public void Y(int i7, Bundle bundle) {
            C1109b c1109b = C1109b.this;
            Handler handler = c1109b.f9104b;
            if (handler != null) {
                handler.post(c1109b.new c(i7, bundle));
            } else {
                c1109b.a(i7, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: c.b$c */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f9108b;

        public c(int i7, Bundle bundle) {
            this.f9107a = i7;
            this.f9108b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1109b.this.a(this.f9107a, this.f9108b);
        }
    }

    public C1109b(Parcel parcel) {
        this.f9105c = InterfaceC1108a.AbstractBinderC0149a.b(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        synchronized (this) {
            try {
                if (this.f9105c == null) {
                    this.f9105c = new BinderC0151b();
                }
                parcel.writeStrongBinder(this.f9105c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i7, Bundle bundle) {
    }
}

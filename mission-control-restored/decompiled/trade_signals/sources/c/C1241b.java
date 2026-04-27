package c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import c.InterfaceC1240a;

/* JADX INFO: renamed from: c.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1241b implements Parcelable {
    public static final Parcelable.Creator<C1241b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13321a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f13322b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC1240a f13323c;

    /* JADX INFO: renamed from: c.b$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1241b createFromParcel(Parcel parcel) {
            return new C1241b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1241b[] newArray(int i8) {
            return new C1241b[i8];
        }
    }

    /* JADX INFO: renamed from: c.b$b, reason: collision with other inner class name */
    public class BinderC0228b extends InterfaceC1240a.AbstractBinderC0226a {
        public BinderC0228b() {
        }

        @Override // c.InterfaceC1240a
        public void C(int i8, Bundle bundle) {
            C1241b c1241b = C1241b.this;
            Handler handler = c1241b.f13322b;
            if (handler != null) {
                handler.post(c1241b.new c(i8, bundle));
            } else {
                c1241b.a(i8, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: c.b$c */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f13326b;

        public c(int i8, Bundle bundle) {
            this.f13325a = i8;
            this.f13326b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1241b.this.a(this.f13325a, this.f13326b);
        }
    }

    public C1241b(Parcel parcel) {
        this.f13323c = InterfaceC1240a.AbstractBinderC0226a.D(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        synchronized (this) {
            try {
                if (this.f13323c == null) {
                    this.f13323c = new BinderC0228b();
                }
                parcel.writeStrongBinder(this.f13323c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i8, Bundle bundle) {
    }
}

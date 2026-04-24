package t;

import android.app.Notification;
import android.os.Parcel;
import b.C0369a;
import b.InterfaceC0371c;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Notification f9784d;

    public S(String str, int i, String str2, Notification notification) {
        this.f9781a = str;
        this.f9782b = i;
        this.f9783c = str2;
        this.f9784d = notification;
    }

    public final void a(InterfaceC0371c interfaceC0371c) {
        String str = this.f9781a;
        int i = this.f9782b;
        String str2 = this.f9783c;
        C0369a c0369a = (C0369a) interfaceC0371c;
        c0369a.getClass();
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(InterfaceC0371c.f4808g);
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i);
            parcelObtain.writeString(str2);
            Notification notification = this.f9784d;
            if (notification != null) {
                parcelObtain.writeInt(1);
                notification.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            c0369a.f4806a.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NotifyTask[packageName:");
        sb.append(this.f9781a);
        sb.append(", id:");
        sb.append(this.f9782b);
        sb.append(", tag:");
        return AbstractC1024h.d(sb, this.f9783c, "]");
    }
}

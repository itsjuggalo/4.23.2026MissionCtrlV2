package j2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import t2.u0;
import v1.InterfaceC1257c;

/* JADX INFO: loaded from: classes.dex */
public final class U implements InterfaceC1257c {
    public static final Parcelable.Creator<U> CREATOR = new C0727c(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0730f f7668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f7669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i2.I f7670c;

    public U(C0730f c0730f) {
        com.google.android.gms.common.internal.I.g(c0730f);
        this.f7668a = c0730f;
        ArrayList arrayList = c0730f.e;
        this.f7669b = null;
        for (int i = 0; i < arrayList.size(); i++) {
            if (!TextUtils.isEmpty(((C0728d) arrayList.get(i)).f7686m)) {
                this.f7669b = new T(((C0728d) arrayList.get(i)).f7680b, ((C0728d) arrayList.get(i)).f7686m, c0730f.f7695n);
            }
        }
        if (this.f7669b == null) {
            this.f7669b = new T(c0730f.f7695n);
        }
        this.f7670c = c0730f.f7696o;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.S(parcel, 1, this.f7668a, i, false);
        u0.S(parcel, 2, this.f7669b, i, false);
        u0.S(parcel, 3, this.f7670c, i, false);
        u0.a0(iX, parcel);
    }

    public U(C0730f c0730f, T t6, i2.I i) {
        this.f7668a = c0730f;
        this.f7669b = t6;
        this.f7670c = i;
    }
}

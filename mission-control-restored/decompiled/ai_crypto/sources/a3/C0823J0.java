package a3;

import Z2.AbstractC0759h;
import Z2.InterfaceC0757g;
import Z2.InterfaceC0761i;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.List;

/* JADX INFO: renamed from: a3.J0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0823J0 implements InterfaceC0761i {
    public static final Parcelable.Creator<C0823J0> CREATOR = new C0821I0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0855i f6148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0819H0 f6149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Z2.y0 f6150c;

    public C0823J0(C0855i c0855i) {
        C0855i c0855i2 = (C0855i) AbstractC1207s.k(c0855i);
        this.f6148a = c0855i2;
        List listJ0 = c0855i2.j0();
        this.f6149b = null;
        for (int i7 = 0; i7 < listJ0.size(); i7++) {
            if (!TextUtils.isEmpty(((C0847e) listJ0.get(i7)).zza())) {
                this.f6149b = new C0819H0(((C0847e) listJ0.get(i7)).b(), ((C0847e) listJ0.get(i7)).zza(), c0855i.k0());
            }
        }
        if (this.f6149b == null) {
            this.f6149b = new C0819H0(c0855i.k0());
        }
        this.f6150c = c0855i.h0();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // Z2.InterfaceC0761i
    public final InterfaceC0757g r() {
        return this.f6149b;
    }

    @Override // Z2.InterfaceC0761i
    public final AbstractC0759h s() {
        return this.f6150c;
    }

    @Override // Z2.InterfaceC0761i
    public final Z2.A w() {
        return this.f6148a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 1, w(), i7, false);
        Q1.c.C(parcel, 2, r(), i7, false);
        Q1.c.C(parcel, 3, this.f6150c, i7, false);
        Q1.c.b(parcel, iA);
    }

    public C0823J0(C0855i c0855i, C0819H0 c0819h0, Z2.y0 y0Var) {
        this.f6148a = c0855i;
        this.f6149b = c0819h0;
        this.f6150c = y0Var;
    }
}

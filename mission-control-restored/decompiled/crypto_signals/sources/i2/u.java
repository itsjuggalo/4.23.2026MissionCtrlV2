package i2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public final class u extends AbstractC0658d implements Cloneable {
    public static final Parcelable.Creator<u> CREATOR = new com.google.android.gms.common.internal.Q(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6809d;
    public final String e;

    public u(String str, String str2, String str3, String str4, boolean z6) {
        com.google.android.gms.common.internal.I.a("Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) ? false : true);
        this.f6806a = str;
        this.f6807b = str2;
        this.f6808c = str3;
        this.f6809d = z6;
        this.e = str4;
    }

    public static u p(String str, String str2) {
        return new u(str, str2, null, null, true);
    }

    public final Object clone() {
        boolean z6 = this.f6809d;
        return new u(this.f6806a, this.f6807b, this.f6808c, this.e, z6);
    }

    @Override // i2.AbstractC0658d
    public final String m() {
        return "phone";
    }

    @Override // i2.AbstractC0658d
    public final String n() {
        return "phone";
    }

    @Override // i2.AbstractC0658d
    public final AbstractC0658d o() {
        return (u) clone();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.T(parcel, 1, this.f6806a, false);
        u0.T(parcel, 2, this.f6807b, false);
        u0.T(parcel, 4, this.f6808c, false);
        boolean z6 = this.f6809d;
        u0.b0(parcel, 5, 4);
        parcel.writeInt(z6 ? 1 : 0);
        u0.T(parcel, 6, this.e, false);
        u0.a0(iX, parcel);
    }
}

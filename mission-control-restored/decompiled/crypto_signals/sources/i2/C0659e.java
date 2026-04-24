package i2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import t2.u0;

/* JADX INFO: renamed from: i2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0659e extends AbstractC0658d {
    public static final Parcelable.Creator<C0659e> CREATOR = new com.google.android.gms.common.internal.Q(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6791d;
    public boolean e;

    public C0659e(String str, String str2, String str3, String str4, boolean z6) {
        com.google.android.gms.common.internal.I.d(str);
        this.f6788a = str;
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.f6789b = str2;
        this.f6790c = str3;
        this.f6791d = str4;
        this.e = z6;
    }

    @Override // i2.AbstractC0658d
    public final String m() {
        return "password";
    }

    @Override // i2.AbstractC0658d
    public final String n() {
        return !TextUtils.isEmpty(this.f6789b) ? "password" : "emailLink";
    }

    @Override // i2.AbstractC0658d
    public final AbstractC0658d o() {
        return new C0659e(this.f6788a, this.f6789b, this.f6790c, this.f6791d, this.e);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.T(parcel, 1, this.f6788a, false);
        u0.T(parcel, 2, this.f6789b, false);
        u0.T(parcel, 3, this.f6790c, false);
        u0.T(parcel, 4, this.f6791d, false);
        boolean z6 = this.e;
        u0.b0(parcel, 5, 4);
        parcel.writeInt(z6 ? 1 : 0);
        u0.a0(iX, parcel);
    }
}

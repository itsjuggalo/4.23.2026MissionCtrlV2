package i2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public final class I extends AbstractC0658d {
    public static final Parcelable.Creator<I> CREATOR = new com.google.android.gms.common.internal.Q(15);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzajb f6736d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f6737f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f6738k;

    public I(String str, String str2, String str3, zzajb zzajbVar, String str4, String str5, String str6) {
        this.f6733a = zzac.zzb(str);
        this.f6734b = str2;
        this.f6735c = str3;
        this.f6736d = zzajbVar;
        this.e = str4;
        this.f6737f = str5;
        this.f6738k = str6;
    }

    public static I p(zzajb zzajbVar) {
        com.google.android.gms.common.internal.I.h(zzajbVar, "Must specify a non-null webSignInCredential");
        return new I(null, null, null, zzajbVar, null, null, null);
    }

    @Override // i2.AbstractC0658d
    public final String m() {
        return this.f6733a;
    }

    @Override // i2.AbstractC0658d
    public final String n() {
        return this.f6733a;
    }

    @Override // i2.AbstractC0658d
    public final AbstractC0658d o() {
        return new I(this.f6733a, this.f6734b, this.f6735c, this.f6736d, this.e, this.f6737f, this.f6738k);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.T(parcel, 1, this.f6733a, false);
        u0.T(parcel, 2, this.f6734b, false);
        u0.T(parcel, 3, this.f6735c, false);
        u0.S(parcel, 4, this.f6736d, i, false);
        u0.T(parcel, 5, this.e, false);
        u0.T(parcel, 6, this.f6737f, false);
        u0.T(parcel, 7, this.f6738k, false);
        u0.a0(iX, parcel);
    }
}

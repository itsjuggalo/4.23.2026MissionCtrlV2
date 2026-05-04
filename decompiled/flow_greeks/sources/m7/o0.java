package m7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.flutter.plugins.firebase.auth.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o0 extends h implements Cloneable {
    public static final Parcelable.Creator<o0> CREATOR = new q1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16051e;

    public o0(String str, String str2, String str3, boolean z10, String str4) {
        com.google.android.gms.common.internal.s.b(((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) ? false : true, "Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.");
        this.f16047a = str;
        this.f16048b = str2;
        this.f16049c = str3;
        this.f16050d = z10;
        this.f16051e = str4;
    }

    public static o0 V(String str, String str2) {
        return new o0(str, str2, null, true, null);
    }

    public static o0 Y(String str, String str2) {
        return new o0(null, null, str, true, str2);
    }

    @Override // m7.h
    public String R() {
        return Constants.SIGN_IN_METHOD_PHONE;
    }

    @Override // m7.h
    public String S() {
        return Constants.SIGN_IN_METHOD_PHONE;
    }

    @Override // m7.h
    public final h T() {
        return (o0) clone();
    }

    public String U() {
        return this.f16048b;
    }

    public final o0 W(boolean z10) {
        this.f16050d = false;
        return this;
    }

    public final String X() {
        return this.f16049c;
    }

    public final boolean Z() {
        return this.f16050d;
    }

    public /* synthetic */ Object clone() {
        return new o0(this.f16047a, U(), this.f16049c, this.f16050d, this.f16051e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, this.f16047a, false);
        n5.c.E(parcel, 2, U(), false);
        n5.c.E(parcel, 4, this.f16049c, false);
        n5.c.g(parcel, 5, this.f16050d);
        n5.c.E(parcel, 6, this.f16051e, false);
        n5.c.b(parcel, iA);
    }

    public final String zzc() {
        return this.f16047a;
    }

    public final String zzd() {
        return this.f16051e;
    }
}

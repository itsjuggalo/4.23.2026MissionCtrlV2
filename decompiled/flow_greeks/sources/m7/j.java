package m7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.flutter.plugins.firebase.auth.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j extends h {
    public static final Parcelable.Creator<j> CREATOR = new a2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f16032e;

    public j(String str, String str2) {
        this(str, str2, null, null, false);
    }

    public static boolean V(String str) {
        f fVarC;
        return (TextUtils.isEmpty(str) || (fVarC = f.c(str)) == null || fVarC.b() != 4) ? false : true;
    }

    @Override // m7.h
    public String R() {
        return Constants.SIGN_IN_METHOD_PASSWORD;
    }

    @Override // m7.h
    public String S() {
        return !TextUtils.isEmpty(this.f16029b) ? Constants.SIGN_IN_METHOD_PASSWORD : "emailLink";
    }

    @Override // m7.h
    public final h T() {
        return new j(this.f16028a, this.f16029b, this.f16030c, this.f16031d, this.f16032e);
    }

    public final j U(a0 a0Var) {
        this.f16031d = a0Var.zze();
        this.f16032e = true;
        return this;
    }

    public final String W() {
        return this.f16031d;
    }

    public final boolean X() {
        return !TextUtils.isEmpty(this.f16030c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, this.f16028a, false);
        n5.c.E(parcel, 2, this.f16029b, false);
        n5.c.E(parcel, 3, this.f16030c, false);
        n5.c.E(parcel, 4, this.f16031d, false);
        n5.c.g(parcel, 5, this.f16032e);
        n5.c.b(parcel, iA);
    }

    public final String zzc() {
        return this.f16028a;
    }

    public final String zzd() {
        return this.f16029b;
    }

    public final String zze() {
        return this.f16030c;
    }

    public final boolean zzg() {
        return this.f16032e;
    }

    public j(String str, String str2, String str3, String str4, boolean z10) {
        this.f16028a = com.google.android.gms.common.internal.s.e(str);
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.f16029b = str2;
        this.f16030c = str3;
        this.f16031d = str4;
        this.f16032e = z10;
    }
}

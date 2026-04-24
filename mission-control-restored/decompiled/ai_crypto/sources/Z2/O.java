package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public class O extends AbstractC0759h implements Cloneable {
    public static final Parcelable.Creator<O> CREATOR = new q0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5737e;

    public O(String str, String str2, String str3, boolean z7, String str4) {
        AbstractC1207s.b(((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) ? false : true, "Cannot create PhoneAuthCredential without either sessionInfo + smsCode or temporary proof + phoneNumber.");
        this.f5733a = str;
        this.f5734b = str2;
        this.f5735c = str3;
        this.f5736d = z7;
        this.f5737e = str4;
    }

    public static O E(String str, String str2) {
        return new O(str, str2, null, true, null);
    }

    public static O G(String str, String str2) {
        return new O(null, null, str, true, str2);
    }

    @Override // Z2.AbstractC0759h
    public String A() {
        return "phone";
    }

    @Override // Z2.AbstractC0759h
    public String B() {
        return "phone";
    }

    @Override // Z2.AbstractC0759h
    public final AbstractC0759h C() {
        return (O) clone();
    }

    public String D() {
        return this.f5734b;
    }

    public final O F(boolean z7) {
        this.f5736d = false;
        return this;
    }

    public final String H() {
        return this.f5735c;
    }

    public final boolean I() {
        return this.f5736d;
    }

    public /* synthetic */ Object clone() {
        return new O(this.f5733a, D(), this.f5735c, this.f5736d, this.f5737e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f5733a, false);
        Q1.c.E(parcel, 2, D(), false);
        Q1.c.E(parcel, 4, this.f5735c, false);
        Q1.c.g(parcel, 5, this.f5736d);
        Q1.c.E(parcel, 6, this.f5737e, false);
        Q1.c.b(parcel, iA);
    }

    public final String zzc() {
        return this.f5733a;
    }

    public final String zzd() {
        return this.f5737e;
    }
}

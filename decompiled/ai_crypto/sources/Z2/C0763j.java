package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: Z2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0763j extends AbstractC0759h {
    public static final Parcelable.Creator<C0763j> CREATOR = new A0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5799e;

    public C0763j(String str, String str2) {
        this(str, str2, null, null, false);
    }

    public static boolean E(String str) {
        C0755f c0755fC;
        return (TextUtils.isEmpty(str) || (c0755fC = C0755f.c(str)) == null || c0755fC.b() != 4) ? false : true;
    }

    @Override // Z2.AbstractC0759h
    public String A() {
        return "password";
    }

    @Override // Z2.AbstractC0759h
    public String B() {
        return !TextUtils.isEmpty(this.f5796b) ? "password" : "emailLink";
    }

    @Override // Z2.AbstractC0759h
    public final AbstractC0759h C() {
        return new C0763j(this.f5795a, this.f5796b, this.f5797c, this.f5798d, this.f5799e);
    }

    public final C0763j D(A a7) {
        this.f5798d = a7.zze();
        this.f5799e = true;
        return this;
    }

    public final String F() {
        return this.f5798d;
    }

    public final boolean G() {
        return !TextUtils.isEmpty(this.f5797c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f5795a, false);
        Q1.c.E(parcel, 2, this.f5796b, false);
        Q1.c.E(parcel, 3, this.f5797c, false);
        Q1.c.E(parcel, 4, this.f5798d, false);
        Q1.c.g(parcel, 5, this.f5799e);
        Q1.c.b(parcel, iA);
    }

    public final String zzc() {
        return this.f5795a;
    }

    public final String zzd() {
        return this.f5796b;
    }

    public final String zze() {
        return this.f5797c;
    }

    public final boolean zzg() {
        return this.f5799e;
    }

    public C0763j(String str, String str2, String str3, String str4, boolean z7) {
        this.f5795a = AbstractC1207s.e(str);
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.f5796b = str2;
        this.f5797c = str3;
        this.f5798d = str4;
        this.f5799e = z7;
    }
}

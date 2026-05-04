package y4;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b extends n5.a {
    public static final Parcelable.Creator<b> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f25270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Account f25271d;

    public b(int i10, int i11, String str, Account account) {
        this.f25268a = i10;
        this.f25269b = i11;
        this.f25270c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f25271d = account;
        } else {
            this.f25271d = new Account(str, "com.google");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f25268a);
        n5.c.t(parcel, 2, this.f25269b);
        n5.c.E(parcel, 3, this.f25270c, false);
        n5.c.C(parcel, 4, this.f25271d, i10, false);
        n5.c.b(parcel, iA);
    }
}

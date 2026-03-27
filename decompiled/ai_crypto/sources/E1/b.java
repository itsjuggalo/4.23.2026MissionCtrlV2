package E1;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class b extends Q1.a {
    public static final Parcelable.Creator<b> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Account f1585d;

    public b(int i7, int i8, String str, Account account) {
        this.f1582a = i7;
        this.f1583b = i8;
        this.f1584c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f1585d = account;
        } else {
            this.f1585d = new Account(str, "com.google");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f1582a);
        Q1.c.t(parcel, 2, this.f1583b);
        Q1.c.E(parcel, 3, this.f1584c, false);
        Q1.c.C(parcel, 4, this.f1585d, i7, false);
        Q1.c.b(parcel, iA);
    }
}

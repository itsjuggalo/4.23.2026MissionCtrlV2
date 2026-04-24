package n1;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: renamed from: n1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1616b extends A1.a {
    public static final Parcelable.Creator<C1616b> CREATOR = new C1622h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Account f13598d;

    public C1616b(int i4, int i5, String str, Account account) {
        this.f13595a = i4;
        this.f13596b = i5;
        this.f13597c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f13598d = account;
        } else {
            this.f13598d = new Account(str, "com.google");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f13595a);
        A1.c.t(parcel, 2, this.f13596b);
        A1.c.E(parcel, 3, this.f13597c, false);
        A1.c.C(parcel, 4, this.f13598d, i4, false);
        A1.c.b(parcel, iA);
    }
}

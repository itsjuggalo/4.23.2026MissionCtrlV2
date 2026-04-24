package k1;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Q;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: k1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0749b extends AbstractC1255a {
    public static final Parcelable.Creator<C0749b> CREATOR = new Q(19);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Account f7822d;

    public C0749b(int i, int i6, String str, Account account) {
        this.f7819a = i;
        this.f7820b = i6;
        this.f7821c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f7822d = account;
        } else {
            this.f7822d = new Account(str, "com.google");
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f7819a);
        u0.b0(parcel, 2, 4);
        parcel.writeInt(this.f7820b);
        u0.T(parcel, 3, this.f7821c, false);
        u0.S(parcel, 4, this.f7822d, i, false);
        u0.a0(iX, parcel);
    }
}

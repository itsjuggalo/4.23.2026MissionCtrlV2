package o1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.common.internal.Q;
import java.util.ArrayList;
import java.util.Arrays;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: o1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0884a extends AbstractC1255a {
    public static final Parcelable.Creator<C0884a> CREATOR = new Q(28);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f8630d;
    public final GoogleSignInAccount e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PendingIntent f8631f;

    public C0884a(String str, String str2, String str3, ArrayList arrayList, GoogleSignInAccount googleSignInAccount, PendingIntent pendingIntent) {
        this.f8627a = str;
        this.f8628b = str2;
        this.f8629c = str3;
        I.g(arrayList);
        this.f8630d = arrayList;
        this.f8631f = pendingIntent;
        this.e = googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0884a)) {
            return false;
        }
        C0884a c0884a = (C0884a) obj;
        return I.j(this.f8627a, c0884a.f8627a) && I.j(this.f8628b, c0884a.f8628b) && I.j(this.f8629c, c0884a.f8629c) && I.j(this.f8630d, c0884a.f8630d) && I.j(this.f8631f, c0884a.f8631f) && I.j(this.e, c0884a.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8627a, this.f8628b, this.f8629c, this.f8630d, this.f8631f, this.e});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.T(parcel, 1, this.f8627a, false);
        u0.T(parcel, 2, this.f8628b, false);
        u0.T(parcel, 3, this.f8629c, false);
        u0.U(parcel, 4, this.f8630d);
        u0.S(parcel, 5, this.e, i, false);
        u0.S(parcel, 6, this.f8631f, i, false);
        u0.a0(iX, parcel);
    }
}

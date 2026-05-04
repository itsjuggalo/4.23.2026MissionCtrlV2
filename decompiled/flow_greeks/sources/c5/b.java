package c5;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends n5.a {
    public static final Parcelable.Creator<b> CREATOR = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f3604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GoogleSignInAccount f3605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PendingIntent f3606f;

    public b(String str, String str2, String str3, List list, GoogleSignInAccount googleSignInAccount, PendingIntent pendingIntent) {
        this.f3601a = str;
        this.f3602b = str2;
        this.f3603c = str3;
        this.f3604d = (List) com.google.android.gms.common.internal.s.k(list);
        this.f3606f = pendingIntent;
        this.f3605e = googleSignInAccount;
    }

    public String R() {
        return this.f3602b;
    }

    public List S() {
        return this.f3604d;
    }

    public PendingIntent T() {
        return this.f3606f;
    }

    public String U() {
        return this.f3601a;
    }

    public boolean V() {
        return this.f3606f != null;
    }

    public GoogleSignInAccount W() {
        return this.f3605e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return com.google.android.gms.common.internal.q.b(this.f3601a, bVar.f3601a) && com.google.android.gms.common.internal.q.b(this.f3602b, bVar.f3602b) && com.google.android.gms.common.internal.q.b(this.f3603c, bVar.f3603c) && com.google.android.gms.common.internal.q.b(this.f3604d, bVar.f3604d) && com.google.android.gms.common.internal.q.b(this.f3606f, bVar.f3606f) && com.google.android.gms.common.internal.q.b(this.f3605e, bVar.f3605e);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f3601a, this.f3602b, this.f3603c, this.f3604d, this.f3606f, this.f3605e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, U(), false);
        n5.c.E(parcel, 2, R(), false);
        n5.c.E(parcel, 3, this.f3603c, false);
        n5.c.G(parcel, 4, S(), false);
        n5.c.C(parcel, 5, W(), i10, false);
        n5.c.C(parcel, 6, T(), i10, false);
        n5.c.b(parcel, iA);
    }
}

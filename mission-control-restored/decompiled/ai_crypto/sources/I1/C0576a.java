package I1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.List;

/* JADX INFO: renamed from: I1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0576a extends Q1.a {
    public static final Parcelable.Creator<C0576a> CREATOR = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f2867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GoogleSignInAccount f2868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PendingIntent f2869f;

    public C0576a(String str, String str2, String str3, List list, GoogleSignInAccount googleSignInAccount, PendingIntent pendingIntent) {
        this.f2864a = str;
        this.f2865b = str2;
        this.f2866c = str3;
        this.f2867d = (List) AbstractC1207s.k(list);
        this.f2869f = pendingIntent;
        this.f2868e = googleSignInAccount;
    }

    public String A() {
        return this.f2865b;
    }

    public List B() {
        return this.f2867d;
    }

    public PendingIntent C() {
        return this.f2869f;
    }

    public String D() {
        return this.f2864a;
    }

    public GoogleSignInAccount E() {
        return this.f2868e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0576a)) {
            return false;
        }
        C0576a c0576a = (C0576a) obj;
        return AbstractC1206q.b(this.f2864a, c0576a.f2864a) && AbstractC1206q.b(this.f2865b, c0576a.f2865b) && AbstractC1206q.b(this.f2866c, c0576a.f2866c) && AbstractC1206q.b(this.f2867d, c0576a.f2867d) && AbstractC1206q.b(this.f2869f, c0576a.f2869f) && AbstractC1206q.b(this.f2868e, c0576a.f2868e);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f2864a, this.f2865b, this.f2866c, this.f2867d, this.f2869f, this.f2868e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, D(), false);
        Q1.c.E(parcel, 2, A(), false);
        Q1.c.E(parcel, 3, this.f2866c, false);
        Q1.c.G(parcel, 4, B(), false);
        Q1.c.C(parcel, 5, E(), i7, false);
        Q1.c.C(parcel, 6, C(), i7, false);
        Q1.c.b(parcel, iA);
    }
}

package r1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.List;

/* JADX INFO: renamed from: r1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1744a extends A1.a {
    public static final Parcelable.Creator<C1744a> CREATOR = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f14483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GoogleSignInAccount f14484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PendingIntent f14485f;

    public C1744a(String str, String str2, String str3, List list, GoogleSignInAccount googleSignInAccount, PendingIntent pendingIntent) {
        this.f14480a = str;
        this.f14481b = str2;
        this.f14482c = str3;
        this.f14483d = (List) AbstractC0940s.k(list);
        this.f14485f = pendingIntent;
        this.f14484e = googleSignInAccount;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1744a)) {
            return false;
        }
        C1744a c1744a = (C1744a) obj;
        return AbstractC0939q.b(this.f14480a, c1744a.f14480a) && AbstractC0939q.b(this.f14481b, c1744a.f14481b) && AbstractC0939q.b(this.f14482c, c1744a.f14482c) && AbstractC0939q.b(this.f14483d, c1744a.f14483d) && AbstractC0939q.b(this.f14485f, c1744a.f14485f) && AbstractC0939q.b(this.f14484e, c1744a.f14484e);
    }

    public String getAccessToken() {
        return this.f14481b;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f14480a, this.f14481b, this.f14482c, this.f14483d, this.f14485f, this.f14484e);
    }

    public List i() {
        return this.f14483d;
    }

    public PendingIntent k() {
        return this.f14485f;
    }

    public String l() {
        return this.f14480a;
    }

    public GoogleSignInAccount m() {
        return this.f14484e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, l(), false);
        A1.c.E(parcel, 2, getAccessToken(), false);
        A1.c.E(parcel, 3, this.f14482c, false);
        A1.c.G(parcel, 4, i(), false);
        A1.c.C(parcel, 5, m(), i4, false);
        A1.c.C(parcel, 6, k(), i4, false);
        A1.c.b(parcel, iA);
    }
}

package r1;

import N1.C0483t;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class l extends A1.a {
    public static final Parcelable.Creator<l> CREATOR = new E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f14552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f14553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f14554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f14555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C0483t f14556i;

    public l(String str, String str2, String str3, String str4, Uri uri, String str5, String str6, String str7, C0483t c0483t) {
        this.f14548a = (String) AbstractC0940s.k(str);
        this.f14549b = str2;
        this.f14550c = str3;
        this.f14551d = str4;
        this.f14552e = uri;
        this.f14553f = str5;
        this.f14554g = str6;
        this.f14555h = str7;
        this.f14556i = c0483t;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return AbstractC0939q.b(this.f14548a, lVar.f14548a) && AbstractC0939q.b(this.f14549b, lVar.f14549b) && AbstractC0939q.b(this.f14550c, lVar.f14550c) && AbstractC0939q.b(this.f14551d, lVar.f14551d) && AbstractC0939q.b(this.f14552e, lVar.f14552e) && AbstractC0939q.b(this.f14553f, lVar.f14553f) && AbstractC0939q.b(this.f14554g, lVar.f14554g) && AbstractC0939q.b(this.f14555h, lVar.f14555h) && AbstractC0939q.b(this.f14556i, lVar.f14556i);
    }

    public String getDisplayName() {
        return this.f14549b;
    }

    public String getPhoneNumber() {
        return this.f14555h;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f14548a, this.f14549b, this.f14550c, this.f14551d, this.f14552e, this.f14553f, this.f14554g, this.f14555h, this.f14556i);
    }

    public String i() {
        return this.f14551d;
    }

    public String k() {
        return this.f14550c;
    }

    public String l() {
        return this.f14554g;
    }

    public String m() {
        return this.f14548a;
    }

    public String n() {
        return this.f14553f;
    }

    public Uri o() {
        return this.f14552e;
    }

    public C0483t p() {
        return this.f14556i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, m(), false);
        A1.c.E(parcel, 2, getDisplayName(), false);
        A1.c.E(parcel, 3, k(), false);
        A1.c.E(parcel, 4, i(), false);
        A1.c.C(parcel, 5, o(), i4, false);
        A1.c.E(parcel, 6, n(), false);
        A1.c.E(parcel, 7, l(), false);
        A1.c.E(parcel, 8, getPhoneNumber(), false);
        A1.c.C(parcel, 9, p(), i4, false);
        A1.c.b(parcel, iA);
    }
}

package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import b6.a;
import b6.d;
import b6.e;
import b6.k;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RegisterRequestParams extends RequestParams {
    public static final Parcelable.Creator<RegisterRequestParams> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f5845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f5846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f5847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f5848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f5849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f5850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set f5852h;

    public RegisterRequestParams(Integer num, Double d10, Uri uri, List list, List list2, a aVar, String str) {
        this.f5845a = num;
        this.f5846b = d10;
        this.f5847c = uri;
        s.b((list == null || list.isEmpty()) ? false : true, "empty list of register requests is provided");
        this.f5848d = list;
        this.f5849e = list2;
        this.f5850f = aVar;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            s.b((uri == null && dVar.R() == null) ? false : true, "register request has null appId and no request appId is provided");
            if (dVar.R() != null) {
                hashSet.add(Uri.parse(dVar.R()));
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            e eVar = (e) it2.next();
            s.b((uri == null && eVar.R() == null) ? false : true, "registered key has null appId and no request appId is provided");
            if (eVar.R() != null) {
                hashSet.add(Uri.parse(eVar.R()));
            }
        }
        this.f5852h = hashSet;
        s.b(str == null || str.length() <= 80, "Display Hint cannot be longer than 80 characters");
        this.f5851g = str;
    }

    public Uri R() {
        return this.f5847c;
    }

    public a S() {
        return this.f5850f;
    }

    public String T() {
        return this.f5851g;
    }

    public List U() {
        return this.f5848d;
    }

    public List V() {
        return this.f5849e;
    }

    public Integer W() {
        return this.f5845a;
    }

    public Double X() {
        return this.f5846b;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequestParams)) {
            return false;
        }
        RegisterRequestParams registerRequestParams = (RegisterRequestParams) obj;
        return q.b(this.f5845a, registerRequestParams.f5845a) && q.b(this.f5846b, registerRequestParams.f5846b) && q.b(this.f5847c, registerRequestParams.f5847c) && q.b(this.f5848d, registerRequestParams.f5848d) && (((list = this.f5849e) == null && registerRequestParams.f5849e == null) || (list != null && (list2 = registerRequestParams.f5849e) != null && list.containsAll(list2) && registerRequestParams.f5849e.containsAll(this.f5849e))) && q.b(this.f5850f, registerRequestParams.f5850f) && q.b(this.f5851g, registerRequestParams.f5851g);
    }

    public int hashCode() {
        return q.c(this.f5845a, this.f5847c, this.f5846b, this.f5848d, this.f5849e, this.f5850f, this.f5851g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = c.a(parcel);
        c.w(parcel, 2, W(), false);
        c.o(parcel, 3, X(), false);
        c.C(parcel, 4, R(), i10, false);
        c.I(parcel, 5, U(), false);
        c.I(parcel, 6, V(), false);
        c.C(parcel, 7, S(), i10, false);
        c.E(parcel, 8, T(), false);
        c.b(parcel, iA);
    }
}

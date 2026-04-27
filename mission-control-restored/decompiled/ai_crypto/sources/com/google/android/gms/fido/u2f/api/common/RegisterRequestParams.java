package com.google.android.gms.fido.u2f.api.common;

import Q1.c;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import e2.C1471a;
import e2.d;
import e2.e;
import e2.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RegisterRequestParams extends RequestParams {
    public static final Parcelable.Creator<RegisterRequestParams> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f11209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f11210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f11211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f11212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f11213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1471a f11214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f11215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set f11216h;

    public RegisterRequestParams(Integer num, Double d7, Uri uri, List list, List list2, C1471a c1471a, String str) {
        this.f11209a = num;
        this.f11210b = d7;
        this.f11211c = uri;
        AbstractC1207s.b((list == null || list.isEmpty()) ? false : true, "empty list of register requests is provided");
        this.f11212d = list;
        this.f11213e = list2;
        this.f11214f = c1471a;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            AbstractC1207s.b((uri == null && dVar.A() == null) ? false : true, "register request has null appId and no request appId is provided");
            if (dVar.A() != null) {
                hashSet.add(Uri.parse(dVar.A()));
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            e eVar = (e) it2.next();
            AbstractC1207s.b((uri == null && eVar.A() == null) ? false : true, "registered key has null appId and no request appId is provided");
            if (eVar.A() != null) {
                hashSet.add(Uri.parse(eVar.A()));
            }
        }
        this.f11216h = hashSet;
        AbstractC1207s.b(str == null || str.length() <= 80, "Display Hint cannot be longer than 80 characters");
        this.f11215g = str;
    }

    public Uri A() {
        return this.f11211c;
    }

    public C1471a B() {
        return this.f11214f;
    }

    public String C() {
        return this.f11215g;
    }

    public List D() {
        return this.f11212d;
    }

    public List E() {
        return this.f11213e;
    }

    public Integer F() {
        return this.f11209a;
    }

    public Double G() {
        return this.f11210b;
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
        return AbstractC1206q.b(this.f11209a, registerRequestParams.f11209a) && AbstractC1206q.b(this.f11210b, registerRequestParams.f11210b) && AbstractC1206q.b(this.f11211c, registerRequestParams.f11211c) && AbstractC1206q.b(this.f11212d, registerRequestParams.f11212d) && (((list = this.f11213e) == null && registerRequestParams.f11213e == null) || (list != null && (list2 = registerRequestParams.f11213e) != null && list.containsAll(list2) && registerRequestParams.f11213e.containsAll(this.f11213e))) && AbstractC1206q.b(this.f11214f, registerRequestParams.f11214f) && AbstractC1206q.b(this.f11215g, registerRequestParams.f11215g);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f11209a, this.f11211c, this.f11210b, this.f11212d, this.f11213e, this.f11214f, this.f11215g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.w(parcel, 2, F(), false);
        c.o(parcel, 3, G(), false);
        c.C(parcel, 4, A(), i7, false);
        c.I(parcel, 5, D(), false);
        c.I(parcel, 6, E(), false);
        c.C(parcel, 7, B(), i7, false);
        c.E(parcel, 8, C(), false);
        c.b(parcel, iA);
    }
}

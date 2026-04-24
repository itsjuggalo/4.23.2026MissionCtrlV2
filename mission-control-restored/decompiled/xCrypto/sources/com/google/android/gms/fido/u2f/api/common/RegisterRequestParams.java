package com.google.android.gms.fido.u2f.api.common;

import A1.c;
import O1.a;
import O1.d;
import O1.e;
import O1.k;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RegisterRequestParams extends RequestParams {
    public static final Parcelable.Creator<RegisterRequestParams> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f10026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f10027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f10028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f10030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f10031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f10032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set f10033h;

    public RegisterRequestParams(Integer num, Double d4, Uri uri, List list, List list2, a aVar, String str) {
        this.f10026a = num;
        this.f10027b = d4;
        this.f10028c = uri;
        AbstractC0940s.b((list == null || list.isEmpty()) ? false : true, "empty list of register requests is provided");
        this.f10029d = list;
        this.f10030e = list2;
        this.f10031f = aVar;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            AbstractC0940s.b((uri == null && dVar.i() == null) ? false : true, "register request has null appId and no request appId is provided");
            if (dVar.i() != null) {
                hashSet.add(Uri.parse(dVar.i()));
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            e eVar = (e) it2.next();
            AbstractC0940s.b((uri == null && eVar.i() == null) ? false : true, "registered key has null appId and no request appId is provided");
            if (eVar.i() != null) {
                hashSet.add(Uri.parse(eVar.i()));
            }
        }
        this.f10033h = hashSet;
        AbstractC0940s.b(str == null || str.length() <= 80, "Display Hint cannot be longer than 80 characters");
        this.f10032g = str;
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
        return AbstractC0939q.b(this.f10026a, registerRequestParams.f10026a) && AbstractC0939q.b(this.f10027b, registerRequestParams.f10027b) && AbstractC0939q.b(this.f10028c, registerRequestParams.f10028c) && AbstractC0939q.b(this.f10029d, registerRequestParams.f10029d) && (((list = this.f10030e) == null && registerRequestParams.f10030e == null) || (list != null && (list2 = registerRequestParams.f10030e) != null && list.containsAll(list2) && registerRequestParams.f10030e.containsAll(this.f10030e))) && AbstractC0939q.b(this.f10031f, registerRequestParams.f10031f) && AbstractC0939q.b(this.f10032g, registerRequestParams.f10032g);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f10026a, this.f10028c, this.f10027b, this.f10029d, this.f10030e, this.f10031f, this.f10032g);
    }

    public Uri i() {
        return this.f10028c;
    }

    public a k() {
        return this.f10031f;
    }

    public String l() {
        return this.f10032g;
    }

    public List m() {
        return this.f10029d;
    }

    public List n() {
        return this.f10030e;
    }

    public Integer o() {
        return this.f10026a;
    }

    public Double p() {
        return this.f10027b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.w(parcel, 2, o(), false);
        c.o(parcel, 3, p(), false);
        c.C(parcel, 4, i(), i4, false);
        c.I(parcel, 5, m(), false);
        c.I(parcel, 6, n(), false);
        c.C(parcel, 7, k(), i4, false);
        c.E(parcel, 8, l(), false);
        c.b(parcel, iA);
    }
}

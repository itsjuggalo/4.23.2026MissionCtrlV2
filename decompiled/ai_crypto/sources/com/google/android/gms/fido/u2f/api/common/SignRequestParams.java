package com.google.android.gms.fido.u2f.api.common;

import Q1.c;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import e2.C1471a;
import e2.e;
import e2.m;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SignRequestParams extends RequestParams {
    public static final Parcelable.Creator<SignRequestParams> CREATOR = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f11217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f11218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f11219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f11220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f11221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1471a f11222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f11223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set f11224h;

    public SignRequestParams(Integer num, Double d7, Uri uri, byte[] bArr, List list, C1471a c1471a, String str) {
        this.f11217a = num;
        this.f11218b = d7;
        this.f11219c = uri;
        this.f11220d = bArr;
        AbstractC1207s.b((list == null || list.isEmpty()) ? false : true, "registeredKeys must not be null or empty");
        this.f11221e = list;
        this.f11222f = c1471a;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            AbstractC1207s.b((eVar.A() == null && uri == null) ? false : true, "registered key has null appId and no request appId is provided");
            eVar.B();
            AbstractC1207s.b(true, "register request has null challenge and no default challenge isprovided");
            if (eVar.A() != null) {
                hashSet.add(Uri.parse(eVar.A()));
            }
        }
        this.f11224h = hashSet;
        AbstractC1207s.b(str == null || str.length() <= 80, "Display Hint cannot be longer than 80 characters");
        this.f11223g = str;
    }

    public Uri A() {
        return this.f11219c;
    }

    public C1471a B() {
        return this.f11222f;
    }

    public byte[] C() {
        return this.f11220d;
    }

    public String D() {
        return this.f11223g;
    }

    public List E() {
        return this.f11221e;
    }

    public Integer F() {
        return this.f11217a;
    }

    public Double G() {
        return this.f11218b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignRequestParams)) {
            return false;
        }
        SignRequestParams signRequestParams = (SignRequestParams) obj;
        return AbstractC1206q.b(this.f11217a, signRequestParams.f11217a) && AbstractC1206q.b(this.f11218b, signRequestParams.f11218b) && AbstractC1206q.b(this.f11219c, signRequestParams.f11219c) && Arrays.equals(this.f11220d, signRequestParams.f11220d) && this.f11221e.containsAll(signRequestParams.f11221e) && signRequestParams.f11221e.containsAll(this.f11221e) && AbstractC1206q.b(this.f11222f, signRequestParams.f11222f) && AbstractC1206q.b(this.f11223g, signRequestParams.f11223g);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f11217a, this.f11219c, this.f11218b, this.f11221e, this.f11222f, this.f11223g, Integer.valueOf(Arrays.hashCode(this.f11220d)));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.w(parcel, 2, F(), false);
        c.o(parcel, 3, G(), false);
        c.C(parcel, 4, A(), i7, false);
        c.k(parcel, 5, C(), false);
        c.I(parcel, 6, E(), false);
        c.C(parcel, 7, B(), i7, false);
        c.E(parcel, 8, D(), false);
        c.b(parcel, iA);
    }
}

package com.google.android.gms.fido.u2f.api.common;

import A1.c;
import O1.a;
import O1.e;
import O1.m;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
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
    public final Integer f10034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f10035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f10036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f10037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f10038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f10039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f10040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set f10041h;

    public SignRequestParams(Integer num, Double d4, Uri uri, byte[] bArr, List list, a aVar, String str) {
        this.f10034a = num;
        this.f10035b = d4;
        this.f10036c = uri;
        this.f10037d = bArr;
        AbstractC0940s.b((list == null || list.isEmpty()) ? false : true, "registeredKeys must not be null or empty");
        this.f10038e = list;
        this.f10039f = aVar;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            AbstractC0940s.b((eVar.i() == null && uri == null) ? false : true, "registered key has null appId and no request appId is provided");
            eVar.k();
            AbstractC0940s.b(true, "register request has null challenge and no default challenge isprovided");
            if (eVar.i() != null) {
                hashSet.add(Uri.parse(eVar.i()));
            }
        }
        this.f10041h = hashSet;
        AbstractC0940s.b(str == null || str.length() <= 80, "Display Hint cannot be longer than 80 characters");
        this.f10040g = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignRequestParams)) {
            return false;
        }
        SignRequestParams signRequestParams = (SignRequestParams) obj;
        return AbstractC0939q.b(this.f10034a, signRequestParams.f10034a) && AbstractC0939q.b(this.f10035b, signRequestParams.f10035b) && AbstractC0939q.b(this.f10036c, signRequestParams.f10036c) && Arrays.equals(this.f10037d, signRequestParams.f10037d) && this.f10038e.containsAll(signRequestParams.f10038e) && signRequestParams.f10038e.containsAll(this.f10038e) && AbstractC0939q.b(this.f10039f, signRequestParams.f10039f) && AbstractC0939q.b(this.f10040g, signRequestParams.f10040g);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f10034a, this.f10036c, this.f10035b, this.f10038e, this.f10039f, this.f10040g, Integer.valueOf(Arrays.hashCode(this.f10037d)));
    }

    public Uri i() {
        return this.f10036c;
    }

    public a k() {
        return this.f10039f;
    }

    public byte[] l() {
        return this.f10037d;
    }

    public String m() {
        return this.f10040g;
    }

    public List n() {
        return this.f10038e;
    }

    public Integer o() {
        return this.f10034a;
    }

    public Double p() {
        return this.f10035b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.w(parcel, 2, o(), false);
        c.o(parcel, 3, p(), false);
        c.C(parcel, 4, i(), i4, false);
        c.k(parcel, 5, l(), false);
        c.I(parcel, 6, n(), false);
        c.C(parcel, 7, k(), i4, false);
        c.E(parcel, 8, m(), false);
        c.b(parcel, iA);
    }
}

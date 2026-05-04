package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import b6.a;
import b6.e;
import b6.m;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SignRequestParams extends RequestParams {
    public static final Parcelable.Creator<SignRequestParams> CREATOR = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f5853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f5854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f5855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f5856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f5857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f5858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set f5860h;

    public SignRequestParams(Integer num, Double d10, Uri uri, byte[] bArr, List list, a aVar, String str) {
        this.f5853a = num;
        this.f5854b = d10;
        this.f5855c = uri;
        this.f5856d = bArr;
        this.f5857e = list;
        this.f5858f = aVar;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                s.b((eVar.R() == null && uri == null) ? false : true, "registered key has null appId and no request appId is provided");
                eVar.S();
                s.b(true, "register request has null challenge and no default challenge isprovided");
                if (eVar.R() != null) {
                    hashSet.add(Uri.parse(eVar.R()));
                }
            }
        }
        this.f5860h = hashSet;
        s.b(str == null || str.length() <= 80, "Display Hint cannot be longer than 80 characters");
        this.f5859g = str;
    }

    public Uri R() {
        return this.f5855c;
    }

    public a S() {
        return this.f5858f;
    }

    public byte[] T() {
        return this.f5856d;
    }

    public String U() {
        return this.f5859g;
    }

    public List V() {
        return this.f5857e;
    }

    public Integer W() {
        return this.f5853a;
    }

    public Double X() {
        return this.f5854b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignRequestParams)) {
            return false;
        }
        SignRequestParams signRequestParams = (SignRequestParams) obj;
        return q.b(this.f5853a, signRequestParams.f5853a) && q.b(this.f5854b, signRequestParams.f5854b) && q.b(this.f5855c, signRequestParams.f5855c) && Arrays.equals(this.f5856d, signRequestParams.f5856d) && this.f5857e.containsAll(signRequestParams.f5857e) && signRequestParams.f5857e.containsAll(this.f5857e) && q.b(this.f5858f, signRequestParams.f5858f) && q.b(this.f5859g, signRequestParams.f5859g);
    }

    public int hashCode() {
        return q.c(this.f5853a, this.f5855c, this.f5854b, this.f5857e, this.f5858f, this.f5859g, Integer.valueOf(Arrays.hashCode(this.f5856d)));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = c.a(parcel);
        c.w(parcel, 2, W(), false);
        c.o(parcel, 3, X(), false);
        c.C(parcel, 4, R(), i10, false);
        c.k(parcel, 5, T(), false);
        c.I(parcel, 6, V(), false);
        c.C(parcel, 7, S(), i10, false);
        c.E(parcel, 8, U(), false);
        c.b(parcel, iA);
    }
}

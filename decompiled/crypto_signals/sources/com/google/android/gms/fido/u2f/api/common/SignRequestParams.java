package com.google.android.gms.fido.u2f.api.common;

import J1.Y;
import K1.c;
import K1.h;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SignRequestParams extends RequestParams {
    public static final Parcelable.Creator<SignRequestParams> CREATOR = new Y(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f5307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f5308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f5309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f5310d;
    public final ArrayList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f5311f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f5312k;

    public SignRequestParams(Integer num, Double d4, Uri uri, byte[] bArr, ArrayList arrayList, c cVar, String str) {
        this.f5307a = num;
        this.f5308b = d4;
        this.f5309c = uri;
        this.f5310d = bArr;
        I.a("registeredKeys must not be null or empty", (arrayList == null || arrayList.isEmpty()) ? false : true);
        this.e = arrayList;
        this.f5311f = cVar;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            I.a("registered key has null appId and no request appId is provided", (hVar.f818b == null && uri == null) ? false : true);
            String str2 = hVar.f818b;
            if (str2 != null) {
                hashSet.add(Uri.parse(str2));
            }
        }
        I.a("Display Hint cannot be longer than 80 characters", str == null || str.length() <= 80);
        this.f5312k = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignRequestParams)) {
            return false;
        }
        SignRequestParams signRequestParams = (SignRequestParams) obj;
        if (!I.j(this.f5307a, signRequestParams.f5307a) || !I.j(this.f5308b, signRequestParams.f5308b) || !I.j(this.f5309c, signRequestParams.f5309c) || !Arrays.equals(this.f5310d, signRequestParams.f5310d)) {
            return false;
        }
        ArrayList arrayList = this.e;
        ArrayList arrayList2 = signRequestParams.e;
        return arrayList.containsAll(arrayList2) && arrayList2.containsAll(arrayList) && I.j(this.f5311f, signRequestParams.f5311f) && I.j(this.f5312k, signRequestParams.f5312k);
    }

    public final int hashCode() {
        Integer numValueOf = Integer.valueOf(Arrays.hashCode(this.f5310d));
        return Arrays.hashCode(new Object[]{this.f5307a, this.f5309c, this.f5308b, this.e, this.f5311f, this.f5312k, numValueOf});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.Q(parcel, 2, this.f5307a);
        u0.N(parcel, 3, this.f5308b);
        u0.S(parcel, 4, this.f5309c, i, false);
        u0.M(parcel, 5, this.f5310d, false);
        u0.W(parcel, 6, this.e, false);
        u0.S(parcel, 7, this.f5311f, i, false);
        u0.T(parcel, 8, this.f5312k, false);
        u0.a0(iX, parcel);
    }
}

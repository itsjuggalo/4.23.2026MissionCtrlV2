package com.google.android.gms.fido.u2f.api.common;

import J1.Y;
import K1.c;
import K1.g;
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
public class RegisterRequestParams extends RequestParams {
    public static final Parcelable.Creator<RegisterRequestParams> CREATOR = new Y(18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f5301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f5302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f5303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f5304d;
    public final ArrayList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f5305f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f5306k;

    public RegisterRequestParams(Integer num, Double d4, Uri uri, ArrayList arrayList, ArrayList arrayList2, c cVar, String str) {
        this.f5301a = num;
        this.f5302b = d4;
        this.f5303c = uri;
        I.a("empty list of register requests is provided", (arrayList == null || arrayList.isEmpty()) ? false : true);
        this.f5304d = arrayList;
        this.e = arrayList2;
        this.f5305f = cVar;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            I.a("register request has null appId and no request appId is provided", (uri == null && gVar.f816d == null) ? false : true);
            String str2 = gVar.f816d;
            if (str2 != null) {
                hashSet.add(Uri.parse(str2));
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            h hVar = (h) it2.next();
            I.a("registered key has null appId and no request appId is provided", (uri == null && hVar.f818b == null) ? false : true);
            String str3 = hVar.f818b;
            if (str3 != null) {
                hashSet.add(Uri.parse(str3));
            }
        }
        I.a("Display Hint cannot be longer than 80 characters", str == null || str.length() <= 80);
        this.f5306k = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequestParams)) {
            return false;
        }
        RegisterRequestParams registerRequestParams = (RegisterRequestParams) obj;
        if (!I.j(this.f5301a, registerRequestParams.f5301a) || !I.j(this.f5302b, registerRequestParams.f5302b) || !I.j(this.f5303c, registerRequestParams.f5303c) || !I.j(this.f5304d, registerRequestParams.f5304d)) {
            return false;
        }
        ArrayList arrayList = this.e;
        ArrayList arrayList2 = registerRequestParams.e;
        return ((arrayList == null && arrayList2 == null) || (arrayList != null && arrayList2 != null && arrayList.containsAll(arrayList2) && arrayList2.containsAll(arrayList))) && I.j(this.f5305f, registerRequestParams.f5305f) && I.j(this.f5306k, registerRequestParams.f5306k);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5301a, this.f5303c, this.f5302b, this.f5304d, this.e, this.f5305f, this.f5306k});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.Q(parcel, 2, this.f5301a);
        u0.N(parcel, 3, this.f5302b);
        u0.S(parcel, 4, this.f5303c, i, false);
        u0.W(parcel, 5, this.f5304d, false);
        u0.W(parcel, 6, this.e, false);
        u0.S(parcel, 7, this.f5305f, i, false);
        u0.T(parcel, 8, this.f5306k, false);
        u0.a0(iX, parcel);
    }
}

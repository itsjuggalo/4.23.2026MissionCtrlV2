package com.google.android.gms.auth.api.identity;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public class AuthorizationRequest extends AbstractC1255a implements ReflectedParcelable {
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new Q(27);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f5003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5006d;
    public final Account e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5007f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f5008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f5009l;

    public AuthorizationRequest(ArrayList arrayList, String str, boolean z6, boolean z7, Account account, String str2, String str3, boolean z8) {
        boolean z9 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            z9 = true;
        }
        I.a("requestedScopes cannot be null or empty", z9);
        this.f5003a = arrayList;
        this.f5004b = str;
        this.f5005c = z6;
        this.f5006d = z7;
        this.e = account;
        this.f5007f = str2;
        this.f5008k = str3;
        this.f5009l = z8;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AuthorizationRequest)) {
            return false;
        }
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) obj;
        ArrayList arrayList = this.f5003a;
        return arrayList.size() == authorizationRequest.f5003a.size() && arrayList.containsAll(authorizationRequest.f5003a) && this.f5005c == authorizationRequest.f5005c && this.f5009l == authorizationRequest.f5009l && this.f5006d == authorizationRequest.f5006d && I.j(this.f5004b, authorizationRequest.f5004b) && I.j(this.e, authorizationRequest.e) && I.j(this.f5007f, authorizationRequest.f5007f) && I.j(this.f5008k, authorizationRequest.f5008k);
    }

    public final int hashCode() {
        Boolean boolValueOf = Boolean.valueOf(this.f5005c);
        Boolean boolValueOf2 = Boolean.valueOf(this.f5009l);
        Boolean boolValueOf3 = Boolean.valueOf(this.f5006d);
        return Arrays.hashCode(new Object[]{this.f5003a, this.f5004b, boolValueOf, boolValueOf2, boolValueOf3, this.e, this.f5007f, this.f5008k});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.W(parcel, 1, this.f5003a, false);
        u0.T(parcel, 2, this.f5004b, false);
        u0.b0(parcel, 3, 4);
        parcel.writeInt(this.f5005c ? 1 : 0);
        u0.b0(parcel, 4, 4);
        parcel.writeInt(this.f5006d ? 1 : 0);
        u0.S(parcel, 5, this.e, i, false);
        u0.T(parcel, 6, this.f5007f, false);
        u0.T(parcel, 7, this.f5008k, false);
        u0.b0(parcel, 8, 4);
        parcel.writeInt(this.f5009l ? 1 : 0);
        u0.a0(iX, parcel);
    }
}

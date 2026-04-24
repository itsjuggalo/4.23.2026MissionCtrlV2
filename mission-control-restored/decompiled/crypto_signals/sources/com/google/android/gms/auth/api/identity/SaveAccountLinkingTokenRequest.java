package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import o1.r;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public class SaveAccountLinkingTokenRequest extends AbstractC1255a implements ReflectedParcelable {
    public static final Parcelable.Creator<SaveAccountLinkingTokenRequest> CREATOR = new r(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f5010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f5013d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5014f;

    public SaveAccountLinkingTokenRequest(PendingIntent pendingIntent, String str, String str2, ArrayList arrayList, String str3, int i) {
        this.f5010a = pendingIntent;
        this.f5011b = str;
        this.f5012c = str2;
        this.f5013d = arrayList;
        this.e = str3;
        this.f5014f = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SaveAccountLinkingTokenRequest)) {
            return false;
        }
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest) obj;
        ArrayList arrayList = this.f5013d;
        return arrayList.size() == saveAccountLinkingTokenRequest.f5013d.size() && arrayList.containsAll(saveAccountLinkingTokenRequest.f5013d) && I.j(this.f5010a, saveAccountLinkingTokenRequest.f5010a) && I.j(this.f5011b, saveAccountLinkingTokenRequest.f5011b) && I.j(this.f5012c, saveAccountLinkingTokenRequest.f5012c) && I.j(this.e, saveAccountLinkingTokenRequest.e) && this.f5014f == saveAccountLinkingTokenRequest.f5014f;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5010a, this.f5011b, this.f5012c, this.f5013d, this.e});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.S(parcel, 1, this.f5010a, i, false);
        u0.T(parcel, 2, this.f5011b, false);
        u0.T(parcel, 3, this.f5012c, false);
        u0.U(parcel, 4, this.f5013d);
        u0.T(parcel, 5, this.e, false);
        u0.b0(parcel, 6, 4);
        parcel.writeInt(this.f5014f);
        u0.a0(iX, parcel);
    }
}

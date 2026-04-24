package com.google.android.gms.auth;

import E1.p;
import Q1.a;
import Q1.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TokenData extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new p();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f10744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f10747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f10748g;

    public TokenData(int i7, String str, Long l7, boolean z7, boolean z8, List list, String str2) {
        this.f10742a = i7;
        this.f10743b = AbstractC1207s.e(str);
        this.f10744c = l7;
        this.f10745d = z7;
        this.f10746e = z8;
        this.f10747f = list;
        this.f10748g = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f10743b, tokenData.f10743b) && AbstractC1206q.b(this.f10744c, tokenData.f10744c) && this.f10745d == tokenData.f10745d && this.f10746e == tokenData.f10746e && AbstractC1206q.b(this.f10747f, tokenData.f10747f) && AbstractC1206q.b(this.f10748g, tokenData.f10748g);
    }

    public final int hashCode() {
        return AbstractC1206q.c(this.f10743b, this.f10744c, Boolean.valueOf(this.f10745d), Boolean.valueOf(this.f10746e), this.f10747f, this.f10748g);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.f10742a);
        c.E(parcel, 2, this.f10743b, false);
        c.z(parcel, 3, this.f10744c, false);
        c.g(parcel, 4, this.f10745d);
        c.g(parcel, 5, this.f10746e);
        c.G(parcel, 6, this.f10747f, false);
        c.E(parcel, 7, this.f10748g, false);
        c.b(parcel, iA);
    }

    public final String zza() {
        return this.f10743b;
    }
}

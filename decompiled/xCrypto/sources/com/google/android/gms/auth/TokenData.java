package com.google.android.gms.auth;

import A1.a;
import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.List;
import n1.C1630p;

/* JADX INFO: loaded from: classes.dex */
public class TokenData extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new C1630p();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f9559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f9562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9563g;

    public TokenData(int i4, String str, Long l4, boolean z4, boolean z5, List list, String str2) {
        this.f9557a = i4;
        this.f9558b = AbstractC0940s.e(str);
        this.f9559c = l4;
        this.f9560d = z4;
        this.f9561e = z5;
        this.f9562f = list;
        this.f9563g = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f9558b, tokenData.f9558b) && AbstractC0939q.b(this.f9559c, tokenData.f9559c) && this.f9560d == tokenData.f9560d && this.f9561e == tokenData.f9561e && AbstractC0939q.b(this.f9562f, tokenData.f9562f) && AbstractC0939q.b(this.f9563g, tokenData.f9563g);
    }

    public final int hashCode() {
        return AbstractC0939q.c(this.f9558b, this.f9559c, Boolean.valueOf(this.f9560d), Boolean.valueOf(this.f9561e), this.f9562f, this.f9563g);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.f9557a);
        c.E(parcel, 2, this.f9558b, false);
        c.z(parcel, 3, this.f9559c, false);
        c.g(parcel, 4, this.f9560d);
        c.g(parcel, 5, this.f9561e);
        c.G(parcel, 6, this.f9562f, false);
        c.E(parcel, 7, this.f9563g, false);
        c.b(parcel, iA);
    }

    public final String zza() {
        return this.f9558b;
    }
}

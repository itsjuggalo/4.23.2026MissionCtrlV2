package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends n5.a {
    public static final Parcelable.Creator<e> CREATOR;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f5477e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5481d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5482a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5483b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5484c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5485d = true;

        public e a() {
            return new e(this.f5482a, this.f5483b, this.f5484c, this.f5485d);
        }

        public a b(int i10) {
            this.f5482a = i10;
            return this;
        }

        public a c(int i10) {
            this.f5483b = i10;
            return this;
        }

        public a d(boolean z10) {
            this.f5485d = z10;
            return this;
        }

        public a e(int i10) {
            this.f5484c = i10;
            return this;
        }
    }

    static {
        a aVarR = R();
        aVarR.b(-1);
        aVarR.c(-1);
        aVarR.e(0);
        aVarR.d(true);
        f5477e = aVarR.a();
        CREATOR = new s();
    }

    public e(int i10, int i11, int i12, boolean z10) {
        this.f5478a = i10;
        this.f5479b = i11;
        this.f5480c = i12;
        this.f5481d = z10;
    }

    public static a R() {
        return new a();
    }

    public static final a S(Context context) {
        return R();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f5478a == eVar.f5478a && this.f5479b == eVar.f5479b && this.f5480c == eVar.f5480c && this.f5481d == eVar.f5481d;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.f5478a), Integer.valueOf(this.f5479b), Integer.valueOf(this.f5480c), Boolean.valueOf(this.f5481d));
    }

    public final String toString() {
        int i10 = this.f5478a;
        int length = String.valueOf(i10).length();
        int i11 = this.f5479b;
        int length2 = String.valueOf(i11).length();
        int i12 = this.f5480c;
        int length3 = String.valueOf(i12).length();
        boolean z10 = this.f5481d;
        StringBuilder sb2 = new StringBuilder(length + 55 + length2 + 19 + length3 + 13 + String.valueOf(z10).length() + 1);
        sb2.append("ComplianceOptions{callerProductId=");
        sb2.append(i10);
        sb2.append(", dataOwnerProductId=");
        sb2.append(i11);
        sb2.append(", processingReason=");
        sb2.append(i12);
        sb2.append(", isUserData=");
        sb2.append(z10);
        sb2.append("}");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f5478a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.t(parcel, 2, this.f5479b);
        n5.c.t(parcel, 3, this.f5480c);
        n5.c.g(parcel, 4, this.f5481d);
        n5.c.b(parcel, iA);
    }
}

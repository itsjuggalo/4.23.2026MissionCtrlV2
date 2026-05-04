package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends n5.a {
    public static final Parcelable.Creator<c> CREATOR = q.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f5469d = T().a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f5470e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f5471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5473c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f5474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f5475b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5476c;

        public c a() {
            c cVar = new c(this.f5474a, this.f5475b);
            cVar.U(this.f5476c);
            return cVar;
        }

        public a b(e eVar) {
            this.f5474a = eVar;
            return this;
        }

        public final /* synthetic */ a c(boolean z10) {
            this.f5476c = z10;
            return this;
        }
    }

    static {
        a aVarT = T();
        aVarT.c(true);
        f5470e = aVarT.a();
    }

    public c(e eVar, boolean z10) {
        this.f5471a = eVar;
        this.f5472b = z10;
    }

    public static final c R(e eVar) {
        a aVarT = T();
        aVarT.b(eVar);
        return aVarT.a();
    }

    public static final c S() {
        return f5469d;
    }

    public static a T() {
        return new a();
    }

    public final /* synthetic */ void U(boolean z10) {
        this.f5473c = z10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return com.google.android.gms.common.internal.q.b(this.f5471a, cVar.f5471a) && this.f5473c == cVar.f5473c && this.f5472b == cVar.f5472b;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f5471a, Boolean.valueOf(this.f5473c), Boolean.valueOf(this.f5472b));
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f5471a);
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 31);
        sb2.append("ApiMetadata(complianceOptions=");
        sb2.append(strValueOf);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        if (this.f5473c) {
            parcel.setDataPosition(parcel.dataPosition() - 4);
            parcel.setDataSize(parcel.dataSize() - 4);
            return;
        }
        parcel.writeInt(-204102970);
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 1, this.f5471a, i10, false);
        n5.c.g(parcel, 2, this.f5472b);
        n5.c.b(parcel, iA);
    }
}

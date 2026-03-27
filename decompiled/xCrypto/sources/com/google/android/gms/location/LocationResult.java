package com.google.android.gms.location;

import A1.a;
import A1.c;
import P1.F;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LocationResult extends a implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f10056b = Collections.EMPTY_LIST;
    public static final Parcelable.Creator<LocationResult> CREATOR = new F();

    public LocationResult(List list) {
        this.f10057a = list;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f10057a.size() != this.f10057a.size()) {
            return false;
        }
        Iterator it = locationResult.f10057a.iterator();
        Iterator it2 = this.f10057a.iterator();
        while (it.hasNext()) {
            if (((Location) it2.next()).getTime() != ((Location) it.next()).getTime()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator it = this.f10057a.iterator();
        int i4 = 17;
        while (it.hasNext()) {
            long time = ((Location) it.next()).getTime();
            i4 = (i4 * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i4;
    }

    public List i() {
        return this.f10057a;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f10057a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
        sb.append("LocationResult[locations: ");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.I(parcel, 1, i(), false);
        c.b(parcel, iA);
    }
}

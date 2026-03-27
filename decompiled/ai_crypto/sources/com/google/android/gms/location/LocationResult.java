package com.google.android.gms.location;

import Q1.a;
import Q1.c;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import f2.C1555F;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LocationResult extends a implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f11239b = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new C1555F();

    public LocationResult(List list) {
        this.f11240a = list;
    }

    public List A() {
        return this.f11240a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f11240a.size() != this.f11240a.size()) {
            return false;
        }
        Iterator it = locationResult.f11240a.iterator();
        Iterator it2 = this.f11240a.iterator();
        while (it.hasNext()) {
            if (((Location) it2.next()).getTime() != ((Location) it.next()).getTime()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator it = this.f11240a.iterator();
        int i7 = 17;
        while (it.hasNext()) {
            long time = ((Location) it.next()).getTime();
            i7 = (i7 * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i7;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f11240a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
        sb.append("LocationResult[locations: ");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.I(parcel, 1, A(), false);
        c.b(parcel, iA);
    }
}

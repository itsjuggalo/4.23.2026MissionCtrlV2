package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e6.f0;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n5.a;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class LocationResult extends a implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f5881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f5880b = Collections.EMPTY_LIST;
    public static final Parcelable.Creator<LocationResult> CREATOR = new f0();

    public LocationResult(List list) {
        this.f5881a = list;
    }

    public List R() {
        return this.f5881a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f5881a.size() != this.f5881a.size()) {
            return false;
        }
        Iterator it = locationResult.f5881a.iterator();
        Iterator it2 = this.f5881a.iterator();
        while (it.hasNext()) {
            if (((Location) it2.next()).getTime() != ((Location) it.next()).getTime()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator it = this.f5881a.iterator();
        int i10 = 17;
        while (it.hasNext()) {
            long time = ((Location) it.next()).getTime();
            i10 = (i10 * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i10;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f5881a);
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 27);
        sb2.append("LocationResult[locations: ");
        sb2.append(strValueOf);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = c.a(parcel);
        c.I(parcel, 1, R(), false);
        c.b(parcel, iA);
    }
}

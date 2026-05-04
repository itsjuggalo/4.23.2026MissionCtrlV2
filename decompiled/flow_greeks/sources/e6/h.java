package e6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h extends n5.a {
    public static final Parcelable.Creator<h> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8412d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f8413a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8414b = 5;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8415c = "";

        public a a(f fVar) {
            com.google.android.gms.common.internal.s.l(fVar, "geofence can't be null.");
            com.google.android.gms.common.internal.s.b(fVar instanceof zzbe, "Geofence must be created using Geofence.Builder.");
            this.f8413a.add((zzbe) fVar);
            return this;
        }

        public a b(List list) {
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar != null) {
                        a(fVar);
                    }
                }
            }
            return this;
        }

        public h c() {
            com.google.android.gms.common.internal.s.b(!this.f8413a.isEmpty(), "No geofence has been added to this request.");
            return new h(this.f8413a, this.f8414b, this.f8415c, null);
        }

        public a d(int i10) {
            this.f8414b = i10 & 7;
            return this;
        }
    }

    public h(List list, int i10, String str, String str2) {
        this.f8409a = list;
        this.f8410b = i10;
        this.f8411c = str;
        this.f8412d = str2;
    }

    public int R() {
        return this.f8410b;
    }

    public String toString() {
        return "GeofencingRequest[geofences=" + this.f8409a + ", initialTrigger=" + this.f8410b + ", tag=" + this.f8411c + ", attributionTag=" + this.f8412d + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.I(parcel, 1, this.f8409a, false);
        n5.c.t(parcel, 2, R());
        n5.c.E(parcel, 3, this.f8411c, false);
        n5.c.E(parcel, 4, this.f8412d, false);
        n5.c.b(parcel, iA);
    }
}

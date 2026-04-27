package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: P1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0497h extends A1.a {
    public static final Parcelable.Creator<C0497h> CREATOR = new C0507s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3422d;

    /* JADX INFO: renamed from: P1.h$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f3423a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3424b = 5;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3425c = "";

        public a a(InterfaceC0495f interfaceC0495f) {
            AbstractC0940s.l(interfaceC0495f, "geofence can't be null.");
            AbstractC0940s.b(interfaceC0495f instanceof zzbe, "Geofence must be created using Geofence.Builder.");
            this.f3423a.add((zzbe) interfaceC0495f);
            return this;
        }

        public a b(List list) {
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    InterfaceC0495f interfaceC0495f = (InterfaceC0495f) it.next();
                    if (interfaceC0495f != null) {
                        a(interfaceC0495f);
                    }
                }
            }
            return this;
        }

        public C0497h c() {
            AbstractC0940s.b(!this.f3423a.isEmpty(), "No geofence has been added to this request.");
            return new C0497h(this.f3423a, this.f3424b, this.f3425c, null);
        }

        public a d(int i4) {
            this.f3424b = i4 & 7;
            return this;
        }
    }

    public C0497h(List list, int i4, String str, String str2) {
        this.f3419a = list;
        this.f3420b = i4;
        this.f3421c = str;
        this.f3422d = str2;
    }

    public int i() {
        return this.f3420b;
    }

    public String toString() {
        return "GeofencingRequest[geofences=" + this.f3419a + ", initialTrigger=" + this.f3420b + ", tag=" + this.f3421c + ", attributionTag=" + this.f3422d + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.I(parcel, 1, this.f3419a, false);
        A1.c.t(parcel, 2, i());
        A1.c.E(parcel, 3, this.f3421c, false);
        A1.c.E(parcel, 4, this.f3422d, false);
        A1.c.b(parcel, iA);
    }
}

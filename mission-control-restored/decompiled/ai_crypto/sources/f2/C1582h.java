package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: f2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1582h extends Q1.a {
    public static final Parcelable.Creator<C1582h> CREATOR = new C1593s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14087d;

    /* JADX INFO: renamed from: f2.h$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f14088a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14089b = 5;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f14090c = "";

        public a a(InterfaceC1580f interfaceC1580f) {
            AbstractC1207s.l(interfaceC1580f, "geofence can't be null.");
            AbstractC1207s.b(interfaceC1580f instanceof zzbe, "Geofence must be created using Geofence.Builder.");
            this.f14088a.add((zzbe) interfaceC1580f);
            return this;
        }

        public a b(List list) {
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    InterfaceC1580f interfaceC1580f = (InterfaceC1580f) it.next();
                    if (interfaceC1580f != null) {
                        a(interfaceC1580f);
                    }
                }
            }
            return this;
        }

        public C1582h c() {
            AbstractC1207s.b(!this.f14088a.isEmpty(), "No geofence has been added to this request.");
            return new C1582h(this.f14088a, this.f14089b, this.f14090c, null);
        }

        public a d(int i7) {
            this.f14089b = i7 & 7;
            return this;
        }
    }

    public C1582h(List list, int i7, String str, String str2) {
        this.f14084a = list;
        this.f14085b = i7;
        this.f14086c = str;
        this.f14087d = str2;
    }

    public int A() {
        return this.f14085b;
    }

    public String toString() {
        return "GeofencingRequest[geofences=" + this.f14084a + ", initialTrigger=" + this.f14085b + ", tag=" + this.f14086c + ", attributionTag=" + this.f14087d + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.I(parcel, 1, this.f14084a, false);
        Q1.c.t(parcel, 2, A());
        Q1.c.E(parcel, 3, this.f14086c, false);
        Q1.c.E(parcel, 4, this.f14087d, false);
        Q1.c.b(parcel, iA);
    }
}

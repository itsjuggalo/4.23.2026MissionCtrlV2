package h5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends n5.a {
    public static final Parcelable.Creator<d> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11011b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f11012a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11013b = false;

        public d a() {
            return new d(this.f11012a, this.f11013b);
        }

        public a b(boolean z10) {
            this.f11013b = z10;
            return this;
        }
    }

    public d(List list, boolean z10) {
        if (z10) {
            boolean z11 = true;
            if (list != null && !list.isEmpty()) {
                z11 = false;
            }
            s.o(z11, "retrieveAll was set to true but other constraint(s) was also provided: keys");
        }
        this.f11011b = z10;
        this.f11010a = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                s.f(str, "Element in keys cannot be null or empty");
                this.f11010a.add(str);
            }
        }
    }

    public List R() {
        return Collections.unmodifiableList(this.f11010a);
    }

    public boolean S() {
        return this.f11011b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.G(parcel, 1, R(), false);
        n5.c.g(parcel, 2, S());
        n5.c.b(parcel, iA);
    }
}

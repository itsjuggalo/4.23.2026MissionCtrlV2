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
public class c extends n5.a {
    public static final Parcelable.Creator<c> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11007b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f11008a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11009b = false;

        public c a() {
            return new c(this.f11008a, this.f11009b);
        }

        public a b(List list) {
            s.l(list, "Keys cannot be set to null");
            this.f11008a = list;
            return this;
        }
    }

    public c(List list, boolean z10) {
        if (z10) {
            boolean z11 = true;
            if (list != null && !list.isEmpty()) {
                z11 = false;
            }
            s.o(z11, "deleteAll was set to true but other constraint(s) was also provided: keys");
        }
        this.f11007b = z10;
        this.f11006a = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                s.f(str, "Element in keys cannot be null or empty");
                this.f11006a.add(str);
            }
        }
    }

    public boolean R() {
        return this.f11007b;
    }

    public List S() {
        return Collections.unmodifiableList(this.f11006a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.G(parcel, 1, S(), false);
        n5.c.g(parcel, 2, R());
        n5.c.b(parcel, iA);
    }
}

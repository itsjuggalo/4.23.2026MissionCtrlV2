package w1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: w1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1903d extends A1.a {
    public static final Parcelable.Creator<C1903d> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f15556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15557b;

    /* JADX INFO: renamed from: w1.d$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f15558a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15559b = false;

        public C1903d a() {
            return new C1903d(this.f15558a, this.f15559b);
        }

        public a b(boolean z4) {
            this.f15559b = z4;
            return this;
        }
    }

    public C1903d(List list, boolean z4) {
        if (z4) {
            boolean z5 = true;
            if (list != null && !list.isEmpty()) {
                z5 = false;
            }
            AbstractC0940s.o(z5, "retrieveAll was set to true but other constraint(s) was also provided: keys");
        }
        this.f15557b = z4;
        this.f15556a = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                AbstractC0940s.f(str, "Element in keys cannot be null or empty");
                this.f15556a.add(str);
            }
        }
    }

    public List i() {
        return Collections.unmodifiableList(this.f15556a);
    }

    public boolean k() {
        return this.f15557b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.G(parcel, 1, i(), false);
        A1.c.g(parcel, 2, k());
        A1.c.b(parcel, iA);
    }
}

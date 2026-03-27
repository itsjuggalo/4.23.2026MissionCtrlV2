package w1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: w1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1902c extends A1.a {
    public static final Parcelable.Creator<C1902c> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f15552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15553b;

    /* JADX INFO: renamed from: w1.c$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f15554a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15555b = false;

        public C1902c a() {
            return new C1902c(this.f15554a, this.f15555b);
        }

        public a b(List list) {
            AbstractC0940s.l(list, "Keys cannot be set to null");
            this.f15554a = list;
            return this;
        }
    }

    public C1902c(List list, boolean z4) {
        if (z4) {
            boolean z5 = true;
            if (list != null && !list.isEmpty()) {
                z5 = false;
            }
            AbstractC0940s.o(z5, "deleteAll was set to true but other constraint(s) was also provided: keys");
        }
        this.f15553b = z4;
        this.f15552a = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                AbstractC0940s.f(str, "Element in keys cannot be null or empty");
                this.f15552a.add(str);
            }
        }
    }

    public boolean i() {
        return this.f15553b;
    }

    public List k() {
        return Collections.unmodifiableList(this.f15552a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.G(parcel, 1, k(), false);
        A1.c.g(parcel, 2, i());
        A1.c.b(parcel, iA);
    }
}

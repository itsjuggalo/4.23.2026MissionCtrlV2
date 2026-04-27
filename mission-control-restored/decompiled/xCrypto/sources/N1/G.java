package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class G extends A1.a {
    public static final Parcelable.Creator<G> CREATOR = new j0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2746a;

    public G(List list) {
        this.f2746a = list;
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof G)) {
            return false;
        }
        G g4 = (G) obj;
        List list2 = this.f2746a;
        if (list2 == null && g4.f2746a == null) {
            return true;
        }
        return list2 != null && (list = g4.f2746a) != null && list2.containsAll(list) && g4.f2746a.containsAll(this.f2746a);
    }

    public int hashCode() {
        return AbstractC0939q.c(new HashSet(this.f2746a));
    }

    public List i() {
        return this.f2746a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.I(parcel, 1, i(), false);
        A1.c.b(parcel, iA);
    }
}

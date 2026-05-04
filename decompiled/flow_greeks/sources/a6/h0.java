package a6;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h0 extends n5.a {
    public static final Parcelable.Creator<h0> CREATOR = new n1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f177a;

    public h0(List list) {
        this.f177a = list;
    }

    public List R() {
        return this.f177a;
    }

    public final JSONArray S() {
        try {
            JSONArray jSONArray = new JSONArray();
            if (this.f177a != null) {
                for (int i10 = 0; i10 < this.f177a.size(); i10++) {
                    i0 i0Var = (i0) this.f177a.get(i10);
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put((int) i0Var.S());
                    jSONArray2.put((int) i0Var.R());
                    jSONArray2.put((int) i0Var.S());
                    jSONArray.put(i10, jSONArray2);
                }
            }
            return jSONArray;
        } catch (JSONException e10) {
            throw new RuntimeException("Error encoding UvmEntries to JSON object", e10);
        }
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        List list2 = this.f177a;
        if (list2 == null && h0Var.f177a == null) {
            return true;
        }
        return list2 != null && (list = h0Var.f177a) != null && list2.containsAll(list) && h0Var.f177a.containsAll(this.f177a);
    }

    public int hashCode() {
        List list = this.f177a;
        return com.google.android.gms.common.internal.q.c(list == null ? null : new HashSet(list));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.I(parcel, 1, R(), false);
        n5.c.b(parcel, iA);
    }
}

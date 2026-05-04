package r5;

import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends a implements n5.d {
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        a aVar = (a) obj;
        for (a.C0336a c0336a : getFieldMappings().values()) {
            if (isFieldSet(c0336a)) {
                if (!aVar.isFieldSet(c0336a) || !q.b(getFieldValue(c0336a), aVar.getFieldValue(c0336a))) {
                    return false;
                }
            } else if (aVar.isFieldSet(c0336a)) {
                return false;
            }
        }
        return true;
    }

    @Override // r5.a
    public Object getValueObject(String str) {
        return null;
    }

    public int hashCode() {
        int iHashCode = 0;
        for (a.C0336a c0336a : getFieldMappings().values()) {
            if (isFieldSet(c0336a)) {
                iHashCode = (iHashCode * 31) + s.k(getFieldValue(c0336a)).hashCode();
            }
        }
        return iHashCode;
    }

    @Override // r5.a
    public boolean isPrimitiveFieldSet(String str) {
        return false;
    }
}

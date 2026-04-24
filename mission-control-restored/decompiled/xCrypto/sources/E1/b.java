package E1;

import E1.a;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends a implements A1.d {
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
        for (a.C0016a c0016a : getFieldMappings().values()) {
            if (isFieldSet(c0016a)) {
                if (!aVar.isFieldSet(c0016a) || !AbstractC0939q.b(getFieldValue(c0016a), aVar.getFieldValue(c0016a))) {
                    return false;
                }
            } else if (aVar.isFieldSet(c0016a)) {
                return false;
            }
        }
        return true;
    }

    @Override // E1.a
    public Object getValueObject(String str) {
        return null;
    }

    public int hashCode() {
        int iHashCode = 0;
        for (a.C0016a c0016a : getFieldMappings().values()) {
            if (isFieldSet(c0016a)) {
                iHashCode = (iHashCode * 31) + AbstractC0940s.k(getFieldValue(c0016a)).hashCode();
            }
        }
        return iHashCode;
    }

    @Override // E1.a
    public boolean isPrimitiveFieldSet(String str) {
        return false;
    }
}

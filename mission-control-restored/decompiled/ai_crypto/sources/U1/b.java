package U1;

import U1.a;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends a implements Q1.d {
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
        for (a.C0083a c0083a : getFieldMappings().values()) {
            if (isFieldSet(c0083a)) {
                if (!aVar.isFieldSet(c0083a) || !AbstractC1206q.b(getFieldValue(c0083a), aVar.getFieldValue(c0083a))) {
                    return false;
                }
            } else if (aVar.isFieldSet(c0083a)) {
                return false;
            }
        }
        return true;
    }

    @Override // U1.a
    public Object getValueObject(String str) {
        return null;
    }

    public int hashCode() {
        int iHashCode = 0;
        for (a.C0083a c0083a : getFieldMappings().values()) {
            if (isFieldSet(c0083a)) {
                iHashCode = (iHashCode * 31) + AbstractC1207s.k(getFieldValue(c0083a)).hashCode();
            }
        }
        return iHashCode;
    }

    @Override // U1.a
    public boolean isPrimitiveFieldSet(String str) {
        return false;
    }
}

package z1;

import com.google.android.gms.common.internal.I;
import v1.InterfaceC1257c;

/* JADX INFO: renamed from: z1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1458c extends AbstractC1457b implements InterfaceC1257c {
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
        AbstractC1457b abstractC1457b = (AbstractC1457b) obj;
        for (C1456a c1456a : getFieldMappings().values()) {
            if (isFieldSet(c1456a)) {
                if (!abstractC1457b.isFieldSet(c1456a) || !I.j(getFieldValue(c1456a), abstractC1457b.getFieldValue(c1456a))) {
                    return false;
                }
            } else if (abstractC1457b.isFieldSet(c1456a)) {
                return false;
            }
        }
        return true;
    }

    @Override // z1.AbstractC1457b
    public Object getValueObject(String str) {
        return null;
    }

    public int hashCode() {
        int iHashCode = 0;
        for (C1456a c1456a : getFieldMappings().values()) {
            if (isFieldSet(c1456a)) {
                Object fieldValue = getFieldValue(c1456a);
                I.g(fieldValue);
                iHashCode = (iHashCode * 31) + fieldValue.hashCode();
            }
        }
        return iHashCode;
    }

    @Override // z1.AbstractC1457b
    public boolean isPrimitiveFieldSet(String str) {
        return false;
    }
}

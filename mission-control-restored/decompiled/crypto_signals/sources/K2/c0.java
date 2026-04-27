package K2;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends r {
    @Override // K2.r
    public final HashMap a(EnumC0066q enumC0066q) {
        s3.D.k(enumC0066q, "Provided serverTimestampBehavior value must not be null.");
        HashMap mapA = super.a(enumC0066q);
        D1.b.w("Data in a QueryDocumentSnapshot should be non-null", mapA != null, new Object[0]);
        return mapA;
    }

    @Override // K2.r
    public final Map b() {
        HashMap mapA = a(EnumC0066q.f965d);
        D1.b.w("Data in a QueryDocumentSnapshot should be non-null", mapA != null, new Object[0]);
        return mapA;
    }
}

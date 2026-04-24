package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0949u;
import java.util.List;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0954z implements InterfaceC0953y {
    public static AbstractC0949u.b d(Object obj, long j7) {
        return (AbstractC0949u.b) i0.z(obj, j7);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0953y
    public void a(Object obj, Object obj2, long j7) {
        AbstractC0949u.b bVarD = d(obj, j7);
        AbstractC0949u.b bVarD2 = d(obj2, j7);
        int size = bVarD.size();
        int size2 = bVarD2.size();
        if (size > 0 && size2 > 0) {
            if (!bVarD.f()) {
                bVarD = bVarD.e(size2 + size);
            }
            bVarD.addAll(bVarD2);
        }
        if (size > 0) {
            bVarD2 = bVarD;
        }
        i0.O(obj, j7, bVarD2);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0953y
    public void b(Object obj, long j7) {
        d(obj, j7).d();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0953y
    public List c(Object obj, long j7) {
        AbstractC0949u.b bVarD = d(obj, j7);
        if (bVarD.f()) {
            return bVarD;
        }
        int size = bVarD.size();
        AbstractC0949u.b bVarE = bVarD.e(size == 0 ? 10 : size * 2);
        i0.O(obj, j7, bVarE);
        return bVarE;
    }
}

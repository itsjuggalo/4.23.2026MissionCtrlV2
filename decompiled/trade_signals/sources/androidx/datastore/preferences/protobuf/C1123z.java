package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC1118u;
import java.util.List;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1123z implements InterfaceC1122y {
    public static AbstractC1118u.b d(Object obj, long j8) {
        return (AbstractC1118u.b) i0.z(obj, j8);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC1122y
    public void a(Object obj, Object obj2, long j8) {
        AbstractC1118u.b bVarD = d(obj, j8);
        AbstractC1118u.b bVarD2 = d(obj2, j8);
        int size = bVarD.size();
        int size2 = bVarD2.size();
        if (size > 0 && size2 > 0) {
            if (!bVarD.m()) {
                bVarD = bVarD.i(size2 + size);
            }
            bVarD.addAll(bVarD2);
        }
        if (size > 0) {
            bVarD2 = bVarD;
        }
        i0.O(obj, j8, bVarD2);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC1122y
    public void b(Object obj, long j8) {
        d(obj, j8).g();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC1122y
    public List c(Object obj, long j8) {
        AbstractC1118u.b bVarD = d(obj, j8);
        if (bVarD.m()) {
            return bVarD;
        }
        int size = bVarD.size();
        AbstractC1118u.b bVarI = bVarD.i(size == 0 ? 10 : size * 2);
        i0.O(obj, j8, bVarI);
        return bVarI;
    }
}

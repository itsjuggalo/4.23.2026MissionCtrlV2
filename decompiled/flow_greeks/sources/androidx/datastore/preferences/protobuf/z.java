package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements y {
    public static u.b d(Object obj, long j10) {
        return (u.b) h1.z(obj, j10);
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public void a(Object obj, Object obj2, long j10) {
        u.b bVarD = d(obj, j10);
        u.b bVarD2 = d(obj2, j10);
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
        h1.O(obj, j10, bVarD2);
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public void b(Object obj, long j10) {
        d(obj, j10).h();
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public List c(Object obj, long j10) {
        u.b bVarD = d(obj, j10);
        if (bVarD.m()) {
            return bVarD;
        }
        int size = bVarD.size();
        u.b bVarI = bVarD.i(size == 0 ? 10 : size * 2);
        h1.O(obj, j10, bVarI);
        return bVarI;
    }
}

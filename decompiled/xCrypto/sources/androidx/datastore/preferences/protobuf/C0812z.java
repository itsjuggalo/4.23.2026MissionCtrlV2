package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0807u;
import java.util.List;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0812z implements InterfaceC0811y {
    public static AbstractC0807u.b d(Object obj, long j4) {
        return (AbstractC0807u.b) i0.z(obj, j4);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0811y
    public void a(Object obj, Object obj2, long j4) {
        AbstractC0807u.b bVarD = d(obj, j4);
        AbstractC0807u.b bVarD2 = d(obj2, j4);
        int size = bVarD.size();
        int size2 = bVarD2.size();
        if (size > 0 && size2 > 0) {
            if (!bVarD.e()) {
                bVarD = bVarD.a(size2 + size);
            }
            bVarD.addAll(bVarD2);
        }
        if (size > 0) {
            bVarD2 = bVarD;
        }
        i0.O(obj, j4, bVarD2);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0811y
    public void b(Object obj, long j4) {
        d(obj, j4).d();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0811y
    public List c(Object obj, long j4) {
        AbstractC0807u.b bVarD = d(obj, j4);
        if (bVarD.e()) {
            return bVarD;
        }
        int size = bVarD.size();
        AbstractC0807u.b bVarA = bVarD.a(size == 0 ? 10 : size * 2);
        i0.O(obj, j4, bVarA);
        return bVarA;
    }
}

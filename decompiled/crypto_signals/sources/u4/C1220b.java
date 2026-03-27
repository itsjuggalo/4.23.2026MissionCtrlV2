package u4;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: renamed from: u4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1220b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1220b f10380b = new C1220b(new IdentityHashMap());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f10381a;

    public C1220b(IdentityHashMap identityHashMap) {
        this.f10381a = identityHashMap;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1220b.class != obj.getClass()) {
            return false;
        }
        IdentityHashMap identityHashMap = this.f10381a;
        int size = identityHashMap.size();
        IdentityHashMap identityHashMap2 = ((C1220b) obj).f10381a;
        if (size != identityHashMap2.size()) {
            return false;
        }
        for (Map.Entry entry : identityHashMap.entrySet()) {
            if (!identityHashMap2.containsKey(entry.getKey()) || !android.support.v4.media.session.a.k(entry.getValue(), identityHashMap2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = 0;
        for (Map.Entry entry : this.f10381a.entrySet()) {
            iHashCode += Arrays.hashCode(new Object[]{entry.getKey(), entry.getValue()});
        }
        return iHashCode;
    }

    public final String toString() {
        return this.f10381a.toString();
    }
}

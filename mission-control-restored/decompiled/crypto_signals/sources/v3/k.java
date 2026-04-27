package v3;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class k extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f10626b;

    public /* synthetic */ k(m mVar, int i) {
        this.f10625a = i;
        this.f10626b = mVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f10625a) {
            case 0:
                this.f10626b.clear();
                break;
            default:
                this.f10626b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        l lVarA;
        switch (this.f10625a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                m mVar = this.f10626b;
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                l lVar = null;
                if (key != null) {
                    try {
                        lVarA = mVar.a(key, false);
                    } catch (ClassCastException unused) {
                        lVarA = null;
                    }
                    break;
                } else {
                    lVarA = null;
                }
                if (lVarA != null && Objects.equals(lVarA.f10633l, entry.getValue())) {
                    lVar = lVarA;
                }
                return lVar != null;
            default:
                return this.f10626b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f10625a) {
            case 0:
                return new j(this.f10626b, 0);
            default:
                return new j(this.f10626b, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        l lVarA;
        switch (this.f10625a) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    m mVar = this.f10626b;
                    Object key = entry.getKey();
                    l lVar = null;
                    if (key != null) {
                        try {
                            lVarA = mVar.a(key, false);
                        } catch (ClassCastException unused) {
                            lVarA = null;
                        }
                    } else {
                        lVarA = null;
                    }
                    if (lVarA != null && Objects.equals(lVarA.f10633l, entry.getValue())) {
                        lVar = lVarA;
                    }
                    if (lVar != null) {
                        mVar.d(lVar, true);
                        break;
                    }
                    break;
                }
                break;
            default:
                m mVar2 = this.f10626b;
                l lVarA2 = null;
                if (obj != null) {
                    try {
                        lVarA2 = mVar2.a(obj, false);
                        break;
                    } catch (ClassCastException unused2) {
                    }
                }
                if (lVarA2 != null) {
                    mVar2.d(lVarA2, true);
                }
                if (lVarA2 != null) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f10625a) {
        }
        return this.f10626b.f10639d;
    }
}

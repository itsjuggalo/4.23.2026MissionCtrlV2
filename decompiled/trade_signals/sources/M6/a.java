package M6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ArrayList implements l {
    public a(int i8) {
        super(i8);
    }

    public /* bridge */ int C(m mVar) {
        return super.lastIndexOf(mVar);
    }

    public /* bridge */ boolean F(m mVar) {
        return super.remove(mVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof m) {
            return d((m) obj);
        }
        return false;
    }

    public /* bridge */ boolean d(m mVar) {
        return super.contains(mVar);
    }

    public /* bridge */ int e() {
        return super.size();
    }

    public /* bridge */ int h(m mVar) {
        return super.indexOf(mVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof m) {
            return h((m) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof m) {
            return C((m) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof m) {
            return F((m) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return e();
    }
}

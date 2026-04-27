package F5;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: renamed from: F5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0546d extends AbstractList implements List, R5.a {
    public abstract int a();

    public abstract Object c(int i7);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i7) {
        return c(i7);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}

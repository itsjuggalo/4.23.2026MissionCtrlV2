package X2;

import j3.InterfaceC1564a;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: renamed from: X2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0758e extends AbstractList implements List, InterfaceC1564a {
    public abstract int f();

    public abstract Object i(int i4);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i4) {
        return i(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return f();
    }
}

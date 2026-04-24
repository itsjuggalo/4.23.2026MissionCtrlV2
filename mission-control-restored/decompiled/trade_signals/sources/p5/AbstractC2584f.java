package p5;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: renamed from: p5.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2584f extends AbstractList implements List, C5.a {
    public abstract int a();

    public abstract Object d(int i8);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i8) {
        return d(i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}

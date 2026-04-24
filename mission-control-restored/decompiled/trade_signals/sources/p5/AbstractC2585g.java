package p5;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: renamed from: p5.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2585g extends AbstractSet implements Set, C5.c {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return a();
    }
}

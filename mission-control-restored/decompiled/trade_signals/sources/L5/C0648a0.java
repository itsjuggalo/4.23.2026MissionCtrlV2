package L5;

import java.util.Comparator;

/* JADX INFO: renamed from: L5.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0648a0 implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B5.o f5140a;

    public C0648a0(B5.o oVar) {
        this.f5140a = oVar;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return AbstractC0654d0.E(this.f5140a, obj, obj2);
    }
}

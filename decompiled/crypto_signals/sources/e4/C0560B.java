package e4;

import java.util.ArrayList;

/* JADX INFO: renamed from: e4.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0560B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0561C f6207b;

    public static C0560B a(ArrayList arrayList) {
        C0560B c0560b = new C0560B();
        int i = S.i.d(7)[((Integer) arrayList.get(0)).intValue()];
        if (i == 0) {
            throw new IllegalStateException("Nonnull field \"operation\" is null.");
        }
        c0560b.f6206a = i;
        C0561C c0561c = (C0561C) arrayList.get(1);
        if (c0561c == null) {
            throw new IllegalStateException("Nonnull field \"data\" is null.");
        }
        c0560b.f6207b = c0561c;
        return c0560b;
    }
}

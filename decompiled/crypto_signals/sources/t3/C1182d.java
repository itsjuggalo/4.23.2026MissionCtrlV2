package t3;

import w3.AbstractC1280B;

/* JADX INFO: renamed from: t3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1182d extends AbstractC1280B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f10237a = null;

    @Override // t3.s
    public final Object b(B3.a aVar) {
        s sVar = this.f10237a;
        if (sVar != null) {
            return sVar.b(aVar);
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) {
        s sVar = this.f10237a;
        if (sVar == null) {
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
        sVar.c(bVar, obj);
    }

    @Override // w3.AbstractC1280B
    public final s d() {
        s sVar = this.f10237a;
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }
}

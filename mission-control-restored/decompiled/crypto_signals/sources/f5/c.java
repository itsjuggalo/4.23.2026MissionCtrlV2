package f5;

import a5.A;

/* JADX INFO: loaded from: classes.dex */
public final class c implements A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I4.i f6503a;

    public c(I4.i iVar) {
        this.f6503a = iVar;
    }

    @Override // a5.A
    public final I4.i b() {
        return this.f6503a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f6503a + ')';
    }
}

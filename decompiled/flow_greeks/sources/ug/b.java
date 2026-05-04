package ug;

import java.util.concurrent.Executor;
import ng.k0;
import ng.p1;
import sg.e0;
import sg.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends p1 implements Executor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f23016d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k0 f23017e = k0.d0(k.f23034c, g0.e("kotlinx.coroutines.io.parallelism", vd.l.b(64, e0.a()), 0, 0, 12, null), null, 2, null);

    @Override // ng.k0
    public void Z(gd.i iVar, Runnable runnable) {
        f23017e.Z(iVar, runnable);
    }

    @Override // ng.k0
    public k0 c0(int i10, String str) {
        return k.f23034c.c0(i10, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Z(gd.j.f10531a, runnable);
    }

    @Override // ng.k0
    public String toString() {
        return "Dispatchers.IO";
    }

    @Override // ng.p1
    public Executor e0() {
        return this;
    }
}

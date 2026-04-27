package a5;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: a5.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0301h extends AbstractC0290a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Thread f4125d;
    public final V e;

    public C0301h(I4.i iVar, Thread thread, V v2) {
        super(iVar, true);
        this.f4125d = thread;
        this.e = v2;
    }

    @Override // a5.p0
    public final void f(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f4125d;
        if (kotlin.jvm.internal.j.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}

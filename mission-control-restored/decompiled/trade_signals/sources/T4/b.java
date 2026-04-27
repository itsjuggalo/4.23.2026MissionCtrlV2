package T4;

import j5.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static RuntimeException a(Throwable th) {
        throw g.d(th);
    }

    public static void b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}

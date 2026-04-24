package D0;

import B0.i;
import G4.l;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import m0.ExecutorC0856c;

/* JADX INFO: loaded from: classes.dex */
public final class d implements C0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f263b = new ReentrantLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f264c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f265d = new LinkedHashMap();

    public d(WindowLayoutComponent windowLayoutComponent) {
        this.f262a = windowLayoutComponent;
    }

    @Override // C0.a
    public final void a(Context context, ExecutorC0856c executorC0856c, i iVar) {
        l lVar;
        ReentrantLock reentrantLock = this.f263b;
        reentrantLock.lock();
        LinkedHashMap linkedHashMap = this.f264c;
        try {
            f fVar = (f) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.f265d;
            if (fVar != null) {
                fVar.b(iVar);
                linkedHashMap2.put(iVar, context);
                lVar = l.f540a;
            } else {
                lVar = null;
            }
            if (lVar == null) {
                f fVar2 = new f(context);
                linkedHashMap.put(context, fVar2);
                linkedHashMap2.put(iVar, context);
                fVar2.b(iVar);
                this.f262a.addWindowLayoutInfoListener(context, fVar2);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // C0.a
    public final void b(i iVar) {
        ReentrantLock reentrantLock = this.f263b;
        reentrantLock.lock();
        LinkedHashMap linkedHashMap = this.f265d;
        try {
            Context context = (Context) linkedHashMap.get(iVar);
            if (context == null) {
                return;
            }
            LinkedHashMap linkedHashMap2 = this.f264c;
            f fVar = (f) linkedHashMap2.get(context);
            if (fVar == null) {
                return;
            }
            ReentrantLock reentrantLock2 = fVar.f267b;
            reentrantLock2.lock();
            LinkedHashSet linkedHashSet = fVar.f269d;
            try {
                linkedHashSet.remove(iVar);
                reentrantLock2.unlock();
                linkedHashMap.remove(iVar);
                if (linkedHashSet.isEmpty()) {
                    linkedHashMap2.remove(context);
                    this.f262a.removeWindowLayoutInfoListener(fVar);
                }
            } catch (Throwable th) {
                reentrantLock2.unlock();
                throw th;
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}

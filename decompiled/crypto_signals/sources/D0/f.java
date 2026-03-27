package D0;

import B0.i;
import B0.l;
import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class f implements C.a, Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f266a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f268c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f267b = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f269d = new LinkedHashSet();

    public f(Context context) {
        this.f266a = context;
    }

    @Override // C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(WindowLayoutInfo value) {
        j.e(value, "value");
        ReentrantLock reentrantLock = this.f267b;
        reentrantLock.lock();
        try {
            this.f268c = e.c(this.f266a, value);
            Iterator it = this.f269d.iterator();
            while (it.hasNext()) {
                ((C.a) it.next()).accept(this.f268c);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(i iVar) {
        ReentrantLock reentrantLock = this.f267b;
        reentrantLock.lock();
        try {
            l lVar = this.f268c;
            if (lVar != null) {
                iVar.accept(lVar);
            }
            this.f269d.add(iVar);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}

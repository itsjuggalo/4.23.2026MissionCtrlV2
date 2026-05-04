package y2;

import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import cd.h0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReentrantLock f25175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f25176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map f25177i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(WindowLayoutComponent component, t2.d adapter) {
        super(component, adapter);
        t.f(component, "component");
        t.f(adapter, "adapter");
        this.f25175g = new ReentrantLock();
        this.f25176h = new LinkedHashMap();
        this.f25177i = new LinkedHashMap();
    }

    @Override // y2.d, y2.c, x2.a
    public void a(s0.a callback) {
        t.f(callback, "callback");
        ReentrantLock reentrantLock = this.f25175g;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f25177i.get(callback);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            i iVar = (i) this.f25176h.get(context);
            if (iVar == null) {
                reentrantLock.unlock();
                return;
            }
            iVar.d(callback);
            this.f25177i.remove(callback);
            if (iVar.c()) {
                this.f25176h.remove(context);
                e().removeWindowLayoutInfoListener(iVar);
            }
            h0 h0Var = h0.f3852a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // y2.d, y2.c, x2.a
    public void b(Context context, Executor executor, s0.a callback) {
        t.f(context, "context");
        t.f(executor, "executor");
        t.f(callback, "callback");
        ReentrantLock reentrantLock = this.f25175g;
        reentrantLock.lock();
        try {
            i iVar = (i) this.f25176h.get(context);
            if (iVar != null) {
                iVar.b(callback);
                this.f25177i.put(callback, context);
            } else {
                i iVar2 = new i(context);
                this.f25176h.put(context, iVar2);
                this.f25177i.put(callback, context);
                iVar2.b(callback);
                e().addWindowLayoutInfoListener(context, iVar2);
            }
            h0 h0Var = h0.f3852a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}

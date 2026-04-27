package N0;

import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
public class e extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReentrantLock f5452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f5453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map f5454i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(WindowLayoutComponent component, I0.d adapter) {
        super(component, adapter);
        AbstractC2304t.f(component, "component");
        AbstractC2304t.f(adapter, "adapter");
        this.f5452g = new ReentrantLock();
        this.f5453h = new LinkedHashMap();
        this.f5454i = new LinkedHashMap();
    }

    @Override // N0.d, M0.a
    public void a(Context context, Executor executor, S.a callback) {
        C2470H c2470h;
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(executor, "executor");
        AbstractC2304t.f(callback, "callback");
        ReentrantLock reentrantLock = this.f5452g;
        reentrantLock.lock();
        try {
            h hVar = (h) this.f5453h.get(context);
            if (hVar != null) {
                hVar.b(callback);
                this.f5454i.put(callback, context);
                c2470h = C2470H.f21956a;
            } else {
                c2470h = null;
            }
            if (c2470h == null) {
                h hVar2 = new h(context);
                this.f5453h.put(context, hVar2);
                this.f5454i.put(callback, context);
                hVar2.b(callback);
                c().addWindowLayoutInfoListener(context, hVar2);
            }
            C2470H c2470h2 = C2470H.f21956a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // N0.d, M0.a
    public void b(S.a callback) {
        AbstractC2304t.f(callback, "callback");
        ReentrantLock reentrantLock = this.f5452g;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f5454i.get(callback);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            h hVar = (h) this.f5453h.get(context);
            if (hVar == null) {
                reentrantLock.unlock();
                return;
            }
            hVar.d(callback);
            this.f5454i.remove(callback);
            if (hVar.c()) {
                this.f5453h.remove(context);
                c().removeWindowLayoutInfoListener(hVar);
            }
            C2470H c2470h = C2470H.f21956a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}

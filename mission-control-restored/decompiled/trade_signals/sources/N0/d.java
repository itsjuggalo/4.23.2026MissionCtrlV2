package N0;

import B5.k;
import I0.d;
import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.extensions.MulticastConsumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.O;
import o5.C2470H;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
public class d implements M0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f5446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final I0.d f5447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f5448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f5449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f5450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f5451f;

    public /* synthetic */ class a extends AbstractC2302q implements k {
        public a(Object obj) {
            super(1, obj, MulticastConsumer.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0);
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m((WindowLayoutInfo) obj);
            return C2470H.f21956a;
        }

        public final void m(WindowLayoutInfo p02) {
            AbstractC2304t.f(p02, "p0");
            ((MulticastConsumer) this.receiver).accept(p02);
        }
    }

    public d(WindowLayoutComponent component, I0.d consumerAdapter) {
        AbstractC2304t.f(component, "component");
        AbstractC2304t.f(consumerAdapter, "consumerAdapter");
        this.f5446a = component;
        this.f5447b = consumerAdapter;
        this.f5448c = new ReentrantLock();
        this.f5449d = new LinkedHashMap();
        this.f5450e = new LinkedHashMap();
        this.f5451f = new LinkedHashMap();
    }

    @Override // M0.a
    public void a(Context context, Executor executor, S.a callback) {
        C2470H c2470h;
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(executor, "executor");
        AbstractC2304t.f(callback, "callback");
        ReentrantLock reentrantLock = this.f5448c;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f5449d.get(context);
            if (multicastConsumer != null) {
                multicastConsumer.a(callback);
                this.f5450e.put(callback, context);
                c2470h = C2470H.f21956a;
            } else {
                c2470h = null;
            }
            if (c2470h == null) {
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(context);
                this.f5449d.put(context, multicastConsumer2);
                this.f5450e.put(callback, context);
                multicastConsumer2.a(callback);
                if (!(context instanceof Activity)) {
                    multicastConsumer2.accept(new WindowLayoutInfo(AbstractC2595q.i()));
                    reentrantLock.unlock();
                    return;
                } else {
                    this.f5451f.put(multicastConsumer2, this.f5447b.c(this.f5446a, O.b(WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", (Activity) context, new a(multicastConsumer2)));
                }
            }
            C2470H c2470h2 = C2470H.f21956a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // M0.a
    public void b(S.a callback) {
        AbstractC2304t.f(callback, "callback");
        ReentrantLock reentrantLock = this.f5448c;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f5450e.get(callback);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f5449d.get(context);
            if (multicastConsumer == null) {
                reentrantLock.unlock();
                return;
            }
            multicastConsumer.c(callback);
            this.f5450e.remove(callback);
            if (multicastConsumer.b()) {
                this.f5449d.remove(context);
                d.b bVar = (d.b) this.f5451f.remove(multicastConsumer);
                if (bVar != null) {
                    bVar.dispose();
                }
            }
            C2470H c2470h = C2470H.f21956a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final WindowLayoutComponent c() {
        return this.f5446a;
    }
}

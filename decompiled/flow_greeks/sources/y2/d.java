package y2;

import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.extensions.MulticastConsumer;
import cd.h0;
import dd.r;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import pd.k;
import t2.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f25169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t2.d f25170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f25171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f25172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f25173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f25174f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final /* synthetic */ class a extends q implements k {
        public a(Object obj) {
            super(1, obj, MulticastConsumer.class, "accept", "accept(Landroidx/window/extensions/layout/WindowLayoutInfo;)V", 0);
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            o((WindowLayoutInfo) obj);
            return h0.f3852a;
        }

        public final void o(WindowLayoutInfo p02) {
            t.f(p02, "p0");
            ((MulticastConsumer) this.receiver).accept(p02);
        }
    }

    public d(WindowLayoutComponent component, t2.d consumerAdapter) {
        t.f(component, "component");
        t.f(consumerAdapter, "consumerAdapter");
        this.f25169a = component;
        this.f25170b = consumerAdapter;
        this.f25171c = new ReentrantLock();
        this.f25172d = new LinkedHashMap();
        this.f25173e = new LinkedHashMap();
        this.f25174f = new LinkedHashMap();
    }

    @Override // y2.c, x2.a
    public void a(s0.a callback) {
        t.f(callback, "callback");
        ReentrantLock reentrantLock = this.f25171c;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f25173e.get(callback);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f25172d.get(context);
            if (multicastConsumer == null) {
                reentrantLock.unlock();
                return;
            }
            multicastConsumer.c(callback);
            this.f25173e.remove(callback);
            if (multicastConsumer.b()) {
                this.f25172d.remove(context);
                d.b bVar = (d.b) this.f25174f.remove(multicastConsumer);
                if (bVar != null) {
                    bVar.dispose();
                }
            }
            h0 h0Var = h0.f3852a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // y2.c, x2.a
    public void b(Context context, Executor executor, s0.a callback) {
        t.f(context, "context");
        t.f(executor, "executor");
        t.f(callback, "callback");
        ReentrantLock reentrantLock = this.f25171c;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f25172d.get(context);
            if (multicastConsumer != null) {
                multicastConsumer.a(callback);
                this.f25173e.put(callback, context);
            } else {
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(context);
                this.f25172d.put(context, multicastConsumer2);
                this.f25173e.put(callback, context);
                multicastConsumer2.a(callback);
                if (!(context instanceof Activity)) {
                    multicastConsumer2.accept(new WindowLayoutInfo(r.k()));
                    reentrantLock.unlock();
                    return;
                } else {
                    this.f25174f.put(multicastConsumer2, this.f25170b.c(this.f25169a, n0.b(WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", (Activity) context, new a(multicastConsumer2)));
                }
            }
            h0 h0Var = h0.f3852a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final WindowLayoutComponent e() {
        return this.f25169a;
    }
}

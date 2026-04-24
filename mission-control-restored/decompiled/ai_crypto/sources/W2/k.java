package W2;

import X2.a;
import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.ComponentCallbacks2C1166c;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f5421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X2.a f5422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f5423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f5424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f5425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f5426f;

    public class a implements ComponentCallbacks2C1166c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f5427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ X2.a f5428b;

        public a(h hVar, X2.a aVar) {
            this.f5427a = hVar;
            this.f5428b = aVar;
        }

        @Override // com.google.android.gms.common.api.internal.ComponentCallbacks2C1166c.a
        public void a(boolean z7) {
            k.this.f5423c = z7;
            if (z7) {
                this.f5427a.c();
            } else if (k.this.e()) {
                this.f5427a.g(k.this.f5425e - this.f5428b.a());
            }
        }
    }

    public k(Context context, e eVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this((Context) AbstractC1207s.k(context), new h((e) AbstractC1207s.k(eVar), executor, scheduledExecutorService), new a.C0098a());
    }

    public void d(int i7) {
        if (this.f5424d == 0 && i7 > 0) {
            this.f5424d = i7;
            if (e()) {
                this.f5421a.g(this.f5425e - this.f5422b.a());
            }
        } else if (this.f5424d > 0 && i7 == 0) {
            this.f5421a.c();
        }
        this.f5424d = i7;
    }

    public final boolean e() {
        return this.f5426f && !this.f5423c && this.f5424d > 0 && this.f5425e != -1;
    }

    public k(Context context, h hVar, X2.a aVar) {
        this.f5421a = hVar;
        this.f5422b = aVar;
        this.f5425e = -1L;
        ComponentCallbacks2C1166c.c((Application) context.getApplicationContext());
        ComponentCallbacks2C1166c.b().a(new a(hVar, aVar));
    }
}

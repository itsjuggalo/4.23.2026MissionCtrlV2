package androidx.emoji2.text;

import android.content.Context;
import androidx.emoji2.text.c;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import p0.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements l2.b {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements DefaultLifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f1944a;

        public a(i iVar) {
            this.f1944a = iVar;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(m mVar) {
            EmojiCompatInitializer.this.d();
            this.f1944a.c(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends c.AbstractC0025c {
        public b(Context context) {
            super(new c(context));
            b(1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements c.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1946a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a extends c.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c.i f1947a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ThreadPoolExecutor f1948b;

            public a(c.i iVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f1947a = iVar;
                this.f1948b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.c.i
            public void a(Throwable th) {
                try {
                    this.f1947a.a(th);
                } finally {
                    this.f1948b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.c.i
            public void b(f fVar) {
                try {
                    this.f1947a.b(fVar);
                } finally {
                    this.f1948b.shutdown();
                }
            }
        }

        public c(Context context) {
            this.f1946a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.c.h
        public void a(final c.i iVar) {
            final ThreadPoolExecutor threadPoolExecutorB = q1.b.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: q1.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18755a.c(iVar, threadPoolExecutorB);
                }
            });
        }

        public void c(c.i iVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                e eVarA = androidx.emoji2.text.a.a(this.f1946a);
                if (eVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                eVarA.c(threadPoolExecutor);
                eVarA.a().a(new a(iVar, threadPoolExecutor));
            } catch (Throwable th) {
                iVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                k.a("EmojiCompat.EmojiCompatInitializer.run");
                if (androidx.emoji2.text.c.i()) {
                    androidx.emoji2.text.c.c().l();
                }
            } finally {
                k.b();
            }
        }
    }

    @Override // l2.b
    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // l2.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean create(Context context) {
        androidx.emoji2.text.c.h(new b(context));
        c(context);
        return Boolean.TRUE;
    }

    public void c(Context context) {
        i lifecycle = ((m) l2.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new a(lifecycle));
    }

    public void d() {
        q1.b.c().postDelayed(new d(), 500L);
    }
}

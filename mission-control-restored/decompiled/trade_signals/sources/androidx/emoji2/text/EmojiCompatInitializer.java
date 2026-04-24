package androidx.emoji2.text;

import P.l;
import android.content.Context;
import androidx.emoji2.text.c;
import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC1161m;
import androidx.lifecycle.ProcessLifecycleInitializer;
import h0.AbstractC1844c;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements A0.b {

    public class a implements DefaultLifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1157i f11450a;

        public a(AbstractC1157i abstractC1157i) {
            this.f11450a = abstractC1157i;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(InterfaceC1161m interfaceC1161m) {
            EmojiCompatInitializer.this.e();
            this.f11450a.c(this);
        }
    }

    public static class b extends c.AbstractC0184c {
        public b(Context context) {
            super(new c(context));
            b(1);
        }
    }

    public static class c implements c.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f11452a;

        public class a extends c.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c.i f11453a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ThreadPoolExecutor f11454b;

            public a(c.i iVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f11453a = iVar;
                this.f11454b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.c.i
            public void a(Throwable th) {
                try {
                    this.f11453a.a(th);
                } finally {
                    this.f11454b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.c.i
            public void b(f fVar) {
                try {
                    this.f11453a.b(fVar);
                } finally {
                    this.f11454b.shutdown();
                }
            }
        }

        public c(Context context) {
            this.f11452a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.c.h
        public void a(final c.i iVar) {
            final ThreadPoolExecutor threadPoolExecutorB = AbstractC1844c.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: h0.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18310a.d(iVar, threadPoolExecutorB);
                }
            });
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(c.i iVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                e eVarA = androidx.emoji2.text.a.a(this.f11452a);
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

    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                l.a("EmojiCompat.EmojiCompatInitializer.run");
                if (androidx.emoji2.text.c.i()) {
                    androidx.emoji2.text.c.c().l();
                }
            } finally {
                l.b();
            }
        }
    }

    @Override // A0.b
    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // A0.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        androidx.emoji2.text.c.h(new b(context));
        d(context);
        return Boolean.TRUE;
    }

    public void d(Context context) {
        AbstractC1157i lifecycle = ((InterfaceC1161m) A0.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new a(lifecycle));
    }

    public void e() {
        AbstractC1844c.d().postDelayed(new d(), 500L);
    }
}

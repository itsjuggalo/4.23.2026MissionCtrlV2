package androidx.emoji2.text;

import M.n;
import android.content.Context;
import androidx.emoji2.text.c;
import androidx.lifecycle.AbstractC0963i;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0967m;
import androidx.lifecycle.ProcessLifecycleInitializer;
import h0.AbstractC1667c;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements G0.b {

    public class a implements DefaultLifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0963i f7638a;

        public a(AbstractC0963i abstractC0963i) {
            this.f7638a = abstractC0963i;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(InterfaceC0967m interfaceC0967m) {
            EmojiCompatInitializer.this.e();
            this.f7638a.c(this);
        }
    }

    public static class b extends c.AbstractC0127c {
        public b(Context context) {
            super(new c(context));
            b(1);
        }
    }

    public static class c implements c.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f7640a;

        public class a extends c.h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c.h f7641a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ThreadPoolExecutor f7642b;

            public a(c.h hVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f7641a = hVar;
                this.f7642b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.c.h
            public void a(Throwable th) {
                try {
                    this.f7641a.a(th);
                } finally {
                    this.f7642b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.c.h
            public void b(f fVar) {
                try {
                    this.f7641a.b(fVar);
                } finally {
                    this.f7642b.shutdown();
                }
            }
        }

        public c(Context context) {
            this.f7640a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.c.g
        public void a(final c.h hVar) {
            final ThreadPoolExecutor threadPoolExecutorB = AbstractC1667c.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: h0.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14691a.d(hVar, threadPoolExecutorB);
                }
            });
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(c.h hVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                e eVarA = androidx.emoji2.text.a.a(this.f7640a);
                if (eVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                eVarA.c(threadPoolExecutor);
                eVarA.a().a(new a(hVar, threadPoolExecutor));
            } catch (Throwable th) {
                hVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                n.a("EmojiCompat.EmojiCompatInitializer.run");
                if (androidx.emoji2.text.c.h()) {
                    androidx.emoji2.text.c.b().k();
                }
            } finally {
                n.b();
            }
        }
    }

    @Override // G0.b
    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // G0.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        androidx.emoji2.text.c.g(new b(context));
        d(context);
        return Boolean.TRUE;
    }

    public void d(Context context) {
        AbstractC0963i abstractC0963iA = ((InterfaceC0967m) G0.a.e(context).f(ProcessLifecycleInitializer.class)).a();
        abstractC0963iA.a(new a(abstractC0963iA));
    }

    public void e() {
        AbstractC1667c.d().postDelayed(new d(), 500L);
    }
}

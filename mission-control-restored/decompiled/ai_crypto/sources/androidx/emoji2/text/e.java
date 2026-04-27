package androidx.emoji2.text;

import I.k;
import M.n;
import N.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.c;
import h0.AbstractC1667c;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class e extends c.AbstractC0127c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f7692j = new a();

    public static class a {
        public Typeface a(Context context, g.b bVar) {
            return g.a(context, null, new g.b[]{bVar});
        }

        public g.a b(Context context, N.e eVar) {
            return g.b(context, null, eVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static class b implements c.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f7693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final N.e f7694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f7695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f7696d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Handler f7697e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Executor f7698f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ThreadPoolExecutor f7699g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c.h f7700h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ContentObserver f7701i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Runnable f7702j;

        public b(Context context, N.e eVar, a aVar) {
            P.f.h(context, "Context cannot be null");
            P.f.h(eVar, "FontRequest cannot be null");
            this.f7693a = context.getApplicationContext();
            this.f7694b = eVar;
            this.f7695c = aVar;
        }

        @Override // androidx.emoji2.text.c.g
        public void a(c.h hVar) {
            P.f.h(hVar, "LoaderCallback cannot be null");
            synchronized (this.f7696d) {
                this.f7700h = hVar;
            }
            d();
        }

        public final void b() {
            synchronized (this.f7696d) {
                try {
                    this.f7700h = null;
                    ContentObserver contentObserver = this.f7701i;
                    if (contentObserver != null) {
                        this.f7695c.c(this.f7693a, contentObserver);
                        this.f7701i = null;
                    }
                    Handler handler = this.f7697e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f7702j);
                    }
                    this.f7697e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f7699g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f7698f = null;
                    this.f7699g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c() {
            synchronized (this.f7696d) {
                try {
                    if (this.f7700h == null) {
                        return;
                    }
                    try {
                        g.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.f7696d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            n.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.f7695c.a(this.f7693a, bVarE);
                            ByteBuffer byteBufferF = k.f(this.f7693a, null, bVarE.d());
                            if (byteBufferF == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            f fVarB = f.b(typefaceA, byteBufferF);
                            n.b();
                            synchronized (this.f7696d) {
                                try {
                                    c.h hVar = this.f7700h;
                                    if (hVar != null) {
                                        hVar.b(fVarB);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            n.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.f7696d) {
                            try {
                                c.h hVar2 = this.f7700h;
                                if (hVar2 != null) {
                                    hVar2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        public void d() {
            synchronized (this.f7696d) {
                try {
                    if (this.f7700h == null) {
                        return;
                    }
                    if (this.f7698f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = AbstractC1667c.b("emojiCompat");
                        this.f7699g = threadPoolExecutorB;
                        this.f7698f = threadPoolExecutorB;
                    }
                    this.f7698f.execute(new Runnable() { // from class: h0.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f14703a.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final g.b e() {
            try {
                g.a aVarB = this.f7695c.b(this.f7693a, this.f7694b);
                if (aVarB.c() == 0) {
                    g.b[] bVarArrB = aVarB.b();
                    if (bVarArrB == null || bVarArrB.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrB[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.c() + ")");
            } catch (PackageManager.NameNotFoundException e7) {
                throw new RuntimeException("provider not found", e7);
            }
        }

        public void f(Executor executor) {
            synchronized (this.f7696d) {
                this.f7698f = executor;
            }
        }
    }

    public e(Context context, N.e eVar) {
        super(new b(context, eVar, f7692j));
    }

    public e c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}

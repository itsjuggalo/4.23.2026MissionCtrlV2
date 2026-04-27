package androidx.emoji2.text;

import L.k;
import P.l;
import Q.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.c;
import h0.AbstractC1844c;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class e extends c.AbstractC0184c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f11509k = new a();

    public static class a {
        public Typeface a(Context context, g.b bVar) {
            return g.a(context, null, new g.b[]{bVar});
        }

        public g.a b(Context context, Q.e eVar) {
            return g.b(context, null, eVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static class b implements c.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f11510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Q.e f11511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f11512c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f11513d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Handler f11514e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Executor f11515f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ThreadPoolExecutor f11516g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c.i f11517h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ContentObserver f11518i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Runnable f11519j;

        public b(Context context, Q.e eVar, a aVar) {
            S.g.e(context, "Context cannot be null");
            S.g.e(eVar, "FontRequest cannot be null");
            this.f11510a = context.getApplicationContext();
            this.f11511b = eVar;
            this.f11512c = aVar;
        }

        @Override // androidx.emoji2.text.c.h
        public void a(c.i iVar) {
            S.g.e(iVar, "LoaderCallback cannot be null");
            synchronized (this.f11513d) {
                this.f11517h = iVar;
            }
            d();
        }

        public final void b() {
            synchronized (this.f11513d) {
                try {
                    this.f11517h = null;
                    ContentObserver contentObserver = this.f11518i;
                    if (contentObserver != null) {
                        this.f11512c.c(this.f11510a, contentObserver);
                        this.f11518i = null;
                    }
                    Handler handler = this.f11514e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f11519j);
                    }
                    this.f11514e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f11516g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f11515f = null;
                    this.f11516g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c() {
            synchronized (this.f11513d) {
                try {
                    if (this.f11517h == null) {
                        return;
                    }
                    try {
                        g.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.f11513d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            l.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.f11512c.a(this.f11510a, bVarE);
                            ByteBuffer byteBufferF = k.f(this.f11510a, null, bVarE.d());
                            if (byteBufferF == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            f fVarB = f.b(typefaceA, byteBufferF);
                            l.b();
                            synchronized (this.f11513d) {
                                try {
                                    c.i iVar = this.f11517h;
                                    if (iVar != null) {
                                        iVar.b(fVarB);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            l.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.f11513d) {
                            try {
                                c.i iVar2 = this.f11517h;
                                if (iVar2 != null) {
                                    iVar2.a(th2);
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
            synchronized (this.f11513d) {
                try {
                    if (this.f11517h == null) {
                        return;
                    }
                    if (this.f11515f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = AbstractC1844c.b("emojiCompat");
                        this.f11516g = threadPoolExecutorB;
                        this.f11515f = threadPoolExecutorB;
                    }
                    this.f11515f.execute(new Runnable() { // from class: h0.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f18318a.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final g.b e() {
            try {
                g.a aVarB = this.f11512c.b(this.f11510a, this.f11511b);
                if (aVarB.c() == 0) {
                    g.b[] bVarArrB = aVarB.b();
                    if (bVarArrB == null || bVarArrB.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrB[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.c() + ")");
            } catch (PackageManager.NameNotFoundException e8) {
                throw new RuntimeException("provider not found", e8);
            }
        }

        public void f(Executor executor) {
            synchronized (this.f11513d) {
                this.f11515f = executor;
            }
        }
    }

    public e(Context context, Q.e eVar) {
        super(new b(context, eVar, f11509k));
    }

    public e c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}

package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.c;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import l0.n;
import p0.k;
import q0.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends c.AbstractC0025c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f2003k = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public Typeface a(Context context, g.b bVar) {
            return g.a(context, null, new g.b[]{bVar});
        }

        public g.a b(Context context, q0.e eVar) {
            return g.b(context, null, eVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements c.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f2004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q0.e f2005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f2006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f2007d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Handler f2008e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Executor f2009f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ThreadPoolExecutor f2010g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c.i f2011h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ContentObserver f2012i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Runnable f2013j;

        public b(Context context, q0.e eVar, a aVar) {
            s0.f.e(context, "Context cannot be null");
            s0.f.e(eVar, "FontRequest cannot be null");
            this.f2004a = context.getApplicationContext();
            this.f2005b = eVar;
            this.f2006c = aVar;
        }

        @Override // androidx.emoji2.text.c.h
        public void a(c.i iVar) {
            s0.f.e(iVar, "LoaderCallback cannot be null");
            synchronized (this.f2007d) {
                this.f2011h = iVar;
            }
            d();
        }

        public final void b() {
            synchronized (this.f2007d) {
                try {
                    this.f2011h = null;
                    ContentObserver contentObserver = this.f2012i;
                    if (contentObserver != null) {
                        this.f2006c.c(this.f2004a, contentObserver);
                        this.f2012i = null;
                    }
                    Handler handler = this.f2008e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f2013j);
                    }
                    this.f2008e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f2010g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f2009f = null;
                    this.f2010g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c() {
            synchronized (this.f2007d) {
                try {
                    if (this.f2011h == null) {
                        return;
                    }
                    try {
                        g.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.f2007d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            k.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.f2006c.a(this.f2004a, bVarE);
                            ByteBuffer byteBufferF = n.f(this.f2004a, null, bVarE.d());
                            if (byteBufferF == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            f fVarB = f.b(typefaceA, byteBufferF);
                            k.b();
                            synchronized (this.f2007d) {
                                try {
                                    c.i iVar = this.f2011h;
                                    if (iVar != null) {
                                        iVar.b(fVarB);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            k.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.f2007d) {
                            try {
                                c.i iVar2 = this.f2011h;
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
            synchronized (this.f2007d) {
                try {
                    if (this.f2011h == null) {
                        return;
                    }
                    if (this.f2009f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = q1.b.b("emojiCompat");
                        this.f2010g = threadPoolExecutorB;
                        this.f2009f = threadPoolExecutorB;
                    }
                    this.f2009f.execute(new Runnable() { // from class: q1.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f18763a.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final g.b e() {
            try {
                g.a aVarB = this.f2006c.b(this.f2004a, this.f2005b);
                if (aVarB.e() == 0) {
                    g.b[] bVarArrC = aVarB.c();
                    if (bVarArrC == null || bVarArrC.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrC[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.e() + ")");
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }

        public void f(Executor executor) {
            synchronized (this.f2007d) {
                this.f2009f = executor;
            }
        }
    }

    public e(Context context, q0.e eVar) {
        super(new b(context, eVar, f2003k));
    }

    public e c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}

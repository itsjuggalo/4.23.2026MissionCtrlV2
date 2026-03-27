package h1;

import T0.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import c1.n;
import com.bumptech.glide.load.ImageHeaderParser;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import q1.AbstractC2624g;
import q1.AbstractC2629l;

/* JADX INFO: renamed from: h1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1846a implements U0.j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0311a f18334f = new C0311a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f18335g = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f18337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f18338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0311a f18339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1847b f18340e;

    /* JADX INFO: renamed from: h1.a$a, reason: collision with other inner class name */
    public static class C0311a {
        public T0.a a(a.InterfaceC0112a interfaceC0112a, T0.c cVar, ByteBuffer byteBuffer, int i8) {
            return new T0.e(interfaceC0112a, cVar, byteBuffer, i8);
        }
    }

    /* JADX INFO: renamed from: h1.a$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue f18341a = AbstractC2629l.f(0);

        public synchronized T0.d a(ByteBuffer byteBuffer) {
            T0.d dVar;
            try {
                dVar = (T0.d) this.f18341a.poll();
                if (dVar == null) {
                    dVar = new T0.d();
                }
            } catch (Throwable th) {
                throw th;
            }
            return dVar.p(byteBuffer);
        }

        public synchronized void b(T0.d dVar) {
            dVar.a();
            this.f18341a.offer(dVar);
        }
    }

    public C1846a(Context context, List list, X0.d dVar, X0.b bVar) {
        this(context, list, dVar, bVar, f18335g, f18334f);
    }

    public static int e(T0.c cVar, int i8, int i9) {
        int iMin = Math.min(cVar.a() / i9, cVar.d() / i8);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i8 + "x" + i9 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return iMax;
    }

    public final C1850e c(ByteBuffer byteBuffer, int i8, int i9, T0.d dVar, U0.h hVar) {
        long jB = AbstractC2624g.b();
        try {
            T0.c cVarC = dVar.c();
            if (cVarC.b() > 0 && cVarC.c() == 0) {
                Bitmap.Config config = hVar.c(AbstractC1854i.f18381a) == U0.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                T0.a aVarA = this.f18339d.a(this.f18340e, cVarC, byteBuffer, e(cVarC, i8, i9));
                aVarA.e(config);
                aVarA.b();
                Bitmap bitmapA = aVarA.a();
                if (bitmapA == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + AbstractC2624g.a(jB));
                    }
                    return null;
                }
                C1850e c1850e = new C1850e(new C1848c(this.f18336a, aVarA, n.c(), i8, i9, bitmapA));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + AbstractC2624g.a(jB));
                }
                return c1850e;
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + AbstractC2624g.a(jB));
            }
        }
    }

    @Override // U0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public C1850e a(ByteBuffer byteBuffer, int i8, int i9, U0.h hVar) {
        T0.d dVarA = this.f18338c.a(byteBuffer);
        try {
            return c(byteBuffer, i8, i9, dVarA, hVar);
        } finally {
            this.f18338c.b(dVarA);
        }
    }

    @Override // U0.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, U0.h hVar) {
        return !((Boolean) hVar.c(AbstractC1854i.f18382b)).booleanValue() && com.bumptech.glide.load.a.g(this.f18337b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public C1846a(Context context, List list, X0.d dVar, X0.b bVar, b bVar2, C0311a c0311a) {
        this.f18336a = context.getApplicationContext();
        this.f18337b = list;
        this.f18339d = c0311a;
        this.f18340e = new C1847b(dVar, bVar);
        this.f18338c = bVar2;
    }
}

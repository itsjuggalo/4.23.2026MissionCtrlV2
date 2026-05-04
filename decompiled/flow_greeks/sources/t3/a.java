package t3;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import c4.l;
import com.bumptech.glide.load.ImageHeaderParser;
import f3.a;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a implements g3.j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0366a f20677f = new C0366a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f20678g = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f20680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f20681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0366a f20682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t3.b f20683e;

    /* JADX INFO: renamed from: t3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0366a {
        public f3.a a(a.InterfaceC0172a interfaceC0172a, f3.c cVar, ByteBuffer byteBuffer, int i10) {
            return new f3.e(interfaceC0172a, cVar, byteBuffer, i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue f20684a = l.f(0);

        public synchronized f3.d a(ByteBuffer byteBuffer) {
            f3.d dVar;
            try {
                dVar = (f3.d) this.f20684a.poll();
                if (dVar == null) {
                    dVar = new f3.d();
                }
            } catch (Throwable th) {
                throw th;
            }
            return dVar.p(byteBuffer);
        }

        public synchronized void b(f3.d dVar) {
            dVar.a();
            this.f20684a.offer(dVar);
        }
    }

    public a(Context context, List list, j3.d dVar, j3.b bVar) {
        this(context, list, dVar, bVar, f20678g, f20677f);
    }

    public static int e(f3.c cVar, int i10, int i11) {
        int iMin = Math.min(cVar.a() / i11, cVar.d() / i10);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i10 + "x" + i11 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return iMax;
    }

    public final e c(ByteBuffer byteBuffer, int i10, int i11, f3.d dVar, g3.h hVar) {
        StringBuilder sb2;
        long jB = c4.g.b();
        try {
            f3.c cVarC = dVar.c();
            if (cVarC.b() > 0 && cVarC.c() == 0) {
                Bitmap.Config config = hVar.c(i.f20724a) == g3.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                f3.a aVarA = this.f20682d.a(this.f20683e, cVarC, byteBuffer, e(cVarC, i10, i11));
                aVarA.f(config);
                aVarA.c();
                Bitmap bitmapB = aVarA.b();
                if (bitmapB == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb2 = new StringBuilder();
                    }
                    return null;
                }
                e eVar = new e(new c(this.f20679a, aVarA, o3.e.c(), i10, i11, bitmapB));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + c4.g.a(jB));
                }
                return eVar;
            }
            if (!Log.isLoggable("BufferGifDecoder", 2)) {
                return null;
            }
            sb2 = new StringBuilder();
            sb2.append("Decoded GIF from stream in ");
            sb2.append(c4.g.a(jB));
            Log.v("BufferGifDecoder", sb2.toString());
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + c4.g.a(jB));
            }
            throw th;
        }
    }

    @Override // g3.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public e a(ByteBuffer byteBuffer, int i10, int i11, g3.h hVar) {
        f3.d dVarA = this.f20681c.a(byteBuffer);
        try {
            return c(byteBuffer, i10, i11, dVarA, hVar);
        } finally {
            this.f20681c.b(dVarA);
        }
    }

    @Override // g3.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, g3.h hVar) {
        return !((Boolean) hVar.c(i.f20725b)).booleanValue() && com.bumptech.glide.load.a.g(this.f20680b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public a(Context context, List list, j3.d dVar, j3.b bVar, b bVar2, C0366a c0366a) {
        this.f20679a = context.getApplicationContext();
        this.f20680b = list;
        this.f20682d = c0366a;
        this.f20683e = new t3.b(dVar, bVar);
        this.f20681c = bVar2;
    }
}

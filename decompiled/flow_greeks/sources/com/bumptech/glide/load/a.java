package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import p3.b0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bumptech.glide.load.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0093a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f5263a;

        public C0093a(InputStream inputStream) {
            this.f5263a = inputStream;
        }

        @Override // com.bumptech.glide.load.a.l
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.e(this.f5263a);
            } finally {
                this.f5263a.reset();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f5264a;

        public b(ByteBuffer byteBuffer) {
            this.f5264a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.a.l
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.a(this.f5264a);
            } finally {
                c4.a.d(this.f5264a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f5265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j3.b f5266b;

        public c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, j3.b bVar) {
            this.f5265a = parcelFileDescriptorRewinder;
            this.f5266b = bVar;
        }

        @Override // com.bumptech.glide.load.a.l
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            b0 b0Var = null;
            try {
                b0 b0Var2 = new b0(new FileInputStream(this.f5265a.a().getFileDescriptor()), this.f5266b);
                try {
                    ImageHeaderParser.ImageType imageTypeE = imageHeaderParser.e(b0Var2);
                    b0Var2.e();
                    this.f5265a.a();
                    return imageTypeE;
                } catch (Throwable th) {
                    th = th;
                    b0Var = b0Var2;
                    if (b0Var != null) {
                        b0Var.e();
                    }
                    this.f5265a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f5267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j3.b f5268b;

        public d(ByteBuffer byteBuffer, j3.b bVar) {
            this.f5267a = byteBuffer;
            this.f5268b = bVar;
        }

        @Override // com.bumptech.glide.load.a.k
        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.c(this.f5267a, this.f5268b);
            } finally {
                c4.a.d(this.f5267a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f5269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j3.b f5270b;

        public e(InputStream inputStream, j3.b bVar) {
            this.f5269a = inputStream;
            this.f5270b = bVar;
        }

        @Override // com.bumptech.glide.load.a.k
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.d(this.f5269a, this.f5270b);
            } finally {
                this.f5269a.reset();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f5271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j3.b f5272b;

        public f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, j3.b bVar) {
            this.f5271a = parcelFileDescriptorRewinder;
            this.f5272b = bVar;
        }

        @Override // com.bumptech.glide.load.a.k
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            b0 b0Var = null;
            try {
                b0 b0Var2 = new b0(new FileInputStream(this.f5271a.a().getFileDescriptor()), this.f5272b);
                try {
                    int iD = imageHeaderParser.d(b0Var2, this.f5272b);
                    b0Var2.e();
                    this.f5271a.a();
                    return iD;
                } catch (Throwable th) {
                    th = th;
                    b0Var = b0Var2;
                    if (b0Var != null) {
                        b0Var.e();
                    }
                    this.f5271a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f5273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j3.b f5274b;

        public g(ByteBuffer byteBuffer, j3.b bVar) {
            this.f5273a = byteBuffer;
            this.f5274b = bVar;
        }

        @Override // com.bumptech.glide.load.a.j
        public boolean a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.b(this.f5273a, this.f5274b);
            } finally {
                c4.a.d(this.f5273a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class h implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f5275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j3.b f5276b;

        public h(InputStream inputStream, j3.b bVar) {
            this.f5275a = inputStream;
            this.f5276b = bVar;
        }

        @Override // com.bumptech.glide.load.a.j
        public boolean a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.f(this.f5275a, this.f5276b);
            } finally {
                this.f5275a.reset();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class i implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f5277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j3.b f5278b;

        public i(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, j3.b bVar) {
            this.f5277a = parcelFileDescriptorRewinder;
            this.f5278b = bVar;
        }

        @Override // com.bumptech.glide.load.a.j
        public boolean a(ImageHeaderParser imageHeaderParser) throws Throwable {
            b0 b0Var = null;
            try {
                b0 b0Var2 = new b0(new FileInputStream(this.f5277a.a().getFileDescriptor()), this.f5278b);
                try {
                    boolean zF = imageHeaderParser.f(b0Var2, this.f5278b);
                    b0Var2.e();
                    this.f5277a.a();
                    return zF;
                } catch (Throwable th) {
                    th = th;
                    b0Var = b0Var2;
                    if (b0Var != null) {
                        b0Var.e();
                    }
                    this.f5277a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface j {
        boolean a(ImageHeaderParser imageHeaderParser);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface k {
        int a(ImageHeaderParser imageHeaderParser);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface l {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, j3.b bVar) {
        return d(list, new f(parcelFileDescriptorRewinder, bVar));
    }

    public static int b(List list, InputStream inputStream, j3.b bVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new b0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return d(list, new e(inputStream, bVar));
    }

    public static int c(List list, ByteBuffer byteBuffer, j3.b bVar) {
        if (byteBuffer == null) {
            return -1;
        }
        return d(list, new d(byteBuffer, bVar));
    }

    public static int d(List list, k kVar) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            int iA = kVar.a((ImageHeaderParser) list.get(i10));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType e(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, j3.b bVar) {
        return h(list, new c(parcelFileDescriptorRewinder, bVar));
    }

    public static ImageHeaderParser.ImageType f(List list, InputStream inputStream, j3.b bVar) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new b0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return h(list, new C0093a(inputStream));
    }

    public static ImageHeaderParser.ImageType g(List list, ByteBuffer byteBuffer) {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : h(list, new b(byteBuffer));
    }

    public static ImageHeaderParser.ImageType h(List list, l lVar) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ImageHeaderParser.ImageType imageTypeA = lVar.a((ImageHeaderParser) list.get(i10));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static boolean i(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, j3.b bVar) {
        return l(list, new i(parcelFileDescriptorRewinder, bVar));
    }

    public static boolean j(List list, InputStream inputStream, j3.b bVar) {
        if (inputStream == null) {
            return false;
        }
        if (!inputStream.markSupported()) {
            inputStream = new b0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return l(list, new h(inputStream, bVar));
    }

    public static boolean k(List list, ByteBuffer byteBuffer, j3.b bVar) {
        if (byteBuffer == null) {
            return false;
        }
        return l(list, new g(byteBuffer, bVar));
    }

    public static boolean l(List list, j jVar) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (jVar.a((ImageHeaderParser) list.get(i10))) {
                return true;
            }
        }
        return false;
    }
}

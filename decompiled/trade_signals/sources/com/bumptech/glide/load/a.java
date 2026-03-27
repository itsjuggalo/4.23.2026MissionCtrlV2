package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import d1.C1611A;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import q1.AbstractC2618a;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bumptech.glide.load.a$a, reason: collision with other inner class name */
    public class C0249a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f14815a;

        public C0249a(InputStream inputStream) {
            this.f14815a = inputStream;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.c(this.f14815a);
            } finally {
                this.f14815a.reset();
            }
        }
    }

    public class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f14816a;

        public b(ByteBuffer byteBuffer) {
            this.f14816a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.a(this.f14816a);
            } finally {
                AbstractC2618a.d(this.f14816a);
            }
        }
    }

    public class c implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f14817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ X0.b f14818b;

        public c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, X0.b bVar) {
            this.f14817a = parcelFileDescriptorRewinder;
            this.f14818b = bVar;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            C1611A c1611a = null;
            try {
                C1611A c1611a2 = new C1611A(new FileInputStream(this.f14817a.a().getFileDescriptor()), this.f14818b);
                try {
                    ImageHeaderParser.ImageType imageTypeC = imageHeaderParser.c(c1611a2);
                    c1611a2.e();
                    this.f14817a.a();
                    return imageTypeC;
                } catch (Throwable th) {
                    th = th;
                    c1611a = c1611a2;
                    if (c1611a != null) {
                        c1611a.e();
                    }
                    this.f14817a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f14819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ X0.b f14820b;

        public d(ByteBuffer byteBuffer, X0.b bVar) {
            this.f14819a = byteBuffer;
            this.f14820b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.d(this.f14819a, this.f14820b);
            } finally {
                AbstractC2618a.d(this.f14819a);
            }
        }
    }

    public class e implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f14821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ X0.b f14822b;

        public e(InputStream inputStream, X0.b bVar) {
            this.f14821a = inputStream;
            this.f14822b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.b(this.f14821a, this.f14822b);
            } finally {
                this.f14821a.reset();
            }
        }
    }

    public class f implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f14823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ X0.b f14824b;

        public f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, X0.b bVar) {
            this.f14823a = parcelFileDescriptorRewinder;
            this.f14824b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            C1611A c1611a = null;
            try {
                C1611A c1611a2 = new C1611A(new FileInputStream(this.f14823a.a().getFileDescriptor()), this.f14824b);
                try {
                    int iB = imageHeaderParser.b(c1611a2, this.f14824b);
                    c1611a2.e();
                    this.f14823a.a();
                    return iB;
                } catch (Throwable th) {
                    th = th;
                    c1611a = c1611a2;
                    if (c1611a != null) {
                        c1611a.e();
                    }
                    this.f14823a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public interface g {
        int a(ImageHeaderParser imageHeaderParser);
    }

    public interface h {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, X0.b bVar) {
        return d(list, new f(parcelFileDescriptorRewinder, bVar));
    }

    public static int b(List list, InputStream inputStream, X0.b bVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new C1611A(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return d(list, new e(inputStream, bVar));
    }

    public static int c(List list, ByteBuffer byteBuffer, X0.b bVar) {
        if (byteBuffer == null) {
            return -1;
        }
        return d(list, new d(byteBuffer, bVar));
    }

    public static int d(List list, g gVar) {
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            int iA = gVar.a((ImageHeaderParser) list.get(i8));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType e(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, X0.b bVar) {
        return h(list, new c(parcelFileDescriptorRewinder, bVar));
    }

    public static ImageHeaderParser.ImageType f(List list, InputStream inputStream, X0.b bVar) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new C1611A(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return h(list, new C0249a(inputStream));
    }

    public static ImageHeaderParser.ImageType g(List list, ByteBuffer byteBuffer) {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : h(list, new b(byteBuffer));
    }

    public static ImageHeaderParser.ImageType h(List list, h hVar) {
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            ImageHeaderParser.ImageType imageTypeA = hVar.a((ImageHeaderParser) list.get(i8));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}

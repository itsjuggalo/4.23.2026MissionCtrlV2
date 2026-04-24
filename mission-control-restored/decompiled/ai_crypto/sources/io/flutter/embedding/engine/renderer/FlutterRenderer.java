package io.flutter.embedding.engine.renderer;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.Keep;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class FlutterRenderer implements TextureRegistry {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f16546i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f16547j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f16548a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f16550c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m f16555h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f16549b = new AtomicLong(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16551d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f16552e = new Handler();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f16553f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f16554g = new ArrayList();

    @Keep
    public final class ImageReaderSurfaceProducer implements TextureRegistry.SurfaceProducer, TextureRegistry.ImageConsumer, TextureRegistry.b {
        private static final boolean CLEANUP_ON_MEMORY_PRESSURE = true;
        private static final int MAX_DEQUEUED_IMAGES = 2;
        private static final int MAX_IMAGES = 6;
        private static final String TAG = "ImageReaderSurfaceProducer";
        private static final boolean VERBOSE_LOGS = false;
        private static final boolean trimOnMemoryPressure = true;
        TextureRegistry.SurfaceProducer.a callback;
        private final long id;
        private boolean released;
        private boolean ignoringFence = false;
        private int requestedWidth = 1;
        private int requestedHeight = 1;
        private boolean createNewReader = true;
        boolean notifiedDestroy = false;
        private long lastDequeueTime = 0;
        private long lastQueueTime = 0;
        private long lastScheduleTime = 0;
        private int numTrims = 0;
        private final Object lock = new Object();
        private final ArrayDeque<b> imageReaderQueue = new ArrayDeque<>();
        private final HashMap<ImageReader, b> perImageReaders = new HashMap<>();
        private ArrayList<a> lastDequeuedImage = new ArrayList<>();
        private b lastReaderDequeuedFrom = null;

        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Image f16556a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f16557b;

            public a(Image image, long j7) {
                this.f16556a = image;
                this.f16557b = j7;
            }
        }

        public class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ImageReader f16559a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ArrayDeque f16560b = new ArrayDeque();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f16561c = false;

            public b(ImageReader imageReader) {
                this.f16559a = imageReader;
                imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: io.flutter.embedding.engine.renderer.j
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public final void onImageAvailable(ImageReader imageReader2) {
                        this.f16604a.g(imageReader2);
                    }
                }, new Handler(Looper.getMainLooper()));
            }

            public boolean c() {
                return this.f16560b.isEmpty() && ImageReaderSurfaceProducer.this.lastReaderDequeuedFrom != this;
            }

            public void d() {
                this.f16561c = true;
                this.f16559a.close();
                this.f16560b.clear();
            }

            public a e() {
                if (this.f16560b.isEmpty()) {
                    return null;
                }
                return (a) this.f16560b.removeFirst();
            }

            public boolean f() {
                return this.f16560b.isEmpty();
            }

            public final /* synthetic */ void g(ImageReader imageReader) {
                Image imageAcquireLatestImage;
                try {
                    imageAcquireLatestImage = imageReader.acquireLatestImage();
                } catch (IllegalStateException e7) {
                    J4.b.b(ImageReaderSurfaceProducer.TAG, "onImageAvailable acquireLatestImage failed: " + e7);
                    imageAcquireLatestImage = null;
                }
                if (imageAcquireLatestImage == null) {
                    return;
                }
                if (ImageReaderSurfaceProducer.this.released || this.f16561c) {
                    imageAcquireLatestImage.close();
                } else {
                    ImageReaderSurfaceProducer.this.onImage(imageReader, imageAcquireLatestImage);
                }
            }

            public a h(Image image) {
                if (this.f16561c) {
                    return null;
                }
                a aVar = ImageReaderSurfaceProducer.this.new a(image, System.nanoTime());
                this.f16560b.add(aVar);
                while (this.f16560b.size() > 2) {
                    ((a) this.f16560b.removeFirst()).f16556a.close();
                }
                return aVar;
            }
        }

        public ImageReaderSurfaceProducer(long j7) {
            this.id = j7;
        }

        private void cleanup() {
            synchronized (this.lock) {
                try {
                    for (b bVar : this.perImageReaders.values()) {
                        if (this.lastReaderDequeuedFrom == bVar) {
                            this.lastReaderDequeuedFrom = null;
                        }
                        bVar.d();
                    }
                    this.perImageReaders.clear();
                    if (this.lastDequeuedImage.size() > 0) {
                        Iterator<a> it = this.lastDequeuedImage.iterator();
                        while (it.hasNext()) {
                            it.next().f16556a.close();
                        }
                        this.lastDequeuedImage.clear();
                    }
                    b bVar2 = this.lastReaderDequeuedFrom;
                    if (bVar2 != null) {
                        bVar2.d();
                        this.lastReaderDequeuedFrom = null;
                    }
                    this.imageReaderQueue.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private ImageReader createImageReader29() {
            return ImageReader.newInstance(this.requestedWidth, this.requestedHeight, 34, 6, 256L);
        }

        private ImageReader createImageReader33() {
            h.a();
            ImageReader.Builder builderA = io.flutter.embedding.engine.renderer.g.a(this.requestedWidth, this.requestedHeight);
            builderA.setMaxImages(6);
            builderA.setImageFormat(34);
            builderA.setUsage(256L);
            return builderA.build();
        }

        private b getActiveReader() {
            synchronized (this.lock) {
                try {
                    if (!this.createNewReader) {
                        b bVarPeekLast = this.imageReaderQueue.peekLast();
                        if (bVarPeekLast.f16559a.getSurface().isValid()) {
                            return bVarPeekLast;
                        }
                    }
                    this.createNewReader = false;
                    return getOrCreatePerImageReader(createImageReader());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private b getOrCreatePerImageReader(ImageReader imageReader) {
            b bVar = this.perImageReaders.get(imageReader);
            if (bVar != null) {
                return bVar;
            }
            b bVarCreatePerImageReader = createPerImageReader(imageReader);
            this.perImageReaders.put(imageReader, bVarCreatePerImageReader);
            this.imageReaderQueue.add(bVarCreatePerImageReader);
            return bVarCreatePerImageReader;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$dequeueImage$0() {
            if (this.released) {
                return;
            }
            FlutterRenderer.this.w();
        }

        private void maybeWaitOnFence(Image image) {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else {
                this.ignoringFence = true;
                J4.b.a(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
            }
        }

        private void releaseInternal() {
            cleanup();
            this.released = true;
            FlutterRenderer.this.u(this);
            FlutterRenderer.this.f16554g.remove(this);
        }

        private void waitOnFence(Image image) {
            try {
                image.getFence().awaitForever();
            } catch (IOException unused) {
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            a aVarDequeueImage = dequeueImage();
            if (aVarDequeueImage == null) {
                return null;
            }
            maybeWaitOnFence(aVarDequeueImage.f16556a);
            return aVarDequeueImage.f16556a;
        }

        public ImageReader createImageReader() {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 33) {
                return createImageReader33();
            }
            if (i7 >= 29) {
                return createImageReader29();
            }
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }

        public b createPerImageReader(ImageReader imageReader) {
            return new b(imageReader);
        }

        public double deltaMillis(long j7) {
            return j7 / 1000000.0d;
        }

        public a dequeueImage() {
            a aVar;
            boolean z7;
            synchronized (this.lock) {
                try {
                    Iterator<b> it = this.imageReaderQueue.iterator();
                    aVar = null;
                    while (true) {
                        z7 = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        b next = it.next();
                        a aVarE = next.e();
                        if (aVarE == null) {
                            aVar = aVarE;
                        } else {
                            while (this.lastDequeuedImage.size() > 2) {
                                this.lastDequeuedImage.remove(0).f16556a.close();
                            }
                            this.lastDequeuedImage.add(aVarE);
                            this.lastReaderDequeuedFrom = next;
                            aVar = aVarE;
                        }
                    }
                    pruneImageReaderQueue();
                    Iterator<b> it2 = this.imageReaderQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (!it2.next().f()) {
                            z7 = true;
                            break;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z7) {
                FlutterRenderer.this.f16552e.post(new Runnable() { // from class: io.flutter.embedding.engine.renderer.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16603a.lambda$dequeueImage$0();
                    }
                });
            }
            return aVar;
        }

        public void disableFenceForTest() {
            this.ignoringFence = true;
        }

        public void finalize() throws Throwable {
            try {
                if (this.released) {
                    return;
                }
                releaseInternal();
                FlutterRenderer.this.f16552e.post(new f(this.id, FlutterRenderer.this.f16548a));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public Surface getForcedNewSurface() {
            this.createNewReader = true;
            return getSurface();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getHeight() {
            return this.requestedHeight;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public Surface getSurface() {
            return getActiveReader().f16559a.getSurface();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getWidth() {
            return this.requestedWidth;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public boolean handlesCropAndRotation() {
            return false;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public long id() {
            return this.id;
        }

        public int numImageReaders() {
            int size;
            synchronized (this.lock) {
                size = this.imageReaderQueue.size();
            }
            return size;
        }

        public int numImages() {
            int size;
            synchronized (this.lock) {
                try {
                    Iterator<b> it = this.imageReaderQueue.iterator();
                    size = 0;
                    while (it.hasNext()) {
                        size += it.next().f16560b.size();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return size;
        }

        public int numTrims() {
            int i7;
            synchronized (this.lock) {
                i7 = this.numTrims;
            }
            return i7;
        }

        public void onImage(ImageReader imageReader, Image image) {
            a aVarH;
            synchronized (this.lock) {
                aVarH = getOrCreatePerImageReader(imageReader).h(image);
            }
            if (aVarH == null) {
                return;
            }
            FlutterRenderer.this.w();
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i7) {
            if (i7 < 40) {
                return;
            }
            synchronized (this.lock) {
                this.numTrims++;
            }
            cleanup();
            this.createNewReader = true;
        }

        public int pendingDequeuedImages() {
            return this.lastDequeuedImage.size();
        }

        public void pruneImageReaderQueue() {
            b bVarPeekFirst;
            while (this.imageReaderQueue.size() > 1 && (bVarPeekFirst = this.imageReaderQueue.peekFirst()) != null && bVarPeekFirst.c()) {
                this.imageReaderQueue.removeFirst();
                this.perImageReaders.remove(bVarPeekFirst.f16559a);
                bVarPeekFirst.d();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void release() {
            if (this.released) {
                return;
            }
            releaseInternal();
            FlutterRenderer.this.E(this.id);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void scheduleFrame() {
            FlutterRenderer.this.w();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void setCallback(TextureRegistry.SurfaceProducer.a aVar) {
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void setSize(int i7, int i8) {
            int iMax = Math.max(1, i7);
            int iMax2 = Math.max(1, i8);
            if (this.requestedWidth == iMax && this.requestedHeight == iMax2) {
                return;
            }
            this.createNewReader = true;
            this.requestedHeight = iMax2;
            this.requestedWidth = iMax;
        }
    }

    @Keep
    public final class ImageTextureRegistryEntry implements TextureRegistry.ImageTextureEntry, TextureRegistry.ImageConsumer {
        private static final String TAG = "ImageTextureRegistryEntry";
        private final long id;
        private boolean ignoringFence = false;
        private Image image;
        private boolean released;

        public ImageTextureRegistryEntry(long j7) {
            this.id = j7;
        }

        private void maybeWaitOnFence(Image image) {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else {
                this.ignoringFence = true;
                J4.b.a(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
            }
        }

        private void waitOnFence(Image image) {
            try {
                image.getFence().awaitForever();
            } catch (IOException unused) {
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            Image image;
            synchronized (this) {
                image = this.image;
                this.image = null;
            }
            maybeWaitOnFence(image);
            return image;
        }

        public void finalize() throws Throwable {
            try {
                if (this.released) {
                    super.finalize();
                    return;
                }
                Image image = this.image;
                if (image != null) {
                    image.close();
                    this.image = null;
                }
                this.released = true;
                FlutterRenderer.this.f16552e.post(new f(this.id, FlutterRenderer.this.f16548a));
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
                throw th;
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public long id() {
            return this.id;
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public void pushImage(Image image) {
            Image image2;
            if (this.released) {
                return;
            }
            synchronized (this) {
                image2 = this.image;
                this.image = image;
            }
            if (image2 != null) {
                J4.b.b(TAG, "Dropping PlatformView Frame");
                image2.close();
            }
            if (image != null) {
                FlutterRenderer.this.w();
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            this.released = true;
            Image image = this.image;
            if (image != null) {
                image.close();
                this.image = null;
            }
            FlutterRenderer.this.E(this.id);
        }
    }

    public class a implements m {
        public a() {
        }

        @Override // io.flutter.embedding.engine.renderer.m
        public void c() {
            FlutterRenderer.this.f16551d = false;
        }

        @Override // io.flutter.embedding.engine.renderer.m
        public void e() {
            FlutterRenderer.this.f16551d = true;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f16564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f16565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f16566c;

        public b(Rect rect, d dVar, c cVar) {
            this.f16564a = rect;
            this.f16565b = dVar;
            this.f16566c = cVar;
        }
    }

    public enum c {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16571a;

        c(int i7) {
            this.f16571a = i7;
        }
    }

    public enum d {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16577a;

        d(int i7) {
            this.f16577a = i7;
        }
    }

    public final class e implements TextureRegistry.SurfaceTextureEntry, TextureRegistry.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f16578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SurfaceTextureWrapper f16579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f16580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TextureRegistry.b f16581d;

        public e(long j7, SurfaceTexture surfaceTexture) {
            this.f16578a = j7;
            this.f16579b = new SurfaceTextureWrapper(surfaceTexture, new Runnable() { // from class: io.flutter.embedding.engine.renderer.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16605a.c();
                }
            });
            surfaceTexture().setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.embedding.engine.renderer.l
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    this.f16606a.d(surfaceTexture2);
                }
            }, new Handler());
        }

        public final /* synthetic */ void c() {
        }

        public final /* synthetic */ void d(SurfaceTexture surfaceTexture) {
            if (this.f16580c || !FlutterRenderer.this.f16548a.isAttached()) {
                return;
            }
            this.f16579b.markDirty();
            FlutterRenderer.this.w();
        }

        public final void e() {
            FlutterRenderer.this.u(this);
        }

        public SurfaceTextureWrapper f() {
            return this.f16579b;
        }

        public void finalize() throws Throwable {
            try {
                if (this.f16580c) {
                    return;
                }
                FlutterRenderer.this.f16552e.post(new f(this.f16578a, FlutterRenderer.this.f16548a));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public long id() {
            return this.f16578a;
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i7) {
            TextureRegistry.b bVar = this.f16581d;
            if (bVar != null) {
                bVar.onTrimMemory(i7);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void release() {
            if (this.f16580c) {
                return;
            }
            J4.b.f("FlutterRenderer", "Releasing a SurfaceTexture (" + this.f16578a + ").");
            this.f16579b.release();
            FlutterRenderer.this.E(this.f16578a);
            e();
            this.f16580c = true;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnFrameConsumedListener(TextureRegistry.a aVar) {
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnTrimMemoryListener(TextureRegistry.b bVar) {
            this.f16581d = bVar;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public SurfaceTexture surfaceTexture() {
            return this.f16579b.surfaceTexture();
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f16583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FlutterJNI f16584b;

        public f(long j7, FlutterJNI flutterJNI) {
            this.f16583a = j7;
            this.f16584b = flutterJNI;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f16584b.isAttached()) {
                J4.b.f("FlutterRenderer", "Releasing a Texture (" + this.f16583a + ").");
                this.f16584b.unregisterTexture(this.f16583a);
            }
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f16585a = 1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16586b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f16587c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16588d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f16589e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f16590f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f16591g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f16592h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f16593i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f16594j = 0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f16595k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f16596l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f16597m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f16598n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f16599o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f16600p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final List f16601q = new ArrayList();

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final List f16602r = new ArrayList();

        public void c(List list) {
            this.f16602r.clear();
            this.f16602r.addAll(list);
        }

        public void d(List list) {
            this.f16601q.clear();
            this.f16601q.addAll(list);
        }

        public boolean e() {
            return this.f16586b > 0 && this.f16587c > 0 && this.f16585a > 0.0f;
        }
    }

    public FlutterRenderer(FlutterJNI flutterJNI) {
        a aVar = new a();
        this.f16555h = aVar;
        this.f16548a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(aVar);
    }

    public void A() {
        if (this.f16550c != null) {
            this.f16548a.onSurfaceDestroyed();
            if (this.f16551d) {
                this.f16555h.c();
            }
            this.f16551d = false;
            this.f16550c = null;
        }
    }

    public void B(int i7, int i8) {
        this.f16548a.onSurfaceChanged(i7, i8);
    }

    public void C(Surface surface) {
        this.f16550c = surface;
        this.f16548a.onSurfaceWindowChanged(surface);
    }

    public final void D(int[] iArr, int i7, Rect rect) {
        iArr[i7] = rect.left;
        iArr[i7 + 1] = rect.top;
        iArr[i7 + 2] = rect.right;
        iArr[i7 + 3] = rect.bottom;
    }

    public final void E(long j7) {
        this.f16548a.unregisterTexture(j7);
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceProducer a(TextureRegistry.c cVar) {
        if (f16546i || Build.VERSION.SDK_INT < 29) {
            TextureRegistry.SurfaceTextureEntry surfaceTextureEntryC = c();
            o oVar = new o(surfaceTextureEntryC.id(), this.f16552e, this.f16548a, surfaceTextureEntryC);
            J4.b.f("FlutterRenderer", "New SurfaceTextureSurfaceProducer ID: " + surfaceTextureEntryC.id());
            return oVar;
        }
        long andIncrement = this.f16549b.getAndIncrement();
        ImageReaderSurfaceProducer imageReaderSurfaceProducer = new ImageReaderSurfaceProducer(andIncrement);
        boolean z7 = cVar == TextureRegistry.c.resetInBackground;
        p(andIncrement, imageReaderSurfaceProducer, z7);
        if (z7) {
            j(imageReaderSurfaceProducer);
        }
        this.f16554g.add(imageReaderSurfaceProducer);
        J4.b.f("FlutterRenderer", "New ImageReaderSurfaceProducer ID: " + andIncrement);
        return imageReaderSurfaceProducer;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.ImageTextureEntry b() {
        ImageTextureRegistryEntry imageTextureRegistryEntry = new ImageTextureRegistryEntry(this.f16549b.getAndIncrement());
        J4.b.f("FlutterRenderer", "New ImageTextureEntry ID: " + imageTextureRegistryEntry.id());
        p(imageTextureRegistryEntry.id(), imageTextureRegistryEntry, false);
        return imageTextureRegistryEntry;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry c() {
        J4.b.f("FlutterRenderer", "Creating a SurfaceTexture.");
        return r(new SurfaceTexture(0));
    }

    public void i(m mVar) {
        this.f16548a.addIsDisplayingFlutterUiListener(mVar);
        if (this.f16551d) {
            mVar.e();
        }
    }

    public void j(TextureRegistry.b bVar) {
        k();
        this.f16553f.add(new WeakReference(bVar));
    }

    public final void k() {
        Iterator it = this.f16553f.iterator();
        while (it.hasNext()) {
            if (((TextureRegistry.b) ((WeakReference) it.next()).get()) == null) {
                it.remove();
            }
        }
    }

    public void l(ByteBuffer byteBuffer, int i7) {
        this.f16548a.dispatchPointerDataPacket(byteBuffer, i7);
    }

    public boolean m() {
        return this.f16551d;
    }

    public boolean n() {
        return this.f16548a.getIsSoftwareRenderingEnabled();
    }

    public void o(int i7) {
        Iterator it = this.f16553f.iterator();
        while (it.hasNext()) {
            TextureRegistry.b bVar = (TextureRegistry.b) ((WeakReference) it.next()).get();
            if (bVar != null) {
                bVar.onTrimMemory(i7);
            } else {
                it.remove();
            }
        }
    }

    public final void p(long j7, TextureRegistry.ImageConsumer imageConsumer, boolean z7) {
        this.f16548a.registerImageTexture(j7, imageConsumer, z7);
    }

    public final TextureRegistry.SurfaceTextureEntry q(long j7, SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        e eVar = new e(j7, surfaceTexture);
        J4.b.f("FlutterRenderer", "New SurfaceTexture ID: " + eVar.id());
        s(eVar.id(), eVar.f());
        j(eVar);
        return eVar;
    }

    public TextureRegistry.SurfaceTextureEntry r(SurfaceTexture surfaceTexture) {
        return q(this.f16549b.getAndIncrement(), surfaceTexture);
    }

    public final void s(long j7, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f16548a.registerTexture(j7, surfaceTextureWrapper);
    }

    public void t(m mVar) {
        this.f16548a.removeIsDisplayingFlutterUiListener(mVar);
    }

    public void u(TextureRegistry.b bVar) {
        for (WeakReference weakReference : this.f16553f) {
            if (weakReference.get() == bVar) {
                this.f16553f.remove(weakReference);
                return;
            }
        }
    }

    public void v() {
        J4.b.f("FlutterRenderer", "restoreSurfaceProducers called; notifying SurfaceProducers");
        Iterator it = this.f16554g.iterator();
        while (it.hasNext()) {
            ((ImageReaderSurfaceProducer) it.next()).getClass();
        }
    }

    public void w() {
        this.f16548a.scheduleFrame();
    }

    public void x(boolean z7) {
        this.f16548a.setSemanticsEnabled(z7);
    }

    public void y(g gVar) {
        if (gVar.e()) {
            J4.b.f("FlutterRenderer", "Setting viewport metrics\nSize: " + gVar.f16586b + " x " + gVar.f16587c + "\nPadding - L: " + gVar.f16591g + ", T: " + gVar.f16588d + ", R: " + gVar.f16589e + ", B: " + gVar.f16590f + "\nInsets - L: " + gVar.f16595k + ", T: " + gVar.f16592h + ", R: " + gVar.f16593i + ", B: " + gVar.f16594j + "\nSystem Gesture Insets - L: " + gVar.f16599o + ", T: " + gVar.f16596l + ", R: " + gVar.f16597m + ", B: " + gVar.f16597m + "\nDisplay Features: " + gVar.f16601q.size() + "\nDisplay Cutouts: " + gVar.f16602r.size());
            int size = gVar.f16601q.size() + gVar.f16602r.size();
            int[] iArr = new int[size * 4];
            int[] iArr2 = new int[size];
            int[] iArr3 = new int[size];
            for (int i7 = 0; i7 < gVar.f16601q.size(); i7++) {
                b bVar = (b) gVar.f16601q.get(i7);
                D(iArr, i7 * 4, bVar.f16564a);
                iArr2[i7] = bVar.f16565b.f16577a;
                iArr3[i7] = bVar.f16566c.f16571a;
            }
            int size2 = gVar.f16601q.size() * 4;
            for (int i8 = 0; i8 < gVar.f16602r.size(); i8++) {
                b bVar2 = (b) gVar.f16602r.get(i8);
                D(iArr, (i8 * 4) + size2, bVar2.f16564a);
                iArr2[gVar.f16601q.size() + i8] = bVar2.f16565b.f16577a;
                iArr3[gVar.f16601q.size() + i8] = bVar2.f16566c.f16571a;
            }
            this.f16548a.setViewportMetrics(gVar.f16585a, gVar.f16586b, gVar.f16587c, gVar.f16588d, gVar.f16589e, gVar.f16590f, gVar.f16591g, gVar.f16592h, gVar.f16593i, gVar.f16594j, gVar.f16595k, gVar.f16596l, gVar.f16597m, gVar.f16598n, gVar.f16599o, gVar.f16600p, iArr, iArr2, iArr3);
        }
    }

    public void z(Surface surface, boolean z7) {
        if (!z7) {
            A();
        }
        this.f16550c = surface;
        if (z7) {
            this.f16548a.onSurfaceWindowChanged(surface);
        } else {
            this.f16548a.onSurfaceCreated(surface);
        }
    }
}

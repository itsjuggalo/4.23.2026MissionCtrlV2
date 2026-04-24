package io.flutter.embedding.engine.renderer;

import N1.RunnableC0140w;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.Keep;
import io.flutter.view.TextureRegistry$ImageConsumer;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import io.flutter.view.o;
import io.flutter.view.p;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@Keep
final class FlutterRenderer$ImageReaderSurfaceProducer implements TextureRegistry$SurfaceProducer, TextureRegistry$ImageConsumer, o {
    private static final boolean CLEANUP_ON_MEMORY_PRESSURE = true;
    private static final int MAX_DEQUEUED_IMAGES = 2;
    private static final int MAX_IMAGES = 6;
    private static final String TAG = "ImageReaderSurfaceProducer";
    private static final boolean VERBOSE_LOGS = false;
    private static final boolean trimOnMemoryPressure = true;
    private p callback;
    private final long id;
    private boolean released;
    final /* synthetic */ k this$0;
    private boolean ignoringFence = VERBOSE_LOGS;
    private int requestedWidth = 1;
    private int requestedHeight = 1;
    private boolean createNewReader = true;
    private boolean notifiedDestroy = VERBOSE_LOGS;
    private long lastDequeueTime = 0;
    private long lastQueueTime = 0;
    private long lastScheduleTime = 0;
    private int numTrims = 0;
    private final Object lock = new Object();
    private final ArrayDeque<g> imageReaderQueue = new ArrayDeque<>();
    private final HashMap<ImageReader, g> perImageReaders = new HashMap<>();
    private ArrayList<e> lastDequeuedImage = new ArrayList<>();
    private g lastReaderDequeuedFrom = null;

    public FlutterRenderer$ImageReaderSurfaceProducer(k kVar, long j4) {
        this.this$0 = kVar;
        this.id = j4;
    }

    public static /* synthetic */ p access$200(FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer) {
        flutterRenderer$ImageReaderSurfaceProducer.getClass();
        return null;
    }

    private void cleanup() {
        synchronized (this.lock) {
            try {
                for (g gVar : this.perImageReaders.values()) {
                    if (this.lastReaderDequeuedFrom == gVar) {
                        this.lastReaderDequeuedFrom = null;
                    }
                    gVar.f7047c = true;
                    gVar.f7045a.close();
                    gVar.f7046b.clear();
                }
                this.perImageReaders.clear();
                if (this.lastDequeuedImage.size() > 0) {
                    Iterator<e> it = this.lastDequeuedImage.iterator();
                    while (it.hasNext()) {
                        it.next().f7042a.close();
                    }
                    this.lastDequeuedImage.clear();
                }
                g gVar2 = this.lastReaderDequeuedFrom;
                if (gVar2 != null) {
                    gVar2.f7047c = true;
                    gVar2.f7045a.close();
                    gVar2.f7046b.clear();
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
        E.c.p();
        ImageReader.Builder builderH = E.c.h(this.requestedWidth, this.requestedHeight);
        builderH.setMaxImages(6);
        builderH.setImageFormat(34);
        builderH.setUsage(256L);
        return builderH.build();
    }

    private g getActiveReader() {
        synchronized (this.lock) {
            try {
                if (!this.createNewReader) {
                    g gVarPeekLast = this.imageReaderQueue.peekLast();
                    if (gVarPeekLast.f7045a.getSurface().isValid()) {
                        return gVarPeekLast;
                    }
                }
                this.createNewReader = VERBOSE_LOGS;
                return getOrCreatePerImageReader(createImageReader());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private g getOrCreatePerImageReader(ImageReader imageReader) {
        g gVar = this.perImageReaders.get(imageReader);
        if (gVar != null) {
            return gVar;
        }
        g gVarCreatePerImageReader = createPerImageReader(imageReader);
        this.perImageReaders.put(imageReader, gVarCreatePerImageReader);
        this.imageReaderQueue.add(gVarCreatePerImageReader);
        return gVarCreatePerImageReader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$dequeueImage$0() {
        if (this.released) {
            return;
        }
        this.this$0.f7070a.scheduleFrame();
    }

    private void maybeWaitOnFence(Image image) {
        if (image == null || this.ignoringFence) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            waitOnFence(image);
        } else {
            this.ignoringFence = true;
        }
    }

    private void releaseInternal() {
        cleanup();
        this.released = true;
        this.this$0.h(this);
        this.this$0.f7075g.remove(this);
    }

    private void waitOnFence(Image image) {
        try {
            image.getFence().awaitForever();
        } catch (IOException unused) {
        }
    }

    @Override // io.flutter.view.TextureRegistry$ImageConsumer
    public Image acquireLatestImage() {
        e eVarDequeueImage = dequeueImage();
        if (eVarDequeueImage == null) {
            return null;
        }
        Image image = eVarDequeueImage.f7042a;
        maybeWaitOnFence(image);
        return image;
    }

    public ImageReader createImageReader() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            return createImageReader33();
        }
        if (i >= 29) {
            return createImageReader29();
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    public g createPerImageReader(ImageReader imageReader) {
        return new g(this, imageReader);
    }

    public double deltaMillis(long j4) {
        return j4 / 1000000.0d;
    }

    public e dequeueImage() {
        e eVar;
        boolean z6;
        synchronized (this.lock) {
            try {
                Iterator<g> it = this.imageReaderQueue.iterator();
                eVar = null;
                while (true) {
                    boolean zHasNext = it.hasNext();
                    z6 = VERBOSE_LOGS;
                    if (!zHasNext) {
                        break;
                    }
                    g next = it.next();
                    ArrayDeque arrayDeque = next.f7046b;
                    e eVar2 = arrayDeque.isEmpty() ? null : (e) arrayDeque.removeFirst();
                    if (eVar2 == null) {
                        eVar = eVar2;
                    } else {
                        while (this.lastDequeuedImage.size() > 2) {
                            this.lastDequeuedImage.remove(0).f7042a.close();
                        }
                        this.lastDequeuedImage.add(eVar2);
                        this.lastReaderDequeuedFrom = next;
                        eVar = eVar2;
                    }
                }
                pruneImageReaderQueue();
                Iterator<g> it2 = this.imageReaderQueue.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().f7046b.isEmpty()) {
                        z6 = true;
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z6) {
            this.this$0.e.post(new d(this, 0));
        }
        return eVar;
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
            k kVar = this.this$0;
            kVar.e.post(new RunnableC0140w(this.id, kVar.f7070a));
        } finally {
            super.finalize();
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public Surface getForcedNewSurface() {
        this.createNewReader = true;
        return getSurface();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public int getHeight() {
        return this.requestedHeight;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public Surface getSurface() {
        return getActiveReader().f7045a.getSurface();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public int getWidth() {
        return this.requestedWidth;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public boolean handlesCropAndRotation() {
        return VERBOSE_LOGS;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
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
                Iterator<g> it = this.imageReaderQueue.iterator();
                size = 0;
                while (it.hasNext()) {
                    size += it.next().f7046b.size();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return size;
    }

    public int numTrims() {
        int i;
        synchronized (this.lock) {
            i = this.numTrims;
        }
        return i;
    }

    public void onImage(ImageReader imageReader, Image image) {
        e eVar;
        synchronized (this.lock) {
            g orCreatePerImageReader = getOrCreatePerImageReader(imageReader);
            if (orCreatePerImageReader.f7047c) {
                eVar = null;
            } else {
                FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer = orCreatePerImageReader.f7048d;
                System.nanoTime();
                e eVar2 = new e(flutterRenderer$ImageReaderSurfaceProducer, image);
                ArrayDeque arrayDeque = orCreatePerImageReader.f7046b;
                arrayDeque.add(eVar2);
                while (arrayDeque.size() > 2) {
                    ((e) arrayDeque.removeFirst()).f7042a.close();
                }
                eVar = eVar2;
            }
        }
        if (eVar == null) {
            return;
        }
        this.this$0.f7070a.scheduleFrame();
    }

    @Override // io.flutter.view.o
    public void onTrimMemory(int i) {
        if (i < 40) {
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
        g gVarPeekFirst;
        while (this.imageReaderQueue.size() > 1 && (gVarPeekFirst = this.imageReaderQueue.peekFirst()) != null) {
            ArrayDeque arrayDeque = gVarPeekFirst.f7046b;
            if (!arrayDeque.isEmpty() || gVarPeekFirst.f7048d.lastReaderDequeuedFrom == gVarPeekFirst) {
                return;
            }
            this.imageReaderQueue.removeFirst();
            HashMap<ImageReader, g> map = this.perImageReaders;
            ImageReader imageReader = gVarPeekFirst.f7045a;
            map.remove(imageReader);
            gVarPeekFirst.f7047c = true;
            imageReader.close();
            arrayDeque.clear();
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void release() {
        if (this.released) {
            return;
        }
        releaseInternal();
        k kVar = this.this$0;
        kVar.f7070a.unregisterTexture(this.id);
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void scheduleFrame() {
        this.this$0.f7070a.scheduleFrame();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void setCallback(p pVar) {
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void setSize(int i, int i6) {
        int iMax = Math.max(1, i);
        int iMax2 = Math.max(1, i6);
        if (this.requestedWidth == iMax && this.requestedHeight == iMax2) {
            return;
        }
        this.createNewReader = true;
        this.requestedHeight = iMax2;
        this.requestedWidth = iMax;
    }
}

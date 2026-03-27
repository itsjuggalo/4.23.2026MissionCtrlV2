package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.lifecycle.G;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry$ImageTextureEntry;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import io.flutter.view.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f7070a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f7072c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f7076h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f7071b = new AtomicLong(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7073d = false;
    public final Handler e = new Handler();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet f7074f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f7075g = new ArrayList();

    public k(FlutterJNI flutterJNI) {
        a aVar = new a(this);
        this.f7076h = aVar;
        this.f7070a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(aVar);
        G.f4628m.f4633f.a(new b(this));
    }

    public final void a(l lVar) {
        this.f7070a.addIsDisplayingFlutterUiListener(lVar);
        if (this.f7073d) {
            lVar.b();
        }
    }

    public final void b(o oVar) {
        HashSet hashSet = this.f7074f;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((o) ((WeakReference) it.next()).get()) == null) {
                it.remove();
            }
        }
        hashSet.add(new WeakReference(oVar));
    }

    public final TextureRegistry$ImageTextureEntry c() {
        FlutterRenderer$ImageTextureRegistryEntry flutterRenderer$ImageTextureRegistryEntry = new FlutterRenderer$ImageTextureRegistryEntry(this, this.f7071b.getAndIncrement());
        flutterRenderer$ImageTextureRegistryEntry.id();
        this.f7070a.registerImageTexture(flutterRenderer$ImageTextureRegistryEntry.id(), flutterRenderer$ImageTextureRegistryEntry, false);
        return flutterRenderer$ImageTextureRegistryEntry;
    }

    public final TextureRegistry$SurfaceProducer d(int i) {
        if (Build.VERSION.SDK_INT < 29) {
            i iVarE = e();
            return new n(iVarE.f7050a, this.e, this.f7070a, iVarE);
        }
        long andIncrement = this.f7071b.getAndIncrement();
        FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer = new FlutterRenderer$ImageReaderSurfaceProducer(this, andIncrement);
        boolean z6 = i == 2;
        this.f7070a.registerImageTexture(andIncrement, flutterRenderer$ImageReaderSurfaceProducer, z6);
        if (z6) {
            b(flutterRenderer$ImageReaderSurfaceProducer);
        }
        this.f7075g.add(flutterRenderer$ImageReaderSurfaceProducer);
        return flutterRenderer$ImageReaderSurfaceProducer;
    }

    public final i e() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        long andIncrement = this.f7071b.getAndIncrement();
        surfaceTexture.detachFromGLContext();
        i iVar = new i(this, andIncrement, surfaceTexture);
        this.f7070a.registerTexture(iVar.f7050a, iVar.f7051b);
        b(iVar);
        return iVar;
    }

    public final void f(int i) {
        Iterator it = this.f7074f.iterator();
        while (it.hasNext()) {
            o oVar = (o) ((WeakReference) it.next()).get();
            if (oVar != null) {
                oVar.onTrimMemory(i);
            } else {
                it.remove();
            }
        }
    }

    public final void g(l lVar) {
        this.f7070a.removeIsDisplayingFlutterUiListener(lVar);
    }

    public final void h(o oVar) {
        HashSet<WeakReference> hashSet = this.f7074f;
        for (WeakReference weakReference : hashSet) {
            if (weakReference.get() == oVar) {
                hashSet.remove(weakReference);
                return;
            }
        }
    }

    public final void i() {
        if (this.f7072c != null) {
            this.f7070a.onSurfaceDestroyed();
            if (this.f7073d) {
                this.f7076h.a();
            }
            this.f7073d = false;
            this.f7072c = null;
        }
    }
}

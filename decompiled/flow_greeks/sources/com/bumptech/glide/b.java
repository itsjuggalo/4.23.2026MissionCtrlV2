package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import v3.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile b f5173k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f5174l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i3.k f5175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j3.d f5176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k3.h f5177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f5178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j3.b f5179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f5180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v3.c f5181g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f5183i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f5182h = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f5184j = f.NORMAL;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        y3.f build();
    }

    public b(Context context, i3.k kVar, k3.h hVar, j3.d dVar, j3.b bVar, o oVar, v3.c cVar, int i10, a aVar, Map map, List list, List list2, w3.a aVar2, e eVar) {
        this.f5175a = kVar;
        this.f5176b = dVar;
        this.f5179e = bVar;
        this.f5177c = hVar;
        this.f5180f = oVar;
        this.f5181g = cVar;
        this.f5183i = aVar;
        this.f5178d = new d(context, bVar, i.d(this, list2, aVar2), new z3.b(), aVar, map, list, kVar, eVar, i10);
    }

    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (f5174l) {
            throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
        }
        f5174l = true;
        try {
            m(context, generatedAppGlideModule);
        } finally {
            f5174l = false;
        }
    }

    public static b c(Context context) {
        if (f5173k == null) {
            GeneratedAppGlideModule generatedAppGlideModuleD = d(context.getApplicationContext());
            synchronized (b.class) {
                try {
                    if (f5173k == null) {
                        a(context, generatedAppGlideModuleD);
                    }
                } finally {
                }
            }
        }
        return f5173k;
    }

    public static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (!Log.isLoggable("Glide", 5)) {
                return null;
            }
            Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (IllegalAccessException e10) {
            q(e10);
            return null;
        } catch (InstantiationException e11) {
            q(e11);
            return null;
        } catch (NoSuchMethodException e12) {
            q(e12);
            return null;
        } catch (InvocationTargetException e13) {
            q(e13);
            return null;
        }
    }

    public static o l(Context context) {
        c4.k.f(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    public static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new c(), generatedAppGlideModule);
    }

    public static void n(Context context, c cVar, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List listB = Collections.EMPTY_LIST;
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listB = new w3.d(applicationContext).b();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            generatedAppGlideModule.d();
            Iterator it = listB.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                throw null;
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = listB.iterator();
            if (it2.hasNext()) {
                android.support.v4.media.session.b.a(it2.next());
                new StringBuilder().append("Discovered GlideModule from manifest: ");
                throw null;
            }
        }
        cVar.b(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        Iterator it3 = listB.iterator();
        if (it3.hasNext()) {
            android.support.v4.media.session.b.a(it3.next());
            throw null;
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, cVar);
        }
        b bVarA = cVar.a(applicationContext, listB, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(bVarA);
        f5173k = bVarA;
    }

    public static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static k t(Context context) {
        return l(context).d(context);
    }

    public void b() {
        c4.l.a();
        this.f5177c.b();
        this.f5176b.b();
        this.f5179e.b();
    }

    public j3.b e() {
        return this.f5179e;
    }

    public j3.d f() {
        return this.f5176b;
    }

    public v3.c g() {
        return this.f5181g;
    }

    public Context h() {
        return this.f5178d.getBaseContext();
    }

    public d i() {
        return this.f5178d;
    }

    public h j() {
        return this.f5178d.h();
    }

    public o k() {
        return this.f5180f;
    }

    public void o(k kVar) {
        synchronized (this.f5182h) {
            try {
                if (this.f5182h.contains(kVar)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.f5182h.add(kVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        r(i10);
    }

    public boolean p(z3.d dVar) {
        synchronized (this.f5182h) {
            try {
                Iterator it = this.f5182h.iterator();
                while (it.hasNext()) {
                    if (((k) it.next()).A(dVar)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r(int i10) {
        c4.l.a();
        synchronized (this.f5182h) {
            try {
                Iterator it = this.f5182h.iterator();
                while (it.hasNext()) {
                    ((k) it.next()).onTrimMemory(i10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f5177c.a(i10);
        this.f5176b.a(i10);
        this.f5179e.a(i10);
    }

    public void s(k kVar) {
        synchronized (this.f5182h) {
            try {
                if (!this.f5182h.contains(kVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.f5182h.remove(kVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}

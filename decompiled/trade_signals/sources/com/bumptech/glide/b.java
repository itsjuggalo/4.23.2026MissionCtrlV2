package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import j1.InterfaceC2200c;
import j1.o;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k1.AbstractC2265a;
import q1.AbstractC2628k;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public class b implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile b f14710k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f14711l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W0.k f14712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X0.d f14713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Y0.h f14714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f14715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final X0.b f14716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f14717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC2200c f14718g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f14720i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f14719h = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f14721j = f.NORMAL;

    public interface a {
        m1.f a();
    }

    public b(Context context, W0.k kVar, Y0.h hVar, X0.d dVar, X0.b bVar, o oVar, InterfaceC2200c interfaceC2200c, int i8, a aVar, Map map, List list, List list2, AbstractC2265a abstractC2265a, e eVar) {
        this.f14712a = kVar;
        this.f14713b = dVar;
        this.f14716e = bVar;
        this.f14714c = hVar;
        this.f14717f = oVar;
        this.f14718g = interfaceC2200c;
        this.f14720i = aVar;
        this.f14715d = new d(context, bVar, i.d(this, list2, abstractC2265a), new n1.b(), aVar, map, list, kVar, eVar, i8);
    }

    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (f14711l) {
            throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
        }
        f14711l = true;
        try {
            m(context, generatedAppGlideModule);
        } finally {
            f14711l = false;
        }
    }

    public static b c(Context context) {
        if (f14710k == null) {
            GeneratedAppGlideModule generatedAppGlideModuleD = d(context.getApplicationContext());
            synchronized (b.class) {
                try {
                    if (f14710k == null) {
                        a(context, generatedAppGlideModuleD);
                    }
                } finally {
                }
            }
        }
        return f14710k;
    }

    public static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e8) {
            e = e8;
            q(e);
            return null;
        } catch (InstantiationException e9) {
            e = e9;
            q(e);
            return null;
        } catch (NoSuchMethodException e10) {
            e = e10;
            q(e);
            return null;
        } catch (InvocationTargetException e11) {
            e = e11;
            q(e);
            return null;
        }
    }

    public static o l(Context context) {
        AbstractC2628k.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    public static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new c(), generatedAppGlideModule);
    }

    public static void n(Context context, c cVar, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listEmptyList = new k1.d(applicationContext).b();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            generatedAppGlideModule.d();
            Iterator it = listEmptyList.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.b.a(it.next());
                throw null;
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = listEmptyList.iterator();
            if (it2.hasNext()) {
                android.support.v4.media.session.b.a(it2.next());
                new StringBuilder().append("Discovered GlideModule from manifest: ");
                throw null;
            }
        }
        cVar.b(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        Iterator it3 = listEmptyList.iterator();
        if (it3.hasNext()) {
            android.support.v4.media.session.b.a(it3.next());
            throw null;
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, cVar);
        }
        b bVarA = cVar.a(applicationContext, listEmptyList, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(bVarA);
        f14710k = bVarA;
    }

    public static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static k t(Context context) {
        return l(context).d(context);
    }

    public void b() {
        AbstractC2629l.a();
        this.f14714c.b();
        this.f14713b.b();
        this.f14716e.b();
    }

    public X0.b e() {
        return this.f14716e;
    }

    public X0.d f() {
        return this.f14713b;
    }

    public InterfaceC2200c g() {
        return this.f14718g;
    }

    public Context h() {
        return this.f14715d.getBaseContext();
    }

    public d i() {
        return this.f14715d;
    }

    public h j() {
        return this.f14715d.h();
    }

    public o k() {
        return this.f14717f;
    }

    public void o(k kVar) {
        synchronized (this.f14719h) {
            try {
                if (this.f14719h.contains(kVar)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.f14719h.add(kVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i8) {
        r(i8);
    }

    public boolean p(n1.d dVar) {
        synchronized (this.f14719h) {
            try {
                Iterator it = this.f14719h.iterator();
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

    public void r(int i8) {
        AbstractC2629l.a();
        synchronized (this.f14719h) {
            try {
                Iterator it = this.f14719h.iterator();
                while (it.hasNext()) {
                    ((k) it.next()).onTrimMemory(i8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f14714c.a(i8);
        this.f14713b.a(i8);
        this.f14716e.a(i8);
    }

    public void s(k kVar) {
        synchronized (this.f14719h) {
            try {
                if (!this.f14719h.contains(kVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.f14719h.remove(kVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

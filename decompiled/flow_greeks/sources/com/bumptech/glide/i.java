package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import c4.f;
import com.bumptech.glide.c;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import m3.a;
import m3.b;
import m3.d;
import m3.e;
import m3.g;
import m3.l;
import m3.o;
import m3.s;
import m3.t;
import m3.u;
import m3.v;
import m3.w;
import m3.x;
import m3.y;
import n3.a;
import n3.b;
import n3.c;
import n3.d;
import n3.e;
import p3.a0;
import p3.c0;
import p3.d0;
import p3.f0;
import p3.i0;
import p3.p;
import p3.s;
import p3.y;
import q3.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f5237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f5238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ w3.a f5239d;

        public a(b bVar, List list, w3.a aVar) {
            this.f5237b = bVar;
            this.f5238c = list;
            this.f5239d = aVar;
        }

        @Override // c4.f.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h get() {
            if (this.f5236a) {
                throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
            }
            m2.a.c("Glide registry");
            this.f5236a = true;
            try {
                return i.a(this.f5237b, this.f5238c, this.f5239d);
            } finally {
                this.f5236a = false;
                m2.a.f();
            }
        }
    }

    public static h a(b bVar, List list, w3.a aVar) {
        j3.d dVarF = bVar.f();
        j3.b bVarE = bVar.e();
        Context applicationContext = bVar.i().getApplicationContext();
        e eVarF = bVar.i().f();
        h hVar = new h();
        b(applicationContext, hVar, dVarF, bVarE, eVarF);
        c(applicationContext, bVar, hVar, list, aVar);
        return hVar;
    }

    public static void b(Context context, h hVar, j3.d dVar, j3.b bVar, e eVar) {
        g3.j gVar;
        g3.j d0Var;
        String str;
        h hVar2;
        hVar.o(new p3.i());
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 27) {
            hVar.o(new s());
        }
        Resources resources = context.getResources();
        List listG = hVar.g();
        t3.a aVar = new t3.a(context, listG, dVar, bVar);
        g3.j jVarM = i0.m(dVar);
        p pVar = new p(hVar.g(), resources.getDisplayMetrics(), dVar, bVar);
        if (i10 < 28 || !eVar.a(c.b.class)) {
            gVar = new p3.g(pVar);
            d0Var = new d0(pVar, bVar);
        } else {
            d0Var = new y();
            gVar = new p3.h();
        }
        if (i10 >= 28) {
            hVar.e("Animation", InputStream.class, Drawable.class, r3.c.f(listG, bVar));
            hVar.e("Animation", ByteBuffer.class, Drawable.class, r3.c.a(listG, bVar));
        }
        r3.g gVar2 = new r3.g(context);
        p3.c cVar = new p3.c(bVar);
        u3.a aVar2 = new u3.a();
        u3.d dVar2 = new u3.d();
        ContentResolver contentResolver = context.getContentResolver();
        hVar.a(ByteBuffer.class, new m3.c()).a(InputStream.class, new u(bVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, gVar).e("Bitmap", InputStream.class, Bitmap.class, d0Var);
        if (ParcelFileDescriptorRewinder.c()) {
            str = "Animation";
            hVar.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new a0(pVar));
        } else {
            str = "Animation";
        }
        hVar.e("Bitmap", AssetFileDescriptor.class, Bitmap.class, i0.c(dVar));
        String str2 = str;
        hVar.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, jVarM).d(Bitmap.class, Bitmap.class, w.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new f0()).b(Bitmap.class, cVar).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new p3.a(resources, gVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new p3.a(resources, d0Var)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new p3.a(resources, jVarM)).b(BitmapDrawable.class, new p3.b(dVar, cVar)).e(str2, InputStream.class, t3.c.class, new t3.j(listG, aVar, bVar)).e(str2, ByteBuffer.class, t3.c.class, aVar).b(t3.c.class, new t3.d()).d(f3.a.class, f3.a.class, w.a.a()).e("Bitmap", f3.a.class, Bitmap.class, new t3.h(dVar)).c(Uri.class, Drawable.class, gVar2).c(Uri.class, Bitmap.class, new c0(gVar2, dVar)).p(new a.C0321a()).d(File.class, ByteBuffer.class, new d.b()).d(File.class, InputStream.class, new g.e()).c(File.class, File.class, new s3.a()).d(File.class, ParcelFileDescriptor.class, new g.b()).d(File.class, File.class, w.a.a()).p(new k.a(bVar));
        if (ParcelFileDescriptorRewinder.c()) {
            hVar2 = hVar;
            hVar2.p(new ParcelFileDescriptorRewinder.a());
        } else {
            hVar2 = hVar;
        }
        o oVarG = m3.f.g(context);
        o oVarC = m3.f.c(context);
        o oVarE = m3.f.e(context);
        Class cls = Integer.TYPE;
        hVar2.d(cls, InputStream.class, oVarG).d(Integer.class, InputStream.class, oVarG).d(cls, AssetFileDescriptor.class, oVarC).d(Integer.class, AssetFileDescriptor.class, oVarC).d(cls, Drawable.class, oVarE).d(Integer.class, Drawable.class, oVarE).d(Uri.class, InputStream.class, t.f(context)).d(Uri.class, AssetFileDescriptor.class, t.e(context));
        s.c cVar2 = new s.c(resources);
        s.a aVar3 = new s.a(resources);
        s.b bVar2 = new s.b(resources);
        hVar2.d(Integer.class, Uri.class, cVar2).d(cls, Uri.class, cVar2).d(Integer.class, AssetFileDescriptor.class, aVar3).d(cls, AssetFileDescriptor.class, aVar3).d(Integer.class, InputStream.class, bVar2).d(cls, InputStream.class, bVar2);
        hVar2.d(String.class, InputStream.class, new e.c()).d(Uri.class, InputStream.class, new e.c()).d(String.class, InputStream.class, new v.c()).d(String.class, ParcelFileDescriptor.class, new v.b()).d(String.class, AssetFileDescriptor.class, new v.a()).d(Uri.class, InputStream.class, new a.c(context.getAssets())).d(Uri.class, AssetFileDescriptor.class, new a.b(context.getAssets())).d(Uri.class, InputStream.class, new b.a(context)).d(Uri.class, InputStream.class, new c.a(context));
        if (i10 >= 29) {
            hVar2.d(Uri.class, InputStream.class, new d.c(context));
            hVar2.d(Uri.class, ParcelFileDescriptor.class, new d.b(context));
        }
        boolean zA = eVar.a(c.e.class);
        hVar2.d(Uri.class, InputStream.class, new x.d(contentResolver, zA)).d(Uri.class, ParcelFileDescriptor.class, new x.b(contentResolver, zA)).d(Uri.class, AssetFileDescriptor.class, new x.a(contentResolver, zA)).d(Uri.class, InputStream.class, new y.a()).d(URL.class, InputStream.class, new e.a()).d(Uri.class, File.class, new l.a(context)).d(m3.h.class, InputStream.class, new a.C0297a()).d(byte[].class, ByteBuffer.class, new b.a()).d(byte[].class, InputStream.class, new b.d()).d(Uri.class, Uri.class, w.a.a()).d(Drawable.class, Drawable.class, w.a.a()).c(Drawable.class, Drawable.class, new r3.h()).q(Bitmap.class, BitmapDrawable.class, new u3.b(resources)).q(Bitmap.class, byte[].class, aVar2).q(Drawable.class, byte[].class, new u3.c(dVar, aVar2, dVar2)).q(t3.c.class, byte[].class, dVar2);
        g3.j jVarD = i0.d(dVar);
        hVar2.c(ByteBuffer.class, Bitmap.class, jVarD);
        hVar2.c(ByteBuffer.class, BitmapDrawable.class, new p3.a(resources, jVarD));
    }

    public static void c(Context context, b bVar, h hVar, List list, w3.a aVar) {
        Iterator it = list.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
        if (aVar != null) {
            aVar.a(context, bVar, hVar);
        }
    }

    public static f.b d(b bVar, List list, w3.a aVar) {
        return new a(bVar, list, aVar);
    }
}

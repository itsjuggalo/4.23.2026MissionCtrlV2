package H3;

import a1.C1048h;
import a1.C1051k;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import n1.AbstractC2387a;
import o1.InterfaceC2456b;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.k f3672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3673b = new HashMap();

    public static abstract class a extends AbstractC2387a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView f3674d;

        @Override // n1.AbstractC2387a, n1.d
        public void e(Drawable drawable) {
            l.a("Downloading Image Failed");
            o(drawable);
            l(new Exception("Image loading failed!"));
        }

        @Override // n1.d
        public void j(Drawable drawable) {
            l.a("Downloading Image Cleared");
            o(drawable);
            n();
        }

        public abstract void l(Exception exc);

        @Override // n1.d
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void d(Drawable drawable, InterfaceC2456b interfaceC2456b) {
            l.a("Downloading Image Success!!!");
            o(drawable);
            n();
        }

        public abstract void n();

        public final void o(Drawable drawable) {
            ImageView imageView = this.f3674d;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }

        public void p(ImageView imageView) {
            this.f3674d = imageView;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.j f3675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f3676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3677c;

        public b(com.bumptech.glide.j jVar) {
            this.f3675a = jVar;
        }

        public b a(j jVar) {
            this.f3675a.Z(jVar);
            return this;
        }

        public final void b() {
            Set hashSet;
            if (this.f3676b == null || TextUtils.isEmpty(this.f3677c)) {
                return;
            }
            synchronized (e.this.f3673b) {
                try {
                    if (e.this.f3673b.containsKey(this.f3677c)) {
                        hashSet = (Set) e.this.f3673b.get(this.f3677c);
                    } else {
                        hashSet = new HashSet();
                        e.this.f3673b.put(this.f3677c, hashSet);
                    }
                    if (!hashSet.contains(this.f3676b)) {
                        hashSet.add(this.f3676b);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c(ImageView imageView, a aVar) {
            l.a("Downloading Image Callback : " + aVar);
            aVar.p(imageView);
            this.f3675a.h0(aVar);
            this.f3676b = aVar;
            b();
        }

        public b d(int i8) {
            this.f3675a.N(i8);
            l.a("Downloading Image Placeholder : " + i8);
            return this;
        }

        public b e(Class cls) {
            this.f3677c = cls.getSimpleName();
            b();
            return this;
        }
    }

    public e(com.bumptech.glide.k kVar) {
        this.f3672a = kVar;
    }

    public void b(Class cls) {
        String simpleName = cls.getSimpleName();
        synchronized (simpleName) {
            try {
                if (this.f3673b.containsKey(simpleName)) {
                    for (AbstractC2387a abstractC2387a : (Set) this.f3673b.get(simpleName)) {
                        if (abstractC2387a != null) {
                            this.f3672a.o(abstractC2387a);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public b c(String str) {
        l.a("Starting Downloading Image : " + str);
        return new b((com.bumptech.glide.j) this.f3672a.t(new C1048h(str, new C1051k.a().b("Accept", "image/*").c())).h(U0.b.PREFER_ARGB_8888));
    }
}

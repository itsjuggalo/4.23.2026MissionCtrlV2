package u9;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import m3.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.k f22438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f22439b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a extends z3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView f22440d;

        @Override // z3.a, z3.d
        public void g(Drawable drawable) {
            l.a("Downloading Image Failed");
            o(drawable);
            l(new Exception("Image loading failed!"));
        }

        @Override // z3.d
        public void k(Drawable drawable) {
            l.a("Downloading Image Cleared");
            o(drawable);
            n();
        }

        public abstract void l(Exception exc);

        @Override // z3.d
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(Drawable drawable, a4.b bVar) {
            l.a("Downloading Image Success!!!");
            o(drawable);
            n();
        }

        public abstract void n();

        public final void o(Drawable drawable) {
            ImageView imageView = this.f22440d;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }

        public void p(ImageView imageView) {
            this.f22440d = imageView;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.j f22441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f22442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22443c;

        public b(com.bumptech.glide.j jVar) {
            this.f22441a = jVar;
        }

        public b a(j jVar) {
            this.f22441a.Y(jVar);
            return this;
        }

        public final void b() {
            Set hashSet;
            if (this.f22442b == null || TextUtils.isEmpty(this.f22443c)) {
                return;
            }
            synchronized (e.this.f22439b) {
                try {
                    if (e.this.f22439b.containsKey(this.f22443c)) {
                        hashSet = (Set) e.this.f22439b.get(this.f22443c);
                    } else {
                        hashSet = new HashSet();
                        e.this.f22439b.put(this.f22443c, hashSet);
                    }
                    if (!hashSet.contains(this.f22442b)) {
                        hashSet.add(this.f22442b);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c(ImageView imageView, a aVar) {
            l.a("Downloading Image Callback : " + aVar);
            aVar.p(imageView);
            this.f22441a.g0(aVar);
            this.f22442b = aVar;
            b();
        }

        public b d(int i10) {
            this.f22441a.M(i10);
            l.a("Downloading Image Placeholder : " + i10);
            return this;
        }

        public b e(Class cls) {
            this.f22443c = cls.getSimpleName();
            b();
            return this;
        }
    }

    public e(com.bumptech.glide.k kVar) {
        this.f22438a = kVar;
    }

    public void b(Class cls) {
        String simpleName = cls.getSimpleName();
        synchronized (simpleName) {
            try {
                if (this.f22439b.containsKey(simpleName)) {
                    for (z3.a aVar : (Set) this.f22439b.get(simpleName)) {
                        if (aVar != null) {
                            this.f22438a.o(aVar);
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
        return new b((com.bumptech.glide.j) this.f22438a.t(new m3.h(str, new k.a().a("Accept", "image/*").c())).g(g3.b.PREFER_ARGB_8888));
    }
}

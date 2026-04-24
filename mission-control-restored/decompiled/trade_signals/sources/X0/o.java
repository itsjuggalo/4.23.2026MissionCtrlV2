package X0;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public class o implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f9351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f9352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Bitmap.Config[] f9353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f9354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Bitmap.Config[] f9355h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f9356a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f9357b = new g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f9358c = new HashMap();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9359a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f9359a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9359a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9359a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9359a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f9360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap.Config f9362c;

        public b(c cVar) {
            this.f9360a = cVar;
        }

        @Override // X0.m
        public void a() {
            this.f9360a.c(this);
        }

        public void b(int i8, Bitmap.Config config) {
            this.f9361b = i8;
            this.f9362c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f9361b == bVar.f9361b && AbstractC2629l.d(this.f9362c, bVar.f9362c);
        }

        public int hashCode() {
            int i8 = this.f9361b * 31;
            Bitmap.Config config = this.f9362c;
            return i8 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return o.h(this.f9361b, this.f9362c);
        }
    }

    public static class c extends X0.c {
        @Override // X0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b e(int i8, Bitmap.Config config) {
            b bVar = (b) b();
            bVar.b(i8, config);
            return bVar;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f9351d = configArr;
        f9352e = configArr;
        f9353f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f9354g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f9355h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String h(int i8, Bitmap.Config config) {
        return "[" + i8 + "](" + config + ")";
    }

    public static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f9352e;
        }
        int i8 = a.f9359a[config.ordinal()];
        return i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? new Bitmap.Config[]{config} : f9355h : f9354g : f9353f : f9351d;
    }

    @Override // X0.l
    public String a(int i8, int i9, Bitmap.Config config) {
        return h(AbstractC2629l.g(i8, i9, config), config);
    }

    @Override // X0.l
    public int b(Bitmap bitmap) {
        return AbstractC2629l.h(bitmap);
    }

    @Override // X0.l
    public void c(Bitmap bitmap) {
        b bVarE = this.f9356a.e(AbstractC2629l.h(bitmap), bitmap.getConfig());
        this.f9357b.d(bVarE, bitmap);
        NavigableMap navigableMapJ = j(bitmap.getConfig());
        Integer num = (Integer) navigableMapJ.get(Integer.valueOf(bVarE.f9361b));
        navigableMapJ.put(Integer.valueOf(bVarE.f9361b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // X0.l
    public Bitmap d(int i8, int i9, Bitmap.Config config) {
        b bVarG = g(AbstractC2629l.g(i8, i9, config), config);
        Bitmap bitmap = (Bitmap) this.f9357b.a(bVarG);
        if (bitmap != null) {
            f(Integer.valueOf(bVarG.f9361b), bitmap);
            bitmap.reconfigure(i8, i9, config);
        }
        return bitmap;
    }

    @Override // X0.l
    public String e(Bitmap bitmap) {
        return h(AbstractC2629l.h(bitmap), bitmap.getConfig());
    }

    public final void f(Integer num, Bitmap bitmap) {
        NavigableMap navigableMapJ = j(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapJ.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapJ.remove(num);
                return;
            } else {
                navigableMapJ.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
    }

    public final b g(int i8, Bitmap.Config config) {
        b bVarE = this.f9356a.e(i8, config);
        for (Bitmap.Config config2 : i(config)) {
            Integer num = (Integer) j(config2).ceilingKey(Integer.valueOf(i8));
            if (num != null && num.intValue() <= i8 * 8) {
                if (num.intValue() == i8) {
                    if (config2 == null) {
                        if (config == null) {
                            return bVarE;
                        }
                    } else if (config2.equals(config)) {
                        return bVarE;
                    }
                }
                this.f9356a.c(bVarE);
                return this.f9356a.e(num.intValue(), config2);
            }
        }
        return bVarE;
    }

    public final NavigableMap j(Bitmap.Config config) {
        NavigableMap navigableMap = (NavigableMap) this.f9358c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f9358c.put(config, treeMap);
        return treeMap;
    }

    @Override // X0.l
    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.f9357b.f();
        if (bitmap != null) {
            f(Integer.valueOf(AbstractC2629l.h(bitmap)), bitmap);
        }
        return bitmap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f9357b);
        sb.append(", sortedSizes=(");
        for (Map.Entry entry : this.f9358c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f9358c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}

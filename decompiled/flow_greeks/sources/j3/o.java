package j3;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f13864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f13865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Bitmap.Config[] f13866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f13867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Bitmap.Config[] f13868h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f13869a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f13870b = new g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f13871c = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13872a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f13872a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13872a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13872a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13872a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f13873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bitmap.Config f13875c;

        public b(c cVar) {
            this.f13873a = cVar;
        }

        @Override // j3.m
        public void a() {
            this.f13873a.c(this);
        }

        public void b(int i10, Bitmap.Config config) {
            this.f13874b = i10;
            this.f13875c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f13874b == bVar.f13874b && c4.l.d(this.f13875c, bVar.f13875c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i10 = this.f13874b * 31;
            Bitmap.Config config = this.f13875c;
            return i10 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return o.h(this.f13874b, this.f13875c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends j3.c {
        @Override // j3.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b e(int i10, Bitmap.Config config) {
            b bVar = (b) b();
            bVar.b(i10, config);
            return bVar;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f13864d = configArr;
        f13865e = configArr;
        f13866f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f13867g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f13868h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String h(int i10, Bitmap.Config config) {
        return "[" + i10 + "](" + config + ")";
    }

    public static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f13865e;
        }
        int i10 = a.f13872a[config.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new Bitmap.Config[]{config} : f13868h : f13867g : f13866f : f13864d;
    }

    @Override // j3.l
    public String a(int i10, int i11, Bitmap.Config config) {
        return h(c4.l.g(i10, i11, config), config);
    }

    @Override // j3.l
    public int b(Bitmap bitmap) {
        return c4.l.h(bitmap);
    }

    @Override // j3.l
    public void c(Bitmap bitmap) {
        b bVarE = this.f13869a.e(c4.l.h(bitmap), bitmap.getConfig());
        this.f13870b.d(bVarE, bitmap);
        NavigableMap navigableMapJ = j(bitmap.getConfig());
        Integer num = (Integer) navigableMapJ.get(Integer.valueOf(bVarE.f13874b));
        navigableMapJ.put(Integer.valueOf(bVarE.f13874b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // j3.l
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        b bVarG = g(c4.l.g(i10, i11, config), config);
        Bitmap bitmap = (Bitmap) this.f13870b.a(bVarG);
        if (bitmap != null) {
            f(Integer.valueOf(bVarG.f13874b), bitmap);
            bitmap.reconfigure(i10, i11, config);
        }
        return bitmap;
    }

    @Override // j3.l
    public String e(Bitmap bitmap) {
        return h(c4.l.h(bitmap), bitmap.getConfig());
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j3.o.b g(int r9, android.graphics.Bitmap.Config r10) {
        /*
            r8 = this;
            j3.o$c r0 = r8.f13869a
            j3.o$b r0 = r0.e(r9, r10)
            android.graphics.Bitmap$Config[] r1 = i(r10)
            int r2 = r1.length
            r3 = 0
        Lc:
            if (r3 >= r2) goto L4c
            r4 = r1[r3]
            java.util.NavigableMap r5 = r8.j(r4)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            java.lang.Object r5 = r5.ceilingKey(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L49
            int r6 = r5.intValue()
            int r7 = r9 * 8
            if (r6 > r7) goto L49
            int r1 = r5.intValue()
            if (r1 != r9) goto L39
            if (r4 != 0) goto L33
            if (r10 == 0) goto L4c
            goto L39
        L33:
            boolean r9 = r4.equals(r10)
            if (r9 != 0) goto L4c
        L39:
            j3.o$c r9 = r8.f13869a
            r9.c(r0)
            j3.o$c r9 = r8.f13869a
            int r10 = r5.intValue()
            j3.o$b r9 = r9.e(r10, r4)
            return r9
        L49:
            int r3 = r3 + 1
            goto Lc
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.o.g(int, android.graphics.Bitmap$Config):j3.o$b");
    }

    public final NavigableMap j(Bitmap.Config config) {
        NavigableMap navigableMap = (NavigableMap) this.f13871c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f13871c.put(config, treeMap);
        return treeMap;
    }

    @Override // j3.l
    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.f13870b.f();
        if (bitmap != null) {
            f(Integer.valueOf(c4.l.h(bitmap)), bitmap);
        }
        return bitmap;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SizeConfigStrategy{groupedMap=");
        sb2.append(this.f13870b);
        sb2.append(", sortedSizes=(");
        for (Map.Entry entry : this.f13871c.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append('[');
            sb2.append(entry.getValue());
            sb2.append("], ");
        }
        if (!this.f13871c.isEmpty()) {
            sb2.replace(sb2.length() - 2, sb2.length(), "");
        }
        sb2.append(")}");
        return sb2.toString();
    }
}

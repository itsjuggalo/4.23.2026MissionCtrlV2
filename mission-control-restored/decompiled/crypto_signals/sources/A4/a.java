package A4;

import A.o;
import D.C;
import E.l;
import E3.g;
import E3.j;
import K2.m0;
import N1.I1;
import P2.A;
import P3.AbstractActivityC0229d;
import T2.AbstractC0239c;
import V1.f;
import V1.n;
import a3.d;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.common.api.internal.AbstractC0408k;
import com.google.android.gms.internal.common.zzh;
import h.AbstractC0616a;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import m.C0831n;
import m.N;
import q.C0910b;
import r5.i;
import s3.AbstractC1024h;
import s3.I0;
import t2.u0;
import y4.EnumC1441k;

/* JADX INFO: loaded from: classes.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f64a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f65b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f66c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f67d;

    public /* synthetic */ a(char c6, int i) {
        this.f64a = i;
    }

    public static a i(String str) throws ProtocolException {
        int i;
        String strSubstring;
        boolean zStartsWith = str.startsWith("HTTP/1.");
        EnumC1441k enumC1441k = EnumC1441k.HTTP_1_0;
        if (zStartsWith) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                enumC1441k = EnumC1441k.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i = 4;
        }
        int i6 = i + 3;
        if (str.length() < i6) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int i7 = Integer.parseInt(str.substring(i, i6));
            if (str.length() <= i6) {
                strSubstring = "";
            } else {
                if (str.charAt(i6) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i + 4);
            }
            return new a(enumC1441k, i7, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    @Override // E3.j
    public void a() {
        HandlerThread handlerThread = (HandlerThread) this.f66c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f66c = null;
            this.f67d = null;
        }
    }

    @Override // E3.j
    public void b(g gVar) {
        ((Handler) this.f67d).post(gVar.f412b);
    }

    public void d() {
        A a6;
        ImageView imageView = (ImageView) this.f66c;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            N.a(drawable);
        }
        if (drawable == null || (a6 = (A) this.f67d) == null) {
            return;
        }
        C0831n.c(drawable, a6, imageView.getDrawableState());
    }

    public n e() {
        f fVar = (f) this.f67d;
        if (fVar != null) {
            throw fVar.a();
        }
        n nVarA = n.a(this.f65b, (Object[]) this.f66c, this);
        f fVar2 = (f) this.f67d;
        if (fVar2 == null) {
            return nVarA;
        }
        throw fVar2.a();
    }

    public int f() {
        if (Build.VERSION.SDK_INT < 35) {
            return 2;
        }
        AbstractActivityC0229d abstractActivityC0229d = (AbstractActivityC0229d) this.f66c;
        int i = this.f65b;
        View viewFindViewById = abstractActivityC0229d.findViewById(i);
        if (viewFindViewById != null) {
            return viewFindViewById.getContentSensitivity();
        }
        throw new IllegalArgumentException(d.i("FlutterView with ID ", i, "not found"));
    }

    public String g() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.f65b + 1;
        for (int i6 = 0; i6 < i; i6++) {
            Object obj = ((Object[]) this.f66c)[i6];
            if (obj instanceof n5.d) {
                n5.d dVar = (n5.d) obj;
                if (!kotlin.jvm.internal.j.a(dVar.c(), n5.f.f8609l)) {
                    int i7 = ((int[]) this.f67d)[i6];
                    if (i7 >= 0) {
                        sb.append(".");
                        sb.append(dVar.e(i7));
                    }
                } else if (((int[]) this.f67d)[i6] != -1) {
                    sb.append("[");
                    sb.append(((int[]) this.f67d)[i6]);
                    sb.append("]");
                }
            } else if (obj != i.f9489a) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.j.d(string, "toString(...)");
        return string;
    }

    public void h(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.f66c;
        Context context = imageView.getContext();
        int[] iArr = AbstractC0616a.e;
        f.d dVarQ = f.d.Q(context, attributeSet, iArr, i);
        C.c(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) dVarQ.f6382b, i);
        try {
            Drawable drawable = imageView.getDrawable();
            TypedArray typedArray = (TypedArray) dVarQ.f6382b;
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = D1.b.r(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                N.a(drawable);
            }
            if (typedArray.hasValue(2)) {
                I.d.c(imageView, dVarQ.F(2));
            }
            if (typedArray.hasValue(3)) {
                I.d.d(imageView, N.c(typedArray.getInt(3, -1), null));
            }
            dVarQ.S();
        } catch (Throwable th) {
            dVarQ.S();
            throw th;
        }
    }

    public void j(Object obj, Object obj2) {
        int i = (this.f65b + 1) * 2;
        Object[] objArr = (Object[]) this.f66c;
        if (i > objArr.length) {
            this.f66c = Arrays.copyOf(objArr, V1.b.c(objArr.length, i));
        }
        u0.f(obj, obj2);
        Object[] objArr2 = (Object[]) this.f66c;
        int i6 = this.f65b;
        int i7 = i6 * 2;
        objArr2[i7] = obj;
        objArr2[i7 + 1] = obj2;
        this.f65b = i6 + 1;
    }

    public void k(Collection collection) {
        if (collection != null) {
            int size = (collection.size() + this.f65b) * 2;
            Object[] objArr = (Object[]) this.f66c;
            if (size > objArr.length) {
                this.f66c = Arrays.copyOf(objArr, V1.b.c(objArr.length, size));
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            j(entry.getKey(), entry.getValue());
        }
    }

    public m0 l() {
        return new m0(this, Q2.j.f2678c, false);
    }

    public void m(int i) {
        if (Build.VERSION.SDK_INT < 35) {
            throw new IllegalStateException("isSupported() should be called before attempting to set content sensitivity as it is not supported on this device.");
        }
        AbstractActivityC0229d abstractActivityC0229d = (AbstractActivityC0229d) this.f66c;
        int i6 = this.f65b;
        View viewFindViewById = abstractActivityC0229d.findViewById(i6);
        if (viewFindViewById == null) {
            throw new IllegalArgumentException(d.i("FlutterView with ID ", i6, "not found"));
        }
        if (viewFindViewById.getContentSensitivity() == i) {
            return;
        }
        viewFindViewById.setContentSensitivity(i);
        viewFindViewById.invalidate();
    }

    public void n(String str, AbstractC0408k abstractC0408k) {
        Map map = (Map) this.f66c;
        if (map.containsKey(str)) {
            throw new IllegalArgumentException(AbstractC1024h.c("LifecycleCallback with tag ", str, " already added to this fragment."));
        }
        map.put(str, abstractC0408k);
        if (this.f65b > 0) {
            new zzh(Looper.getMainLooper()).post(new o(this, abstractC0408k, str, 12));
        }
    }

    public void o(Bundle bundle) {
        this.f65b = 1;
        this.f67d = bundle;
        for (Map.Entry entry : ((Map) this.f66c).entrySet()) {
            ((AbstractC0408k) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void p(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : ((Map) this.f66c).entrySet()) {
            Bundle bundle2 = new Bundle();
            ((AbstractC0408k) entry.getValue()).onSaveInstanceState(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // E3.j
    public void start() {
        HandlerThread handlerThread = new HandlerThread("Sqflite", this.f65b);
        this.f66c = handlerThread;
        handlerThread.start();
        this.f67d = new Handler(((HandlerThread) this.f66c).getLooper());
    }

    public String toString() {
        switch (this.f64a) {
            case 0:
                StringBuilder sb = new StringBuilder();
                sb.append((String) this.f66c);
                sb.append("://");
                int i = -1;
                if (((String) this.f67d).indexOf(58) != -1) {
                    sb.append('[');
                    sb.append((String) this.f67d);
                    sb.append(']');
                } else {
                    sb.append((String) this.f67d);
                }
                int i6 = this.f65b;
                if (i6 == -1) {
                    String str = (String) this.f66c;
                    i6 = str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
                }
                String str2 = (String) this.f66c;
                if (str2.equals("http")) {
                    i = 80;
                } else if (str2.equals("https")) {
                    i = 443;
                }
                if (i6 != i) {
                    sb.append(':');
                    sb.append(i6);
                }
                return sb.toString();
            case 8:
                return g();
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(((EnumC1441k) this.f67d) == EnumC1441k.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
                sb2.append(' ');
                sb2.append(this.f65b);
                String str3 = (String) this.f66c;
                if (str3 != null) {
                    sb2.append(' ');
                    sb2.append(str3);
                }
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public a() {
        this.f64a = 5;
        this.f66c = Collections.synchronizedMap(new C0910b());
        this.f65b = 0;
    }

    public a(EnumC1441k enumC1441k, int i, String str) {
        this.f64a = 9;
        this.f67d = enumC1441k;
        this.f65b = i;
        this.f66c = str;
    }

    public a(int i, AbstractActivityC0229d abstractActivityC0229d, l lVar) {
        this.f64a = 6;
        this.f66c = abstractActivityC0229d;
        this.f65b = i;
        this.f67d = lVar;
        lVar.f365b = this;
    }

    public a(ImageView imageView) {
        this.f64a = 7;
        this.f65b = 0;
        this.f66c = imageView;
    }

    public a(int i, int i6) {
        this.f64a = i6;
        switch (i6) {
            case 2:
                this.f65b = i;
                this.f66c = new HashSet();
                this.f67d = new ArrayList();
                break;
            case 3:
            default:
                this.f65b = i;
                break;
            case 4:
                this.f66c = new Object[i * 2];
                this.f65b = 0;
                break;
        }
    }

    public a(AbstractC0239c abstractC0239c, I1 i12) {
        this.f64a = 3;
        this.f67d = abstractC0239c;
        this.f65b = 0;
        this.f66c = i12;
    }
}

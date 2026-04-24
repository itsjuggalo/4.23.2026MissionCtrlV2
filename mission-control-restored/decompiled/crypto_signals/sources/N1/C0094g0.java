package N1;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import r2.C0969d;
import s1.C0994k;
import s2.C1002e;
import s3.AbstractC1024h;

/* JADX INFO: renamed from: N1.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0094g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1613d;
    public Object e;

    public C0094g0(C0097h0 c0097h0, String str) {
        this.f1610a = 0;
        Objects.requireNonNull(c0097h0);
        this.e = c0097h0;
        com.google.android.gms.common.internal.I.d(str);
        this.f1611b = str;
    }

    public void a(Object obj, String str) {
        C0994k c0994k = new C0994k(19);
        ((C0994k) this.e).f9532d = c0994k;
        this.e = c0994k;
        c0994k.f9531c = obj;
        c0994k.f9530b = str;
    }

    public void b(String str, long j4) {
        d(str, String.valueOf(j4));
    }

    public void c(String str, boolean z6) {
        d(str, String.valueOf(z6));
    }

    public void d(String str, String str2) {
        U1.f fVar = new U1.f(19);
        ((C0994k) this.e).f9532d = fVar;
        this.e = fVar;
        fVar.f9531c = str2;
        fVar.f9530b = str;
    }

    public io.flutter.plugin.platform.p e() {
        Intent intent = (Intent) this.f1611b;
        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle);
        }
        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f1613d);
        ((A) this.f1612c).getClass();
        intent.putExtras(new Bundle());
        intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
        int i = Build.VERSION.SDK_INT;
        String strA = p.b.a();
        if (!TextUtils.isEmpty(strA)) {
            Bundle bundleExtra = intent.hasExtra("com.android.browser.headers") ? intent.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (!bundleExtra.containsKey("Accept-Language")) {
                bundleExtra.putString("Accept-Language", strA);
                intent.putExtra("com.android.browser.headers", bundleExtra);
            }
        }
        if (i >= 34) {
            if (((ActivityOptions) this.e) == null) {
                this.e = p.a.a();
            }
            p.c.a((ActivityOptions) this.e, false);
        }
        ActivityOptions activityOptions = (ActivityOptions) this.e;
        return new io.flutter.plugin.platform.p(8, intent, activityOptions != null ? activityOptions.toBundle() : null);
    }

    public boolean f(String str, String str2) {
        synchronized (this) {
            try {
                if (!((C1002e) ((AtomicMarkableReference) this.f1611b).getReference()).b(str, str2)) {
                    return false;
                }
                AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) this.f1611b;
                atomicMarkableReference.set((C1002e) atomicMarkableReference.getReference(), true);
                E3.d dVar = new E3.d(this, 22);
                AtomicReference atomicReference = (AtomicReference) this.f1612c;
                while (!atomicReference.compareAndSet(null, dVar)) {
                    if (atomicReference.get() != null) {
                        return true;
                    }
                }
                ((C0969d) ((m.U0) this.e).f8310b).f9463b.a(dVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String g() {
        if (!this.f1613d) {
            this.f1613d = true;
            this.f1612c = ((C0097h0) this.e).t().getString((String) this.f1611b, null);
        }
        return (String) this.f1612c;
    }

    public void h(String str) {
        SharedPreferences.Editor editorEdit = ((C0097h0) this.e).t().edit();
        editorEdit.putString((String) this.f1611b, str);
        editorEdit.apply();
        this.f1612c = str;
    }

    public String toString() {
        switch (this.f1610a) {
            case 1:
                StringBuilder sb = new StringBuilder("DatabaseInfo(databaseId:");
                sb.append((Q2.f) this.e);
                sb.append(" host:");
                return AbstractC1024h.d(sb, (String) this.f1612c, ")");
            case 2:
            default:
                return super.toString();
            case 3:
                boolean z6 = this.f1613d;
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append((String) this.f1611b);
                sb2.append('{');
                String str = "";
                for (C0994k c0994k = (C0994k) ((C0994k) this.f1612c).f9532d; c0994k != null; c0994k = (C0994k) c0994k.f9532d) {
                    Object obj = c0994k.f9531c;
                    if ((c0994k instanceof U1.f) || obj != null || !z6) {
                        sb2.append(str);
                        String str2 = (String) c0994k.f9530b;
                        if (str2 != null) {
                            sb2.append(str2);
                            sb2.append('=');
                        }
                        if (obj == null || !obj.getClass().isArray()) {
                            sb2.append(obj);
                        } else {
                            String strDeepToString = Arrays.deepToString(new Object[]{obj});
                            sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                        }
                        str = ", ";
                    }
                }
                sb2.append('}');
                return sb2.toString();
        }
    }

    public C0094g0(Q2.f fVar, String str, String str2, boolean z6) {
        this.f1610a = 1;
        this.e = fVar;
        this.f1611b = str;
        this.f1612c = str2;
        this.f1613d = z6;
    }

    public C0094g0(Q2.i iVar, Q3.h hVar, A2.e eVar, boolean z6) {
        this.f1610a = 2;
        this.f1611b = iVar;
        this.f1612c = hVar;
        this.e = eVar;
        this.f1613d = z6;
    }

    public C0094g0(String str) {
        this.f1610a = 3;
        C0994k c0994k = new C0994k(19);
        this.f1612c = c0994k;
        this.e = c0994k;
        this.f1613d = false;
        this.f1611b = str;
    }

    public C0094g0(m.U0 u02, boolean z6) {
        this.f1610a = 5;
        this.e = u02;
        this.f1612c = new AtomicReference(null);
        this.f1613d = z6;
        this.f1611b = new AtomicMarkableReference(new C1002e(z6 ? 8192 : 1024), false);
    }

    public C0094g0() {
        this.f1610a = 4;
        this.f1611b = new Intent("android.intent.action.VIEW");
        this.f1612c = new A(29);
        this.f1613d = true;
    }
}

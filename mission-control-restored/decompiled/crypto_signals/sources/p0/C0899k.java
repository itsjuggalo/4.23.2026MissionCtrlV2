package p0;

import K2.C0054e;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebSettings;
import com.google.firebase.components.ComponentRegistrar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import k2.C0755a;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.json.JSONObject;
import s2.InterfaceC1001d;
import u5.C1250g;
import y2.C1424a;
import y2.C1425b;
import y2.InterfaceC1426c;
import z2.InterfaceC1465a;

/* JADX INFO: renamed from: p0.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0899k implements InterfaceC1001d, InterfaceC1426c, InterfaceC1465a {
    public static C1425b f(p pVar) {
        return new C1425b(System.currentTimeMillis() + ((long) 3600000), new F1.l(8), new C1424a(true, false, false), 10.0d, 1.2d, 60);
    }

    public static u5.v h(String str, boolean z6) {
        kotlin.jvm.internal.j.e(str, "<this>");
        u5.j jVar = v5.c.f10656a;
        C1250g c1250g = new C1250g();
        c1250g.E(str);
        return v5.c.d(c1250g, z6);
    }

    public static u5.v i(File file) {
        String str = u5.v.f10549b;
        String string = file.toString();
        kotlin.jvm.internal.j.d(string, "toString()");
        return h(string, false);
    }

    public static void k(WebSettings webSettings, boolean z6) {
        Z.B hVar;
        int i = 24;
        if (!w0.k.f10710d.b()) {
            throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
        }
        try {
            hVar = new Z.B((WebSettingsBoundaryInterface) y5.a.i(WebSettingsBoundaryInterface.class, ((WebkitToCompatConverterBoundaryInterface) w0.l.f10711a.f3700b).convertSettings(webSettings)), i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT != 30 || !"android.webkit.WebSettingsWrapper".equals(webSettings.getClass().getCanonicalName())) {
                throw e;
            }
            Log.e("WebSettingsCompat", "Error converting WebSettings to Chrome implementation. All AndroidX method calls on this WebSettings instance will be no-op calls. See https://crbug.com/388824130 for more info.", e);
            hVar = new w0.h(null, i);
        }
        hVar.u(z6);
    }

    @Override // y2.InterfaceC1426c
    public C1425b b(p pVar, JSONObject jSONObject) {
        return f(pVar);
    }

    @Override // s2.InterfaceC1001d
    public String c() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    @Override // z2.InterfaceC1465a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.StackTraceElement[] d(java.lang.StackTraceElement[] r15) {
        /*
            r14 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            int r1 = r15.length
            java.lang.StackTraceElement[] r1 = new java.lang.StackTraceElement[r1]
            r2 = 1
            r3 = 0
            r6 = r2
            r4 = r3
            r5 = r4
        Ld:
            int r7 = r15.length
            if (r4 >= r7) goto L61
            r7 = r15[r4]
            java.lang.Object r8 = r0.get(r7)
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 == 0) goto L4f
            int r9 = r8.intValue()
            int r10 = r4 - r9
            int r11 = r4 + r10
            int r12 = r15.length
            if (r11 <= r12) goto L26
            goto L4f
        L26:
            r11 = r3
        L27:
            if (r11 >= r10) goto L3b
            int r12 = r9 + r11
            r12 = r15[r12]
            int r13 = r4 + r11
            r13 = r15[r13]
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L38
            goto L4f
        L38:
            int r11 = r11 + 1
            goto L27
        L3b:
            int r8 = r8.intValue()
            int r8 = r4 - r8
            r9 = 10
            if (r6 >= r9) goto L4b
            java.lang.System.arraycopy(r15, r4, r1, r5, r8)
            int r5 = r5 + r8
            int r6 = r6 + 1
        L4b:
            int r8 = r8 + (-1)
            int r8 = r8 + r4
            goto L57
        L4f:
            r6 = r15[r4]
            r1[r5] = r6
            int r5 = r5 + 1
            r6 = r2
            r8 = r4
        L57:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0.put(r7, r4)
            int r4 = r8 + 1
            goto Ld
        L61:
            java.lang.StackTraceElement[] r0 = new java.lang.StackTraceElement[r5]
            java.lang.System.arraycopy(r1, r3, r0, r3, r5)
            int r1 = r15.length
            if (r5 >= r1) goto L6a
            return r0
        L6a:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C0899k.d(java.lang.StackTraceElement[]):java.lang.StackTraceElement[]");
    }

    public String g(List list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List j(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (C0755a c0755a : componentRegistrar.getComponents()) {
            String str = c0755a.f7832a;
            if (str != null) {
                C0054e c0054e = new C0054e(18, str, c0755a);
                c0755a = new C0755a(str, c0755a.f7833b, c0755a.f7834c, c0755a.f7835d, c0755a.e, c0054e, c0755a.f7837g);
            }
            arrayList.add(c0755a);
        }
        return arrayList;
    }

    @Override // s2.InterfaceC1001d
    public void a() {
    }

    @Override // s2.InterfaceC1001d
    public void e(String str, long j4) {
    }
}

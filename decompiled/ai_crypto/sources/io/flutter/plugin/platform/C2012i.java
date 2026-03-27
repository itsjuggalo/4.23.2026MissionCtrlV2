package io.flutter.plugin.platform;

import Q.v0;
import U4.o;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.Window;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/* JADX INFO: renamed from: io.flutter.plugin.platform.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2012i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f16758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U4.o f16759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f16760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o.j f16761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o.h f16763f;

    /* JADX INFO: renamed from: io.flutter.plugin.platform.i$a */
    public class a implements o.h {
        public a() {
        }

        @Override // U4.o.h
        public void b() {
            C2012i.this.t();
        }

        @Override // U4.o.h
        public void f(boolean z7) {
            C2012i.this.w(z7);
        }

        @Override // U4.o.h
        public CharSequence g(o.e eVar) {
            return C2012i.this.r(eVar);
        }

        @Override // U4.o.h
        public void h(List list) {
            C2012i.this.A(list);
        }

        @Override // U4.o.h
        public void i(String str) {
            C2012i.this.v(str);
        }

        @Override // U4.o.h
        public void j(String str) {
            C2012i.this.D(str);
        }

        @Override // U4.o.h
        public void k(o.g gVar) {
            C2012i.this.F(gVar);
        }

        @Override // U4.o.h
        public void l(o.j jVar) {
            C2012i.this.C(jVar);
        }

        @Override // U4.o.h
        public void m() {
            C2012i.this.y();
        }

        @Override // U4.o.h
        public void n(o.k kVar) {
            C2012i.this.z(kVar);
        }

        @Override // U4.o.h
        public void o() {
            C2012i.this.u();
        }

        @Override // U4.o.h
        public void p(o.c cVar) {
            C2012i.this.x(cVar);
        }

        @Override // U4.o.h
        public void q(o.i iVar) {
            C2012i.this.s(iVar);
        }

        @Override // U4.o.h
        public void r(int i7) {
            C2012i.this.B(i7);
        }

        @Override // U4.o.h
        public boolean s() {
            return C2012i.this.p();
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugin.platform.i$b */
    public class b implements View.OnSystemUiVisibilityChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f16765a;

        public b(View view) {
            this.f16765a = view;
        }

        public final /* synthetic */ void b(int i7) {
            if ((i7 & 4) == 0) {
                C2012i.this.f16759b.m(true);
            } else {
                C2012i.this.f16759b.m(false);
            }
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(final int i7) {
            this.f16765a.post(new Runnable() { // from class: io.flutter.plugin.platform.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16770a.b(i7);
                }
            });
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugin.platform.i$c */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f16768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f16769c;

        static {
            int[] iArr = new int[o.d.values().length];
            f16769c = iArr;
            try {
                iArr[o.d.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16769c[o.d.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[o.l.values().length];
            f16768b = iArr2;
            try {
                iArr2[o.l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16768b[o.l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[o.g.values().length];
            f16767a = iArr3;
            try {
                iArr3[o.g.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16767a[o.g.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16767a[o.g.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16767a[o.g.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16767a[o.g.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: renamed from: io.flutter.plugin.platform.i$d */
    public interface d {
        boolean b();

        void f(boolean z7);
    }

    public C2012i(Activity activity, U4.o oVar, d dVar) {
        a aVar = new a();
        this.f16763f = aVar;
        this.f16758a = activity;
        this.f16759b = oVar;
        oVar.l(aVar);
        this.f16760c = dVar;
        this.f16762e = 1280;
    }

    public final void A(List list) {
        int i7 = list.size() == 0 ? 5894 : 1798;
        for (int i8 = 0; i8 < list.size(); i8++) {
            int i9 = c.f16768b[((o.l) list.get(i8)).ordinal()];
            if (i9 == 1) {
                i7 &= -5;
            } else if (i9 == 2) {
                i7 &= -515;
            }
        }
        this.f16762e = i7;
        E();
    }

    public final void B(int i7) {
        this.f16758a.setRequestedOrientation(i7);
    }

    public final void C(o.j jVar) {
        Window window = this.f16758a.getWindow();
        v0 v0Var = new v0(window, window.getDecorView());
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 30) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(201326592);
        }
        o.d dVar = jVar.f5029b;
        if (dVar != null) {
            int i8 = c.f16769c[dVar.ordinal()];
            if (i8 == 1) {
                v0Var.b(true);
            } else if (i8 == 2) {
                v0Var.b(false);
            }
        }
        Integer num = jVar.f5028a;
        if (num != null) {
            window.setStatusBarColor(num.intValue());
        }
        Boolean bool = jVar.f5030c;
        if (bool != null && i7 >= 29) {
            window.setStatusBarContrastEnforced(bool.booleanValue());
        }
        if (i7 >= 26) {
            o.d dVar2 = jVar.f5032e;
            if (dVar2 != null) {
                int i9 = c.f16769c[dVar2.ordinal()];
                if (i9 == 1) {
                    v0Var.a(true);
                } else if (i9 == 2) {
                    v0Var.a(false);
                }
            }
            Integer num2 = jVar.f5031d;
            if (num2 != null) {
                window.setNavigationBarColor(num2.intValue());
            }
        }
        Integer num3 = jVar.f5033f;
        if (num3 != null && i7 >= 28) {
            window.setNavigationBarDividerColor(num3.intValue());
        }
        Boolean bool2 = jVar.f5034g;
        if (bool2 != null && i7 >= 29) {
            window.setNavigationBarContrastEnforced(bool2.booleanValue());
        }
        this.f16761d = jVar;
    }

    public final void D(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        this.f16758a.startActivity(Intent.createChooser(intent, null));
    }

    public void E() {
        this.f16758a.getWindow().getDecorView().setSystemUiVisibility(this.f16762e);
        o.j jVar = this.f16761d;
        if (jVar != null) {
            C(jVar);
        }
    }

    public void F(o.g gVar) {
        View decorView = this.f16758a.getWindow().getDecorView();
        int i7 = c.f16767a[gVar.ordinal()];
        if (i7 == 1) {
            decorView.performHapticFeedback(0);
            return;
        }
        if (i7 == 2) {
            decorView.performHapticFeedback(1);
            return;
        }
        if (i7 == 3) {
            decorView.performHapticFeedback(3);
        } else if (i7 == 4) {
            decorView.performHapticFeedback(6);
        } else {
            if (i7 != 5) {
                return;
            }
            decorView.performHapticFeedback(4);
        }
    }

    public final boolean p() {
        ClipDescription primaryClipDescription;
        ClipboardManager clipboardManager = (ClipboardManager) this.f16758a.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    public void q() {
        this.f16759b.l(null);
    }

    public final CharSequence r(o.e eVar) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f16758a.getSystemService("clipboard");
        CharSequence charSequence = null;
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        try {
            try {
                ClipData primaryClip = clipboardManager.getPrimaryClip();
                if (primaryClip == null) {
                    return null;
                }
                if (eVar != null && eVar != o.e.PLAIN_TEXT) {
                    return null;
                }
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                CharSequence text = itemAt.getText();
                if (text == null) {
                    try {
                        Uri uri = itemAt.getUri();
                        if (uri == null) {
                            J4.b.g("PlatformPlugin", "Clipboard item contained no textual content nor a URI to retrieve it from.");
                            return null;
                        }
                        String scheme = uri.getScheme();
                        if (!scheme.equals("content")) {
                            J4.b.g("PlatformPlugin", "Clipboard item contains a Uri with scheme '" + scheme + "'that is unhandled.");
                            return null;
                        }
                        AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor = this.f16758a.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null);
                        text = itemAt.coerceToText(this.f16758a);
                        if (assetFileDescriptorOpenTypedAssetFileDescriptor != null) {
                            assetFileDescriptorOpenTypedAssetFileDescriptor.close();
                        }
                    } catch (IOException e7) {
                        e = e7;
                        charSequence = text;
                    }
                }
                return text;
            } catch (IOException e8) {
                e = e8;
            }
            J4.b.h("PlatformPlugin", "Failed to close AssetFileDescriptor while trying to read text from URI.", e);
            return charSequence;
        } catch (FileNotFoundException unused) {
            J4.b.g("PlatformPlugin", "Clipboard text was unable to be received from content URI.");
            return null;
        } catch (SecurityException e9) {
            J4.b.h("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e9);
            return null;
        }
    }

    public final void s(o.i iVar) {
        if (iVar == o.i.CLICK) {
            this.f16758a.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t() {
        d dVar = this.f16760c;
        if (dVar == null || !dVar.b()) {
            Activity activity = this.f16758a;
            if (activity instanceof d.y) {
                ((d.y) activity).h().k();
            } else {
                activity.finish();
            }
        }
    }

    public final void u() {
        E();
    }

    public final void v(String str) {
        ((ClipboardManager) this.f16758a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    public final void w(boolean z7) {
        d dVar = this.f16760c;
        if (dVar != null) {
            dVar.f(z7);
        }
    }

    public final void x(o.c cVar) {
        if (Build.VERSION.SDK_INT < 28) {
            this.f16758a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f5002b, (Bitmap) null, cVar.f5001a));
            return;
        }
        AbstractC2011h.a();
        this.f16758a.setTaskDescription(AbstractC2010g.a(cVar.f5002b, 0, cVar.f5001a));
    }

    public final void y() {
        View decorView = this.f16758a.getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new b(decorView));
    }

    public final void z(o.k kVar) {
        int i7;
        if (kVar == o.k.LEAN_BACK) {
            i7 = 1798;
        } else if (kVar == o.k.IMMERSIVE) {
            i7 = 3846;
        } else if (kVar == o.k.IMMERSIVE_STICKY) {
            i7 = 5894;
        } else if (kVar != o.k.EDGE_TO_EDGE || Build.VERSION.SDK_INT < 29) {
            return;
        } else {
            i7 = 1792;
        }
        this.f16762e = i7;
        E();
    }
}

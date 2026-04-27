package U4;

import V4.a;
import android.os.Build;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5133b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.a f5134a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentLinkedQueue f5135a = new ConcurrentLinkedQueue();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f5136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f5137c;

        /* JADX INFO: renamed from: U4.w$a$a, reason: collision with other inner class name */
        public class C0086a implements a.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f5138a;

            public C0086a(b bVar) {
                this.f5138a = bVar;
            }

            @Override // V4.a.e
            public void a(Object obj) {
                a.this.f5135a.remove(this.f5138a);
                if (a.this.f5135a.isEmpty()) {
                    return;
                }
                J4.b.b("SettingsChannel", "The queue becomes empty after removing config generation " + String.valueOf(this.f5138a.f5141a));
            }
        }

        public static class b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static int f5140c = Integer.MIN_VALUE;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f5141a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DisplayMetrics f5142b;

            public b(DisplayMetrics displayMetrics) {
                int i7 = f5140c;
                f5140c = i7 + 1;
                this.f5141a = i7;
                this.f5142b = displayMetrics;
            }
        }

        public a.e b(b bVar) {
            this.f5135a.add(bVar);
            b bVar2 = this.f5137c;
            this.f5137c = bVar;
            if (bVar2 == null) {
                return null;
            }
            return new C0086a(bVar2);
        }

        public b c(int i7) {
            b bVar;
            if (this.f5136b == null) {
                this.f5136b = (b) this.f5135a.poll();
            }
            while (true) {
                bVar = this.f5136b;
                if (bVar == null || bVar.f5141a >= i7) {
                    break;
                }
                this.f5136b = (b) this.f5135a.poll();
            }
            if (bVar == null) {
                J4.b.b("SettingsChannel", "Cannot find config with generation: " + String.valueOf(i7) + ", after exhausting the queue.");
                return null;
            }
            if (bVar.f5141a == i7) {
                return bVar;
            }
            J4.b.b("SettingsChannel", "Cannot find config with generation: " + String.valueOf(i7) + ", the oldest config is now: " + String.valueOf(this.f5136b.f5141a));
            return null;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final V4.a f5143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f5144b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public DisplayMetrics f5145c;

        public b(V4.a aVar) {
            this.f5143a = aVar;
        }

        public void a() {
            J4.b.f("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.f5144b.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.f5144b.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.f5144b.get("platformBrightness"));
            DisplayMetrics displayMetrics = this.f5145c;
            if (!w.c() || displayMetrics == null) {
                this.f5143a.c(this.f5144b);
                return;
            }
            a.b bVar = new a.b(displayMetrics);
            a.e eVarB = w.f5133b.b(bVar);
            this.f5144b.put("configurationId", Integer.valueOf(bVar.f5141a));
            this.f5143a.d(this.f5144b, eVarB);
        }

        public b b(boolean z7) {
            this.f5144b.put("brieflyShowPassword", Boolean.valueOf(z7));
            return this;
        }

        public b c(DisplayMetrics displayMetrics) {
            this.f5145c = displayMetrics;
            return this;
        }

        public b d(boolean z7) {
            this.f5144b.put("nativeSpellCheckServiceDefined", Boolean.valueOf(z7));
            return this;
        }

        public b e(c cVar) {
            this.f5144b.put("platformBrightness", cVar.f5149a);
            return this;
        }

        public b f(float f7) {
            this.f5144b.put("textScaleFactor", Float.valueOf(f7));
            return this;
        }

        public b g(boolean z7) {
            this.f5144b.put("alwaysUse24HourFormat", Boolean.valueOf(z7));
            return this;
        }
    }

    public enum c {
        light("light"),
        dark("dark");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5149a;

        c(String str) {
            this.f5149a = str;
        }
    }

    public w(M4.a aVar) {
        this.f5134a = new V4.a(aVar, "flutter/settings", V4.e.f5330a);
    }

    public static DisplayMetrics b(int i7) {
        a.b bVarC = f5133b.c(i7);
        if (bVarC == null) {
            return null;
        }
        return bVarC.f5142b;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 34;
    }

    public b d() {
        return new b(this.f5134a);
    }
}

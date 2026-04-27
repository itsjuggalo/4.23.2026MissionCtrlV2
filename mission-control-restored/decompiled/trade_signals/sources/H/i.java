package H;

import H.r;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f3397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f3398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final t[] f3399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final t[] f3400d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3401e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3402f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f3403g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f3404h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3405i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f3406j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public PendingIntent f3407k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f3408l;

        /* JADX INFO: renamed from: H.i$a$a, reason: collision with other inner class name */
        public static final class C0040a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IconCompat f3409a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CharSequence f3410b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final PendingIntent f3411c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f3412d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final Bundle f3413e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public ArrayList f3414f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f3415g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f3416h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f3417i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f3418j;

            public C0040a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public C0040a a(t tVar) {
                if (this.f3414f == null) {
                    this.f3414f = new ArrayList();
                }
                if (tVar != null) {
                    this.f3414f.add(tVar);
                }
                return this;
            }

            public a b() {
                c();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<t> arrayList3 = this.f3414f;
                if (arrayList3 != null) {
                    for (t tVar : arrayList3) {
                        if (tVar.k()) {
                            arrayList.add(tVar);
                        } else {
                            arrayList2.add(tVar);
                        }
                    }
                }
                return new a(this.f3409a, this.f3410b, this.f3411c, this.f3413e, arrayList2.isEmpty() ? null : (t[]) arrayList2.toArray(new t[arrayList2.size()]), arrayList.isEmpty() ? null : (t[]) arrayList.toArray(new t[arrayList.size()]), this.f3412d, this.f3415g, this.f3416h, this.f3417i, this.f3418j);
            }

            public final void c() {
                if (this.f3417i && this.f3411c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C0040a d(boolean z7) {
                this.f3412d = z7;
                return this;
            }

            public C0040a e(boolean z7) {
                this.f3417i = z7;
                return this;
            }

            public C0040a f(int i8) {
                this.f3415g = i8;
                return this;
            }

            public C0040a g(boolean z7) {
                this.f3416h = z7;
                return this;
            }

            public C0040a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, t[] tVarArr, boolean z7, int i8, boolean z8, boolean z9, boolean z10) {
                this.f3412d = true;
                this.f3416h = true;
                this.f3409a = iconCompat;
                this.f3410b = e.f(charSequence);
                this.f3411c = pendingIntent;
                this.f3413e = bundle;
                this.f3414f = tVarArr == null ? null : new ArrayList(Arrays.asList(tVarArr));
                this.f3412d = z7;
                this.f3415g = i8;
                this.f3416h = z8;
                this.f3417i = z9;
                this.f3418j = z10;
            }
        }

        public a(int i8, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i8 != 0 ? IconCompat.k(null, "", i8) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f3407k;
        }

        public boolean b() {
            return this.f3401e;
        }

        public Bundle c() {
            return this.f3397a;
        }

        public IconCompat d() {
            int i8;
            if (this.f3398b == null && (i8 = this.f3405i) != 0) {
                this.f3398b = IconCompat.k(null, "", i8);
            }
            return this.f3398b;
        }

        public t[] e() {
            return this.f3399c;
        }

        public int f() {
            return this.f3403g;
        }

        public boolean g() {
            return this.f3402f;
        }

        public CharSequence h() {
            return this.f3406j;
        }

        public boolean i() {
            return this.f3408l;
        }

        public boolean j() {
            return this.f3404h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, t[] tVarArr, t[] tVarArr2, boolean z7, int i8, boolean z8, boolean z9, boolean z10) {
            this.f3402f = true;
            this.f3398b = iconCompat;
            if (iconCompat != null && iconCompat.o() == 2) {
                this.f3405i = iconCompat.m();
            }
            this.f3406j = e.f(charSequence);
            this.f3407k = pendingIntent;
            this.f3397a = bundle == null ? new Bundle() : bundle;
            this.f3399c = tVarArr;
            this.f3400d = tVarArr2;
            this.f3401e = z7;
            this.f3403g = i8;
            this.f3402f = z8;
            this.f3404h = z9;
            this.f3408l = z10;
        }
    }

    public static class b extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public IconCompat f3419e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public IconCompat f3420f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f3421g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f3422h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f3423i;

        public static class a {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* JADX INFO: renamed from: H.i$b$b, reason: collision with other inner class name */
        public static class C0041b {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z7) {
                bigPictureStyle.showBigPictureWhenCollapsed(z7);
            }
        }

        public static IconCompat n(Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (parcelable instanceof Icon) {
                return IconCompat.b((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.f((Bitmap) parcelable);
            }
            return null;
        }

        public static IconCompat q(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            Parcelable parcelable = bundle.getParcelable("android.picture");
            return parcelable != null ? n(parcelable) : n(bundle.getParcelable("android.pictureIcon"));
        }

        @Override // H.i.j
        public void b(H.h hVar) {
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(hVar.a()).setBigContentTitle(this.f3496b);
            IconCompat iconCompat = this.f3419e;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    C0041b.a(bigContentTitle, this.f3419e.v(hVar instanceof l ? ((l) hVar).f() : null));
                } else if (iconCompat.o() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f3419e.l());
                }
            }
            if (this.f3421g) {
                if (this.f3420f == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    a.a(bigContentTitle, this.f3420f.v(hVar instanceof l ? ((l) hVar).f() : null));
                }
            }
            if (this.f3498d) {
                bigContentTitle.setSummaryText(this.f3497c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                C0041b.c(bigContentTitle, this.f3423i);
                C0041b.b(bigContentTitle, this.f3422h);
            }
        }

        @Override // H.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @Override // H.i.j
        public void l(Bundle bundle) {
            super.l(bundle);
            if (bundle.containsKey("android.largeIcon.big")) {
                this.f3420f = n(bundle.getParcelable("android.largeIcon.big"));
                this.f3421g = true;
            }
            this.f3419e = q(bundle);
            this.f3423i = bundle.getBoolean("android.showBigPictureWhenCollapsed");
        }

        public b o(Bitmap bitmap) {
            this.f3420f = bitmap == null ? null : IconCompat.f(bitmap);
            this.f3421g = true;
            return this;
        }

        public b p(Bitmap bitmap) {
            this.f3419e = bitmap == null ? null : IconCompat.f(bitmap);
            return this;
        }

        public b r(CharSequence charSequence) {
            this.f3496b = e.f(charSequence);
            return this;
        }

        public b s(CharSequence charSequence) {
            this.f3497c = e.f(charSequence);
            this.f3498d = true;
            return this;
        }
    }

    public static class c extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f3424e;

        @Override // H.i.j
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // H.i.j
        public void b(H.h hVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(hVar.a()).setBigContentTitle(this.f3496b).bigText(this.f3424e);
            if (this.f3498d) {
                bigTextStyleBigText.setSummaryText(this.f3497c);
            }
        }

        @Override // H.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // H.i.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f3424e = bundle.getCharSequence("android.bigText");
        }

        public c n(CharSequence charSequence) {
            this.f3424e = e.f(charSequence);
            return this;
        }

        public c o(CharSequence charSequence) {
            this.f3496b = e.f(charSequence);
            return this;
        }

        public c p(CharSequence charSequence) {
            this.f3497c = e.f(charSequence);
            this.f3498d = true;
            return this;
        }
    }

    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public boolean f3425A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public boolean f3426B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public boolean f3427C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public String f3428D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public Bundle f3429E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public int f3430F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f3431G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public Notification f3432H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public RemoteViews f3433I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public RemoteViews f3434J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public RemoteViews f3435K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public String f3436L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public int f3437M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public String f3438N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public long f3439O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public int f3440P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public int f3441Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public boolean f3442R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public Notification f3443S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public boolean f3444T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public Object f3445U;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public ArrayList f3446V;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f3447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f3448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f3449c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f3450d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f3451e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f3452f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f3453g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f3454h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RemoteViews f3455i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public IconCompat f3456j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f3457k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f3458l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f3459m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f3460n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f3461o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f3462p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public j f3463q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public CharSequence f3464r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public CharSequence f3465s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public CharSequence[] f3466t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f3467u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f3468v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f3469w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f3470x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f3471y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f3472z;

        public static class a {
            public static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            public static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i8) {
                return builder.setContentType(i8);
            }

            public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i8) {
                return builder.setLegacyStreamType(i8);
            }

            public static AudioAttributes.Builder e(AudioAttributes.Builder builder, int i8) {
                return builder.setUsage(i8);
            }
        }

        public e(Context context) {
            this(context, null);
        }

        public static CharSequence f(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public e A(boolean z7) {
            r(2, z7);
            return this;
        }

        public e B(boolean z7) {
            r(8, z7);
            return this;
        }

        public e C(int i8) {
            this.f3459m = i8;
            return this;
        }

        public e D(int i8, int i9, boolean z7) {
            this.f3467u = i8;
            this.f3468v = i9;
            this.f3469w = z7;
            return this;
        }

        public e E(String str) {
            this.f3438N = str;
            return this;
        }

        public e F(boolean z7) {
            this.f3460n = z7;
            return this;
        }

        public e G(boolean z7) {
            this.f3444T = z7;
            return this;
        }

        public e H(int i8) {
            this.f3443S.icon = i8;
            return this;
        }

        public e I(Uri uri) {
            Notification notification = this.f3443S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder builderE = a.e(a.c(a.b(), 4), 5);
            this.f3443S.audioAttributes = a.a(builderE);
            return this;
        }

        public e J(j jVar) {
            if (this.f3463q != jVar) {
                this.f3463q = jVar;
                if (jVar != null) {
                    jVar.m(this);
                }
            }
            return this;
        }

        public e K(CharSequence charSequence) {
            this.f3464r = f(charSequence);
            return this;
        }

        public e L(CharSequence charSequence) {
            this.f3443S.tickerText = f(charSequence);
            return this;
        }

        public e M(long j8) {
            this.f3439O = j8;
            return this;
        }

        public e N(boolean z7) {
            this.f3461o = z7;
            return this;
        }

        public e O(long[] jArr) {
            this.f3443S.vibrate = jArr;
            return this;
        }

        public e P(int i8) {
            this.f3431G = i8;
            return this;
        }

        public e Q(long j8) {
            this.f3443S.when = j8;
            return this;
        }

        public e a(int i8, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f3448b.add(new a(i8, charSequence, pendingIntent));
            return this;
        }

        public e b(a aVar) {
            if (aVar != null) {
                this.f3448b.add(aVar);
            }
            return this;
        }

        public e c(a aVar) {
            if (aVar != null) {
                this.f3450d.add(aVar);
            }
            return this;
        }

        public Notification d() {
            return new l(this).c();
        }

        public Bundle e() {
            if (this.f3429E == null) {
                this.f3429E = new Bundle();
            }
            return this.f3429E;
        }

        public e g(boolean z7) {
            r(16, z7);
            return this;
        }

        public e h(String str) {
            this.f3428D = str;
            return this;
        }

        public e i(String str) {
            this.f3436L = str;
            return this;
        }

        public e j(boolean z7) {
            this.f3462p = z7;
            e().putBoolean("android.chronometerCountDown", z7);
            return this;
        }

        public e k(int i8) {
            this.f3430F = i8;
            return this;
        }

        public e l(boolean z7) {
            this.f3426B = z7;
            this.f3427C = true;
            return this;
        }

        public e m(PendingIntent pendingIntent) {
            this.f3453g = pendingIntent;
            return this;
        }

        public e n(CharSequence charSequence) {
            this.f3452f = f(charSequence);
            return this;
        }

        public e o(CharSequence charSequence) {
            this.f3451e = f(charSequence);
            return this;
        }

        public e p(int i8) {
            Notification notification = this.f3443S;
            notification.defaults = i8;
            if ((i8 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e q(PendingIntent pendingIntent) {
            this.f3443S.deleteIntent = pendingIntent;
            return this;
        }

        public final void r(int i8, boolean z7) {
            Notification notification;
            int i9;
            if (z7) {
                notification = this.f3443S;
                i9 = i8 | notification.flags;
            } else {
                notification = this.f3443S;
                i9 = (~i8) & notification.flags;
            }
            notification.flags = i9;
        }

        public e s(PendingIntent pendingIntent, boolean z7) {
            this.f3454h = pendingIntent;
            r(128, z7);
            return this;
        }

        public e t(String str) {
            this.f3470x = str;
            return this;
        }

        public e u(int i8) {
            this.f3440P = i8;
            return this;
        }

        public e v(boolean z7) {
            this.f3471y = z7;
            return this;
        }

        public e w(Bitmap bitmap) {
            this.f3456j = bitmap == null ? null : IconCompat.f(i.b(this.f3447a, bitmap));
            return this;
        }

        public e x(int i8, int i9, int i10) {
            Notification notification = this.f3443S;
            notification.ledARGB = i8;
            notification.ledOnMS = i9;
            notification.ledOffMS = i10;
            notification.flags = ((i9 == 0 || i10 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public e y(boolean z7) {
            this.f3425A = z7;
            return this;
        }

        public e z(int i8) {
            this.f3458l = i8;
            return this;
        }

        public e(Context context, String str) {
            this.f3448b = new ArrayList();
            this.f3449c = new ArrayList();
            this.f3450d = new ArrayList();
            this.f3460n = true;
            this.f3425A = false;
            this.f3430F = 0;
            this.f3431G = 0;
            this.f3437M = 0;
            this.f3440P = 0;
            this.f3441Q = 0;
            Notification notification = new Notification();
            this.f3443S = notification;
            this.f3447a = context;
            this.f3436L = str;
            notification.when = System.currentTimeMillis();
            this.f3443S.audioStreamType = -1;
            this.f3459m = 0;
            this.f3446V = new ArrayList();
            this.f3442R = true;
        }
    }

    public static class g extends j {

        public static class a {
            public static Notification.Style a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        @Override // H.i.j
        public void b(H.h hVar) {
            hVar.a().setStyle(a.a());
        }

        @Override // H.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // H.i.j
        public RemoteViews i(H.h hVar) {
            return null;
        }

        @Override // H.i.j
        public RemoteViews j(H.h hVar) {
            return null;
        }

        @Override // H.i.j
        public RemoteViews k(H.h hVar) {
            return null;
        }
    }

    public static class h extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList f3483e = new ArrayList();

        @Override // H.i.j
        public void b(H.h hVar) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(hVar.a()).setBigContentTitle(this.f3496b);
            if (this.f3498d) {
                bigContentTitle.setSummaryText(this.f3497c);
            }
            Iterator it = this.f3483e.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine((CharSequence) it.next());
            }
        }

        @Override // H.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @Override // H.i.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f3483e.clear();
            if (bundle.containsKey("android.textLines")) {
                Collections.addAll(this.f3483e, bundle.getCharSequenceArray("android.textLines"));
            }
        }

        public h n(CharSequence charSequence) {
            if (charSequence != null) {
                this.f3483e.add(e.f(charSequence));
            }
            return this;
        }

        public h o(CharSequence charSequence) {
            this.f3496b = e.f(charSequence);
            return this;
        }

        public h p(CharSequence charSequence) {
            this.f3497c = e.f(charSequence);
            this.f3498d = true;
            return this;
        }
    }

    /* JADX INFO: renamed from: H.i$i, reason: collision with other inner class name */
    public static class C0042i extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f3484e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f3485f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public r f3486g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f3487h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Boolean f3488i;

        /* JADX INFO: renamed from: H.i$i$a */
        public static class a {
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            public static Notification.MessagingStyle b(CharSequence charSequence) {
                return new Notification.MessagingStyle(charSequence);
            }

            public static Notification.MessagingStyle c(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
                return messagingStyle.setConversationTitle(charSequence);
            }
        }

        /* JADX INFO: renamed from: H.i$i$b */
        public static class b {
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        /* JADX INFO: renamed from: H.i$i$c */
        public static class c {
            public static Notification.MessagingStyle a(Person person) {
                return new Notification.MessagingStyle(person);
            }

            public static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z7) {
                return messagingStyle.setGroupConversation(z7);
            }
        }

        public C0042i() {
        }

        public static C0042i o(Notification notification) {
            j jVarG = j.g(notification);
            if (jVarG instanceof C0042i) {
                return (C0042i) jVarG;
            }
            return null;
        }

        @Override // H.i.j
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.f3486g.e());
            bundle.putBundle("android.messagingStyleUser", this.f3486g.k());
            bundle.putCharSequence("android.hiddenConversationTitle", this.f3487h);
            if (this.f3487h != null && this.f3488i.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.f3487h);
            }
            if (!this.f3484e.isEmpty()) {
                bundle.putParcelableArray("android.messages", d.a(this.f3484e));
            }
            if (!this.f3485f.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", d.a(this.f3485f));
            }
            Boolean bool = this.f3488i;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        @Override // H.i.j
        public void b(H.h hVar) {
            u(s());
            Notification.MessagingStyle messagingStyleA = Build.VERSION.SDK_INT >= 28 ? c.a(this.f3486g.j()) : a.b(this.f3486g.e());
            Iterator it = this.f3484e.iterator();
            while (it.hasNext()) {
                a.a(messagingStyleA, ((d) it.next()).k());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Iterator it2 = this.f3485f.iterator();
                while (it2.hasNext()) {
                    b.a(messagingStyleA, ((d) it2.next()).k());
                }
            }
            if (this.f3488i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                a.c(messagingStyleA, this.f3487h);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                c.b(messagingStyleA, this.f3488i.booleanValue());
            }
            messagingStyleA.setBuilder(hVar.a());
        }

        @Override // H.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        @Override // H.i.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f3484e.clear();
            this.f3486g = bundle.containsKey("android.messagingStyleUser") ? r.b(bundle.getBundle("android.messagingStyleUser")) : new r.b().f(bundle.getString("android.selfDisplayName")).a();
            CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
            this.f3487h = charSequence;
            if (charSequence == null) {
                this.f3487h = bundle.getCharSequence("android.hiddenConversationTitle");
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
            if (parcelableArray != null) {
                this.f3484e.addAll(d.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
            if (parcelableArray2 != null) {
                this.f3485f.addAll(d.f(parcelableArray2));
            }
            if (bundle.containsKey("android.isGroupConversation")) {
                this.f3488i = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
            }
        }

        public C0042i n(d dVar) {
            if (dVar != null) {
                this.f3484e.add(dVar);
                if (this.f3484e.size() > 25) {
                    this.f3484e.remove(0);
                }
            }
            return this;
        }

        public CharSequence p() {
            return this.f3487h;
        }

        public List q() {
            return this.f3484e;
        }

        public r r() {
            return this.f3486g;
        }

        public boolean s() {
            e eVar = this.f3495a;
            if (eVar != null && eVar.f3447a.getApplicationInfo().targetSdkVersion < 28 && this.f3488i == null) {
                return this.f3487h != null;
            }
            Boolean bool = this.f3488i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public C0042i t(CharSequence charSequence) {
            this.f3487h = charSequence;
            return this;
        }

        public C0042i u(boolean z7) {
            this.f3488i = Boolean.valueOf(z7);
            return this;
        }

        public C0042i(r rVar) {
            if (TextUtils.isEmpty(rVar.e())) {
                throw new IllegalArgumentException("User's name must not be empty.");
            }
            this.f3486g = rVar;
        }

        /* JADX INFO: renamed from: H.i$i$d */
        public static final class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CharSequence f3489a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f3490b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final r f3491c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Bundle f3492d = new Bundle();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f3493e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Uri f3494f;

            /* JADX INFO: renamed from: H.i$i$d$a */
            public static class a {
                public static Notification.MessagingStyle.Message a(CharSequence charSequence, long j8, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j8, charSequence2);
                }

                public static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            public d(CharSequence charSequence, long j8, r rVar) {
                this.f3489a = charSequence;
                this.f3490b = j8;
                this.f3491c = rVar;
            }

            public static Bundle[] a(List list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i8 = 0; i8 < size; i8++) {
                    bundleArr[i8] = ((d) list.get(i8)).l();
                }
                return bundleArr;
            }

            public static d e(Bundle bundle) {
                try {
                    if (bundle.containsKey("text") && bundle.containsKey(com.amazon.a.a.h.a.f13759b)) {
                        d dVar = new d(bundle.getCharSequence("text"), bundle.getLong(com.amazon.a.a.h.a.f13759b), bundle.containsKey("person") ? r.b(bundle.getBundle("person")) : (!bundle.containsKey("sender_person") || Build.VERSION.SDK_INT < 28) ? bundle.containsKey("sender") ? new r.b().f(bundle.getCharSequence("sender")).a() : null : r.a(k.a(bundle.getParcelable("sender_person"))));
                        if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                            dVar.j(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                        }
                        if (bundle.containsKey("extras")) {
                            dVar.d().putAll(bundle.getBundle("extras"));
                        }
                        return dVar;
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            public static List f(Parcelable[] parcelableArr) {
                d dVarE;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (Parcelable parcelable : parcelableArr) {
                    if ((parcelable instanceof Bundle) && (dVarE = e((Bundle) parcelable)) != null) {
                        arrayList.add(dVarE);
                    }
                }
                return arrayList;
            }

            public String b() {
                return this.f3493e;
            }

            public Uri c() {
                return this.f3494f;
            }

            public Bundle d() {
                return this.f3492d;
            }

            public r g() {
                return this.f3491c;
            }

            public CharSequence h() {
                return this.f3489a;
            }

            public long i() {
                return this.f3490b;
            }

            public d j(String str, Uri uri) {
                this.f3493e = str;
                this.f3494f = uri;
                return this;
            }

            public Notification.MessagingStyle.Message k() {
                Notification.MessagingStyle.Message messageA;
                r rVarG = g();
                if (Build.VERSION.SDK_INT >= 28) {
                    messageA = b.b(h(), i(), rVarG != null ? rVarG.j() : null);
                } else {
                    messageA = a.a(h(), i(), rVarG != null ? rVarG.e() : null);
                }
                if (b() != null) {
                    a.b(messageA, b(), c());
                }
                return messageA;
            }

            public final Bundle l() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f3489a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong(com.amazon.a.a.h.a.f13759b, this.f3490b);
                r rVar = this.f3491c;
                if (rVar != null) {
                    bundle.putCharSequence("sender", rVar.e());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", b.a(this.f3491c.j()));
                    } else {
                        bundle.putBundle("person", this.f3491c.k());
                    }
                }
                String str = this.f3493e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f3494f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.f3492d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            /* JADX INFO: renamed from: H.i$i$d$b */
            public static class b {
                public static Notification.MessagingStyle.Message b(CharSequence charSequence, long j8, Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j8, person);
                }

                public static Parcelable a(Person person) {
                    return person;
                }
            }
        }
    }

    public static abstract class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f3495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f3496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f3497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3498d = false;

        public static j c(String str) {
            if (str == null) {
                return null;
            }
            switch (str) {
                case "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle":
                    return new g();
                case "androidx.core.app.NotificationCompat$BigPictureStyle":
                    return new b();
                case "androidx.core.app.NotificationCompat$CallStyle":
                    return new f();
                case "androidx.core.app.NotificationCompat$InboxStyle":
                    return new h();
                case "androidx.core.app.NotificationCompat$BigTextStyle":
                    return new c();
                case "androidx.core.app.NotificationCompat$MessagingStyle":
                    return new C0042i();
                default:
                    return null;
            }
        }

        public static j d(String str) {
            if (str == null) {
                return null;
            }
            if (str.equals(Notification.BigPictureStyle.class.getName())) {
                return new b();
            }
            if (str.equals(Notification.BigTextStyle.class.getName())) {
                return new c();
            }
            if (str.equals(Notification.InboxStyle.class.getName())) {
                return new h();
            }
            if (str.equals(Notification.MessagingStyle.class.getName())) {
                return new C0042i();
            }
            if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                return new g();
            }
            return null;
        }

        public static j e(Bundle bundle) {
            j jVarC = c(bundle.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
            return jVarC != null ? jVarC : (bundle.containsKey("android.selfDisplayName") || bundle.containsKey("android.messagingStyleUser")) ? new C0042i() : (bundle.containsKey("android.picture") || bundle.containsKey("android.pictureIcon")) ? new b() : bundle.containsKey("android.bigText") ? new c() : bundle.containsKey("android.textLines") ? new h() : bundle.containsKey("android.callType") ? new f() : d(bundle.getString("android.template"));
        }

        public static j f(Bundle bundle) {
            j jVarE = e(bundle);
            if (jVarE == null) {
                return null;
            }
            try {
                jVarE.l(bundle);
                return jVarE;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        public static j g(Notification notification) {
            Bundle bundleA = i.a(notification);
            if (bundleA == null) {
                return null;
            }
            return f(bundleA);
        }

        public void a(Bundle bundle) {
            if (this.f3498d) {
                bundle.putCharSequence("android.summaryText", this.f3497c);
            }
            CharSequence charSequence = this.f3496b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strH = h();
            if (strH != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strH);
            }
        }

        public abstract void b(H.h hVar);

        public String h() {
            return null;
        }

        public RemoteViews i(H.h hVar) {
            return null;
        }

        public RemoteViews j(H.h hVar) {
            return null;
        }

        public RemoteViews k(H.h hVar) {
            return null;
        }

        public void l(Bundle bundle) {
            if (bundle.containsKey("android.summaryText")) {
                this.f3497c = bundle.getCharSequence("android.summaryText");
                this.f3498d = true;
            }
            this.f3496b = bundle.getCharSequence("android.title.big");
        }

        public void m(e eVar) {
            if (this.f3495a != eVar) {
                this.f3495a = eVar;
                if (eVar != null) {
                    eVar.J(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static Bitmap b(Context context, Bitmap bitmap) {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(G.c.f1928b);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(G.c.f1927a);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
    }

    public static class f extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3473e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public r f3474f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f3475g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f3476h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PendingIntent f3477i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f3478j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f3479k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Integer f3480l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public IconCompat f3481m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public CharSequence f3482n;

        public static class a {
            public static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }

            public static Notification.Builder b(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        public static class d {
            public static Notification.CallStyle a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle b(Person person, PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            public static Notification.CallStyle c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle d(Notification.CallStyle callStyle, int i8) {
                return callStyle.setAnswerButtonColorHint(i8);
            }

            public static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z7) {
                return builder.setAuthenticationRequired(z7);
            }

            public static Notification.CallStyle f(Notification.CallStyle callStyle, int i8) {
                return callStyle.setDeclineButtonColorHint(i8);
            }

            public static Notification.CallStyle g(Notification.CallStyle callStyle, boolean z7) {
                return callStyle.setIsVideo(z7);
            }

            public static Notification.CallStyle h(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            public static Notification.CallStyle i(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        @Override // H.i.j
        public void a(Bundle bundle) {
            String str;
            Parcelable parcelableK;
            super.a(bundle);
            bundle.putInt("android.callType", this.f3473e);
            bundle.putBoolean("android.callIsVideo", this.f3478j);
            r rVar = this.f3474f;
            if (rVar != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    parcelableK = c.b(rVar.j());
                    str = "android.callPerson";
                } else {
                    str = "android.callPersonCompat";
                    parcelableK = rVar.k();
                }
                bundle.putParcelable(str, parcelableK);
            }
            IconCompat iconCompat = this.f3481m;
            if (iconCompat != null) {
                bundle.putParcelable("android.verificationIcon", b.a(iconCompat.v(this.f3495a.f3447a)));
            }
            bundle.putCharSequence("android.verificationText", this.f3482n);
            bundle.putParcelable("android.answerIntent", this.f3475g);
            bundle.putParcelable("android.declineIntent", this.f3476h);
            bundle.putParcelable("android.hangUpIntent", this.f3477i);
            Integer num = this.f3479k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f3480l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // H.i.j
        public void b(H.h hVar) {
            int i8 = Build.VERSION.SDK_INT;
            CharSequence charSequenceO = null;
            callStyleA = null;
            Notification.CallStyle callStyleA = null;
            charSequenceO = null;
            if (i8 < 31) {
                Notification.Builder builderA = hVar.a();
                r rVar = this.f3474f;
                builderA.setContentTitle(rVar != null ? rVar.e() : null);
                Bundle bundle = this.f3495a.f3429E;
                if (bundle != null && bundle.containsKey("android.text")) {
                    charSequenceO = this.f3495a.f3429E.getCharSequence("android.text");
                }
                if (charSequenceO == null) {
                    charSequenceO = o();
                }
                builderA.setContentText(charSequenceO);
                r rVar2 = this.f3474f;
                if (rVar2 != null) {
                    if (rVar2.c() != null) {
                        b.c(builderA, this.f3474f.c().v(this.f3495a.f3447a));
                    }
                    if (i8 >= 28) {
                        c.a(builderA, this.f3474f.j());
                    } else {
                        a.a(builderA, this.f3474f.f());
                    }
                }
                a.b(builderA, "call");
                return;
            }
            int i9 = this.f3473e;
            if (i9 == 1) {
                callStyleA = d.a(this.f3474f.j(), this.f3476h, this.f3475g);
            } else if (i9 == 2) {
                callStyleA = d.b(this.f3474f.j(), this.f3477i);
            } else if (i9 == 3) {
                callStyleA = d.c(this.f3474f.j(), this.f3477i, this.f3475g);
            } else if (Log.isLoggable("NotifCompat", 3)) {
                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f3473e));
            }
            if (callStyleA != null) {
                callStyleA.setBuilder(hVar.a());
                Integer num = this.f3479k;
                if (num != null) {
                    d.d(callStyleA, num.intValue());
                }
                Integer num2 = this.f3480l;
                if (num2 != null) {
                    d.f(callStyleA, num2.intValue());
                }
                d.i(callStyleA, this.f3482n);
                IconCompat iconCompat = this.f3481m;
                if (iconCompat != null) {
                    d.h(callStyleA, iconCompat.v(this.f3495a.f3447a));
                }
                d.g(callStyleA, this.f3478j);
            }
        }

        @Override // H.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00aa  */
        @Override // H.i.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.os.Bundle r4) {
            /*
                r3 = this;
                super.l(r4)
                java.lang.String r0 = "android.callType"
                int r0 = r4.getInt(r0)
                r3.f3473e = r0
                java.lang.String r0 = "android.callIsVideo"
                boolean r0 = r4.getBoolean(r0)
                r3.f3478j = r0
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 28
                if (r0 < r1) goto L30
                java.lang.String r0 = "android.callPerson"
                boolean r1 = r4.containsKey(r0)
                if (r1 == 0) goto L30
                android.os.Parcelable r0 = r4.getParcelable(r0)
                android.app.Person r0 = H.k.a(r0)
                H.r r0 = H.r.a(r0)
            L2d:
                r3.f3474f = r0
                goto L41
            L30:
                java.lang.String r0 = "android.callPersonCompat"
                boolean r1 = r4.containsKey(r0)
                if (r1 == 0) goto L41
                android.os.Bundle r0 = r4.getBundle(r0)
                H.r r0 = H.r.b(r0)
                goto L2d
            L41:
                java.lang.String r0 = "android.verificationIcon"
                boolean r1 = r4.containsKey(r0)
                if (r1 == 0) goto L56
                android.os.Parcelable r0 = r4.getParcelable(r0)
                android.graphics.drawable.Icon r0 = (android.graphics.drawable.Icon) r0
                androidx.core.graphics.drawable.IconCompat r0 = androidx.core.graphics.drawable.IconCompat.b(r0)
            L53:
                r3.f3481m = r0
                goto L67
            L56:
                java.lang.String r0 = "android.verificationIconCompat"
                boolean r1 = r4.containsKey(r0)
                if (r1 == 0) goto L67
                android.os.Bundle r0 = r4.getBundle(r0)
                androidx.core.graphics.drawable.IconCompat r0 = androidx.core.graphics.drawable.IconCompat.a(r0)
                goto L53
            L67:
                java.lang.String r0 = "android.verificationText"
                java.lang.CharSequence r0 = r4.getCharSequence(r0)
                r3.f3482n = r0
                java.lang.String r0 = "android.answerIntent"
                android.os.Parcelable r0 = r4.getParcelable(r0)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
                r3.f3475g = r0
                java.lang.String r0 = "android.declineIntent"
                android.os.Parcelable r0 = r4.getParcelable(r0)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
                r3.f3476h = r0
                java.lang.String r0 = "android.hangUpIntent"
                android.os.Parcelable r0 = r4.getParcelable(r0)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
                r3.f3477i = r0
                java.lang.String r0 = "android.answerColor"
                boolean r1 = r4.containsKey(r0)
                r2 = 0
                if (r1 == 0) goto L9f
                int r0 = r4.getInt(r0)
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto La0
            L9f:
                r0 = r2
            La0:
                r3.f3479k = r0
                java.lang.String r0 = "android.declineColor"
                boolean r1 = r4.containsKey(r0)
                if (r1 == 0) goto Lb2
                int r4 = r4.getInt(r0)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            Lb2:
                r3.f3480l = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: H.i.f.l(android.os.Bundle):void");
        }

        public ArrayList n() {
            a aVarS = s();
            a aVarR = r();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(aVarS);
            ArrayList<a> arrayList2 = this.f3495a.f3448b;
            int i8 = 2;
            if (arrayList2 != null) {
                for (a aVar : arrayList2) {
                    if (aVar.j()) {
                        arrayList.add(aVar);
                    } else if (!p(aVar) && i8 > 1) {
                        arrayList.add(aVar);
                        i8--;
                    }
                    if (aVarR != null && i8 == 1) {
                        arrayList.add(aVarR);
                        i8--;
                    }
                }
            }
            if (aVarR != null && i8 >= 1) {
                arrayList.add(aVarR);
            }
            return arrayList;
        }

        public final String o() {
            Resources resources;
            int i8;
            int i9 = this.f3473e;
            if (i9 == 1) {
                resources = this.f3495a.f3447a.getResources();
                i8 = G.f.f1979e;
            } else if (i9 == 2) {
                resources = this.f3495a.f3447a.getResources();
                i8 = G.f.f1980f;
            } else {
                if (i9 != 3) {
                    return null;
                }
                resources = this.f3495a.f3447a.getResources();
                i8 = G.f.f1981g;
            }
            return resources.getString(i8);
        }

        public final boolean p(a aVar) {
            return aVar != null && aVar.c().getBoolean("key_action_priority");
        }

        public final a q(int i8, int i9, Integer num, int i10, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(I.a.c(this.f3495a.f3447a, i10));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f3495a.f3447a.getResources().getString(i9));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            a aVarB = new a.C0040a(IconCompat.j(this.f3495a.f3447a, i8), spannableStringBuilder, pendingIntent).b();
            aVarB.c().putBoolean("key_action_priority", true);
            return aVarB;
        }

        public final a r() {
            int i8 = G.d.f1930b;
            int i9 = G.d.f1929a;
            PendingIntent pendingIntent = this.f3475g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z7 = this.f3478j;
            return q(z7 ? i8 : i9, z7 ? G.f.f1976b : G.f.f1975a, this.f3479k, G.b.f1925a, pendingIntent);
        }

        public final a s() {
            int i8;
            Integer num;
            int i9;
            int i10 = G.d.f1931c;
            PendingIntent pendingIntent = this.f3476h;
            if (pendingIntent == null) {
                i8 = G.f.f1978d;
                num = this.f3480l;
                i9 = G.b.f1926b;
                pendingIntent = this.f3477i;
            } else {
                i8 = G.f.f1977c;
                num = this.f3480l;
                i9 = G.b.f1926b;
            }
            return q(i10, i8, num, i9, pendingIntent);
        }

        public static class b {
            public static Notification.Action.Builder b(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            public static void c(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }

            public static Parcelable a(Icon icon) {
                return icon;
            }
        }

        public static class c {
            public static Notification.Builder a(Notification.Builder builder, Person person) {
                return builder.addPerson(person);
            }

            public static Parcelable b(Person person) {
                return person;
            }
        }
    }
}

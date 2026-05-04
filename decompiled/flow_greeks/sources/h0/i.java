package h0;

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
import h0.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f10792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f10793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final s[] f10794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final s[] f10795d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f10796e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f10797f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f10798g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f10799h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f10800i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f10801j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public PendingIntent f10802k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f10803l;

        /* JADX INFO: renamed from: h0.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0197a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IconCompat f10804a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CharSequence f10805b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final PendingIntent f10806c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f10807d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final Bundle f10808e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public ArrayList f10809f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f10810g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f10811h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f10812i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f10813j;

            public C0197a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public C0197a a(s sVar) {
                if (this.f10809f == null) {
                    this.f10809f = new ArrayList();
                }
                if (sVar != null) {
                    this.f10809f.add(sVar);
                }
                return this;
            }

            public a b() {
                c();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<s> arrayList3 = this.f10809f;
                if (arrayList3 != null) {
                    for (s sVar : arrayList3) {
                        if (sVar.k()) {
                            arrayList.add(sVar);
                        } else {
                            arrayList2.add(sVar);
                        }
                    }
                }
                return new a(this.f10804a, this.f10805b, this.f10806c, this.f10808e, arrayList2.isEmpty() ? null : (s[]) arrayList2.toArray(new s[arrayList2.size()]), arrayList.isEmpty() ? null : (s[]) arrayList.toArray(new s[arrayList.size()]), this.f10807d, this.f10810g, this.f10811h, this.f10812i, this.f10813j);
            }

            public final void c() {
                if (this.f10812i && this.f10806c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C0197a d(boolean z10) {
                this.f10807d = z10;
                return this;
            }

            public C0197a e(boolean z10) {
                this.f10812i = z10;
                return this;
            }

            public C0197a f(int i10) {
                this.f10810g = i10;
                return this;
            }

            public C0197a g(boolean z10) {
                this.f10811h = z10;
                return this;
            }

            public C0197a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, s[] sVarArr, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
                this.f10807d = true;
                this.f10811h = true;
                this.f10804a = iconCompat;
                this.f10805b = e.f(charSequence);
                this.f10806c = pendingIntent;
                this.f10808e = bundle;
                this.f10809f = sVarArr == null ? null : new ArrayList(Arrays.asList(sVarArr));
                this.f10807d = z10;
                this.f10810g = i10;
                this.f10811h = z11;
                this.f10812i = z12;
                this.f10813j = z13;
            }
        }

        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.k(null, "", i10) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f10802k;
        }

        public boolean b() {
            return this.f10796e;
        }

        public Bundle c() {
            return this.f10792a;
        }

        public IconCompat d() {
            int i10;
            if (this.f10793b == null && (i10 = this.f10800i) != 0) {
                this.f10793b = IconCompat.k(null, "", i10);
            }
            return this.f10793b;
        }

        public s[] e() {
            return this.f10794c;
        }

        public int f() {
            return this.f10798g;
        }

        public boolean g() {
            return this.f10797f;
        }

        public CharSequence h() {
            return this.f10801j;
        }

        public boolean i() {
            return this.f10803l;
        }

        public boolean j() {
            return this.f10799h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, s[] sVarArr, s[] sVarArr2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
            this.f10797f = true;
            this.f10793b = iconCompat;
            if (iconCompat != null && iconCompat.o() == 2) {
                this.f10800i = iconCompat.m();
            }
            this.f10801j = e.f(charSequence);
            this.f10802k = pendingIntent;
            this.f10792a = bundle == null ? new Bundle() : bundle;
            this.f10794c = sVarArr;
            this.f10795d = sVarArr2;
            this.f10796e = z10;
            this.f10798g = i10;
            this.f10797f = z11;
            this.f10799h = z12;
            this.f10803l = z13;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public IconCompat f10814e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public IconCompat f10815f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f10816g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f10817h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f10818i;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* JADX INFO: renamed from: h0.i$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0198b {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z10) {
                bigPictureStyle.showBigPictureWhenCollapsed(z10);
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

        @Override // h0.i.j
        public void b(h0.h hVar) {
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(hVar.a()).setBigContentTitle(this.f10869b);
            IconCompat iconCompat = this.f10814e;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    C0198b.a(bigContentTitle, this.f10814e.v(hVar instanceof k ? ((k) hVar).f() : null));
                } else if (iconCompat.o() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f10814e.l());
                }
            }
            if (this.f10816g) {
                if (this.f10815f == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    a.a(bigContentTitle, this.f10815f.v(hVar instanceof k ? ((k) hVar).f() : null));
                }
            }
            if (this.f10871d) {
                bigContentTitle.setSummaryText(this.f10870c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                C0198b.c(bigContentTitle, this.f10818i);
                C0198b.b(bigContentTitle, this.f10817h);
            }
        }

        @Override // h0.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @Override // h0.i.j
        public void l(Bundle bundle) {
            super.l(bundle);
            if (bundle.containsKey("android.largeIcon.big")) {
                this.f10815f = n(bundle.getParcelable("android.largeIcon.big"));
                this.f10816g = true;
            }
            this.f10814e = q(bundle);
            this.f10818i = bundle.getBoolean("android.showBigPictureWhenCollapsed");
        }

        public b o(Bitmap bitmap) {
            this.f10815f = bitmap == null ? null : IconCompat.f(bitmap);
            this.f10816g = true;
            return this;
        }

        public b p(Bitmap bitmap) {
            this.f10814e = bitmap == null ? null : IconCompat.f(bitmap);
            return this;
        }

        public b r(CharSequence charSequence) {
            this.f10869b = e.f(charSequence);
            return this;
        }

        public b s(CharSequence charSequence) {
            this.f10870c = e.f(charSequence);
            this.f10871d = true;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f10819e;

        @Override // h0.i.j
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // h0.i.j
        public void b(h0.h hVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(hVar.a()).setBigContentTitle(this.f10869b).bigText(this.f10819e);
            if (this.f10871d) {
                bigTextStyleBigText.setSummaryText(this.f10870c);
            }
        }

        @Override // h0.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // h0.i.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f10819e = bundle.getCharSequence("android.bigText");
        }

        public c n(CharSequence charSequence) {
            this.f10819e = e.f(charSequence);
            return this;
        }

        public c o(CharSequence charSequence) {
            this.f10869b = e.f(charSequence);
            return this;
        }

        public c p(CharSequence charSequence) {
            this.f10870c = e.f(charSequence);
            this.f10871d = true;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g extends j {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {
            public static Notification.Style a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        @Override // h0.i.j
        public void b(h0.h hVar) {
            hVar.a().setStyle(a.a());
        }

        @Override // h0.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // h0.i.j
        public RemoteViews i(h0.h hVar) {
            return null;
        }

        @Override // h0.i.j
        public RemoteViews j(h0.h hVar) {
            return null;
        }

        @Override // h0.i.j
        public RemoteViews k(h0.h hVar) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class h extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList f10856e = new ArrayList();

        @Override // h0.i.j
        public void b(h0.h hVar) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(hVar.a()).setBigContentTitle(this.f10869b);
            if (this.f10871d) {
                bigContentTitle.setSummaryText(this.f10870c);
            }
            Iterator it = this.f10856e.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine((CharSequence) it.next());
            }
        }

        @Override // h0.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @Override // h0.i.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f10856e.clear();
            if (bundle.containsKey("android.textLines")) {
                Collections.addAll(this.f10856e, bundle.getCharSequenceArray("android.textLines"));
            }
        }

        public h n(CharSequence charSequence) {
            if (charSequence != null) {
                this.f10856e.add(e.f(charSequence));
            }
            return this;
        }

        public h o(CharSequence charSequence) {
            this.f10869b = e.f(charSequence);
            return this;
        }

        public h p(CharSequence charSequence) {
            this.f10870c = e.f(charSequence);
            this.f10871d = true;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f10868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f10869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f10870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10871d = false;

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
                    return new C0199i();
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
                return new C0199i();
            }
            if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                return new g();
            }
            return null;
        }

        public static j e(Bundle bundle) {
            j jVarC = c(bundle.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
            return jVarC != null ? jVarC : (bundle.containsKey("android.selfDisplayName") || bundle.containsKey("android.messagingStyleUser")) ? new C0199i() : (bundle.containsKey("android.picture") || bundle.containsKey("android.pictureIcon")) ? new b() : bundle.containsKey("android.bigText") ? new c() : bundle.containsKey("android.textLines") ? new h() : bundle.containsKey("android.callType") ? new f() : d(bundle.getString("android.template"));
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
            if (this.f10871d) {
                bundle.putCharSequence("android.summaryText", this.f10870c);
            }
            CharSequence charSequence = this.f10869b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strH = h();
            if (strH != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strH);
            }
        }

        public abstract void b(h0.h hVar);

        public String h() {
            return null;
        }

        public RemoteViews i(h0.h hVar) {
            return null;
        }

        public RemoteViews j(h0.h hVar) {
            return null;
        }

        public RemoteViews k(h0.h hVar) {
            return null;
        }

        public void l(Bundle bundle) {
            if (bundle.containsKey("android.summaryText")) {
                this.f10870c = bundle.getCharSequence("android.summaryText");
                this.f10871d = true;
            }
            this.f10869b = bundle.getCharSequence("android.title.big");
        }

        public void m(e eVar) {
            if (this.f10868a != eVar) {
                this.f10868a = eVar;
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
        int dimensionPixelSize = resources.getDimensionPixelSize(g0.c.f9872b);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(g0.c.f9871a);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
    }

    /* JADX INFO: renamed from: h0.i$i, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0199i extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f10857e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f10858f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public q f10859g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f10860h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Boolean f10861i;

        /* JADX INFO: renamed from: h0.i$i$a */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

        /* JADX INFO: renamed from: h0.i$i$b */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class b {
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        /* JADX INFO: renamed from: h0.i$i$c */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class c {
            public static Notification.MessagingStyle a(Person person) {
                return new Notification.MessagingStyle(person);
            }

            public static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z10) {
                return messagingStyle.setGroupConversation(z10);
            }
        }

        public C0199i() {
        }

        public static C0199i o(Notification notification) {
            j jVarG = j.g(notification);
            if (jVarG instanceof C0199i) {
                return (C0199i) jVarG;
            }
            return null;
        }

        @Override // h0.i.j
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.f10859g.e());
            bundle.putBundle("android.messagingStyleUser", this.f10859g.k());
            bundle.putCharSequence("android.hiddenConversationTitle", this.f10860h);
            if (this.f10860h != null && this.f10861i.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.f10860h);
            }
            if (!this.f10857e.isEmpty()) {
                bundle.putParcelableArray("android.messages", d.a(this.f10857e));
            }
            if (!this.f10858f.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", d.a(this.f10858f));
            }
            Boolean bool = this.f10861i;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        @Override // h0.i.j
        public void b(h0.h hVar) {
            u(s());
            Notification.MessagingStyle messagingStyleA = Build.VERSION.SDK_INT >= 28 ? c.a(this.f10859g.j()) : a.b(this.f10859g.e());
            Iterator it = this.f10857e.iterator();
            while (it.hasNext()) {
                a.a(messagingStyleA, ((d) it.next()).k());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Iterator it2 = this.f10858f.iterator();
                while (it2.hasNext()) {
                    b.a(messagingStyleA, ((d) it2.next()).k());
                }
            }
            if (this.f10861i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                a.c(messagingStyleA, this.f10860h);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                c.b(messagingStyleA, this.f10861i.booleanValue());
            }
            messagingStyleA.setBuilder(hVar.a());
        }

        @Override // h0.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        @Override // h0.i.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f10857e.clear();
            if (bundle.containsKey("android.messagingStyleUser")) {
                this.f10859g = q.b(bundle.getBundle("android.messagingStyleUser"));
            } else {
                this.f10859g = new q.b().f(bundle.getString("android.selfDisplayName")).a();
            }
            CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
            this.f10860h = charSequence;
            if (charSequence == null) {
                this.f10860h = bundle.getCharSequence("android.hiddenConversationTitle");
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
            if (parcelableArray != null) {
                this.f10857e.addAll(d.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
            if (parcelableArray2 != null) {
                this.f10858f.addAll(d.f(parcelableArray2));
            }
            if (bundle.containsKey("android.isGroupConversation")) {
                this.f10861i = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
            }
        }

        public C0199i n(d dVar) {
            if (dVar != null) {
                this.f10857e.add(dVar);
                if (this.f10857e.size() > 25) {
                    this.f10857e.remove(0);
                }
            }
            return this;
        }

        public CharSequence p() {
            return this.f10860h;
        }

        public List q() {
            return this.f10857e;
        }

        public q r() {
            return this.f10859g;
        }

        public boolean s() {
            e eVar = this.f10868a;
            if (eVar != null && eVar.f10820a.getApplicationInfo().targetSdkVersion < 28 && this.f10861i == null) {
                return this.f10860h != null;
            }
            Boolean bool = this.f10861i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public C0199i t(CharSequence charSequence) {
            this.f10860h = charSequence;
            return this;
        }

        public C0199i u(boolean z10) {
            this.f10861i = Boolean.valueOf(z10);
            return this;
        }

        public C0199i(q qVar) {
            if (!TextUtils.isEmpty(qVar.e())) {
                this.f10859g = qVar;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        /* JADX INFO: renamed from: h0.i$i$d */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CharSequence f10862a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f10863b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final q f10864c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Bundle f10865d = new Bundle();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f10866e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Uri f10867f;

            /* JADX INFO: renamed from: h0.i$i$d$a */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static class a {
                public static Notification.MessagingStyle.Message a(CharSequence charSequence, long j10, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j10, charSequence2);
                }

                public static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            public d(CharSequence charSequence, long j10, q qVar) {
                this.f10862a = charSequence;
                this.f10863b = j10;
                this.f10864c = qVar;
            }

            public static Bundle[] a(List list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    bundleArr[i10] = ((d) list.get(i10)).l();
                }
                return bundleArr;
            }

            public static d e(Bundle bundle) {
                try {
                    if (bundle.containsKey("text") && bundle.containsKey(com.amazon.a.a.h.a.f4275b)) {
                        d dVar = new d(bundle.getCharSequence("text"), bundle.getLong(com.amazon.a.a.h.a.f4275b), bundle.containsKey("person") ? q.b(bundle.getBundle("person")) : (!bundle.containsKey("sender_person") || Build.VERSION.SDK_INT < 28) ? bundle.containsKey("sender") ? new q.b().f(bundle.getCharSequence("sender")).a() : null : q.a(h0.j.a(bundle.getParcelable("sender_person"))));
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
                return this.f10866e;
            }

            public Uri c() {
                return this.f10867f;
            }

            public Bundle d() {
                return this.f10865d;
            }

            public q g() {
                return this.f10864c;
            }

            public CharSequence h() {
                return this.f10862a;
            }

            public long i() {
                return this.f10863b;
            }

            public d j(String str, Uri uri) {
                this.f10866e = str;
                this.f10867f = uri;
                return this;
            }

            public Notification.MessagingStyle.Message k() {
                Notification.MessagingStyle.Message messageA;
                q qVarG = g();
                if (Build.VERSION.SDK_INT >= 28) {
                    messageA = b.b(h(), i(), qVarG != null ? qVarG.j() : null);
                } else {
                    messageA = a.a(h(), i(), qVarG != null ? qVarG.e() : null);
                }
                if (b() != null) {
                    a.b(messageA, b(), c());
                }
                return messageA;
            }

            public final Bundle l() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f10862a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong(com.amazon.a.a.h.a.f4275b, this.f10863b);
                q qVar = this.f10864c;
                if (qVar != null) {
                    bundle.putCharSequence("sender", qVar.e());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", b.a(this.f10864c.j()));
                    } else {
                        bundle.putBundle("person", this.f10864c.k());
                    }
                }
                String str = this.f10866e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f10867f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.f10865d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            /* JADX INFO: renamed from: h0.i$i$d$b */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static class b {
                public static Notification.MessagingStyle.Message b(CharSequence charSequence, long j10, Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j10, person);
                }

                public static Parcelable a(Person person) {
                    return person;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e {
        public boolean A;
        public boolean B;
        public boolean C;
        public String D;
        public Bundle E;
        public int F;
        public int G;
        public Notification H;
        public RemoteViews I;
        public RemoteViews J;
        public RemoteViews K;
        public String L;
        public int M;
        public String N;
        public long O;
        public int P;
        public int Q;
        public boolean R;
        public Notification S;
        public boolean T;
        public Object U;
        public ArrayList V;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f10820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f10821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f10822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f10823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f10824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f10825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f10826g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f10827h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RemoteViews f10828i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public IconCompat f10829j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f10830k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f10831l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f10832m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f10833n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f10834o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f10835p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public j f10836q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public CharSequence f10837r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public CharSequence f10838s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public CharSequence[] f10839t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f10840u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f10841v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f10842w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f10843x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f10844y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f10845z;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {
            public static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            public static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i10) {
                return builder.setContentType(i10);
            }

            public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i10) {
                return builder.setUsage(i10);
            }
        }

        public e(Context context, String str) {
            this.f10821b = new ArrayList();
            this.f10822c = new ArrayList();
            this.f10823d = new ArrayList();
            this.f10833n = true;
            this.A = false;
            this.F = 0;
            this.G = 0;
            this.M = 0;
            this.P = 0;
            this.Q = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.f10820a = context;
            this.L = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.f10832m = 0;
            this.V = new ArrayList();
            this.R = true;
        }

        public static CharSequence f(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public e A(boolean z10) {
            r(2, z10);
            return this;
        }

        public e B(boolean z10) {
            r(8, z10);
            return this;
        }

        public e C(int i10) {
            this.f10832m = i10;
            return this;
        }

        public e D(int i10, int i11, boolean z10) {
            this.f10840u = i10;
            this.f10841v = i11;
            this.f10842w = z10;
            return this;
        }

        public e E(String str) {
            this.N = str;
            return this;
        }

        public e F(boolean z10) {
            this.f10833n = z10;
            return this;
        }

        public e G(boolean z10) {
            this.T = z10;
            return this;
        }

        public e H(int i10) {
            this.S.icon = i10;
            return this;
        }

        public e I(Uri uri) {
            Notification notification = this.S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder builderD = a.d(a.c(a.b(), 4), 5);
            this.S.audioAttributes = a.a(builderD);
            return this;
        }

        public e J(j jVar) {
            if (this.f10836q != jVar) {
                this.f10836q = jVar;
                if (jVar != null) {
                    jVar.m(this);
                }
            }
            return this;
        }

        public e K(CharSequence charSequence) {
            this.f10837r = f(charSequence);
            return this;
        }

        public e L(CharSequence charSequence) {
            this.S.tickerText = f(charSequence);
            return this;
        }

        public e M(long j10) {
            this.O = j10;
            return this;
        }

        public e N(boolean z10) {
            this.f10834o = z10;
            return this;
        }

        public e O(long[] jArr) {
            this.S.vibrate = jArr;
            return this;
        }

        public e P(int i10) {
            this.G = i10;
            return this;
        }

        public e Q(long j10) {
            this.S.when = j10;
            return this;
        }

        public e a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f10821b.add(new a(i10, charSequence, pendingIntent));
            return this;
        }

        public e b(a aVar) {
            if (aVar != null) {
                this.f10821b.add(aVar);
            }
            return this;
        }

        public e c(a aVar) {
            if (aVar != null) {
                this.f10823d.add(aVar);
            }
            return this;
        }

        public Notification d() {
            return new k(this).c();
        }

        public Bundle e() {
            if (this.E == null) {
                this.E = new Bundle();
            }
            return this.E;
        }

        public e g(boolean z10) {
            r(16, z10);
            return this;
        }

        public e h(String str) {
            this.D = str;
            return this;
        }

        public e i(String str) {
            this.L = str;
            return this;
        }

        public e j(boolean z10) {
            this.f10835p = z10;
            e().putBoolean("android.chronometerCountDown", z10);
            return this;
        }

        public e k(int i10) {
            this.F = i10;
            return this;
        }

        public e l(boolean z10) {
            this.B = z10;
            this.C = true;
            return this;
        }

        public e m(PendingIntent pendingIntent) {
            this.f10826g = pendingIntent;
            return this;
        }

        public e n(CharSequence charSequence) {
            this.f10825f = f(charSequence);
            return this;
        }

        public e o(CharSequence charSequence) {
            this.f10824e = f(charSequence);
            return this;
        }

        public e p(int i10) {
            Notification notification = this.S;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e q(PendingIntent pendingIntent) {
            this.S.deleteIntent = pendingIntent;
            return this;
        }

        public final void r(int i10, boolean z10) {
            if (z10) {
                Notification notification = this.S;
                notification.flags = i10 | notification.flags;
            } else {
                Notification notification2 = this.S;
                notification2.flags = (~i10) & notification2.flags;
            }
        }

        public e s(PendingIntent pendingIntent, boolean z10) {
            this.f10827h = pendingIntent;
            r(128, z10);
            return this;
        }

        public e t(String str) {
            this.f10843x = str;
            return this;
        }

        public e u(int i10) {
            this.P = i10;
            return this;
        }

        public e v(boolean z10) {
            this.f10844y = z10;
            return this;
        }

        public e w(Bitmap bitmap) {
            this.f10829j = bitmap == null ? null : IconCompat.f(i.b(this.f10820a, bitmap));
            return this;
        }

        public e x(int i10, int i11, int i12) {
            Notification notification = this.S;
            notification.ledARGB = i10;
            notification.ledOnMS = i11;
            notification.ledOffMS = i12;
            notification.flags = ((i11 == 0 || i12 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public e y(boolean z10) {
            this.A = z10;
            return this;
        }

        public e z(int i10) {
            this.f10831l = i10;
            return this;
        }

        public e(Context context) {
            this(context, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10846e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public q f10847f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f10848g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f10849h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PendingIntent f10850i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f10851j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f10852k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Integer f10853l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public IconCompat f10854m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public CharSequence f10855n;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {
            public static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }

            public static Notification.Builder b(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

            public static Notification.CallStyle d(Notification.CallStyle callStyle, int i10) {
                return callStyle.setAnswerButtonColorHint(i10);
            }

            public static Notification.CallStyle e(Notification.CallStyle callStyle, int i10) {
                return callStyle.setDeclineButtonColorHint(i10);
            }

            public static Notification.CallStyle f(Notification.CallStyle callStyle, boolean z10) {
                return callStyle.setIsVideo(z10);
            }

            public static Notification.CallStyle g(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            public static Notification.CallStyle h(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        @Override // h0.i.j
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt("android.callType", this.f10846e);
            bundle.putBoolean("android.callIsVideo", this.f10851j);
            q qVar = this.f10847f;
            if (qVar != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable("android.callPerson", c.b(qVar.j()));
                } else {
                    bundle.putParcelable("android.callPersonCompat", qVar.k());
                }
            }
            IconCompat iconCompat = this.f10854m;
            if (iconCompat != null) {
                bundle.putParcelable("android.verificationIcon", b.a(iconCompat.v(this.f10868a.f10820a)));
            }
            bundle.putCharSequence("android.verificationText", this.f10855n);
            bundle.putParcelable("android.answerIntent", this.f10848g);
            bundle.putParcelable("android.declineIntent", this.f10849h);
            bundle.putParcelable("android.hangUpIntent", this.f10850i);
            Integer num = this.f10852k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f10853l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // h0.i.j
        public void b(h0.h hVar) {
            int i10 = Build.VERSION.SDK_INT;
            CharSequence charSequenceO = null;
            callStyleA = null;
            Notification.CallStyle callStyleA = null;
            charSequenceO = null;
            if (i10 < 31) {
                Notification.Builder builderA = hVar.a();
                q qVar = this.f10847f;
                builderA.setContentTitle(qVar != null ? qVar.e() : null);
                Bundle bundle = this.f10868a.E;
                if (bundle != null && bundle.containsKey("android.text")) {
                    charSequenceO = this.f10868a.E.getCharSequence("android.text");
                }
                if (charSequenceO == null) {
                    charSequenceO = o();
                }
                builderA.setContentText(charSequenceO);
                q qVar2 = this.f10847f;
                if (qVar2 != null) {
                    if (qVar2.c() != null) {
                        b.b(builderA, this.f10847f.c().v(this.f10868a.f10820a));
                    }
                    if (i10 >= 28) {
                        c.a(builderA, this.f10847f.j());
                    } else {
                        a.a(builderA, this.f10847f.f());
                    }
                }
                a.b(builderA, "call");
                return;
            }
            int i11 = this.f10846e;
            if (i11 == 1) {
                callStyleA = d.a(this.f10847f.j(), this.f10849h, this.f10848g);
            } else if (i11 == 2) {
                callStyleA = d.b(this.f10847f.j(), this.f10850i);
            } else if (i11 == 3) {
                callStyleA = d.c(this.f10847f.j(), this.f10850i, this.f10848g);
            } else if (Log.isLoggable("NotifCompat", 3)) {
                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f10846e));
            }
            if (callStyleA != null) {
                callStyleA.setBuilder(hVar.a());
                Integer num = this.f10852k;
                if (num != null) {
                    d.d(callStyleA, num.intValue());
                }
                Integer num2 = this.f10853l;
                if (num2 != null) {
                    d.e(callStyleA, num2.intValue());
                }
                d.h(callStyleA, this.f10855n);
                IconCompat iconCompat = this.f10854m;
                if (iconCompat != null) {
                    d.g(callStyleA, iconCompat.v(this.f10868a.f10820a));
                }
                d.f(callStyleA, this.f10851j);
            }
        }

        @Override // h0.i.j
        public String h() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        @Override // h0.i.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f10846e = bundle.getInt("android.callType");
            this.f10851j = bundle.getBoolean("android.callIsVideo");
            if (Build.VERSION.SDK_INT >= 28 && bundle.containsKey("android.callPerson")) {
                this.f10847f = q.a(h0.j.a(bundle.getParcelable("android.callPerson")));
            } else if (bundle.containsKey("android.callPersonCompat")) {
                this.f10847f = q.b(bundle.getBundle("android.callPersonCompat"));
            }
            if (bundle.containsKey("android.verificationIcon")) {
                this.f10854m = IconCompat.b((Icon) bundle.getParcelable("android.verificationIcon"));
            } else if (bundle.containsKey("android.verificationIconCompat")) {
                this.f10854m = IconCompat.a(bundle.getBundle("android.verificationIconCompat"));
            }
            this.f10855n = bundle.getCharSequence("android.verificationText");
            this.f10848g = (PendingIntent) bundle.getParcelable("android.answerIntent");
            this.f10849h = (PendingIntent) bundle.getParcelable("android.declineIntent");
            this.f10850i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
            this.f10852k = bundle.containsKey("android.answerColor") ? Integer.valueOf(bundle.getInt("android.answerColor")) : null;
            this.f10853l = bundle.containsKey("android.declineColor") ? Integer.valueOf(bundle.getInt("android.declineColor")) : null;
        }

        public ArrayList n() {
            a aVarS = s();
            a aVarR = r();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(aVarS);
            ArrayList<a> arrayList2 = this.f10868a.f10821b;
            int i10 = 2;
            if (arrayList2 != null) {
                for (a aVar : arrayList2) {
                    if (aVar.j()) {
                        arrayList.add(aVar);
                    } else if (!p(aVar) && i10 > 1) {
                        arrayList.add(aVar);
                        i10--;
                    }
                    if (aVarR != null && i10 == 1) {
                        arrayList.add(aVarR);
                        i10--;
                    }
                }
            }
            if (aVarR != null && i10 >= 1) {
                arrayList.add(aVarR);
            }
            return arrayList;
        }

        public final String o() {
            int i10 = this.f10846e;
            if (i10 == 1) {
                return this.f10868a.f10820a.getResources().getString(g0.f.f9906e);
            }
            if (i10 == 2) {
                return this.f10868a.f10820a.getResources().getString(g0.f.f9907f);
            }
            if (i10 != 3) {
                return null;
            }
            return this.f10868a.f10820a.getResources().getString(g0.f.f9908g);
        }

        public final boolean p(a aVar) {
            return aVar != null && aVar.c().getBoolean("key_action_priority");
        }

        public final a q(int i10, int i11, Integer num, int i12, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(i0.a.d(this.f10868a.f10820a, i12));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f10868a.f10820a.getResources().getString(i11));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            a aVarB = new a.C0197a(IconCompat.j(this.f10868a.f10820a, i10), spannableStringBuilder, pendingIntent).b();
            aVarB.c().putBoolean("key_action_priority", true);
            return aVarB;
        }

        public final a r() {
            int i10 = g0.d.f9874b;
            int i11 = g0.d.f9873a;
            PendingIntent pendingIntent = this.f10848g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z10 = this.f10851j;
            return q(z10 ? i10 : i11, z10 ? g0.f.f9903b : g0.f.f9902a, this.f10852k, g0.b.f9869a, pendingIntent);
        }

        public final a s() {
            int i10 = g0.d.f9875c;
            PendingIntent pendingIntent = this.f10849h;
            return pendingIntent == null ? q(i10, g0.f.f9905d, this.f10853l, g0.b.f9870b, this.f10850i) : q(i10, g0.f.f9904c, this.f10853l, g0.b.f9870b, pendingIntent);
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class b {
            public static void b(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }

            public static Parcelable a(Icon icon) {
                return icon;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

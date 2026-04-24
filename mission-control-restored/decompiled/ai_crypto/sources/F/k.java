package F;

import F.t;
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
public abstract class k {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f1712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f1713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final v[] f1714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final v[] f1715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1716e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1717f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f1718g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f1719h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1720i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f1721j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public PendingIntent f1722k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f1723l;

        /* JADX INFO: renamed from: F.k$a$a, reason: collision with other inner class name */
        public static final class C0013a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IconCompat f1724a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CharSequence f1725b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final PendingIntent f1726c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f1727d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final Bundle f1728e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public ArrayList f1729f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f1730g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f1731h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f1732i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f1733j;

            public C0013a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public C0013a a(v vVar) {
                if (this.f1729f == null) {
                    this.f1729f = new ArrayList();
                }
                if (vVar != null) {
                    this.f1729f.add(vVar);
                }
                return this;
            }

            public a b() {
                c();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<v> arrayList3 = this.f1729f;
                if (arrayList3 != null) {
                    for (v vVar : arrayList3) {
                        if (vVar.k()) {
                            arrayList.add(vVar);
                        } else {
                            arrayList2.add(vVar);
                        }
                    }
                }
                return new a(this.f1724a, this.f1725b, this.f1726c, this.f1728e, arrayList2.isEmpty() ? null : (v[]) arrayList2.toArray(new v[arrayList2.size()]), arrayList.isEmpty() ? null : (v[]) arrayList.toArray(new v[arrayList.size()]), this.f1727d, this.f1730g, this.f1731h, this.f1732i, this.f1733j);
            }

            public final void c() {
                if (this.f1732i && this.f1726c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C0013a d(boolean z7) {
                this.f1727d = z7;
                return this;
            }

            public C0013a e(boolean z7) {
                this.f1732i = z7;
                return this;
            }

            public C0013a f(boolean z7) {
                this.f1731h = z7;
                return this;
            }

            public C0013a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, v[] vVarArr, boolean z7, int i7, boolean z8, boolean z9, boolean z10) {
                this.f1727d = true;
                this.f1731h = true;
                this.f1724a = iconCompat;
                this.f1725b = e.e(charSequence);
                this.f1726c = pendingIntent;
                this.f1728e = bundle;
                this.f1729f = vVarArr == null ? null : new ArrayList(Arrays.asList(vVarArr));
                this.f1727d = z7;
                this.f1730g = i7;
                this.f1731h = z8;
                this.f1732i = z9;
                this.f1733j = z10;
            }
        }

        public a(int i7, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i7 != 0 ? IconCompat.k(null, "", i7) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f1722k;
        }

        public boolean b() {
            return this.f1716e;
        }

        public Bundle c() {
            return this.f1712a;
        }

        public IconCompat d() {
            int i7;
            if (this.f1713b == null && (i7 = this.f1720i) != 0) {
                this.f1713b = IconCompat.k(null, "", i7);
            }
            return this.f1713b;
        }

        public v[] e() {
            return this.f1714c;
        }

        public int f() {
            return this.f1718g;
        }

        public boolean g() {
            return this.f1717f;
        }

        public CharSequence h() {
            return this.f1721j;
        }

        public boolean i() {
            return this.f1723l;
        }

        public boolean j() {
            return this.f1719h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, v[] vVarArr, v[] vVarArr2, boolean z7, int i7, boolean z8, boolean z9, boolean z10) {
            this.f1717f = true;
            this.f1713b = iconCompat;
            if (iconCompat != null && iconCompat.o() == 2) {
                this.f1720i = iconCompat.m();
            }
            this.f1721j = e.e(charSequence);
            this.f1722k = pendingIntent;
            this.f1712a = bundle == null ? new Bundle() : bundle;
            this.f1714c = vVarArr;
            this.f1715d = vVarArr2;
            this.f1716e = z7;
            this.f1718g = i7;
            this.f1717f = z8;
            this.f1719h = z9;
            this.f1723l = z10;
        }
    }

    public static class b extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public IconCompat f1734e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public IconCompat f1735f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f1736g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f1737h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f1738i;

        public static class a {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* JADX INFO: renamed from: F.k$b$b, reason: collision with other inner class name */
        public static class C0014b {
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

        @Override // F.k.j
        public void b(F.j jVar) {
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(jVar.a()).setBigContentTitle(this.f1811b);
            IconCompat iconCompat = this.f1734e;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    C0014b.a(bigContentTitle, this.f1734e.v(jVar instanceof n ? ((n) jVar).f() : null));
                } else if (iconCompat.o() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f1734e.l());
                }
            }
            if (this.f1736g) {
                if (this.f1735f == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    a.a(bigContentTitle, this.f1735f.v(jVar instanceof n ? ((n) jVar).f() : null));
                }
            }
            if (this.f1813d) {
                bigContentTitle.setSummaryText(this.f1812c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                C0014b.c(bigContentTitle, this.f1738i);
                C0014b.b(bigContentTitle, this.f1737h);
            }
        }

        @Override // F.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @Override // F.k.j
        public void l(Bundle bundle) {
            super.l(bundle);
            if (bundle.containsKey("android.largeIcon.big")) {
                this.f1735f = n(bundle.getParcelable("android.largeIcon.big"));
                this.f1736g = true;
            }
            this.f1734e = q(bundle);
            this.f1738i = bundle.getBoolean("android.showBigPictureWhenCollapsed");
        }

        public b o(Bitmap bitmap) {
            this.f1735f = bitmap == null ? null : IconCompat.f(bitmap);
            this.f1736g = true;
            return this;
        }

        public b p(Bitmap bitmap) {
            this.f1734e = bitmap == null ? null : IconCompat.f(bitmap);
            return this;
        }

        public b r(CharSequence charSequence) {
            this.f1811b = e.e(charSequence);
            return this;
        }

        public b s(CharSequence charSequence) {
            this.f1812c = e.e(charSequence);
            this.f1813d = true;
            return this;
        }
    }

    public static class c extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f1739e;

        @Override // F.k.j
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // F.k.j
        public void b(F.j jVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(jVar.a()).setBigContentTitle(this.f1811b).bigText(this.f1739e);
            if (this.f1813d) {
                bigTextStyleBigText.setSummaryText(this.f1812c);
            }
        }

        @Override // F.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // F.k.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f1739e = bundle.getCharSequence("android.bigText");
        }

        public c n(CharSequence charSequence) {
            this.f1739e = e.e(charSequence);
            return this;
        }

        public c o(CharSequence charSequence) {
            this.f1811b = e.e(charSequence);
            return this;
        }

        public c p(CharSequence charSequence) {
            this.f1812c = e.e(charSequence);
            this.f1813d = true;
            return this;
        }
    }

    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    public static class g extends j {

        public static class a {
            public static Notification.Style a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        @Override // F.k.j
        public void b(F.j jVar) {
            jVar.a().setStyle(a.a());
        }

        @Override // F.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // F.k.j
        public RemoteViews i(F.j jVar) {
            return null;
        }

        @Override // F.k.j
        public RemoteViews j(F.j jVar) {
            return null;
        }

        @Override // F.k.j
        public RemoteViews k(F.j jVar) {
            return null;
        }
    }

    public static class h extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList f1798e = new ArrayList();

        @Override // F.k.j
        public void b(F.j jVar) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(jVar.a()).setBigContentTitle(this.f1811b);
            if (this.f1813d) {
                bigContentTitle.setSummaryText(this.f1812c);
            }
            Iterator it = this.f1798e.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine((CharSequence) it.next());
            }
        }

        @Override // F.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @Override // F.k.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f1798e.clear();
            if (bundle.containsKey("android.textLines")) {
                Collections.addAll(this.f1798e, bundle.getCharSequenceArray("android.textLines"));
            }
        }

        public h n(CharSequence charSequence) {
            if (charSequence != null) {
                this.f1798e.add(e.e(charSequence));
            }
            return this;
        }

        public h o(CharSequence charSequence) {
            this.f1811b = e.e(charSequence);
            return this;
        }

        public h p(CharSequence charSequence) {
            this.f1812c = e.e(charSequence);
            this.f1813d = true;
            return this;
        }
    }

    public static abstract class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f1810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f1811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f1812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1813d = false;

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
                    return new i();
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
                return new i();
            }
            if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                return new g();
            }
            return null;
        }

        public static j e(Bundle bundle) {
            j jVarC = c(bundle.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
            return jVarC != null ? jVarC : (bundle.containsKey("android.selfDisplayName") || bundle.containsKey("android.messagingStyleUser")) ? new i() : (bundle.containsKey("android.picture") || bundle.containsKey("android.pictureIcon")) ? new b() : bundle.containsKey("android.bigText") ? new c() : bundle.containsKey("android.textLines") ? new h() : bundle.containsKey("android.callType") ? new f() : d(bundle.getString("android.template"));
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
            Bundle bundleA = k.a(notification);
            if (bundleA == null) {
                return null;
            }
            return f(bundleA);
        }

        public void a(Bundle bundle) {
            if (this.f1813d) {
                bundle.putCharSequence("android.summaryText", this.f1812c);
            }
            CharSequence charSequence = this.f1811b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strH = h();
            if (strH != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strH);
            }
        }

        public abstract void b(F.j jVar);

        public String h() {
            return null;
        }

        public RemoteViews i(F.j jVar) {
            return null;
        }

        public RemoteViews j(F.j jVar) {
            return null;
        }

        public RemoteViews k(F.j jVar) {
            return null;
        }

        public void l(Bundle bundle) {
            if (bundle.containsKey("android.summaryText")) {
                this.f1812c = bundle.getCharSequence("android.summaryText");
                this.f1813d = true;
            }
            this.f1811b = bundle.getCharSequence("android.title.big");
        }

        public void m(e eVar) {
            if (this.f1810a != eVar) {
                this.f1810a = eVar;
                if (eVar != null) {
                    eVar.I(this);
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
        int dimensionPixelSize = resources.getDimensionPixelSize(E.c.f1492b);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(E.c.f1491a);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
    }

    public static class i extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f1799e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f1800f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public t f1801g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f1802h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Boolean f1803i;

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

        public static class b {
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        public static class c {
            public static Notification.MessagingStyle a(Person person) {
                return new Notification.MessagingStyle(person);
            }

            public static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z7) {
                return messagingStyle.setGroupConversation(z7);
            }
        }

        public i() {
        }

        public static i o(Notification notification) {
            j jVarG = j.g(notification);
            if (jVarG instanceof i) {
                return (i) jVarG;
            }
            return null;
        }

        @Override // F.k.j
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.f1801g.e());
            bundle.putBundle("android.messagingStyleUser", this.f1801g.k());
            bundle.putCharSequence("android.hiddenConversationTitle", this.f1802h);
            if (this.f1802h != null && this.f1803i.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.f1802h);
            }
            if (!this.f1799e.isEmpty()) {
                bundle.putParcelableArray("android.messages", d.a(this.f1799e));
            }
            if (!this.f1800f.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", d.a(this.f1800f));
            }
            Boolean bool = this.f1803i;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        @Override // F.k.j
        public void b(F.j jVar) {
            u(s());
            Notification.MessagingStyle messagingStyleA = Build.VERSION.SDK_INT >= 28 ? c.a(this.f1801g.j()) : a.b(this.f1801g.e());
            Iterator it = this.f1799e.iterator();
            while (it.hasNext()) {
                a.a(messagingStyleA, ((d) it.next()).k());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Iterator it2 = this.f1800f.iterator();
                while (it2.hasNext()) {
                    b.a(messagingStyleA, ((d) it2.next()).k());
                }
            }
            if (this.f1803i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                a.c(messagingStyleA, this.f1802h);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                c.b(messagingStyleA, this.f1803i.booleanValue());
            }
            messagingStyleA.setBuilder(jVar.a());
        }

        @Override // F.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        @Override // F.k.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f1799e.clear();
            if (bundle.containsKey("android.messagingStyleUser")) {
                this.f1801g = t.b(bundle.getBundle("android.messagingStyleUser"));
            } else {
                this.f1801g = new t.b().f(bundle.getString("android.selfDisplayName")).a();
            }
            CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
            this.f1802h = charSequence;
            if (charSequence == null) {
                this.f1802h = bundle.getCharSequence("android.hiddenConversationTitle");
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
            if (parcelableArray != null) {
                this.f1799e.addAll(d.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
            if (parcelableArray2 != null) {
                this.f1800f.addAll(d.f(parcelableArray2));
            }
            if (bundle.containsKey("android.isGroupConversation")) {
                this.f1803i = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
            }
        }

        public i n(d dVar) {
            if (dVar != null) {
                this.f1799e.add(dVar);
                if (this.f1799e.size() > 25) {
                    this.f1799e.remove(0);
                }
            }
            return this;
        }

        public CharSequence p() {
            return this.f1802h;
        }

        public List q() {
            return this.f1799e;
        }

        public t r() {
            return this.f1801g;
        }

        public boolean s() {
            e eVar = this.f1810a;
            if (eVar != null && eVar.f1762a.getApplicationInfo().targetSdkVersion < 28 && this.f1803i == null) {
                return this.f1802h != null;
            }
            Boolean bool = this.f1803i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public i t(CharSequence charSequence) {
            this.f1802h = charSequence;
            return this;
        }

        public i u(boolean z7) {
            this.f1803i = Boolean.valueOf(z7);
            return this;
        }

        public i(t tVar) {
            if (!TextUtils.isEmpty(tVar.e())) {
                this.f1801g = tVar;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        public static final class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CharSequence f1804a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f1805b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final t f1806c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Bundle f1807d = new Bundle();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f1808e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Uri f1809f;

            public static class a {
                public static Notification.MessagingStyle.Message a(CharSequence charSequence, long j7, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j7, charSequence2);
                }

                public static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            public d(CharSequence charSequence, long j7, t tVar) {
                this.f1804a = charSequence;
                this.f1805b = j7;
                this.f1806c = tVar;
            }

            public static Bundle[] a(List list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i7 = 0; i7 < size; i7++) {
                    bundleArr[i7] = ((d) list.get(i7)).l();
                }
                return bundleArr;
            }

            public static d e(Bundle bundle) {
                try {
                    if (bundle.containsKey("text") && bundle.containsKey(com.amazon.a.a.h.a.f9648b)) {
                        d dVar = new d(bundle.getCharSequence("text"), bundle.getLong(com.amazon.a.a.h.a.f9648b), bundle.containsKey("person") ? t.b(bundle.getBundle("person")) : (!bundle.containsKey("sender_person") || Build.VERSION.SDK_INT < 28) ? bundle.containsKey("sender") ? new t.b().f(bundle.getCharSequence("sender")).a() : null : t.a(m.a(bundle.getParcelable("sender_person"))));
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
                return this.f1808e;
            }

            public Uri c() {
                return this.f1809f;
            }

            public Bundle d() {
                return this.f1807d;
            }

            public t g() {
                return this.f1806c;
            }

            public CharSequence h() {
                return this.f1804a;
            }

            public long i() {
                return this.f1805b;
            }

            public d j(String str, Uri uri) {
                this.f1808e = str;
                this.f1809f = uri;
                return this;
            }

            public Notification.MessagingStyle.Message k() {
                Notification.MessagingStyle.Message messageA;
                t tVarG = g();
                if (Build.VERSION.SDK_INT >= 28) {
                    messageA = b.b(h(), i(), tVarG != null ? tVarG.j() : null);
                } else {
                    messageA = a.a(h(), i(), tVarG != null ? tVarG.e() : null);
                }
                if (b() != null) {
                    a.b(messageA, b(), c());
                }
                return messageA;
            }

            public final Bundle l() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f1804a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong(com.amazon.a.a.h.a.f9648b, this.f1805b);
                t tVar = this.f1806c;
                if (tVar != null) {
                    bundle.putCharSequence("sender", tVar.e());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", b.a(this.f1806c.j()));
                    } else {
                        bundle.putBundle("person", this.f1806c.k());
                    }
                }
                String str = this.f1808e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f1809f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.f1807d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            public static class b {
                public static Notification.MessagingStyle.Message b(CharSequence charSequence, long j7, Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j7, person);
                }

                public static Parcelable a(Person person) {
                    return person;
                }
            }
        }
    }

    public static class e {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public boolean f1740A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public boolean f1741B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public boolean f1742C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public String f1743D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public Bundle f1744E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public int f1745F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f1746G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public Notification f1747H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public RemoteViews f1748I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public RemoteViews f1749J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public RemoteViews f1750K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public String f1751L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public int f1752M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public String f1753N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public long f1754O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public int f1755P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public int f1756Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public boolean f1757R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public Notification f1758S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public boolean f1759T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public Object f1760U;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public ArrayList f1761V;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f1762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f1763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f1764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f1765d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f1766e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f1767f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f1768g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f1769h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RemoteViews f1770i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public IconCompat f1771j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f1772k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f1773l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1774m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f1775n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f1776o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f1777p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public j f1778q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public CharSequence f1779r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public CharSequence f1780s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public CharSequence[] f1781t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f1782u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f1783v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f1784w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f1785x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f1786y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f1787z;

        public static class a {
            public static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            public static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i7) {
                return builder.setContentType(i7);
            }

            public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i7) {
                return builder.setLegacyStreamType(i7);
            }

            public static AudioAttributes.Builder e(AudioAttributes.Builder builder, int i7) {
                return builder.setUsage(i7);
            }
        }

        public e(Context context, String str) {
            this.f1763b = new ArrayList();
            this.f1764c = new ArrayList();
            this.f1765d = new ArrayList();
            this.f1775n = true;
            this.f1740A = false;
            this.f1745F = 0;
            this.f1746G = 0;
            this.f1752M = 0;
            this.f1755P = 0;
            this.f1756Q = 0;
            Notification notification = new Notification();
            this.f1758S = notification;
            this.f1762a = context;
            this.f1751L = str;
            notification.when = System.currentTimeMillis();
            this.f1758S.audioStreamType = -1;
            this.f1774m = 0;
            this.f1761V = new ArrayList();
            this.f1757R = true;
        }

        public static CharSequence e(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public e A(boolean z7) {
            q(8, z7);
            return this;
        }

        public e B(int i7) {
            this.f1774m = i7;
            return this;
        }

        public e C(int i7, int i8, boolean z7) {
            this.f1782u = i7;
            this.f1783v = i8;
            this.f1784w = z7;
            return this;
        }

        public e D(String str) {
            this.f1753N = str;
            return this;
        }

        public e E(boolean z7) {
            this.f1775n = z7;
            return this;
        }

        public e F(boolean z7) {
            this.f1759T = z7;
            return this;
        }

        public e G(int i7) {
            this.f1758S.icon = i7;
            return this;
        }

        public e H(Uri uri) {
            Notification notification = this.f1758S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder builderE = a.e(a.c(a.b(), 4), 5);
            this.f1758S.audioAttributes = a.a(builderE);
            return this;
        }

        public e I(j jVar) {
            if (this.f1778q != jVar) {
                this.f1778q = jVar;
                if (jVar != null) {
                    jVar.m(this);
                }
            }
            return this;
        }

        public e J(CharSequence charSequence) {
            this.f1779r = e(charSequence);
            return this;
        }

        public e K(CharSequence charSequence) {
            this.f1758S.tickerText = e(charSequence);
            return this;
        }

        public e L(long j7) {
            this.f1754O = j7;
            return this;
        }

        public e M(boolean z7) {
            this.f1776o = z7;
            return this;
        }

        public e N(long[] jArr) {
            this.f1758S.vibrate = jArr;
            return this;
        }

        public e O(int i7) {
            this.f1746G = i7;
            return this;
        }

        public e P(long j7) {
            this.f1758S.when = j7;
            return this;
        }

        public e a(int i7, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f1763b.add(new a(i7, charSequence, pendingIntent));
            return this;
        }

        public e b(a aVar) {
            if (aVar != null) {
                this.f1763b.add(aVar);
            }
            return this;
        }

        public Notification c() {
            return new n(this).c();
        }

        public Bundle d() {
            if (this.f1744E == null) {
                this.f1744E = new Bundle();
            }
            return this.f1744E;
        }

        public e f(boolean z7) {
            q(16, z7);
            return this;
        }

        public e g(String str) {
            this.f1743D = str;
            return this;
        }

        public e h(String str) {
            this.f1751L = str;
            return this;
        }

        public e i(boolean z7) {
            this.f1777p = z7;
            d().putBoolean("android.chronometerCountDown", z7);
            return this;
        }

        public e j(int i7) {
            this.f1745F = i7;
            return this;
        }

        public e k(boolean z7) {
            this.f1741B = z7;
            this.f1742C = true;
            return this;
        }

        public e l(PendingIntent pendingIntent) {
            this.f1768g = pendingIntent;
            return this;
        }

        public e m(CharSequence charSequence) {
            this.f1767f = e(charSequence);
            return this;
        }

        public e n(CharSequence charSequence) {
            this.f1766e = e(charSequence);
            return this;
        }

        public e o(int i7) {
            Notification notification = this.f1758S;
            notification.defaults = i7;
            if ((i7 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e p(PendingIntent pendingIntent) {
            this.f1758S.deleteIntent = pendingIntent;
            return this;
        }

        public final void q(int i7, boolean z7) {
            if (z7) {
                Notification notification = this.f1758S;
                notification.flags = i7 | notification.flags;
            } else {
                Notification notification2 = this.f1758S;
                notification2.flags = (~i7) & notification2.flags;
            }
        }

        public e r(PendingIntent pendingIntent, boolean z7) {
            this.f1769h = pendingIntent;
            q(128, z7);
            return this;
        }

        public e s(String str) {
            this.f1785x = str;
            return this;
        }

        public e t(int i7) {
            this.f1755P = i7;
            return this;
        }

        public e u(boolean z7) {
            this.f1786y = z7;
            return this;
        }

        public e v(Bitmap bitmap) {
            this.f1771j = bitmap == null ? null : IconCompat.f(k.b(this.f1762a, bitmap));
            return this;
        }

        public e w(int i7, int i8, int i9) {
            Notification notification = this.f1758S;
            notification.ledARGB = i7;
            notification.ledOnMS = i8;
            notification.ledOffMS = i9;
            notification.flags = ((i8 == 0 || i9 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public e x(boolean z7) {
            this.f1740A = z7;
            return this;
        }

        public e y(int i7) {
            this.f1773l = i7;
            return this;
        }

        public e z(boolean z7) {
            q(2, z7);
            return this;
        }

        public e(Context context) {
            this(context, null);
        }
    }

    public static class f extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1788e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public t f1789f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f1790g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f1791h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PendingIntent f1792i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f1793j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f1794k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Integer f1795l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public IconCompat f1796m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public CharSequence f1797n;

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

            public static Notification.CallStyle d(Notification.CallStyle callStyle, int i7) {
                return callStyle.setAnswerButtonColorHint(i7);
            }

            public static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z7) {
                return builder.setAuthenticationRequired(z7);
            }

            public static Notification.CallStyle f(Notification.CallStyle callStyle, int i7) {
                return callStyle.setDeclineButtonColorHint(i7);
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

        @Override // F.k.j
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt("android.callType", this.f1788e);
            bundle.putBoolean("android.callIsVideo", this.f1793j);
            t tVar = this.f1789f;
            if (tVar != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable("android.callPerson", c.b(tVar.j()));
                } else {
                    bundle.putParcelable("android.callPersonCompat", tVar.k());
                }
            }
            IconCompat iconCompat = this.f1796m;
            if (iconCompat != null) {
                bundle.putParcelable("android.verificationIcon", b.a(iconCompat.v(this.f1810a.f1762a)));
            }
            bundle.putCharSequence("android.verificationText", this.f1797n);
            bundle.putParcelable("android.answerIntent", this.f1790g);
            bundle.putParcelable("android.declineIntent", this.f1791h);
            bundle.putParcelable("android.hangUpIntent", this.f1792i);
            Integer num = this.f1794k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f1795l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // F.k.j
        public void b(F.j jVar) {
            int i7 = Build.VERSION.SDK_INT;
            CharSequence charSequenceO = null;
            callStyleA = null;
            Notification.CallStyle callStyleA = null;
            charSequenceO = null;
            if (i7 < 31) {
                Notification.Builder builderA = jVar.a();
                t tVar = this.f1789f;
                builderA.setContentTitle(tVar != null ? tVar.e() : null);
                Bundle bundle = this.f1810a.f1744E;
                if (bundle != null && bundle.containsKey("android.text")) {
                    charSequenceO = this.f1810a.f1744E.getCharSequence("android.text");
                }
                if (charSequenceO == null) {
                    charSequenceO = o();
                }
                builderA.setContentText(charSequenceO);
                t tVar2 = this.f1789f;
                if (tVar2 != null) {
                    if (tVar2.c() != null) {
                        b.c(builderA, this.f1789f.c().v(this.f1810a.f1762a));
                    }
                    if (i7 >= 28) {
                        c.a(builderA, this.f1789f.j());
                    } else {
                        a.a(builderA, this.f1789f.f());
                    }
                }
                a.b(builderA, "call");
                return;
            }
            int i8 = this.f1788e;
            if (i8 == 1) {
                callStyleA = d.a(this.f1789f.j(), this.f1791h, this.f1790g);
            } else if (i8 == 2) {
                callStyleA = d.b(this.f1789f.j(), this.f1792i);
            } else if (i8 == 3) {
                callStyleA = d.c(this.f1789f.j(), this.f1792i, this.f1790g);
            } else if (Log.isLoggable("NotifCompat", 3)) {
                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f1788e));
            }
            if (callStyleA != null) {
                callStyleA.setBuilder(jVar.a());
                Integer num = this.f1794k;
                if (num != null) {
                    d.d(callStyleA, num.intValue());
                }
                Integer num2 = this.f1795l;
                if (num2 != null) {
                    d.f(callStyleA, num2.intValue());
                }
                d.i(callStyleA, this.f1797n);
                IconCompat iconCompat = this.f1796m;
                if (iconCompat != null) {
                    d.h(callStyleA, iconCompat.v(this.f1810a.f1762a));
                }
                d.g(callStyleA, this.f1793j);
            }
        }

        @Override // F.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        @Override // F.k.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f1788e = bundle.getInt("android.callType");
            this.f1793j = bundle.getBoolean("android.callIsVideo");
            if (Build.VERSION.SDK_INT >= 28 && bundle.containsKey("android.callPerson")) {
                this.f1789f = t.a(m.a(bundle.getParcelable("android.callPerson")));
            } else if (bundle.containsKey("android.callPersonCompat")) {
                this.f1789f = t.b(bundle.getBundle("android.callPersonCompat"));
            }
            if (bundle.containsKey("android.verificationIcon")) {
                this.f1796m = IconCompat.b((Icon) bundle.getParcelable("android.verificationIcon"));
            } else if (bundle.containsKey("android.verificationIconCompat")) {
                this.f1796m = IconCompat.a(bundle.getBundle("android.verificationIconCompat"));
            }
            this.f1797n = bundle.getCharSequence("android.verificationText");
            this.f1790g = (PendingIntent) bundle.getParcelable("android.answerIntent");
            this.f1791h = (PendingIntent) bundle.getParcelable("android.declineIntent");
            this.f1792i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
            this.f1794k = bundle.containsKey("android.answerColor") ? Integer.valueOf(bundle.getInt("android.answerColor")) : null;
            this.f1795l = bundle.containsKey("android.declineColor") ? Integer.valueOf(bundle.getInt("android.declineColor")) : null;
        }

        public ArrayList n() {
            a aVarS = s();
            a aVarR = r();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(aVarS);
            ArrayList<a> arrayList2 = this.f1810a.f1763b;
            int i7 = 2;
            if (arrayList2 != null) {
                for (a aVar : arrayList2) {
                    if (aVar.j()) {
                        arrayList.add(aVar);
                    } else if (!p(aVar) && i7 > 1) {
                        arrayList.add(aVar);
                        i7--;
                    }
                    if (aVarR != null && i7 == 1) {
                        arrayList.add(aVarR);
                        i7--;
                    }
                }
            }
            if (aVarR != null && i7 >= 1) {
                arrayList.add(aVarR);
            }
            return arrayList;
        }

        public final String o() {
            int i7 = this.f1788e;
            if (i7 == 1) {
                return this.f1810a.f1762a.getResources().getString(E.f.f1545e);
            }
            if (i7 == 2) {
                return this.f1810a.f1762a.getResources().getString(E.f.f1546f);
            }
            if (i7 != 3) {
                return null;
            }
            return this.f1810a.f1762a.getResources().getString(E.f.f1547g);
        }

        public final boolean p(a aVar) {
            return aVar != null && aVar.c().getBoolean("key_action_priority");
        }

        public final a q(int i7, int i8, Integer num, int i9, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(G.a.getColor(this.f1810a.f1762a, i9));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f1810a.f1762a.getResources().getString(i8));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            a aVarB = new a.C0013a(IconCompat.j(this.f1810a.f1762a, i7), spannableStringBuilder, pendingIntent).b();
            aVarB.c().putBoolean("key_action_priority", true);
            return aVarB;
        }

        public final a r() {
            int i7 = E.d.f1494b;
            int i8 = E.d.f1493a;
            PendingIntent pendingIntent = this.f1790g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z7 = this.f1793j;
            return q(z7 ? i7 : i8, z7 ? E.f.f1542b : E.f.f1541a, this.f1794k, E.b.f1489a, pendingIntent);
        }

        public final a s() {
            int i7 = E.d.f1495c;
            PendingIntent pendingIntent = this.f1791h;
            return pendingIntent == null ? q(i7, E.f.f1544d, this.f1795l, E.b.f1490b, this.f1792i) : q(i7, E.f.f1543c, this.f1795l, E.b.f1490b, pendingIntent);
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

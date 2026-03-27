package w;

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
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import v.AbstractC1870b;
import v.AbstractC1871c;
import v.AbstractC1872d;
import v.AbstractC1874f;
import w.t;
import x.AbstractC1909a;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f15385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f15386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final v[] f15387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final v[] f15388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15389e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f15390f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f15391g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f15392h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f15393i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f15394j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public PendingIntent f15395k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f15396l;

        /* JADX INFO: renamed from: w.k$a$a, reason: collision with other inner class name */
        public static final class C0249a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IconCompat f15397a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CharSequence f15398b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final PendingIntent f15399c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f15400d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final Bundle f15401e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public ArrayList f15402f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f15403g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f15404h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f15405i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f15406j;

            public C0249a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public C0249a a(v vVar) {
                if (this.f15402f == null) {
                    this.f15402f = new ArrayList();
                }
                if (vVar != null) {
                    this.f15402f.add(vVar);
                }
                return this;
            }

            public a b() {
                c();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<v> arrayList3 = this.f15402f;
                if (arrayList3 != null) {
                    for (v vVar : arrayList3) {
                        if (vVar.k()) {
                            arrayList.add(vVar);
                        } else {
                            arrayList2.add(vVar);
                        }
                    }
                }
                return new a(this.f15397a, this.f15398b, this.f15399c, this.f15401e, arrayList2.isEmpty() ? null : (v[]) arrayList2.toArray(new v[arrayList2.size()]), arrayList.isEmpty() ? null : (v[]) arrayList.toArray(new v[arrayList.size()]), this.f15400d, this.f15403g, this.f15404h, this.f15405i, this.f15406j);
            }

            public final void c() {
                if (this.f15405i && this.f15399c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C0249a d(boolean z4) {
                this.f15400d = z4;
                return this;
            }

            public C0249a e(boolean z4) {
                this.f15405i = z4;
                return this;
            }

            public C0249a f(int i4) {
                this.f15403g = i4;
                return this;
            }

            public C0249a g(boolean z4) {
                this.f15404h = z4;
                return this;
            }

            public C0249a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, v[] vVarArr, boolean z4, int i4, boolean z5, boolean z6, boolean z7) {
                this.f15400d = true;
                this.f15404h = true;
                this.f15397a = iconCompat;
                this.f15398b = e.f(charSequence);
                this.f15399c = pendingIntent;
                this.f15401e = bundle;
                this.f15402f = vVarArr == null ? null : new ArrayList(Arrays.asList(vVarArr));
                this.f15400d = z4;
                this.f15403g = i4;
                this.f15404h = z5;
                this.f15405i = z6;
                this.f15406j = z7;
            }
        }

        public a(int i4, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i4 != 0 ? IconCompat.k(null, "", i4) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f15395k;
        }

        public boolean b() {
            return this.f15389e;
        }

        public Bundle c() {
            return this.f15385a;
        }

        public IconCompat d() {
            int i4;
            if (this.f15386b == null && (i4 = this.f15393i) != 0) {
                this.f15386b = IconCompat.k(null, "", i4);
            }
            return this.f15386b;
        }

        public v[] e() {
            return this.f15387c;
        }

        public int f() {
            return this.f15391g;
        }

        public boolean g() {
            return this.f15390f;
        }

        public CharSequence h() {
            return this.f15394j;
        }

        public boolean i() {
            return this.f15396l;
        }

        public boolean j() {
            return this.f15392h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, v[] vVarArr, v[] vVarArr2, boolean z4, int i4, boolean z5, boolean z6, boolean z7) {
            this.f15390f = true;
            this.f15386b = iconCompat;
            if (iconCompat != null && iconCompat.o() == 2) {
                this.f15393i = iconCompat.m();
            }
            this.f15394j = e.f(charSequence);
            this.f15395k = pendingIntent;
            this.f15385a = bundle == null ? new Bundle() : bundle;
            this.f15387c = vVarArr;
            this.f15388d = vVarArr2;
            this.f15389e = z4;
            this.f15391g = i4;
            this.f15390f = z5;
            this.f15392h = z6;
            this.f15396l = z7;
        }
    }

    public static class b extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public IconCompat f15407e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public IconCompat f15408f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f15409g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f15410h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f15411i;

        public static class a {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* JADX INFO: renamed from: w.k$b$b, reason: collision with other inner class name */
        public static class C0250b {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z4) {
                bigPictureStyle.showBigPictureWhenCollapsed(z4);
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

        @Override // w.k.j
        public void b(w.j jVar) {
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(jVar.a()).setBigContentTitle(this.f15484b);
            IconCompat iconCompat = this.f15407e;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    C0250b.a(bigContentTitle, this.f15407e.v(jVar instanceof n ? ((n) jVar).f() : null));
                } else if (iconCompat.o() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f15407e.l());
                }
            }
            if (this.f15409g) {
                if (this.f15408f == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    a.a(bigContentTitle, this.f15408f.v(jVar instanceof n ? ((n) jVar).f() : null));
                }
            }
            if (this.f15486d) {
                bigContentTitle.setSummaryText(this.f15485c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                C0250b.c(bigContentTitle, this.f15411i);
                C0250b.b(bigContentTitle, this.f15410h);
            }
        }

        @Override // w.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @Override // w.k.j
        public void l(Bundle bundle) {
            super.l(bundle);
            if (bundle.containsKey("android.largeIcon.big")) {
                this.f15408f = n(bundle.getParcelable("android.largeIcon.big"));
                this.f15409g = true;
            }
            this.f15407e = q(bundle);
            this.f15411i = bundle.getBoolean("android.showBigPictureWhenCollapsed");
        }

        public b o(Bitmap bitmap) {
            this.f15408f = bitmap == null ? null : IconCompat.f(bitmap);
            this.f15409g = true;
            return this;
        }

        public b p(Bitmap bitmap) {
            this.f15407e = bitmap == null ? null : IconCompat.f(bitmap);
            return this;
        }

        public b r(CharSequence charSequence) {
            this.f15484b = e.f(charSequence);
            return this;
        }

        public b s(CharSequence charSequence) {
            this.f15485c = e.f(charSequence);
            this.f15486d = true;
            return this;
        }
    }

    public static class c extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f15412e;

        @Override // w.k.j
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // w.k.j
        public void b(w.j jVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(jVar.a()).setBigContentTitle(this.f15484b).bigText(this.f15412e);
            if (this.f15486d) {
                bigTextStyleBigText.setSummaryText(this.f15485c);
            }
        }

        @Override // w.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // w.k.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f15412e = bundle.getCharSequence("android.bigText");
        }

        public c n(CharSequence charSequence) {
            this.f15412e = e.f(charSequence);
            return this;
        }

        public c o(CharSequence charSequence) {
            this.f15484b = e.f(charSequence);
            return this;
        }

        public c p(CharSequence charSequence) {
            this.f15485c = e.f(charSequence);
            this.f15486d = true;
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

        @Override // w.k.j
        public void b(w.j jVar) {
            jVar.a().setStyle(a.a());
        }

        @Override // w.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // w.k.j
        public RemoteViews i(w.j jVar) {
            return null;
        }

        @Override // w.k.j
        public RemoteViews j(w.j jVar) {
            return null;
        }

        @Override // w.k.j
        public RemoteViews k(w.j jVar) {
            return null;
        }
    }

    public static class h extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList f15471e = new ArrayList();

        @Override // w.k.j
        public void b(w.j jVar) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(jVar.a()).setBigContentTitle(this.f15484b);
            if (this.f15486d) {
                bigContentTitle.setSummaryText(this.f15485c);
            }
            Iterator it = this.f15471e.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine((CharSequence) it.next());
            }
        }

        @Override // w.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @Override // w.k.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f15471e.clear();
            if (bundle.containsKey("android.textLines")) {
                Collections.addAll(this.f15471e, bundle.getCharSequenceArray("android.textLines"));
            }
        }

        public h n(CharSequence charSequence) {
            if (charSequence != null) {
                this.f15471e.add(e.f(charSequence));
            }
            return this;
        }

        public h o(CharSequence charSequence) {
            this.f15484b = e.f(charSequence);
            return this;
        }

        public h p(CharSequence charSequence) {
            this.f15485c = e.f(charSequence);
            this.f15486d = true;
            return this;
        }
    }

    public static abstract class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f15483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f15484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f15485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15486d = false;

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
            if (this.f15486d) {
                bundle.putCharSequence("android.summaryText", this.f15485c);
            }
            CharSequence charSequence = this.f15484b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strH = h();
            if (strH != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strH);
            }
        }

        public abstract void b(w.j jVar);

        public String h() {
            return null;
        }

        public RemoteViews i(w.j jVar) {
            return null;
        }

        public RemoteViews j(w.j jVar) {
            return null;
        }

        public RemoteViews k(w.j jVar) {
            return null;
        }

        public void l(Bundle bundle) {
            if (bundle.containsKey("android.summaryText")) {
                this.f15485c = bundle.getCharSequence("android.summaryText");
                this.f15486d = true;
            }
            this.f15484b = bundle.getCharSequence("android.title.big");
        }

        public void m(e eVar) {
            if (this.f15483a != eVar) {
                this.f15483a = eVar;
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
        int dimensionPixelSize = resources.getDimensionPixelSize(AbstractC1871c.f15118b);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(AbstractC1871c.f15117a);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
    }

    public static class i extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f15472e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f15473f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public t f15474g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f15475h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Boolean f15476i;

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

            public static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z4) {
                return messagingStyle.setGroupConversation(z4);
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

        @Override // w.k.j
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.f15474g.e());
            bundle.putBundle("android.messagingStyleUser", this.f15474g.k());
            bundle.putCharSequence("android.hiddenConversationTitle", this.f15475h);
            if (this.f15475h != null && this.f15476i.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.f15475h);
            }
            if (!this.f15472e.isEmpty()) {
                bundle.putParcelableArray("android.messages", d.a(this.f15472e));
            }
            if (!this.f15473f.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", d.a(this.f15473f));
            }
            Boolean bool = this.f15476i;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        @Override // w.k.j
        public void b(w.j jVar) {
            u(s());
            Notification.MessagingStyle messagingStyleA = Build.VERSION.SDK_INT >= 28 ? c.a(this.f15474g.j()) : a.b(this.f15474g.e());
            Iterator it = this.f15472e.iterator();
            while (it.hasNext()) {
                a.a(messagingStyleA, ((d) it.next()).k());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Iterator it2 = this.f15473f.iterator();
                while (it2.hasNext()) {
                    b.a(messagingStyleA, ((d) it2.next()).k());
                }
            }
            if (this.f15476i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                a.c(messagingStyleA, this.f15475h);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                c.b(messagingStyleA, this.f15476i.booleanValue());
            }
            messagingStyleA.setBuilder(jVar.a());
        }

        @Override // w.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        @Override // w.k.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f15472e.clear();
            if (bundle.containsKey("android.messagingStyleUser")) {
                this.f15474g = t.b(bundle.getBundle("android.messagingStyleUser"));
            } else {
                this.f15474g = new t.b().f(bundle.getString("android.selfDisplayName")).a();
            }
            CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
            this.f15475h = charSequence;
            if (charSequence == null) {
                this.f15475h = bundle.getCharSequence("android.hiddenConversationTitle");
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
            if (parcelableArray != null) {
                this.f15472e.addAll(d.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
            if (parcelableArray2 != null) {
                this.f15473f.addAll(d.f(parcelableArray2));
            }
            if (bundle.containsKey("android.isGroupConversation")) {
                this.f15476i = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
            }
        }

        public i n(d dVar) {
            if (dVar != null) {
                this.f15472e.add(dVar);
                if (this.f15472e.size() > 25) {
                    this.f15472e.remove(0);
                }
            }
            return this;
        }

        public CharSequence p() {
            return this.f15475h;
        }

        public List q() {
            return this.f15472e;
        }

        public t r() {
            return this.f15474g;
        }

        public boolean s() {
            e eVar = this.f15483a;
            if (eVar != null && eVar.f15435a.getApplicationInfo().targetSdkVersion < 28 && this.f15476i == null) {
                return this.f15475h != null;
            }
            Boolean bool = this.f15476i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public i t(CharSequence charSequence) {
            this.f15475h = charSequence;
            return this;
        }

        public i u(boolean z4) {
            this.f15476i = Boolean.valueOf(z4);
            return this;
        }

        public i(t tVar) {
            if (!TextUtils.isEmpty(tVar.e())) {
                this.f15474g = tVar;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        public static final class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CharSequence f15477a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f15478b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final t f15479c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Bundle f15480d = new Bundle();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f15481e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Uri f15482f;

            public static class a {
                public static Notification.MessagingStyle.Message a(CharSequence charSequence, long j4, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j4, charSequence2);
                }

                public static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            public d(CharSequence charSequence, long j4, t tVar) {
                this.f15477a = charSequence;
                this.f15478b = j4;
                this.f15479c = tVar;
            }

            public static Bundle[] a(List list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    bundleArr[i4] = ((d) list.get(i4)).l();
                }
                return bundleArr;
            }

            public static d e(Bundle bundle) {
                try {
                    if (bundle.containsKey("text") && bundle.containsKey(com.amazon.a.a.h.a.f8463b)) {
                        d dVar = new d(bundle.getCharSequence("text"), bundle.getLong(com.amazon.a.a.h.a.f8463b), bundle.containsKey("person") ? t.b(bundle.getBundle("person")) : (!bundle.containsKey("sender_person") || Build.VERSION.SDK_INT < 28) ? bundle.containsKey("sender") ? new t.b().f(bundle.getCharSequence("sender")).a() : null : t.a(m.a(bundle.getParcelable("sender_person"))));
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
                return this.f15481e;
            }

            public Uri c() {
                return this.f15482f;
            }

            public Bundle d() {
                return this.f15480d;
            }

            public t g() {
                return this.f15479c;
            }

            public CharSequence h() {
                return this.f15477a;
            }

            public long i() {
                return this.f15478b;
            }

            public d j(String str, Uri uri) {
                this.f15481e = str;
                this.f15482f = uri;
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
                CharSequence charSequence = this.f15477a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong(com.amazon.a.a.h.a.f8463b, this.f15478b);
                t tVar = this.f15479c;
                if (tVar != null) {
                    bundle.putCharSequence("sender", tVar.e());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", b.a(this.f15479c.j()));
                    } else {
                        bundle.putBundle("person", this.f15479c.k());
                    }
                }
                String str = this.f15481e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f15482f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.f15480d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            public static class b {
                public static Notification.MessagingStyle.Message b(CharSequence charSequence, long j4, Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j4, person);
                }

                public static Parcelable a(Person person) {
                    return person;
                }
            }
        }
    }

    public static class e {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public boolean f15413A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public boolean f15414B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public boolean f15415C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public String f15416D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public Bundle f15417E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public int f15418F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f15419G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public Notification f15420H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public RemoteViews f15421I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public RemoteViews f15422J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public RemoteViews f15423K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public String f15424L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public int f15425M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public String f15426N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public long f15427O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public int f15428P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public int f15429Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public boolean f15430R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public Notification f15431S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public boolean f15432T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public Object f15433U;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public ArrayList f15434V;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f15435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f15436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList f15437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f15438d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f15439e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f15440f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f15441g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f15442h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RemoteViews f15443i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public IconCompat f15444j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f15445k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f15446l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f15447m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f15448n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f15449o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f15450p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public j f15451q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public CharSequence f15452r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public CharSequence f15453s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public CharSequence[] f15454t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f15455u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f15456v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f15457w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f15458x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f15459y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f15460z;

        public static class a {
            public static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            public static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i4) {
                return builder.setContentType(i4);
            }

            public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i4) {
                return builder.setLegacyStreamType(i4);
            }

            public static AudioAttributes.Builder e(AudioAttributes.Builder builder, int i4) {
                return builder.setUsage(i4);
            }
        }

        public e(Context context, String str) {
            this.f15436b = new ArrayList();
            this.f15437c = new ArrayList();
            this.f15438d = new ArrayList();
            this.f15448n = true;
            this.f15413A = false;
            this.f15418F = 0;
            this.f15419G = 0;
            this.f15425M = 0;
            this.f15428P = 0;
            this.f15429Q = 0;
            Notification notification = new Notification();
            this.f15431S = notification;
            this.f15435a = context;
            this.f15424L = str;
            notification.when = System.currentTimeMillis();
            this.f15431S.audioStreamType = -1;
            this.f15447m = 0;
            this.f15434V = new ArrayList();
            this.f15430R = true;
        }

        public static CharSequence f(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public e A(boolean z4) {
            r(2, z4);
            return this;
        }

        public e B(boolean z4) {
            r(8, z4);
            return this;
        }

        public e C(int i4) {
            this.f15447m = i4;
            return this;
        }

        public e D(int i4, int i5, boolean z4) {
            this.f15455u = i4;
            this.f15456v = i5;
            this.f15457w = z4;
            return this;
        }

        public e E(String str) {
            this.f15426N = str;
            return this;
        }

        public e F(boolean z4) {
            this.f15448n = z4;
            return this;
        }

        public e G(boolean z4) {
            this.f15432T = z4;
            return this;
        }

        public e H(int i4) {
            this.f15431S.icon = i4;
            return this;
        }

        public e I(Uri uri) {
            Notification notification = this.f15431S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder builderE = a.e(a.c(a.b(), 4), 5);
            this.f15431S.audioAttributes = a.a(builderE);
            return this;
        }

        public e J(j jVar) {
            if (this.f15451q != jVar) {
                this.f15451q = jVar;
                if (jVar != null) {
                    jVar.m(this);
                }
            }
            return this;
        }

        public e K(CharSequence charSequence) {
            this.f15452r = f(charSequence);
            return this;
        }

        public e L(CharSequence charSequence) {
            this.f15431S.tickerText = f(charSequence);
            return this;
        }

        public e M(long j4) {
            this.f15427O = j4;
            return this;
        }

        public e N(boolean z4) {
            this.f15449o = z4;
            return this;
        }

        public e O(long[] jArr) {
            this.f15431S.vibrate = jArr;
            return this;
        }

        public e P(int i4) {
            this.f15419G = i4;
            return this;
        }

        public e Q(long j4) {
            this.f15431S.when = j4;
            return this;
        }

        public e a(int i4, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f15436b.add(new a(i4, charSequence, pendingIntent));
            return this;
        }

        public e b(a aVar) {
            if (aVar != null) {
                this.f15436b.add(aVar);
            }
            return this;
        }

        public e c(a aVar) {
            if (aVar != null) {
                this.f15438d.add(aVar);
            }
            return this;
        }

        public Notification d() {
            return new n(this).c();
        }

        public Bundle e() {
            if (this.f15417E == null) {
                this.f15417E = new Bundle();
            }
            return this.f15417E;
        }

        public e g(boolean z4) {
            r(16, z4);
            return this;
        }

        public e h(String str) {
            this.f15416D = str;
            return this;
        }

        public e i(String str) {
            this.f15424L = str;
            return this;
        }

        public e j(boolean z4) {
            this.f15450p = z4;
            e().putBoolean("android.chronometerCountDown", z4);
            return this;
        }

        public e k(int i4) {
            this.f15418F = i4;
            return this;
        }

        public e l(boolean z4) {
            this.f15414B = z4;
            this.f15415C = true;
            return this;
        }

        public e m(PendingIntent pendingIntent) {
            this.f15441g = pendingIntent;
            return this;
        }

        public e n(CharSequence charSequence) {
            this.f15440f = f(charSequence);
            return this;
        }

        public e o(CharSequence charSequence) {
            this.f15439e = f(charSequence);
            return this;
        }

        public e p(int i4) {
            Notification notification = this.f15431S;
            notification.defaults = i4;
            if ((i4 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e q(PendingIntent pendingIntent) {
            this.f15431S.deleteIntent = pendingIntent;
            return this;
        }

        public final void r(int i4, boolean z4) {
            if (z4) {
                Notification notification = this.f15431S;
                notification.flags = i4 | notification.flags;
            } else {
                Notification notification2 = this.f15431S;
                notification2.flags = (~i4) & notification2.flags;
            }
        }

        public e s(PendingIntent pendingIntent, boolean z4) {
            this.f15442h = pendingIntent;
            r(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS, z4);
            return this;
        }

        public e t(String str) {
            this.f15458x = str;
            return this;
        }

        public e u(int i4) {
            this.f15428P = i4;
            return this;
        }

        public e v(boolean z4) {
            this.f15459y = z4;
            return this;
        }

        public e w(Bitmap bitmap) {
            this.f15444j = bitmap == null ? null : IconCompat.f(k.b(this.f15435a, bitmap));
            return this;
        }

        public e x(int i4, int i5, int i6) {
            Notification notification = this.f15431S;
            notification.ledARGB = i4;
            notification.ledOnMS = i5;
            notification.ledOffMS = i6;
            notification.flags = ((i5 == 0 || i6 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public e y(boolean z4) {
            this.f15413A = z4;
            return this;
        }

        public e z(int i4) {
            this.f15446l = i4;
            return this;
        }

        public e(Context context) {
            this(context, null);
        }
    }

    public static class f extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15461e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public t f15462f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f15463g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f15464h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PendingIntent f15465i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f15466j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f15467k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Integer f15468l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public IconCompat f15469m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public CharSequence f15470n;

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

            public static Notification.CallStyle d(Notification.CallStyle callStyle, int i4) {
                return callStyle.setAnswerButtonColorHint(i4);
            }

            public static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z4) {
                return builder.setAuthenticationRequired(z4);
            }

            public static Notification.CallStyle f(Notification.CallStyle callStyle, int i4) {
                return callStyle.setDeclineButtonColorHint(i4);
            }

            public static Notification.CallStyle g(Notification.CallStyle callStyle, boolean z4) {
                return callStyle.setIsVideo(z4);
            }

            public static Notification.CallStyle h(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            public static Notification.CallStyle i(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        @Override // w.k.j
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt("android.callType", this.f15461e);
            bundle.putBoolean("android.callIsVideo", this.f15466j);
            t tVar = this.f15462f;
            if (tVar != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable("android.callPerson", c.b(tVar.j()));
                } else {
                    bundle.putParcelable("android.callPersonCompat", tVar.k());
                }
            }
            IconCompat iconCompat = this.f15469m;
            if (iconCompat != null) {
                bundle.putParcelable("android.verificationIcon", b.a(iconCompat.v(this.f15483a.f15435a)));
            }
            bundle.putCharSequence("android.verificationText", this.f15470n);
            bundle.putParcelable("android.answerIntent", this.f15463g);
            bundle.putParcelable("android.declineIntent", this.f15464h);
            bundle.putParcelable("android.hangUpIntent", this.f15465i);
            Integer num = this.f15467k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f15468l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // w.k.j
        public void b(w.j jVar) {
            int i4 = Build.VERSION.SDK_INT;
            CharSequence charSequenceO = null;
            callStyleA = null;
            Notification.CallStyle callStyleA = null;
            charSequenceO = null;
            if (i4 < 31) {
                Notification.Builder builderA = jVar.a();
                t tVar = this.f15462f;
                builderA.setContentTitle(tVar != null ? tVar.e() : null);
                Bundle bundle = this.f15483a.f15417E;
                if (bundle != null && bundle.containsKey("android.text")) {
                    charSequenceO = this.f15483a.f15417E.getCharSequence("android.text");
                }
                if (charSequenceO == null) {
                    charSequenceO = o();
                }
                builderA.setContentText(charSequenceO);
                t tVar2 = this.f15462f;
                if (tVar2 != null) {
                    if (tVar2.c() != null) {
                        b.c(builderA, this.f15462f.c().v(this.f15483a.f15435a));
                    }
                    if (i4 >= 28) {
                        c.a(builderA, this.f15462f.j());
                    } else {
                        a.a(builderA, this.f15462f.f());
                    }
                }
                a.b(builderA, "call");
                return;
            }
            int i5 = this.f15461e;
            if (i5 == 1) {
                callStyleA = d.a(this.f15462f.j(), this.f15464h, this.f15463g);
            } else if (i5 == 2) {
                callStyleA = d.b(this.f15462f.j(), this.f15465i);
            } else if (i5 == 3) {
                callStyleA = d.c(this.f15462f.j(), this.f15465i, this.f15463g);
            } else if (Log.isLoggable("NotifCompat", 3)) {
                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f15461e));
            }
            if (callStyleA != null) {
                callStyleA.setBuilder(jVar.a());
                Integer num = this.f15467k;
                if (num != null) {
                    d.d(callStyleA, num.intValue());
                }
                Integer num2 = this.f15468l;
                if (num2 != null) {
                    d.f(callStyleA, num2.intValue());
                }
                d.i(callStyleA, this.f15470n);
                IconCompat iconCompat = this.f15469m;
                if (iconCompat != null) {
                    d.h(callStyleA, iconCompat.v(this.f15483a.f15435a));
                }
                d.g(callStyleA, this.f15466j);
            }
        }

        @Override // w.k.j
        public String h() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        @Override // w.k.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f15461e = bundle.getInt("android.callType");
            this.f15466j = bundle.getBoolean("android.callIsVideo");
            if (Build.VERSION.SDK_INT >= 28 && bundle.containsKey("android.callPerson")) {
                this.f15462f = t.a(m.a(bundle.getParcelable("android.callPerson")));
            } else if (bundle.containsKey("android.callPersonCompat")) {
                this.f15462f = t.b(bundle.getBundle("android.callPersonCompat"));
            }
            if (bundle.containsKey("android.verificationIcon")) {
                this.f15469m = IconCompat.b((Icon) bundle.getParcelable("android.verificationIcon"));
            } else if (bundle.containsKey("android.verificationIconCompat")) {
                this.f15469m = IconCompat.a(bundle.getBundle("android.verificationIconCompat"));
            }
            this.f15470n = bundle.getCharSequence("android.verificationText");
            this.f15463g = (PendingIntent) bundle.getParcelable("android.answerIntent");
            this.f15464h = (PendingIntent) bundle.getParcelable("android.declineIntent");
            this.f15465i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
            this.f15467k = bundle.containsKey("android.answerColor") ? Integer.valueOf(bundle.getInt("android.answerColor")) : null;
            this.f15468l = bundle.containsKey("android.declineColor") ? Integer.valueOf(bundle.getInt("android.declineColor")) : null;
        }

        public ArrayList n() {
            a aVarS = s();
            a aVarR = r();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(aVarS);
            ArrayList<a> arrayList2 = this.f15483a.f15436b;
            int i4 = 2;
            if (arrayList2 != null) {
                for (a aVar : arrayList2) {
                    if (aVar.j()) {
                        arrayList.add(aVar);
                    } else if (!p(aVar) && i4 > 1) {
                        arrayList.add(aVar);
                        i4--;
                    }
                    if (aVarR != null && i4 == 1) {
                        arrayList.add(aVarR);
                        i4--;
                    }
                }
            }
            if (aVarR != null && i4 >= 1) {
                arrayList.add(aVarR);
            }
            return arrayList;
        }

        public final String o() {
            int i4 = this.f15461e;
            if (i4 == 1) {
                return this.f15483a.f15435a.getResources().getString(AbstractC1874f.f15169e);
            }
            if (i4 == 2) {
                return this.f15483a.f15435a.getResources().getString(AbstractC1874f.f15170f);
            }
            if (i4 != 3) {
                return null;
            }
            return this.f15483a.f15435a.getResources().getString(AbstractC1874f.f15171g);
        }

        public final boolean p(a aVar) {
            return aVar != null && aVar.c().getBoolean("key_action_priority");
        }

        public final a q(int i4, int i5, Integer num, int i6, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(AbstractC1909a.getColor(this.f15483a.f15435a, i6));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f15483a.f15435a.getResources().getString(i5));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            a aVarB = new a.C0249a(IconCompat.j(this.f15483a.f15435a, i4), spannableStringBuilder, pendingIntent).b();
            aVarB.c().putBoolean("key_action_priority", true);
            return aVarB;
        }

        public final a r() {
            int i4 = AbstractC1872d.f15120b;
            int i5 = AbstractC1872d.f15119a;
            PendingIntent pendingIntent = this.f15463g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z4 = this.f15466j;
            return q(z4 ? i4 : i5, z4 ? AbstractC1874f.f15166b : AbstractC1874f.f15165a, this.f15467k, AbstractC1870b.f15115a, pendingIntent);
        }

        public final a s() {
            int i4 = AbstractC1872d.f15121c;
            PendingIntent pendingIntent = this.f15464h;
            return pendingIntent == null ? q(i4, AbstractC1874f.f15168d, this.f15468l, AbstractC1870b.f15116b, this.f15465i) : q(i4, AbstractC1874f.f15167c, this.f15468l, AbstractC1870b.f15116b, pendingIntent);
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

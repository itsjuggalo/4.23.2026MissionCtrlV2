package F;

import F.k;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u.C2737b;

/* JADX INFO: loaded from: classes.dex */
public class n implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Notification.Builder f1815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k.e f1816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteViews f1817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RemoteViews f1818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f1819f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f1820g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1821h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RemoteViews f1822i;

    public static class a {
        public static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        public static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        public static Notification.Action.Builder e(int i7, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i7, charSequence, pendingIntent);
        }

        public static String f(Notification notification) {
            return notification.getGroup();
        }

        public static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Builder h(Notification.Builder builder, boolean z7) {
            return builder.setGroupSummary(z7);
        }

        public static Notification.Builder i(Notification.Builder builder, boolean z7) {
            return builder.setLocalOnly(z7);
        }

        public static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    public static class b {
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        public static Notification.Builder c(Notification.Builder builder, int i7) {
            return builder.setColor(i7);
        }

        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder f(Notification.Builder builder, int i7) {
            return builder.setVisibility(i7);
        }
    }

    public static class c {
        public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        public static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        public static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    public static class d {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z7) {
            return builder.setAllowGeneratedReplies(z7);
        }

        public static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        public static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        public static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    public static class e {
        public static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static Notification.Builder b(Notification.Builder builder, int i7) {
            return builder.setBadgeIconType(i7);
        }

        public static Notification.Builder c(Notification.Builder builder, boolean z7) {
            return builder.setColorized(z7);
        }

        public static Notification.Builder d(Notification.Builder builder, int i7) {
            return builder.setGroupAlertBehavior(i7);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder g(Notification.Builder builder, long j7) {
            return builder.setTimeoutAfter(j7);
        }
    }

    public static class f {
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i7) {
            return builder.setSemanticAction(i7);
        }
    }

    public static class g {
        public static Notification.Builder a(Notification.Builder builder, boolean z7) {
            return builder.setAllowSystemGeneratedContextualActions(z7);
        }

        public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z7) {
            return builder.setContextual(z7);
        }

        public static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    public static class h {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z7) {
            return builder.setAuthenticationRequired(z7);
        }

        public static Notification.Builder b(Notification.Builder builder, int i7) {
            return builder.setForegroundServiceBehavior(i7);
        }
    }

    public n(k.e eVar) {
        int i7;
        this.f1816c = eVar;
        Context context = eVar.f1762a;
        this.f1814a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1815b = e.a(context, eVar.f1751L);
        } else {
            this.f1815b = new Notification.Builder(eVar.f1762a);
        }
        Notification notification = eVar.f1758S;
        this.f1815b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f1770i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f1766e).setContentText(eVar.f1767f).setContentInfo(eVar.f1772k).setContentIntent(eVar.f1768g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f1769h, (notification.flags & 128) != 0).setNumber(eVar.f1773l).setProgress(eVar.f1782u, eVar.f1783v, eVar.f1784w);
        Notification.Builder builder = this.f1815b;
        IconCompat iconCompat = eVar.f1771j;
        c.b(builder, iconCompat == null ? null : iconCompat.v(context));
        this.f1815b.setSubText(eVar.f1779r).setUsesChronometer(eVar.f1776o).setPriority(eVar.f1774m);
        k.j jVar = eVar.f1778q;
        if (jVar instanceof k.f) {
            Iterator it = ((k.f) jVar).n().iterator();
            while (it.hasNext()) {
                b((k.a) it.next());
            }
        } else {
            Iterator it2 = eVar.f1763b.iterator();
            while (it2.hasNext()) {
                b((k.a) it2.next());
            }
        }
        Bundle bundle = eVar.f1744E;
        if (bundle != null) {
            this.f1820g.putAll(bundle);
        }
        int i8 = Build.VERSION.SDK_INT;
        this.f1817d = eVar.f1748I;
        this.f1818e = eVar.f1749J;
        this.f1815b.setShowWhen(eVar.f1775n);
        a.i(this.f1815b, eVar.f1740A);
        a.g(this.f1815b, eVar.f1785x);
        a.j(this.f1815b, eVar.f1787z);
        a.h(this.f1815b, eVar.f1786y);
        this.f1821h = eVar.f1755P;
        b.b(this.f1815b, eVar.f1743D);
        b.c(this.f1815b, eVar.f1745F);
        b.f(this.f1815b, eVar.f1746G);
        b.d(this.f1815b, eVar.f1747H);
        b.e(this.f1815b, notification.sound, notification.audioAttributes);
        List listE = i8 < 28 ? e(g(eVar.f1764c), eVar.f1761V) : eVar.f1761V;
        if (listE != null && !listE.isEmpty()) {
            Iterator it3 = listE.iterator();
            while (it3.hasNext()) {
                b.a(this.f1815b, (String) it3.next());
            }
        }
        this.f1822i = eVar.f1750K;
        if (eVar.f1765d.size() > 0) {
            Bundle bundle2 = eVar.d().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i9 = 0; i9 < eVar.f1765d.size(); i9++) {
                bundle4.putBundle(Integer.toString(i9), o.a((k.a) eVar.f1765d.get(i9)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            eVar.d().putBundle("android.car.EXTENSIONS", bundle2);
            this.f1820g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i10 = Build.VERSION.SDK_INT;
        Object obj = eVar.f1760U;
        if (obj != null) {
            c.c(this.f1815b, obj);
        }
        this.f1815b.setExtras(eVar.f1744E);
        d.e(this.f1815b, eVar.f1781t);
        RemoteViews remoteViews = eVar.f1748I;
        if (remoteViews != null) {
            d.c(this.f1815b, remoteViews);
        }
        RemoteViews remoteViews2 = eVar.f1749J;
        if (remoteViews2 != null) {
            d.b(this.f1815b, remoteViews2);
        }
        RemoteViews remoteViews3 = eVar.f1750K;
        if (remoteViews3 != null) {
            d.d(this.f1815b, remoteViews3);
        }
        if (i10 >= 26) {
            e.b(this.f1815b, eVar.f1752M);
            e.e(this.f1815b, eVar.f1780s);
            e.f(this.f1815b, eVar.f1753N);
            e.g(this.f1815b, eVar.f1754O);
            e.d(this.f1815b, eVar.f1755P);
            if (eVar.f1742C) {
                e.c(this.f1815b, eVar.f1741B);
            }
            if (!TextUtils.isEmpty(eVar.f1751L)) {
                this.f1815b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i10 >= 28) {
            Iterator it4 = eVar.f1764c.iterator();
            while (it4.hasNext()) {
                f.a(this.f1815b, ((t) it4.next()).j());
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            g.a(this.f1815b, eVar.f1757R);
            g.b(this.f1815b, k.d.a(null));
        }
        if (i11 >= 31 && (i7 = eVar.f1756Q) != 0) {
            h.b(this.f1815b, i7);
        }
        if (eVar.f1759T) {
            if (this.f1816c.f1786y) {
                this.f1821h = 2;
            } else {
                this.f1821h = 1;
            }
            this.f1815b.setVibrate(null);
            this.f1815b.setSound(null);
            int i12 = notification.defaults & (-4);
            notification.defaults = i12;
            this.f1815b.setDefaults(i12);
            if (i11 >= 26) {
                if (TextUtils.isEmpty(this.f1816c.f1785x)) {
                    a.g(this.f1815b, "silent");
                }
                e.d(this.f1815b, this.f1821h);
            }
        }
    }

    public static List e(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        C2737b c2737b = new C2737b(list.size() + list2.size());
        c2737b.addAll(list);
        c2737b.addAll(list2);
        return new ArrayList(c2737b);
    }

    public static List g(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((t) it.next()).i());
        }
        return arrayList;
    }

    @Override // F.j
    public Notification.Builder a() {
        return this.f1815b;
    }

    public final void b(k.a aVar) {
        IconCompat iconCompatD = aVar.d();
        Notification.Action.Builder builderA = c.a(iconCompatD != null ? iconCompatD.u() : null, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : v.b(aVar.e())) {
                a.c(builderA, remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i7 = Build.VERSION.SDK_INT;
        d.a(builderA, aVar.b());
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i7 >= 28) {
            f.b(builderA, aVar.f());
        }
        if (i7 >= 29) {
            g.c(builderA, aVar.j());
        }
        if (i7 >= 31) {
            h.a(builderA, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        a.b(builderA, bundle);
        a.a(this.f1815b, a.d(builderA));
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsK;
        RemoteViews remoteViewsI;
        k.j jVar = this.f1816c.f1778q;
        if (jVar != null) {
            jVar.b(this);
        }
        RemoteViews remoteViewsJ = jVar != null ? jVar.j(this) : null;
        Notification notificationD = d();
        if (remoteViewsJ != null) {
            notificationD.contentView = remoteViewsJ;
        } else {
            RemoteViews remoteViews = this.f1816c.f1748I;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (jVar != null && (remoteViewsI = jVar.i(this)) != null) {
            notificationD.bigContentView = remoteViewsI;
        }
        if (jVar != null && (remoteViewsK = this.f1816c.f1778q.k(this)) != null) {
            notificationD.headsUpContentView = remoteViewsK;
        }
        if (jVar != null && (bundleA = k.a(notificationD)) != null) {
            jVar.a(bundleA);
        }
        return notificationD;
    }

    public Notification d() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f1815b.build();
        }
        Notification notificationBuild = this.f1815b.build();
        if (this.f1821h != 0) {
            if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) != 0 && this.f1821h == 2) {
                h(notificationBuild);
            }
            if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) == 0 && this.f1821h == 1) {
                h(notificationBuild);
            }
        }
        return notificationBuild;
    }

    public Context f() {
        return this.f1814a;
    }

    public final void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }
}

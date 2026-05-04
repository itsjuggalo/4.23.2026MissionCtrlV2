package h0;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import h0.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k implements h0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Notification.Builder f10873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i.e f10874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteViews f10875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RemoteViews f10876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f10877f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f10878g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RemoteViews f10880i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

        public static String e(Notification notification) {
            return notification.getGroup();
        }

        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Builder g(Notification.Builder builder, boolean z10) {
            return builder.setGroupSummary(z10);
        }

        public static Notification.Builder h(Notification.Builder builder, boolean z10) {
            return builder.setLocalOnly(z10);
        }

        public static Notification.Builder i(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        public static Notification.Builder c(Notification.Builder builder, int i10) {
            return builder.setColor(i10);
        }

        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder f(Notification.Builder builder, int i10) {
            return builder.setVisibility(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAllowGeneratedReplies(z10);
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e {
        public static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setBadgeIconType(i10);
        }

        public static Notification.Builder c(Notification.Builder builder, boolean z10) {
            return builder.setColorized(z10);
        }

        public static Notification.Builder d(Notification.Builder builder, int i10) {
            return builder.setGroupAlertBehavior(i10);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder g(Notification.Builder builder, long j10) {
            return builder.setTimeoutAfter(j10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f {
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i10) {
            return builder.setSemanticAction(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g {
        public static Notification.Builder a(Notification.Builder builder, boolean z10) {
            return builder.setAllowSystemGeneratedContextualActions(z10);
        }

        public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z10) {
            return builder.setContextual(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class h {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAuthenticationRequired(z10);
        }

        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setForegroundServiceBehavior(i10);
        }
    }

    public k(i.e eVar) {
        int i10;
        this.f10874c = eVar;
        Context context = eVar.f10820a;
        this.f10872a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f10873b = e.a(context, eVar.L);
        } else {
            this.f10873b = new Notification.Builder(eVar.f10820a);
        }
        Notification notification = eVar.S;
        this.f10873b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f10828i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f10824e).setContentText(eVar.f10825f).setContentInfo(eVar.f10830k).setContentIntent(eVar.f10826g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f10827h, (notification.flags & 128) != 0).setNumber(eVar.f10831l).setProgress(eVar.f10840u, eVar.f10841v, eVar.f10842w);
        Notification.Builder builder = this.f10873b;
        IconCompat iconCompat = eVar.f10829j;
        c.b(builder, iconCompat == null ? null : iconCompat.v(context));
        this.f10873b.setSubText(eVar.f10837r).setUsesChronometer(eVar.f10834o).setPriority(eVar.f10832m);
        i.j jVar = eVar.f10836q;
        if (jVar instanceof i.f) {
            Iterator it = ((i.f) jVar).n().iterator();
            while (it.hasNext()) {
                b((i.a) it.next());
            }
        } else {
            Iterator it2 = eVar.f10821b.iterator();
            while (it2.hasNext()) {
                b((i.a) it2.next());
            }
        }
        Bundle bundle = eVar.E;
        if (bundle != null) {
            this.f10878g.putAll(bundle);
        }
        int i11 = Build.VERSION.SDK_INT;
        this.f10875d = eVar.I;
        this.f10876e = eVar.J;
        this.f10873b.setShowWhen(eVar.f10833n);
        a.h(this.f10873b, eVar.A);
        a.f(this.f10873b, eVar.f10843x);
        a.i(this.f10873b, eVar.f10845z);
        a.g(this.f10873b, eVar.f10844y);
        this.f10879h = eVar.P;
        b.b(this.f10873b, eVar.D);
        b.c(this.f10873b, eVar.F);
        b.f(this.f10873b, eVar.G);
        b.d(this.f10873b, eVar.H);
        b.e(this.f10873b, notification.sound, notification.audioAttributes);
        List listE = i11 < 28 ? e(g(eVar.f10822c), eVar.V) : eVar.V;
        if (listE != null && !listE.isEmpty()) {
            Iterator it3 = listE.iterator();
            while (it3.hasNext()) {
                b.a(this.f10873b, (String) it3.next());
            }
        }
        this.f10880i = eVar.K;
        if (eVar.f10823d.size() > 0) {
            Bundle bundle2 = eVar.e().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i12 = 0; i12 < eVar.f10823d.size(); i12++) {
                bundle4.putBundle(Integer.toString(i12), l.a((i.a) eVar.f10823d.get(i12)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            eVar.e().putBundle("android.car.EXTENSIONS", bundle2);
            this.f10878g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i13 = Build.VERSION.SDK_INT;
        Object obj = eVar.U;
        if (obj != null) {
            c.c(this.f10873b, obj);
        }
        this.f10873b.setExtras(eVar.E);
        d.e(this.f10873b, eVar.f10839t);
        RemoteViews remoteViews = eVar.I;
        if (remoteViews != null) {
            d.c(this.f10873b, remoteViews);
        }
        RemoteViews remoteViews2 = eVar.J;
        if (remoteViews2 != null) {
            d.b(this.f10873b, remoteViews2);
        }
        RemoteViews remoteViews3 = eVar.K;
        if (remoteViews3 != null) {
            d.d(this.f10873b, remoteViews3);
        }
        if (i13 >= 26) {
            e.b(this.f10873b, eVar.M);
            e.e(this.f10873b, eVar.f10838s);
            e.f(this.f10873b, eVar.N);
            e.g(this.f10873b, eVar.O);
            e.d(this.f10873b, eVar.P);
            if (eVar.C) {
                e.c(this.f10873b, eVar.B);
            }
            if (!TextUtils.isEmpty(eVar.L)) {
                this.f10873b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i13 >= 28) {
            Iterator it4 = eVar.f10822c.iterator();
            while (it4.hasNext()) {
                f.a(this.f10873b, ((q) it4.next()).j());
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 29) {
            g.a(this.f10873b, eVar.R);
            g.b(this.f10873b, i.d.a(null));
        }
        if (i14 >= 31 && (i10 = eVar.Q) != 0) {
            h.b(this.f10873b, i10);
        }
        if (eVar.T) {
            if (this.f10874c.f10844y) {
                this.f10879h = 2;
            } else {
                this.f10879h = 1;
            }
            this.f10873b.setVibrate(null);
            this.f10873b.setSound(null);
            int i15 = notification.defaults & (-4);
            notification.defaults = i15;
            this.f10873b.setDefaults(i15);
            if (i14 >= 26) {
                if (TextUtils.isEmpty(this.f10874c.f10843x)) {
                    a.f(this.f10873b, "silent");
                }
                e.d(this.f10873b, this.f10879h);
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
        w.b bVar = new w.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    public static List g(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((q) it.next()).i());
        }
        return arrayList;
    }

    @Override // h0.h
    public Notification.Builder a() {
        return this.f10873b;
    }

    public final void b(i.a aVar) {
        IconCompat iconCompatD = aVar.d();
        Notification.Action.Builder builderA = c.a(iconCompatD != null ? iconCompatD.u() : null, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : s.b(aVar.e())) {
                a.c(builderA, remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i10 = Build.VERSION.SDK_INT;
        d.a(builderA, aVar.b());
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i10 >= 28) {
            f.b(builderA, aVar.f());
        }
        if (i10 >= 29) {
            g.c(builderA, aVar.j());
        }
        if (i10 >= 31) {
            h.a(builderA, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        a.b(builderA, bundle);
        a.a(this.f10873b, a.d(builderA));
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsK;
        RemoteViews remoteViewsI;
        i.j jVar = this.f10874c.f10836q;
        if (jVar != null) {
            jVar.b(this);
        }
        RemoteViews remoteViewsJ = jVar != null ? jVar.j(this) : null;
        Notification notificationD = d();
        if (remoteViewsJ != null) {
            notificationD.contentView = remoteViewsJ;
        } else {
            RemoteViews remoteViews = this.f10874c.I;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (jVar != null && (remoteViewsI = jVar.i(this)) != null) {
            notificationD.bigContentView = remoteViewsI;
        }
        if (jVar != null && (remoteViewsK = this.f10874c.f10836q.k(this)) != null) {
            notificationD.headsUpContentView = remoteViewsK;
        }
        if (jVar != null && (bundleA = i.a(notificationD)) != null) {
            jVar.a(bundleA);
        }
        return notificationD;
    }

    public Notification d() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f10873b.build();
        }
        Notification notificationBuild = this.f10873b.build();
        if (this.f10879h != 0) {
            if (a.e(notificationBuild) != null && (notificationBuild.flags & 512) != 0 && this.f10879h == 2) {
                h(notificationBuild);
            }
            if (a.e(notificationBuild) != null && (notificationBuild.flags & 512) == 0 && this.f10879h == 1) {
                h(notificationBuild);
            }
        }
        return notificationBuild;
    }

    public Context f() {
        return this.f10872a;
    }

    public final void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }
}

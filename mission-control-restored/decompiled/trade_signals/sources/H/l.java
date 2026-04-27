package H;

import H.i;
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

/* JADX INFO: loaded from: classes.dex */
public class l implements H.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Notification.Builder f3500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i.e f3501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteViews f3502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RemoteViews f3503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f3504f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f3505g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RemoteViews f3507i;

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

        public static Notification.Action.Builder e(int i8, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i8, charSequence, pendingIntent);
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

        public static Notification.Builder c(Notification.Builder builder, int i8) {
            return builder.setColor(i8);
        }

        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder f(Notification.Builder builder, int i8) {
            return builder.setVisibility(i8);
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

        public static Notification.Builder b(Notification.Builder builder, int i8) {
            return builder.setBadgeIconType(i8);
        }

        public static Notification.Builder c(Notification.Builder builder, boolean z7) {
            return builder.setColorized(z7);
        }

        public static Notification.Builder d(Notification.Builder builder, int i8) {
            return builder.setGroupAlertBehavior(i8);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder g(Notification.Builder builder, long j8) {
            return builder.setTimeoutAfter(j8);
        }
    }

    public static class f {
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i8) {
            return builder.setSemanticAction(i8);
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

        public static Notification.Builder b(Notification.Builder builder, int i8) {
            return builder.setForegroundServiceBehavior(i8);
        }
    }

    public l(i.e eVar) {
        int i8;
        this.f3501c = eVar;
        Context context = eVar.f3447a;
        this.f3499a = context;
        this.f3500b = Build.VERSION.SDK_INT >= 26 ? e.a(context, eVar.f3436L) : new Notification.Builder(eVar.f3447a);
        Notification notification = eVar.f3443S;
        this.f3500b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f3455i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f3451e).setContentText(eVar.f3452f).setContentInfo(eVar.f3457k).setContentIntent(eVar.f3453g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f3454h, (notification.flags & 128) != 0).setNumber(eVar.f3458l).setProgress(eVar.f3467u, eVar.f3468v, eVar.f3469w);
        Notification.Builder builder = this.f3500b;
        IconCompat iconCompat = eVar.f3456j;
        c.b(builder, iconCompat == null ? null : iconCompat.v(context));
        this.f3500b.setSubText(eVar.f3464r).setUsesChronometer(eVar.f3461o).setPriority(eVar.f3459m);
        i.j jVar = eVar.f3463q;
        if (jVar instanceof i.f) {
            Iterator it = ((i.f) jVar).n().iterator();
            while (it.hasNext()) {
                b((i.a) it.next());
            }
        } else {
            Iterator it2 = eVar.f3448b.iterator();
            while (it2.hasNext()) {
                b((i.a) it2.next());
            }
        }
        Bundle bundle = eVar.f3429E;
        if (bundle != null) {
            this.f3505g.putAll(bundle);
        }
        int i9 = Build.VERSION.SDK_INT;
        this.f3502d = eVar.f3433I;
        this.f3503e = eVar.f3434J;
        this.f3500b.setShowWhen(eVar.f3460n);
        a.i(this.f3500b, eVar.f3425A);
        a.g(this.f3500b, eVar.f3470x);
        a.j(this.f3500b, eVar.f3472z);
        a.h(this.f3500b, eVar.f3471y);
        this.f3506h = eVar.f3440P;
        b.b(this.f3500b, eVar.f3428D);
        b.c(this.f3500b, eVar.f3430F);
        b.f(this.f3500b, eVar.f3431G);
        b.d(this.f3500b, eVar.f3432H);
        b.e(this.f3500b, notification.sound, notification.audioAttributes);
        List listE = i9 < 28 ? e(g(eVar.f3449c), eVar.f3446V) : eVar.f3446V;
        if (listE != null && !listE.isEmpty()) {
            Iterator it3 = listE.iterator();
            while (it3.hasNext()) {
                b.a(this.f3500b, (String) it3.next());
            }
        }
        this.f3507i = eVar.f3435K;
        if (eVar.f3450d.size() > 0) {
            Bundle bundle2 = eVar.e().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i10 = 0; i10 < eVar.f3450d.size(); i10++) {
                bundle4.putBundle(Integer.toString(i10), m.a((i.a) eVar.f3450d.get(i10)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            eVar.e().putBundle("android.car.EXTENSIONS", bundle2);
            this.f3505g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i11 = Build.VERSION.SDK_INT;
        Object obj = eVar.f3445U;
        if (obj != null) {
            c.c(this.f3500b, obj);
        }
        this.f3500b.setExtras(eVar.f3429E);
        d.e(this.f3500b, eVar.f3466t);
        RemoteViews remoteViews = eVar.f3433I;
        if (remoteViews != null) {
            d.c(this.f3500b, remoteViews);
        }
        RemoteViews remoteViews2 = eVar.f3434J;
        if (remoteViews2 != null) {
            d.b(this.f3500b, remoteViews2);
        }
        RemoteViews remoteViews3 = eVar.f3435K;
        if (remoteViews3 != null) {
            d.d(this.f3500b, remoteViews3);
        }
        if (i11 >= 26) {
            e.b(this.f3500b, eVar.f3437M);
            e.e(this.f3500b, eVar.f3465s);
            e.f(this.f3500b, eVar.f3438N);
            e.g(this.f3500b, eVar.f3439O);
            e.d(this.f3500b, eVar.f3440P);
            if (eVar.f3427C) {
                e.c(this.f3500b, eVar.f3426B);
            }
            if (!TextUtils.isEmpty(eVar.f3436L)) {
                this.f3500b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i11 >= 28) {
            Iterator it4 = eVar.f3449c.iterator();
            while (it4.hasNext()) {
                f.a(this.f3500b, ((r) it4.next()).j());
            }
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 29) {
            g.a(this.f3500b, eVar.f3442R);
            g.b(this.f3500b, i.d.a(null));
        }
        if (i12 >= 31 && (i8 = eVar.f3441Q) != 0) {
            h.b(this.f3500b, i8);
        }
        if (eVar.f3444T) {
            if (this.f3501c.f3471y) {
                this.f3506h = 2;
            } else {
                this.f3506h = 1;
            }
            this.f3500b.setVibrate(null);
            this.f3500b.setSound(null);
            int i13 = notification.defaults & (-4);
            notification.defaults = i13;
            this.f3500b.setDefaults(i13);
            if (i12 >= 26) {
                if (TextUtils.isEmpty(this.f3501c.f3470x)) {
                    a.g(this.f3500b, "silent");
                }
                e.d(this.f3500b, this.f3506h);
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
            arrayList.add(((r) it.next()).i());
        }
        return arrayList;
    }

    @Override // H.h
    public Notification.Builder a() {
        return this.f3500b;
    }

    public final void b(i.a aVar) {
        IconCompat iconCompatD = aVar.d();
        Notification.Action.Builder builderA = c.a(iconCompatD != null ? iconCompatD.u() : null, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : t.b(aVar.e())) {
                a.c(builderA, remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i8 = Build.VERSION.SDK_INT;
        d.a(builderA, aVar.b());
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i8 >= 28) {
            f.b(builderA, aVar.f());
        }
        if (i8 >= 29) {
            g.c(builderA, aVar.j());
        }
        if (i8 >= 31) {
            h.a(builderA, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        a.b(builderA, bundle);
        a.a(this.f3500b, a.d(builderA));
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsK;
        RemoteViews remoteViewsI;
        i.j jVar = this.f3501c.f3463q;
        if (jVar != null) {
            jVar.b(this);
        }
        RemoteViews remoteViewsJ = jVar != null ? jVar.j(this) : null;
        Notification notificationD = d();
        if (remoteViewsJ != null || (remoteViewsJ = this.f3501c.f3433I) != null) {
            notificationD.contentView = remoteViewsJ;
        }
        if (jVar != null && (remoteViewsI = jVar.i(this)) != null) {
            notificationD.bigContentView = remoteViewsI;
        }
        if (jVar != null && (remoteViewsK = this.f3501c.f3463q.k(this)) != null) {
            notificationD.headsUpContentView = remoteViewsK;
        }
        if (jVar != null && (bundleA = i.a(notificationD)) != null) {
            jVar.a(bundleA);
        }
        return notificationD;
    }

    public Notification d() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f3500b.build();
        }
        Notification notificationBuild = this.f3500b.build();
        if (this.f3506h != 0) {
            if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) != 0 && this.f3506h == 2) {
                h(notificationBuild);
            }
            if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) == 0 && this.f3506h == 1) {
                h(notificationBuild);
            }
        }
        return notificationBuild;
    }

    public Context f() {
        return this.f3499a;
    }

    public final void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }
}

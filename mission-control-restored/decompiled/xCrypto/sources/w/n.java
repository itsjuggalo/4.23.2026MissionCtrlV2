package w;

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
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u.C1854b;
import w.k;

/* JADX INFO: loaded from: classes.dex */
public class n implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Notification.Builder f15488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k.e f15489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteViews f15490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RemoteViews f15491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f15492f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f15493g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RemoteViews f15495i;

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

        public static Notification.Action.Builder e(int i4, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i4, charSequence, pendingIntent);
        }

        public static String f(Notification notification) {
            return notification.getGroup();
        }

        public static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Builder h(Notification.Builder builder, boolean z4) {
            return builder.setGroupSummary(z4);
        }

        public static Notification.Builder i(Notification.Builder builder, boolean z4) {
            return builder.setLocalOnly(z4);
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

        public static Notification.Builder c(Notification.Builder builder, int i4) {
            return builder.setColor(i4);
        }

        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder f(Notification.Builder builder, int i4) {
            return builder.setVisibility(i4);
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
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z4) {
            return builder.setAllowGeneratedReplies(z4);
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

        public static Notification.Builder b(Notification.Builder builder, int i4) {
            return builder.setBadgeIconType(i4);
        }

        public static Notification.Builder c(Notification.Builder builder, boolean z4) {
            return builder.setColorized(z4);
        }

        public static Notification.Builder d(Notification.Builder builder, int i4) {
            return builder.setGroupAlertBehavior(i4);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder g(Notification.Builder builder, long j4) {
            return builder.setTimeoutAfter(j4);
        }
    }

    public static class f {
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i4) {
            return builder.setSemanticAction(i4);
        }
    }

    public static class g {
        public static Notification.Builder a(Notification.Builder builder, boolean z4) {
            return builder.setAllowSystemGeneratedContextualActions(z4);
        }

        public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z4) {
            return builder.setContextual(z4);
        }

        public static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    public static class h {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z4) {
            return builder.setAuthenticationRequired(z4);
        }

        public static Notification.Builder b(Notification.Builder builder, int i4) {
            return builder.setForegroundServiceBehavior(i4);
        }
    }

    public n(k.e eVar) {
        int i4;
        this.f15489c = eVar;
        Context context = eVar.f15435a;
        this.f15487a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f15488b = e.a(context, eVar.f15424L);
        } else {
            this.f15488b = new Notification.Builder(eVar.f15435a);
        }
        Notification notification = eVar.f15431S;
        this.f15488b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f15443i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f15439e).setContentText(eVar.f15440f).setContentInfo(eVar.f15445k).setContentIntent(eVar.f15441g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f15442h, (notification.flags & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0).setNumber(eVar.f15446l).setProgress(eVar.f15455u, eVar.f15456v, eVar.f15457w);
        Notification.Builder builder = this.f15488b;
        IconCompat iconCompat = eVar.f15444j;
        c.b(builder, iconCompat == null ? null : iconCompat.v(context));
        this.f15488b.setSubText(eVar.f15452r).setUsesChronometer(eVar.f15449o).setPriority(eVar.f15447m);
        k.j jVar = eVar.f15451q;
        if (jVar instanceof k.f) {
            Iterator it = ((k.f) jVar).n().iterator();
            while (it.hasNext()) {
                b((k.a) it.next());
            }
        } else {
            Iterator it2 = eVar.f15436b.iterator();
            while (it2.hasNext()) {
                b((k.a) it2.next());
            }
        }
        Bundle bundle = eVar.f15417E;
        if (bundle != null) {
            this.f15493g.putAll(bundle);
        }
        int i5 = Build.VERSION.SDK_INT;
        this.f15490d = eVar.f15421I;
        this.f15491e = eVar.f15422J;
        this.f15488b.setShowWhen(eVar.f15448n);
        a.i(this.f15488b, eVar.f15413A);
        a.g(this.f15488b, eVar.f15458x);
        a.j(this.f15488b, eVar.f15460z);
        a.h(this.f15488b, eVar.f15459y);
        this.f15494h = eVar.f15428P;
        b.b(this.f15488b, eVar.f15416D);
        b.c(this.f15488b, eVar.f15418F);
        b.f(this.f15488b, eVar.f15419G);
        b.d(this.f15488b, eVar.f15420H);
        b.e(this.f15488b, notification.sound, notification.audioAttributes);
        List listE = i5 < 28 ? e(g(eVar.f15437c), eVar.f15434V) : eVar.f15434V;
        if (listE != null && !listE.isEmpty()) {
            Iterator it3 = listE.iterator();
            while (it3.hasNext()) {
                b.a(this.f15488b, (String) it3.next());
            }
        }
        this.f15495i = eVar.f15423K;
        if (eVar.f15438d.size() > 0) {
            Bundle bundle2 = eVar.e().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i6 = 0; i6 < eVar.f15438d.size(); i6++) {
                bundle4.putBundle(Integer.toString(i6), o.a((k.a) eVar.f15438d.get(i6)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            eVar.e().putBundle("android.car.EXTENSIONS", bundle2);
            this.f15493g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i7 = Build.VERSION.SDK_INT;
        Object obj = eVar.f15433U;
        if (obj != null) {
            c.c(this.f15488b, obj);
        }
        this.f15488b.setExtras(eVar.f15417E);
        d.e(this.f15488b, eVar.f15454t);
        RemoteViews remoteViews = eVar.f15421I;
        if (remoteViews != null) {
            d.c(this.f15488b, remoteViews);
        }
        RemoteViews remoteViews2 = eVar.f15422J;
        if (remoteViews2 != null) {
            d.b(this.f15488b, remoteViews2);
        }
        RemoteViews remoteViews3 = eVar.f15423K;
        if (remoteViews3 != null) {
            d.d(this.f15488b, remoteViews3);
        }
        if (i7 >= 26) {
            e.b(this.f15488b, eVar.f15425M);
            e.e(this.f15488b, eVar.f15453s);
            e.f(this.f15488b, eVar.f15426N);
            e.g(this.f15488b, eVar.f15427O);
            e.d(this.f15488b, eVar.f15428P);
            if (eVar.f15415C) {
                e.c(this.f15488b, eVar.f15414B);
            }
            if (!TextUtils.isEmpty(eVar.f15424L)) {
                this.f15488b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i7 >= 28) {
            Iterator it4 = eVar.f15437c.iterator();
            while (it4.hasNext()) {
                f.a(this.f15488b, ((t) it4.next()).j());
            }
        }
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            g.a(this.f15488b, eVar.f15430R);
            g.b(this.f15488b, k.d.a(null));
        }
        if (i8 >= 31 && (i4 = eVar.f15429Q) != 0) {
            h.b(this.f15488b, i4);
        }
        if (eVar.f15432T) {
            if (this.f15489c.f15459y) {
                this.f15494h = 2;
            } else {
                this.f15494h = 1;
            }
            this.f15488b.setVibrate(null);
            this.f15488b.setSound(null);
            int i9 = notification.defaults & (-4);
            notification.defaults = i9;
            this.f15488b.setDefaults(i9);
            if (i8 >= 26) {
                if (TextUtils.isEmpty(this.f15489c.f15458x)) {
                    a.g(this.f15488b, "silent");
                }
                e.d(this.f15488b, this.f15494h);
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
        C1854b c1854b = new C1854b(list.size() + list2.size());
        c1854b.addAll(list);
        c1854b.addAll(list2);
        return new ArrayList(c1854b);
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

    @Override // w.j
    public Notification.Builder a() {
        return this.f15488b;
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
        int i4 = Build.VERSION.SDK_INT;
        d.a(builderA, aVar.b());
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i4 >= 28) {
            f.b(builderA, aVar.f());
        }
        if (i4 >= 29) {
            g.c(builderA, aVar.j());
        }
        if (i4 >= 31) {
            h.a(builderA, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        a.b(builderA, bundle);
        a.a(this.f15488b, a.d(builderA));
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsK;
        RemoteViews remoteViewsI;
        k.j jVar = this.f15489c.f15451q;
        if (jVar != null) {
            jVar.b(this);
        }
        RemoteViews remoteViewsJ = jVar != null ? jVar.j(this) : null;
        Notification notificationD = d();
        if (remoteViewsJ != null) {
            notificationD.contentView = remoteViewsJ;
        } else {
            RemoteViews remoteViews = this.f15489c.f15421I;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (jVar != null && (remoteViewsI = jVar.i(this)) != null) {
            notificationD.bigContentView = remoteViewsI;
        }
        if (jVar != null && (remoteViewsK = this.f15489c.f15451q.k(this)) != null) {
            notificationD.headsUpContentView = remoteViewsK;
        }
        if (jVar != null && (bundleA = k.a(notificationD)) != null) {
            jVar.a(bundleA);
        }
        return notificationD;
    }

    public Notification d() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f15488b.build();
        }
        Notification notificationBuild = this.f15488b.build();
        if (this.f15494h != 0) {
            if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) != 0 && this.f15494h == 2) {
                h(notificationBuild);
            }
            if (a.f(notificationBuild) != null && (notificationBuild.flags & 512) == 0 && this.f15494h == 1) {
                h(notificationBuild);
            }
        }
        return notificationBuild;
    }

    public Context f() {
        return this.f15487a;
    }

    public final void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }
}

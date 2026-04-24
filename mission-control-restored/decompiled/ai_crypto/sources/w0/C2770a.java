package w0;

import F.j;
import F.k;
import android.app.Notification;
import android.media.session.MediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;

/* JADX INFO: renamed from: w0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2770a extends k.j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f24939e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaSessionCompat.Token f24940f;

    @Override // F.k.j
    public void b(j jVar) {
        jVar.a().setStyle(n(new Notification.MediaStyle()));
    }

    @Override // F.k.j
    public RemoteViews i(j jVar) {
        return null;
    }

    @Override // F.k.j
    public RemoteViews j(j jVar) {
        return null;
    }

    public Notification.MediaStyle n(Notification.MediaStyle mediaStyle) {
        int[] iArr = this.f24939e;
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        MediaSessionCompat.Token token = this.f24940f;
        if (token != null) {
            mediaStyle.setMediaSession((MediaSession.Token) token.a());
        }
        return mediaStyle;
    }
}
